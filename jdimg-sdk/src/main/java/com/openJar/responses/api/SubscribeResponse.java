package com.openJar.responses.api;


import com.openJar.responses.Response;
import java.util.Date;

/**
 * Created By admin on 2017/12/12/17:39
 */
public class SubscribeResponse extends Response {

    /**
     * 项目ID
     */
    private Long itemId;
    /**项目编码*/
    private String itemCode;
    /**购买人*/
    private String UserName;
    /**
     *调用来源
     */
    private String itemSource;
    /**
     *服务版本号
     */
    private String versionNo;

    private Date endDate;

    public SubscribeResponse() {
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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

    public String getItemSource() {
        return itemSource;
    }

    public void setItemSource(String itemSource) {
        this.itemSource = itemSource;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
