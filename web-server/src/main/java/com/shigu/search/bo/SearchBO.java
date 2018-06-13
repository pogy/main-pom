package com.shigu.search.bo;

import java.io.Serializable;

/**
 * 搜索的bo
 * Created by zhaohongbo on 17/4/6.
 */
public class SearchBO extends PageInSearchBO implements Serializable{
    private String from;
    /**
     * 站点
     */
    private String webSite="hz";
    /**
     * 市场ID
     */
    private Long mid;
    /**
     * 一级类目
     */
    private Long pid;
    /**
     * 二级类目
     */
    private Long cid;
    /**
     * 排序类型
     */
    private String sort;
    /**
     * 对应时间内发布的商品，d为天数
     */
    private Integer d;
    /**
     * 筛选开始价格
     */
    private Double sp;
    /**
     * 筛选结束价格
     */
    private Double ep;
    /**
     * 开始时间
     */
    private String st;
    /**
     * 结束时间
     */
    private String et;
    /**
     * 筛选关键字
     */
    private String keyword;
    /**
     * 当值为1时，开启大图筛选
     */
    private Integer bpic;
    /**
     * 值为1时，筛选带视频的商品
     */
    private Integer goodsVideo;

    /**
     * 自定义搜索名
     */
    private String cname;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getD() {
        return d;
    }

    public void setD(Integer d) {
        this.d = d;
    }

    public Double getSp() {
        return sp;
    }

    public void setSp(Double sp) {
        this.sp = sp;
    }

    public Double getEp() {
        return ep;
    }

    public void setEp(Double ep) {
        this.ep = ep;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getEt() {
        return et;
    }

    public void setEt(String et) {
        this.et = et;
    }

    public Integer getBpic() {
        return bpic;
    }

    public void setBpic(Integer bpic) {
        this.bpic = bpic;
    }

    public Integer getGoodsVideo() {
        return goodsVideo;
    }

    public void setGoodsVideo(Integer goodsVideo) {
        this.goodsVideo = goodsVideo;
    }
}
