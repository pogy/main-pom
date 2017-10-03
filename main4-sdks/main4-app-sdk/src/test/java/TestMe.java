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
        request.setPassword("fei691820");
        request.setType(1);
        LoginResponse response = client.execute(request);
        System.out.println(response.getUsers().getUserId());//1000085908
        System.out.println(response.getUsers().getToken());//865c7c17a0374c11950f1946926d48b0
        System.out.println(response.getBody());
    }
    //发送验证码
    @Test
    public void  getPhoneMsgRequest  (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        GetPhoneMsgRequest request=new GetPhoneMsgRequest ();
        request.setTelephone("17637503238");
        request.setType(3);
        GetPhoneMsgResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    //修改密码
    @Test
    public void  ChangePasswordRequest   (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        ChangePasswordRequest  request=new ChangePasswordRequest();
        request.setUserId(1000085908L);

        request.setOldPwd("fei691820");
        request.setNewPwd("fei691820%");
        request.setToken("d6d035ec810c4612bd2cb8f0f80f1bb6");
        ChangePasswordResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    @Test
    public void  ForgetPasswordRequest   (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        ForgetPasswordRequest request=new ForgetPasswordRequest();
        request.setTelephone("17637503238");
        request.setMsgCode("037452");
        request.setNewPassword("fei691820%");
        ForgetPasswordResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    @Test
    public void  RegistRequest   (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        RegistRequest request=new RegistRequest();
        request.setTelephone("17637503231");
        request.setPassword("fei691820");
        request.setCode("125195");
        RegistResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    @Test
    public void  OrtherLoginRequest    (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        OrtherLoginRequest  request=new OrtherLoginRequest ();
        request.setType(1);
        request.setNick("tb9950563");
        OrtherLoginResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    @Test
    public void  DoStoreCollectRequest(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        DoStoreCollectRequest request=new DoStoreCollectRequest();
        request.setShopId(43455L);
        request.setToken("ad24a062bbe646bd9a18cf159c69ce39");
        request.setUserId(1000085908L);
        request.setYesOrNo(true);
        DoStoreCollectResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
}