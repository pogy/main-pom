import com.openJar.requests.app.*;
import com.openJar.responses.app.*;
import com.openJar.tools.OpenClient;
import com.openJar.tools.PcOpenClient;
import org.junit.Test;

/**
 * 类名：TestMe
 * 类路径：PACKAGE_NAME.TestMe
 * 创建者：任真飞
 * 创建时间：2017-09-19 16:08
 * 项目：main-pom
 * 描述：
 */
public class TestMe {
    @Test
    public void  LoginRequest (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        LoginRequest request=new LoginRequest ();
        request.setUserName("17637503238");
        request.setPassword("fei691820%");
        request.setType(1);
        LoginResponse response = client.execute(request);
       // System.out.println(response.getUsers().getUserId());//1000085908
//        System.out.println(response.getUsers().getToken());//865c7c17a0374c11950f1946926d48b0
        System.out.println(response.getBody());
    }
    @Test
    public void  WxLoginRequest (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        WxLoginRequest request=new WxLoginRequest ();
        request.setNickname("卐逍遥情羽卍");
        request.setUnionid("1_oGXmPt-FFvooaQmz5EUu20Ijdu-g");
        WxLoginResponse response = client.execute(request);
        // System.out.println(response.getUsers().getUserId());//1000085908
//        System.out.println(response.getUsers().getToken());//865c7c17a0374c11950f1946926d48b0
        System.out.println(response.getBody());
    }

    //修改密码
    @Test
    public void  ChangePasswordRequest   (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        ChangePasswordRequest  request=new ChangePasswordRequest();
        request.setToken("CGNOwyTOtKPL6oXZIfbqzPirJnb1XV0UaanP/ShhLFosXfwO10GOBg==");

        request.setOldPwd("fei691820");
        request.setNewPwd("fei691820%");
        ChangePasswordResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    @Test
    public void  ForgetPasswordRequest   (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        ForgetPasswordRequest request=new ForgetPasswordRequest();
        request.setTelephone("17637503238");
        request.setMsgCode("755157");
        request.setNewPassword("fei691820%");
        ForgetPasswordResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    @Test
    public void  RegistRequest   (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        RegistRequest request=new RegistRequest();
        request.setTelephone("17637503218");
        request.setPassword("fei691820");
        request.setCode("476052");
        RegistResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    @Test
    public void  OtherLoginRequest    (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        OtherLoginRequest  request=new OtherLoginRequest ();
        request.setType(1);
        request.setNick("tb9950563");
        OtherLoginResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    //发送验证码
    @Test
    public void  getPhoneMsgRequest  (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        GetPhoneMsgRequest request=new GetPhoneMsgRequest ();
        request.setTelephone("17637503238");
        request.setType(4);
        GetPhoneMsgResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    @Test
    public void  BindUserRequest (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        BindUserRequest   request=new BindUserRequest  ();
        request.setTempId("1_oGXmPt-FFvooaQmz5EUu20Ijdu-g");
        request.setTelephone("17637503238");
        request.setCode("856093");
        request.setType("WX");
        request.setUserNick("卐逍遥情羽卍");
        BindUserResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    @Test
    public void  DoStoreCollectRequest(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        LoginRequest request=new LoginRequest ();
        request.setUserName("15669267663");
        request.setPassword("asd158684");
        request.setType(1);
        LoginResponse response = client.execute(request);
//        System.out.println(response.getUsers().getUserId());//1000085908
       //System.out.println(response.getUsers().getToken());//865c7c17a0374c11950f1946926d48b0
       // System.out.println(response.getBody());


//        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        DoStoreCollectRequest request2=new DoStoreCollectRequest();
        request2.setShopId(43457L);
        String token = response.getUsers().getToken();
        request2.setToken(token);
        request2.setUserId(1000084567L);
        request2.setYesOrNo(true);
        DoStoreCollectResponse response2 = client.execute(request2);
        System.out.println(response2.getBody());
    }
}