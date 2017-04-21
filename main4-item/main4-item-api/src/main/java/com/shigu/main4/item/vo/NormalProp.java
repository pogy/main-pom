package com.shigu.main4.item.vo;

import java.io.Serializable;

/**
 * 普通属性
 * Created by zhaohongbo on 17/2/16.
 */
public class NormalProp implements Serializable{

    private static final long serialVersionUID = 6999687541937858396L;
    /**
     * 属性名
     */
    private String pname;
    /**
     * 属性值
     */
    private String value;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
