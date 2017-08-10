package com.shigu.main4.daifa.enums;

/**
 * Created by pc on 2017-05-24.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */
public enum DaifaListDealTypeEnum {
    TRADE_SORT("ts","字母+两位数字","交易识别码"),//订单排序码
    GGOODS_CODE("nh","日期_拿货人ID_次数"),
    TK_CODE("tk","tk日期_退货员ID_次数"),
    DAIFA_SEND_CODE("fh","fh日期_sellerId"),
    STOCK_CODE("ck","ck日期_sellerId_次数"),
    OT_CODE("ot","ot日期_sellerId_次数"),
    OTHER_REFUND("or","or日期_sellerId_次数");


    private String tag;//标志
    private String rule;//规则
    private String instruction;//说明


    DaifaListDealTypeEnum(String tag, String rule, String instruction){
        this.tag=tag;
        this.rule=rule;
        this.instruction=instruction;
    }

    DaifaListDealTypeEnum(String tag){
        this.tag=tag;
    }
    DaifaListDealTypeEnum(String tag, String rule){
        this.tag=tag;
        this.rule=rule;
    }
    DaifaListDealTypeEnum(){

    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public static void main(String[] args) {
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
