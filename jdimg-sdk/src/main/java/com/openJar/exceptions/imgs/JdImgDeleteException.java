package com.openJar.exceptions.imgs;

import com.openJar.exceptions.OpenException;

import java.io.Serializable;

/**
 * Created By admin on 2017/12/22/14:19
 */
public class JdImgDeleteException extends OpenException implements Serializable{
    private String errCode;
    private String ErrMdg;

    public JdImgDeleteException() {
    }

    public JdImgDeleteException(String errMdg) {
        ErrMdg = errMdg;
    }

    public JdImgDeleteException(String errCode, String errMdg) {
        this.errCode = errCode;
        ErrMdg = errMdg;
    }
}
