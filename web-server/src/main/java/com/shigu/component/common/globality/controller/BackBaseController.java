package com.shigu.component.common.globality.controller;


import com.shigu.session.main4.SysUserSession;
import com.shigu.session.main4.names.SessionEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * 后台管理BASE CONTROLLER
 *
 * @author shigu_zjb
 * @date 2017/03/09 10:42
 *
 *
 */
public abstract class BackBaseController {

    /**
     * shiro代理session
     * @return
     */
    public Session getShiroSession(){
        Session session = SecurityUtils.getSubject().getSession();
        return session;
    }

    /**
     * 清除用户SESSION
     */
    public void removeShiroSession(){
        if (SecurityUtils.getSubject().getSession() != null) {
            SecurityUtils.getSubject().getSession().removeAttribute(SessionEnum.SYS_USER.getValue());
        }
    }


    /**
     * 会话用户对象
     * @return
     */
    public SysUserSession getAuthorithUser(){
        Session session = getShiroSession();
        SysUserSession authUser = (SysUserSession) session.getAttribute((SessionEnum.SYS_USER.getValue()));
        return authUser;
    }

    /**
     * 用户名称
     * @return
     */
    public String getUserName(){
        SysUserSession authUser = getAuthorithUser();
        if(authUser == null){
            return null;
        }
        return authUser.getUserName();
    }

    /**
     * 登录用户名称
     * @return
     */
    public String getLoginName(){
        SysUserSession authUser = getAuthorithUser();
        if(authUser == null){
            return null;
        }
        return authUser.getLoginName();
    }

}
