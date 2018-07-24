package com.openJar.responses.thirdSupport;

import com.openJar.responses.Response;

/**
 * @ProjectName: main-pom
 * @Package: com.openJar.responses.thirdSupport
 * @ClassName: SelWorkUserGgoodsTasksResponse
 * @Author: sy
 * @CreateDate: 2018/7/19 0019 13:25
 */
public class SelWorkUserGgoodsTasksResponse extends Response {
    //需拿总件数
    private Integer needTakeSumCount;
    //需拿总价格
    private String needTakeSumPrice;
    //已拿总件数
    private Integer haveTakeSumCount;
    //已拿总价格
    private String haveTakeSumPrice;
    //未拿总件数
    private Integer noTakeSumCount;
    //未拿总价格
    private String noTakeSumPrice;
    //缺货总件数
    private Integer stockoutSumCount;
    //缺货总价格
    private String stockoutSumPrice;

    public Integer getNeedTakeSumCount() {
        return needTakeSumCount;
    }

    public void setNeedTakeSumCount(Integer needTakeSumCount) {
        this.needTakeSumCount = needTakeSumCount;
    }

    public String getNeedTakeSumPrice() {
        return needTakeSumPrice;
    }

    public void setNeedTakeSumPrice(String needTakeSumPrice) {
        this.needTakeSumPrice = needTakeSumPrice;
    }

    public Integer getHaveTakeSumCount() {
        return haveTakeSumCount;
    }

    public void setHaveTakeSumCount(Integer haveTakeSumCount) {
        this.haveTakeSumCount = haveTakeSumCount;
    }

    public String getHaveTakeSumPrice() {
        return haveTakeSumPrice;
    }

    public void setHaveTakeSumPrice(String haveTakeSumPrice) {
        this.haveTakeSumPrice = haveTakeSumPrice;
    }

    public Integer getNoTakeSumCount() {
        return noTakeSumCount;
    }

    public void setNoTakeSumCount(Integer noTakeSumCount) {
        this.noTakeSumCount = noTakeSumCount;
    }

    public String getNoTakeSumPrice() {
        return noTakeSumPrice;
    }

    public void setNoTakeSumPrice(String noTakeSumPrice) {
        this.noTakeSumPrice = noTakeSumPrice;
    }

    public Integer getStockoutSumCount() {
        return stockoutSumCount;
    }

    public void setStockoutSumCount(Integer stockoutSumCount) {
        this.stockoutSumCount = stockoutSumCount;
    }

    public String getStockoutSumPrice() {
        return stockoutSumPrice;
    }

    public void setStockoutSumPrice(String stockoutSumPrice) {
        this.stockoutSumPrice = stockoutSumPrice;
    }
}
