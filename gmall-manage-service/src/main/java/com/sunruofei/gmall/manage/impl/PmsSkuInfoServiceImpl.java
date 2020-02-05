package com.sunruofei.gmall.manage.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunruofei.gmall.bean.PmsSkuAttrValue;
import com.sunruofei.gmall.bean.PmsSkuImage;
import com.sunruofei.gmall.bean.PmsSkuInfo;
import com.sunruofei.gmall.bean.PmsSkuSaleAttrValue;
import com.sunruofei.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.sunruofei.gmall.manage.mapper.PmsSkuImageMapper;
import com.sunruofei.gmall.manage.mapper.PmsSkuInfoMapper;
import com.sunruofei.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.sunruofei.gmall.service.PmsSkuInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 库存单元表 服务实现类
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Service
public class PmsSkuInfoServiceImpl extends ServiceImpl<PmsSkuInfoMapper, PmsSkuInfo> implements PmsSkuInfoService {

    @Autowired
    PmsSkuInfoMapper pmsSkuInfoMapper;

    @Autowired
    PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Autowired
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Autowired
    PmsSkuImageMapper pmsSkuImageMapper;

    @Override
    public void pmsSkuInfo(PmsSkuInfo pmsSkuInfo) {
        // 插入skuInfo
        int i = pmsSkuInfoMapper.insert(pmsSkuInfo);
        String skuId = pmsSkuInfo.getId();

        // 插入平台属性关联
        List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {
            pmsSkuAttrValue.setSkuId(skuId);
            pmsSkuAttrValueMapper.insert(pmsSkuAttrValue);
        }

        // 插入销售属性关联
        List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
            pmsSkuSaleAttrValue.setSkuId(skuId);
            pmsSkuSaleAttrValueMapper.insert(pmsSkuSaleAttrValue);
        }

        // 插入图片信息
        List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImagesList();
        for (PmsSkuImage pmsSkuImage : skuImageList) {
            pmsSkuImage.setSkuId(skuId);
            pmsSkuImageMapper.insert(pmsSkuImage);
        }

    }
}
