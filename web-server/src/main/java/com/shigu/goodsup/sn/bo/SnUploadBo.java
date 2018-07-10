package com.shigu.goodsup.sn.bo;

public class SnUploadBo {
    private String stuffStatus;
    private String title;
    private String sellPoint;
    private String price;
    private Integer num;
    private String pcContent;
    private Long colorPid;
    private Long sizePid;
    private Long cid;
    private Long uid;
    private Long shopUid;//店铺id
    private Long mid;//商品id
    private Long postage_id;
    private String approve_status;
    private String categoryCode;

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getStuffStatus() {
        return stuffStatus;
    }

    public void setStuffStatus(String stuffStatus) {
        this.stuffStatus = stuffStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getPcContent() {
        return pcContent;
    }

    public void setPcContent(String pcContent) {
        this.pcContent = pcContent;
    }

    public Long getColorPid() {
        return colorPid;
    }

    public void setColorPid(Long colorPid) {
        this.colorPid = colorPid;
    }

    public Long getSizePid() {
        return sizePid;
    }

    public void setSizePid(Long sizePid) {
        this.sizePid = sizePid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getShopUid() {
        return shopUid;
    }

    public void setShopUid(Long shopUid) {
        this.shopUid = shopUid;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Long getPostage_id() {
        return postage_id;
    }

    public void setPostage_id(Long postage_id) {
        this.postage_id = postage_id;
    }

    public String getApprove_status() {
        return approve_status;
    }

    public void setApprove_status(String approve_status) {
        this.approve_status = approve_status;
    }
}
