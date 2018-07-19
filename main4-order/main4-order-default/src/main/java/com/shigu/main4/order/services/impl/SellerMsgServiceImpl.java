package com.shigu.main4.order.services.impl;


import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ItemOrderExample;
import com.opentae.data.mall.examples.ShiguPhonePushMarkExample;
import com.opentae.data.mall.examples.ShiguSellerAppMsgExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.common.push.commons.MD5Attestation;
import com.shigu.common.push.event.PushData;
import com.shigu.common.push.event.PushEvent;
import com.shigu.common.push.services.PushMsgService;
import com.shigu.common.push.services.PushMsgServicesManager;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.order.bo.NewOrderMsg;
import com.shigu.main4.order.bo.NewOrderTransparentMsg;
import com.shigu.main4.order.services.SellerMsgService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by gtx on 2018/7/9.
 * 供应商消息
 * @author gtx
 * @since
 */
@Service("sellerMsgService")
public class SellerMsgServiceImpl implements SellerMsgService {

    @Resource(name = "tae_mall_shiguSellerAppMsgMapper")
    private ShiguSellerAppMsgMapper shiguSellerAppMsgMapper;
    @Resource(name = "tae_mall_shiguPhonePushMarkMapper")
    private ShiguPhonePushMarkMapper shiguPhonePushMarkMapper;
    @Resource(name = "tae_mall_itemOrderSubMapper")
    private ItemOrderSubMapper itemOrderSubMapper;
    @Resource(name = "tae_mall_itemOrderMapper")
    private ItemOrderMapper itemOrderMapper;
    @Resource(name = "pushMsgServiceManager")
    private PushMsgServicesManager pushMsgServiceManager;
    @Resource(name = "tae_mall_shiguShopMapper")
    private ShiguShopMapper shiguShopMapper;

    /**
     * 标记为已读消息
     * @param userId
     * @param msgIds
     */
    @Override
    public boolean markReaded(Long userId, String msgIds) {
        if (userId == null) {
            return false;
        }
        List<Long> ids = null;
        if ((StringUtils.isNotBlank(msgIds))) {
            String[] split = msgIds.split(",");
            if (split != null && split.length > 0) {
                ids = Arrays.stream(split).filter(item->StringUtils.isNotBlank(item))
                        .map(item -> Long.parseLong(item)).collect(Collectors.toList());
            }
        }

        ShiguSellerAppMsgExample example = new ShiguSellerAppMsgExample();
        ShiguSellerAppMsgExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        if (ids != null && ids.size() > 0) {
            criteria.andIdIn(ids);
        }

        ShiguSellerAppMsg shiguSellerAppMsg = new ShiguSellerAppMsg();
        shiguSellerAppMsg.setMsgStatus(1);
        shiguSellerAppMsg.setGmtModify(new Date());
        shiguSellerAppMsgMapper.updateByExampleSelective(shiguSellerAppMsg,example);

        return true;
    }

    /**
     * 删除消息
     * @param userId
     * @param msgIds
     */
    @Override
    public boolean deleteMsg(Long userId, String msgIds) {
        if (userId == null) {
            return false;
        }
        List<Long> ids = null;
        if ((StringUtils.isNotBlank(msgIds))) {
            String[] split = msgIds.split(",");
            if (split != null && split.length > 0) {
                ids = Arrays.stream(split).filter(item->StringUtils.isNotBlank(item))
                        .map(item -> Long.parseLong(item)).collect(Collectors.toList());
            }
        }

        ShiguSellerAppMsgExample example = new ShiguSellerAppMsgExample();
        ShiguSellerAppMsgExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        if (ids != null && ids.size() > 0) {
            criteria.andIdIn(ids);
        }
        shiguSellerAppMsgMapper.deleteByExample(example);

        return true;
    }

    /**
     * 绑定手机推送信息
     * @param xzUserKey   星座用户标识
     * @param deviceToken 手机唯一码
     * @param pushCid     第三方推送标识
     * @param phoneModel  手机类型 0 安卓 1 IOS
     * @param pushAppId   md5加密后的推送配置的appId
     * @return
     */
    @Override
    public boolean bindPushCid(String xzUserKey,String deviceToken,String pushCid,Integer phoneModel,String pushAppId){
        ShiguPhonePushMark shiguPhonePushMark = new ShiguPhonePushMark();
        shiguPhonePushMark.setDeviceToken(deviceToken);

        shiguPhonePushMark = shiguPhonePushMarkMapper.selectOne(shiguPhonePushMark);
        Date now = new Date();
        if (shiguPhonePushMark == null) {
            shiguPhonePushMark = new ShiguPhonePushMark();
            shiguPhonePushMark.setDeviceToken(deviceToken);
            shiguPhonePushMark.setXzUserKey(xzUserKey);
            shiguPhonePushMark.setPushCid(pushCid);
            shiguPhonePushMark.setPhoneModel(phoneModel);
            shiguPhonePushMark.setPushAppId(pushAppId);
            shiguPhonePushMark.setGmtCreate(now);
            shiguPhonePushMark.setGmtModify(now);

            shiguPhonePushMarkMapper.insert(shiguPhonePushMark);
        }else {
            shiguPhonePushMark.setXzUserKey(xzUserKey);
            shiguPhonePushMark.setPushCid(pushCid);
            shiguPhonePushMark.setPhoneModel(phoneModel);
            shiguPhonePushMark.setPushAppId(pushAppId);
            shiguPhonePushMark.setGmtModify(now);

            shiguPhonePushMarkMapper.updateByPrimaryKeySelective(shiguPhonePushMark);
        }

        return true;
    }

    /**
     * 推送新订单消息
     * @param oid 订单ID
     */
    @Override
    @Async
    public void pushNewOrderMsg(Long oid) {
        ItemOrder itemOrder = itemOrderMapper.selectFieldsByPrimaryKey(oid, FieldUtil.codeFields("oid,pay_time"));
        if (itemOrder == null) {
            return;
        }
        if (itemOrder.getPayTime() == null) {
            itemOrder.setPayTime(new Date());
        }
        ItemOrderExample example = new ItemOrderExample();
        example.createCriteria().andOidEqualTo(oid);
        List<ItemOrderSub> itemOrderSubs = itemOrderSubMapper.selectFieldsByExample(example,
                FieldUtil.codeFields("soid,shop_id,num,goods_no,color,size,num,should_pay_money"));
        if (itemOrderSubs == null || itemOrderSubs.isEmpty()) {
            return;
        }

        Set<Long> shopIds = itemOrderSubs.stream().map(ItemOrderSub::getShopId).collect(Collectors.toSet());
        Set<String> xzUserKeys = itemOrderSubs.stream().map(item->"shop"+String.valueOf(item.getShopId())).collect(Collectors.toSet());
        ShiguShopExample shiguShopExample = new ShiguShopExample();
        shiguShopExample.createCriteria().andShopIdIn(new ArrayList<>(shopIds));
        List<ShiguShop> shiguShops = shiguShopMapper.selectFieldsByExample(shiguShopExample, FieldUtil.codeFields("shop_id,user_id"));
        Map<String, ShiguShop> shopUserMap = shiguShops.stream()
                .collect(Collectors.toMap(item -> String.valueOf(item.getShopId()), Function.identity(), (key1, key2) -> key2));


        String payDate = DateUtil.dateToString(itemOrder.getPayTime(), DateUtil.patternC);
        Map<String, List<ItemOrderSub>> shopOrderGroup = itemOrderSubs.stream()
                .collect(Collectors.groupingBy(item -> String.valueOf(item.getShopId())));

        //查出本次订单相关档口安卓cid
        ShiguPhonePushMarkExample shiguPhonePushMarkExample = new ShiguPhonePushMarkExample();
        shiguPhonePushMarkExample.createCriteria().andPhoneModelEqualTo(0).andXzUserKeyIn(new ArrayList<>(xzUserKeys));
        List<ShiguPhonePushMark> shiguPhonePushMarks = shiguPhonePushMarkMapper.selectFieldsByExample(shiguPhonePushMarkExample,
                FieldUtil.codeFields("id,xz_user_key,push_cid,push_app_id"));
        Map<String, List<ShiguPhonePushMark>> cidGroup = shiguPhonePushMarks.stream()
                .collect(Collectors.groupingBy(ShiguPhonePushMark::getXzUserKey));

        String msgTitle = "您有新的代发订单!";
        Date now = new Date();
        for (Map.Entry<String, List<ItemOrderSub>> entry : shopOrderGroup.entrySet()){
            try {
                Long orderPay = 0L;

                List<ItemOrderSub> orderSubs = entry.getValue();
                StringBuffer sendMsg = new StringBuffer();
                StringBuffer goodsNos = new StringBuffer();
                goodsNos.append("货号：");
                Set<String> goodsNoList = orderSubs.stream()
                        .filter(item -> item.getGoodsNo() != null && item.getGoodsNo().trim().length() > 0)
                        .limit(10)
                        .map(ItemOrderSub::getGoodsNo).collect(Collectors.toSet());
                if (goodsNoList == null || goodsNoList.isEmpty()) {
                    goodsNos.append("暂无货号");
                }else {
                    List<String> collect = goodsNoList.stream().limit(5).collect(Collectors.toList());
                    for (int i=0;i<collect.size();i++){
                        if (i == collect.size() - 1) {
                            goodsNos.append(collect.get(i));
                        }else {
                            goodsNos.append(collect.get(i)).append("、");
                        }
                    }
                }

                for (int i =0 ;i< orderSubs.size();i++){
                    ItemOrderSub itemOrderSub = orderSubs.get(i);
                    orderPay += itemOrderSub.getShouldPayMoney();

                    if (i == 2) {//订单信息来2个
                        sendMsg.append("......");
                        break;
                    } else {
                        sendMsg.append("下单时间：").append(payDate).append("，");
                        if (itemOrderSub.getGoodsNo() != null && itemOrderSub.getGoodsNo().trim().length() > 0) {
                            sendMsg.append("货号：").append(itemOrderSub.getGoodsNo()).append("，");
                        }
                        sendMsg.append("颜色：").append(itemOrderSub.getColor()).append("，")
                                .append("尺码：").append(itemOrderSub.getSize()).append("，")
                                .append("件数：").append(itemOrderSub.getNum()).append("，")
                                .append("总价：￥").append(MoneyUtil.dealPrice(itemOrderSub.getShouldPayMoney()));
                    }
                }

                String strShopId = String.valueOf(orderSubs.get(0).getShopId());
                ShiguSellerAppMsgExample shiguSellerAppMsgExample = new ShiguSellerAppMsgExample();
                shiguSellerAppMsgExample.createCriteria()
                        .andUserIdEqualTo(shopUserMap.get(strShopId).getUserId())
                        .andMsgStatusEqualTo(0).andMsgTypeEqualTo(0);

                int badge = shiguSellerAppMsgMapper.countByExample(shiguSellerAppMsgExample);

                List<ShiguPhonePushMark> shiguPhonePushMarksList = cidGroup.get("shop" + strShopId);
                if (shiguPhonePushMarksList == null || shiguPhonePushMarksList.isEmpty()) {
                    return;
                }
                //推消息
                String msgStr = sendMsg.toString();

                //添加消息记录
                ShiguSellerAppMsg shiguSellerAppMsg = new ShiguSellerAppMsg();
                shiguSellerAppMsg.setUserId(shopUserMap.get(strShopId).getUserId());
                shiguSellerAppMsg.setMsgTitle(msgTitle);
                shiguSellerAppMsg.setMsg(msgStr);
                shiguSellerAppMsg.setExtend1(String.valueOf(orderPay));
                shiguSellerAppMsg.setExtend2(goodsNos.toString());
                shiguSellerAppMsg.setMsgStatus(0);
                shiguSellerAppMsg.setMsgType(0);
                shiguSellerAppMsg.setGmtCreate(now);
                shiguSellerAppMsg.setGmtModify(now);

                shiguSellerAppMsgMapper.insert(shiguSellerAppMsg);

                NewOrderMsg newOrderMsg = new NewOrderMsg();
                newOrderMsg.setMsgId(shiguSellerAppMsg.getId());
                newOrderMsg.setMsgTitle(msgTitle);
                newOrderMsg.setMsgStr(msgStr);
                newOrderMsg.setStrShopId(strShopId);
                newOrderMsg.setBadge(badge);
                newOrderMsg.setShiguPhonePushMarksList(shiguPhonePushMarksList);
                this.pushNewOrderMsg(newOrderMsg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 推消息
     * @param newOrderMsg
     */
    private  void pushNewOrderMsg (NewOrderMsg newOrderMsg){
        NewOrderTransparentMsg msg = new NewOrderTransparentMsg();
        msg.setMsgId(newOrderMsg.getMsgId());
        msg.setMsgStr(newOrderMsg.getMsgStr());

        PushData<NewOrderTransparentMsg> pushData = new PushData<>();
        pushData.setTitle(newOrderMsg.getMsgTitle());
        pushData.setPushType(0);
        pushData.setData(msg);
        pushData.setNotifyData(newOrderMsg.getMsgStr());

        PushEvent<String> pushEvent = new PushEvent<>();
        pushEvent.setTarget(newOrderMsg.getStrShopId());
        pushEvent.setData(pushData);


        Integer badge = newOrderMsg.getBadge() == null ? 1 : newOrderMsg.getBadge() +1;
        pushMsgServiceManager.pushTransparentToAlias(pushEvent,badge,String.class);

        Map<String, List<ShiguPhonePushMark>> pushAppIdGroup = newOrderMsg.getShiguPhonePushMarksList().stream()
                .collect(Collectors.groupingBy(ShiguPhonePushMark::getPushAppId));

        Map<String, PushMsgService> pushMsgServicesMap = pushMsgServiceManager.getPushMsgServicesMap();
        for (Map.Entry<String,PushMsgService> pushMsgServiceEntry : pushMsgServicesMap.entrySet()){
            String appId = MD5Attestation.MD5Encode(pushMsgServiceEntry.getValue().getAppId());
            List<ShiguPhonePushMark> shiguPhonePushMarks1 = pushAppIdGroup.get(appId);
            if (shiguPhonePushMarks1 == null || shiguPhonePushMarks1.isEmpty()) {
                continue;
            }
            List<String> cids = shiguPhonePushMarks1.stream().map(ShiguPhonePushMark::getPushCid).collect(Collectors.toList());
            //离线cid
            cids = cids.stream().filter(item -> !pushMsgServiceEntry.getValue().isOnline(item)).collect(Collectors.toList());

            PushEvent<List<String>> notifyPushEvent = new PushEvent<>();
            notifyPushEvent.setTarget(cids);
            notifyPushEvent.setData(pushData);
            pushMsgServiceEntry.getValue().pushNotifyToClientIdList(notifyPushEvent,String.class);
        }
    }

}
