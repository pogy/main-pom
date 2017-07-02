package com.shigu.activity.service;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.opentae.data.mall.beans.ActiveDrawGoods;
import com.opentae.data.mall.beans.ActiveDrawRecord;
import com.opentae.data.mall.interfaces.ActiveDrawRecordMapper;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.spread.service.ActiveDrawService;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawPemVo;
import com.shigu.main4.tools.RedisIO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    RedisIO redisIO;

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
        //1、拿到消息
        //2、验证是否本期发现好货,如果不是,中止
        //3、修改redis,如果有修改,执行4
        //4、验证用户当前应该是怎样一个档次,依靠redis
        //5、加操作
        ItemUpRecordVO itemUpRecordVO = JSON.parseObject(message.getBody(),ItemUpRecordVO.class);
        // 当前期次
        List<ActiveDrawPemVo> activeDrawPemVos = activeDrawServiceImpl.selDrawPemQueList();
//        ActiveDrawPemVo drawPem = activeDrawPemVos.get(0);
        Long pemId=6L;
        // 验证是发现好货商品
        if(activeDrawServiceImpl.findGoods(itemUpRecordVO.getSupperGoodsId(),pemId)||"赵洪波5".equals(itemUpRecordVO.getFenUserNick())){
            doChange(pemId,itemUpRecordVO.getFenUserId(),itemUpRecordVO.getSupperGoodsId(),ActiveDrawGoods.TYPE_FAGOODS);
        }
        //验证是否每日发现
        if(activeDrawServiceImpl.findDaliy(itemUpRecordVO.getSupperGoodsId(),pemId)){
            doChange(pemId,itemUpRecordVO.getFenUserId(),itemUpRecordVO.getSupperGoodsId(),ActiveDrawGoods.TYPE_DAILYFIND);
        }
        return Action.CommitMessage;
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
}
