package com.shigu.main4.cdn.bo;

import com.shigu.tools.EncodeParamter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 店铺类别参数
 * Created by zhaohongbo on 17/3/6.
 */
public class ShopCdnBO implements Serializable{
    /**
     * 店铺ID
     */
    @NotNull(message = "参数异常")
    private Long id;
    /**
     * 页码
     */
    private Integer pageNo;
    /**
     * 每页多少条
     */
    private Integer pageSize=16;
    /**
     * 页面分类,
     * 2全部商品,
     * 4下架商品
     */
    private Integer timeflag;
    /**
     * 店内类目
     */
    private String scid;
    /**
     * 淘宝分类
     */
    private Long cid;
    /**
     * 店内关键词
     */
    private String pstring;
    /**
     * 父类风格id
     */
    private Long spid;
    /**
     * 排序条件
     */
    private String order;
    /**
     * 看仓库时,时间标识
     * all全部
     * month一个月内
     * week一周内
     * day一天内
     */
    private String option;
    /**
     * 价格开始
     */
    private Double beginPrice;
    /**
     * 价格结束
     */
    private Double endPrice;
    /**
     * 几天内
     */
    private Integer dd;

    private String startDate;
    private String endDate;
    private Long diyScid;

    /**
     * 判断是否首页,决定要不要装修
     * @return
     */
    public boolean isIndex(){
        return (pageNo==null||pageNo==1)&&
                timeflag==null&&
                scid==null&&
                cid==null&&
                pstring==null;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getOrder() {
        if(order==null){
            order="time_down";
        }
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPageNo() {
        if(pageNo==null||pageNo<1){
            return 1;
        }
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getTimeflag() {
        return timeflag;
    }

    public void setTimeflag(Integer timeflag) {
        this.timeflag = timeflag;
    }

    public String getScid() {
        return scid;
    }

    public void setScid(String scid) {
        this.scid = scid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getPstring() {
        return pstring;
    }

    public void setPstring(String pstring) {
        if(pstring!=null){
            this.pstring= EncodeParamter.iosToUtf8(pstring);
        }
    }

    public Long getSpid() {
        return spid;
    }

    public void setSpid(Long spid) {
        this.spid = spid;
    }

    public Double getBeginPrice() {
        return beginPrice;
    }

    public void setBeginPrice(Double beginPrice) {
        this.beginPrice = beginPrice;
    }

    public Double getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Double endPrice) {
        this.endPrice = endPrice;
    }

    public Integer getDd() {
        return dd;
    }

    public void setDd(Integer dd) {
        this.dd = dd;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Long getDiyScid() {
        return diyScid;
    }

    public void setDiyScid(Long diyScid) {
        this.diyScid = diyScid;
    }
}
