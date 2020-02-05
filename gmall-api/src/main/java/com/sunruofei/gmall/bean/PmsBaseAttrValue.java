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
 * 属性值表
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PmsBaseAttrValue extends Model<PmsBaseAttrValue> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 属性值名称
     */
    private String valueName;

    /**
     * 属性id
     */
    private String attrId;

    /**
     * 启用：1 停用：0 1
     */
    private String isEnabled;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
