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
 * 库存工作单表 库存工作单表
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WmsWareOrderTask extends Model<WmsWareOrderTask> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 订单编号
     */
    private String orderId;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 收货人电话
     */
    private String consigneeTel;

    /**
     * 送货地址
     */
    private String deliveryAddress;

    /**
     * 订单备注
     */
    private String orderComment;

    /**
     * 付款方式 1:在线付款 2:货到付款
     */
    private String paymentWay;

    private String taskStatus;

    /**
     * 订单描述
     */
    private String orderBody;

    /**
     * 物流单号
     */
    private String trackingNo;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 仓库编号
     */
    private String wareId;

    /**
     * 工作单备注
     */
    private String taskComment;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
