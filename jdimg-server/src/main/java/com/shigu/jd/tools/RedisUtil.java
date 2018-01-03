package com.shigu.jd.tools;

import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis用的工具
 * Created by zhaohongbo on 16/12/15.
 */
public class RedisUtil {
    /**
     * 字节化key
     * @param key
     * @return
     */
    public static byte[] parseKey(String key){
        RedisSerializer<String> stringRedisSerializer=new StringRedisSerializer();
        return stringRedisSerializer.serialize(key);
    }

    /**
     * 格式化key
     * @param key
     * @return
     */
    public static String formatKey(byte[] key){
        RedisSerializer<String> stringRedisSerializer=new StringRedisSerializer();
        return stringRedisSerializer.deserialize(key);
    }

    /**
     * 字节化value
     * @param value
     * @return
     */
    public static byte[] parseValue(Object value){
        JdkSerializationRedisSerializer jdkSerializationRedisSerializer=new JdkSerializationRedisSerializer();
        return jdkSerializationRedisSerializer.serialize(value);
    }

    /**
     * 格式化value
     * @param value
     * @return
     */
    public static Object formatValue(byte[] value){
        JdkSerializationRedisSerializer jdkSerializationRedisSerializer=new JdkSerializationRedisSerializer();
        return jdkSerializationRedisSerializer.deserialize(value);
    }
}
