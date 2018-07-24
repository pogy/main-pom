import com.shigu.services.SendMsgService;
import net.sf.json.JSONObject;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeAction;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequestBuilder;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaohongbo on 17/2/28.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(value = "/main4/spring/test.xml")
public class MsgTest {

//    @Autowired
    SendMsgService sendMsgService;
    @Test
    public void forgetTest(){
        sendMsgService.sendVerificationCode("18888971970","654321");
    }

    @Test
    public void mapTest(){
        Map<String,Object> map=new HashMap<>();
        map.put("rrr",111);
        map.put("bbb",new Date());
        map.put("aaa","haha");
        JSONObject obj=JSONObject.fromObject("{'result':'success'}");
        obj.accumulateAll(map);
        System.out.println(obj);
    }

    @Test
    public void test3(){
        String s=",,1,11,2312321,";
        System.out.println(s.split(",").length);
    }

    @Test
    public void test4() throws UnknownHostException {
        String url = "122.224.105.246";
        String port = "9213";
        String fromIndex="shop_v3";
        String toIndex="shop_v6";
        String[] types={"hz","ss","cs","gz","jx","xh","bj"};

        Settings settings = Settings.settingsBuilder().put("cluster.name", "xz571-application").build();
        TransportClient client = TransportClient.builder().settings(settings).build();
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(url), Integer.valueOf(port)));
        IndicesAdminClient indicesAdminClient = client.admin().indices();
        AnalyzeRequestBuilder request = new AnalyzeRequestBuilder(indicesAdminClient,AnalyzeAction.INSTANCE,"goods","DDYYZY 控价135");
// request.setAnalyzer("ik");
        request.setTokenizer("ik");
// Analyzer（分析器）、Tokenizer（分词器）
        List<AnalyzeResponse.AnalyzeToken> listAnalysis = request.execute().actionGet().getTokens();
        for(AnalyzeResponse.AnalyzeToken token:listAnalysis){
            System.out.println(token.getTerm()+"  ");
        }
    }
}
