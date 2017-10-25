package com.shigu.main4.item.vo;

import java.io.Serializable;

/**
 * 类名：ShopUnprocessItemCount
 * 类路径：com.shigu.main4.item.vo.ShopUnprocessItemCount
 * 创建者：王浩翔
 * 创建时间：2017-10-25 13:15
 * 项目：main-pom
 * 描述：出售中的商品页面，商家提示数量
 */
public class ShopUnprocessItemCount implements Serializable {
    //无最低零售价商品数量
    private Integer nolowestLsjNum;
    //无大图商品数量
    private Integer noBigPicGoodsNum;
    //无材料成分数量
    private Integer noConstituentNum;

    public Integer getNolowestLsjNum() {
        return nolowestLsjNum;
    }

    public void setNolowestLsjNum(Integer nolowestLsjNum) {
        this.nolowestLsjNum = nolowestLsjNum;
    }

    public Integer getNoBigPicGoodsNum() {
        return noBigPicGoodsNum;
    }

    public void setNoBigPicGoodsNum(Integer noBigPicGoodsNum) {
        this.noBigPicGoodsNum = noBigPicGoodsNum;
    }

    public Integer getNoConstituentNum() {
        return noConstituentNum;
    }

    public void setNoConstituentNum(Integer noConstituentNum) {
        this.noConstituentNum = noConstituentNum;
    }
}
