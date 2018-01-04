package com.shigu.seller.vo;

import com.alibaba.druid.util.StringUtils;
import com.shigu.main4.item.enums.ItemFrom;
import com.shigu.main4.item.vo.InstockItem;
import com.shigu.tools.KeyWordsUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 出售中宝贝/仓库中宝贝VO LIST
 * Created by zhaohongbo on 17/3/12.
 */
public class InstockItemVO {
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

    private String time;

    private Boolean tj;

    private Integer isShowcase;

    private Date delistTimeDate;

    private String delistTime;

    private String detailUrlnew;

    private Date loadDate;

    private Date startTime;

    public InstockItemVO(InstockItem instockItem) {
        setGoodsNo(instockItem.getGoodsNo());
        setId(instockItem.getItemId());
        setImgsrc(instockItem.getPicUrl());
        setPrice2(instockItem.getPiPrice());
        setTitle(instockItem.getTitle());
        if(instockItem!=null){
            if(instockItem.getItemFrom().equals(ItemFrom.TAOBAO)){
                this.type = "淘宝同步";
            }else if(instockItem.getItemFrom().equals(ItemFrom.MEMBER)){
                this.type = "手工发布";
            }else if(instockItem.getItemFrom().equals(ItemFrom.PACKAGE)) {
                this.type = "数据包发布";
            }else{
                this.type = "其它";
            }
        }
//        setDetailUrlnew(instockItem);
//        setCount(instockItem.);
//        setPrice1(instockItem.get);
        setDelistTimeDate(instockItem.getCreated());
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
        if(org.apache.commons.lang3.StringUtils.isNotBlank(title)){
            title= KeyWordsUtil.duleKeyWords(title);
        }
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
        if(delistTimeDate==null)
            return;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.delistTime = formatter.format(delistTimeDate);
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
}
