package com.openJar.responses.imgs;

import com.openJar.responses.Response;

/**
 * 请求结果
 * Created by zhaohongbo on 16/12/20.
 */
public class JdUptoImgsResponse extends Response{
    private String newUrl;
    private String result;
    private String errorCode;
    private String msg;
    private String imgindex;
    private Long imgsize;

    public String getNewUrl() {
        return newUrl;
    }

    public void setNewUrl(String newUrl) {
        this.newUrl = newUrl;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getImgindex() {
        return imgindex;
    }

    public void setImgindex(String imgindex) {
        this.imgindex = imgindex;
    }

    public Long getImgsize() {
        return imgsize;
    }

    public void setImgsize(Long imgsize) {
        this.imgsize = imgsize;
    }
}
