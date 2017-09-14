package com.shigu.main4.common.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 系统标签
 * Created by Licca on 17/2/20.
 */
public enum ShiguTags implements Serializable {
    CAN_RETREAT("可退","1"),
    CAN_CHANGE("可换","2");

    ShiguTags(String title, String value) {
        this.title = title;
        this.value = value;
    }

    // 普通方法
    public static ShiguTags getShiguTags(String values) {
        for (ShiguTags c : ShiguTags.values()) {
            if (c.getValue().equals(values)) {
                return c;
            }
        }
        return null;
    }

    public static String getShiguTags(List<ShiguTags> shiguTagsList) {
        StringBuffer str = new StringBuffer();
        for (int i = 0;i<shiguTagsList.size();i++) {
            ShiguTags shiguTags = shiguTagsList.get(i);
            str.append(shiguTags.getValue());
            if((i != 0 && i!=shiguTagsList.size()-1)||i == 0 && shiguTagsList.size()!=1){
                str.append(",");
            }
        }
        return str.toString();
    }


    /**
     * 标题
     */
    private String title;
    /**
     * 值
     */
    private String value;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
