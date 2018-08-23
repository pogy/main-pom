package com.shigu.main4.daifa.enums;

/**
 * Created by zf on 2017/6/16.
 */
public enum DaifaSendMqEnum {
    /**快递设置**/
//    expressChange("express_setting","express_","快递数据更新"),
//    marketChange("market_sale","market_sale_","可售市场"),
//    marketFeeChange("serviceCharge_by_market","serviceCharge_","服务费设置"),
//    allocat("trade_allocate","trade_","配货中"),
    refund("refund_agree","refund_","同意退款"),
    cutOff("stop_trade","stop_trade_","截单"),
//    downOrder("goods_soldout","goods_soldout_","下架"),
    haveDate("have_time","haveTime_","有货时间"),
//    daifaRemark("remark_deal","remark_deal_","代发订单备注"),
//    getGoods("get_goods","get_goods_","拿到货"),
//    stockout("stockout","stockout_","拿不到货"),
    weightSet("weight_set","weight_","重量回写"),
    sendAll("send_all","send_all_","全单发货"),
//    sendPart("send_part","send_part_","部分发货，其他退款"),
    afterSaleAccept("after_sale_accept","after_sale_","授理并返回退货信息"),
//    aftersaleReceive("after_sale_received","after_sale_","收到货","不完全到货"),
//    afterSaleDeal("after_sale_deal","after_sale_","售后处理中"),
//    afterSaleFinished("after_sale_finished","after_sale_","售后完成","售后失败"),
    repriceApply("reprice_apply","apply_","议价"),
    shopRefuse("shop_refuse","refuse_","档口拒绝退货"),
    markDown("mark_down","mark_down_","标记下架"),
    updateExpressCode("update_express_code","update_express_code_","更新快递单号"),


    ;


    DaifaSendMqEnum(String messageTag, String messageKey, String msg){
        this.messageKey=messageKey;
        this.messageTag=messageTag;
        this.msg=msg;
    }
    DaifaSendMqEnum(String messageTag, String messageKey, String msg, String errMsg){
        this.messageKey=messageKey;
        this.messageTag=messageTag;
        this.msg=msg;
        this.errMsg=errMsg;
    }
    DaifaSendMqEnum(String messageTag, String messageKey){
        this.messageKey=messageKey;
        this.messageTag=messageTag;
    }

    private String messageTag;
    private String messageKey;
    private String msg;
    private String errMsg;

    public String getMessageTag() {
        return messageTag;
    }

    public void setMessageTag(String messageTag) {
        this.messageTag = messageTag;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
