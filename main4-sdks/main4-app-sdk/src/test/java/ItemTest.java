import com.alibaba.fastjson.JSON;
import com.openJar.requests.app.ImgSearchRequest;
import com.openJar.requests.app.ItemSearchRequest;
import com.openJar.requests.app.OneItemRequest;
import com.openJar.responses.app.ImgSearchResponse;
import com.openJar.responses.app.ItemSearchResponse;
import com.openJar.responses.app.OneItemResponse;
import org.junit.Test;

/**
 * 类名：ItemTest
 * 类路径：PACKAGE_NAME.ItemTest
 * 创建者：王浩翔
 * 创建时间：2017-09-20 11:14
 * 项目：main-pom
 * 描述：
 */
public class ItemTest extends BaseSDKClientTest {

    @Test
    public void testItemSearch() {
        ItemSearchRequest req = new ItemSearchRequest();
        req.setWebSite("hz");
        req.setOrderBy("common");
        ItemSearchResponse resp = client.execute(req);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void testImgSearch() {
        ImgSearchRequest req = new ImgSearchRequest();
        req.setImgurl("https://img.alicdn.com/bao/uploaded/i4/1979258373/TB2VH2Ob3sSMeJjSspeXXa77VXa_!!1979258373.jpg_300x300.jpg");
        req.setWebSite("hz");
        ImgSearchResponse resp = client.execute(req);
        System.out.println(JSON.toJSONString(resp));
    }


    //todo:响应结果解析失败
    @Test
    public void testOneItem() {
        OneItemRequest req = new OneItemRequest();
        req.setWebSite("hz");
        req.setItemId(21447623L);
        OneItemResponse resp = client.execute(req);
        System.out.println(JSON.toJSONString(resp));
    }
}
