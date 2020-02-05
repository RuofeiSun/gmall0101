package com.sunruofei.gmall.manage.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunruofei.gmall.bean.PmsBaseCatalog3;
import com.sunruofei.gmall.manage.mapper.PmsBaseCatalog3Mapper;
import com.sunruofei.gmall.service.PmsBaseCatalog3Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Service
public class PmsBaseCatalog3ServiceImpl extends ServiceImpl<PmsBaseCatalog3Mapper, PmsBaseCatalog3> implements PmsBaseCatalog3Service {

    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    @Override
    public List<PmsBaseCatalog3> getPmsBaseCatalog3ByCatalog2Id(String catalog2Id) {
        QueryWrapper<PmsBaseCatalog3> wrapper = new QueryWrapper<>();
        wrapper.eq("catalog2_id", catalog2Id);
        return pmsBaseCatalog3Mapper.selectList(wrapper);

    }
}
