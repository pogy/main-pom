package com.shigu.main4.monitor.test;

import com.alibaba.fastjson.JSON;
import com.shigu.main4.monitor.service.impl.StarCaculateServiceImpl;
import com.shigu.main4.monitor.services.StarCaculateService;
import com.shigu.main4.tools.RedisIO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by wxc on 2017/3/8.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations="/spring/store_test.xml" )
public class StarCalculatorTest {

    @Autowired
    RedisIO redisIO;

    @Autowired
    StarCaculateService starCaculateService;

    @Test
    public void testJSONString() {
        System.out.println(JSON.parseObject(null, Integer.class));
    }

    /**
     * 这里对吗？？？
     */
    @Test
    public void testCacheForAdd() {
        // 保证测试数据清洁
        assertTrue("请删除该ID测试数据，重新运行测试", redisIO.get(9968 + "", Long.TYPE) == null);

        assertFalse(starCaculateService.cacheForAdd(9968L, 5L));//  null    ->  1
        assertTrue(redisIO.get(9968 + "", Long.TYPE) == 1);
        assertFalse(starCaculateService.cacheForAdd(9968L, 5L));//  1       ->  2
        assertTrue(redisIO.get(9968 + "", Long.TYPE) == 2);
        assertFalse(starCaculateService.cacheForAdd(9968L, 5L));//  2       ->  3
        assertTrue(redisIO.get(9968 + "", Long.TYPE) == 3);
        assertFalse(starCaculateService.cacheForAdd(9968L, 5L));//  3       ->  4
        assertTrue(redisIO.get(9968 + "", Long.TYPE) == 4);
        assertFalse(starCaculateService.cacheForAdd(9968L, 5L));//  4       ->  5
        assertTrue(redisIO.get(9968 + "", Long.TYPE) == 5);

        assertTrue(starCaculateService.cacheForAdd(9968L, 5L));//   5       ->  1
        assertFalse(starCaculateService.cacheForAdd(9968L, 5L));//  1       ->  2
        assertFalse(starCaculateService.cacheForAdd(9968L, 5L));//  2       ->  3
        assertFalse(starCaculateService.cacheForAdd(9968L, 5L));//  3       ->  4
        assertFalse(starCaculateService.cacheForAdd(9968L, 5L));//  4       ->  5

        assertTrue(starCaculateService.cacheForAdd(9968L, 5L));//   5       ->  1
        assertTrue(redisIO.get(9968 + "", Long.TYPE) == 1);

        redisIO.del("9968");
    }

    @Test
    public void deleteRedisByKey() {
        redisIO.del("9968");
    }
}
