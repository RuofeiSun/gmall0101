package com.sunruofei.gmall.manage.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunruofei.gmall.bean.PmsBaseCatalog2;
import com.sunruofei.gmall.manage.mapper.PmsBaseCatalog2Mapper;
import com.sunruofei.gmall.service.PmsBaseCatalog2Service;
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
public class PmsBaseCatalog2ServiceImpl extends ServiceImpl<PmsBaseCatalog2Mapper, PmsBaseCatalog2> implements PmsBaseCatalog2Service {

    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;

    @Override
    public List<PmsBaseCatalog2> getPmsBaseCatalog2ByCatalog1Id(String catalog1Id) {
        QueryWrapper<PmsBaseCatalog2> wrapper = new QueryWrapper<>();
        wrapper.eq("catalog1_id", catalog1Id);
        return pmsBaseCatalog2Mapper.selectList(wrapper);
    }
}
