package com.sunruofei.gmall.user.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sunruofei.gmall.bean.UmsMemberReceiveAddress;
import com.sunruofei.gmall.service.UmsMemberReceiveAddressService;
import com.sunruofei.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

/**
 * <p>
 * 会员收货地址表 服务实现类
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */

@Service
public class UmsMemberReceiveAddressServiceImpl extends ServiceImpl<UmsMemberReceiveAddressMapper, UmsMemberReceiveAddress> implements UmsMemberReceiveAddressService {

    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
        QueryWrapper<UmsMemberReceiveAddress> qw = new QueryWrapper<>();
        qw.eq("member_id", memberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddressList = umsMemberReceiveAddressMapper.selectList(qw);
        return umsMemberReceiveAddressList;
    }

}
