package com.shigu.main4.test.es;

import com.searchtool.configs.ElasticConfiguration;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortOrder;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by zhaohongbo on 17/3/13.
 */
public class EsBulkDataApi {

    public static void main(String[] args) throws UnknownHostException {
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

        int i=1;
        //scroll to get the data
        int from=0;
        int size=500;
        Long goodsId=61294L;
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
            System.out.println(id+" ========================");
            from+=size;
            // when there is no data,break the loop
            if (searchResponse.getHits().getHits().length == 0) {
                break;
            }

        }
    }
}
