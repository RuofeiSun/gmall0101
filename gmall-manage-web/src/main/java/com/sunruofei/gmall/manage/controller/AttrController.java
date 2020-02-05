package com.sunruofei.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sunruofei.gmall.bean.PmsBaseAttrInfo;
import com.sunruofei.gmall.bean.PmsBaseAttrValue;
import com.sunruofei.gmall.bean.PmsBaseSaleAttr;
import com.sunruofei.gmall.service.PmsBaseAttrInfoService;
import com.sunruofei.gmall.service.PmsBaseAttrValueService;
import com.sunruofei.gmall.service.PmsBaseSaleAttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class AttrController {

    @Reference
    PmsBaseAttrInfoService pmsBaseAttrInfoService;

    @Reference
    PmsBaseAttrValueService pmsBaseAttrValueService;

    @Reference
    PmsBaseSaleAttrService pmsBaseSaleAttrService;


    /**
     * 获取销售属性
     *
     * @return
     */
    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return pmsBaseSaleAttrService.list();
    }

    /**
     * 获取属性值
     *
     * @return
     */
    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        return pmsBaseAttrValueService.getAttrValueListByAttrId(attrId);
    }

    /**
     * 保存或修改属性
     *
     * @param pmsBaseAttrInfo
     * @return
     */
    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {

        return pmsBaseAttrInfoService.saveAttr(pmsBaseAttrInfo);
    }


    /**
     * 获取属性
     *
     * @return
     */
    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {

        return pmsBaseAttrInfoService.getAttrInfoBycatalog3Id(catalog3Id);
    }


}
