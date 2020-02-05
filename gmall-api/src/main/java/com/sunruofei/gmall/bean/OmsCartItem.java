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
 * 购物车表
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OmsCartItem extends Model<OmsCartItem> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    private String productId;

    private String productSkuId;

    private String memberId;

    /**
     * 购买数量
     */
    private String quantity;

    /**
     * 添加到购物车的价格
     */
    private String price;

    /**
     * 销售属性1
     */
    private String sp1;

    /**
     * 销售属性2
     */
    private String sp2;

    /**
     * 销售属性3
     */
    private String sp3;

    /**
     * 商品主图
     */
    private String productPic;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品副标题（卖点）
     */
    private String productSubTitle;

    /**
     * 商品sku条码
     */
    private String productSkuCode;

    /**
     * 会员昵称
     */
    private String memberNickname;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 修改时间
     */
    private String modifyDate;

    /**
     * 是否删除
     */
    private String deleteStatus;

    /**
     * 商品分类
     */
    private String productCategoryId;

    private String productBrand;

    private String productSn;

    /**
     * 商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     */
    private String productAttr;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
