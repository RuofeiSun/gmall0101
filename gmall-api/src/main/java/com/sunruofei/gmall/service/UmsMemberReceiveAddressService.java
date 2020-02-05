package com.sunruofei.gmall.service;

import com.sunruofei.gmall.bean.UmsMemberReceiveAddress;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 会员收货地址表 服务类
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
public interface UmsMemberReceiveAddressService extends IService<UmsMemberReceiveAddress> {

    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);

}
