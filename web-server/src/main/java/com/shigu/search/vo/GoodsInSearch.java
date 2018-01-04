package com.shigu.search.vo;

import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.tools.KeyWordsUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 搜索中的商品
 * Created by zhaohongbo on 17/4/5.
 */
public class GoodsInSearch implements Serializable{
    /**
     * 商品id
     */
    private String id;
    /**
     * 商品标题
     */
    private String title;

    private String highLightTitle;
    /**
     * 商品图片地址，绝对路径
     */
    private String imgsrc;
    /**
     * 商品批发价，格式(12.00)
     */
    private String piprice;
    /**
     * 商品发布时间，格式(5分钟前，2小时前等)
     */
    private String postTimeText;
    /**
     * 商品所属市场档口名全称，空格隔开
     */
    private String fullStoreName;
    /**
     * 浏览量
     */
    private String viewCount;
    /**
     * 阿里旺旺昵称
     */
    private String aliww;
    /**
     * 店铺ID
     */
    private Long storeid;
    /**
     * 货号
     */
    private String goodsNo;
    /**
     * 高亮货号
     */
    private String highLightGoodsNo;
    /**
     * 市场名
     */
    private String marketName;
    /**
     * 档口号
     */
    private String storeNum;

    public GoodsInSearch() {
    }

    /**
     * 货号
     * @return
     */
    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public Long getStoreid() {
        return storeid;
    }

    public void setStoreid(Long storeid) {
        this.storeid = storeid;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        if(StringUtils.isNotBlank(title)){
            title= KeyWordsUtil.duleKeyWords(title);
        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getPostTimeText() {
        return postTimeText;
    }

    public void setPostTimeText(String postTimeText) {
        this.postTimeText = postTimeText;
    }

    public String getFullStoreName() {
        return fullStoreName;
    }

    public void setFullStoreName(String fullStoreName) {
        this.fullStoreName = fullStoreName;
    }

    public String getAliww() {
        return aliww;
    }

    public void setAliww(String aliww) {
        this.aliww = aliww;
    }

    public String getHighLightTitle() {
        return highLightTitle;
    }

    public void setHighLightTitle(String highLightTitle) {
        this.highLightTitle = highLightTitle;
    }

    public String getHighLightGoodsNo() {
        return highLightGoodsNo;
    }

    public void setHighLightGoodsNo(String highLightGoodsNo) {
        this.highLightGoodsNo = highLightGoodsNo;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }
}
