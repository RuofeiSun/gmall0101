package com.sunruofei.gmall.service;

import com.sunruofei.gmall.bean.PmsSearchParam;
import com.sunruofei.gmall.bean.PmsSearchSkuInfo;

import java.util.List;

public interface SearchService {
    List<PmsSearchSkuInfo> list(PmsSearchParam pmsSearchParam);
}
