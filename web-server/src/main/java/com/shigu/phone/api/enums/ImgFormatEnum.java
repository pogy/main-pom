package com.shigu.phone.api.enums;

public enum ImgFormatEnum {
    DT("450"),
    SHOP_TJ("150"),
    GOODS_LIST("300"),
    CAT("100"),
    GOODS_IMAGES("400"),
    HEAD("100"),
    GOODS_DETAIL("970")
    ;

    ImgFormatEnum(String width){
        this.oss="?x-oss-process=image/resize,m_lfit,w_"+width+"/format,jpg,q_50";
        this.tb="_"+width+"x"+width+"q50.jpg";
    }

    String oss;
    String tb;

    public String getOss() {
        return this.oss;
    }

    public String getTb() {
        return this.tb;
    }
}
