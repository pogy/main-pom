package com.openJar.exceptions.imgs;

import com.openJar.exceptions.OpenException;

import java.io.Serializable;

/**
 * 商品主图上传
 * Created by zhaohongbo on 17/1/18.
 */
public class JdUptoItemImgException extends OpenException implements Serializable{

    public JdUptoItemImgException() {
    }

    public JdUptoItemImgException(String msg) {
        super.setErrMsg(msg);
    }

    public JdUptoItemImgException(String code,String msg) {
        super.setCode(code);
        super.setErrMsg(msg);
    }


}
