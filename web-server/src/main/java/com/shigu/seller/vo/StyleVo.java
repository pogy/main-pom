package com.shigu.seller.vo;

/**
 *  出售中商品样式数据
 * Created by bugzy on 2017/5/22 0022.
 */
public class StyleVo {

    private String sid;

    private String name;

    public StyleVo(String sid, String name) {
        this.sid = sid;
        this.name = name;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
