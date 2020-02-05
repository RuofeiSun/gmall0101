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
 * spu销售属性值
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PmsProductSaleAttrValue extends Model<PmsProductSaleAttrValue> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 商品id
     */
    private String productId;

    /**
     * 销售属性id
     */
    private String saleAttrId;

    /**
     * 销售属性值名称
     */
    private String saleAttrValueName;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
