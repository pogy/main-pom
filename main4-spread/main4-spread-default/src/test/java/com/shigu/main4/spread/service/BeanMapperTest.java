package com.shigu.main4.spread.service;

import com.alibaba.fastjson.JSON;
import com.shigu.main4.common.util.BeanMapper;
import org.junit.Test;

/**
 * Created by zhaohongbo on 17/5/8.
 */
public class BeanMapperTest {

    @Test
    public void bmTest(){
        T1 t1=new T1();
        t1.setName("小明");
        t1.setId(123L);
        T2 t2=new T2() {
        };
        BeanMapper.mapAbstact(t1,t2);
        System.out.println(JSON.toJSONString(t2));
    }
}
