package com.shigu.component.shiro;

import com.shigu.component.shiro.enums.UserType;
import com.shigu.component.shiro.exceptions.LoginAuthException;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 认证授权选择器
 * Created by zhaohongbo on 17/2/10.
 */
public class DefaultModularRealm extends ModularRealmAuthenticator {
    private Map<String, Object> definedRealms;

    /**
     * 多个realm实现
     */
    protected AuthenticationInfo doMultiRealmAuthentication(
            Collection<Realm> realms, AuthenticationToken token) {
        return super.doMultiRealmAuthentication(realms, token);
    }

    /**
     * 调用单个realm执行操作
     */
    protected AuthenticationInfo doSingleRealmAuthentication(Realm realm,
                                                             AuthenticationToken token) {
        // 如果该realms不支持(不能验证)当前token
        if (!realm.supports(token)) {
            throw new ShiroException("token错误!");
        }
        AuthenticationInfo info = null;
        try {
            info = realm.getAuthenticationInfo(token);

            if (info == null) {
                throw new ShiroException("token不存在!");
            }
        } catch (LoginAuthException e) {
            throw e;
        } catch (Exception e) {
            throw new ShiroException("用户名或者密码错误!");
        }
        return info;
    }

    /**
     * 判断登录类型执行操作
     */
    @Override
    protected AuthenticationInfo doAuthenticate(
            AuthenticationToken authenticationToken)
            throws AuthenticationException {
        this.assertRealmsConfigured();

        Realm realm = null;

        CaptchaUsernamePasswordToken token = (CaptchaUsernamePasswordToken) authenticationToken;
        if (token.getLoginType().equals(UserType.MEMBER)) {
            realm = (Realm) this.definedRealms.get("memberRealm");
        }
        if (token.getLoginType().equals(UserType.SYSTEM)) {
            realm = (Realm) this.definedRealms.get("systemRealm");
        }
        if (realm == null) {
            return null;
        }

        return this.doSingleRealmAuthentication(realm, authenticationToken);
    }

    /**
     * 判断realm是否为空
     */
    @Override
    protected void assertRealmsConfigured() throws IllegalStateException {
        this.definedRealms = this.getDefinedRealms();
        if (CollectionUtils.isEmpty(this.definedRealms)) {
            throw new ShiroException("值传递错误!");
        }
    }

    public Map<String, Object> getDefinedRealms() {
        return this.definedRealms;
    }

    public void setDefinedRealms(Map<String, Object> definedRealms) {
        this.definedRealms = definedRealms;
    }
}
