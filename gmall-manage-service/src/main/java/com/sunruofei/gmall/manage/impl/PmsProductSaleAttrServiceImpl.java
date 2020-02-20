package com.sunruofei.gmall.manage.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunruofei.gmall.bean.PmsProductSaleAttr;
import com.sunruofei.gmall.bean.PmsProductSaleAttrValue;
import com.sunruofei.gmall.manage.mapper.PmsProductSaleAttrMapper;
import com.sunruofei.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.sunruofei.gmall.service.PmsProductSaleAttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Service
public class PmsProductSaleAttrServiceImpl extends ServiceImpl<PmsProductSaleAttrMapper, PmsProductSaleAttr> implements PmsProductSaleAttrService {

    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {

        QueryWrapper<PmsProductSaleAttr> pmsProductSaleAttrQueryWrapper = new QueryWrapper<>();
        pmsProductSaleAttrQueryWrapper.eq("product_id", spuId);
        List<PmsProductSaleAttr> pmsProductSaleAttrs = pmsProductSaleAttrMapper.selectList(pmsProductSaleAttrQueryWrapper);
        for (PmsProductSaleAttr pmsProductSaleAttr : pmsProductSaleAttrs) {
            QueryWrapper<PmsProductSaleAttrValue> pmsProductSaleAttrValuerQueryWrapper = new QueryWrapper<>();
            pmsProductSaleAttrValuerQueryWrapper.eq("product_id", spuId).eq("sale_attr_id", pmsProductSaleAttr.getSaleAttrId());

            List<PmsProductSaleAttrValue> pmsProductSaleAttrValues = pmsProductSaleAttrValueMapper.selectList(pmsProductSaleAttrValuerQueryWrapper);
            pmsProductSaleAttr.setSpuSaleAttrValueList(pmsProductSaleAttrValues);
        }


        return pmsProductSaleAttrs;
    }
}
