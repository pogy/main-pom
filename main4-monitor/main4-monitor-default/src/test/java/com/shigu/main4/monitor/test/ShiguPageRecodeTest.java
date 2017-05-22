package com.shigu.main4.monitor.test;

import com.alibaba.fastjson.JSON;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguPropImgs;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.searchtool.configs.ElasticConfiguration;
import com.searchtool.domain.SimpleElaBean;
import com.searchtool.mappers.ElasticRepository;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.monitor.bo.PageInfoBO;
import com.shigu.main4.monitor.bo.ShiguPageRecodeBo;
import com.shigu.main4.monitor.service.impl.BrowerMonitorServiceImpl;
import com.shigu.main4.monitor.services.BrowerMonitorService;
import com.shigu.main4.monitor.vo.BrowerRecord;
import com.shigu.main4.monitor.vo.BrowerRecordVo;
import com.shigu.main4.monitor.vo.ClientMsg;
import org.apache.commons.lang3.time.DateUtils;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/spring/store_test.xml" )
public class ShiguPageRecodeTest {

    @Autowired
    private BrowerMonitorServiceImpl browerMonitorService;

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    public final String ELASTIC_PAGE_INDEX = "shigupagerecode";
    public final String TYPE = "page";

    @Test
    public void addShiguPage(){
        ClientMsg clientMsg = new ClientMsg();
        clientMsg.setClientOs("windows8");
        clientMsg.setClientBrower("ie1011");
        clientMsg.setClientBrowerVersion("10");
        clientMsg.setClientIp("192.168.1.1");
        String url = "http://hs.571xz.com/item.html?id=123465";
        Long userId = 10000808L;
        String type = "other";
        PageInfoBO pageInfoBO = new PageInfoBO();
        pageInfoBO.setConnectKey("123456798");
        pageInfoBO.setItemId(3131588L);
        pageInfoBO.setReferer("http://www.571xz.com/index.html");
        pageInfoBO.setShopId(32888L);
        pageInfoBO.setUrl(url);
        pageInfoBO.setWebSite("hz");
        String idkeys = browerMonitorService.inPage(type, userId, pageInfoBO, clientMsg);
        System.out.println(idkeys);
    }

    @Test
    public void outPage(){
        boolean pans =  browerMonitorService.outPage("45843589");
        System.out.println(pans);
    }

    @Bean
    public ElasticRepository elasticRepository() {
        return new ElasticRepository();
    }

    private LinkedBlockingQueue<ShiguPageRecodeBo> queue = new LinkedBlockingQueue<>();


    @Test
    public void deleteIndex() {
        SearchHit[] hits;
        ElasticRepository repository = new ElasticRepository();
        List<SimpleElaBean> sebs = new ArrayList<>();
        while (true) {
            SearchResponse response = ElasticConfiguration.searchClient.prepareSearch("shigupagerecode")
                    .setQuery(QueryBuilders.matchAllQuery()).setSize(5000).execute().actionGet();
            hits = response.getHits().hits();
            if (hits.length == 0)
                break;
            for (SearchHit hit : hits)
                sebs.add(new SimpleElaBean(hit.index(), hit.type(), hit.getId()));
            repository.deleteListByKey(sebs, 100);
            sebs.clear();
        }
    }

    @Test
    public void reindex() {
        SearchHit[] hits;
        ElasticRepository repository = new ElasticRepository();
        List<SimpleElaBean> sebs = new ArrayList<>();
        while (true) {
            SearchResponse response = ElasticConfiguration.searchClient.prepareSearch("shigupagerecode")
                    .setQuery(QueryBuilders.matchAllQuery()).setSize(5000).execute().actionGet();
            hits = response.getHits().hits();
            if (hits.length == 0)
                break;
            for (SearchHit hit : hits)
                sebs.add(new SimpleElaBean(hit.index(), hit.type(), hit.getId(), hit.getSourceAsString()));
            repository.deleteListByKey(sebs, 100);
            for (SimpleElaBean seb : sebs) {
                seb.setIndex("shigupagerecode");
            }
            repository.insertList(sebs, 100);
            sebs.clear();
        }
    }
}
