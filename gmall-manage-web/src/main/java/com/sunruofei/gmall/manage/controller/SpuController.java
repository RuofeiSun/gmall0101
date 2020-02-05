package com.sunruofei.gmall.manage.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.sunruofei.gmall.bean.PmsProductImage;
import com.sunruofei.gmall.bean.PmsProductInfo;
import com.sunruofei.gmall.bean.PmsProductSaleAttr;
import com.sunruofei.gmall.manage.util.PmsUploadUtil;
import com.sunruofei.gmall.service.PmsProductImageService;
import com.sunruofei.gmall.service.PmsProductInfoService;
import com.sunruofei.gmall.service.PmsProductSaleAttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@CrossOrigin
public class SpuController {

    @Reference
    PmsProductInfoService pmsProductInfoService;

    @Reference
    PmsProductSaleAttrService pmsProductSaleAttrService;

    @Reference
    PmsProductImageService pmsProductImageService;

    /**
     * 获取spu图片列表
     *
     * @param spuId
     * @return
     */
    @RequestMapping("spuImageList")
    @ResponseBody
    public List<PmsProductImage> spuImageList(@RequestParam("spuId") String spuId) {

        return pmsProductImageService.getPmsProductImageBySpuId(spuId);
    }

    /**
     * 获取本商品的销售属性相关数据
     *
     * @param spuId
     * @return
     */
    @RequestMapping("spuSaleAttrList")
    @ResponseBody
    public List<PmsProductSaleAttr> spuSaleAttrList(@RequestParam("spuId") String spuId) {

        return pmsProductSaleAttrService.spuSaleAttrList(spuId);
    }

    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile file) {
        String imgUrl = PmsUploadUtil.uploadImage(file);
        return imgUrl;
    }

    /**
     * 保存SPU信息
     *
     * @param PmsProductInfo
     * @return
     */
    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo PmsProductInfo) {
        pmsProductInfoService.saveSpuInfo(PmsProductInfo);
        return "success";
    }

    /**
     * 展示SPU列表
     *
     * @param catalog3Id
     * @return
     */
    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id) {
        return pmsProductInfoService.getPmsProductInfoListByCatalog3Id(catalog3Id);
    }

}
