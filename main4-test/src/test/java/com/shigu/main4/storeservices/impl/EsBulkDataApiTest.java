package com.shigu.main4.storeservices.impl;

import com.opentae.data.mall.beans.ShiguGoodsIdGenerator;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by zhaohongbo on 17/3/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/ac.xml" )
public class EsBulkDataApiTest {
    @Autowired
    ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;
    @Test
    public void test() throws UnknownHostException {
        // establish the client
        String url = "122.224.105.246";
        String port = "9213";
        String fromIndex="goods_v2";
        String toIndex="goods_v4";
        String[] types={"hz","ss","cs","gz","jx","xh","bj"};

        Settings settings = Settings.settingsBuilder().put("cluster.name", "xz571-application").build();
        TransportClient client = TransportClient.builder().settings(settings).build();
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(url), Integer.valueOf(port).intValue()));


//        SearchResponse searchResponse = client.prepareSearch(fromIndex).addSort("goodsId", SortOrder.ASC)
//                .setTypes(types).setSearchType(SearchType.SCAN)
//                .setScroll(new TimeValue(60000)).setQuery(queryBuilder)
//                .setSize(500).execute().actionGet();

        ShiguGoodsIdGenerator sgig=new ShiguGoodsIdGenerator();
        sgig.setGoodId(2L);
        sgig=shiguGoodsIdGeneratorMapper.selectOne(sgig);
        int i=1;
        //scroll to get the data
        int from=0;
        int size=3000;
        Long goodsId=Long.valueOf(sgig.getRemark());
        while (true) {

            QueryBuilder queryBuilder = QueryBuilders.boolQuery().must(
                    QueryBuilders.rangeQuery("goodsId").gt(goodsId));
            SearchResponse searchResponse = client.prepareSearch(fromIndex).addSort("goodsId",SortOrder.ASC)
                    .setTypes(types).setQuery(queryBuilder).setFrom(from).setSize(size).execute().actionGet();

            BulkRequestBuilder bulkRequest = client.prepareBulk();
            String id="";
            for (SearchHit hit : searchResponse.getHits().getHits()) {
                // copy the data to the new index

//                client.prepareIndex(toIndex, hit.getType(), hit.getId())
//                        .setSource(hit.getSourceAsString()).execute().actionGet();

                bulkRequest.add(client.prepareIndex(toIndex, hit.getType(), hit.getId())
                        .setSource(hit.getSourceAsString()));
                id=hit.getId();
            }
            bulkRequest.execute().actionGet();
            i++;
            ShiguGoodsIdGenerator si=new ShiguGoodsIdGenerator();
            si.setGoodId(2L);
            si.setRemark(id);
            goodsId=Long.valueOf(id);
            shiguGoodsIdGeneratorMapper.updateByPrimaryKeySelective(si);
            System.out.println(id+" ========================");
            // when there is no data,break the loop
            if (searchResponse.getHits().getHits().length == 0) {
                break;
            }

        }
    }
}
