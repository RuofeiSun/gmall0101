package com.sunruofei.gmall.service;

import com.sunruofei.gmall.bean.PmsBaseCatalog2;
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
public interface PmsBaseCatalog2Service extends IService<PmsBaseCatalog2> {

    /**
     * 获取二级菜单
     *
     * @param catalog1Id
     * @return
     */
    public List<PmsBaseCatalog2> getPmsBaseCatalog2ByCatalog1Id(String catalog1Id);

}
