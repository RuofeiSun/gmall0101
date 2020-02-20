package com.sunruofei.gmall.manage.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunruofei.gmall.bean.PmsBaseAttrValue;
import com.sunruofei.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.sunruofei.gmall.service.PmsBaseAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 属性值表 服务实现类
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Service
public class PmsBaseAttrValueServiceImpl extends ServiceImpl<PmsBaseAttrValueMapper, PmsBaseAttrValue> implements PmsBaseAttrValueService {

    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<PmsBaseAttrValue> getAttrValueListByAttrId(String attrId) {
        QueryWrapper<PmsBaseAttrValue> wrapper = new QueryWrapper<>();
        wrapper.eq("attr_id", attrId);
        return pmsBaseAttrValueMapper.selectList(wrapper);
    }
}
