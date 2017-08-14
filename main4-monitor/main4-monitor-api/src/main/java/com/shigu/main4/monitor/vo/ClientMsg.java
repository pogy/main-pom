package com.shigu.main4.monitor.vo;

/**
 * 客户端信息
 * Created by zhaohongbo on 17/2/16.
 */
public class ClientMsg implements java.io.Serializable {
    /**
     * 客户端IP
     */
    private String clientIp;
    /**
     * 浏览器类型
     */
    private String clientBrower;
    /**
     * 浏览器版本
     */
    private String clientBrowerVersion;
    /**
     * 客户端系统版本
     */
    private String clientOs;

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getClientBrower() {
        return clientBrower;
    }

    public void setClientBrower(String clientBrower) {
        this.clientBrower = clientBrower;
    }

    public String getClientBrowerVersion() {
        return clientBrowerVersion;
    }

    public void setClientBrowerVersion(String clientBrowerVersion) {
        this.clientBrowerVersion = clientBrowerVersion;
    }

    public String getClientOs() {
        return clientOs;
    }

    public void setClientOs(String clientOs) {
        this.clientOs = clientOs;
    }
}
