import com.shigu.main4.common.util.UUIDGenerator;
import com.shigu.main4.tools.RedisIO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.util.HashSet;
import java.util.Set;

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
    public void redisUpTest(){
        String KEY_IN_REDIS="KEY_IN_REDIS2";
        String findType="DAILY";
        Long pemId=111L;
        Long userId=222L;
        Long goodsId=123L;
        String key=KEY_IN_REDIS+findType+"_"+pemId+"_"+userId;
        Set goodsIdSet=redisIO.get(key,Set.class);
        System.out.println(goodsIdSet);
        System.out.println(goodsIdSet.contains(goodsId.intValue()));
    }

    @Test
    public void putSetTest(){
        String KEY_IN_REDIS="KEY_IN_REDIS";
        String findType="DAILY";
        Long pemId=111L;
        Long userId=222L;
        String key=KEY_IN_REDIS+findType+"_"+pemId+"_"+userId;
        Set<Long> goodsSet=new HashSet<>();
        goodsSet.add(123L);
        goodsSet.add(234L);
        goodsSet.add(123L);
        goodsSet.add(345L);
        redisIO.putFixedTemp(key,goodsSet,1000);
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
    @Test
    public void getAllKey(){

       // Jedis jedis = redisIO.getJedis();
       // String ping = jedis.ping();
        //System.out.println("ping="+ping);
        //String s = jedis.get("phone_login_token");
        //System.out.println("key="+s);
        //删除
       // String uuid = UUIDGenerator.getUUID();
       // redisIO.putFixedTemp("phone_login_token",uuid,60);
        String phone_login_token = redisIO.get("phone_login_token"+"1000085908");

        System.out.println("**********************************"+"phone_login_token=***"+phone_login_token);
       /* redisIO.del("phone_login_token");
        String phone_login_token = redisIO.get("phone_login_token");
        System.out.println("**********************************"+"phone_login_token"+phone_login_token);*/
    }

}
