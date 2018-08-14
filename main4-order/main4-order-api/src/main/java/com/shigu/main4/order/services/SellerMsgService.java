package com.shigu.main4.order.services;

/**
 * Created by gtx on 2018/7/9.
 * 供应商消息
 * @author gtx
 * @since
 */
public interface SellerMsgService {

    /**
     * 标记为已读消息
     * @param userId
     * @param msgIds
     */
    boolean markReaded(Long userId, String msgIds);

    /**
     * 删除消息
     * @param userId
     * @param msgIds
     */
    boolean deleteMsg(Long userId, String msgIds);

    /**
     * 绑定手机推送信息
     * @param xzUserKey   星座用户标识
     * @param deviceToken 手机唯一码
     * @param pushCid     第三方推送标识
     * @param phoneModel  手机类型 0 安卓 1 IOS
     * @param pushAppId   md5加密后的推送配置的appId
     * @return
     */
    boolean bindPushCid(String xzUserKey,String deviceToken,String pushCid,Integer phoneModel,String pushAppId);

    /**
     * 推送新订单消息
     */
    void pushNewOrderMsg(Long oid);
}
