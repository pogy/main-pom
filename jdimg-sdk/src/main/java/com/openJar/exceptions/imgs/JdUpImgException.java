package com.openJar.exceptions.imgs;

import com.openJar.exceptions.OpenException;

import java.io.Serializable;

/**
 * Created by zhaohongbo on 16/12/20.
 */
public class JdUpImgException extends OpenException implements Serializable{

    public JdUpImgException() {
    }

    public JdUpImgException(String errorMsg) {
       super.setErrMsg(errorMsg);
    }

    public JdUpImgException(String errorCode, String errorMsg) {
       super.setCode(errorCode);
       super.setErrMsg(errorMsg);
    }


}
