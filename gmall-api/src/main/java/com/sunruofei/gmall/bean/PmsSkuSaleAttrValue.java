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
 * sku销售属性值
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PmsSkuSaleAttrValue extends Model<PmsSkuSaleAttrValue> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 库存单元id
     */
    private String skuId;

    /**
     * 销售属性id（冗余)
     */
    private String saleAttrId;

    /**
     * 销售属性值id
     */
    private String saleAttrValueId;

    /**
     * 销售属性名称(冗余)
     */
    private String saleAttrName;

    /**
     * 销售属性值名称(冗余)
     */
    private String saleAttrValueName;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
