package com.sunruofei.gmall.manage.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunruofei.gmall.bean.PmsBaseAttrInfo;
import com.sunruofei.gmall.bean.PmsBaseAttrValue;
import com.sunruofei.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.sunruofei.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.sunruofei.gmall.service.PmsBaseAttrInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 属性表 服务实现类
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Service
public class PmsBaseAttrInfoServiceImpl extends ServiceImpl<PmsBaseAttrInfoMapper, PmsBaseAttrInfo> implements PmsBaseAttrInfoService {

    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    /**
     * 根据三级ID获取属性值
     *
     * @param catalog3Id
     * @return
     */
    @Override
    public List<PmsBaseAttrInfo> getAttrInfoBycatalog3Id(String catalog3Id) {

        QueryWrapper<PmsBaseAttrInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("catalog3_id", catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMapper.selectList(wrapper);

        for (PmsBaseAttrInfo pmsBaseAttrInfo : pmsBaseAttrInfos) {
            QueryWrapper<PmsBaseAttrValue> valueWrapper = new QueryWrapper<>();
            valueWrapper.eq("attr_id", pmsBaseAttrInfo.getId());
            List<PmsBaseAttrValue> pmsBaseAttrValues = pmsBaseAttrValueMapper.selectList(valueWrapper);
            pmsBaseAttrInfo.setAttrValueList(pmsBaseAttrValues);
        }

        return pmsBaseAttrInfos;
    }

    @Override
    public String saveAttr(PmsBaseAttrInfo pmsBaseAttrInfo) {

        //如果没有Id则是新增，否则修改
        if (StringUtils.isEmpty(pmsBaseAttrInfo.getId())) {

            //先插入属性，获取属性Id
            pmsBaseAttrInfoMapper.insert(pmsBaseAttrInfo);

            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();

            //先插入属性值明细，补上属性Id
            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                pmsBaseAttrValueMapper.insert(pmsBaseAttrValue);

            }
        } else {
            //修改属性
            pmsBaseAttrInfoMapper.updateById(pmsBaseAttrInfo);

            //修改属性值(先删后添加)
            UpdateWrapper<PmsBaseAttrValue> deleteWrapper = new UpdateWrapper<>();
            deleteWrapper.eq("attr_id", pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMapper.delete(deleteWrapper);

            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();

            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {

                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                pmsBaseAttrValueMapper.insert(pmsBaseAttrValue);

            }


        }


        return "success";
    }

    @Override
    public List<PmsBaseAttrInfo> getAttrValueListByValueId(Set<String> valueIdSet) {
        String valueIdStr = StringUtils.join(valueIdSet, ",");//41,45,46
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMapper.selectAttrValueListByValueId(valueIdStr);
        return pmsBaseAttrInfos;
    }
}
