package com.shigu.main4.monitor.test;

import com.alibaba.fastjson.JSON;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguPageRecode;
import com.opentae.data.mall.beans.ShiguPropImgs;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.searchtool.configs.ElasticConfiguration;
import com.searchtool.domain.SimpleElaBean;
import com.searchtool.mappers.ElasticRepository;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.monitor.bo.PageInfoBO;
import com.shigu.main4.monitor.bo.ShiguPageRecodeBo;
import com.shigu.main4.monitor.service.ShiguPageRecodeService;
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
    private ShiguPageRecodeService shiguPageRecodeService;

    @Autowired
    private BrowerMonitorServiceImpl browerMonitorService;

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    public final String ELASTIC_PAGE_INDEX = "shigupagerecode";
    public final String TYPE = "page";

    @Test
    public void addEs(){
        System.out.println("读取商品链接------------------------------------");
        ShiguPageRecodeBo shiguPageRecodeBo = new ShiguPageRecodeBo();
        shiguPageRecodeBo.setId(51702342L);
        ShiguPageRecode shiguPageRecode = shiguPageRecodeService.findShiguPageRecode(shiguPageRecodeBo);
        BrowerRecordVo browerRecord = shiguPageRecodeService.getBrowerRecord(shiguPageRecode);
        if(browerRecord == null){
            System.out.println("browerRecord:"+ JSON.toJSONString(browerRecord));
            return;
        }

        PageInfoBO pageInfoBO = new PageInfoBO();
        pageInfoBO.setWebSite(browerRecord.getWebSite());
        pageInfoBO.setItemId(browerRecord.getItemId());
        pageInfoBO.setUrl(browerRecord.getUrl());
        pageInfoBO.setShopId(browerRecord.getShop());
        pageInfoBO.setReferer(browerRecord.getReferer());

        String idkeys = browerMonitorService.inPage(browerRecord.getType(), browerRecord.getUserId(), pageInfoBO, browerRecord.getClientMsg());
        System.out.println("idkeys:" + idkeys);
    }

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

    /**
     * 将shigu_page_recode 到入ES
     *  上次导入至
     * 2017.3.14 00:00:00
     */
    @Test
    public void dataTrans() throws Exception {

        for (int i = 0; i < 25; i++) {// 20个任务一起干。
            Thread thread = new Thread(new RecodeWriter(), "worker-" + i);
            thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();
        }

        ShiguPageRecodeBo bo = new ShiguPageRecodeBo();
        bo.setEndInTime(DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH));
        bo.setPageable(true);
        Integer step = 5000;
        bo.setPageSize(step);
        bo.setPageNo(1);
        int count = shiguPageRecodeService.countByBo(bo);
        int pages = (count - 1) / step + 1;
        System.out.println("page:" + pages);
        for (int i = 1; i <= pages; i++) {
            bo.setPageNo(i);
            queue.put(bo);
            bo = BeanMapper.map(bo, ShiguPageRecodeBo.class);//copy 出另一个对象
        }
        while (true) {
            int size = queue.size();
            System.out.println("队列剩余任务：" + size + ", 剩余" + (size * 100.0 / pages) + "%");
            Thread.sleep(5000);
        }
    }

    @Test
    public void testCache() {
        Long hz = shiguPageRecodeService.getShopIdByItemId(165791L, "hz");
        Long cache = shiguPageRecodeService.getShopIdByItemId(165791L, "hz");
        assert hz == cache;

    }

    private class RecodeWriter implements Runnable {
        @Override
        public void run() {
            ElasticRepository repository = new ElasticRepository();
            List<SimpleElaBean> sebs = new ArrayList<>();
            Client client = ElasticConfiguration.searchClient;
            while (true) {
                try {
                    for (ShiguPageRecode pageRecode : shiguPageRecodeService.findShiguPageRecodeListByBo(queue.take())) {
                        if (!client.prepareGet().setIndex("shigupagerecode").setFetchSource(false).setId(pageRecode.getId().toString()).execute().actionGet().isExists()) {
                            BrowerRecordVo record = shiguPageRecodeService.getBrowerRecord(pageRecode);
                            sebs.add(new SimpleElaBean("shigupagerecode", record.getType(), record.getKeyId(), JSON.toJSONStringWithDateFormat(record, "yyyy-MM-dd HH:mm:ss")));
                        } else break;
                    }
                    if (!sebs.isEmpty()) {
                        repository.insertList(sebs, 100);
                        sebs.clear();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

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
