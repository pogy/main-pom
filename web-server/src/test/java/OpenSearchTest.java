import com.aliyun.opensearch.CloudsearchClient;
import com.aliyun.opensearch.CloudsearchSearch;
import com.aliyun.opensearch.object.KeyTypeEnum;
import org.junit.Test;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaohongbo on 17/4/10.
 */
public class OpenSearchTest {

    @Test
    public void test() throws IOException {
        String accesskey= "LTAINlvsCqKlSP4I";
        String secret =   "XbfaARrK5PkUtqRfqWLfy5L9OQ9nQJ";
        String appName =  "shop_test";
        String host="http://opensearch-cn-hangzhou.aliyuncs.com";
        Map<String, Object> opts = new HashMap<String, Object>();
// 这里的host需要根据访问应用详情页中提供的的API入口来确定
        CloudsearchClient client = new CloudsearchClient(accesskey, secret , host, opts, KeyTypeEnum.ALIYUN);
        CloudsearchSearch search = new CloudsearchSearch(client);
// 添加指定搜索的应用：
        search.addIndex(appName);
// 指定搜索的关键词，这里要指定在哪个索引上搜索，如果不指定的话默认在使用“default”索引（索引字段名称是您在您的数据结构中的“索引到”字段。）
//        search.setQueryString("'词典'");
        search.setQueryString("shop_test:'101'");
//        search.setQueryString("index_name:'词典'");
// 指定搜索返回的格式。
        search.setFormat("json");
        List<String> fields=new ArrayList<>();
        fields.add("shop_num");
        fields.add("shop_id");
        search.addFetchFields(fields);
// 设定过滤条件
//        search.addFilter("price>10");
// 设定排序方式 + 表示正序 - 表示降序
        search.addSort("shop_id", "+");
// 返回搜索结果
        System.out.println(search.search());
    }
}
