package com.shigu.main4.jd.bo;

import java.io.Serializable;

/**
 * Created By admin on 2017/12/24/12:18\
 * 新增和修改商品图片
 */
public class JdImageUpdateBO implements Serializable{

    private static final long serialVersionUID = -6145514116220260854L;

    /**
     * 商品id
     */
    private Long goodsId;
    /**
     *颜色id。如果没有颜色id，则默认为10个0
     */
    private String colorId = "0,0,0,0,0,0,0,0,0,0";
    /**
     * 图片Id 以逗号分割的数字串列表，例如："1234,34343,2313"
     */
    private String imgId;
    /**
     * 图片顺序。index值：1-N，如果index存在，则直接覆盖相应index图片
     * 以逗号分割的数字串列表，例如："1234,34343,2313"
     */
    private String imgIndex;
    /**
     * 	京东图片服务器地址，不包括前缀。例如：jfs/t2116/102/1731643157/81969/c3df941a/5670f868Nc441d4c3.jpg
     * 	以逗号分割的数字串列表，例如："1234,34343,2313"
     */
    private String imgUrl;
    /**
     *图片空间中的图片Id
     * 	以逗号分割的数字串列表，例如："1234,34343,2313"
     */
    private String imgZoneId;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getImgIndex() {
        return imgIndex;
    }

    public void setImgIndex(String imgIndex) {
        this.imgIndex = imgIndex;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgZoneId() {
        return imgZoneId;
    }

    public void setImgZoneId(String imgZoneId) {
        this.imgZoneId = imgZoneId;
    }
}
