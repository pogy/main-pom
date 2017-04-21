package com.shigu.main4.test.factory;

/**
 * Created by zhaohongbo on 17/3/31.
 */
public class TestFactory {


    public TestBean makeTestBean(Long userId){
        System.out.println(userId+"  55555555555");
        return new TestBean();
    }
}
