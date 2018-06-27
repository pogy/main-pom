import com.shigu.sn.client.SnSdkClient;
import com.suning.api.entity.custom.CategoryredictGetRequest;
import com.suning.api.entity.custom.CategoryredictGetResponse;
import com.suning.api.entity.fontorder.IsvorderQueryRequest;
import com.suning.api.entity.fontorder.IsvorderQueryResponse;
import com.suning.api.entity.item.CategoryQueryRequest;
import com.suning.api.entity.item.CategoryQueryResponse;
import com.suning.api.exception.SuningApiException;
import org.junit.Test;

public class ApiTest {
    @Test
    public void client() throws SuningApiException {
        SnSdkClient snSdkClient=new SnSdkClient();
        IsvorderQueryRequest isvorderQueryRequest = new IsvorderQueryRequest();
        isvorderQueryRequest.setOrderStartTime("2000-01-01 00:00:00");
        isvorderQueryRequest.setOrderEndTime("2018-06-14 00:00:00");
        isvorderQueryRequest.setPageNo(1);
        isvorderQueryRequest.setPageSize(10);
        isvorderQueryRequest.setItemCode("123456");
        isvorderQueryRequest.setBuyerCode("70177742");
        IsvorderQueryResponse isvorderQueryResponse = snSdkClient.testSend(isvorderQueryRequest, "f9ebbfe7100e089b18c1f85513e74678", "03e372c1b0c9a2440844740262cf1dd4");
        System.out.println(isvorderQueryResponse.getBody());
    }

    @Test
    public void cat() throws SuningApiException{
        SnSdkClient snSdkClient=new SnSdkClient();
        CategoryQueryRequest request=new CategoryQueryRequest();
        request.setCategoryName("服饰鞋帽");
        request.setPageNo(1);
        request.setPageSize(10);
        request.setCheckParam(true);
        CategoryQueryResponse res= snSdkClient.testSend(request, "715ddac6a126cbd540b8203a08a4ad73", "6779e1cddd0567e09df169d66daca2cb");
        System.out.println(res.getBody());
    }
}
