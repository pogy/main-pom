package com.openJar.exceptions.imgs;

import com.openJar.exceptions.OpenException;

import java.io.Serializable;

/**
 * 上传单张属性图
 * Created by zhaohongbo on 17/1/18.
 */
public class JdUptoPropImgException extends OpenException implements Serializable{
    public JdUptoPropImgException() {
    }

    public JdUptoPropImgException(String msg) {
        super.setErrMsg(msg);
    }

    public JdUptoPropImgException(String code,String msg) {
        super.setCode(code);
        super.setErrMsg(msg);
    }


}
