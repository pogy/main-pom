package com.shigu.main4.ucenter.services.test.zjb;

import com.opentae.data.mall.beans.MemberLoginRecord;
import com.shigu.main4.ucenter.services.RegisterAndLoginService;
import com.shigu.main4.ucenter.services.impl.MemberLoginRecordServiceImpl;
import com.shigu.main4.ucenter.vo.LoginRecord;
import com.shigu.main4.ucenter.vo.RegisterUser;
import com.shigu.session.main4.Rds3TempUser;
import com.shigu.session.main4.enums.LoginFromType;
import org.apache.ibatis.type.Alias;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * 登录注册服务测试类
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/main4/spring/spring.xml" )
public class RegisterAndLoginServiceTest {

    @Autowired
    private RegisterAndLoginService registerAndLoginService;

    @Autowired
    private MemberLoginRecordServiceImpl memberLoginRecordService;


    /**
     * 注册新用户
     * @throws Exception
     */
    @Test
    public void registerMemberUser() throws Exception {

        RegisterUser registerUser = new RegisterUser();

        registerUser.setPassword("1234567");

        assertEquals(null, registerAndLoginService.registerByPhone(registerUser));

        registerUser.setTelephone("15270970409");

        assertEquals(null, registerAndLoginService.registerByPhone(registerUser));

        registerUser.setUserNick("我是小灰灰");

        // 已经存在的login_phone or user_name
        assertEquals(null, registerAndLoginService.registerByPhone(registerUser));

        registerUser.setTelephone("18070130002");

        assertNotNull(registerAndLoginService.registerByPhone(registerUser));
    }

    /**
     * 绑定用户
     * @throws Exception
     */
    @Test
    @Transactional(rollbackFor = Exception.class)
    public void banding3User() throws Exception{
        String phone = "18258259333";
        Rds3TempUser rds3TempUser = new Rds3TempUser();
        rds3TempUser.setSubUserName("aj欧美专柜代购");
        rds3TempUser.setSubUserKey("2224501970");
        rds3TempUser.setLoginFromType(LoginFromType.TAOBAO);

        // 已存在该主用户 不存在该子账户 正常返回true并创建QQ子账户
//        assertEquals(true, registerAndLoginService.bind3RdUser(phone, rds3TempUser));
        assertTrue(registerAndLoginService.bind3RdUser(phone,rds3TempUser));

        // 存在该子账户QQ 存在主账号 正常返回false
//        assertEquals(false, registerAndLoginService.bind3RdUser(phone, rds3TempUser));
//
//        phone = "18070130001";
//
//        rds3TempUser.setSubUserName("my_name_is_wxcxs");
//        rds3TempUser.setSubUserKey("7409718958");
//        rds3TempUser.setLoginFromType(LoginFromType.ALI);
//
//        // 主账号不存在 子账号也不存足 正常返回true 创建主账号与子账号
//        assertEquals(true, registerAndLoginService.bind3RdUser(phone, rds3TempUser));
    }


    /**
     * 绑定用户
     * @throws Exception
     */
    @Test
    @Transactional(rollbackFor = Exception.class)
    public void banding3UserNoTBNoPhone() throws Exception{

    }

    /**
     * 登录记录
     */
    @Test
    public void loginRecord(){
        registerAndLoginService.loginRecord(null);
        LoginRecord loginRecord = new LoginRecord();
        registerAndLoginService.loginRecord(loginRecord);
        loginRecord.setLoginFromType(LoginFromType.ALI);
        registerAndLoginService.loginRecord(loginRecord);
        loginRecord.setSubUserName("my_name_is_zjb");
        registerAndLoginService.loginRecord(loginRecord);
        loginRecord.setIp("120.25.87.99");
        registerAndLoginService.loginRecord(loginRecord);
        loginRecord.setSubUserId(11L);
        registerAndLoginService.loginRecord(loginRecord);
        loginRecord.setTime(new Date());
        registerAndLoginService.loginRecord(loginRecord);
        loginRecord.setUserId(1L);
        registerAndLoginService.loginRecord(loginRecord);
    }

    /**
     * 数据迁移
     */
    @Test
    public void loginRecordRransfer(){
        int pageNo = 1;
        int pageSize = 100;
        List<MemberLoginRecord> memberLoginRecordList = memberLoginRecordService.findLoginRecordList(1, 100);
        if (memberLoginRecordList == null || memberLoginRecordList.size() == 0) {
            return;
        }
        for (int i = 0; i < memberLoginRecordList.size(); i++) {
            MemberLoginRecord memberLoginRecord = memberLoginRecordList.get(i);
            if(memberLoginRecord == null){
                continue;
            }
            LoginRecord loginRecord = new LoginRecord();
            loginRecord.setUserId(memberLoginRecord.getUserId());
            loginRecord.setSubUserId(memberLoginRecord.getSubUserId());
            loginRecord.setSubUserName(memberLoginRecord.getSubUserName());
            loginRecord.setTime(memberLoginRecord.getLastTime());
            loginRecord.setIp(memberLoginRecord.getLastIp());
            LoginFromType loginFromType = LoginFromType.getLoginFromType(memberLoginRecord.getAccountType());
            loginRecord.setLoginFromType(loginFromType);
            registerAndLoginService.loginRecord(loginRecord);
        }

    }

    /**
     * 判断手机号是否允许注册
     */
    @Test
    public void userCanRegist(){
        String phone = "15270970408";
        boolean panss =  registerAndLoginService.userCanRegist(phone ,LoginFromType.PHONE);
        System.out.println("该手机号允许注册，返回：" + panss);

        phone = "15270970409";
        panss =  registerAndLoginService.userCanRegist(phone, LoginFromType.PHONE);
        System.out.println("该手机号不允许注册，返回：" + panss);

        String userName = "忆逝";
        panss = registerAndLoginService.userCanRegist(userName ,LoginFromType.WX);
        System.out.println("存在该用户昵称：" + userName + " 返回：" + panss);
    }

    /**
     * 用户名反查用户ID
     */
    @Test
    public void selUserIdByName(){
        String userName = "忆逝";
        Long userId = registerAndLoginService.selUserIdByName(userName, LoginFromType.WX);
        System.out.println("用户名反查用户ID:" + userId);

        userName = "忆逝1111";
        userId = registerAndLoginService.selUserIdByName(userName, LoginFromType.ALI);
        System.out.println("用户名反查用户ID,返回null:" + userId);

        System.out.println("测试memberUserSub存在，和用户权益也存在，反查userID");
        userName = "18070130002";
        userId = registerAndLoginService.selUserIdByName(userName, LoginFromType.PHONE);
        System.out.println("用户名反查用户ID,返回:" + userId);

        System.out.println("测试memberUserSub不存在，和用户权益存在，反查userID");
        userName = "15270970401";
        userId = registerAndLoginService.selUserIdByName(userName, LoginFromType.PHONE);
        System.out.println("用户名反查用户ID,返回:" + userId);
    }
}
