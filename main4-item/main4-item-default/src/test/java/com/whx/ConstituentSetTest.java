package com.whx;

import com.item.test.BaseSpringTest;
import com.shigu.main4.item.services.ShopsItemService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类名：ConstituentSetTest
 * 类路径：com.whx.ConstituentSetTest
 * 创建者：王浩翔
 * 创建时间：2017-11-07 13:35
 * 项目：main-pom
 * 描述：
 */
public class ConstituentSetTest extends BaseSpringTest{

    @Autowired
    ShopsItemService shopsItemService;

    /**
     * 测试方法：{@link {com.shigu.main4.item.services.ShopsItemService}#setConstituent}
     * 描述：
     */
    @Test
    public void Name() throws Exception {
        shopsItemService.setConstituent(21742907l,43429l,"hz","面料","里料");
    }
}
