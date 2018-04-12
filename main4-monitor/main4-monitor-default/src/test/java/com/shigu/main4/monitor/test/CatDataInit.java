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
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.monitor.enums.CidMapEnum;
import com.shigu.main4.monitor.enums.RankingPeriodEnum;
import com.shigu.main4.monitor.services.RankingSimpleService;
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

import java.util.*;
import java.util.stream.Collectors;

import static com.shigu.main4.monitor.service.impl.RankingSimpleServiceImpl.getPeriodTimeStamp;

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

    @Autowired
    RankingSimpleService rankingSimpleService;

    /**
     * 上周数据初始化
     */
    @Test
    public void initCatData() throws Main4Exception {
        initCatData(0,RankingPeriodEnum.RANKING_BY_WEEK);
        filledCidScore(0,16L,RankingPeriodEnum.RANKING_BY_WEEK);
        filledCidScore(0,30L,RankingPeriodEnum.RANKING_BY_WEEK);
    }

    @Test
    public void getListTest(){
        try {
            List<RankingCateLineVO> womanList = rankingSimpleService.getRankingCateLinesByCids(16L,RankingPeriodEnum.RANKING_BY_WEEK);
            List<RankingCateLineVO> manList = rankingSimpleService.getRankingCateLinesByCids(30L,RankingPeriodEnum.RANKING_BY_WEEK);
            System.out.println(womanList);
            System.out.println(manList);
        } catch (Main4Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 排出对应期次顶级类目排行前三的子类目
     * @param prePemNum 往前期次
     * @param cid 顶级类目id
     */
    public void filledCidScore(int prePemNum, Long cid, RankingPeriodEnum periodEnum) throws Main4Exception {
        int pem = prePemNum;
        List<RankingCateLineVO> rankingCateLineVOS = Lists.newArrayList();
        for (ShiguTaobaocat shiguTaobaocat : cats(Lists.newArrayList(cid))) {
            Long uploadCount = redisIO.get(getPreFix(CAT_UP_COUNT_INDEX,pem,periodEnum)+shiguTaobaocat.getCid(), Long.class);
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
        int size = rankingCateLineVOS.size();
        if (size>3) {
            rankingCateLineVOS = rankingCateLineVOS.subList(0,3);
        }
        for (RankingCateLineVO rankingCateLineVO : rankingCateLineVOS) {
            ++i;
            rankingCateLineVO.setRank(i);
        }
        redisIO.putTemp(CidMapEnum.map(cid)+getPeriodTimeStamp(pem,periodEnum),rankingCateLineVOS,3600*24*180);
    }

    public List<ShiguTaobaocat> cats(List<Long> parentCids) {
        ShiguTaobaocatExample example = new ShiguTaobaocatExample();
        example.createCriteria().andParentCidIn(parentCids);
        return shiguTaobaocatMapper.selectByExample(example);
    }

    @Test
    public void cidDataBaseTest(){
        String s = redisIO.get(getPreFix(WOMAN_CAT_UP_COUNT_INDEX,0,RankingPeriodEnum.RANKING_BY_WEEK));
        String man = redisIO.get(getPreFix(MAN_CAT_UP_COUNT_INDEX,0,RankingPeriodEnum.RANKING_BY_WEEK));
        System.out.println(s);
        System.out.println(man);
    }

    private String getPreFix(String prefixIndex,int pem,RankingPeriodEnum periodEnum){
        String formatPrefix = prefixIndex + getPeriodTimeStamp(pem,periodEnum) + "_";
        return formatPrefix;
    }


    /**
     * 往前x期类目上传量数据初始化
     * @param prePemNum
     */
    public void initCatData(int prePemNum,RankingPeriodEnum periodEnum) {
        String formatPrefix = getPreFix(CAT_UP_COUNT_INDEX,prePemNum,periodEnum);
        String fromTime = getPeriodTimeStamp(prePemNum+1,periodEnum) + " 00:00:00";
        String toTime = getPeriodTimeStamp(prePemNum,periodEnum) + " 00:00:00";
        Client searchClient = ElasticConfiguration.searchClient;
        SearchResponse scrollResp = searchClient.prepareSearch("shigugoodsup").setTypes("hz").setSearchType(SearchType.SCAN)
                .setSize(500).setScroll(TimeValue.timeValueMinutes(5)).setQuery(QueryBuilders.rangeQuery("daiTime").from(fromTime).to(toTime))
                .execute().actionGet();
        long count = scrollResp.getHits().getTotalHits();
        for (int i = 0, sum = 0; sum < count; i++) {
            scrollResp = searchClient.prepareSearchScroll(scrollResp.getScrollId())
                    .setScroll(TimeValue.timeValueMinutes(10))
                    .execute().actionGet();
            sum += scrollResp.getHits().hits().length;
            Map<String,List<ItemUpRecordVO>> webSiteItemUpMap = new HashMap<>();
            for (SearchHit searchHitFields : scrollResp.getHits().hits()) {
                ItemUpRecordVO itemUpRecordVO = JSON.parseObject(searchHitFields.getSourceAsString(), ItemUpRecordVO.class);
                List<ItemUpRecordVO> itemUpRecordVOS = webSiteItemUpMap.get(itemUpRecordVO.getWebSite());
                if (itemUpRecordVOS == null) {
                    itemUpRecordVOS = new ArrayList<>();
                    webSiteItemUpMap.put(itemUpRecordVO.getWebSite(),itemUpRecordVOS);
                }
                itemUpRecordVOS.add(itemUpRecordVO);
            }
            for (String webSite : webSiteItemUpMap.keySet()) {
                List<Long> goodsIds = webSiteItemUpMap.get(webSite).stream().filter(item -> item != null && item.getSupperGoodsId() != null).map(ItemUpRecordVO::getSupperGoodsId).collect(Collectors.toList());
                if (goodsIds.isEmpty()) {
                    continue;
                }
                ShiguGoodsTinyExample example = new ShiguGoodsTinyExample();
                example.setWebSite(webSite);
                example.createCriteria().andGoodsIdIn(goodsIds);
                for (ShiguGoodsTiny shiguGoodsTiny : shiguGoodsTinyMapper.selectByExample(example)) {
                    String index = formatPrefix + shiguGoodsTiny.getCid();
                    Long aLong = redisIO.get(index, Long.class);
                    if (aLong == null) {
                        aLong = 0L;
                    }
                    aLong++;
                    redisIO.putTemp(index, aLong, 3600 * 24 * 10);
                }
            }
        }
    }
}
