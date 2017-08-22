package com.shigu.main4.store.test.whx;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.exceptions.ShopFitmentException;
import com.shigu.main4.storeservices.ShopFitmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.*;
/**
 * 类名：ShopFitmentServiceImplTest
 * 类路径：com.shigu.main4.store.test.whx.ShopFitmentServiceImplTest
 * 创建者：王浩翔
 * 创建时间：2017-08-21 18:17
 * 项目：main-pom
 * 描述：
 */

/**
 * 测试类{@link com.shigu.main4.storeservices.impl.ShopFitmentServiceImpl}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/main4/spring/store_test.xml" )
public class ShopFitmentServiceImplTest {

    /**
     * 不进行装修初始化的档口id
     */
    Long[] ignoredShopIds = {};
    /**
     * 要进行装修初始化的市场
     */
    Long[] marketIds = {};
    @Autowired
    private ShiguShopMapper shiguShopMapper;
    @Autowired
    private ShopFitmentService shopFitmentService;
    /**
     * 初始化店铺装修工具
     */
    @Test
    public void InitShopFitment() throws Exception {
        ShiguShopExample example = new ShiguShopExample();
        example.createCriteria().andMarketIdIn(Arrays.asList(marketIds)).andShopIdNotIn(Arrays.asList(ignoredShopIds));
        shiguShopMapper.selectFieldsByExample(example,FieldUtil.codeFields("shop_id")).stream().map(ShiguShop::getShopId)
                .forEach(o->{
                    try {
                        shopFitmentService.initShopFitment(o);
                    } catch (ShopFitmentException e) {
                        e.printStackTrace();
                    }
                });
    }

}