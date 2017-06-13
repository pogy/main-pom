package com.shigu.main4.monitor.test;

import com.opentae.data.mall.beans.ShiguShopLicense;
import com.opentae.data.mall.interfaces.ShiguShopLicenseMapper;
import com.shigu.main4.monitor.services.StarCaculateService;
import com.shigu.main4.tools.RedisIO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.Assert.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wxc on 2017/3/8.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations="/spring/store_test.xml" )
public class StarCaculateServiceImplTest {

    @Autowired
    private StarCaculateService starCaculateService;

    @Autowired
    private ShiguShopLicenseMapper shiguShopLicenseMapper;

    @Autowired
    RedisIO redisIO;

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void testAddBrowser() {

        // 默认100次，第101次触发加星操作
        for (int i = 1; i <= 101; i++) {
            starCaculateService.addBrower(9968L);

            // redis 中不会出现101
            if (i < 101) {
                assertTrue(redisIO.get(9968 + "", Long.TYPE) == i);
            } else {
                // 这里触发+星星，redis 缓存值被置为1
                assertTrue(redisIO.get(9968 + "", Long.TYPE) == 1);
            }
        }
        ShiguShopLicense license = new ShiguShopLicense();
        license.setShopId(9968L);
        license.setLicenseType(6);
        license = shiguShopLicenseMapper.selectOne(license);

        // 验证权益数据结果
        assertTrue(license != null && "1".equals(license.getContext()));

        redisIO.del(9968 + "");
    }

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void testAddStar() {

        ShiguShopLicense shopLicense = new ShiguShopLicense();
        shopLicense.setLicenseType(6);
        shopLicense.setShopId(9968L);
        assertTrue("测试数据必须为 null， 请清理测试数据或更换后重新运行", shiguShopLicenseMapper.selectOne(shopLicense) == null);

        starCaculateService.addStar(9968L, 10086);

        assertTrue("10086".equals(shiguShopLicenseMapper.selectOne(shopLicense).getContext()));
    }
}
