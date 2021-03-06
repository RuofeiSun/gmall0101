package com.sunruofei.gmall.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sunruofei.gmall.bean.PmsSkuInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 库存单元表 Mapper 接口
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
public interface PmsSkuInfoMapper extends BaseMapper<PmsSkuInfo> {

    List<PmsSkuInfo> selectSkuSaleAttrValueListBySpu(@Param("productId") String productId);
}
