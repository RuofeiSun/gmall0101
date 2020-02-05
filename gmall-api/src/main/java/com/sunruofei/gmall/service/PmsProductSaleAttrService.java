package com.sunruofei.gmall.service;

import com.sunruofei.gmall.bean.PmsProductSaleAttr;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
public interface PmsProductSaleAttrService extends IService<PmsProductSaleAttr> {

    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);
}
