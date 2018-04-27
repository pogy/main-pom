package com.shigu.main4.item.services.utils;


import com.alibaba.fastjson.JSON;
import com.shigu.main4.tools.RedisIO;
import redis.clients.jedis.Jedis;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gtx on 2018/4/26.
 *
 * @author gtx
 * @description
 * @since
 */
public class UpdatePropValueWorker {

    public static final ExecutorService POOL  = Executors.newSingleThreadExecutor();
    public static final int MAX_QUEUE = 40;
    public static final int REDISTASK_MAXSIZE = 1000;
    public static final AtomicInteger NOW_QUEUE_SIZE = new AtomicInteger(0);
    public static final String UPDATE_PROP_VALUE_KEY = "update_prop_value_key";

    /**
     * 添加任务到队列
     */
    public static synchronized void addQueue(UpdatePropValueTask task){
        RedisIO redisIO = task.getRedisIO();
        Jedis jedis = redisIO.getJedis();
        try {
            if(MAX_QUEUE <= NOW_QUEUE_SIZE.get()){
                //队列满了存入redis 只存1000条
                Long llen = jedis.llen(UPDATE_PROP_VALUE_KEY);
                if (llen != null && llen > REDISTASK_MAXSIZE) {//直接抛弃多余任务
                    return;
                }
                jedis.rpush(UPDATE_PROP_VALUE_KEY, JSON.toJSONString(task));
                return;
            }
            NOW_QUEUE_SIZE.addAndGet(1);
            try {
                POOL.submit(task);
            } catch (Exception e) {//如果加进程失败,有可能在重置队列
                NOW_QUEUE_SIZE.addAndGet(-1);
            }
        } finally {
            if (jedis != null) {
                redisIO.returnJedis(jedis);
            }
        }
    }


}
