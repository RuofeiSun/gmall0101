package com.sunruofei.gmall.service;

import com.sunruofei.gmall.bean.PmsProductImage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品图片表 服务类
 * </p>
 *
 * @author sunruofei
 * @since 2020-01-07
 */
public interface PmsProductImageService extends IService<PmsProductImage> {

    List<PmsProductImage> getPmsProductImageBySpuId(String spuId);
}
