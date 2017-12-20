import com.shigu.main4.tools.RedisIO;
import com.shigu.spread.services.RedisForIndexPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

/**
 * Created by zhulm on 17/6/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations="/main4/spring/cachetest.xml" )
public class RedisForIndexPageTest {

    @Autowired
    RedisForIndexPage redisForIndexPage;
    @Test
    public void putCache() {
        redisForIndexPage.putCache("123", "123Value");
    }

    @Test
    public void getCache() throws Exception {
       System.out.println("================================" + redisForIndexPage.getFromCache("123", String.class));
    }

    @Test
    public void clearCache() {
        redisForIndexPage.clearCache("123");
    }
}
