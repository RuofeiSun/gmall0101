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
public class WmsWareSku extends Model<WmsWareSku> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * skuid
     */
    private String skuId;

    /**
     * 仓库id
     */
    private String warehouseId;

    /**
     * 库存数
     */
    private String stock;

    /**
     * 存货名称
     */
    private String stockName;

    private String stockLocked;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
