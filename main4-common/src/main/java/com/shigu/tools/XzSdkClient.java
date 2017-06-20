package com.shigu.tools;

import com.openJar.tools.PcOpenClient;

/**
 * 星座sdk
 * Created by zhaohongbo on 17/3/1.
 */
public class XzSdkClient {
    private String appkey;
    private String secret;
    private String type;
    /**
     * 主站域名
     */
    private String mainHost;
    /**
     * 一键上传主域
     */
    private String yjHost;
    /**
     * 所有支持的主营类目
     */
    private String xzMainBus;
    /**
     * 发信箱
     */
    private String mailfrom;
    /**
     * 邮局地址
     */
    private String smtphost;
    /**
     * 发信用户名
     */
    private String mailuser;
    /**
     * 邮箱密码
     */
    private String mailpwd;
    /**
     * 是否smtp授权
     */
    private Boolean smtpauth;
    /**
     * smtp超时时间
     */
    private Long smtptimeout;

    private PcOpenClient pcOpenClient;

    public String getMainHost() {
        return mainHost;
    }

    public void setMainHost(String mainHost) {
        this.mainHost = mainHost;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PcOpenClient getPcOpenClient() {
        if(pcOpenClient==null){
            pcOpenClient=new PcOpenClient(appkey,secret,type);
        }
        return pcOpenClient;
    }

    public void setPcOpenClient(PcOpenClient pcOpenClient) {
        this.pcOpenClient = pcOpenClient;
    }

    public String getYjHost() {
        return yjHost;
    }

    public void setYjHost(String yjHost) {
        this.yjHost = yjHost;
    }

    public String getXzMainBus() {
        return xzMainBus;
    }

    public void setXzMainBus(String xzMainBus) {
        this.xzMainBus = xzMainBus;
    }

    public String getMailfrom() {
        return mailfrom;
    }

    public void setMailfrom(String mailfrom) {
        this.mailfrom = mailfrom;
    }

    public String getSmtphost() {
        return smtphost;
    }

    public void setSmtphost(String smtphost) {
        this.smtphost = smtphost;
    }

    public String getMailuser() {
        return mailuser;
    }

    public void setMailuser(String mailuser) {
        this.mailuser = mailuser;
    }

    public String getMailpwd() {
        return mailpwd;
    }

    public void setMailpwd(String mailpwd) {
        this.mailpwd = mailpwd;
    }

    public Boolean getSmtpauth() {
        return smtpauth;
    }

    public void setSmtpauth(Boolean smtpauth) {
        this.smtpauth = smtpauth;
    }

    public Long getSmtptimeout() {
        return smtptimeout;
    }

    public void setSmtptimeout(Long smtptimeout) {
        this.smtptimeout = smtptimeout;
    }
}
