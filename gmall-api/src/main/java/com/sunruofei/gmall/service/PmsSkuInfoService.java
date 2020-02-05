package com.sunruofei.gmall.service;

import com.sunruofei.gmall.bean.PmsSkuInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 库存单元表 服务类
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
public interface PmsSkuInfoService extends IService<PmsSkuInfo> {

    void pmsSkuInfo(PmsSkuInfo pmsSkuInfo);
}
