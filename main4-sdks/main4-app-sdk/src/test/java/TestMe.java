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
        request.setUserName("15669267663");
        request.setPassword("asd158684");
        request.setType(1);
        LoginResponse response = client.execute(request);
        System.out.println(response.getUsers().getUserId());//1000084567
        System.out.println(response.getUsers().getToken());//17e400a8654543a8b4449a8c1c96cda2
        System.out.println(response.getBody());
    }
    //发送手机号
    @Test
    public void  getPhoneMsgRequest  (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        GetPhoneMsgRequest request=new GetPhoneMsgRequest ();
        request.setTelephone("15669267663");
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
        request.setNewPwd("fei691820");
        request.setToken("37ac3d92003943f9a667707599fa180a");
        ChangePasswordResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    @Test
    public void  ForgetPasswordRequest   (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        ForgetPasswordRequest request=new ForgetPasswordRequest();
        request.setTelephone("17637503238");
        request.setMsgCode("795918");
        request.setNewPassword("fei691820");
        ForgetPasswordResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    @Test
    public void  RegistRequest   (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        RegistRequest request=new RegistRequest();
        request.setTelephone("17637503239");
        request.setPassword("fei691820");
        request.setCode("683552");
        RegistResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    @Test
    public void  DoStoreCollectRequest(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        DoStoreCollectRequest request=new DoStoreCollectRequest();
        request.setShopId(16339L);
        request.setToken("758bcd4c9c2b47d1b5763c63031b76d2");
        request.setUserId(1000084567L);
        request.setYesOrNo(true);
        DoStoreCollectResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
}