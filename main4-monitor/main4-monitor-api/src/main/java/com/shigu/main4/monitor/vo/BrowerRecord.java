package com.shigu.main4.monitor.vo;

import java.util.Date;

/**
 * 浏览记录
 * Created by zhaohongbo on 17/2/16.
 */
public class BrowerRecord implements java.io.Serializable {
    /**
     * 唯一主键
     */
    private String keyId;
    /**
     * 分站
     */
    private String webSite;
    /**
     * 受访域名
     */
    private String domain;
    /**
     * 主域后面的受访路径,如/ttt/index.html
     */
    private String uri;
    /**
     * 全链接,如http://www.baidu.com/index.htm?key=xxx&p=ii
     */
    private String url;
    /**
     * 客户端信息
     */
    private ClientMsg clientMsg;
    /**
     * 进入页面时间,毫秒值
     */
    private Date inTime;
    /**
     * 跳出页面时间,毫秒值
     */
    private Date outTime;
    /**
     * 关联key
     */
    private String connectKey;
    /**
     * 商品ID
     */
    private Long itemId;
    /**
     * 店铺ID
     */
    private Long shop;
    /**
     * 来源页面
     */
    private String referer;
    /**
     * 如果已经登陆,就有用户ID
     */
    private Long userId;

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ClientMsg getClientMsg() {
        return clientMsg;
    }

    public void setClientMsg(ClientMsg clientMsg) {
        this.clientMsg = clientMsg;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getConnectKey() {
        return connectKey;
    }

    public void setConnectKey(String connectKey) {
        this.connectKey = connectKey;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getShop() {
        return shop;
    }

    public void setShop(Long shop) {
        this.shop = shop;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
