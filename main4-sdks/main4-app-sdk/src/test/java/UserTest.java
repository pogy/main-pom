import com.openJar.requests.app.BindUserRequest;
import com.openJar.requests.app.GetPhoneMsgRequest;
import com.openJar.requests.app.RegistRequest;
import com.openJar.responses.app.BindUserResponse;
import com.openJar.responses.app.RegistResponse;
import org.junit.Test;

/**
 * 类名：UserTest
 * 类路径：PACKAGE_NAME.UserTest
 * 创建者：王浩翔
 * 创建时间：2017-09-20 14:11
 * 项目：main-pom
 * 描述：
 */
public class UserTest extends BaseSDKClientTest {

    @Test
    public void testMsgSendRegist() {
        GetPhoneMsgRequest getPhoneMsgRequest = new GetPhoneMsgRequest();
        getPhoneMsgRequest.setTelephone("18637515786");
        getPhoneMsgRequest.setType(2);
        client.execute(getPhoneMsgRequest);
    }
    @Test
    public void testRegist() {
        RegistRequest registRequest = new RegistRequest();
        registRequest.setTelephone("18637515786");
        registRequest.setPassword("z123456");
        registRequest.setCode("543453");
        RegistResponse execute = client.execute(registRequest);
        sout(execute);
    }


//    @Test
//    public void testBindUser() throws NoSuchFieldException, IllegalAccessException {
//        PhoneVerify bindVerify = new PhoneVerify();
//        //userId
//        long tempId = 1000083680L;
//        bindVerify.setUserId(tempId);
//        //手机号
//        String telephone = "15168224104";
//        bindVerify.setPhone(telephone);
//        //绑定验证码
//        String bindCode = "bindVerify";
//        bindVerify.setVerify(bindCode);
//        //测试值临时放5分钟
//        redisIO.putTemp("phone_bind_type_msg_"+ telephone,bindVerify,300);
//        Rds3TempUser rds3TempUser = new Rds3TempUser();
//        rds3TempUser.setSubUserKey("32235ea1d3674b4ea3762ebe8364814d");
//        rds3TempUser.setSubUserName("15168224104");
//        rds3TempUser.setLoginFromType(LoginFromType.XZ);
//        redisIO.putTemp("phone_rd3_temp_user_type_msg_"+"32235ea1d3674b4ea3762ebe8364814d",rds3TempUser,300);
//        BindUserRequest req = new BindUserRequest();
//        req.setTempId("32235ea1d3674b4ea3762ebe8364814d");
//        req.setTelephone(telephone);
//        req.setCode(bindCode);
//        BindUserResponse resp = client.execute(req);
//        //String sessionKey = "phone_user_session_info_type_msg_" + resp.getUserId() +"_"+ resp.getToken();
//       // PersonalSession session = redisIO.get(sessionKey, PersonalSession.class);
//        sout(resp);
//       //sout(session);
//    }
}
