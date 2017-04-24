import com.alibaba.fastjson.JSON;
import com.searchtool.domain.SimpleElaBean;
import com.shigu.main4.cron.BulkGoodsToEs;
import com.shigu.main4.cron.SynStorecat;
import com.shigu.main4.tools.RedisIO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhaohongbo on 17/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations="/store_test.xml" )
public class CronTest {

    @Autowired
    RedisIO redisIO;

    @Autowired
    BulkGoodsToEs bulkGoodsToEs;

    @Autowired
    SynStorecat synStorecat;

    @Test
    public void testTbcat(){
        synStorecat.doContext();
    }
    @Test
    public void test() throws InterruptedException {
//        System.out.println(11);
//        System.out.println(redisIO);
//        System.out.println(bulkGoodsToEs);
//        Thread.sleep(100000);
        bulkGoodsToEs.doContext();
    }
    @Test
    public void parseTest(){
        //{"index":"shigugoodsup","source":"{\"supperImww\":\"imwww\",\"supperPrice\":\"165\",\"supperImage\":\"http://img03.taobaocdn.com/bao/uploaded/i3/TB1dZ3eGXXXXXbzXFXXXXXXXXXX_!!0-item_pic.jpg\",\"fenGoodsName\":\"2017冬装新款棉衣 糖果色四色中长款修身棉衣1111\",\"supperGoodsId\":12270481,\"supperStoreId\":32888,\"supperTelephone\":\"1515115155\",\"fenImage\":\"http://img03.taobaocdn.com/bao/uploaded/i3/TB1dZ3eGXXXXXbzXFXXXXXXXXXX_!!0-item_pic.jpg\",\"supperPiPrice\":3005,\"webSite\":\"hz\",\"supperTaobaoUrl\":\"httpppppp\",\"supperMarket\":\"asdasdasd\",\"supperStorenum\":\"2058\",\"fenNumiid\":524121231,\"fenPrice\":\"165\",\"status\":0,\"supperServers\":\"退现金,包换款\",\"supperMarketId\":644,\"supperNumiid\":41268119989,\"supperStoreName\":\"ksskks\",\"flag\":\"web-tb\",\"supperGoodsName\":\"2017冬装新款棉衣 糖果色四色中长款修身棉衣11111\",\"fenUserNick\":\"lyszhen4\",\"fenUserId\":1000006627,\"daiTime\":\"2017-04-16 19:23:17\",\"supperQq\":\"123415432534\"}","type":"hz"}
        String s="{\"index\":\"shigugoodsup\",\"source\":\"{\\\"supperImww\\\":\\\"imwww\\\",\\\"supperPrice\\\":\\\"165\\\",\\\"supperImage\\\":\\\"http://img03.taobaocdn.com/bao/uploaded/i3/TB1dZ3eGXXXXXbzXFXXXXXXXXXX_!!0-item_pic.jpg\\\",\\\"fenGoodsName\\\":\\\"2017冬装新款棉衣 糖果色四色中长款修身棉衣1111\\\",\\\"supperGoodsId\\\":12270481,\\\"supperStoreId\\\":32888,\\\"supperTelephone\\\":\\\"1515115155\\\",\\\"fenImage\\\":\\\"http://img03.taobaocdn.com/bao/uploaded/i3/TB1dZ3eGXXXXXbzXFXXXXXXXXXX_!!0-item_pic.jpg\\\",\\\"supperPiPrice\\\":3005,\\\"webSite\\\":\\\"hz\\\",\\\"supperTaobaoUrl\\\":\\\"httpppppp\\\",\\\"supperMarket\\\":\\\"asdasdasd\\\",\\\"supperStorenum\\\":\\\"2058\\\",\\\"fenNumiid\\\":524121231,\\\"fenPrice\\\":\\\"165\\\",\\\"status\\\":0,\\\"supperServers\\\":\\\"退现金,包换款\\\",\\\"supperMarketId\\\":644,\\\"supperNumiid\\\":41268119989,\\\"supperStoreName\\\":\\\"ksskks\\\",\\\"flag\\\":\\\"web-tb\\\",\\\"supperGoodsName\\\":\\\"2017冬装新款棉衣 糖果色四色中长款修身棉衣11111\\\",\\\"fenUserNick\\\":\\\"lyszhen4\\\",\\\"fenUserId\\\":1000006627,\\\"daiTime\\\":\\\"2017-04-16 19:19:33\\\",\\\"supperQq\\\":\\\"123415432534\\\"}\",\"type\":\"hz\"}";
        System.out.println(s);
        SimpleElaBean seb=JSON.parseObject(s, SimpleElaBean.class);
        System.out.println(seb);
    }
}
