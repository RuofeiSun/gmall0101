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
 * 会员收货地址表
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UmsMemberReceiveAddress extends Model<UmsMemberReceiveAddress> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    private String memberId;

    /**
     * 收货人名称
     */
    private String name;

    private String phoneNumber;

    /**
     * 是否为默认
     */
    private String defaultStatus;

    /**
     * 邮政编码
     */
    private String postCode;

    /**
     * 省份/直辖市
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区
     */
    private String region;

    /**
     * 详细地址(街道)
     */
    private String detailAddress;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
