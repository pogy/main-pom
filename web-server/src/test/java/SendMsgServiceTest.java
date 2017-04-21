import com.shigu.services.SendMsgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Licca on 17/2/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/main4/spring/test.xml")
public class SendMsgServiceTest {

    @Autowired
    SendMsgService sendMsgService;

    @Test
    public void sendForgetPwdTest(){
//        sendMsgService.sendForgetPwd("18888971970","111111");
    }
}
