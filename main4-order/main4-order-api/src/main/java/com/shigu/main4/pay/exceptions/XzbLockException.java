package com.shigu.main4.pay.exceptions;

import com.openJar.exceptions.OpenException;

/**
 * 类名：XzbLockException
 * 类路径： com.shigu.main4.pay.exceptions.XzbLockException
 * 创建者： whx
 * 创建时间： 8/8/18 4:26 PM
 * 项目： main-pom
 * 描述：
 */
public class XzbLockException extends OpenException {

    private String msg;

    public XzbLockException() {
    }

    public XzbLockException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
