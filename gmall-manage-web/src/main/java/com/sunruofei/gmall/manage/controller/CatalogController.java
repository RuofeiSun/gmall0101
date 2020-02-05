package com.sunruofei.gmall.manage.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.sunruofei.gmall.bean.PmsBaseCatalog1;
import com.sunruofei.gmall.bean.PmsBaseCatalog2;
import com.sunruofei.gmall.bean.PmsBaseCatalog3;
import com.sunruofei.gmall.service.PmsBaseCatalog1Service;
import com.sunruofei.gmall.service.PmsBaseCatalog2Service;
import com.sunruofei.gmall.service.PmsBaseCatalog3Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class CatalogController {

    @Reference
    private PmsBaseCatalog1Service pmsBaseCatalog1Service;

    @Reference
    private PmsBaseCatalog2Service pmsBaseCatalog2Service;

    @Reference
    private PmsBaseCatalog3Service pmsBaseCatalog3Service;

    /**
     * 二级菜单
     *
     * @return
     */
    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {

        return pmsBaseCatalog3Service.getPmsBaseCatalog3ByCatalog2Id(catalog2Id);
    }

    /**
     * 二级菜单
     *
     * @return
     */
    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {

        return pmsBaseCatalog2Service.getPmsBaseCatalog2ByCatalog1Id(catalog1Id);
    }

    /**
     * 一级菜单
     *
     * @return
     */
    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1() {

        List<PmsBaseCatalog1> list = pmsBaseCatalog1Service.list();

        return list;
    }

}
