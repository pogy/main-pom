package com.shigu.main4.order.zfenums;

/**
 * Created by zf on 2017/7/17.
 */
public enum TbOrderStatusEnum {
//    WAIT_BUYER_PAY("WAIT_BUYER_PAY"),//等待买家付款
    WAIT_SELLER_SEND_GOODS("WAIT_SELLER_SEND_GOODS"),//等待卖家发货
//    SELLER_CONSIGNED_PART("SELLER_CONSIGNED_PART"),//卖家部分发货
//    WAIT_BUYER_CONFIRM_GOODS("WAIT_BUYER_CONFIRM_GOODS"),//等待买家确认收货
//    TRADE_BUYER_SIGNED("TRADE_BUYER_SIGNED"),//买家已签收（货到付款专用）
//    TRADE_FINISHED("TRADE_FINISHED"),//交易成功
//    TRADE_CLOSED("TRADE_CLOSED"),//交易关闭
//    TRADE_CLOSED_BY_TAOBAO("TRADE_CLOSED_BY_TAOBAO")//交易被淘宝关闭
    ;

    private String status;
    TbOrderStatusEnum(String status){
        this.status=status;
    }
    @Override
    public String toString(){
        return this.status;
    }
}
