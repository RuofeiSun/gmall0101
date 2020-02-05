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
 * 产品评价回复表
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PmsCommentReplay extends Model<PmsCommentReplay> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    private String commentId;

    private String memberNickName;

    private String memberIcon;

    private String content;

    private String createTime;

    /**
     * 评论人员类型；0->会员；1->管理员
     */
    private String type;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
