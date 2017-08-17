package com.shigu.activity.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.opentae.data.mall.beans.ActiveDrawGoods;
import com.opentae.data.mall.beans.ActiveDrawRecord;
import com.opentae.data.mall.beans.ShiguTemp;
import com.opentae.data.mall.examples.ActiveDrawGoodsExample;
import com.opentae.data.mall.examples.ShiguTempExample;
import com.opentae.data.mall.interfaces.ActiveDrawGoodsMapper;
import com.opentae.data.mall.interfaces.ActiveDrawRecordMapper;
import com.opentae.data.mall.interfaces.ShiguTempMapper;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.spread.service.ActiveDrawService;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawPemVo;
import com.shigu.main4.spread.vo.active.draw.NewAutumnDrawVerifyVO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.spread.services.SpreadService;
import com.shigu.spread.vo.ItemSpreadVO;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.index.Term;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 发现好货监听
 * Created by zhaohongbo on 17/7/2.
 */
@Service("activeDrawListener")
public class ActiveDrawListener implements MessageListener {

    @Autowired
    private ActiveDrawService activeDrawServiceImpl;

    @Autowired
    private ActiveDrawRecordMapper activeDrawRecordMapper;

    @Autowired
    private ActiveDrawGoodsMapper activeDrawGoodsMapper;

    @Autowired
    private SpreadService spreadService;//因为广告搬到了风格馆,所以查一下是否风格馆商品

    @Autowired
    RedisIO redisIO;

    @Autowired
    private DrawQualification newAutumnDrawQualification;

    List<DrawRule> FAGOODS_RULE;
    List<DrawRule> DAILYFIND_RULE;

    @PostConstruct
    public void init(){
        if (FAGOODS_RULE==null) {
            FAGOODS_RULE = new ArrayList<>();
            FAGOODS_RULE.add(new DrawRule(10,"A4",false));
            FAGOODS_RULE.add(new DrawRule(8,"A3",false));
            FAGOODS_RULE.add(new DrawRule(5,"A2",false));
            FAGOODS_RULE.add(new DrawRule(3,"A1",true));
        }
        if (DAILYFIND_RULE == null) {
            DAILYFIND_RULE=new ArrayList<>();
            DAILYFIND_RULE.add(new DrawRule(5,"B2",false));
            DAILYFIND_RULE.add(new DrawRule(3,"B1",true));
        }
    }

    final String KEY_IN_REDIS="ONEKEY_FOR_FINDGOODS_";

    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        //doChange(null,userId,null,null);
        //return Action.CommitMessage;

        ///** 发现好货/每日发现抽奖

        //1、拿到消息
        //2、验证是否本期发现好货,如果不是,中止
        //3、修改redis,如果有修改,执行4
        //4、验证用户当前应该是怎样一个档次,依靠redis
        //5、加操作
        ItemUpRecordVO itemUpRecordVO = JSON.parseObject(message.getBody(),ItemUpRecordVO.class);
        // 当前期次
//        List<ActiveDrawPemVo> activeDrawPemVos = activeDrawServiceImpl.selDrawPemQueList();
//        ActiveDrawPemVo drawPem = activeDrawPemVos.get(0);
//        Long pemId=drawPem.getId();
        // 验证是发现好货商品
//        if(findGoods(itemUpRecordVO.getSupperGoodsId(),pemId)){
//            doChange(pemId,itemUpRecordVO.getFenUserId(),itemUpRecordVO.getSupperGoodsId(),ActiveDrawGoods.TYPE_FAGOODS);
//        }
        //验证是否每日发现
//        if(findDaliy(itemUpRecordVO.getSupperGoodsId(),pemId)){
//            doChange(pemId,itemUpRecordVO.getFenUserId(),itemUpRecordVO.getSupperGoodsId(),ActiveDrawGoods.TYPE_DAILYFIND);
//        }
        //验证是秋装新品
        if (newAutumn(itemUpRecordVO.getSupperGoodsId(), Arrays.asList(NewAutumnDrawVerifyVO.UPLOAD_FLAG))) {
            //只从淘宝电脑端上款
            if ("web-tb".equals(itemUpRecordVO.getFlag())) {
                doChangeNewAutumn(itemUpRecordVO.getFenUserId(),itemUpRecordVO.getSupperGoodsId(),NewAutumnDrawVerifyVO.DRAW_RECORD_FLAG);
            }
        }
        return Action.CommitMessage;

    }


    public void doChangeNewAutumn(Long userId,Long goodsId,String findFlag) {
        String key=KEY_IN_REDIS+findFlag+"_"+userId;
        //上了新款
        boolean goodsIdAdded = false;
        Set goodsIdSet = redisIO.get(key,Set.class);
        if (goodsIdSet == null) {
            goodsIdSet = new HashSet();
            goodsIdSet.add(goodsId);
            goodsIdAdded = true;
            redisIO.putFixedTemp(key,goodsIdSet,3600*24*10);
        } else if (!goodsIdSet.contains(goodsId)) {
            goodsIdSet.add(goodsId);
            goodsIdAdded = true;
            redisIO.putFixedTemp(key,goodsIdSet,3600*24*10);
        }
        int upNum = goodsIdSet.size();
        if (goodsIdAdded==true&&upNum>=3) {
            newAutumnDrawQualification.updateQualification(userId,upNum);
        }
    }

    /**
     * 改变中奖资格
     * @param pemId 期次ID
     * @param userId 用户ID
     * @param goodsId 商品ID
     * @param findType 发现的类别,好货还是每日
     */
    public void doChange(Long pemId,Long userId,Long goodsId,String findType){

        //1、得出当前上传过的商品数
        //2、找到对应的规则进行修改数据
//        redisIO.putFixedTemp("ONEKEY_FOR_FINDGOODS_"+findType+"_"+pemId+"_"+userId,new HashSet<Long>(),3600*24*8);//先放入再说
        String key=KEY_IN_REDIS+findType+"_"+pemId+"_"+userId;
        Set goodsIdSet=redisIO.get(key,Set.class);
        if (goodsIdSet == null) {
            goodsIdSet=new HashSet();
            goodsIdSet.add(goodsId);
            redisIO.putFixedTemp(key,goodsIdSet,3600*24*8);
        }else if(!goodsIdSet.contains(goodsId.intValue())){
            goodsIdSet.add(goodsId);
            redisIO.putFixedTemp(key,goodsIdSet,3600*24*8);
        }
        //查出次数
        int total=goodsIdSet.size();
        //按规则办事
        List<DrawRule> rules;
        if(findType.equals(ActiveDrawGoods.TYPE_FAGOODS)){
            rules=FAGOODS_RULE;
        }else if(findType.equals(ActiveDrawGoods.TYPE_DAILYFIND)){
            rules=DAILYFIND_RULE;
        }else{
            rules=new ArrayList<>();
        }
        for(DrawRule rule:rules){
            if(rule.getMinUp()>total){
                continue;
            }
            ActiveDrawRecord activeDrawRecord=new ActiveDrawRecord();
            activeDrawRecord.setUserId(userId);
            activeDrawRecord.setPemId(pemId);
            activeDrawRecord.setWard(rule.getTag());
            if(rule.getDefaultDraw()){
                String drawCode = StringUtil.str10To37Str();
                activeDrawRecord.setDrawStatus(ActiveDrawRecord.DRAW_STATUS_YES);
                activeDrawRecord.setDrawCode(drawCode);
            }else{
                activeDrawRecord.setDrawStatus(ActiveDrawRecord.DRAW_STATUS_WAIT);
            }
            addActiveDrawRecord(activeDrawRecord);
            break;
        }
    }

    /**
     * 新增用户抽奖
     * @param activeDrawRecord
     */
    public void addActiveDrawRecord(ActiveDrawRecord activeDrawRecord){
        if(activeDrawRecord == null || activeDrawRecord.getPemId() == null ||
                activeDrawRecord.getUserId() == null || StringUtils.isEmpty(activeDrawRecord.getWard())){
            return;
        }
        ActiveDrawRecord drawRecord = new ActiveDrawRecord();
        drawRecord.setPemId(activeDrawRecord.getPemId());
        drawRecord.setUserId(activeDrawRecord.getUserId());
        activeDrawRecord.setEnabled(false);
        activeDrawRecord.setReceivesYes(false);
        activeDrawRecord.setCreateTime(new Date());
        activeDrawRecord.setModifyTime(new Date());
        drawRecord.setWard(activeDrawRecord.getWard());
        int count = activeDrawRecordMapper.selectCount(drawRecord);
        if(count > 0){
            // 已经新增数据
            return;
        }
        activeDrawRecordMapper.insertSelective(activeDrawRecord);
    }



    /**
     * 中奖规则
     */
    class DrawRule{
        private Integer minUp;
        private String tag;//中奖类别
        private Boolean defaultDraw;

        public DrawRule() {
        }

        public DrawRule(Integer minUp, String tag, Boolean defaultDraw) {
            this.minUp = minUp;
            this.tag = tag;
            this.defaultDraw = defaultDraw;
        }

        public Integer getMinUp() {
            return minUp;
        }

        public void setMinUp(Integer minUp) {
            this.minUp = minUp;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public Boolean getDefaultDraw() {
            return defaultDraw;
        }

        public void setDefaultDraw(Boolean defaultDraw) {
            this.defaultDraw = defaultDraw;
        }
    }

    /**
     * 是否好货
     * @param goodsId
     * @param pemId
     * @return
     */
    public Boolean findGoods(Long goodsId, Long pemId) {
        List<ItemSpreadVO> items=spreadService.selItemSpreads("hz", SpreadEnum.MAN_FG).selObj();
        for(ItemSpreadVO isvo:items){
            if(isvo.getId()!=null&&goodsId!=null&&isvo.getId().equals(goodsId.toString())){
                return true;
            }
        }
        //搜索
        items=spreadService.selItemSpreads("hz", SpreadEnum.MAN_RM).selObj();
        for(ItemSpreadVO isvo:items){
            if(isvo.getId()!=null&&goodsId!=null&&isvo.getId().equals(goodsId.toString())){
                return true;
            }
        }
        return false;
    }

    /**
     * 是否每日发现
     * @param goodsId
     * @param pemId
     * @return
     */
    public Boolean findDaliy(Long goodsId, Long pemId) {
        ActiveDrawGoodsExample example=new ActiveDrawGoodsExample();
        example.createCriteria().andPemIdEqualTo(pemId).andGoodsIdEqualTo(goodsId).andTypeEqualTo(ActiveDrawGoods.TYPE_DAILYFIND);
        return activeDrawGoodsMapper.countByExample(example)>0;
    }

    public Boolean newAutumn(Long goodsId, List<String> pemFlag) {
        if (goodsId == null) {
            return false;
        }
        ShiguTempExample example = new ShiguTempExample();
        example.createCriteria().andFlagIn(pemFlag).andKey1EqualTo(goodsId.toString());
        return shiguTempMapper.countByExample(example)>0;
    }

    @Autowired
    private ShiguTempMapper shiguTempMapper;
    public String signUp(String flag, Long userId, Long shopId){
        if (userId==null||shopId==null){
            return "您还没有店铺";
        }
        ShiguTempExample shiguTempExample =new ShiguTempExample();
        shiguTempExample.createCriteria().andKey1EqualTo(userId.toString()).andKey2EqualTo(shopId.toString());
        List<ShiguTemp> temps = shiguTempMapper.selectByExample(shiguTempExample);
        if (temps.size()>0){
            return "您已经报过名了";
        }
        ShiguTemp shiguTemp=new ShiguTemp();
        shiguTemp.setFlag(flag);
        shiguTemp.setKey1(userId.toString());
        shiguTemp.setKey2(shopId.toString());
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        shiguTemp.setKey3(dateFormat.format(new Date()));
        shiguTempMapper.insertSelective(shiguTemp);
        return "true";
    }
    public boolean checkSignUp(Long userId,Long shopId) {
        ShiguTempExample shiguTempExample=new ShiguTempExample();
        shiguTempExample.createCriteria().andKey1EqualTo(userId.toString()).andKey2EqualTo(shopId.toString());
        List<ShiguTemp> temps = shiguTempMapper.selectByExample(shiguTempExample);
        if (temps.size()>0){
            return true;
        }
        return false;
    }

    //中奖资格数据初始化
    //public void initData() throws ParseException {
    //    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //    Date date = sdf.parse("2017-08-12 01:00:00");
    //    SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup").setSize(10000);
    //    BoolQueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("flag", "web-tb"))
    //            .must(QueryBuilders.rangeQuery("daiTime").from("2017-08-16 00:00:00").to("2017-08-17 00:00:00"));
    //
    //    SearchResponse searchResponse = srb.setTypes("hz").setQuery(query).execute().actionGet();
    //    SearchHit[] hits = searchResponse.getHits().getHits();
    //    int count=0;
    //    for (SearchHit hit : hits) {
    //        ItemUpRecordVO itemUpRecordVO = JSON.parseObject(hit.getSourceAsString(), ItemUpRecordVO.class);
    //        if (newAutumn(itemUpRecordVO.getSupperGoodsId(), Arrays.asList(NewAutumnDrawVerifyVO.UPLOAD_FLAG))) {
    //            //只从淘宝电脑端上款
    //            if ("web-tb".equals(itemUpRecordVO.getFlag())) {
    //                doChangeNewAutumn(itemUpRecordVO.getFenUserId(),itemUpRecordVO.getSupperGoodsId(),NewAutumnDrawVerifyVO.DRAW_RECORD_FLAG);
    //
    //            }
    //        }
    //        System.out.print(++count);
    //        System.out.println(':');
    //        System.out.println(itemUpRecordVO.getSupperGoodsId());
    //    }
    //}
}
