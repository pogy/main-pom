package com.shigu.daifa.vo;
/**
 *Created By pc on 2017-09-21/16:08
 *
 */
public class ParcelSearchOrderStatisticsVO {
    /**
     * 全部包裹数量
     */
    private String allPackbagNum;
    /**
     * 已匹配订单数量
     */
    private String matchedPackbagNum;
    /**
     * 未匹配订单数量
     */
    private String unmatchPackbagNum;

    public String getAllPackbagNum() {
        return allPackbagNum;
    }

    public void setAllPackbagNum(String allPackbagNum) {
        this.allPackbagNum = allPackbagNum;
    }

    public String getMatchedPackbagNum() {
        return matchedPackbagNum;
    }

    public void setMatchedPackbagNum(String matchedPackbagNum) {
        this.matchedPackbagNum = matchedPackbagNum;
    }

    public String getUnmatchPackbagNum() {
        return unmatchPackbagNum;
    }

    public void setUnmatchPackbagNum(String unmatchPackbagNum) {
        this.unmatchPackbagNum = unmatchPackbagNum;
    }
}
