package com.shigu.main4.order.model;

import com.shigu.main4.order.vo.LogisticsTemplateVO;
import com.shigu.main4.order.vo.SenderVO;

import java.util.List;

/**
 * 发货单位
 * Created by zhaohongbo on 17/7/18.
 */
public interface Sender {

    /**
     * 发货机构信息
     */
    SenderVO senderInfo();
    /**
     * 发货
     */
    void sendOrder(Long oid,String logisticsCode);//发放订单给代发

    /**
     * 查询发货单位的快递模板
     * @return
     */
    List<LogisticsTemplateVO> selTemplate();//查询发货单位的快递模板

    /**
     * 生效的快递模板
     * 如果没有,取系统默认
     * 系统默认的是sender_id=-1
     * @return
     */
    LogisticsTemplateVO usedTemplate();

}
