package com.opentae.data.mall.multibeans;

import java.io.Serializable;

/**
 * 路径:com.opentae.data.mall.multibeans.GoodsStyleInfoBean
 * 工程:main-pom
 * 时间:18-1-25下午8:13
 * 创建人:wanghaoxiang
 * 描述：
 */
public class GoodsStyleInfoBean implements Serializable {

    //商品id
    private Long goodsId;
    //商品标题
    private String title;
    //商品图片
    private String imgsrc;
    //商品
    private Long styleId;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getTitle() {
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

    public Long getStyleId() {
        return styleId;
    }

    public void setStyleId(Long styleId) {
        this.styleId = styleId;
    }
}
