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
 * 品牌表
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PmsBrand extends Model<PmsBrand> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    private String name;

    /**
     * 首字母
     */
    private String firstLetter;

    private String sort;

    /**
     * 是否为品牌制造商：0->不是；1->是
     */
    private String factoryStatus;

    private String showStatus;

    /**
     * 产品数量
     */
    private String productCount;

    /**
     * 产品评论数量
     */
    private String productCommentCount;

    /**
     * 品牌logo
     */
    private String logo;

    /**
     * 专区大图
     */
    private String bigPic;

    /**
     * 品牌故事
     */
    private String brandStory;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
