package com.shigu.seller.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.vo
 * @ClassName: ChildOrdersVo
 * @Author: sy
 * @CreateDate: 2018/5/4 0004 16:24
 */
public class ChildOrdersVo implements Serializable{

    private String imgsrc;
    private Long goodsId;
    private String title;
    private String goodsNo;
    private String price;
    private List<SkusVo> skus;

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

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

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<SkusVo> getSkus() {
        return skus;
    }

    public void setSkus(List<SkusVo> skus) {
        this.skus = skus;
    }
}
