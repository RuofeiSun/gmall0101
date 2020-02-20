package com.sunruofei.gmall.service;

import com.sunruofei.gmall.bean.PmsProductInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sunruofei.gmall.bean.PmsProductSaleAttr;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
public interface PmsProductInfoService extends IService<PmsProductInfo> {

    /**
     * 根据三级ID获取spu
     *
     * @param catalog3Id
     * @return
     */
    List<PmsProductInfo> getPmsProductInfoListByCatalog3Id(String catalog3Id);

    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    /**
     * 根据skuId获取相应的商品销售属性
     * @param productId
     * @param skuId
     * @return
     */
    public List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(String productId, String skuId);
}
