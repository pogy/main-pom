package com.shigu.api.exceptions;

import com.openJar.exceptions.OpenException;

/**
 * 系统出现未知异常
 * @author wxc
 * @date 2016年6月15日 下午3:58:27
 */
public class SystemException extends OpenException {
    private String msg="服务器繁忙";



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
