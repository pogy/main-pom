package com.item.test.wxc;

import com.shigu.main4.item.services.utils.FileImgsUtil;
import org.junit.Test;

/**
 * Created by Administrator on 2017/4/20 0020.
 */
public class FileImgsUtilTest {

    @Test
    public void test() throws Exception {
        FileImgsUtil.zip("D:/kit/apache-tomcat-7.0.77/temp/201704/123123", "D:/kit/apache-tomcat-7.0.77/temp/201704/123123.zip");
    }
}
