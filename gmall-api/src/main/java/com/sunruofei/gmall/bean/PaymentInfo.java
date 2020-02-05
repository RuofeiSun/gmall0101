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
 * 支付信息表
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PaymentInfo extends Model<PaymentInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 对外业务编号
     */
    private String orderSn;

    /**
     * 订单编号
     */
    private String orderId;

    /**
     * 支付宝交易编号
     */
    private String alipayTradeNo;

    /**
     * 支付金额
     */
    private String totalAmount;

    /**
     * 交易内容
     */
    private String subject;

    /**
     * 支付状态
     */
    private String paymentStatus;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 创建时间
     */
    private String confirmTime;

    /**
     * 回调信息
     */
    private String callbackContent;

    private String callbackTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
