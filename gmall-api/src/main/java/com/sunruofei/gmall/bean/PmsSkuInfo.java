package com.sunruofei.gmall.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 库存单元表
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PmsSkuInfo extends Model<PmsSkuInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 库存id(itemID)
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 商品id
     */
    private String productId;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * sku名称
     */
    private String skuName;

    /**
     * 商品规格描述
     */
    private String skuDesc;

    private String weight;

    /**
     * 品牌(冗余)
     */
    private String tmId;

    /**
     * 三级分类id（冗余)
     */
    private String catalog3Id;

    /**
     * 默认显示图片(冗余)
     */
    private String skuDefaultImg;

    /**
     * sku图片
     */
    @TableField(exist = false)
    private List<PmsSkuImage> skuImagesList;

    /**
     * sku平台属性值
     */
    @TableField(exist = false)
    private List<PmsSkuAttrValue> skuAttrValueList;

    /**
     * sku销售属性
     */
    @TableField(exist = false)
    private List<PmsSkuSaleAttrValue> skuSaleAttrValueList;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
