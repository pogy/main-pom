package data;


import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.searchtool.configs.ElasticConfiguration;
import com.searchtool.mappers.ElasticRepository;
import com.shigu.main4.tools.RedisIO;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 商品
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/ac.xml")
public class ShiguGoodsupTest {


    @Autowired
    private MemberUserSubMapper memberUserSubMapper;

    @Autowired
    RedisIO redisIO;


    /**
     * 批量更新shigugoodsup userId(一)
     * 先查出数据库的子账号 在循环子账号 批量更新ES
     *
     */
    @Test
    public void esAddUserIdPI() {
        Long userId = 1000000808L;// 可不传
        int pageNo = 1;
        int pageSize = 10;
        int startRows = (pageNo - 1) * 10;
        List<MemberUserSub> memberUserSubList = memberUserSubMapper.selectUserSubListByUserName(userId, startRows, pageSize);
        System.out.println("查询到的用户子账户：" + JSON.toJSONString(memberUserSubList));
        Iterator<MemberUserSub> memberUserSubIterator = memberUserSubList.iterator();
        if (memberUserSubIterator == null) {
            return;
        }
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
        while (memberUserSubIterator.hasNext()) {
            MemberUserSub memberUserSub = memberUserSubIterator.next();
            if (memberUserSub == null) {
                memberUserSub = new MemberUserSub();
                memberUserSub.setUserId(-1L);
                continue;
            }
            String userName = memberUserSub.getSubUserName();
            if (StringUtils.isEmpty(userName)) {
                continue;
            }
            TermQueryBuilder query = QueryBuilders.termQuery("fenUserNick", userName);
            srb.setQuery(query);
            srb.setSize(5000);
            SearchResponse response = srb.execute().actionGet();
            SearchHit[] hits = response.getHits().getHits();
            updatePi(hits,memberUserSub.getUserId());
        }
    }

    /**
     * 批量更新ES
     * @param hits
     * @param userId
     */
    public void updatePi(SearchHit[] hits,Long userId){
        if (hits == null || hits.length == 0) {
            return;
        }

        System.out.println("es需要更新数据：" + hits.length);

        ElasticRepository elasticRepository = new ElasticRepository();
        Client client = ElasticConfiguration.client;
        BulkRequestBuilder bulkRequest = client.prepareBulk();

        for (SearchHit hit : hits) {
            if (hit == null) {
                continue;
            }
            String source = hit.getSourceAsString();
            if (StringUtils.isEmpty(source)) {
                continue;
            }

            Map<String ,Object> shiguGoodsUpMap = JSON.parseObject(source, Map.class);
            Object websiteObject = shiguGoodsUpMap.get("webSite");
            if(websiteObject!=null && websiteObject.toString().equals("cs")){
                System.out.println(JSON.toJSONString(shiguGoodsUpMap));
            }

            if (shiguGoodsUpMap == null) {
                continue;
            }

            shiguGoodsUpMap.put("userId", userId);

            source = JSON.toJSONString(shiguGoodsUpMap);

            bulkRequest.add(client.prepareIndex("shigugoodsup"
                    , hit.getType()
                    , hit.getId())
                    .setSource(source));
        }
        try {
            bulkRequest.execute().actionGet();
            System.out.println("更新成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量更新shigugoodsup userId(二)
     * 根据nick查出用户信息 根据nick查询es批量更新userId
     *
     */
    @Test
    public void goodsupNickToUserId(){
        String nick = "lyszhen3";
        MemberUserSub memberUserSub = new MemberUserSub();
        memberUserSub.setSubUserName(nick);
        List<MemberUserSub> memberUserSubList = memberUserSubMapper.select(memberUserSub);
        if(memberUserSubList == null || memberUserSubList.size() == 0){
            memberUserSub = new MemberUserSub();
            memberUserSub.setUserId(-1L);
            return;
        }else{
            memberUserSub = memberUserSubList.get(0);
        }

        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
        TermQueryBuilder query = QueryBuilders.termQuery("fenUserNick", nick);
        srb.setQuery(query);
        srb.setSize(5000);
        SearchResponse response = srb.execute().actionGet();
        SearchHit[] hits = response.getHits().getHits();
        updatePi(hits,memberUserSub.getUserId());
    }


}
