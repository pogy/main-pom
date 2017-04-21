package com.shigu.seller.vo;

import com.shigu.tb.finder.vo.TbOnsale;

import java.io.Serializable;

/**
 * 给发布商品用
 * Created by zhaohongbo on 17/3/4.
 */
public class ItemSendVO2 implements Serializable{
    private String href;
    private Long id;
    private String imgsrc;
    private String price1;
    private String title;
    private String type;


    public ItemSendVO2(TbOnsale to) {
        setHref(to.getNumIid().toString());
        setId(to.getNumIid());
        setImgsrc(to.getPicUrl());
        setPrice1(to.getPrice());
        setTitle(to.getTitle());
        setType(to.getGoodsId()==null?"0":"1");
    }

    public String getType() {
        if("1".equals(type)){
            return "已发布";
        }
        return "未发布";
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHref() {
        return "https://item.taobao.com/item.htm?id="+id;
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

    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
