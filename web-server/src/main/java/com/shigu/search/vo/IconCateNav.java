package com.shigu.search.vo;

import java.io.Serializable;

/**
 * 今日新品,带图类目
 * '男装|nanzhuang1|656,男鞋|nanxie1|655,女装|nvzhuang1|65c,女鞋|nvxie|65a,童装|tongzhuang1|65d,包包|baobao|654,配饰|maozi|65b,大码|dama|658,情侣|qinglv|659,内衣|neiyi|657'
 * Created by zhaohongbo on 17/4/5.
 */
public class IconCateNav implements Serializable{
    /**
     * 类目ID
     */
    private String id;
    /**
     * 类目全名
     */
    private String text;
    /**
     * 类目全拼
     */
    private String name;
    /**
     * 类目icon图标数字编码
     */
    private String icon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
