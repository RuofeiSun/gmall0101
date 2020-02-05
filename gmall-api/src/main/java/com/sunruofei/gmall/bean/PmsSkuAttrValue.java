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
 * sku平台属性值关联表
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PmsSkuAttrValue extends Model<PmsSkuAttrValue> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 属性id（冗余)
     */
    private String attrId;

    /**
     * 属性值id
     */
    private String valueId;

    /**
     * skuid
     */
    private String skuId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
