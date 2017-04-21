package com.shigu.main4.spread.enums;

/**
 * 广告类型
 * Created by Licca on 17/4/10.
 */
public enum GoatTypeEnum {
    NORMAL("普通类广告",1),ITEM("商品类广告",2);

    GoatTypeEnum(String title, Integer value) {
        this.title = title;
        this.value = value;
    }

    private String title;

    private Integer value;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
