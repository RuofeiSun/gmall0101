package com.sunruofei.gmall.manage.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunruofei.gmall.bean.PmsProductImage;
import com.sunruofei.gmall.manage.mapper.PmsProductImageMapper;
import com.sunruofei.gmall.service.PmsProductImageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * <p>
 * 商品图片表 服务实现类
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Service
public class PmsProductImageServiceImpl extends ServiceImpl<PmsProductImageMapper, PmsProductImage> implements PmsProductImageService {

    @Autowired
    PmsProductImageMapper pmsProductImageMapper;

    @Override
    public List<PmsProductImage> getPmsProductImageBySpuId(String spuId) {
        QueryWrapper<PmsProductImage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id", spuId);
        return pmsProductImageMapper.selectList(queryWrapper);
    }
}
