package com.shigu.main4.activity.mq;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.opentae.data.mall.examples.ShiguTempExample;
import com.opentae.data.mall.interfaces.ShiguTempMapper;
import com.shigu.main4.spread.enums.AutumnNewConstant;
import com.shigu.main4.spread.processes.HitDrawChooser;
import com.shigu.main4.spread.vo.active.draw.ItemUpRecordVOForSpread;
import com.shigu.main4.tools.RedisIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * 发现好货监听
 * Created by zhaohongbo on 17/7/2.
 */
@Service("activeDrawListener")
public class ActiveDrawListener implements MessageListener {

    @Autowired
    RedisIO redisIO;

    @Autowired
    private HitDrawChooser hitDrawChooser;

    List<DrawRule> FAGOODS_RULE;
    List<DrawRule> DAILYFIND_RULE;

    @PostConstruct
    public void init() {
        if (FAGOODS_RULE == null) {
            FAGOODS_RULE = new ArrayList<>();
            FAGOODS_RULE.add(new DrawRule(10, "A4", false));
            FAGOODS_RULE.add(new DrawRule(8, "A3", false));
            FAGOODS_RULE.add(new DrawRule(5, "A2", false));
            FAGOODS_RULE.add(new DrawRule(3, "A1", true));
        }
        if (DAILYFIND_RULE == null) {
            DAILYFIND_RULE = new ArrayList<>();
            DAILYFIND_RULE.add(new DrawRule(5, "B2", false));
            DAILYFIND_RULE.add(new DrawRule(3, "B1", true));
        }
    }

    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        ItemUpRecordVOForSpread itemUpRecordVO = JSON.parseObject(message.getBody(), ItemUpRecordVOForSpread.class);
        //验证是秋装新品
        Date now = new Date();
        if (now.after(AutumnNewConstant.STARTTIME) && now.before(AutumnNewConstant.DEADLINE) && newAutumn(itemUpRecordVO.getSupperGoodsId(), Arrays.asList(AutumnNewConstant.UPLOAD_FLAG))) {
            //只从淘宝电脑端上款
            if ("web-tb".equals(itemUpRecordVO.getFlag())) {
                doChangeNewAutumn(itemUpRecordVO.getFenUserId(), itemUpRecordVO.getSupperGoodsId(), AutumnNewConstant.DRAW_RECORD_FLAG);
            }
        }
        return Action.CommitMessage;

    }


    public void doChangeNewAutumn(Long userId, Long goodsId, String findFlag) {
        final String KEY_IN_REDIS = "ONEKEY_FOR_FINDGOODS_";
        String key = KEY_IN_REDIS + findFlag + "_" + userId;
        //上了新款
        boolean goodsIdAdded = false;
        Set goodsIdSet = redisIO.get(key, Set.class);
        if (goodsIdSet == null) {
            goodsIdSet = new HashSet();
            goodsIdSet.add(goodsId);
            goodsIdAdded = true;
            redisIO.putFixedTemp(key, goodsIdSet, 3600 * 24 * 7);
        } else if (!goodsIdSet.contains(goodsId)) {
            goodsIdSet.add(goodsId);
            goodsIdAdded = true;
            redisIO.putFixedTemp(key, goodsIdSet, 3600 * 24 * 7);
        }
        int upNum = goodsIdSet.size();
        if (goodsIdAdded == true && upNum >= 3) {
            hitDrawChooser.updateQualification(userId, upNum, AutumnNewConstant.CURRENT_ACTIVE);
        }
    }

    /**
     * 中奖规则
     */
    class DrawRule {
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

    public Boolean newAutumn(Long goodsId, List<String> pemFlag) {
        if (goodsId == null) {
            return false;
        }
        ShiguTempExample example = new ShiguTempExample();
        example.createCriteria().andFlagIn(pemFlag).andKey1EqualTo(goodsId.toString());
        return shiguTempMapper.countByExample(example) > 0;
    }

    @Autowired
    private ShiguTempMapper shiguTempMapper;

}
