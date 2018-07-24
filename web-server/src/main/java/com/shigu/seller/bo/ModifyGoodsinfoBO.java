package com.shigu.seller.bo;

import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 修改商品信息
 * Created by zhaohongbo on 17/3/9.
 */
public class ModifyGoodsinfoBO implements Serializable{

    @NotNull(message = "商品ID不能为null")
    private Long goodsId;
    @SafeHtml(message = "title包含非法页面标签")
    private String title;
    @SafeHtml(message = "goodsNo包含非法页面标签")
    private String goodsNo;

    private Integer isShowcase;

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
//        this.title = EncodeParamter.iosToUtf8(title);
        this.title=title;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public Integer getIsShowcase() {
        return isShowcase;
    }

    public void setIsShowcase(Integer isShowcase) {
        this.isShowcase = isShowcase;
    }
}
