package com.shigu.buyer.bo;

import com.shigu.tools.EncodeParamter;

import java.io.Serializable;

/**
 * 一键上传记录
 * Created by zhaohongbo on 17/3/13.
 */
public class OnekeyRecordBO implements Serializable{
    /**
     * 上传商品的状态，1(档口在售)，2(淘宝已下降)，3(历史上传)
     */
    private Integer uploadGoodsState;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 档口出售状态，1(档口在售)，2(档口下架)
     */
    private Integer shopState;
    /**
     * 淘宝出售状态，1(淘宝在售)，2(淘宝下架)
     */
    private Integer tbState;
    /**
     * 一键上传目标：web-tb淘宝上传,imgzip大图下载,wx微信上传,tb老淘宝上传
     */
    private String flag = "web-tb";

    private Integer page;

    private Integer rows=12;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getShopState() {
        return shopState;
    }

    public void setShopState(Integer shopState) {
        this.shopState = shopState;
    }

    public Integer getTbState() {
        return tbState;
    }

    public void setTbState(Integer tbState) {
        this.tbState = tbState;
    }

    public Integer getUploadGoodsState() {
        return uploadGoodsState;
    }

    public void setUploadGoodsState(Integer uploadGoodsState) {
        this.uploadGoodsState = uploadGoodsState;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getPage() {
        if(page==null||page<1){
            return 1;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }



}
