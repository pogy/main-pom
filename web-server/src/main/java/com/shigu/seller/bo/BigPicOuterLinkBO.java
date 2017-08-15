package com.shigu.seller.bo;

/**
 * 类名：BigPicOuterLinkBO
 * 类路径：com.shigu.seller.bo.BigPicOuterLinkBO
 * 创建者：王浩翔
 * 创建时间：2017-08-12 17:19
 * 项目：main-pom
 * 描述：
 */
public class BigPicOuterLinkBO {

    /**
     * 大图外链
     */
    private String link;
    /**
     * 外链密码
     */
    private String psw;
    /**
     * 是否关联相同商品
     */
    private Boolean isChecked;
    /**
     * 商品Id
     */
    private Long goodsId;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean ckecked) {
        isChecked = ckecked;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
