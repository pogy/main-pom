import com.shigu.sn.client.SnSdkClient;
import com.suning.api.DefaultSuningClient;
import com.suning.api.entity.custom.*;
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
import java.util.ArrayList;
import java.util.List;

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
        ItemparametersQueryResponse res= snSdkClient.testSend(request, "715ddac6a126cbd540b8203a08a4ad73", "6779e1cddd0567e09df169d66daca2cb","8970a34257fd313cbc529d8d9150f9ba");
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
        GetproductcodeQueryRequest request=new GetproductcodeQueryRequest();
        request.setApplycode("100612683");
//        request.setCheckParam(true);
        GetproductcodeQueryResponse res= snSdkClient.testSend(request, "715ddac6a126cbd540b8203a08a4ad73", "6779e1cddd0567e09df169d66daca2cb","c761d98dddaa39299a3f288132f94f50");
        System.out.println(res.getBody());
    }

    @Test
    public void cat7() throws SuningApiException{
        SnSdkClient snSdkClient=new SnSdkClient();
        ItemAddRequest request=new ItemAddRequest();
        request.setVerticalPic("https://image.suning.cn/uimg/sop/commodity/521845881138632379170150_x.jpg");
        request.setSupplierImg1Url("https://image.suning.cn/uimg/sop/commodity/629719423764492042538700_x.jpg");
        request.setSupplierImg2Url("https://image.suning.cn/uimg/sop/commodity/630778988801009336505300_x.jpg");
        request.setSupplierImg3Url("https://image.suning.cn/uimg/sop/commodity/758654345165413288551720_x.jpg");
        request.setSupplierImg4Url("https://image.suning.cn/uimg/sop/commodity/663963236504348439934000_x.jpg");
        request.setSupplierImg5Url("https://image.suning.cn/uimg/sop/commodity/174129465615104101801040_x.jpg");
        request.setFreightTemplateId("b3d72678ae844f36b49d277047739ec5");
        request.setSourceCountry("CN");
        request.setSellPoint(" ");
        request.setAfterSaleServiceDec(" ");
        request.setSaleSet("1");
        request.setProductName("H18 P25 S-4XL 港风原宿黑白狗情侣短袖 男女BF风日系半袖衣服");
        request.setCmTitle("H18 P25 S-4XL 港风原宿黑白狗情侣短袖T恤 男女BF风日系半袖衣服");
        request.setCategoryCode("R6152001");
        request.setBrandCode("899U");
        String in="<p style=\"text-align:center;\"><span style=\"font-family:microsoft yahei;color:#000000;font-size:12.0px;line-height:18.0px;\">———————这是小波熬夜写的文案———————</span></p>\n" +
                "\n" +
                "<p style=\"margin-top:1.12em;margin-bottom:1.12em;color:#000000;font-size:12.0px;line-height:18.0px;text-align:center;\"><strong style=\"font-size:14.0px;line-height:1.5;\"><span style=\"color:#ff0000;\"><span style=\"font-family:microsoft yahei;\"><span style=\"font-size:12.0px;\">尺寸：S M L XL XXL 3XL 4XL 颜色：白色 黑色&nbsp;</span></span></span></strong></p>\n" +
                "\n" +
                "<p style=\"margin-top:1.12em;margin-bottom:1.12em;color:#000000;font-size:12.0px;line-height:18.0px;text-align:center;\"><span style=\"font-family:microsoft yahei;\">非常干净简单的一款印花情侣短袖T恤</span></p>\n" +
                "\n" +
                "<p style=\"margin-top:1.12em;margin-bottom:1.12em;color:#000000;font-size:12.0px;line-height:18.0px;text-align:center;\"><span style=\"font-family:microsoft yahei;line-height:1.5;\">上身特别好看 简单基础设计</span></p>\n" +
                "\n" +
                "<p style=\"margin-top:1.12em;margin-bottom:1.12em;color:#000000;font-size:12.0px;line-height:18.0px;text-align:center;\"><span style=\"font-family:microsoft yahei;line-height:1.5;\">简约而不失时尚 男女都能穿 太有感觉了</span></p>\n" +
                "\n" +
                "<p style=\"margin-top:1.12em;margin-bottom:1.12em;color:#000000;font-size:12.0px;line-height:18.0px;text-align:center;\"><span style=\"font-family:microsoft yahei;line-height:1.5;\">尺码多且丰富 90斤-200斤都可穿&nbsp;</span></p>\n" +
                "\n" +
                "<p style=\"margin-top:1.12em;margin-bottom:1.12em;color:#000000;font-size:12.0px;line-height:18.0px;text-align:center;\"><span style=\"font-family:microsoft yahei;line-height:1.5;\">性价比超高 强烈推荐</span></p>\n" +
                "\n" +
                "<p style=\"margin-top:1.12em;margin-bottom:1.12em;color:#000000;font-size:12.0px;line-height:18.0px;text-align:center;\"><span style=\"color:#ff0000;font-family:microsoft yahei;line-height:1.5;\">希望大家会喜欢</span></p>\n" +
                "\n" +
                "<p style=\"margin-top:1.12em;margin-bottom:1.12em;color:#000000;font-size:12.0px;line-height:18.0px;text-align:center;\"><span style=\"color:#ff0000;font-family:microsoft yahei;line-height:1.5;\"><img style=\"max-width:750.0px;\" src=\"https://image.suning.cn/uimg/sop/commodity/123368585614532935282193_x.jpg\" align=\"absmiddle\"><img style=\"max-width:750.0px;\" src=\"https://image.suning.cn/uimg/sop/commodity/381266302134288567844390_x.jpg\" align=\"absmiddle\"><img style=\"max-width:750.0px;\" src=\"https://image.suning.cn/uimg/sop/commodity/492378753921973875743500_x.jpg\" align=\"absmiddle\"><img style=\"max-width:750.0px;\" src=\"https://image.suning.cn/uimg/sop/commodity/282830612204244788497620_x.jpg\" align=\"absmiddle\"><img style=\"max-width:750.0px;\" src=\"https://image.suning.cn/uimg/sop/commodity/182445519113257301546908_x.jpg\" align=\"absmiddle\"></span></p>";
        byte[] i=in.getBytes();
        request.setIntroduction("JTNDcCUyMHN0eWxlJTNEJTIydGV4dC1hbGlnbiUzQWNlbnRlciUzQiUyMiUzRSUzQ3NwYW4lMjBzdHlsZSUzRCUyMmZvbnQtZmFtaWx5JTNBbWljcm9zb2Z0JTIweWFoZWklM0Jjb2xvciUzQSUyMzAwMDAwMCUzQmZvbnQtc2l6ZSUzQTEyLjBweCUzQmxpbmUtaGVpZ2h0JTNBMTguMHB4JTNCJTIyJTNFJXUyMDE0JXUyMDE0JXUyMDE0JXUyMDE0JXUyMDE0JXUyMDE0JXUyMDE0JXU4RkQ5JXU2NjJGJXU1QzBGJXU2Q0UyJXU3MUFDJXU1OTFDJXU1MTk5JXU3Njg0JXU2NTg3JXU2ODQ4JXUyMDE0JXUyMDE0JXUyMDE0JXUyMDE0JXUyMDE0JXUyMDE0JXUyMDE0JTNDL3NwYW4lM0UlM0MvcCUzRSUwQSUwQSUzQ3AlMjBzdHlsZSUzRCUyMm1hcmdpbi10b3AlM0ExLjEyZW0lM0JtYXJnaW4tYm90dG9tJTNBMS4xMmVtJTNCY29sb3IlM0ElMjMwMDAwMDAlM0Jmb250LXNpemUlM0ExMi4wcHglM0JsaW5lLWhlaWdodCUzQTE4LjBweCUzQnRleHQtYWxpZ24lM0FjZW50ZXIlM0IlMjIlM0UlM0NzdHJvbmclMjBzdHlsZSUzRCUyMmZvbnQtc2l6ZSUzQTE0LjBweCUzQmxpbmUtaGVpZ2h0JTNBMS41JTNCJTIyJTNFJTNDc3BhbiUyMHN0eWxlJTNEJTIyY29sb3IlM0ElMjNmZjAwMDAlM0IlMjIlM0UlM0NzcGFuJTIwc3R5bGUlM0QlMjJmb250LWZhbWlseSUzQW1pY3Jvc29mdCUyMHlhaGVpJTNCJTIyJTNFJTNDc3BhbiUyMHN0eWxlJTNEJTIyZm9udC1zaXplJTNBMTIuMHB4JTNCJTIyJTNFJXU1QzNBJXU1QkY4JXVGRjFBUyUyME0lMjBMJTIwWEwlMjBYWEwlMjAzWEwlMjA0WEwlMjAldTk4OUMldTgyNzIldUZGMUEldTc2N0QldTgyNzIlMjAldTlFRDEldTgyNzIlMjZuYnNwJTNCJTNDL3NwYW4lM0UlM0Mvc3BhbiUzRSUzQy9zcGFuJTNFJTNDL3N0cm9uZyUzRSUzQy9wJTNFJTBBJTBBJTNDcCUyMHN0eWxlJTNEJTIybWFyZ2luLXRvcCUzQTEuMTJlbSUzQm1hcmdpbi1ib3R0b20lM0ExLjEyZW0lM0Jjb2xvciUzQSUyMzAwMDAwMCUzQmZvbnQtc2l6ZSUzQTEyLjBweCUzQmxpbmUtaGVpZ2h0JTNBMTguMHB4JTNCdGV4dC1hbGlnbiUzQWNlbnRlciUzQiUyMiUzRSUzQ3NwYW4lMjBzdHlsZSUzRCUyMmZvbnQtZmFtaWx5JTNBbWljcm9zb2Z0JTIweWFoZWklM0IlMjIlM0UldTk3NUUldTVFMzgldTVFNzIldTUxQzAldTdCODAldTUzNTUldTc2ODQldTRFMDAldTZCM0UldTUzNzAldTgyQjEldTYwQzUldTRGQTMldTc3RUQldTg4OTZUJXU2MDY0JTNDL3NwYW4lM0UlM0MvcCUzRSUwQSUwQSUzQ3AlMjBzdHlsZSUzRCUyMm1hcmdpbi10b3AlM0ExLjEyZW0lM0JtYXJnaW4tYm90dG9tJTNBMS4xMmVtJTNCY29sb3IlM0ElMjMwMDAwMDAlM0Jmb250LXNpemUlM0ExMi4wcHglM0JsaW5lLWhlaWdodCUzQTE4LjBweCUzQnRleHQtYWxpZ24lM0FjZW50ZXIlM0IlMjIlM0UlM0NzcGFuJTIwc3R5bGUlM0QlMjJmb250LWZhbWlseSUzQW1pY3Jvc29mdCUyMHlhaGVpJTNCbGluZS1oZWlnaHQlM0ExLjUlM0IlMjIlM0UldTRFMEEldThFQUIldTcyNzkldTUyMkIldTU5N0QldTc3MEIlMjAldTdCODAldTUzNTUldTU3RkEldTc4NDAldThCQkUldThCQTElM0Mvc3BhbiUzRSUzQy9wJTNFJTBBJTBBJTNDcCUyMHN0eWxlJTNEJTIybWFyZ2luLXRvcCUzQTEuMTJlbSUzQm1hcmdpbi1ib3R0b20lM0ExLjEyZW0lM0Jjb2xvciUzQSUyMzAwMDAwMCUzQmZvbnQtc2l6ZSUzQTEyLjBweCUzQmxpbmUtaGVpZ2h0JTNBMTguMHB4JTNCdGV4dC1hbGlnbiUzQWNlbnRlciUzQiUyMiUzRSUzQ3NwYW4lMjBzdHlsZSUzRCUyMmZvbnQtZmFtaWx5JTNBbWljcm9zb2Z0JTIweWFoZWklM0JsaW5lLWhlaWdodCUzQTEuNSUzQiUyMiUzRSV1N0I4MCV1N0VBNiV1ODAwQyV1NEUwRCV1NTkzMSV1NjVGNiV1NUMxQSUyMCV1NzUzNyV1NTk3MyV1OTBGRCV1ODBGRCV1N0E3RiUyMCV1NTkyQSV1NjcwOSV1NjExRiV1ODlDOSV1NEU4NiUzQy9zcGFuJTNFJTNDL3AlM0UlMEElMEElM0NwJTIwc3R5bGUlM0QlMjJtYXJnaW4tdG9wJTNBMS4xMmVtJTNCbWFyZ2luLWJvdHRvbSUzQTEuMTJlbSUzQmNvbG9yJTNBJTIzMDAwMDAwJTNCZm9udC1zaXplJTNBMTIuMHB4JTNCbGluZS1oZWlnaHQlM0ExOC4wcHglM0J0ZXh0LWFsaWduJTNBY2VudGVyJTNCJTIyJTNFJTNDc3BhbiUyMHN0eWxlJTNEJTIyZm9udC1mYW1pbHklM0FtaWNyb3NvZnQlMjB5YWhlaSUzQmxpbmUtaGVpZ2h0JTNBMS41JTNCJTIyJTNFJXU1QzNBJXU3ODAxJXU1OTFBJXU0RTE0JXU0RTMwJXU1QkNDJTIwOTAldTY1QTQtMjAwJXU2NUE0JXU5MEZEJXU1M0VGJXU3QTdGJTI2bmJzcCUzQiUzQy9zcGFuJTNFJTNDL3AlM0UlMEElMEElM0NwJTIwc3R5bGUlM0QlMjJtYXJnaW4tdG9wJTNBMS4xMmVtJTNCbWFyZ2luLWJvdHRvbSUzQTEuMTJlbSUzQmNvbG9yJTNBJTIzMDAwMDAwJTNCZm9udC1zaXplJTNBMTIuMHB4JTNCbGluZS1oZWlnaHQlM0ExOC4wcHglM0J0ZXh0LWFsaWduJTNBY2VudGVyJTNCJTIyJTNFJTNDc3BhbiUyMHN0eWxlJTNEJTIyZm9udC1mYW1pbHklM0FtaWNyb3NvZnQlMjB5YWhlaSUzQmxpbmUtaGVpZ2h0JTNBMS41JTNCJTIyJTNFJXU2MDI3JXU0RUY3JXU2QkQ0JXU4RDg1JXU5QUQ4JTIwJXU1RjNBJXU3MEM4JXU2M0E4JXU4MzUwJTNDL3NwYW4lM0UlM0MvcCUzRSUwQSUwQSUzQ3AlMjBzdHlsZSUzRCUyMm1hcmdpbi10b3AlM0ExLjEyZW0lM0JtYXJnaW4tYm90dG9tJTNBMS4xMmVtJTNCY29sb3IlM0ElMjMwMDAwMDAlM0Jmb250LXNpemUlM0ExMi4wcHglM0JsaW5lLWhlaWdodCUzQTE4LjBweCUzQnRleHQtYWxpZ24lM0FjZW50ZXIlM0IlMjIlM0UlM0NzcGFuJTIwc3R5bGUlM0QlMjJjb2xvciUzQSUyM2ZmMDAwMCUzQmZvbnQtZmFtaWx5JTNBbWljcm9zb2Z0JTIweWFoZWklM0JsaW5lLWhlaWdodCUzQTEuNSUzQiUyMiUzRSV1NUUwQyV1NjcxQiV1NTkyNyV1NUJCNiV1NEYxQSV1NTU5QyV1NkIyMiUzQy9zcGFuJTNFJTNDL3AlM0UlMEElMEElM0NwJTIwc3R5bGUlM0QlMjJtYXJnaW4tdG9wJTNBMS4xMmVtJTNCbWFyZ2luLWJvdHRvbSUzQTEuMTJlbSUzQmNvbG9yJTNBJTIzMDAwMDAwJTNCZm9udC1zaXplJTNBMTIuMHB4JTNCbGluZS1oZWlnaHQlM0ExOC4wcHglM0J0ZXh0LWFsaWduJTNBY2VudGVyJTNCJTIyJTNFJTNDc3BhbiUyMHN0eWxlJTNEJTIyY29sb3IlM0ElMjNmZjAwMDAlM0Jmb250LWZhbWlseSUzQW1pY3Jvc29mdCUyMHlhaGVpJTNCbGluZS1oZWlnaHQlM0ExLjUlM0IlMjIlM0UlM0NpbWclMjBzdHlsZSUzRCUyMm1heC13aWR0aCUzQTc1MC4wcHglM0IlMjIlMjBzcmMlM0QlMjJodHRwcyUzQS8vaW1hZ2Uuc3VuaW5nLmNuL3VpbWcvc29wL2NvbW1vZGl0eS8xMjMzNjg1ODU2MTQ1MzI5MzUyODIxOTNfeC5qcGclMjIlMjBhbGlnbiUzRCUyMmFic21pZGRsZSUyMiUzRSUzQ2ltZyUyMHN0eWxlJTNEJTIybWF4LXdpZHRoJTNBNzUwLjBweCUzQiUyMiUyMHNyYyUzRCUyMmh0dHBzJTNBLy9pbWFnZS5zdW5pbmcuY24vdWltZy9zb3AvY29tbW9kaXR5LzM4MTI2NjMwMjEzNDI4ODU2Nzg0NDM5MF94LmpwZyUyMiUyMGFsaWduJTNEJTIyYWJzbWlkZGxlJTIyJTNFJTNDaW1nJTIwc3R5bGUlM0QlMjJtYXgtd2lkdGglM0E3NTAuMHB4JTNCJTIyJTIwc3JjJTNEJTIyaHR0cHMlM0EvL2ltYWdlLnN1bmluZy5jbi91aW1nL3NvcC9jb21tb2RpdHkvNDkyMzc4NzUzOTIxOTczODc1NzQzNTAwX3guanBnJTIyJTIwYWxpZ24lM0QlMjJhYnNtaWRkbGUlMjIlM0UlM0NpbWclMjBzdHlsZSUzRCUyMm1heC13aWR0aCUzQTc1MC4wcHglM0IlMjIlMjBzcmMlM0QlMjJodHRwcyUzQS8vaW1hZ2Uuc3VuaW5nLmNuL3VpbWcvc29wL2NvbW1vZGl0eS8yODI4MzA2MTIyMDQyNDQ3ODg0OTc2MjBfeC5qcGclMjIlMjBhbGlnbiUzRCUyMmFic21pZGRsZSUyMiUzRSUzQ2ltZyUyMHN0eWxlJTNEJTIybWF4LXdpZHRoJTNBNzUwLjBweCUzQiUyMiUyMHNyYyUzRCUyMmh0dHBzJTNBLy9pbWFnZS5zdW5pbmcuY24vdWltZy9zb3AvY29tbW9kaXR5LzE4MjQ0NTUxOTExMzI1NzMwMTU0NjkwOF94LmpwZyUyMiUyMGFsaWduJTNEJTIyYWJzbWlkZGxlJTIyJTNFJTNDL3NwYW4lM0UlM0MvcCUzRQ==");

        List<Pars> list=new ArrayList<>();
        Pars pars=new Pars();
        pars.setParCode("country");
        pars.setParValue("CN");
        Pars pars1=new Pars();
        pars1.setParCode("region");
        pars1.setParValue("130");
        Pars pars2=new Pars();
        pars2.setParCode("city");
        pars2.setParValue("000001000323");
        Pars pars3=new Pars();
        pars3.setParCode("000576");
        pars3.setParValue("A249/H18");
        Pars pars8=new Pars();
        pars8.setParCode("006781");
        pars8.setParValue("02");
        Pars pars9=new Pars();
        pars9.setParCode("006830");
        pars9.setParValue("22");

        Pars pars10=new Pars();
        pars10.setParCode("007061");
        pars10.setParValue("01");
        Pars pars11=new Pars();
        pars11.setParCode("007741");
        pars11.setParValue("02");
        Pars pars12=new Pars();
        pars12.setParCode("010595");
        pars12.setParValue("02");
        Pars pars13=new Pars();
        pars13.setParCode("010693");
        pars13.setParValue("16");
        Pars pars14=new Pars();
        pars14.setParCode("010827");
        pars14.setParValue("35");
        Pars pars15=new Pars();
        pars15.setParCode("011052");
        pars15.setParValue("01");
        Pars pars16=new Pars();
        pars16.setParCode("012565");
        pars16.setParValue("04");
        Pars pars17=new Pars();
        pars17.setParCode("012603");
        pars17.setParValue("01");
        Pars pars18=new Pars();
        pars18.setParCode("014110");
        pars18.setParValue("13");
        Pars pars19=new Pars();
        pars19.setParCode("014253");
        pars19.setParValue("13");
        Pars pars20=new Pars();
        pars20.setParCode("VOLUM");
        pars20.setParValue("1");
        Pars pars21=new Pars();
        pars21.setParCode("BRGEW");
        pars21.setParValue("1");

        list.add(pars);
        list.add(pars1);
        list.add(pars2);
        list.add(pars3);
        list.add(pars8);
        list.add(pars9);
        list.add(pars10);
        list.add(pars11);
        list.add(pars12);
        list.add(pars13);
        list.add(pars14);
        list.add(pars15);
        list.add(pars16);
        list.add(pars17);
        list.add(pars18);
        list.add(pars19);
        list.add(pars20);
        list.add(pars21);
        request.setPars(list);
        request.setPrice("39");
        request.setReqFormat("json");
        List<ItemAddRequest.ChildItem> childItemList=new ArrayList<>();
        ItemAddRequest.ChildItem childItem=new ItemAddRequest.ChildItem();
        childItem.setPrice("39");
        childItem.setSupplierImg1Url("https://image.suning.cn/uimg/sop/commodity/196842899312219334624460_x.jpg");
        childItem.setInvQty("100");
        List<Pars> list1=new ArrayList<>();
        Pars pars4=new Pars();
        pars4.setParCode("G99007");
        pars4.setParValue("40码");
        Pars pars5=new Pars();
        pars5.setParCode("G00000");
        pars5.setParValue("米色");
        Pars pars6=new Pars();
        pars6.setParCode("G00001");
        pars6.setParValue("米色");
        Pars pars7=new Pars();
        pars7.setParCode("G00002");
        pars7.setParValue("40码");
        list1.add(pars4);
        list1.add(pars5);
        list1.add(pars6);
        list1.add(pars7);
        childItem.setPars(list1);
        childItemList.add(childItem);
        request.setChildItem(childItemList);
//        request.setCheckParam(true);
        ItemAddResponse res= snSdkClient.testSend(request, "715ddac6a126cbd540b8203a08a4ad73", "6779e1cddd0567e09df169d66daca2cb","00a6cdf3c1dd320889d3e0f36de24a37");
        System.out.println(res.getBody());
    }
}
