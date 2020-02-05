package com.sunruofei.gmall.service;

import com.sunruofei.gmall.bean.PmsBaseAttrInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 属性表 服务类
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
public interface PmsBaseAttrInfoService extends IService<PmsBaseAttrInfo> {

    /**
     * 根据三级id获取属性值
     *
     * @param catalog3Id
     * @return
     */
    List<PmsBaseAttrInfo> getAttrInfoBycatalog3Id(String catalog3Id);

    /**
     * 保存属性及属性值
     *
     * @param pmsBaseAttrInfo
     * @return
     */
    String saveAttr(PmsBaseAttrInfo pmsBaseAttrInfo);
}
