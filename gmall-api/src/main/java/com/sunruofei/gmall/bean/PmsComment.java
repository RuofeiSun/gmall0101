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
 * 商品评价表
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PmsComment extends Model<PmsComment> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    private String productId;

    private String memberNickName;

    private String productName;

    /**
     * 评价星数：0->5
     */
    private String star;

    /**
     * 评价的ip
     */
    private String memberIp;

    private String createTime;

    private String showStatus;

    /**
     * 购买时的商品属性
     */
    private String productAttribute;

    private String collectCouont;

    private String readCount;

    private String content;

    /**
     * 上传图片地址，以逗号隔开
     */
    private String pics;

    /**
     * 评论用户头像
     */
    private String memberIcon;

    private String replayCount;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
