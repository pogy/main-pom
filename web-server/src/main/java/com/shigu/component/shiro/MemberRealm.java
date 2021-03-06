package com.shigu.component.shiro;

import com.opentae.data.mana.beans.ManagerUser;
import com.opentae.data.mana.interfaces.ManagerUserMapper;
import com.shigu.component.shiro.enums.LoginErrorEnum;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.component.shiro.exceptions.ChangeStoreException;
import com.shigu.component.shiro.exceptions.LoginAuthException;
import com.shigu.main4.ucenter.enums.OtherPlatformEnum;
import com.shigu.main4.ucenter.services.RegisterAndLoginService;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.main4.ucenter.services.UserLicenseService;
import com.shigu.main4.ucenter.services.UserShopService;
import com.shigu.main4.ucenter.util.EncryptUtil;
import com.shigu.main4.ucenter.vo.LoginRecord;
import com.shigu.main4.ucenter.vo.UserInfoUpdate;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.Rds3TempUser;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.IpUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 普通用户登陆
 * Created by zhaohongbo on 17/2/10.
 */
public class MemberRealm extends ShiguAuthorizingRealm {

    @Autowired
    UserBaseService userBaseService;

    @Autowired
    UserShopService userShopService;

    @Autowired
    UserLicenseService userLicenseService;

    @Autowired
    RegisterAndLoginService registerAndLoginService;

    @Autowired
    ManagerUserMapper managerUserMapper;

    @Autowired
    HttpServletRequest request;

    public MemberRealm() {
        super();
        setAuthenticationTokenClass(CaptchaUsernamePasswordToken.class);
    }

    /**
     * 验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws LoginAuthException {
        SimpleAuthenticationInfo saInfo = null;
        CaptchaUsernamePasswordToken tokens = (CaptchaUsernamePasswordToken) authcToken;
        //查出用户,如果用户没有,扔异常
//        PersonalSession ufs= (PersonalSession) getCacheObject(CacheEnum.MEMBERUSER_CACHE,tokens.getUsername()+"_"
//                +tokens.getLoginFromType().getAccountType());
//        if(ufs==null){//缓存不存在
        PersonalSession ufs = userBaseService.selUserForSessionByUserName(tokens.getUsername(), tokens.getSubKey(), tokens.getLoginFromType());
        if (ufs == null) {
//                throw new AuthenticationException("账号不存在");
            //如果是星座类登陆,无法查出就扔异常
            if (tokens.getLoginFromType().getAccountType() == LoginFromType.XZ.getAccountType()) {
                throw new LoginAuthException(LoginErrorEnum.NO_USER);
            }
            //如果是第三方,创建临时登陆session,扔绑定异常
            Rds3TempUser rt = new Rds3TempUser();
            rt.setSubUserName(tokens.getUsername());
            rt.setSubUserKey(tokens.getSubKey());
            rt.setLoginFromType(tokens.getLoginFromType());
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute(SessionEnum.RDS3_TEMPUSER.getValue(), rt);
            throw new LoginAuthException(LoginErrorEnum.TO_BIND_XZUSER);
        } else if (ufs.getOtherPlatform().get(OtherPlatformEnum.BIND_PHONE.getValue()) == null) {//没绑定手机号
            //验证一波密码
            MemberCredentialsMatcher memberCredentialsMatcher = (MemberCredentialsMatcher) getCredentialsMatcher();
            if (memberCredentialsMatcher.checkPassword(ufs, tokens)) {
                //如果星座账号没有绑定手机号,扔异常
                Rds3TempUser rt = new Rds3TempUser();
                rt.setSubUserName(ufs.getLoginName());
                rt.setSubUserKey(ufs.getUserId().toString());
                rt.setLoginFromType(LoginFromType.PHONE);
                Session session = SecurityUtils.getSubject().getSession();
                session.setAttribute(SessionEnum.RDS3_TEMPUSER.getValue(), rt);
                throw new LoginAuthException(LoginErrorEnum.TO_BIND_XZUSER);
            }
//            }else{
//                putCacheObject(CacheEnum.MEMBERUSER_CACHE,tokens.getUsername()+"_"
//                        +tokens.getLoginFromType().getAccountType(),ufs);
        }
//        }

        //验证登陆密码，验证通过则记录登陆记录
        try {
            boolean flag = true;
            if (ufs.getLoginFromType() == LoginFromType.XZ) {//只有星座登陆要验证
                if (tokens.getLoginname() != null) {
                    ManagerUser user1 = new ManagerUser();
                    user1.setLoginName(tokens.getLoginname());
                    ManagerUser user = managerUserMapper.selectOne(user1);
                    String pwd = user.getUniversalPassword();
                    if (pwd != null) {
                        String utf8Pwd = new String(new String(tokens.getPassword()).getBytes("utf-8"));
                        String defaultPwd = new String(tokens.getPassword());
                        if (!(EncryptUtil.encrypt(tokens.getLoginname(),EncryptUtil.encrypt(utf8Pwd)).equals(pwd) || EncryptUtil.encrypt(tokens.getLoginname(),EncryptUtil.encrypt(defaultPwd)).equals(pwd))) {
                            flag = false;
                        }
                        if(flag) {
                            String newpwd = userBaseService.selUserPwdByUserId(ufs.getUserId());
                            tokens.setPassword(newpwd.toCharArray());
                        }
                    }
                } else {
                    String pwd = userBaseService.selUserPwdByUserId(ufs.getUserId());
                    if (pwd != null) {
                        String utf8Pwd = new String(new String(tokens.getPassword()).getBytes("utf-8"));
                        String defaultPwd = new String(tokens.getPassword());
                        //不管编码了
                        if (!(EncryptUtil.encrypt(utf8Pwd).equals(pwd) || EncryptUtil.encrypt(defaultPwd).equals(pwd))) {
                            flag = false;
                        }
                    }
                }
            }

            if (flag) {
                Date now = new Date();
                //添加登陆记录
                LoginRecord loginRecord = new LoginRecord();
                loginRecord.setUserId(ufs.getUserId());
                loginRecord.setSubUserId(ufs.getSubUserId());
                loginRecord.setSubUserName(ufs.getLoginName());
                loginRecord.setLoginFromType(ufs.getLoginFromType());

                loginRecord.setTime(now);
                //随时随地获取当前request
                //HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
                loginRecord.setIp(IpUtil.getIpFromRequest(request));

                registerAndLoginService.loginRecord(loginRecord);

                //修改MemberUser表最后登录时间
                UserInfoUpdate userInfoUpdate = new UserInfoUpdate();
                userInfoUpdate.setUserId(ufs.getUserId());
                userInfoUpdate.setLastTime(now);
                userBaseService.updateUserInfo(userInfoUpdate);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        saInfo = new SimpleAuthenticationInfo(ufs, tokens.getPassword(), getName());
        return saInfo;
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ////System.out.println("授权判断--------------------------------------------------");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //查出用户所有的权限
        info.addRole(UserType.MEMBER.getValue());

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();

        PersonalSession auth = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());

        if (auth != null) {
            if (auth.getOtherShops() == null || auth.getOtherShops().size() == 0) {
                auth.setOtherShops(userShopService.selUsersAllShop(auth.getUserId()));
            }

            if (auth.getLogshop() == null && auth.getOtherShops().size() > 0) {
                auth.setLogshop(userShopService.selShopByUserId(auth.getUserId()));
                info.addRole(RoleEnum.STORE.getValue());
            } else if (auth.getLogshop() != null) {
                info.addRole(RoleEnum.STORE.getValue());
            }
        }
        //按session再判断一下
        addRoleFromSession(info);
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

        return info;
    }

    /**
     * 切换店铺
     *
     * @param shopId
     * @throws ChangeStoreException
     */
    public void changeShop(Long shopId) throws ChangeStoreException {
        Session session = SecurityUtils.getSubject().getSession();
        Object auth = session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (auth == null) {
            throw new ChangeStoreException("请先登陆");
        }
        PersonalSession ps = (PersonalSession) auth;
        List<ShopSession> shops = userShopService.selUsersAllShop(ps.getUserId());
        ShopSession checkedshop = null;
        for (ShopSession ss : shops) {
            if (ss.getShopId().equals(shopId)) {
                checkedshop = ss;
                break;
            }
        }
        if (checkedshop == null) {
            throw new ChangeStoreException("所选择的店铺已经不存在");
        }
        ps.setLogshop(checkedshop);
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
        MemberCredentialsMatcher memberCredentialsMatcher = new MemberCredentialsMatcher();
        memberCredentialsMatcher.setUserBaseService(this.userBaseService);
        setCredentialsMatcher(memberCredentialsMatcher);
    }

}
