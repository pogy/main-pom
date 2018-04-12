package com.shigu.exceptions;

/**
 * Created By admin on 2017/12/22/16:16
 */
public class ImgDownloadException extends Exception {
    private String code;
    private String errMsg;

    public ImgDownloadException() {
    }

    public ImgDownloadException(String errMsg) {
        this.errMsg = errMsg;
    }

    public ImgDownloadException(String code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
