package com.shigu.main4.order.enums;

/**
 * Created by gtx on 2018/5/2.
 * 订单终端来源
 * @author gtx
 * @description
 * @since
 */
public enum OrderFrom {
    PC(1,"来自PC端的定单"),
    APP(2,"来自APP端的定单"),
    WAP(3,"来自WAP端的定单"),
    WX(4,"来自WX端的定单"),


    ;

    private int from;
    private String description;

    OrderFrom(int from, String description) {
        this.from = from;
        this.description = description;
    }

    public static OrderFrom valueOf(int form){
        for (OrderFrom item : OrderFrom.values()){
            if (item.getFrom() == form) {
                return item;
            }
        }
        throw new IllegalArgumentException("未知的订单来源");
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
