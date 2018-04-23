package com.shigu.daifa.vo;

public class FinancialGoodsFeeDetailVO {
    private Long userId;
    private String userName;
    private String allotmentFee;
    private String haveToTakeFee;
    private String userRefundedFee;
    private boolean userRefundedIsWrong;

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAllotmentFee() {
        return this.allotmentFee;
    }

    public void setAllotmentFee(String allotmentFee) {
        this.allotmentFee = allotmentFee;
    }

    public String getHaveToTakeFee() {
        return this.haveToTakeFee;
    }

    public void setHaveToTakeFee(String haveToTakeFee) {
        this.haveToTakeFee = haveToTakeFee;
    }

    public String getUserRefundedFee() {
        return this.userRefundedFee;
    }

    public void setUserRefundedFee(String userRefundedFee) {
        this.userRefundedFee = userRefundedFee;
    }

    public boolean isUserRefundedIsWrong() {
        return this.userRefundedIsWrong;
    }

    public void setUserRefundedIsWrong(boolean userRefundedIsWrong) {
        this.userRefundedIsWrong = userRefundedIsWrong;
    }
}
