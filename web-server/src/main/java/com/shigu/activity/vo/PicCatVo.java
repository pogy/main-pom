package com.shigu.activity.vo;

/**
 * 带图导航
 * Created by bugzy on 2017/5/18 0018.
 */
public class PicCatVo extends StyleNavVo {
    private String imgsrc;
    private Integer goodscount;

    public PicCatVo(String id, String text) {
        super(id, text);
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public Integer getGoodscount() {
        return goodscount;
    }

    public void setGoodscount(Integer goodscount) {
        this.goodscount = goodscount;
    }
}
