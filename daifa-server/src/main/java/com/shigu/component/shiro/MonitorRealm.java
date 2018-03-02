package com.shigu.component.shiro;


import com.opentae.data.daifa.beans.TsysRole;
import com.opentae.data.daifa.interfaces.TsysRoleMapper;
import com.shigu.config.DaifaSessionConfig;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * apache shrio 认证与授权
 * @author zjb
 */
public class MonitorRealm extends AuthorizingRealm {

	@Autowired
	TsysRoleMapper tsysRoleMapper;

	@Autowired
	CustomCredentialsMatcher customCredentialsMatcher;/////

	@Autowired
	private SimpleRolePermissionReader simpleRolePermissionReader;


	public MonitorRealm() {
		super();
		setAuthenticationTokenClass(CaptchaUsernamePasswordToken.class);
	}

    /**
     * 验证
     */
//	@Override
//	 protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
//		SimpleAuthenticationInfo saInfo = null;
//		CaptchaUsernamePasswordToken tokens = (CaptchaUsernamePasswordToken) authcToken;
//		ManagerUserExample example=new ManagerUserExample();
//		example.createCriteria().andLoginNameEqualTo(tokens.getUsername());
//		example.setStartIndex(0);
//		example.setEndIndex(1);
//		List<ManagerUser> results=managerUserMapper.selectByConditionList(example);
//		if(results.size()==0){
//			throw new AuthenticationException("账号不存在");
//		}
//		ManagerUser user=results.get(0);
//		if(user.getStatus()!=1){
//			throw new AuthenticationException("账号被封号");
//		}
//		tokens.setCaptcha(user.getPassword());
//		AuthorityUser auth = new AuthorityUser();
//		auth.setUserName(tokens.getUsername());
//		auth.setNick(user.getNick());
//		auth.setUserId(user.getUserId());
//		saInfo = new SimpleAuthenticationInfo(auth, tokens.getPassword(), getName());
//		return saInfo;
//	}
	/*@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		SimpleAuthenticationInfo saInfo = null;
		CaptchaUsernamePasswordToken tokens = (CaptchaUsernamePasswordToken) authcToken;

		AuthorityUser auth = new AuthorityUser();
		auth.setUserName(tokens.getUsername());

		saInfo = new SimpleAuthenticationInfo(auth, tokens.getPassword(), getName());
		return saInfo;
	}*/
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		SimpleAuthenticationInfo saInfo = null;
		CaptchaUsernamePasswordToken tokens = (CaptchaUsernamePasswordToken) authcToken;
		AuthorityUser auth = new AuthorityUser();

			//AuthorityUser auth = new AuthorityUser();
			auth.setUserName(tokens.getUsername());


		saInfo = new SimpleAuthenticationInfo(auth, tokens.getPassword(), getName());
		return saInfo;
	}

	/**
	 * ====================================================================================
	 * @方法名： doGetAuthorizationInfo
	 * @user gzy 17/2/28 08:58
	 * @功能：新的授权
	 * @param: [principals]
	 * @return: org.apache.shiro.authz.AuthorizationInfo
	 * @exception:
	 * ====================================================================================
	 *
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		////System.out.println("授权判断--------------------------------------------------");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//查出用户所有的权限
		//AuthorityUser auth = (AuthorityUser) principals.getPrimaryPrincipal();
		Session session = SecurityUtils.getSubject().getSession();
		AuthorityUser auth = (AuthorityUser)session.getAttribute (DaifaSessionConfig.DAIFA_SESSION);

		List<TsysRole> roles=tsysRoleMapper.selRoleNamesByuserIds(auth.getDaifaWorkerId ().toString());
		//List<UserRole> roles=managerRoleMapper.selRoleNamesByuserIds(3+"");
		List<String> roleStrings=new ArrayList<String>();
		List<Permission> allPermissions=new ArrayList<Permission>();
		for(TsysRole ur:roles){
			////System.out.println(ur.getRoleTag ());
			roleStrings.add(ur.getRoleTag());
			allPermissions.addAll(simpleRolePermissionReader.resolvePermissionsInRole(ur.getRoleTag()));
		}
		info.addRoles(roleStrings);
		info.addObjectPermissions(allPermissions);
		return info;
	}

	/**
     * 授权
     */
	/*@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		////System.out.println("授权判断--------------------------------------------------");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//查出用户所有的权限
		//AuthorityUser auth = (AuthorityUser) principals.getPrimaryPrincipal();

		Session session = SecurityUtils.getSubject().getSession();
		AuthorityUser auth = (AuthorityUser)session.getAttribute ("usersession");

		List<UserRole> roles=managerRoleMapper.selRoleNamesByuserIds(auth.getUserId().toString());
		//List<UserRole> roles=managerRoleMapper.selRoleNamesByuserIds(3+"");
		List<String> roleStrings=new ArrayList<String>();
		List<Permission> allPermissions=new ArrayList<Permission>();
		for(UserRole ur:roles){
			//System.out.println(ur.getRoleTag ());
			roleStrings.add(ur.getRoleTag());
			allPermissions.addAll(simpleRolePermissionReader.resolvePermissionsInRole(ur.getRoleTag()));
		}
		info.addRoles(roleStrings);
		info.addObjectPermissions(allPermissions);
		return info;
	}*/

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
		setCredentialsMatcher(customCredentialsMatcher);
	}

	public SimpleRolePermissionReader getSimpleRolePermissionReader() {
		return simpleRolePermissionReader;
	}

	public void setSimpleRolePermissionReader(SimpleRolePermissionReader simpleRolePermissionReader) {
		this.simpleRolePermissionReader = simpleRolePermissionReader;
	}
}
	
