package com.sunruofei.gmall.service;

import com.sunruofei.gmall.bean.PmsBaseAttrValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 属性值表 服务类
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
public interface PmsBaseAttrValueService extends IService<PmsBaseAttrValue> {

    List<PmsBaseAttrValue> getAttrValueListByAttrId(String attrId);
}
