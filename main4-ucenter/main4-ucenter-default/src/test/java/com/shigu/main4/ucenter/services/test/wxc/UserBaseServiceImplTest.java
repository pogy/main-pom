package com.shigu.main4.ucenter.services.test.wxc;

import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.ucenter.services.UserBaseService;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by wxc on 2017/3/27.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/main4/spring/spring.xml")
public class UserBaseServiceImplTest {

    @Autowired
    private UserBaseService userBaseService;
    @Autowired
    private MemberUserSubMapper memberUserSubMapper;
    @Autowired
    private ShiguShopMapper shiguShopMapper;
    /**
     * 测试解绑用户子账号，如果是淘宝子账号，解绑所在店铺userId
     */
    @Test
    @Transactional(rollbackFor = Exception.class)
    public void unBindUser() throws Exception {
        //验证店铺存在
        ShiguShop shop = shiguShopMapper.selectByPrimaryKey(41844L);
        assertTrue("测试店铺不存在", shop != null);
        assertTrue("测试店铺不属于userId=1000038336", shop.getUserId() == 1000038336);

        // 验证子账号存在
        MemberUserSub userSub = memberUserSubMapper.selectByPrimaryKey(1000053211L);
        assertTrue("测试账号的淘宝子账号不存在", userSub != null);
        assertTrue("测试子账号不属于账号1000038336", userSub.getUserId() == 1000038336);

        userBaseService.unBindUser(1000038336L, 1000053211L);

        shop = shiguShopMapper.selectByPrimaryKey(41844L);

        assertTrue("解绑淘宝子账号失败",shop.getUserId() == null);
        assertTrue("解绑淘宝子账号失败",memberUserSubMapper.selectByPrimaryKey(1000053211L) == null);
    }

}