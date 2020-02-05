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
 *
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PmsBaseCatalog3 extends Model<PmsBaseCatalog3> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 三级分类名称
     */
    private String name;

    /**
     * 二级分类编号
     */
    private String catalog2Id;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
