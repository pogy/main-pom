package com.shigu.jd.img.vo;

/**
 * 其它图片的下载
 * Created by zhaohongbo on 17/1/18.
 */
public class DownOtherVO {
    /**
     * 1表示成功
     */
    private int status;
    /**
     * 成功后的url链接
     */
    private String url;
    /**
     * 失败消息
     */
    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
