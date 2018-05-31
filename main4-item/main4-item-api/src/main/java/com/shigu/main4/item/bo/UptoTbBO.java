package com.shigu.main4.item.bo;


import java.io.Serializable;

/**
 * 上传给淘宝的参数
 * Created by zhaohongbo on 17/1/18.
 */
public class UptoTbBO implements Serializable{

    /**
     * 新旧
     */
    private String stuffStatus;
    private String kuiSearch;
    /**
     * 标题
     */
    private String title;
    /**
     * 卖点
     */
    private String sellPoint;
    /**
     * 价格
     */
    private String price;
    /**
     * 在售数量
     */
    private Long num;
    /**
     * 外部编号
     */
    private String outerId;
    /**
     * 详情
     */
    private String pcContent;
    /**
     * 省份
     */
    private String prov;
    /**
     * 城市
     */
    private String city;
    /**
     * 快递模板ID
     */
    private Long postage_id;
    /**
     * 体积
     */
    private String item_size;
    /**
     * 重量
     */
    private String item_weight;
    /**
     *
     */
    private Long sub_stock;
    /**
     * 在售状态
     */
    private String approve_status;
    /**
     * 颜色PID
     */
    private Long colorPid;
    /**
     * 尺码PID
     */
    private Long sizePid;
    /**
     * 类目ID
     */
    private Long cid;
    /**
     * 用户淘宝ID
     */
    private Long uid;
    /**
     * 星座店ID
     */
    private Long shopUid;
    /**
     * 商品ID
     */
    private Long mid;

    private String oldToNew;
    /**
     * 默认的色码
     */
    private String colorSizeDefault;

    private Boolean has_invoice;

    private Boolean has_warranty;

    private Boolean sell_promise;

    private Boolean has_showcase;

    private String date;

    private String hour;
    private String minute;

    private Boolean needMakeMobileDesc;

    public String getItem_weight() {
        return item_weight;
    }

    public void setItem_weight(String item_weight) {
        this.item_weight = item_weight;
    }

    public Boolean getNeedMakeMobileDesc() {
        return needMakeMobileDesc;
    }

    public void setNeedMakeMobileDesc(Boolean needMakeMobileDesc) {
        this.needMakeMobileDesc = needMakeMobileDesc;
    }

    public Boolean getHas_invoice() {
        return has_invoice;
    }

    public void setHas_invoice(Boolean has_invoice) {
        this.has_invoice = has_invoice;
    }

    public Boolean getHas_warranty() {
        return has_warranty;
    }

    public void setHas_warranty(Boolean has_warranty) {
        this.has_warranty = has_warranty;
    }

    public Boolean getSell_promise() {
        return sell_promise;
    }

    public void setSell_promise(Boolean sell_promise) {
        this.sell_promise = sell_promise;
    }

    public String getStuffStatus() {
        return stuffStatus;
    }

    public void setStuffStatus(String stuffStatus) {
        this.stuffStatus = stuffStatus;
    }

    public String getKuiSearch() {
        return kuiSearch;
    }

    public void setKuiSearch(String kuiSearch) {
        this.kuiSearch = kuiSearch;
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

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getOuterId() {
        return outerId;
    }

    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }

    public String getPcContent() {
        return pcContent;
    }

    public void setPcContent(String pcContent) {
        this.pcContent = pcContent;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getItem_size() {
        return item_size;
    }

    public void setItem_size(String item_size) {
        this.item_size = item_size;
    }



    public Long getSub_stock() {
        return sub_stock;
    }

    public void setSub_stock(Long sub_stock) {
        this.sub_stock = sub_stock;
    }

    public String getApprove_status() {
        return approve_status;
    }

    public void setApprove_status(String approve_status) {
        this.approve_status = approve_status;
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

    public String getOldToNew() {
        return oldToNew;
    }

    public void setOldToNew(String oldToNew) {
        this.oldToNew = oldToNew;
    }

    public String getColorSizeDefault() {
        return colorSizeDefault;
    }

    public void setColorSizeDefault(String colorSizeDefault) {
        this.colorSizeDefault = colorSizeDefault;
    }

    public Long getPostage_id() {
        return postage_id;
    }

    public void setPostage_id(Long postage_id) {
        this.postage_id = postage_id;
    }

    public Boolean getHas_showcase() {
        return has_showcase;
    }

    public void setHas_showcase(Boolean has_showcase) {
        this.has_showcase = has_showcase;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }
}
