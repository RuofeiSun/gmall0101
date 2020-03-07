package com.sunruofei.gmall.cart.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunruofei.gmall.bean.OmsCartItem;
import com.sunruofei.gmall.cart.mapper.OmsCartItemMapper;
import com.sunruofei.gmall.service.OmsCartItemService;
import com.sunruofei.gmall.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Service
public class OmsCartItemServiceImpl extends ServiceImpl<OmsCartItemMapper, OmsCartItem> implements OmsCartItemService {


    @Autowired
    RedisUtil redisUtil;

    @Autowired
    OmsCartItemMapper omsCartItemMapper;

    /**
     * 根据用户Id和产品skuid判断购物车是否添加过该产品
     * @param memberId
     * @param skuId
     * @return
     */
    @Override
    public OmsCartItem ifCartExistByUser(String memberId, String skuId) {

        QueryWrapper<OmsCartItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("member_id",memberId);
        queryWrapper.eq("product_sku_id",skuId);

        return omsCartItemMapper.selectOne(queryWrapper);
    }

    /**
     * 添加到购物车
     * @param omsCartItem
     */
    @Override
    public void addCart(OmsCartItem omsCartItem) {
        System.out.println(omsCartItem.getQuantity());
        if (StringUtils.isNotBlank(omsCartItem.getMemberId())) {
            omsCartItemMapper.insert(omsCartItem);//避免添加空值
        }
    }

    /**
     * 更新购物车
     * @param omsCartItemFromDb
     */
    @Override
    public void updateCart(OmsCartItem omsCartItemFromDb) {

        omsCartItemMapper.updateById(omsCartItemFromDb);
    }

    /**
     * 刷新购物车缓存
     * @param memberId
     */
    @Override
    public void flushCartCache(String memberId) {

        QueryWrapper<OmsCartItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("member_id",memberId);
        List<OmsCartItem> omsCartItems = omsCartItemMapper.selectList(queryWrapper);

        // 同步到redis缓存中
        Jedis jedis = redisUtil.getJedis();

        Map<String,String> map = new HashMap<>();
        for (OmsCartItem cartItem : omsCartItems) {
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getQuantity())));
            map.put(cartItem.getProductSkuId(), JSON.toJSONString(cartItem));
        }

        //hmset如果key存在仍然会存不会覆盖；
        jedis.del("user:"+memberId+":cart");
        jedis.hmset("user:"+memberId+":cart",map);

        jedis.close();
    }

    @Override
    public List<OmsCartItem> cartList(String memberId) {
        Jedis jedis = null;
        List<OmsCartItem> omsCartItems = new ArrayList<>();
        try {
            jedis = redisUtil.getJedis();

            List<String> hvals = jedis.hvals("user:" + memberId + ":cart");

            for (String hval : hvals) {
                OmsCartItem omsCartItem = JSON.parseObject(hval, OmsCartItem.class);
                omsCartItems.add(omsCartItem);
            }

        }catch (Exception e){
            // 处理异常，记录系统日志
            e.printStackTrace();
            //String message = e.getMessage();
            //logService.addErrLog(message);
            return null;
        }finally {
            jedis.close();
        }

        return omsCartItems;
    }

    @Override
    public void checkCart(OmsCartItem omsCartItem) {

/*        Example e = new Example(OmsCartItem.class);

        e.createCriteria().andEqualTo("memberId",omsCartItem.getMemberId()).andEqualTo("productSkuId",omsCartItem.getProductSkuId());
        omsCartItemMapper.updateByExampleSelective(omsCartItem,e);*/
        omsCartItemMapper.updateById(omsCartItem);

        // 缓存同步
        flushCartCache(omsCartItem.getMemberId());
    }
}
