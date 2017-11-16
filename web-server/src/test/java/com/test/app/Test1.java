package com.test.app;

import com.shigu.component.encryption.MD5;
import com.shigu.main4.common.util.UUIDGenerator;

/**
 * 类名：Test1
 * 类路径：com.test.app.Test1
 * 创建者：任真飞
 * 创建时间：2017-09-19 15:51
 * 项目：main-pom
 * 描述：
 */
public class Test1 {
    public static void main( String[] args ) {
        String uuid = UUIDGenerator.getUUID();
        System.out.println("uuid="+uuid);
        String s = MD5.encrypt("123456");
        System.out.println("MD5="+s);
    }
}