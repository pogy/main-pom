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
}
