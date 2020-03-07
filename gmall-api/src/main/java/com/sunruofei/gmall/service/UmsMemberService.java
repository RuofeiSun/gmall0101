package com.sunruofei.gmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sunruofei.gmall.bean.UmsMember;
import com.sunruofei.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
public interface UmsMemberService extends IService<UmsMember> {

    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);

    UmsMember login(UmsMember umsMember);

    void addUserToken(String token, String memberId);
}
