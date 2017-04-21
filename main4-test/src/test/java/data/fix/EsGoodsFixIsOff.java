package data.fix;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.searchtool.configs.ElasticConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by wxc on 2017/4/7.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ac.xml")
public class EsGoodsFixIsOff {
    private static final Logger logger = getLogger(EsGoodsFixIsOff.class);
    @Autowired
    private ShiguShopMapper shiguShopMapper;
    public void fix(Long shopId) {

        // 更新es数据
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("goods");
        srb.setSize(5000);
        BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();
        QueryBuilder queryBuilder = QueryBuilders.termQuery("storeId" ,shopId);
        boleanQueryBuilder.must(queryBuilder);
        QueryBuilder queryBuilderIsOff = QueryBuilders.termQuery("is_off" ,0);
        boleanQueryBuilder.must(queryBuilderIsOff);
        srb.setQuery(boleanQueryBuilder);
        SearchResponse response = srb.execute().actionGet();
        SearchHit[] hits = response.getHits().getHits();
        if(hits == null || hits.length == 0){
            return;
        }
        // 批量更新
        Client client = ElasticConfiguration.client;
        BulkRequestBuilder bulkRequest = client.prepareBulk();

        for (SearchHit hit : hits) {
            if (hit == null) {
                continue;
            }
            Map<String ,Object> source = hit.getSource();
            if (source == null || source.isEmpty() || source.get("is_off") == null
                    || (int)source.get("is_off") == 1) {
                continue;
            }
            source.put("is_off", 1);
            bulkRequest.add(client.prepareIndex("goods"
                    , hit.getType()
                    , hit.getId()).setSource(JSON.toJSONStringWithDateFormat(source, "yyyy-MM-dd HH:mm:ss")));
        }
        try {
            if (bulkRequest.numberOfActions() > 0)
                bulkRequest.execute().actionGet();
        } catch (Exception e) {
            logger.error("更新商品es数据关闭状态为1>>发生异常>>批量更新es数据>>error:" + e.toString());
            e.printStackTrace();
        }
    }

    @Test
    public void findShop() throws InterruptedException {
        ShiguShop shiguShop = new ShiguShop();
        shiguShop.setWebSite("hz");
        shiguShop.setShopStatus(1);
        List<ShiguShop> select = shiguShopMapper.select(shiguShop);
        System.out.println(select.size());
        for (int i = 0; i < select.size(); i++) {
            if (i < 4638) {
                continue;
            }
            ShiguShop shop = select.get(i);
            logger.info(i+1+"-"+shop.getShopName());
            fix(shop.getShopId());
            Thread.sleep(1500);
        }
    }

    @Test
    public void downOne() {
        fix(39689L);
    }
}
