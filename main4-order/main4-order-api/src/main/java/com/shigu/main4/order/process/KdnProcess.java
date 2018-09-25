package com.shigu.main4.order.process;


import com.shigu.main4.order.vo.KdnPostInfoVO;

/**
 * 快递鸟相关操作
 * Created by bugzy on 2017/8/12 0012.
 */
public interface KdnProcess {
    /**
     * 根据快递鸟的推送更新物流信息
     * @param requestData
     */
    void updatePostInfoByNotify(String requestData);

    /**
     * 根据订单ID获取物流信息
     * @param oid
     */
    KdnPostInfoVO selPostInfoByOid(Long oid);

    /**
     * 根据快递单号获取物流信息
     * @param expressCode
     */
    KdnPostInfoVO selPostInfoByExpressCode(String expressCode);
}
