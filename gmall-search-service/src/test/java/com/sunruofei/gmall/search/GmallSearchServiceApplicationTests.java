package com.sunruofei.gmall.search;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sunruofei.gmall.bean.PmsSearchSkuInfo;
import com.sunruofei.gmall.bean.PmsSkuInfo;
import com.sunruofei.gmall.service.PmsSkuInfoService;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class GmallSearchServiceApplicationTests {

    @Reference
    PmsSkuInfoService skuService;// 查询mysql


    @Autowired
    JestClient jestClient;

    @Test
    void contextLoads() throws IOException {
        get();
        //put();

    }

    public void put() throws IOException {

        // 查询mysql数据
        List<PmsSkuInfo> pmsSkuInfoList = new ArrayList<>();

        pmsSkuInfoList = skuService.getAllSku("61");

        // 转化为es的数据结构
        List<PmsSearchSkuInfo> pmsSearchSkuInfos = new ArrayList<>();

        for (PmsSkuInfo pmsSkuInfo : pmsSkuInfoList) {
            PmsSearchSkuInfo pmsSearchSkuInfo = new PmsSearchSkuInfo();

            BeanUtils.copyProperties(pmsSkuInfo,pmsSearchSkuInfo);

            pmsSearchSkuInfo.setId(Long.parseLong(pmsSkuInfo.getId()));

            pmsSearchSkuInfos.add(pmsSearchSkuInfo);

        }

        // 导入es
        for (PmsSearchSkuInfo pmsSearchSkuInfo : pmsSearchSkuInfos) {
            Index put = new Index.Builder(pmsSearchSkuInfo).index("gmall0105").type("PmsSkuInfo").id(pmsSearchSkuInfo.getId()+"").build();
            jestClient.execute(put);
        }

    }

    public void get() throws IOException {

        // jest的dsl工具
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // bool
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        // filter
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("skuAttrValueList.valueId","48");
        boolQueryBuilder.filter(termQueryBuilder);
        // must
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("skuName","小米Note3");
        boolQueryBuilder.must(matchQueryBuilder);
        // query
        searchSourceBuilder.query(boolQueryBuilder);
        // from
        searchSourceBuilder.from(0);
        // size
        searchSourceBuilder.size(20);
        // highlight
        //searchSourceBuilder.highlight(null);

        String dslStr = searchSourceBuilder.toString();

        System.err.println(dslStr);


        // 用api执行复杂查询
        List<PmsSearchSkuInfo> pmsSearchSkuInfos = new ArrayList<>();

        Search search = new Search.Builder(dslStr).addIndex("gmall0105").addType("PmsSkuInfo").build();

        SearchResult execute = jestClient.execute(search);

        List<SearchResult.Hit<PmsSearchSkuInfo, Void>> hits = execute.getHits(PmsSearchSkuInfo.class);

        for (SearchResult.Hit<PmsSearchSkuInfo, Void> hit : hits) {
            PmsSearchSkuInfo source = hit.source;

            pmsSearchSkuInfos.add(source);
        }

        System.out.println(pmsSearchSkuInfos.size());
    }

}
