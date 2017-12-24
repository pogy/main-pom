package com.openJar.responses.imgs;

import com.openJar.responses.Response;

/**
 * 上传单张
 * Created by zhaohongbo on 17/1/18.
 */
public class JdUptoPropImgResponse extends Response{
    /**
     * 新图片链接
     */
    private String url;
    /**
     * 新图片ID
     */
    private Long id;

    private String tbmsg;

    public String getTbmsg() {
        return tbmsg;
    }

    public void setTbmsg(String tbmsg) {
        this.tbmsg = tbmsg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
