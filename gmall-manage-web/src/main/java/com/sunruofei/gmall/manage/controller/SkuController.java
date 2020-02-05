package com.sunruofei.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sunruofei.gmall.bean.PmsSkuInfo;
import com.sunruofei.gmall.service.PmsSkuInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class SkuController {

    @Reference
    PmsSkuInfoService pmsSkuInfoService;

    @RequestMapping("saveSkuInfo")
    @ResponseBody
    public String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo) {
        pmsSkuInfoService.pmsSkuInfo(pmsSkuInfo);
        return "success";
    }


}
