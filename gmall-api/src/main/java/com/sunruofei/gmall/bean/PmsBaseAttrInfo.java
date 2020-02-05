package com.sunruofei.gmall.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 属性表
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PmsBaseAttrInfo extends Model<PmsBaseAttrInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 属性名称
     */
    private String attrName;

    private String catalog3Id;

    /**
     * 启用：1 停用：0
     */
    private String isEnabled;

    @TableField(exist = false)
    private List<PmsBaseAttrValue> AttrValueList;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
