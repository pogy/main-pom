package com.shigu.seller.bo;

import java.io.Serializable;

/**
 * 类名：GoatApplyTypeBO
 * 类路径：com.shigu.seller.bo.GoatApplyTypeBO
 * 创建者：王浩翔
 * 创建时间：2017-11-28 13:18
 * 项目：main-pom
 * 描述：
 */
public class GoatApplyTypeBO implements Serializable {
    //广告类型,man和woman
    public String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
