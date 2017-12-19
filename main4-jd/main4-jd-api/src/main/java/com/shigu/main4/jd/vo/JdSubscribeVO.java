package com.shigu.main4.jd.vo;


import java.io.Serializable;

/**
 * Created By admin on 2017/12/12/17:39
 */
public class JdSubscribeVO implements Serializable{

    private static final long serialVersionUID = 1329826928743772122L;

    /**项目编码*/
    private String itemCode;
    /**购买人*/
    private String UserName;

    private String endDate;

    public JdSubscribeVO() {
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
