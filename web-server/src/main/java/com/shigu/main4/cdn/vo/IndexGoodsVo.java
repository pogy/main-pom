package com.shigu.main4.cdn.vo;


import java.io.Serializable;

/**
 * 首页商品数据VO
 *
 * 现暂时用于濮院站首页
 *
 * @author shigu_zjb
 * @date 2017/05/08 19:06
 *
 */
public class IndexGoodsVo implements Serializable {

    private String id;

    private String title;

    private String parentMarketName;

    private String storeNum;

    private String imgsrc;

    private String piprice;

    private String storeId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParentMarketName() {
        return parentMarketName;
    }

    public void setParentMarketName(String parentMarketName) {
        this.parentMarketName = parentMarketName;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getPiprice() {
        return piprice;
    }

    public void setPiprice(String piprice) {
        this.piprice = piprice;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
}
