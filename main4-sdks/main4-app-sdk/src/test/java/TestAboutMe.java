import com.openJar.requests.app.*;
import com.openJar.responses.app.*;
import com.openJar.tools.OpenClient;
import com.openJar.tools.PcOpenClient;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Base64;
import java.util.Date;

public class TestAboutMe {
    //成功
    @Test
    public void aboutMe(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        AboutMeRequest request=new AboutMeRequest();
        request.setUserId(1000085908L);
        AboutMeResponse response=client.execute(request);
        System.out.println(response.getBody());
        //System.out.println("getHeadUrl:"+response.getHeadUrl()+"getPhoneBind="+response.getPhoneBind()+"getUserNick="+response.getUserNick());
    }

    //成功
    @Test
    public void CatRequest(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        CatRequest request=new CatRequest();
        request.setWebSite("hz");
        request.setType(2);
        CatResponse response = client.execute(request);
        System.out.println(response.getBody());
        //System.out.println(response.getCatGroups());
    }

    //成功
    //ItemSpreadRequest
    @Test
    public void ItemSpreadRequest(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        ItemSpreadRequest request=new ItemSpreadRequest();
        request.setSpreadCode("QZGG");
        request.setWebSite("hz");
        ItemSpreadResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    //成功
    @Test
    public void SitesRequest(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        SitesRequest request=new SitesRequest();

        SitesResponse response = client.execute(request);
        System.out.println(response.getBody());
    }

    //成功
    @Test
    public void  SearchNavRequest (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        SearchNavRequest  request=new SearchNavRequest ();
        request.setType(1);
        request.setWebSite("hz");
        SearchNavResponse response = client.execute(request);
        System.out.println(response.getBody());
    }

    //失败1
    //new成功
    @Test
    public void  OneShopRequest(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        OneShopRequest request=new OneShopRequest();
        request.setWebSite("hz");
        request.setShopId(41700L);//请检查shopId是否存在是否与站点对应
        OneShopResponse response = client.execute(request);
        System.out.println(response.getBody());
        System.out.println(""+response.getShopNum());
    }
    //失败,缺少地址错误
    @Test
    public void  UpToWxRequest (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        UpToWxRequest  request=new UpToWxRequest ();
        request.setUserId(1000085908L);
        request.setWebSite("hz");
        request.setGoodsId(20466357L);
        request.setToken("ced93b4e002748a2b88a31a9967ae521");
        UpToWxResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    //失败
    @Test
    public void  StoreCollectRequest (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        StoreCollectRequest  request=new StoreCollectRequest ();
        request.setUserId(1000085908L);
        StoreCollectResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    //失败1
    @Test
    public void ImgSearchRequest(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        ImgSearchRequest  request=new ImgSearchRequest();
        request.setImgurl("http://imgs.571xz.net/mall/xzw/e98715c4-a0e8-4b15-8904-6d6cce89edee.jpg");
        request.setWebSite("hz");
        ImgSearchResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    //缺参数
    @Test
    public void ShopSearchRequest(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        ShopSearchRequest request=new ShopSearchRequest();
        request.setWebSite("hz");

        ShopSearchResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    //成功
    @Test
    public void ItemSearchRequest(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        ItemSearchRequest request=new ItemSearchRequest();
//        request.setType(2);//2普通搜索(keywords不为空)
//        request.setKeyword("袜子");

        request.setType(1);//1商品库(cid不能为空)
        request.setCid(50000557l);//针织衫/毛衣

        ItemSearchResponse response = client.execute(request);
        System.out.println(response.getBody());
        Assert.assertTrue(response.isSuccess());
    }
    //成功
    @Test
    public void MarketsRequest(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        MarketsRequest request=new MarketsRequest();
        request.setMid(0L);//市场ID,如果传入空，默认返回这个分站的默认市
        request.setWebSite("hz");
        MarketsResponse response = client.execute(request);
        System.out.println(response.getBody());
        Assert.assertTrue(response.isSuccess());
    }

    //new成功
    @Test
    public void  ShopCatRequest (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        ShopCatRequest  request=new ShopCatRequest ();
        request.setWebSite("hz");
//        request.setShopId(15408L);//无子集测试
        request.setShopId(29737l);//有子集测试
        ShopCatResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    //成功
    @Test
    public void TestImgSpread(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        ImgSpreadRequest request=new ImgSpreadRequest();
        request.setSpreadCode("WOMAN-DT");//必须是图片式广告（goat_one_location表中goatType为0的广告）

        request.setWebSite("hz");
        ImgSpreadResponse response = client.execute(request);
        System.out.println(response.getBody());
        Assert.assertTrue(response.isSuccess());
    }
    //失败,地址
    @Test
    public void ChangePasswordRequest(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        ChangePasswordRequest request=new ChangePasswordRequest();
        //新密码
        request.setNewPwd("fei691820");
        //老密码
        //request.getOldPwd("fei691820%");
        request.setToken("");
        //  request.setUserId("1000085908");
        ChangePasswordResponse response = client.execute(request);
        System.out.println(response.getBody());
        //System.out.println(response.getCatGroups());
    }
    //失败地址
    @Test
    public void bindUserRequest(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        BindUserRequest request=new BindUserRequest();
        request.setTempId("222");
//        request.setTelephone("17637503238");
        request.setTelephone("13999999999");
        request.setCode("790692");
        request.setType("QQ");
        request.setUserNick("胡汉三");
        BindUserResponse response = client.execute(request);
        System.out.println(response.getBody());
        System.out.println(response.getUserNick()+response.getImgsrc()+response.getToken()+response.getImSeller()+response.getUserId());
        Assert.assertTrue(response.isSuccess());
    }
    //未知
    @Test
    public void  OneItemRequest(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        OneItemRequest request=new OneItemRequest();
        request.setItemId(6000025358001L);
        OneItemResponse response = client.execute(request);
        System.out.println(response.getBody());
    }

    //失败,地址
    @Test
    public void  UpToTbRequest(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        UpToTbRequest request=new UpToTbRequest();
        request.setUserId(1000085908L);
        request.setWebSite("hz");

        UpToTbResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    //失败,地址
    @Test
    public void  MakeImgToTbRequest(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        MakeImgToTbRequest request=new MakeImgToTbRequest();
        request.setUserId(1000085908L);
        request.setWebSite("hz");
        request.setGoodsId(20466357L);
        MakeImgToTbResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    //失败
    @Test
    public void  MakePhoneToTbRequest (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        MakePhoneToTbRequest  request=new MakePhoneToTbRequest ();

        MakePhoneToTbResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    //失败
    @Test
    public void  SelTbTemplateRequest(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        SelTbTemplateRequest request=new SelTbTemplateRequest();
        request.setUserId(1000085908L);
        SelTbTemplateResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    //失败url
    @Test
    public void  SelTbShopcatRequest (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        SelTbShopcatRequest  request=new SelTbShopcatRequest ();
        request.setUserId(1000085908L);
        SelTbShopcatResponse response = client.execute(request);
        System.out.println(response.getBody());
    }
    //失败
    @Test
    public void  DoStoreCollectRequest (){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        DoStoreCollectRequest  request=new DoStoreCollectRequest ();

        DoStoreCollectResponse response = client.execute(request);
        System.out.println(response.getBody());
    }

    //失败
    @Test
    public void ImgUploadRequest() throws FileNotFoundException {
        OpenClient client = new PcOpenClient("3838438", "37456A6A5CA10F9A988F12BFECD88575", "test");

        String filePath = "D:\\test.png";
//        String filePath = "D:\\test2.jpg";
        String extention = filePath.substring(filePath.indexOf("."),filePath.length());
        byte[] file = TestAboutMe.fileToByteArrays(filePath);

        ImgUploadRequest request = new ImgUploadRequest();
        request.setFile( Base64.getEncoder().encodeToString(file));
        request.setType(1);
        request.setUserId(13456872821l);
        request.setExtension(extention);

        System.out.println(request.testApiUrl());
        ImgUploadResponse response = client.execute(request);
        System.out.println(response.getBody());
    }


    public static byte[] fileToByteArrays(String filePath) {
        byte[] buff = null;
        InputStream is = null;
        try {
            File file = new File(filePath);
            is = new BufferedInputStream(new FileInputStream(file));
            buff = new byte[is.available()]; // available适合于本地文件读取，不适用于网络文件
            is.read(buff);
        } catch (IOException ex) {
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
            }
        }
        return buff;
    }
}
