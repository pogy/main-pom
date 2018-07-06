import com.shigu.sn.client.SnSdkClient;
import com.suning.api.entity.custom.CategoryredictGetRequest;
import com.suning.api.entity.custom.CategoryredictGetResponse;
import com.suning.api.entity.custom.NewbrandQueryRequest;
import com.suning.api.entity.custom.NewbrandQueryResponse;
import com.suning.api.entity.fontorder.IsvorderQueryRequest;
import com.suning.api.entity.fontorder.IsvorderQueryResponse;
import com.suning.api.entity.item.*;
import com.suning.api.entity.sale.FreighttemplateQueryRequest;
import com.suning.api.entity.sale.FreighttemplateQueryResponse;
import com.suning.api.entity.shop.ShopcategoryQueryRequest;
import com.suning.api.entity.shop.ShopcategoryQueryResponse;
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
        IsvorderQueryResponse isvorderQueryResponse = snSdkClient.testSend(isvorderQueryRequest, "f9ebbfe7100e089b18c1f85513e74678", "03e372c1b0c9a2440844740262cf1dd4","84273e51f7923bc2805de99aa5f8e7f1");
        System.out.println(isvorderQueryResponse.getBody());
    }

    @Test
    public void cat2() throws SuningApiException{
        SnSdkClient snSdkClient=new SnSdkClient();
        ProductQueryRequest request=new ProductQueryRequest();
        request.setBrandCode("899U");
        request.setCategoryCode("R6152001");
        request.setPageNo(1);
        request.setPageSize(10);
//        request.setCheckParam(true);
        ProductQueryResponse res= snSdkClient.testSend(request, "715ddac6a126cbd540b8203a08a4ad73", "6779e1cddd0567e09df169d66daca2cb","84273e51f7923bc2805de99aa5f8e7f1");
        System.out.println(res.getBody());
    }

    @Test
    public void cat() throws SuningApiException{
        SnSdkClient snSdkClient=new SnSdkClient();
        NewbrandQueryRequest request=new NewbrandQueryRequest();
        request.setCategoryCode("R6152001");
        request.setPageNo(1);
        request.setPageSize(10);
//        request.setCheckParam(true);
        NewbrandQueryResponse res= snSdkClient.testSend(request, "715ddac6a126cbd540b8203a08a4ad73", "6779e1cddd0567e09df169d66daca2cb","84273e51f7923bc2805de99aa5f8e7f1");
        System.out.println(res.getBody());
    }

    @Test
    public void cat1() throws SuningApiException{
        SnSdkClient snSdkClient=new SnSdkClient();
        CategoryQueryRequest request=new CategoryQueryRequest();
        request.setCategoryName("T恤");
        request.setPageNo(1);
        request.setPageSize(50);
//        request.setCheckParam(true);
        CategoryQueryResponse res= snSdkClient.testSend(request, "715ddac6a126cbd540b8203a08a4ad73", "6779e1cddd0567e09df169d66daca2cb","672bf348edf93c9fbb32ed4e5f1fa8a2");
        System.out.println(res.getBody());
    }

    @Test
    public void cat3() throws SuningApiException{
        SnSdkClient snSdkClient=new SnSdkClient();
        ShopcategoryQueryRequest request=new ShopcategoryQueryRequest();
        request.setPageNo(1);
        request.setPageSize(10);
//        request.setCheckParam(true);
        ShopcategoryQueryResponse res= snSdkClient.testSend(request, "715ddac6a126cbd540b8203a08a4ad73", "6779e1cddd0567e09df169d66daca2cb","669691d8a2f438379ecb689df4d1a9e3");
        System.out.println(res.getBody());
    }
}
