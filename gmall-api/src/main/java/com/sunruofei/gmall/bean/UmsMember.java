package com.sunruofei.gmall.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 会员表
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UmsMember extends Model<UmsMember> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    private String memberLevelId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 帐号启用状态:0->禁用；1->启用
     */
    private String status;

    /**
     * 注册时间
     */
    private String createTime;

    /**
     * 头像
     */
    private String icon;

    /**
     * 性别：0->未知；1->男；2->女
     */
    private String gender;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 所做城市
     */
    private String city;

    /**
     * 职业
     */
    private String job;

    /**
     * 个性签名
     */
    private String personalizedSignature;

    /**
     * 用户来源
     */
    private String sourceType;

    /**
     * 积分
     */
    private String integration;

    /**
     * 成长值
     */
    private String growth;

    /**
     * 剩余抽奖次数
     */
    private String luckeyCount;

    /**
     * 历史积分数量
     */
    private String historyIntegration;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
