package com.shigu.seller.vo;

import java.io.Serializable;

/**
 * 路径:com.shigu.seller.vo.ShopStyleGoodsInfoVO
 * 工程:main-pom
 * 时间:18-1-25下午8:30
 * 创建人:wanghaoxiang
 * 描述：风格下商品数据列表
 */
public class ShopStyleGoodsInfoVO implements Serializable {

    //商品id
    private Long goodsid;
    //商品图片
    private String imgsrc;
    //商品标题
    private String title;
    //所属风格小类id
    private Long scid;
    //所属风格小类名称
    private String scname;

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getScid() {
        return scid;
    }

    public void setScid(Long scid) {
        this.scid = scid;
    }

    public String getScname() {
        return scname;
    }

    public void setScname(String scname) {
        this.scname = scname;
    }
}
