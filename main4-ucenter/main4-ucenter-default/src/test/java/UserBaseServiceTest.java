//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.shigu.main4.ucenter.services.UserBaseService;
//import com.shigu.main4.ucenter.vo.OuterUser;
//import com.shigu.main4.ucenter.vo.UserInfo;
//import com.shigu.main4.ucenter.vo.UserInfoUpdate;
//import com.shigu.session.main4.PersonalSession;
//import com.shigu.session.main4.enums.LoginFromType;
//import com.shigu.session.main4.names.SessionEnum;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.subject.support.DelegatingSubject;
//import org.apache.shiro.web.session.HttpServletSession;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//import org.springframework.util.Assert;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
///**
// * 用户基础服务测试
// * Created by zhaohongbo on 17/2/20.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration( value="/main4/spring/apache-shiro.xml" )
//@TransactionConfiguration(defaultRollback = true)
//@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class})
//@PrepareForTest({ SecurityUtils.class })
//public class UserBaseServiceTest {
//
//    private static final Logger logger = LoggerFactory.getLogger(UserBaseServiceTest.class);
//
//    @Autowired
//    @InjectMocks
//    UserBaseService userBaseService;
//
//    @Test
//    public void selUserForSessionByUserNameTest(){
//        PersonalSession ps=userBaseService.selUserForSessionByUserName("15820463349", LoginFromType.XZ);
//        Assert.notNull(ps);
//        PersonalSession ps2=userBaseService.selUserForSessionByUserName("tttt24",LoginFromType.XZ);
//        Assert.isNull(ps2);
//        PersonalSession psTb=userBaseService.selUserForSessionByUserName("赵洪波5",LoginFromType.TAOBAO);
//        Assert.notNull(psTb);
//    }
//
//    @Test
//    public void selUserPwdByUserId(){
//        assertEquals("dcc62e31c8030d9488969c5da73d2f16",userBaseService.selUserPwdByUserId(9968L));
//    }
//
//    @Test
//    public void testSelUserInfo() {
//
//        // 存在的
//        UserInfo info = userBaseService.selUserInfo(9968L);
//
//        logger.info("userId=9968\n" + JSON.toJSONString(info, SerializerFeature.PrettyFormat));
//
//        assertNotNull(info);
//
//        // 不存在的
//        info = userBaseService.selUserInfo(23333333L);
//
//        assertNull(info);
//
//        // 老头像
//        info = userBaseService.selUserInfo(2949L);
//        logger.info("userId=2949L\n" + JSON.toJSONString(info, SerializerFeature.PrettyFormat));
//
//        assertTrue(info != null && info.getHeadUrl().contains("//sgimage.571xz.com/new_image_site"));
//    }
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        PowerMockito.mockStatic(SecurityUtils.class);//使用powermock 模拟静态类
//    }
////    public PowerMockRule rule = new PowerMockRule();
//    @Test
//    public void testUpdateUserInfo() throws Exception {
//        UserInfoUpdate info = new UserInfoUpdate();
//        info.setUserId(9968L);
//        info.setUserNick("test24222");
//
//        //////////////////////MOCK///////////////////////////////////
//        PersonalSession sessionUser = new PersonalSession();
//        sessionUser.setLoginName("Mr赵");
//        sessionUser.setLoginFromType(LoginFromType.WX);
//        HttpServletSession session = PowerMockito.mock(HttpServletSession.class);
//        PowerMockito.when(session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue())).thenReturn(sessionUser);
//
////        DelegatingSubject sbj = PowerMockito.mock(DelegatingSubject.class);
////        PowerMockito.when(sbj.getSession()).thenReturn(session);
////        PowerMockito.when(SecurityUtils.getSubject()).thenReturn(sbj);
//        //TODO: 啊哦。mock失败了。。算了再议
//        //Error creating bean with name 'securityManager' defined in class path resource [main4/spring/apache-shiro.xml]: Initialization of bean failed; nested exception is java.lang.VerifyError: Expecting a stackmap frame at branch target 39
//        //Exception Details:
//        //Location:
//        //com/shigu/component/shiro/DefaultModularRealm.doAuthenticate(Lorg/apache/shiro/authc/AuthenticationToken;)Lorg/apache/shiro/authc/AuthenticationInfo; @21: ifeq
//        //Reason:
//        //Expected stackmap frame at this location.
//        //        Bytecode:
//        //0x0000000: 2ab6 003c 014d 2bc0 003e 4e2d b600 42b2
//        //0x0000010: 0048 b600 4c99 0012 2ab4 004e 1250 b900
//        //0x0000020: 5602 00c0 001d 4d2d b600 42b2 0059 b600
//        //0x0000030: 4c99 0012 2ab4 004e 125b b900 5602 00c0
//        //0x0000040: 001d 4d2c c700 0501 b02a 2c2b b600 5db0
//        //0x0000050:
//        //////////////////////MOCK///////////////////////////////////
//        int i = userBaseService.updateUserInfo(info);
//
//        assertTrue(i > 0);
//
//        /// TODO: 没有登录，session中拿不到session_user，so 抛抛空指针什么的挺正常了
//    }
//
//    @Test
//    public void selOutUsers(){
//        Long userId = 1000038564L;
//        List<OuterUser> outerUserList = userBaseService.selOuterUsers(userId);
//
//        System.out.println(JSON.toJSONString(outerUserList));
//
//        userId = 100003856411L;
//        outerUserList = userBaseService.selOuterUsers(userId);
//
//        System.out.println(JSON.toJSONString(outerUserList));
//    }
//}
