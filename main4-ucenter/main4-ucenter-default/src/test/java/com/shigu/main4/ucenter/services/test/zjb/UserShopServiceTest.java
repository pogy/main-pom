package com.shigu.main4.ucenter.services.test.zjb;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.services.UserShopService;
import com.shigu.session.main4.ShopSession;
import org.apache.shiro.SecurityUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/main4/spring/apache-shiro.xml" )
@TransactionConfiguration(defaultRollback = true)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class})
@PrepareForTest({ SecurityUtils.class })
public class UserShopServiceTest {

    @Autowired
    private UserShopService userShopService;

    @Autowired
    private ShiguShopMapper shopMapper;

    /**
     * 查看用户最后一次登陆的店铺
     */
    @Test
    public void userShopSessionTest(){
        ShopSession shopSession = userShopService.selShopByUserId(2L);

        System.out.println(JSON.toJSONString(shopSession));

        shopSession = userShopService.selShopByUserId(1L);

        System.out.println(JSON.toJSONString(shopSession));
    }

    /**
     * 查看店铺下可用shop
     *
     */
    @Test
    public void selUsersAllShop(){
        List<ShopSession> shopSessionList = userShopService.selUsersAllShop(9968L);

        Assert.assertTrue(shopSessionList.size() > 0);

        System.out.println("存在店铺：" + JSON.toJSONString(shopSessionList));

        shopSessionList = userShopService.selUsersAllShop(3L);

        Assert.assertTrue(shopSessionList.size() == 0);

        System.out.println("不存在店铺：" + JSON.toJSONString(shopSessionList));
    }


    /**
     * 绑定淘宝昵称到店铺
     */
    @Test
    public void bindNickToShop() throws Main4Exception {
        String tbNick = "18070130059";

        System.out.println("用户不存在测试---");
        try{
            userShopService.bindNickToShop(tbNick);
        }catch (Main4Exception e){
            System.out.println("用户不存在测试>>error:" + e.getMessage());
        }

        tbNick = "我我是我是我";
        System.out.println("店铺不存在测试---");
        Long shopId = userShopService.bindNickToShop(tbNick);
        Assert.assertNull(shopId);

        System.out.println("设定成功测试---");
        tbNick = "frf8320";
        shopId = userShopService.bindNickToShop(tbNick);
        System.out.println("设置成功返回店铺ID:"+shopId);
    }

}
