package com.sunruofei.gmall.bean;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.List;

public class PmsSearchParam extends Model<PmsSearchParam> {

    private String catalog3Id;

    private String keyword;

    private List<PmsSkuAttrValue> skuAttrValueList;

    public String getCatalog3Id() {
        return catalog3Id;
    }

    public void setCatalog3Id(String catalog3Id) {
        this.catalog3Id = catalog3Id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<PmsSkuAttrValue> getSkuAttrValueList() {
        return skuAttrValueList;
    }

    public void setSkuAttrValueList(List<PmsSkuAttrValue> skuAttrValueList) {
        this.skuAttrValueList = skuAttrValueList;
    }
}
