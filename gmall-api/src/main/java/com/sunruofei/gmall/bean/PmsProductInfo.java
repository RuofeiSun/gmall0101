package com.sunruofei.gmall.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.List;

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
public class PmsProductInfo extends Model<PmsProductInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品描述(后台简述）
     */
    private String description;

    /**
     * 三级分类id
     */
    private String catalog3Id;

    /**
     * 品牌id
     */
    private String tmId;

    /**
     * spu图片list
     */
    @TableField(exist = false)
    private List<PmsProductImage> spuImageList;

    /**
     * spu销售属性list
     */
    @TableField(exist = false)
    private List<PmsProductSaleAttr> spuSaleAttrList;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
