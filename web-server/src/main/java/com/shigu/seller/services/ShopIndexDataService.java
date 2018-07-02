package com.shigu.seller.services;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.protobuf.Internal;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.monitor.enums.FlowType;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.services.ShopBrowerService;
import com.shigu.main4.monitor.vo.BrowerRecord;
import com.shigu.main4.monitor.vo.HotUpItem;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.monitor.vo.NoUpItem;
import com.shigu.seller.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.xcontent.ToXContent;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregator;
import org.elasticsearch.search.aggregations.bucket.MultiBucketsAggregation;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramInterval;
import org.elasticsearch.search.aggregations.bucket.terms.InternalTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsBuilder;
import org.elasticsearch.search.aggregations.metrics.tophits.InternalTopHits;
import org.elasticsearch.search.aggregations.metrics.tophits.TopHitsBuilder;
import org.elasticsearch.search.aggregations.metrics.valuecount.ValueCountBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.jsoup.select.Collector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 店铺首屏数据服务
 * Created by zhaohongbo on 17/3/19.
 */
@Service
public class ShopIndexDataService {

    @Autowired
    protected EhCacheCacheManager cacheManager;

    @Autowired
    ShopBrowerService shopBrowerService;

    @Autowired
    ItemUpRecordService itemUpRecordService;

    @Autowired
    private ShiguShopMapper shiguShopMapper;
    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Autowired
    private ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;
    @Autowired
    private ShiguStoreCollectMapper shiguStoreCollectMapper;
    @Autowired
    private MemberLicenseMapper memberLicenseMapper;

    /**
     * 商户中心,首屏数据
     * @param shopId
     * @return
     */
    public IndexDataFlow selIndexDataFlow(Long shopId){
        Cache cache=cacheManager.getCache("sellerIndexDataCache");
        if(cache.get(shopId)!=null){
            return cache.get(shopId,IndexDataFlow.class);
        }
        IndexDataFlow data=new IndexDataFlow();
        Calendar cal=Calendar.getInstance();
        Date now=cal.getTime();
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        Date from=cal.getTime();
        cal.add(Calendar.MONTH,-3);
        Date threeMonthAgo=cal.getTime();
        cal.add(Calendar.YEAR,-10);
        Date fifthMonthAgo=cal.getTime();
//        data.setDailiRecord(itemUpRecordService.upedItemTimes(shopId,fifthMonthAgo,now));
//        data.setDailiGoods(itemUpRecordService.upedItemNum(shopId,from,now));
//        data.setDailiPerson(itemUpRecordService.countDailiSellerNum(shopId));
        data.setDailiRecord(-1);
        data.setDailiGoods(-1);
        data.setDailiPerson(-1);
        List<HotUpItem> upItems=itemUpRecordService.selHotUpItems(shopId,7);
        List<HotItemVO> hots=new ArrayList<>();
        for(HotUpItem hui:upItems){
            hots.add(new HotItemVO(hui));
        }
        data.setHotGoods(hots);
        List<NoUpItem> noups=itemUpRecordService.noUpItems(shopId,7,threeMonthAgo);
        List<HotItemVO> nos=new ArrayList<>();
        for(NoUpItem nui:noups){
            nos.add(new HotItemVO(nui));
        }
        data.setNothotGoods(nos);
        data.setIpList(shopBrowerService.selShopFlowByHour(shopId,from,24, FlowType.IP));
        data.setPvList(shopBrowerService.selShopFlowByHour(shopId,from,24,FlowType.PV));
        cache.put(shopId,data);
        return data;
    }

    /**
     * 走线图
     * @param shopId
     * @param type
     * @return
     */
    public DateDataLineVO selGhTongjiByDay(Long shopId,int type){
        DateDataLineVO vo=new DateDataLineVO();
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        if(type==1){//今天
            Date from=cal.getTime();
            vo.setIpList(shopBrowerService.selShopFlowByHour(shopId,from,24,FlowType.IP));
            vo.setPvList(shopBrowerService.selShopFlowByHour(shopId,from,24,FlowType.PV));
        }else if(type==2){//最近7天
            cal.add(Calendar.DATE,-6);
            Date from=cal.getTime();
            vo.setIpList(shopBrowerService.selShopFlowByDay(shopId,from,7,FlowType.IP));
            vo.setPvList(shopBrowerService.selShopFlowByDay(shopId,from,7,FlowType.PV));
        }else if(type==3){//最近30天
            cal.add(Calendar.DATE,-29);
            Date from=cal.getTime();
            vo.setIpList(shopBrowerService.selShopFlowByDay(shopId,from,30,FlowType.IP));
            vo.setPvList(shopBrowerService.selShopFlowByDay(shopId,from,30,FlowType.PV));
        }
        return vo;
    }

    /**
     * 展示累计数据
     * @param shopId
     */
    public List<EachAllDataVO> eachAllDataList(Long shopId,String webSite) {
        List<EachAllDataVO> eachAllDataVOS = new ArrayList<>();

        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);

        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);
        String domain = null;
        if (StringUtils.isNotBlank(shiguShop.getDomain())) {
            domain = shiguShop.getDomain()+".571xz.com";
        }

        //今日访问
        long todayViewNum = 0L;
        String todayStartStrTime = DateFormatUtils.format(todayStart, "yyyy-MM-dd HH:mm:ss");
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigupagerecode");
        srb.setTypes("shop");
        BoolQueryBuilder qb= QueryBuilders.boolQuery();
        qb.must(QueryBuilders.rangeQuery("inTime").gte(todayStartStrTime));
        qb.must(QueryBuilders.termQuery("shop",shopId));

        srb.setQuery(qb);
        srb.setSize(0);
        srb.setFrom(1);
        TermsBuilder termsBuilder = AggregationBuilders.terms("shop").field("shop");
        srb.addAggregation(termsBuilder);
        org.elasticsearch.action.search.SearchResponse searchResponse = srb.execute()
                .actionGet();
        Terms shopTerms = searchResponse.getAggregations().get("shop");
        if (shopTerms != null && !shopTerms.getBuckets().isEmpty()) {
            List<Terms.Bucket> buckets = shopTerms.getBuckets();
            for (Terms.Bucket bucket : buckets){
                if (bucket.getKeyAsNumber().longValue() == shopId) {
                    todayViewNum = bucket.getDocCount();
                }
            }
        }

        if (domain != null) {
            SearchRequestBuilder domainSrb = ElasticConfiguration.searchClient.prepareSearch("shigupagerecode");
            domainSrb.setTypes("other");
            BoolQueryBuilder domainQb= QueryBuilders.boolQuery();
            domainQb.must(QueryBuilders.rangeQuery("inTime").gte(todayStartStrTime));
            domainQb.must(QueryBuilders.termQuery("domain",domain));

            domainSrb.setQuery(domainQb);
            domainSrb.setSize(0);
            domainSrb.setFrom(1);
            TermsBuilder domianTermsBuilder = AggregationBuilders.terms("domain").field("domain");
            domainSrb.addAggregation(domianTermsBuilder);
            org.elasticsearch.action.search.SearchResponse domainSearchResponse = domainSrb.execute()
                    .actionGet();
            Terms domainTerms = domainSearchResponse.getAggregations().get("domain");
            if (domainTerms != null && !domainTerms.getBuckets().isEmpty()) {
                List<Terms.Bucket> buckets = domainTerms.getBuckets();
                for (Terms.Bucket bucket : buckets){
                    if (bucket.getKeyAsString().equals(domain)) {
                        todayViewNum += bucket.getDocCount();
                    }
                }
            }
        }

        ShiguGoodsTinyExample example = new ShiguGoodsTinyExample();
        example.setWebSite(webSite);
        example.createCriteria().andStoreIdEqualTo(shopId);

        List<ShiguGoodsTiny> goodsList = shiguGoodsTinyMapper.selectFieldsByExample(example, FieldUtil.codeFields("goods_id"));
        if (goodsList != null && !goodsList.isEmpty()) {
            List<Long> goodsIds = goodsList.stream().map(ShiguGoodsTiny::getGoodsId).collect(Collectors.toList());
            List<List<Long>> partition = Lists.partition(goodsIds, 500);

            for (List<Long> ids : partition){
                SearchRequestBuilder itemSrb = ElasticConfiguration.searchClient.prepareSearch("shigupagerecode");
                itemSrb.setTypes("item");
                BoolQueryBuilder itemQb= QueryBuilders.boolQuery();
                itemQb.must(QueryBuilders.rangeQuery("inTime").gte(todayStartStrTime));
                itemQb.must(QueryBuilders.termsQuery("itemId",ids.toArray(new Long[ids.size()])));

                itemSrb.setQuery(itemQb);
                itemSrb.addAggregation(AggregationBuilders.terms("_type").field("_type"));
                org.elasticsearch.action.search.SearchResponse itemSrbSearchResponse = itemSrb.execute()
                        .actionGet();
                Terms itemTerms = itemSrbSearchResponse.getAggregations().get("_type");
                if (itemTerms != null && !itemTerms.getBuckets().isEmpty()) {
                    todayViewNum += itemTerms.getBuckets().get(0).getDocCount();
                }

            }

        }

        //今日下载 imgzip
        long todayDownloadNum = 0;
        SearchRequestBuilder downloadsSrb = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
//        downloadsSrb.setTypes(webSite);
        BoolQueryBuilder downloadQb= QueryBuilders.boolQuery();
        downloadQb.must(QueryBuilders.rangeQuery("daiTime").gte(todayStartStrTime));
        downloadQb.must(QueryBuilders.termQuery("supperStoreId",shopId));
        downloadQb.must(QueryBuilders.termQuery("flag","imgzip"));

        downloadsSrb.setQuery(downloadQb);
        downloadsSrb.addAggregation(AggregationBuilders.terms("_type").field("_type"));
        org.elasticsearch.action.search.SearchResponse downloadsSrbResponse = downloadsSrb.execute()
                .actionGet();
        Terms downloadsSrbTerms = downloadsSrbResponse.getAggregations().get("_type");
        if (downloadsSrbTerms != null && !downloadsSrbTerms.getBuckets().isEmpty()) {
            todayDownloadNum = downloadsSrbTerms.getBuckets().get(0).getDocCount();
        }

        //累计下载
        long totalDownloadNum = 0;
        SearchRequestBuilder totalDownloadsSrb = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
        totalDownloadsSrb.setTypes(webSite);
        BoolQueryBuilder totalDownloadQb= QueryBuilders.boolQuery();
        totalDownloadQb.must(QueryBuilders.termQuery("supperStoreId",shopId));
        downloadQb.must(QueryBuilders.termQuery("flag","imgzip"));

        totalDownloadsSrb.setQuery(downloadQb);
        totalDownloadsSrb.addAggregation(AggregationBuilders.terms("_type").field("_type"));
        org.elasticsearch.action.search.SearchResponse totalDownloadsSearchResponse = totalDownloadsSrb.execute()
                .actionGet();
        Terms totalDownloadsTerms = totalDownloadsSearchResponse.getAggregations().get("_type");
        if (totalDownloadsTerms != null && !totalDownloadsTerms.getBuckets().isEmpty()) {
            todayDownloadNum = totalDownloadsTerms.getBuckets().get(0).getDocCount();
        }

        //关注用户
        ShiguStoreCollectExample shiguStoreCollectExample = new ShiguStoreCollectExample();
        shiguStoreCollectExample.createCriteria().andStoreIdEqualTo(shopId);//状态字段已弃用
        int count = shiguStoreCollectMapper.countByExample(shiguStoreCollectExample);

        EachAllDataVO todayViewDataVO = new EachAllDataVO();
        todayViewDataVO.setText("今日访问");
        todayViewDataVO.setNum(String.valueOf(todayViewNum));

        EachAllDataVO todayDownloadDataVO = new EachAllDataVO();
        todayDownloadDataVO.setText("今日下载");
        todayDownloadDataVO.setNum(String.valueOf(todayDownloadNum));

        EachAllDataVO totalDownloadDataVO = new EachAllDataVO();
        totalDownloadDataVO.setText("累计下载");
        totalDownloadDataVO.setNum(String.valueOf(todayDownloadNum));

        EachAllDataVO followUserDataVO = new EachAllDataVO();
        followUserDataVO.setText("关注用户");
        followUserDataVO.setNum(String.valueOf(count));

        eachAllDataVOS.add(todayViewDataVO);
        eachAllDataVOS.add(todayDownloadDataVO);
        eachAllDataVOS.add(totalDownloadDataVO);
        eachAllDataVOS.add(followUserDataVO);

        return eachAllDataVOS;
    }

    /**
     * 今日下载排行榜数据
     * @param shopId
     * @param webSite
     * @return
     */
    public List<DownlaodDataVO> todayDownlaodDataList(Long shopId, String webSite) {
        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 0);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.SECOND, 0);
        startTime.set(Calendar.MILLISECOND, 0);

        return downlaodDataList(shopId,webSite,DateFormatUtils.format(startTime, "yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 下载排行榜数据
     * @param shopId
     * @param webSite
     * @param startTime yyyy-MM-dd HH;mm:ss
     * @return
     */
    public List<DownlaodDataVO> downlaodDataList(Long shopId, String webSite,String startTime) {
        List<DownlaodDataVO> todayDownlaodDataVOS = new ArrayList<>();

        SearchRequestBuilder downloadsSrb = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
        BoolQueryBuilder downloadQb= QueryBuilders.boolQuery();
        downloadQb.must(QueryBuilders.rangeQuery("daiTime").gte(startTime));
        downloadQb.must(QueryBuilders.termQuery("supperStoreId",shopId));
        downloadQb.must(QueryBuilders.termQuery("flag","imgzip"));

        downloadsSrb.setQuery(downloadQb);
        downloadsSrb.setSize(0);
        downloadsSrb.setFrom(1);
        downloadsSrb.addAggregation(AggregationBuilders.terms("supperGoodsId").field("supperGoodsId").size(30));
        org.elasticsearch.action.search.SearchResponse downloadsSrbResponse = downloadsSrb.execute()
                .actionGet();
        Terms downloadsSrbTerms = downloadsSrbResponse.getAggregations().get("supperGoodsId");
        List<Long> goodsIds = new ArrayList<>();
        if (downloadsSrbTerms != null && !downloadsSrbTerms.getBuckets().isEmpty()) {
            downloadsSrbTerms.getBuckets().stream().forEach(item->{
                DownlaodDataVO vo = new DownlaodDataVO();
                vo.setGoodsId(String.valueOf(item.getKeyAsNumber().longValue()));
                vo.setDownNum(String.valueOf(item.getDocCount()));

                todayDownlaodDataVOS.add(vo);
                goodsIds.add(item.getKeyAsNumber().longValue());
            });
        }
        if (!todayDownlaodDataVOS.isEmpty()) {
            SearchRequestBuilder goodsSrb = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
            BoolQueryBuilder goodsQb= QueryBuilders.boolQuery();
            goodsQb.must(QueryBuilders.rangeQuery("daiTime").gte(startTime));
            goodsQb.must(QueryBuilders.termsQuery("supperGoodsId",goodsIds.toArray(new Long[goodsIds.size()])));
            goodsQb.must(QueryBuilders.termQuery("flag","imgzip"));

            TopHitsBuilder topHitsBuilder = AggregationBuilders.topHits("daiTimeSort").setSize(1).addSort(SortBuilders.fieldSort("daiTime").order(SortOrder.DESC)).setFetchSource(true);
            goodsSrb.setQuery(goodsQb);
            goodsSrb.addAggregation(AggregationBuilders.terms("supperGoodsId").field("supperGoodsId").subAggregation(topHitsBuilder));
            org.elasticsearch.action.search.SearchResponse goodsSrbResponse = goodsSrb.execute()
                    .actionGet();

            Map<String, DownlaodDataVO> todayDownloadMap = todayDownlaodDataVOS.stream().collect(Collectors.toMap(DownlaodDataVO::getGoodsId, Function.identity(),(key1, key2) -> key2));
            Map<String, String> goodsIdUidMap = new HashMap<>();
            List<Terms.Bucket> terms = ((InternalTerms) goodsSrbResponse.getAggregations().get("supperGoodsId")).getBuckets();
            List<Long> downloadcUserIds = new ArrayList<>();

            for (Terms.Bucket bucket : terms){
                SearchHit[] daiTimeSorts = ((InternalTopHits) bucket.getAggregations().get("daiTimeSort")).getHits().getHits();
                if (daiTimeSorts != null && daiTimeSorts.length >0) {
                    ItemUpRecordVO shiguGoodsUp = JSON.parseObject(daiTimeSorts[0].getSourceAsString(), ItemUpRecordVO.class);
                    String strGoodsId= String.valueOf(shiguGoodsUp.getSupperGoodsId());

                    DownlaodDataVO todayDownlaodDataVO = todayDownloadMap.get(strGoodsId);
                    todayDownlaodDataVO.setImgSrc(shiguGoodsUp.getSupperImage());
                    todayDownlaodDataVO.setTitle(shiguGoodsUp.getFenGoodsName());
                    todayDownlaodDataVO.setLastDownTime(shiguGoodsUp.getDaiTime());

                    goodsIdUidMap.put(strGoodsId,String.valueOf(shiguGoodsUp.getFenUserId()));
                    downloadcUserIds.add(shiguGoodsUp.getFenUserId());
                }
            }

            if (downloadcUserIds != null && !downloadcUserIds.isEmpty()) {

                MemberLicenseExample memberLicenseExample = new MemberLicenseExample();
                memberLicenseExample.createCriteria().andLicenseTypeEqualTo(4).andUserIdIn(downloadcUserIds);
                List<MemberLicense> memberLicenses = memberLicenseMapper.selectByExample(memberLicenseExample);
                Map<String, String> licenceMap = new HashMap<>();
                memberLicenses.stream().forEach(item->{
                    licenceMap.put(String.valueOf(item.getUserId()),item.getContext());
                });

               for(Map.Entry<String,String> entry : goodsIdUidMap.entrySet()){
                   String context = licenceMap.get(entry.getValue());
                   todayDownloadMap.get(entry.getKey()).setUserPhone(context.substring(0,3)+"****"+context.substring(7));
               }

            }

        }

        return todayDownlaodDataVOS;
    }

    /**
     * 一周访问排行榜数据
     * @param shopId
     * @param webSite
     * @return
     */
    public List<WeekReadDataVO> weekReadDataList(Long shopId, String webSite) {
        List<WeekReadDataVO> weekReadDataVOS = new ArrayList<>();

        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 0);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.SECOND, 0);
        startTime.set(Calendar.MILLISECOND, 0);
        startTime.add(Calendar.DAY_OF_MONTH,-7);

        String startStrTime = DateFormatUtils.format(startTime, "yyyy-MM-dd HH:mm:ss");

        ShiguGoodsTinyExample example = new ShiguGoodsTinyExample();
        example.setWebSite(webSite);
        example.createCriteria().andStoreIdEqualTo(shopId);
        List<ShiguGoodsTiny> goodsList = shiguGoodsTinyMapper.selectFieldsByExample(example, FieldUtil.codeFields("goods_id"));

        List<WeekReadDataVO> topWeekReadDataVOS = new ArrayList<>();
        if (goodsList != null && !goodsList.isEmpty()) {
            List<Long> goodsIds = goodsList.stream().map(ShiguGoodsTiny::getGoodsId).collect(Collectors.toList());
            List<List<Long>> partition = Lists.partition(goodsIds, 500);

            for (List<Long> ids : partition){
                //查浏览量
                SearchRequestBuilder downloadsSrb = ElasticConfiguration.searchClient.prepareSearch("shigupagerecode");
                downloadsSrb.setTypes("item");
                BoolQueryBuilder itemQb= QueryBuilders.boolQuery();
                itemQb.must(QueryBuilders.rangeQuery("inTime").gte(startStrTime));
                itemQb.must(QueryBuilders.termsQuery("itemId",ids.toArray(new Long[ids.size()])));

                downloadsSrb.setQuery(itemQb);
                downloadsSrb.setSize(0);
                downloadsSrb.setFrom(1);
                downloadsSrb.addAggregation(AggregationBuilders.terms("itemId").field("itemId").size(30)
                        .subAggregation(AggregationBuilders.topHits("inTimeSort").setSize(1)
                                .addSort(SortBuilders.fieldSort("inTime").order(SortOrder.DESC)).setFetchSource(true)));
                org.elasticsearch.action.search.SearchResponse downloadsSrbResponse = downloadsSrb.execute()
                        .actionGet();
                Terms downloadsSrbTerms = downloadsSrbResponse.getAggregations().get("itemId");
                if (downloadsSrbTerms != null && !downloadsSrbTerms.getBuckets().isEmpty()) {
                    downloadsSrbTerms.getBuckets().stream().forEach(item->{

                        WeekReadDataVO vo = new WeekReadDataVO();
                        vo.setGoodsId(String.valueOf(item.getKeyAsNumber().longValue()));
                        vo.setReadNum(String.valueOf(item.getDocCount()));

                        SearchHit[] daiTimeSorts = ((InternalTopHits) item.getAggregations().get("inTimeSort")).getHits().getHits();
                        if (daiTimeSorts != null && daiTimeSorts.length >0) {
                            BrowerRecord browerRecord = JSON.parseObject(daiTimeSorts[0].getSourceAsString(), BrowerRecord.class);
                            vo.setLastReadTime(DateFormatUtils.format(browerRecord.getInTime(), "yyyy-MM-dd HH:mm:ss"));
                        }

                        weekReadDataVOS.add(vo);
                    });
                }
            }

            Collections.sort(weekReadDataVOS);
            topWeekReadDataVOS = weekReadDataVOS.stream().limit(30).collect(Collectors.toList());
            Map<String, WeekReadDataVO> topDataVOMap = topWeekReadDataVOS.stream().collect(Collectors.toMap(WeekReadDataVO::getGoodsId, Function.identity(), (key1, key2) -> key2));

            if (topDataVOMap != null && !topDataVOMap.isEmpty()) {
                List<Long> longGoodsIds = topWeekReadDataVOS.stream().map(item -> Long.parseLong(item.getGoodsId())).collect(Collectors.toList());

                ShiguGoodsTinyExample shiguGoodsTinyExample = new ShiguGoodsTinyExample();
                shiguGoodsTinyExample.setWebSite(webSite);
                shiguGoodsTinyExample.createCriteria().andGoodsIdIn(longGoodsIds);
                List<ShiguGoodsTiny> shiguGoodsTinies = shiguGoodsTinyMapper.selectFieldsByExample(shiguGoodsTinyExample, FieldUtil.codeFields("goods_id,pic_url,title"));
                shiguGoodsTinies.stream().forEach(item -> {
                    WeekReadDataVO weekReadDataVO = topDataVOMap.get(String.valueOf(item.getGoodsId()));
                    weekReadDataVO.setTitle(item.getTitle());
                    weekReadDataVO.setImgSrc(item.getPicUrl());
                });

                ShiguGoodsSoldoutExample shiguGoodsSoldoutExample = new ShiguGoodsSoldoutExample();
                shiguGoodsSoldoutExample.setWebSite(webSite);
                shiguGoodsSoldoutExample.createCriteria().andGoodsIdIn(longGoodsIds);
                List<ShiguGoodsSoldout> shiguGoodsSoldouts = shiguGoodsSoldoutMapper.selectFieldsByExample(shiguGoodsSoldoutExample, FieldUtil.codeFields("goods_id,pic_url,title"));
                shiguGoodsSoldouts.stream().forEach(item -> {
                    WeekReadDataVO weekReadDataVO = topDataVOMap.get(String.valueOf(item.getGoodsId()));
                    weekReadDataVO.setTitle(item.getTitle());
                    weekReadDataVO.setImgSrc(item.getPicUrl());
                });
            }


        }

        return topWeekReadDataVOS;
    }

    /**
     * 一周下载排行榜数据
     * @param shopId
     * @param webSite
     * @return
     */
    public List<DownlaodDataVO> weekDownloadDataList(Long shopId, String webSite) {
        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 0);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.SECOND, 0);
        startTime.set(Calendar.MILLISECOND, 0);
        startTime.add(Calendar.DAY_OF_MONTH,-7);

        return downlaodDataList(shopId,webSite,DateFormatUtils.format(startTime, "yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 获取访问下载数据
     * @param shopId
     * @param webSite
     * @return
     */
    public List<LineDataVO> getDownReadData(Long shopId, String webSite) {
        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 0);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.SECOND, 0);
        startTime.set(Calendar.MILLISECOND, 0);
        startTime.add(Calendar.DAY_OF_MONTH,-9);
        String commonStartStrTime = DateFormatUtils.format(startTime, "yyyy-MM-dd HH:mm:ss");
        String startStrTime = DateFormatUtils.format(startTime, "yyyy/MM/dd");
        String nowStrTime = DateFormatUtils.format(new Date(), "yyyy/MM/dd");

        //访问
        SearchRequestBuilder requestBuilder = ElasticConfiguration.searchClient.prepareSearch("shigupagerecode");
        requestBuilder.setTypes("shop");

        BoolQueryBuilder qb = QueryBuilders.boolQuery();
        qb.must(QueryBuilders.rangeQuery("inTime").from(commonStartStrTime));
        qb.must(QueryBuilders.termQuery("shop",shopId));

        requestBuilder.setQuery(qb);
        requestBuilder.addAggregation(AggregationBuilders.dateHistogram("goodsReadStatistics")
                .field("inTime").interval(DateHistogramInterval.DAY).format("yyyy/MM/dd").minDocCount(0).extendedBounds(startStrTime, nowStrTime));
        SearchResponse searchResponse = requestBuilder.execute().actionGet();
        MultiBucketsAggregation agg = searchResponse.getAggregations().get("goodsReadStatistics");
        List<DataListVO> goodsReadStatistics = agg.getBuckets().stream().map(o -> {
            DataListVO vo = new DataListVO();
            vo.setText(o.getKeyAsString());
            vo.setValue(o.getDocCount());
            return vo;
        }).collect(Collectors.toList());
        Map<String, DataListVO> dataListVOMap = goodsReadStatistics.stream().collect(Collectors.toMap(DataListVO::getText, Function.identity(),(key1, key2) -> key2));


        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);
        String domain = null;
        if (StringUtils.isNotBlank(shiguShop.getDomain())) {
            domain = shiguShop.getDomain()+".571xz.com";
        }
        if (domain != null) {
            SearchRequestBuilder domainSrb = ElasticConfiguration.searchClient.prepareSearch("shigupagerecode");
            domainSrb.setTypes("other");
            BoolQueryBuilder domainQb= QueryBuilders.boolQuery();
            domainQb.must(QueryBuilders.rangeQuery("inTime").from(commonStartStrTime));
            domainQb.must(QueryBuilders.termQuery("domain",domain));

            domainSrb.setQuery(domainQb);
            domainSrb.setSize(0);
            domainSrb.setFrom(1);
            domainSrb.addAggregation(AggregationBuilders.dateHistogram("domainReadStatistics")
                    .field("inTime").interval(DateHistogramInterval.DAY).format("yyyy/MM/dd").minDocCount(0).extendedBounds(startStrTime, nowStrTime));
            org.elasticsearch.action.search.SearchResponse domainSearchResponse = domainSrb.execute()
                    .actionGet();
            MultiBucketsAggregation doaminAgg = domainSearchResponse.getAggregations().get("domainReadStatistics");
            doaminAgg.getBuckets().stream().forEach(item->{
                DataListVO dataListVO = dataListVOMap.get(item.getKeyAsString());
                dataListVO.setValue(dataListVO.getValue()+item.getDocCount());
            });
        }

        ShiguGoodsTinyExample example = new ShiguGoodsTinyExample();
        example.setWebSite(webSite);
        example.createCriteria().andStoreIdEqualTo(shopId);
        List<ShiguGoodsTiny> goodsList = shiguGoodsTinyMapper.selectFieldsByExample(example, FieldUtil.codeFields("goods_id"));
        if (goodsList != null && !goodsList.isEmpty()) {
            List<Long> goodsIds = goodsList.stream().map(ShiguGoodsTiny::getGoodsId).collect(Collectors.toList());
            List<List<Long>> partition = Lists.partition(goodsIds, 500);

            for (List<Long> ids : partition){
                SearchRequestBuilder itemSrb = ElasticConfiguration.searchClient.prepareSearch("shigupagerecode");
                itemSrb.setTypes("item");
                BoolQueryBuilder itemQb= QueryBuilders.boolQuery();
                itemQb.must(QueryBuilders.rangeQuery("inTime").from(commonStartStrTime));
                itemQb.must(QueryBuilders.termsQuery("itemId",ids.toArray(new Long[ids.size()])));

                itemSrb.setQuery(itemQb);
                itemSrb.setSize(0);
                itemSrb.setFrom(1);
                itemSrb.addAggregation(AggregationBuilders.dateHistogram("itemReadStatistics")
                        .field("inTime").interval(DateHistogramInterval.DAY).format("yyyy/MM/dd").minDocCount(0).extendedBounds(startStrTime, nowStrTime));
                org.elasticsearch.action.search.SearchResponse itemSearchResponse = itemSrb.execute()
                        .actionGet();
                MultiBucketsAggregation itemAgg = itemSearchResponse.getAggregations().get("itemReadStatistics");
                itemAgg.getBuckets().stream().forEach(item->{
                    DataListVO dataListVO = dataListVOMap.get(item.getKeyAsString());
                    dataListVO.setValue(dataListVO.getValue()+item.getDocCount());
                });

            }

        }

        //下载
        SearchRequestBuilder downloadBuilder = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
        downloadBuilder.setTypes(webSite);

        downloadBuilder.setQuery(QueryBuilders.boolQuery()
                        .must(QueryBuilders.termQuery("supperStoreId", shopId))
                        .must(QueryBuilders.termQuery("flag","imgzip"))
                        .must(QueryBuilders.rangeQuery("daiTime").from(commonStartStrTime)))
                .addAggregation(AggregationBuilders.dateHistogram("goodsUploadStatistics")
                        .field("daiTime").interval(DateHistogramInterval.DAY).minDocCount(0).format("yyyy/MM/dd").extendedBounds(startStrTime, nowStrTime));
        SearchResponse downloadResponse = downloadBuilder.execute().actionGet();
        MultiBucketsAggregation downloadAgg = downloadResponse.getAggregations().get("goodsUploadStatistics");
        List<DataListVO> goodsUploadStatistics = downloadAgg.getBuckets().stream().map(o -> {
            DataListVO vo = new DataListVO();
            vo.setText(o.getKeyAsString());
            vo.setValue(o.getDocCount());
            return vo;
        }).collect(Collectors.toList());


        LineDataVO readLineDataVO = new LineDataVO();
        readLineDataVO.setTitle("访问");
        readLineDataVO.setDataList(goodsReadStatistics);

        LineDataVO downloadLineDataVO = new LineDataVO();
        downloadLineDataVO.setTitle("下载");
        downloadLineDataVO.setDataList(goodsUploadStatistics);

        List<LineDataVO> lineDataVOS = new ArrayList<>();
        lineDataVOS.add(readLineDataVO);
        lineDataVOS.add(downloadLineDataVO);

        return lineDataVOS;
    }
}
