package com.shigu.main4.activity.mq;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.google.common.collect.Lists;
import com.opentae.data.mall.beans.ActiveDrawPem;
import com.opentae.data.mall.beans.MemberLicense;
import com.opentae.data.mall.examples.ActiveDrawPemExample;
import com.opentae.data.mall.interfaces.ActiveDrawPemMapper;
import com.opentae.data.mall.interfaces.MemberLicenseMapper;
import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.model.GoatFactory;
import com.shigu.main4.goat.vo.ItemGoatVO;
import com.shigu.main4.spread.enums.ActiveEnum;
import com.shigu.main4.spread.service.VoucherService;
import com.shigu.main4.spread.vo.active.draw.ItemUpRecordVOForSpread;
import com.shigu.main4.tools.RedisIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    GoatFactory goatFactory;

    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        ItemUpRecordVOForSpread itemUpRecordVO = JSON.parseObject(message.getBody(), ItemUpRecordVOForSpread.class);
        for (ActiveDrawPem activeDrawPem : selCurrentDrawPem()) {
            doUpdateQualification(itemUpRecordVO, ActiveEnum.flagOf(activeDrawPem.getFlag()),activeDrawPem.getId());
        }
        return Action.CommitMessage;
    }

    protected void doUpdateQualification(ItemUpRecordVOForSpread uploadRecord, ActiveEnum activeEnum, Long pemId){
        switch (activeEnum){
            //代金券活动，只有vip用户可以参与
            case VIP_VOUCHER:
                doUpdateVipVoucher(uploadRecord,pemId);
                return;
        }
    }

    @Autowired
    MemberLicenseMapper memberLicenseMapper;

    @Autowired
    VoucherService vipVoucherService;

    protected void doUpdateVipVoucher(ItemUpRecordVOForSpread uploadRecord, Long pemId){
        Long userId = uploadRecord.getFenUserId();
        Long goodsId = uploadRecord.getSupperGoodsId();
        //杭州首页广告商品上传到淘宝
        if ("web-tb".equals(uploadRecord.getFlag())&&currentHzGoatGoodsIds().contains(goodsId)) {
            //vip分销商验证
            MemberLicense queryLicense = new MemberLicense();
            queryLicense.setUserId(userId);
            queryLicense.setLicenseType(7);
            queryLicense.setLicenseFailure(1);
            //有效vip用户
            if (memberLicenseMapper.selectOne(queryLicense) != null) {
                String userUploadSetKey = getUserUploadSetKey(userId, pemId, ActiveEnum.VIP_VOUCHER.name());
                if (checkAndUpdateRedisSet(userUploadSetKey,goodsId)) {
                    int upNum = redisIO.get(userUploadSetKey, Set.class).size();
                    vipVoucherService.obtainVoucher(userId,upNum,pemId);
                }
            }
        }
    }

    protected boolean checkAndUpdateRedisSet(String key,Long goodsId){
        boolean added = false;
        Set set = redisIO.get(key, Set.class);
        if (set == null) {
            set = new HashSet();
        }
        if (!set.contains(goodsId)) {
            set.add(goodsId);
            added = true;
        }
        if (added) {
            redisIO.putFixedTemp(key,set,60*60*24*7);
        }
        return added;
    }

    /**
     * 获取redis中存放用户上传记录的键
     * @param userId
     * @param pemId
     * @param identifyStr
     * @return
     */
    public String getUserUploadSetKey(Long userId,Long pemId,String identifyStr){
        return String.format("ACTIVE_KEY_IN_REDIS_%s%d_%d",identifyStr,pemId,userId);
    }



    /**
     * 获取当前正在进行的活动
     */
    protected List<ActiveDrawPem> selCurrentDrawPem(){
        Date now = new Date();
        ActiveDrawPemExample example = new ActiveDrawPemExample();
        example.createCriteria().andStartTimeLessThan(now).andEndTimeGreaterThan(now);
        return activeDrawPemMapper.selectByExample(example);
    }

    /**
     * 获取当前杭州站首页广告商品id，用作首页上传商品抽奖
     * @return
     */
    protected List<Long> currentHzGoatGoodsIds(){
        String cacheIndex = "HZ_INDEX_GOAT_GOODS_ID_FOR_ACTIVE_DRAW_";
        List<Long> list = redisIO.getList(cacheIndex, Long.class);
        if (list != null) {
            return list;
        }
        //杭州首页商品广告
        ArrayList<String> locationCodes = Lists.newArrayList("MAN-RM", "MAN-FG", "MAN-YS", "MAN-TJDK");
        HashSet<Long> goatGoodsIdSet = new HashSet<>();
        for (String locationCode : locationCodes) {
            try {
                List<ItemGoatVO> goatVOS = goatFactory.getALocation(locationCode).selGoats();
                for (ItemGoatVO goatVO : goatVOS) {
                    goatGoodsIdSet.add(goatVO.getItemId());
                }

            } catch (GoatException e) {
                e.printStackTrace();
            }
        }
        list = new ArrayList<>(goatGoodsIdSet);
        //缓存十分钟
        redisIO.putTemp(cacheIndex,list,60*10);
        return list;
    }

    @Autowired
    private ActiveDrawPemMapper activeDrawPemMapper;

}
