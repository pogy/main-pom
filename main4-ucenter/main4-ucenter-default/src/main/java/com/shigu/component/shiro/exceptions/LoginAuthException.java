package com.shigu.component.shiro.exceptions;

import com.shigu.component.shiro.enums.LoginErrorEnum;
import org.apache.shiro.authc.AuthenticationException;

/**
 * 登陆过程中的异常
 * Created by Licca on 17/2/20.
 */
public class LoginAuthException extends AuthenticationException {
    /**
     * 回馈信息
     */
    private LoginErrorEnum msgback;

    public LoginAuthException(LoginErrorEnum msgback) {
        super(msgback.getTitle());
        this.msgback = msgback;
    }

    public LoginAuthException(String message) {
        super(message);
    }

    public LoginErrorEnum getMsgback() {
        return msgback;
    }

    public void setMsgback(LoginErrorEnum msgback) {
        this.msgback = msgback;
    }
}
