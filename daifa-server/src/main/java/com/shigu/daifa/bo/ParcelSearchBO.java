package com.shigu.daifa.bo;

import java.util.List;

/**
 *Created By pc on 2017-09-21/15:50
 *包裹查询
 */
public class ParcelSearchBO {
    /**
     * 快递单号
     */
    private String postCode;
    /**
     * 发货人手机
     */
    private String telphone;
    /**
     *匹配状态
     */
    private Integer matchState;
    /**
     * 当前页
     */
    private Integer page;

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public Integer getMatchState() {
        return matchState;
    }

    public void setMatchState(Integer matchState) {
        this.matchState = matchState;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
