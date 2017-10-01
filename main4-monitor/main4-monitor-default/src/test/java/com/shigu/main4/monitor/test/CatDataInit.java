package com.shigu.main4.monitor.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguTaobaocat;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.examples.ShiguTaobaocatExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguTaobaocatMapper;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.monitor.vo.RankingCateLineVO;
import com.shigu.main4.tools.RedisIO;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 类名：CatDataInit
 * 类路径：com.shigu.main4.monitor.test.CatDataInit
 * 创建者：王浩翔
 * 创建时间：2017-10-01 9:27
 * 项目：main-pom
 * 描述：排行榜类目数据测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/store_test.xml")
public class CatDataInit {

    @Autowired
    RedisIO redisIO;

    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    ShiguTaobaocatMapper shiguTaobaocatMapper;

    String CAT_UP_COUNT_INDEX = "count_upload_for_cat_cid_index_";

    String MAN_CAT_UP_COUNT_INDEX = "man_cat_upload_count_index_";

    String WOMAN_CAT_UP_COUNT_INDEX = "woman_cat_upload_count_index_";

    /**
     * 获取期次时间戳
     * @param prePemNum 往前推期次
     * @return
     */
    public String selPemTimeStamp(int prePemNum){
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE,-7*prePemNum);
        Date newTime = calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(newTime);
    }

    @Test
    public void filledCidScore(){
        int pem = 0;
        List<RankingCateLineVO> rankingCateLineVOS = Lists.newArrayList();
        for (ShiguTaobaocat shiguTaobaocat : cats(Lists.newArrayList(16L))) {
            Long uploadCount = redisIO.get(getPreFix(CAT_UP_COUNT_INDEX,pem)+shiguTaobaocat.getCid(), Long.class);
            RankingCateLineVO lineVO = new RankingCateLineVO();
            if (uploadCount == null) {
                continue;
            }
            lineVO.setText(shiguTaobaocat.getCname());
            lineVO.setTotalNum(uploadCount);
            rankingCateLineVOS.add(lineVO);
        }
        Collections.sort(rankingCateLineVOS,new RankingCateLineVO.RankingCateComparator());
        int i = 0;
        List<RankingCateLineVO> resultRankingList = Lists.newArrayList();
        for (RankingCateLineVO rankingCateLineVO : rankingCateLineVOS) {
            if (i++>3) {
                break;
            }
            rankingCateLineVO.setRank(i);
            resultRankingList.add(rankingCateLineVO);
        }
        redisIO.putTemp(getPreFix(WOMAN_CAT_UP_COUNT_INDEX,pem),resultRankingList,3600*24*180);
    }

    public List<ShiguTaobaocat> cats(List<Long> parentCids) {
        ShiguTaobaocatExample example = new ShiguTaobaocatExample();
        example.createCriteria().andParentCidIn(parentCids);
        return shiguTaobaocatMapper.selectByExample(example);
    }

    @Test
    public void cidDataBaseTest(){
        String s = redisIO.get(getPreFix(WOMAN_CAT_UP_COUNT_INDEX,0));
        String man = redisIO.get(getPreFix(MAN_CAT_UP_COUNT_INDEX,0));
        System.out.println(s);
        System.out.println(man);
    }

    private String getPreFix(String prefixIndex,int pem){
        String formatPrefix = prefixIndex + selPemTimeStamp(pem) + "_";
        return formatPrefix;
    }

    @Test
    public void initCatData() {
        String formatPrefix = getPreFix(CAT_UP_COUNT_INDEX,0);
        Client searchClient = ElasticConfiguration.searchClient;
        SearchResponse scrollResp = searchClient.prepareSearch("shigugoodsup").setTypes("hz").setSearchType(SearchType.SCAN)
                .setSize(500).setScroll(TimeValue.timeValueMinutes(5)).setQuery(QueryBuilders.rangeQuery("daiTime").from("now-7d"))
                .execute().actionGet();
        long count = scrollResp.getHits().getTotalHits();
        for (int i = 0, sum = 0; sum < count; i++) {
            scrollResp = searchClient.prepareSearchScroll(scrollResp.getScrollId())
                    .setScroll(TimeValue.timeValueMinutes(10))
                    .execute().actionGet();
            sum += scrollResp.getHits().hits().length;
            for (SearchHit searchHitFields : scrollResp.getHits().hits()) {
                ItemUpRecordVO itemUpRecordVO = JSON.parseObject(searchHitFields.getSourceAsString(), ItemUpRecordVO.class);
                ShiguGoodsTinyExample example = new ShiguGoodsTinyExample();
                example.setWebSite(itemUpRecordVO.getWebSite());
                example.createCriteria().andGoodsIdEqualTo(itemUpRecordVO.getSupperGoodsId());
                for (ShiguGoodsTiny shiguGoodsTiny : shiguGoodsTinyMapper.selectByExample(example)) {
                    String index = formatPrefix + shiguGoodsTiny.getCid();
                    Long aLong = redisIO.get(index, Long.class);
                    if (aLong == null) {
                        aLong = 0L;
                    }
                    aLong++;
                    redisIO.putTemp(index, aLong, 3600 * 24 * 180);
                }
            }
        }
    }
}
