package com.shigu.exceptions;

import com.openJar.exceptions.OpenException;

/**
 * Created By admin on 2017/12/22/16:16
 */
public class ImgDownloadException extends OpenException {

    public ImgDownloadException() {
    }

    public ImgDownloadException(String errMsg) {
        super.setErrMsg(errMsg);
    }

    public ImgDownloadException(String code, String errMsg) {
        super.setCode(code);
        super.setErrMsg(errMsg);
    }

}
