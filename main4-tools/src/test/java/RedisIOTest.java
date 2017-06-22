import com.shigu.main4.tools.RedisIO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

/**
 * Created by zhaohongbo on 17/4/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations="/spring/store_test.xml" )
public class RedisIOTest {

    @Autowired
    RedisIO redisIO;
    @Test
    public void putExTest(){
        System.out.println(redisIO.putTemp("hahaha",111L,100));
//        System.out.println(redisIO.put("hehe",123L));
    }

    @Test
    public void addlistTest() throws InterruptedException {
        redisIO.rpush("gegege",1);
        redisIO.rpush("gegege",2);
        redisIO.rpush("gegege",3);
        System.out.println(redisIO.rpop("gegege"));
        System.out.println(redisIO.rpop("gegege"));
        System.out.println(redisIO.rpop("gegege"));
    }

    @Test
    public void poplistTest(){
        System.out.println(redisIO.rpoplPush("hahahahaha","123"));
    }

    @Test
    public void threadPop() throws InterruptedException {
        final RedisIO redis=redisIO;
        for(int i=0;i<10;i++)
        new Thread(){
            @Override
            public void run() {
                Jedis jedis=redis.getJedis();
                for(int i=0;i<100;i++){
                    System.out.println(jedis.rpop("hahahahaha"));
                }
            }
        }.start();
        Thread.sleep(100000);
    }

    @Test
    public void pushTest(){
        redisIO.rpush("hehehehe",5555);
    }

    @Test
    public void popTest(){
        System.out.println(redisIO.rpop("hehehehe"));
    }

    @Test
    public void test(){
        System.out.println(redisIO.getJedis().configGet("_density_pv_item_*"));
    }

    @Test
    public void hsetTest(){
        redisIO.hset("imkey","123",11);
        redisIO.hset("imkey","456",11);
//        System.out.println(redisIO.getJedis().hgetAll());
    }
}
