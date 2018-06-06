package com.shigu.main4.vo;

import java.io.Serializable;


/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.vo
 * @ClassName: GoodsVo
 * @Author: sy
 * @CreateDate: 2018/5/31 0031 13:03
 */
public class GoodsVo implements Serializable{

    private Long goodsId;
    private String imgSrc;
    private String goodsNo;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }
}
