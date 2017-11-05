package com.whx;

import com.item.test.BaseSpringTest;
import com.shigu.main4.item.services.utils.OuterSynUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类名：TbUnauthSynTest
 * 类路径：com.whx.TbUnauthSynTest
 * 创建者：王浩翔
 * 创建时间：2017-11-05 12:12
 * 项目：main-pom
 * 描述：
 */
public class TbUnauthSynTest extends BaseSpringTest {
    @Autowired
    OuterSynUtil taobaoUnauthorizedSynService;

    @Test
    public void testSynShop(){
        taobaoUnauthorizedSynService.synOneShop(43429L);
    }

    @Autowired
    OuterSynUtil wsyUnauthorizedSynService;
    @Test
    public void t(){
        wsyUnauthorizedSynService.synOneShop(43429L,1090076L);
    }
}
