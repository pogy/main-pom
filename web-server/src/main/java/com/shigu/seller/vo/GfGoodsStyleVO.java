package com.shigu.seller.vo;

import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */
public class GfGoodsStyleVO {
    private Long id;
    private String titleText;
    private String titleImg;
    private List<GfShowVO> goodsList;


    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText( String titleText ) {
        this.titleText = titleText;
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg( String titleImg ) {
        this.titleImg = titleImg;
    }

    public List<GfShowVO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList( List<GfShowVO> goodsList ) {
        this.goodsList = goodsList;
    }
}
