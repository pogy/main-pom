import com.openJar.requests.app.CatRequest;
import com.openJar.responses.app.CatResponse;
import com.openJar.tools.OpenClient;
import com.openJar.tools.PcOpenClient;
import org.junit.Test;

public class CatTest {
    protected OpenClient client = new PcOpenClient("3838438", "37456A6A5CA10F9A988F12BFECD88575", "test");

    @Test
    public void cat(){
        CatRequest request=new CatRequest();
        request.setType(1);
        request.setWebSite("hz");
        CatResponse response=client.execute(request);
        System.out.println(response.getBody());
    }
}
