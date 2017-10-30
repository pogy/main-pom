package com.shigu.phone.api.enums;

public enum ImgFormatEnum {
    DT("450"),
    SHOP_TJ("150"),
    GOODS_LIST("300"),
    CAT("100"),
    GOODS_IMAGES("400"),
    HEAD("300"),
    GOODS_DETAIL(null)
    ;

    ImgFormatEnum(String width){
        String w=width==null?"":"/resize,w_"+width;
        String w2=width==null?"q30":width+"x"+width+"q80";
        this.oss="?x-oss-process=image"+w+"/format,jpg/quality,q_80";
        this.tb="_"+w2+".jpg";
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
