import com.openJar.requests.app.AboutMeRequest;
import com.openJar.responses.app.AboutMeResponse;
import com.openJar.tools.OpenClient;
import com.openJar.tools.PcOpenClient;
import org.junit.Test;

public class TestAboutMe {

    @Test
    public void aboutMe(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        AboutMeRequest request=new AboutMeRequest();
        request.setUserId(9968L);
        AboutMeResponse response=client.execute(request);
        System.out.println(response.getBody());
    }
}
