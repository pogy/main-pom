package com.shigu.daifa.vo;

/**
 * Created By zyl on 2018/9/6 0006/10:36
 */
public class NewFinancialVo {
    /**
     * 当天发货商品金额
     * 当天快递费
     * 当天发货商品服务费
     * 当日退货退款金额
     */
    private String todayGoodsFee;
    private String todayExpressFee;
    private String todayServerFee;
    private String todayRefunFee;

    public String getTodayGoodsFee() {
        return todayGoodsFee;
    }

    public void setTodayGoodsFee(String todayGoodsFee) {
        this.todayGoodsFee = todayGoodsFee;
    }

    public String getTodayExpressFee() {
        return todayExpressFee;
    }

    public void setTodayExpressFee(String todayExpressFee) {
        this.todayExpressFee = todayExpressFee;
    }

    public String getTodayServerFee() {
        return todayServerFee;
    }

    public void setTodayServerFee(String todayServerFee) {
        this.todayServerFee = todayServerFee;
    }

    public String getTodayRefunFee() {
        return todayRefunFee;
    }

    public void setTodayRefunFee(String todayRefunFee) {
        this.todayRefunFee = todayRefunFee;
    }
}
