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
 * 会员等级表
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UmsMemberLevel extends Model<UmsMemberLevel> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    private String name;

    private String growthPoint;

    /**
     * 是否为默认等级：0->不是；1->是
     */
    private String defaultStatus;

    /**
     * 免运费标准
     */
    private String freeFreightPoint;

    /**
     * 每次评价获取的成长值
     */
    private String commentGrowthPoint;

    /**
     * 是否有免邮特权
     */
    private String priviledgeFreeFreight;

    /**
     * 是否有签到特权
     */
    private String priviledgeSignIn;

    /**
     * 是否有评论获奖励特权
     */
    private String priviledgeComment;

    /**
     * 是否有专享活动特权
     */
    private String priviledgePromotion;

    /**
     * 是否有会员价格特权
     */
    private String priviledgeMemberPrice;

    /**
     * 是否有生日特权
     */
    private String priviledgeBirthday;

    private String note;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
