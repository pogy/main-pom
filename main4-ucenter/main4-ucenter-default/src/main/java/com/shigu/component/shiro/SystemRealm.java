package com.shigu.component.shiro;

import com.shigu.component.shiro.enums.UserType;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.SysUserSession;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * 后台登陆
 * Created by zhaohongbo on 17/2/10.
 */
public class SystemRealm extends ShiguAuthorizingRealm {

    @Autowired
    private UserBaseService userBaseService;


    public SystemRealm() {
        super();
        setAuthenticationTokenClass(CaptchaUsernamePasswordToken.class);
    }

    /**
     * 验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        CaptchaUsernamePasswordToken tokens = (CaptchaUsernamePasswordToken) authcToken;
        // TODO:验证码验证
        SysUserSession sysUserSession = userBaseService.selSysForSessionByUserName(tokens.getUsername());
        if(sysUserSession == null){
            throw new UnknownAccountException("No account found for user [" + tokens.getUsername() + "]");
        }
        // TODO:用户状态验证
        SimpleAuthenticationInfo saInfo = new SimpleAuthenticationInfo(sysUserSession, tokens.getPassword(), getName());
        return saInfo;
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //System.out.println("授权判断--------------------------------------------------");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //查出用户所有的权限
//		AuthorityUser auth = (AuthorityUser) principals.getPrimaryPrincipal();
//
//		List<UserRole> roles=managerRoleMapper.selRoleNamesByuserIds(auth.getUserId().toString());
//		List<String> roleStrings=new ArrayList<String>();
//		List<Permission> allPermissions=new ArrayList<Permission>();
//		for(UserRole ur:roles){
//			roleStrings.add(ur.getRoleTag());
//			allPermissions.addAll(simpleRolePermissionReader.resolvePermissionsInRole(ur.getRoleTag()));
//		}
//		info.addRoles(roleStrings);
//		info.addObjectPermissions(allPermissions);
        info.addRole(UserType.SYSTEM.getValue());
        addRoleFromSession(info);
        return info;
    }

    /**
     * 更新用户授权信息缓存.
     */
    public void clearCachedAuthorizationInfo(Object principal) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
        clearCachedAuthorizationInfo(principals);
    }

    /**
     * 清除所有用户授权信息缓存.
     */
    public void clearAllCachedAuthorizationInfo() {
        Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
        if (cache != null) {
            for (Object key : cache.keys()) {
                cache.remove(key);
            }
        }
    }


    /**
     * 设定Password校验.
     */
    @PostConstruct
    public void initCredentialsMatcher() {
        SystemCredentialsMatcher systemCredentialsMatcher=new SystemCredentialsMatcher();
        systemCredentialsMatcher.setUserBaseService(userBaseService);
        setCredentialsMatcher(systemCredentialsMatcher);
    }

}
