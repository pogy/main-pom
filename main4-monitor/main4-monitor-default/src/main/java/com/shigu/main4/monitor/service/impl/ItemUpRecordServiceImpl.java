package com.shigu.main4.monitor.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.bean.ProducerBean;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.searchtool.configs.ElasticConfiguration;
import com.searchtool.domain.SimpleElaBean;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.monitor.enums.GoodsUploadFlagEnum;
import com.shigu.main4.monitor.enums.RankingPeriodEnum;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.services.StarCaculateService;
import com.shigu.main4.monitor.vo.*;
import com.shigu.main4.tools.RedisIO;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

import static com.shigu.main4.monitor.service.impl.RankingSimpleServiceImpl.getPeriodTimeStamp;

import static com.opentae.data.mall.examples.TaobaoSessionMapExample.appkey;
import static com.opentae.data.mall.examples.TaobaoSessionMapExample.secret;

/**
 * 商品上传服务实现类
 * Created by zhaohongbo on 17/3/13.
 */
@Service("itemUpRecordService")
public class ItemUpRecordServiceImpl implements ItemUpRecordService{

    private static final Logger logger = LoggerFactory.getLogger(ItemUpRecordServiceImpl.class);

    @Resource(name = "tae_mall_shiguGoodsTinyMapper")
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    private TaobaoSessionMapMapper taobaoSessionMapMapper;

    @Autowired
    private StarCaculateService starCaculateService;

    @Autowired
    private GoodsUpCountForsearchMapper goodsUpCountForsearchMapper;

    @Autowired
    RedisIO redisIO;
    private String goodslistName="bulk_up_to_es";

    @Autowired
    ProducerBean producer;

    @Autowired
    private ShiguNewActivityMapper shiguNewActivityMapper;

    @Autowired
    private ShiguNewActiveParticipantsMapper shiguNewActiveParticipantsMapper;

    @Autowired
    private ShiguNewActivityUpRecordMapper shiguNewActivityUpRecordMapper;

    @Autowired
    private ShiguTaobaocatMapper shiguTaobaocatMapper;

    //上传类目统计前缀
    String CAT_UP_COUNT_INDEX = "count_upload_for_cat_cid_index_";

    final String XZ_APPKEY="21720662";

    /**
     * 添加上传记录到es中
     * @param itemUpRecordVO
     */
    @Override
    public void addItemUpRecord(ItemUpRecordVO itemUpRecordVO) {
        if(itemUpRecordVO == null){
            return;
        }
        itemUpRecordVO.setStatus(0L);

        // 充值送现金活动上传统计
        try {
            countUploadForCash(itemUpRecordVO);
        } catch (Exception e) {
            logger.error("充值送现金活动上传统计发生异常。", e);
        }


        JSONObject goodsUp = JSON.parseObject(JSON.toJSONString(itemUpRecordVO));
        Object supperPiPrice = goodsUp.get("supperPiPrice");
        if (supperPiPrice != null) {
            Double piPrice = Double.valueOf(supperPiPrice.toString()) * 100;
            goodsUp.put("supperPiPrice", piPrice.longValue());
        }
        SimpleElaBean bean = new SimpleElaBean();
        bean.setIndex("shigugoodsup");
        bean.setType(itemUpRecordVO.getWebSite());
        bean.setSource(goodsUp.toJSONString());
//        ElasticRepository elasticRepository = new ElasticRepository();
//        elasticRepository.insert(bean);
        redisIO.rpush(goodslistName,bean);

        //推送消息
        try {
            pushAddMessage(itemUpRecordVO);
//        producer.sendAsync(new Message());
        } catch (Exception e) {
            logger.error("推送消息失败", e);
        }

        //每周类目上传统计
        RankingPeriodEnum periodEnum = RankingPeriodEnum.RANKING_BY_WEEK;
        String formatPrefix = CAT_UP_COUNT_INDEX + getPeriodTimeStamp(-1, periodEnum) + "_";
        String index = formatPrefix + itemUpRecordVO.getCid();
        Long aLong = redisIO.get(index, Long.class);
        if (aLong == null) {
            aLong = 0L;
        }
        aLong++;
        redisIO.putTemp(index,aLong,3600*24*30);
        //添加星星数计算
        if(itemUpRecordVO.getSupperStoreId()!=null){
            try {
                starCaculateService.addItemUp(itemUpRecordVO.getSupperStoreId());
            } catch (Exception e) {
                logger.error("上传后重算星星数失败",e);
            }
        }

        //商品对应上传数加 1
        try {
            this.updateGoodsUpCountForSearchNum(itemUpRecordVO.getSupperGoodsId(),1L);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("上传后商品对应上传数加失败",e);
        }
    }

    /**
     * 修改 商品对应上传数
     * 不存在记录则会新建记录
     * @param goodsId
     * @param num
     */
    @Override
    public void updateGoodsUpCountForSearchNum(long goodsId,long num){
        GoodsUpCountForsearch goodsUpCountForsearch = new GoodsUpCountForsearch();
        goodsUpCountForsearch.setGoodsId(goodsId);
        goodsUpCountForsearch = goodsUpCountForsearchMapper.selectOne(goodsUpCountForsearch);
        if (goodsUpCountForsearch == null) {
            //新增记录
            goodsUpCountForsearch = new GoodsUpCountForsearch();
            goodsUpCountForsearch.setGoodsId(goodsId);
            goodsUpCountForsearch.setGoodsUpNum(num);
            goodsUpCountForsearchMapper.insertSelective(goodsUpCountForsearch);
        }else {
            //更新记录
            long goodsUpNum = goodsUpCountForsearch.getGoodsUpNum() + num;
            goodsUpCountForsearch.setGoodsUpNum(goodsUpNum);
            goodsUpCountForsearchMapper.updateByPrimaryKeySelective(goodsUpCountForsearch);
        }
    }

    /**
     * 修改 商品对应上传数
     * 不存在记录则会新建记录
     * @param goodsIds
     * @param num
     */
    @Override
    public void updateGoodsUpCountForSearchNum(Set<Long> goodsIds, long num){
        goodsUpCountForsearchMapper.updatList(goodsIds,num);
    }

    /**
     * 充值送现金活动上传统计（只统计上传到出售中的男装）
     * @param itemUpRecordVO
     */
    public void countUploadForCash(ItemUpRecordVO itemUpRecordVO) {
        if ("web-tb".equals(itemUpRecordVO.getFlag()) || "tb".equals(itemUpRecordVO.getFlag())) { // pc端或app端上传到淘宝
            if ("onsale".equals(itemUpRecordVO.getApproveStatus()) || "instock".equals(itemUpRecordVO.getApproveStatus())
                    || "onsale_clock".equals(itemUpRecordVO.getApproveStatus())) {
                Date now = new Date();
                ShiguNewActivity activity = getActivityNow(now); // 获取当前活动
                if (activity != null) {
                    if (isMan(itemUpRecordVO.getCid())) { // 男装
                        int type = 1; // 上传到出售中
                        if ("instock".equals(itemUpRecordVO.getApproveStatus())) {
                            type = 2; // 上传到仓库中
                        }
                        // 先保存上传记录，再增加上传数
                        if (saveActivityUpRecord(itemUpRecordVO.getFenUserId(), itemUpRecordVO.getSupperGoodsId(), activity.getId(), now, type)) {
                            increaseUploadNum(itemUpRecordVO.getFenUserId(), activity.getId(), now, type);
                        }
                    }
                }
            }
        }
    }

    /**
     * 保存活动期间的上传记录
     * @return
     */
    private boolean saveActivityUpRecord(Long memberId, Long goodsId, Long activityId, Date now, int type) {
        ShiguNewActivityUpRecordExample example = new ShiguNewActivityUpRecordExample();
        ShiguNewActivityUpRecordExample.Criteria criteria = example.createCriteria();
        criteria.andNewActiveIdEqualTo(activityId).andMemberIdEqualTo(memberId).andGoodsIdEqualTo(goodsId);
        if (type == 1) {
            criteria.andTypeEqualTo(type);
        }
        List list = shiguNewActivityUpRecordMapper.selectByExample(example);
        if (list == null || list.isEmpty()) {
            // 没记录的时候保存
            int count = 0;
            ShiguNewActivityUpRecord record = new ShiguNewActivityUpRecord();
            record.setMemberId(memberId);
            record.setGoodsId(goodsId);
            record.setNewActiveId(activityId);
            record.setType(type);
            record.setGmtCreate(now);
            record.setGmtModify(now);
            try {
                count = shiguNewActivityUpRecordMapper.insert(record);
            } catch (DuplicateKeyException e) {
                // 唯一索引冲突，无需处理
                System.out.println("ShiguNewActivityUpRecord唯一索引冲突，记录一下看看，无需处理: " + record);
            }
            return count == 1; // 等于1表示保存成功
        }
        return false;
    }

    /**
     * 增加用户的上传记录数
     */
    private void increaseUploadNum(Long memberId, Long activityId, Date now, int type) {
        int count;
        if (type == 1) {
            count = shiguNewActiveParticipantsMapper.increaseUploadNum(memberId, activityId);
        } else {
            count = shiguNewActiveParticipantsMapper.increaseUploadStoreNum(memberId, activityId);
        }
        if (count < 1) {
            // 数据库中不存在记录，则新增
            ShiguNewActiveParticipants participants = new ShiguNewActiveParticipants();
            participants.setMemberId(memberId);
            participants.setNewActiveId(activityId);
            if (type == 1) {
                participants.setGoodsUploadNum(1L);
                participants.setGoodsUploadStoreNum(0L);
            } else {
                participants.setGoodsUploadNum(0L);
                participants.setGoodsUploadStoreNum(1L);
            }
            participants.setWinningStatus(1);
            participants.setGmtCreate(now);
            participants.setGmtModify(now);
            try {
                shiguNewActiveParticipantsMapper.insert(participants);
            } catch (DuplicateKeyException e) {
                // 唯一索引冲突，无需处理
                System.out.println("ShiguNewActiveParticipants唯一索引冲突，记录一下看看，无需处理: " + participants);
            }
        }
    }

    /**
     * 获取当前进行的上传得现金活动
     * @return
     */
    private ShiguNewActivity getActivityNow(Date now) {
        ShiguNewActivity activity = null;
        ShiguNewActivityExample example = new ShiguNewActivityExample();
        example.setEndIndex(0);
        example.setEndIndex(1);
        ShiguNewActivityExample.Criteria criteria = example.createCriteria();
        criteria.andStartTimeLessThanOrEqualTo(now).andEndTimeGreaterThanOrEqualTo(now);
        List<ShiguNewActivity> activityList = shiguNewActivityMapper.selectFieldsByExample(example, "id,title");
        if (activityList != null && !activityList.isEmpty()) {
            activity = activityList.get(0);
        }
        return activity;
    }

    /**
     * 是否男装
     * @param cid
     * @return
     */
    private boolean isMan(Long cid) {
        ShiguTaobaocat cat = shiguTaobaocatMapper.selectByPrimaryKey(cid);
        return cat != null && (cat.getParentCid() == 30L || cat.getCid() == 30L);
    }

    @Override
    public void updateItemUpload(ItemUpRecordVO itemUpRecordVO,String oneKeyId) {
        if(itemUpRecordVO == null || StringUtils.isEmpty(oneKeyId)){
            return;
        }
        itemUpRecordVO.setStatus(0L);
        itemUpRecordVO.setTbSoldout(true);
        JSONObject goodsUp = JSON.parseObject(JSON.toJSONString(itemUpRecordVO));
        Object supperPiPrice = goodsUp.get("supperPiPrice");
        if (supperPiPrice != null) {
            Double piPrice = Double.valueOf(supperPiPrice.toString()) * 100;
            goodsUp.put("supperPiPrice", piPrice.longValue());
        }
        SimpleElaBean bean = new SimpleElaBean();
        bean.setIndex("shigugoodsup");
        bean.setType(itemUpRecordVO.getWebSite());
        bean.setSource(goodsUp.toJSONString());
        bean.setPk(oneKeyId);
        redisIO.rpush(goodslistName,bean);
    }



    /**
     * 添加消息
     * @param itemUpRecordVO
     */
    public void pushAddMessage(ItemUpRecordVO itemUpRecordVO){
        producer.sendOneway(new Message("ONEKEY_UPLOAD", itemUpRecordVO.getFlag()
                , itemUpRecordVO.getSupperGoodsId().toString(), JSONObject.toJSON(itemUpRecordVO).toString().getBytes()));
    }

    /**
     * 用户对某件商品的最后一次上传时间
     * @param userId
     * @param supperGoodsId
     * @return
     */
    @Override
    public LastUploadedVO selLastUpByIds(Long userId, Long supperGoodsId) {
        if(userId == null || supperGoodsId == null){
            return null;
        }
        try {
            SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
            BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();
            QueryBuilder query = QueryBuilders.termQuery("fenUserId", userId);
            boleanQueryBuilder.must(query);
            BoolQueryBuilder flagbool=QueryBuilders.boolQuery();
            QueryBuilder flagQuery=QueryBuilders.termQuery("flag","web-tb");
            flagbool.should(flagQuery);
            flagbool.should(QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("flag")));
            flagbool.minimumNumberShouldMatch(1);
            boleanQueryBuilder.must(flagbool);
            QueryBuilder queryGoods = QueryBuilders.termQuery("supperGoodsId", supperGoodsId);
            boleanQueryBuilder.must(queryGoods);
            QueryBuilder stautsQuery = QueryBuilders.termQuery("status", 0);
            boleanQueryBuilder.must(stautsQuery);
            srb.addSort("daiTime", SortOrder.DESC);
            srb.setSize(1);
            srb.setQuery(boleanQueryBuilder);
            SearchResponse response = srb.execute().actionGet();
            SearchHit[] hits = response.getHits().getHits();
            if (hits == null || hits.length == 0) {
                return null;
            }
            SearchHit hit = hits[0];
            ItemUpRecordVO shiguGoodsUp = JSON.parseObject(hit.getSourceAsString(), ItemUpRecordVO.class);
            Date daitime = DateUtil.stringToDate(shiguGoodsUp.getDaiTime(),DateUtil.patternD);
            LastUploadedVO vo=new LastUploadedVO();
            vo.setLastTime(daitime);
            vo.setNumIid(shiguGoodsUp.getFenNumiid());
            return vo;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 用户对某件商品的最后一次上传时间
     * @param userId
     * @param supperGoodsId
     * @return
     */
    @Override
    public LastUploadedVO selLastUpByIds(Long userId, Long supperGoodsId,GoodsUploadFlagEnum flag) {
        if(userId == null || supperGoodsId == null){
            return null;
        }
        try {
            SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
            BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();
            QueryBuilder query = QueryBuilders.termQuery("fenUserId", userId);
            boleanQueryBuilder.must(query);
            BoolQueryBuilder flagbool=QueryBuilders.boolQuery();
            QueryBuilder flagQuery=QueryBuilders.termQuery("flag",flag);
            flagbool.should(flagQuery);
            flagbool.should(QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("flag")));
            flagbool.minimumNumberShouldMatch(1);
            boleanQueryBuilder.must(flagbool);
            QueryBuilder queryGoods = QueryBuilders.termQuery("supperGoodsId", supperGoodsId);
            boleanQueryBuilder.must(queryGoods);
            QueryBuilder stautsQuery = QueryBuilders.termQuery("status", 0);
            boleanQueryBuilder.must(stautsQuery);
            srb.addSort("daiTime", SortOrder.DESC);
            srb.setSize(1);
            srb.setQuery(boleanQueryBuilder);
            SearchResponse response = srb.execute().actionGet();
            SearchHit[] hits = response.getHits().getHits();
            if (hits == null || hits.length == 0) {
                return null;
            }
            SearchHit hit = hits[0];
            ItemUpRecordVO shiguGoodsUp = JSON.parseObject(hit.getSourceAsString(), ItemUpRecordVO.class);
            Date daitime = DateUtil.stringToDate(shiguGoodsUp.getDaiTime(),DateUtil.patternD);
            LastUploadedVO vo=new LastUploadedVO();
            vo.setLastTime(daitime);
            vo.setNumIid(shiguGoodsUp.getFenNumiid());
            return vo;
        } catch (Exception e) {
            return null;
        }
    }



    /**
     * 查询已上传的宝贝
     * @param userId 用户ID
     * @param target
     * @param keyword
     * @param fromDate
     * @param toDate
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public ShiguPager<OnekeyRecoreVO> uploadedItems(Long userId, String target, String keyword, Date fromDate, Date toDate, int pageNo, int pageSize) {
        if(userId == null){
            return new ShiguPager<OnekeyRecoreVO>();
        }
        BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();
        // 条件组合
        QueryBuilder query = QueryBuilders.termQuery("fenUserId", userId);
        boleanQueryBuilder.must(query);

        if(!StringUtils.isEmpty(target)){
            QueryBuilder queryTarget = QueryBuilders.termQuery("flag", target);
            boleanQueryBuilder.must(queryTarget);
        }

        if(!StringUtils.isEmpty(keyword)){
            QueryBuilder queryKeywork = QueryBuilders.matchQuery("supperGoodsName", keyword).minimumShouldMatch("90%");
            boleanQueryBuilder.must(queryKeywork);
        }
        QueryBuilder queryStatus = QueryBuilders.termQuery("status", 0);
        boleanQueryBuilder.must(queryStatus);
        return uploadedItemsCommon(boleanQueryBuilder,fromDate,toDate,pageNo,pageSize);
    }

    @Override
    public ShiguPager<OnekeyRecoreVO> uploadedItems(Long userId, String tbNick, String target, String keyword, Date fromDate, Date toDate, int pageNo, int pageSize) {
        if(userId == null){
            return new ShiguPager<OnekeyRecoreVO>();
        }
        BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();
        // 条件组合
        if(tbNick!=null){
            QueryBuilder query = QueryBuilders.termQuery("fenUserId", userId);
            boleanQueryBuilder.should(query);
            QueryBuilder nickQuery=QueryBuilders.termQuery("fenUserNick", tbNick);
            boleanQueryBuilder.should(nickQuery);
            boleanQueryBuilder.minimumNumberShouldMatch(1);
        }else{
            QueryBuilder query = QueryBuilders.termQuery("fenUserId", userId);
            boleanQueryBuilder.must(query);
        }
        if(!StringUtils.isEmpty(target)){
            QueryBuilder queryTarget = QueryBuilders.termQuery("flag", target);
            boleanQueryBuilder.must(queryTarget);
        }

        if(!StringUtils.isEmpty(keyword)){
            QueryBuilder queryKeywork = QueryBuilders.matchQuery("supperGoodsName", keyword).minimumShouldMatch("90%");
            boleanQueryBuilder.must(queryKeywork);
        }

        QueryBuilder queryStatus = QueryBuilders.termQuery("status", 0);
        boleanQueryBuilder.must(queryStatus);
        return uploadedItemsCommon(boleanQueryBuilder,fromDate,toDate,pageNo,pageSize);
    }

    @Override
    public ShiguPager<OnekeyRecoreVO> uploadedItems(Long userId, int type, int pageNo, int pageSize) {
        if(userId == null){
            return new ShiguPager<OnekeyRecoreVO>();
        }
        BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();
        // 条件组合
        QueryBuilder query = QueryBuilders.termQuery("fenUserId", userId);
        boleanQueryBuilder.must(query);

        if(type==2){
            QueryBuilder queryType11=QueryBuilders.termQuery("shopSoldout",true);
            QueryBuilder queryType22 = QueryBuilders.termQuery("tbSoldout", false);

            boleanQueryBuilder.must(queryType11);
            boleanQueryBuilder.must(queryType22);
        }else if(type==3){
            QueryBuilder queryType = QueryBuilders.termQuery("tbSoldout", true);
            boleanQueryBuilder.must(queryType);
        }
        QueryBuilder queryStatus = QueryBuilders.termQuery("status", 0);
        boleanQueryBuilder.must(queryStatus);
        return uploadedItemsCommon(boleanQueryBuilder,null,null,pageNo,pageSize);
    }

    @Override
    public ShiguPager<OnekeyRecoreVO> uploadedItems(Long userId, String tbNick, int type, int pageNo, int pageSize) {
        if(userId == null){
            return new ShiguPager<OnekeyRecoreVO>();
        }
        BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();
        // 条件组合
        if(tbNick!=null){
            QueryBuilder query = QueryBuilders.termQuery("fenUserId", userId);
            boleanQueryBuilder.should(query);
            QueryBuilder nickQuery=QueryBuilders.termQuery("fenUserNick", tbNick);
            boleanQueryBuilder.should(nickQuery);
            boleanQueryBuilder.minimumNumberShouldMatch(1);
        }else{
            QueryBuilder query = QueryBuilders.termQuery("fenUserId", userId);
            boleanQueryBuilder.must(query);
        }
        if(type==2){
            QueryBuilder queryType11=QueryBuilders.termQuery("shopSoldout",true);
            QueryBuilder queryType22 = QueryBuilders.termQuery("tbSoldout", false);

            boleanQueryBuilder.must(queryType11);
            boleanQueryBuilder.must(queryType22);
        }else if(type==3){
            QueryBuilder queryType = QueryBuilders.termQuery("tbSoldout", true);
            boleanQueryBuilder.must(queryType);
        }
        QueryBuilder queryStatus = QueryBuilders.termQuery("status", 0);
        boleanQueryBuilder.must(queryStatus);
        return uploadedItemsCommon(boleanQueryBuilder,null,null,pageNo,pageSize);
    }

    @Override
    public SingleItemUpRecordVO singleUploadedItem(String uploadId) {
        if(StringUtils.isEmpty(uploadId)){
            return null;
        }
        BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();
        QueryBuilder queryId = QueryBuilders.termQuery("_id", uploadId);
        boleanQueryBuilder.must(queryId);
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
        srb.setSize(1);
        srb.setFrom(0);

        srb.setQuery(boleanQueryBuilder);
        // 默认条件
        SearchResponse response = srb.execute().actionGet();
        SearchHit[] hits = response.getHits().getHits();
        if (hits != null && hits.length > 0) {
            SingleItemUpRecordVO shiguGoodsUp = JSON.parseObject(hits[0].getSourceAsString(), SingleItemUpRecordVO.class);
            shiguGoodsUp.setOneKeyId(hits[0].getId());
            return shiguGoodsUp;
        }else{
            return null;
        }
    }

    /**
     * 公共查,已上传
     * @param boleanQueryBuilder
     * @param fromDate
     * @param toDate
     * @param pageNo
     * @param pageSize
     * @return
     */
    public ShiguPager<OnekeyRecoreVO> uploadedItemsCommon(BoolQueryBuilder boleanQueryBuilder,Date fromDate,Date toDate,int pageNo, int pageSize){


        if(pageNo <=0 ){
            pageNo = 1;
        };
        if(pageSize == 0){
            pageSize = 10;
        }

        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");

        if (fromDate != null) {
            RangeQueryBuilder qb = QueryBuilders.rangeQuery("daiTime").from(DateUtil.dateToString(fromDate,DateUtil.patternD));
            if (toDate != null) {
                qb.to(DateUtil.dateToString(toDate,DateUtil.patternD));
            }
            boleanQueryBuilder.must(qb);
        } else {
            if (toDate != null) {
                RangeQueryBuilder qb = QueryBuilders.rangeQuery("daiTime").to(DateUtil.dateToString(toDate,DateUtil.patternD));
                boleanQueryBuilder.must(qb);
            }
        }
        // 分页信息
        int totalrow = pageSize * (pageNo - 1);
        srb.setSize(pageSize);
        srb.setFrom(totalrow);

        srb.setQuery(boleanQueryBuilder);
        // 默认条件
        srb.addSort("daiTime", SortOrder.DESC);


        SearchResponse response = srb.execute().actionGet();
        SearchHit[] hits = response.getHits().getHits();
        List<OnekeyRecoreVO> onekeyRecoreVOList = new ArrayList<OnekeyRecoreVO>();
        if (hits != null && hits.length > 0) {
            for (SearchHit hit : hits) {
                ItemUpRecordVO shiguGoodsUp = JSON.parseObject(hit.getSourceAsString(), ItemUpRecordVO.class);
                if(shiguGoodsUp == null){
                    continue;
                }
                OnekeyRecoreVO onekeyRecoreVO = new OnekeyRecoreVO();
                onekeyRecoreVO.setCreatetime(shiguGoodsUp.getDaiTime());
                onekeyRecoreVO.setCreateDate(DateUtil.stringToDate(shiguGoodsUp.getDaiTime(),DateUtil.patternD));
                onekeyRecoreVO.setId(shiguGoodsUp.getSupperGoodsId());
                onekeyRecoreVO.setImgsrc(shiguGoodsUp.getSupperImage());
                onekeyRecoreVO.setTitle(shiguGoodsUp.getSupperGoodsName());
                onekeyRecoreVO.setWebSite(shiguGoodsUp.getWebSite());
                onekeyRecoreVO.setOnekeyId(hit.getId());
                if(shiguGoodsUp.getWebSite()==null){//有部分坏的,记日志
                    logger.error(shiguGoodsUp.getSupperGoodsId()+" in shigugoodsup has no webSite!!!");
//                    continue;//跳过
                    shiguGoodsUp.setWebSite("hz");//暂时认为是杭州站 的
                }

                Long goodsId = shiguGoodsUp.getSupperGoodsId();
                ShiguGoodsTiny queryGoodsTiny = new ShiguGoodsTiny();
                queryGoodsTiny.setGoodsId(goodsId);
                queryGoodsTiny.setWebSite(shiguGoodsUp.getWebSite());
                ShiguGoodsTiny shiguGoodsTiny = shiguGoodsTinyMapper.selectOne(queryGoodsTiny);
                if(shiguGoodsTiny != null){
                    onekeyRecoreVO.setLiprice(shiguGoodsTiny.getPriceString());
                    onekeyRecoreVO.setPiprice(shiguGoodsTiny.getPiPriceString());
                }else{
                    onekeyRecoreVO.setLiprice(MoneyUtil.dealPrice(MoneyUtil.StringToLong(shiguGoodsUp.getFenPrice())));
                    onekeyRecoreVO.setPiprice(shiguGoodsUp.getSupperPrice());
                }
                onekeyRecoreVOList.add(onekeyRecoreVO);
            }
        }

        // 查询总记录数
        srb.setSearchType(SearchType.COUNT);
        response = srb.execute().actionGet();
        Long total = response.getHits().getTotalHits();

        ShiguPager<OnekeyRecoreVO> shiguPager = new ShiguPager<OnekeyRecoreVO>();
        shiguPager.setNumber(pageNo);
        shiguPager.setContent(onekeyRecoreVOList);
        shiguPager.calPages(total.intValue(), pageSize);
        return shiguPager;
    }

    /**
     * 删除一键上传记录(逻辑删除)
     * @param userId 用户ID
     * @param onekeyIds 已上传商品主键
     */
    @Override
    public void deleteUploadedItems(Long userId, List<String> onekeyIds) throws Main4Exception {
        if(userId == null || onekeyIds == null || onekeyIds.size() == 0){
            return;
        }
        BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();
        QueryBuilder queryBuilder = QueryBuilders.termQuery("fenUserId" ,userId);
        boleanQueryBuilder.must(queryBuilder);
        deleteUploadedItemsCommon(onekeyIds,boleanQueryBuilder);
    }

    /**
     * 也可以按nick删除
     * @param userId
     * @param nick
     * @param onekeyIds
     * @throws Main4Exception
     */
    @Override
    public void deleteUploadedItems(Long userId, String nick, List<String> onekeyIds) throws Main4Exception {
        if( onekeyIds == null || onekeyIds.size() == 0||userId==null&&nick==null){
            return;
        }
        BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();
        if(nick!=null){
            QueryBuilder queryBuilder = QueryBuilders.termQuery("fenUserId" ,userId);
            boleanQueryBuilder.should(queryBuilder);
            QueryBuilder nickQuery=QueryBuilders.termQuery("fenUserNick",nick);
            boleanQueryBuilder.should(nickQuery);
            boleanQueryBuilder.minimumNumberShouldMatch(1);
            deleteUploadedItemsCommon(onekeyIds,boleanQueryBuilder);
        }else{
            deleteUploadedItems(userId,onekeyIds);
        }
    }

    /**
     * 公共删除上传记录
     * @param onekeyIds
     * @param boleanQueryBuilder
     * @throws Main4Exception
     */
    private void deleteUploadedItemsCommon(List<String> onekeyIds,BoolQueryBuilder boleanQueryBuilder) throws Main4Exception {

        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
        srb.setSize(onekeyIds.size());

        QueryBuilder queryStatus = QueryBuilders.termQuery("status" ,0);
        boleanQueryBuilder.must(queryStatus);

        BoolQueryBuilder idsBoolQuery = QueryBuilders.boolQuery();
        for(int i = 0;i < onekeyIds.size() ;i++){
            QueryBuilder queryId = QueryBuilders.termQuery("_id" ,onekeyIds.get(i));
            idsBoolQuery.should(queryId);
        }
        boleanQueryBuilder.must(idsBoolQuery);
        //System.out.println(boleanQueryBuilder);
        srb.setQuery(boleanQueryBuilder);
        SearchResponse response = srb.execute().actionGet();
        SearchHit[] hits = response.getHits().getHits();

        if(hits == null || hits.length == 0){
            return;
        }

        // 批量删除(逻辑删除/批量更新)
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
            if (shiguGoodsUpMap == null) {
                continue;
            }
            shiguGoodsUpMap.put("status", 1);
            source = JSON.toJSONString(shiguGoodsUpMap);
            bulkRequest.add(client.prepareIndex("shigugoodsup"
                    , hit.getType()
                    , hit.getId()).setSource(source));
        }
        try {
            bulkRequest.execute().actionGet();
        } catch (Exception e) {
            logger.error("删除一键上传记录(逻辑删除)>>发生异常>>批量更新es数据>>error:" + e.toString());
            e.printStackTrace();
            throw new Main4Exception("批量删除一键上传记录失败");
        }
    }

    @Override
    public List<HotUpItem> selHotUpItems(Long shopId, Integer size) {
        List<HotUpItem> hotUpItems = new ArrayList<>();
        SearchResponse response = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup").setSearchType(SearchType.COUNT)
                .setQuery(QueryBuilders.termQuery("supperStoreId", shopId))
                .addAggregation(AggregationBuilders.terms("goods").field("supperGoodsId").size(size))
                .execute().actionGet();
        LongTerms goods = response.getAggregations().get("goods");
        for (Terms.Bucket bucket : goods.getBuckets()) {
            SearchResponse itemRes = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup")
                    .setQuery(QueryBuilders.termQuery("supperGoodsId", bucket.getKeyAsString()))
                    .addSort("daiTime", SortOrder.DESC)
                    .setSize(1)
                    .execute().actionGet();
            SearchHit hit = itemRes.getHits().getHits()[0];
            Map<String, Object> source = hit.getSource();
            HotUpItem hotUpItem = new HotUpItem();
            hotUpItems.add(hotUpItem);
            Object supperGoodsId = source.get("supperGoodsId");
            if (supperGoodsId != null) {
                hotUpItem.setGoodsId(Long.valueOf(supperGoodsId.toString()));
            }
            Object supperPrice = source.get("supperPrice");
            if (supperPrice != null) {
                hotUpItem.setPrice(supperPrice.toString());
            }
            Object supperImage = source.get("supperImage");
            if (supperImage != null) {
                hotUpItem.setImgUrl(supperImage.toString());
            }
        }
        return hotUpItems;
    }

    @Override
    public List<NoUpItem> noUpItems(Long shopId, Integer size, Date fromTime) {
        List<NoUpItem> noUpItems = new ArrayList<>();
        List<Long> ids = new ArrayList<>();
        for (Terms.Bucket bucket : aggsUpedByShopAndTime(shopId, fromTime, new Date())) {
            ids.add((Long) bucket.getKeyAsNumber());
        }
        ShiguShop shiguShop;
        if (!ids.isEmpty() && (shiguShop = shiguShopMapper.selectByPrimaryKey(shopId)) != null) {
            ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
            tinyExample.setWebSite(shiguShop.getWebSite());
            tinyExample.setStartIndex(0);
            tinyExample.setEndIndex(size);
            tinyExample.createCriteria().andStoreIdEqualTo(shopId).andGoodsIdNotIn(ids);
            for (ShiguGoodsTiny tiny : shiguGoodsTinyMapper.selectByConditionList(tinyExample)) {
                NoUpItem noUpItem = new NoUpItem();
                noUpItems.add(noUpItem);
                noUpItem.setGoodsId(tiny.getGoodsId());
                noUpItem.setImgUrl(tiny.getPicUrl());
                noUpItem.setPrice(tiny.getPriceString());
            }
        }
        return noUpItems;
    }

    /**
     * select count() from Es. shigugoodsup
     * where supper_store_id=${shop_id}
     * and daiTime>${fromTime} and daiTime<${toTime} 聚合 by supper_goods_id
     * @param shopId
     * @param fromTime
     * @param toTime
     * @return
     */
    @Override
    public int upedItemNum(Long shopId, Date fromTime, Date toTime) {
        return aggsUpedByShopAndTime(shopId, fromTime, toTime).size();
    }

    private List<Terms.Bucket> aggsUpedByShopAndTime(Long shopId, Date fromTime, Date toTime) {
        LongTerms terms = searchUpedByShopAndTime(shopId, fromTime, toTime)
                .addAggregation(AggregationBuilders.terms("goods").field("supperGoodsId").size(10000))
                .execute().actionGet().getAggregations().get("goods");
        return terms.getBuckets();
    }
    private SearchRequestBuilder searchUpedByShopAndTime(Long shopId, Date fromTime, Date toTime) {
        String from = DateFormatUtils.format(fromTime, "yyyy-MM-dd HH:mm:ss");
        String to = DateFormatUtils.format(toTime, "yyyy-MM-dd HH:mm:ss");
        return ElasticConfiguration.searchClient.prepareSearch("shigugoodsup")
                .setSearchType(SearchType.COUNT)
                .setQuery(QueryBuilders.boolQuery()
                        .must(QueryBuilders.termQuery("supperStoreId", shopId))
                        .must(QueryBuilders.rangeQuery("daiTime").gt(from).lt(to)));
    }

    @Override
    public int upedItemTimes(Long shopId, Date fromTime, Date toTime) {
        return (int) searchUpedByShopAndTime(shopId, fromTime, toTime).execute().actionGet().getHits().getTotalHits();
    }

    @Override
    public int countDailiSellerNum(Long shopId) {
        return sellerCount(shopId, null).size();
    }

    /**
     *  查询代理
     * @param shop 档口
     * @param size 代理数量限制
     * @return 代理列表
     */
    private List<Terms.Bucket> sellerCount(Long shop, Integer size) {
        if (size == null)
            size = 1000000;// 默认最大 1,000,000+
        SearchResponse response = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup")
                .setSearchType(SearchType.COUNT)
                .setQuery(QueryBuilders.termQuery("supperStoreId", shop))
                .addAggregation(AggregationBuilders.terms("seller").field("fenUserNick").size(size))
                .execute().actionGet();
        StringTerms seller = response.getAggregations().get("seller");
        return seller.getBuckets();
    }

    @Override
    public List<DataLineVO> dailiSellerLevelLine(Long shopId) {
        List<DataLineVO> vos = new ArrayList<>();
        List<Terms.Bucket> buckets = sellerCount(shopId, 20);
        if (!buckets.isEmpty()) {
            List<String> nicks = new ArrayList<>();
            for (Terms.Bucket bucket : buckets) {
                nicks.add(bucket.getKeyAsString());
            }
            TaobaoSessionMapExample sessionMapExample = new TaobaoSessionMapExample();
            sessionMapExample.createCriteria().andAppkeyEqualTo(XZ_APPKEY).andNickIn(nicks);//TODO: appkey 可能需要个常量保存。
            List<TaobaoSessionMap> taobaoSessionMaps = taobaoSessionMapMapper.selectFieldsByExample(sessionMapExample, FieldUtil.codeFields("tsm_id,nick,remark1"));
            Map<String, TaobaoSessionMap> sessionMap = BeanMapper.list2Map(taobaoSessionMaps, "nick", String.class);

            for (Terms.Bucket bucket : buckets) {
                DataLineVO dataLineVO = new DataLineVO();
                vos.add(dataLineVO);
                dataLineVO.setFlow(((int) bucket.getDocCount()));
                TaobaoSessionMap session = sessionMap.get(bucket.getKeyAsString());
                if (session != null) {
                    String level = "1心";
                    String levelScore = session.getRemark1();
                    int score;
                    if (levelScore != null && (score = Integer.valueOf(levelScore)) > 0) {
                        if (score <= 5) {
                            level = score + "心";
                        } else if (score <= 10) {
                            level = (score - 5) + "钻";
                        } else if (score <= 15) {
                            level = (score - 10) + "冠";
                        } else {
                            level = (score - 15) + "金冠";
                        }
                    }
                    dataLineVO.setDatestr(level);
                }
            }
        }
        return vos;
    }
}
