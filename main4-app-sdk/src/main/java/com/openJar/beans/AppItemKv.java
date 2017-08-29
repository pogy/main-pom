package com.openJar.beans;

import com.openJar.utils.OpenBean;

/**
 * 类名：AppItemKv
 * 类路径：com.openJar.beans.AppItemKv
 * 创建者：王浩翔
 * 创建时间：2017-08-29 12:58
 * 项目：main-pom
 * 描述：app端商品参数
 */
public class AppItemKv extends OpenBean {
    //标题
    private String key;
    //值
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
