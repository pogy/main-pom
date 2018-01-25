package com.shigu.jd.api.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * Created By admin on 2017/12/22/16:16
 */
public class ImgDownloadException extends Main4Exception {

    public ImgDownloadException() {
    }

    public ImgDownloadException(String errMsg) {
        super(errMsg);
    }
}
