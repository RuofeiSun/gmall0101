package com.sunruofei.gmall.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sunruofei.gmall.bean.PmsBaseAttrInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 属性表 Mapper 接口
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
public interface PmsBaseAttrInfoMapper extends BaseMapper<PmsBaseAttrInfo> {

    List<PmsBaseAttrInfo> selectAttrValueListByValueId(@Param("valueIdStr") String valueIdStr);

}
