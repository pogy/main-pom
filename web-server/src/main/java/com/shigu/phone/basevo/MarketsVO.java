package com.shigu.phone.basevo;

import java.io.Serializable;

/**
 * Created By pc on 2017-10-23/14:42
 * 市场列表
 */
public class MarketsVO implements Serializable {

    private static final long serialVersionUID = 2292041310108209260L;

    /**市场id*/
    private String mid;
    /**市场名称*/
    private String name;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
