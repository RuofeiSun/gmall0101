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
 *
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WmsWareOrderTaskDetail extends Model<WmsWareOrderTaskDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * sku_id
     */
    private String skuId;

    /**
     * sku名称
     */
    private String skuName;

    /**
     * 购买个数
     */
    private String skuNums;

    /**
     * 工作单编号
     */
    private String taskId;

    private String skuNum;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
