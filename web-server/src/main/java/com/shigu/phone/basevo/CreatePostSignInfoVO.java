package com.shigu.phone.basevo;

import java.io.Serializable;

/**
 * Created By pc on 2017-10-18/9:55
 */
public class CreatePostSignInfoVO implements Serializable {
    //授权id	必须
    private String accessid;
    //授权策略	必须
    private String policy;
    //签名	必须
    private String signature;
    //授权路径	必须
    private String dir;
    //ossHost&nbsp;&nbsp;OSS地址	必须
    private String host;
    //过期时间，单位秒	必须
    private String expire;

    public String getAccessid() {
        return accessid;
    }

    public void setAccessid(String accessid) {
        this.accessid = accessid;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }
}
