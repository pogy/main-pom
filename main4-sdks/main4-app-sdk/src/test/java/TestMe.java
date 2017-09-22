import com.openJar.requests.app.ChangePasswordRequest;
import com.openJar.requests.app.DoStoreCollectRequest;
import com.openJar.requests.app.GetPhoneMsgRequest;
import com.openJar.requests.app.LoginRequest;
import com.openJar.responses.app.ChangePasswordResponse;
import com.openJar.responses.app.DoStoreCollectResponse;
import com.openJar.responses.app.GetPhoneMsgResponse;
import com.openJar.responses.app.LoginResponse;
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

        System.out.println(response.getBody());
    }
    @Test
    public void  getPhoneMsgRequest  (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        GetPhoneMsgRequest request=new GetPhoneMsgRequest ();
        request.setTelephone("17637503238");
        request.setType(1);
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
        request.setToken("01de053bf53c47a2a9e14fca37354ed5");
        ChangePasswordResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
}