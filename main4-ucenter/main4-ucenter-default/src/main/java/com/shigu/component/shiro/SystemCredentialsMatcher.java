package com.shigu.component.shiro;

import com.shigu.session.main4.SysUserSession;
import com.shigu.session.main4.names.SessionEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 系统登陆密码验证器
 * Created by zhaohongbo on 17/2/15.
 */
public class SystemCredentialsMatcher extends ShiguCredentialsMatcher {

    private static final Logger logger = LoggerFactory.getLogger(SimpleCredentialsMatcher.class);



    public SystemCredentialsMatcher(){

    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
        CaptchaUsernamePasswordToken token = (CaptchaUsernamePasswordToken) authcToken;
        SysUserSession auth = (SysUserSession) info.getPrincipals().getPrimaryPrincipal();
        String pwd = auth.getLoginPwd();
        if(pwd == null){
            return false;
        }else if(!pwd.equals(encrypt(new String(token.getPassword())))){
            return false;
        }
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute(SessionEnum.SYS_USER.getValue(), auth);
        return true;
    }
}
