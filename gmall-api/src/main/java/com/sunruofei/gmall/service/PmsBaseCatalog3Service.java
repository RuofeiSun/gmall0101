package com.sunruofei.gmall.service;

import com.sunruofei.gmall.bean.PmsBaseCatalog3;
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
public interface PmsBaseCatalog3Service extends IService<PmsBaseCatalog3> {

    public List<PmsBaseCatalog3> getPmsBaseCatalog3ByCatalog2Id(String catalog2Id);

}
