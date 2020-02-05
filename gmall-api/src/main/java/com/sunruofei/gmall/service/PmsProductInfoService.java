package com.sunruofei.gmall.service;

import com.sunruofei.gmall.bean.PmsProductInfo;
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
public interface PmsProductInfoService extends IService<PmsProductInfo> {

    /**
     * 根据三级ID获取spu
     *
     * @param catalog3Id
     * @return
     */
    List<PmsProductInfo> getPmsProductInfoListByCatalog3Id(String catalog3Id);

    void saveSpuInfo(PmsProductInfo pmsProductInfo);
}
