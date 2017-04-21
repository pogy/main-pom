package com.opentae.data.mana.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 接口实体
 * Created by zhaohongbo on 16/5/20.
 */
public class ManagerJiekou {
    /**
     * 唯一主键，没别的意义
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long jkId;
    /**
     * appkey
     */
    private String appkey;
    /**
     * 私钥
     */
    private String secret;
    /**
     * 接口平台，tb表示淘宝，wx表示微信，alipay表示支付宝，jd表示京东，ali表示阿里巴巴。用前端js控制
     */
    private String platform;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 接口图标
     */
    private String headUrl;
    /**
     * 接口名称
     */
    private String title;

    private String remark;

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getJkId() {
        return jkId;
    }

    public void setJkId(Long jkId) {
        this.jkId = jkId;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
