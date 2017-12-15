package com.shigu.seller.vo;

import com.alibaba.druid.util.StringUtils;
import com.shigu.main4.item.enums.ItemFrom;
import com.shigu.main4.item.vo.OnsaleItem;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 出售中的商品
 * Created by zhaohongbo on 17/3/9.
 */
public class OnsaleItemVO {
    private String goodsNo;

    private String href;

    private Long id;

    private String imgsrc;

    private String price;

    private String title;

    private String type = "手工同步";

    private String count;

    private String price1;

    private String price2;

    private String price3;

    private String time;

    private Boolean tj;

    private Integer isShowcase;

    private Date delistTimeDate;

    private String delistTime;

    private String detailUrlnew;

    private Date loadDate;

    private Date startTime;

    private String styleName;

    private String sid;

    private Integer correlateType;

    private Integer bigPicType;

    private String linkHref;

    private String linkHrefPassword;

    //是否已设置面料 1未设置 2已设置
    private Integer constituentType;
    //面料成分
    private String fabric;
    //里料成分
    private String inFabric;
    //总销量
    private Integer saleCount;
    //已设置的最低零售价
    private String lowestLiPrice;
    //主图视频
    private String goodsVideoUrl;
    //是否已设置主图视频 2已设置
    private Integer goodsVideoType;

    //大图是否关联同货号商品 true是 false否
    private Boolean picLindGoodsNo;
    //商品风格类型，1未设置，2已设置
    private Integer goodsStyleType;
    //已设置的商品风格名称
    private Integer goodsStyleId;
    //风格是否关联同货号商品 true是 false否
    private Boolean styleLinkGoodsNo;
    //视频是否关联同货号商品 true是 false否
    private Boolean videoLinkGoodsNo;


    public Boolean getPicLindGoodsNo() {
        return picLindGoodsNo;
    }

    public void setPicLindGoodsNo(Boolean picLindGoodsNo) {
        this.picLindGoodsNo = picLindGoodsNo;
    }

    public Integer getGoodsStyleType() {
        return goodsStyleType;
    }

    public void setGoodsStyleType(Integer goodsStyleType) {
        this.goodsStyleType = goodsStyleType;
    }

    public Integer getGoodsStyleId() {
        return goodsStyleId;
    }

    public void setGoodsStyleId(Integer goodsStyleId) {
        this.goodsStyleId = goodsStyleId;
    }

    public Boolean getStyleLinkGoodsNo() {
        return styleLinkGoodsNo;
    }

    public void setStyleLinkGoodsNo(Boolean styleLinkGoodsNo) {
        this.styleLinkGoodsNo = styleLinkGoodsNo;
    }

    public Boolean getVideoLinkGoodsNo() {
        return videoLinkGoodsNo;
    }

    public void setVideoLinkGoodsNo(Boolean videoLinkGoodsNo) {
        this.videoLinkGoodsNo = videoLinkGoodsNo;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCorrelateType() {
        return correlateType;
    }

    public void setCorrelateType(Integer correlateType) {
        this.correlateType = correlateType;
    }

    public Integer getBigPicType() {
        return bigPicType;
    }

    public void setBigPicType(Integer bigPicType) {
        this.bigPicType = bigPicType;
    }

    public String getLinkHref() {
        return linkHref;
    }

    public void setLinkHref(String linkHref) {
        this.linkHref = linkHref;
    }

    public String getLinkHrefPassword() {
        return linkHrefPassword;
    }

    public void setLinkHrefPassword(String linkHrefPassword) {
        this.linkHrefPassword = linkHrefPassword;
    }

    public OnsaleItemVO(OnsaleItem onsaleItem) {
        this.setGoodsNo(onsaleItem.getGoodsNo());
        this.setId(onsaleItem.getItemId());
        this.setImgsrc(onsaleItem.getPicUrl());
        this.setPrice(onsaleItem.getPiPrice());
        this.setTitle(onsaleItem.getTitle());
        this.setDetailUrlnew(onsaleItem.getItemFrom().equals(ItemFrom.TAOBAO)?"1":"");
        this.setCount(onsaleItem.getGoodsUpNum()+"");
        this.setPrice1(onsaleItem.getPrice());
        this.setPrice2(onsaleItem.getPiPrice());
        this.setPrice3(onsaleItem.getPrice());
        this.setLoadDate(onsaleItem.getCreated());
        this.setIsShowcase(onsaleItem.getIsShowCase());
        this.setSaleCount(onsaleItem.getSaleCount());
        this.setFabric(onsaleItem.getFabric());
        this.setInFabric(onsaleItem.getInFabric());
        this.setConstituentType(onsaleItem.getConstituentType());
        this.setGoodsVideoUrl(onsaleItem.getGoodsVideoUrl());
        this.setGoodsVideoType(this.getGoodsVideoUrl()==null||"".equals(this.getGoodsVideoUrl())?1:2);
        if (onsaleItem.getGoodsStyleId() == null||StringUtils.isEmpty(onsaleItem.getGoodsStyleId())){
            this.setGoodsStyleId(0);
        }else{
            this.setGoodsStyleId(Integer.valueOf(onsaleItem.getGoodsStyleId()));
        }
        this.setGoodsStyleType(this.getGoodsStyleId() == 0 ? 1:2);
        if (onsaleItem.getHasRetailPriceSet()) {
            this.setLowestLiPrice(onsaleItem.getPrice());
        }
    }

    public Integer getIsShowcase() {
        return isShowcase;
    }

    public void setIsShowcase(Integer isShowcase) {
        if(this.isShowcase == null || this.isShowcase == 0){
            this.tj = false;
        }else{
            this.tj = true;
        }
        this.isShowcase = isShowcase;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getHref() {
        return "http://www.571xz.com/item.htm?id="+this.id;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getPrice() {
        return this.price2;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public String getCount() {
        if(count == null||!isNumeric(count)){
            return "0";
        }
        return count;
    }

    public void setCount(String count) {
        if(count == null||!isNumeric(count)){
            count = "0";
        }
        this.count = count;
    }

    public boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            //System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getTj() {
        if(this.isShowcase == null || this.isShowcase == 0){
            return false;
        }else{
            return true;
        }
    }

    public void setTj(Boolean tj) {
        this.tj = tj;
    }


    public String getDelistTime() {
        return delistTime;
    }

    public void setDelistTime(String delistTime) {
        this.delistTime = delistTime;
    }

    public Date getDelistTimeDate() {
        return delistTimeDate;
    }

    public void setDelistTimeDate(Date delistTimeDate) {
        Date currentTime = delistTimeDate;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        this.delistTime = dateString;
        this.delistTimeDate = delistTimeDate;
    }

    public String getDetailUrlnew() {
        return detailUrlnew;
    }

    public void setDetailUrlnew(String detailUrlnew) {
        if(!StringUtils.isEmpty(detailUrlnew)){
            this.type = "淘宝同步";
        }else{
            this.type = "手工发布";
        }
        this.detailUrlnew = detailUrlnew;
    }


    public Date getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(Date loadDate) {
        if(loadDate == null){
            this.time = "              ";
            return;
        }
        Date currentTime = loadDate;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        this.time = dateString;
        this.loadDate = loadDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        Date currentTime = startTime;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        this.time = dateString;
        this.startTime = startTime;
    }

    public String getPrice3() {
        return price3;
    }

    public void setPrice3(String price3) {
        this.price3 = price3;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Integer getConstituentType() {
        return constituentType;
    }

    public void setConstituentType(Integer constituentType) {
        this.constituentType = constituentType;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getInFabric() {
        return inFabric;
    }

    public void setInFabric(String inFabric) {
        this.inFabric = inFabric;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public String getLowestLiPrice() {
        return lowestLiPrice;
    }

    public void setLowestLiPrice(String lowestLiPrice) {
        this.lowestLiPrice = lowestLiPrice;
    }

    public String getGoodsVideoUrl() {
        return goodsVideoUrl;
    }

    public void setGoodsVideoUrl(String goodsVideoUrl) {
        this.goodsVideoUrl = goodsVideoUrl;
    }

    public Integer getGoodsVideoType() {
        return goodsVideoType;
    }

    public void setGoodsVideoType(Integer goodsVideoType) {
        this.goodsVideoType = goodsVideoType;
    }
}
