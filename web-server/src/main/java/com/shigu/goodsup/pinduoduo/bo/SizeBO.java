package com.shigu.goodsup.pinduoduo.bo;

import java.io.Serializable;

/**
 * Created by gtx on 2018/6/27.
 *
 * @author gtx
 * @since
 */
public class SizeBO implements Serializable {

    /**
     * 尺码spcid
     */
    private Long vid;
    /**
     * 尺码名
     */
    private String name;
    /**
     * 数量
     */
    private String num;
    /**
     * 单买价 元
     */
    private String price;
    /**
     * 团购价 元
     */
    private String gprice;
    /**
     * 外部编码
     */
    private String code;

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGprice() {
        return gprice;
    }

    public void setGprice(String gprice) {
        this.gprice = gprice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
