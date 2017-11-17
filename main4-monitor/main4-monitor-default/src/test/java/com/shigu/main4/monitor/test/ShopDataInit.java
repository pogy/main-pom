package com.shigu.main4.monitor.test;

import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.beans.ShiguShopLicense;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguShopLicenseMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.monitor.enums.CidMarketIdMapEnum;
import com.shigu.main4.monitor.enums.RankingPeriodEnum;
import com.shigu.main4.monitor.vo.RankingShopVO;
import com.shigu.main4.tools.RedisIO;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.valuecount.InternalValueCount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.shigu.main4.monitor.service.impl.RankingSimpleServiceImpl.getPeriodTimeStamp;

/**
 * 类名：ShopDataInit
 * 类路径：com.shigu.main4.monitor.test.ShopDataInit
 * 创建者：王浩翔
 * 创建时间：2017-10-02 15:40
 * 项目：main-pom
 * 描述：排行榜店铺测试数据初始化
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/store_test.xml")
public class ShopDataInit {

    @Autowired
    ShiguShopLicenseMapper shiguShopLicenseMapper;
    @Autowired
    ShiguShopMapper shiguShopMapper;
    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Autowired
    ShiguMarketMapper shiguMarketMapper;
    @Autowired
    RedisIO redisIO;

    @Test
    public void initMan() {
        //upDataToRedis(CidMarketIdMapEnum.ALL_CAT_SHOP_RANKING, 1, RankingPeriodEnum.RANKING_BY_WEEK);
        //upDataToRedis(CidMarketIdMapEnum.MAN_CAT_SHOP_RANKING, 1, RankingPeriodEnum.RANKING_BY_WEEK);
        //upDataToRedis(CidMarketIdMapEnum.WOMAN_CAT_SHOP_RANKING, 1, RankingPeriodEnum.RANKING_BY_WEEK);
        //upDataToRedis(CidMarketIdMapEnum.ALL_CAT_SHOP_RANKING, 0, RankingPeriodEnum.RANKING_BY_WEEK);
        //upDataToRedis(CidMarketIdMapEnum.MAN_CAT_SHOP_RANKING, 0, RankingPeriodEnum.RANKING_BY_WEEK);
        //upDataToRedis(CidMarketIdMapEnum.WOMAN_CAT_SHOP_RANKING, 0, RankingPeriodEnum.RANKING_BY_WEEK);

        upDataToRedis(CidMarketIdMapEnum.ALL_CAT_SHOP_RANKING_MONTH, 1, RankingPeriodEnum.RANKING_BY_MONTH);
        upDataToRedis(CidMarketIdMapEnum.ALL_CAT_SHOP_RANKING_MONTH, 0, RankingPeriodEnum.RANKING_BY_MONTH);
    }

    public void upDataToRedis(CidMarketIdMapEnum cat, int pem, RankingPeriodEnum periodEnum) {
        String fromTime = getPeriodTimeStamp(pem + 1, periodEnum) + " 00:00:00";
        String toTime = getPeriodTimeStamp(pem, periodEnum) + " 00:00:00";
        Client searchClient = ElasticConfiguration.searchClient;
        SearchRequestBuilder searchRequestBuilder = searchClient.prepareSearch("shigugoodsup").setTypes("hz");
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        for (Long aLong : cat.getMarketIds()) {
            boolQuery.should(QueryBuilders.termQuery("supperMarketId", aLong));
        }
        searchRequestBuilder.setQuery(QueryBuilders.boolQuery().must(boolQuery).must(QueryBuilders.rangeQuery("daiTime").from(fromTime).to(toTime))).setSize(0);
        searchRequestBuilder.addAggregation(AggregationBuilders.terms("shopUpCount").field("supperStoreId").size(500).subAggregation(AggregationBuilders.count("shopUpManCount").field("fenUserId")));
        SearchResponse searchResponse = searchRequestBuilder.execute().actionGet();
        List<Terms.Bucket> shopUpCount = ((LongTerms) searchResponse.getAggregations().get("shopUpCount")).getBuckets();
        Map<Long, Long> shopIdUpManCount = new LinkedHashMap<>(500);
        //先筛选出类目中一周内上传人数前500的店铺
        for (Terms.Bucket bucket : shopUpCount) {
            //shopId
            Long shopId = bucket.getKeyAsNumber().longValue();
            //上传人数
            Long upManCount = ((InternalValueCount) bucket.getAggregations().get("shopUpManCount")).getValue();
            shopIdUpManCount.put(shopId, upManCount);
        }
        List<Long> shopIdList = shopIdUpManCount.keySet().stream().collect(Collectors.toList());
        int loopSize = shopIdList.size();
        int stepSize = 50;
        Map<Long, Long> shopUpNewCount = new LinkedHashMap<>(500);
        for (int i = 0; i * stepSize < loopSize; i++) {
            List<Long> subList = shopIdList.subList(i * stepSize, (i + 1) * stepSize > loopSize ? loopSize : (i + 1) * stepSize);
            SearchRequestBuilder searchRequestBuilder1 = searchClient.prepareSearch("goods").setTypes("hz");
            BoolQueryBuilder shouldShop = QueryBuilders.boolQuery();
            for (Long aLong : subList) {
                shouldShop.should(QueryBuilders.termQuery("storeId", aLong));
            }
            searchRequestBuilder1.setQuery(QueryBuilders.boolQuery().must(QueryBuilders.rangeQuery("loadDate").from(fromTime).to(toTime)).must(shouldShop)).setSize(0)
                    .addAggregation(AggregationBuilders.terms("shopItemNewCount").field("storeId").size(5));
            SearchResponse shopUpNewResult = searchRequestBuilder1.execute().actionGet();
            LongTerms shopItemNewCount = shopUpNewResult.getAggregations().get("shopItemNewCount");
            for (Terms.Bucket bucket : shopItemNewCount.getBuckets()) {
                long shopId = bucket.getKeyAsNumber().longValue();
                shopUpNewCount.put(shopId, bucket.getDocCount());
            }
        }
        List<RankingShopVO> rankingShopVOS = new ArrayList<>(500);
        for (Long shopId : shopIdList) {
            rankingShopVOS.add(getShopExponent(shopId, shopIdUpManCount.get(shopId), shopUpNewCount.get(shopId), cat.totalScore));
        }
        //截取算分前200的档口
        rankingShopVOS.sort(new RankingShopVO.RankingShopComparator());
        rankingShopVOS = rankingShopVOS.subList(0, 200 < rankingShopVOS.size() ? 200 : rankingShopVOS.size());
        List<RankingShopVO> pastRankingShop = redisIO.getList(cat.getIndexPrefix() + getPeriodTimeStamp(pem + 1, periodEnum), RankingShopVO.class);
        int i = 0;
        for (RankingShopVO rankingShopVO : rankingShopVOS) {
            Long shopId = rankingShopVO.getShopId();
            rankingShopVO.setRank(++i);
            ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);
            ShiguMarket shiguMarket = shiguMarketMapper.selectByPrimaryKey(shiguShop.getMarketId());
            rankingShopVO.setFullShopName(shiguMarket.getMarketName() + " " + shiguShop.getShopNum());
            ShiguShopLicense shiguShopLicense = new ShiguShopLicense();
            shiguShopLicense.setShopId(shopId);
            shiguShopLicense.setLicenseType(6);
            shiguShopLicense.setLicenseFailure(0);
            shiguShopLicense = shiguShopLicenseMapper.selectOne(shiguShopLicense);
            rankingShopVO.setShopLevel(shiguShopLicense == null ? 0L : Long.valueOf(shiguShopLicense.getContext()));
            ShiguGoodsTinyExample example = new ShiguGoodsTinyExample();
            example.setWebSite(shiguShop.getWebSite());
            example.createCriteria().andStoreIdEqualTo(shopId);
            rankingShopVO.setGoodsCount(shiguGoodsTinyMapper.countByExample(example));
            if (pastRankingShop == null) {
                rankingShopVO.setChangeNum(201 - rankingShopVO.getRank());
                continue;
            }
            for (RankingShopVO shopVO : pastRankingShop) {
                if (shopId.equals(shopVO.getShopId())) {
                    rankingShopVO.setChangeNum(shopVO.getRank() - rankingShopVO.getRank());
                    break;
                }
            }
            if (rankingShopVO.getChangeNum() == null) {
                rankingShopVO.setChangeNum(201 - rankingShopVO.getRank());
            }
        }
        //排行结果保存15天
        redisIO.putTemp(cat.getIndexPrefix() + getPeriodTimeStamp(pem, periodEnum), rankingShopVOS, 3600 * 24 * 15);
    }

    /**
     * 计算档口对应的排行权重
     *
     * @param shopId
     * @param shopUpMan
     * @param shopUpNew
     * @param totalScore
     * @return
     */
    private RankingShopVO getShopExponent(Long shopId, Long shopUpMan, Long shopUpNew, int totalScore) {
        RankingShopVO rankingShopVO = new RankingShopVO();
        //在上传量粗排出的店铺中设置保底上新量权重为10件的权重
        if (shopUpNew == null || shopUpNew < 10) {
            shopUpNew = 10L;
        }
        rankingShopVO.setShopId(shopId);
        int upNewMaxScore = totalScore * 3 / 10;
        int upManMaxScore = totalScore * 7 / 10;
        long docCount = shopUpNew;
        //上款量超过1000部分权重
        long kWeight = docCount / 1000 * 100;
        //上款量百位级权重
        long hWeight = (docCount % 1000) / 100 * 100;
        //上款量百位以下权重
        long perWeight = (docCount % 100) * 10;
        //最终上款量权重
        long boostUpNew = kWeight > 0 ? (kWeight > (upNewMaxScore - 2000) ? upNewMaxScore : kWeight + 2000) : hWeight > 0 ? hWeight + 1000 : perWeight;
        long shopUploadScore = shopUpMan * 50;
        long boostUploadMan = shopUploadScore > upManMaxScore ? upManMaxScore : shopUploadScore;
        rankingShopVO.setExponent(boostUpNew + boostUploadMan);
        return rankingShopVO;
    }
}
