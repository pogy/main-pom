import com.shigu.sn.client.SnSdkClient;
import com.suning.api.DefaultSuningClient;
import com.suning.api.entity.custom.CategoryredictGetRequest;
import com.suning.api.entity.custom.CategoryredictGetResponse;
import com.suning.api.entity.custom.NewbrandQueryRequest;
import com.suning.api.entity.custom.NewbrandQueryResponse;
import com.suning.api.entity.fontorder.IsvorderQueryRequest;
import com.suning.api.entity.fontorder.IsvorderQueryResponse;
import com.suning.api.entity.item.*;
import com.suning.api.entity.master.CityQueryRequest;
import com.suning.api.entity.master.CityQueryResponse;
import com.suning.api.entity.master.NationQueryRequest;
import com.suning.api.entity.master.NationQueryResponse;
import com.suning.api.entity.sale.FreighttemplateQueryRequest;
import com.suning.api.entity.sale.FreighttemplateQueryResponse;
import com.suning.api.entity.shop.ShopcategoryQueryRequest;
import com.suning.api.entity.shop.ShopcategoryQueryResponse;
import com.suning.api.exception.SuningApiException;
import org.junit.Test;

import java.io.IOException;

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
    public void cat5() throws SuningApiException{
        SnSdkClient snSdkClient=new SnSdkClient();
        ItemparametersQueryRequest request=new ItemparametersQueryRequest();
        request.setCategoryCode("R6152001");
        request.setPageNo(1);
        request.setPageSize(50);
//        request.setCheckParam(true);
        ItemparametersQueryResponse res= snSdkClient.testSend(request, "715ddac6a126cbd540b8203a08a4ad73", "6779e1cddd0567e09df169d66daca2cb","672bf348edf93c9fbb32ed4e5f1fa8a2");
        System.out.println(res.getBody());
    }

    @Test
    public void cat1() throws SuningApiException{
        SnSdkClient snSdkClient=new SnSdkClient();
        CityQueryRequest request=new CityQueryRequest();
        request.setNationCode("CN");
//        request.setCheckParam(true);
        CityQueryResponse res= snSdkClient.testSend(request, "715ddac6a126cbd540b8203a08a4ad73", "6779e1cddd0567e09df169d66daca2cb","c1bccdea8ef33eafa816371d51181e16");
        System.out.println(res.getBody());
    }

    @Test
    public void cat3() throws SuningApiException,IOException{
//        SnSdkClient snSdkClient=new SnSdkClient();
//        NPicAddRequest request=new NPicAddRequest();
//        request.setPicFileData("/home/yxg/图片/psb.jpeg");
////        request.setCheckParam(true);
//        PicAddResponse res= snSdkClient.testSend(request, "715ddac6a126cbd540b8203a08a4ad73", "6779e1cddd0567e09df169d66daca2cb","eb765d8270ab3dbd97ed0ff2fda9c885");
//        System.out.println(res.getBody());
//
        NPicAddRequest request = new NPicAddRequest();
        request.setPicFileData("无");
//api入参校验逻辑开关，当测试稳定之后建议设置为 false 或者删除该行
        request.setCheckParam(true);
        String serverUrl = "https://open.suning.com/api/http/sopRequest";
        String appKey = "715ddac6a126cbd540b8203a08a4ad73";
        String appSecret = "6779e1cddd0567e09df169d66daca2cb";
        DefaultSuningClient client = new DefaultSuningClient(serverUrl, appKey,appSecret,"eb765d8270ab3dbd97ed0ff2fda9c885", "json");
        try {
            NPicAddResponse response = client.excuteMultiPart(request);
            System.out.println("返回json/xml格式数据 :" + response.getBody());
        } catch (SuningApiException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cat6() throws SuningApiException{
        SnSdkClient snSdkClient=new SnSdkClient();
        NationQueryRequest request=new NationQueryRequest();
        request.setNationName("中国");
//        request.setCheckParam(true);
        NationQueryResponse res= snSdkClient.testSend(request, "715ddac6a126cbd540b8203a08a4ad73", "6779e1cddd0567e09df169d66daca2cb","0d2f1006ed803c80a4bf73ad5c657d6a");
        System.out.println(res.getBody());
    }
}
