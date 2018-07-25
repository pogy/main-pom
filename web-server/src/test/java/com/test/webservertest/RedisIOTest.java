package com.test.webservertest;

import com.alibaba.fastjson.JSON;
import com.openJar.tools.OpenClient;
import com.openJar.tools.PcOpenClient;
import com.shigu.main4.tools.RedisIO;

import java.lang.reflect.Field;

/**
 * 类名：RedisIOTest
 * 类路径： com.test.webservertest.RedisIOTest
 * 创建者： whx
 * 创建时间： 7/24/18 12:57 PM
 * 项目： main-pom
 * 描述：
 */
public class RedisIOTest {
    protected OpenClient client = new PcOpenClient("3838438", "37456A6A5CA10F9A988F12BFECD88575", "test");
    protected RedisIO redisIO = getRedisIOInstance();
    protected void sout(Object obj){
        System.out.println(JSON.toJSONString(obj));
    }

    public static void main(String[] args) {
        RedisIOTest test = new RedisIOTest();
        RedisIO redisIO = test.getRedisIOInstance();
        redisIO.put("shigu_rebate_type", "true");
    }


    private RedisIO getRedisIOInstance() {
        RedisIO redisIO = new RedisIO();
        try {
            setValues(redisIO, "IP", "192.168.1.193");
            setValues(redisIO, "PORT", 6379);
            setValues(redisIO, "AUTH", "test123");
            setValues(redisIO, "MAX_ACTIVE", 600);
            setValues(redisIO, "MAX_IDLE", 300);
            setValues(redisIO, "MAX_WAIT", 1000);
        } catch (IllegalAccessException | NoSuchFieldException ignore) {
        }
        redisIO.init();
        return redisIO;
    }

    private void setValues(Object object, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object, value);
    }
}
