package com.shigu.main4.ucenter.services.test.zjb;

import com.shigu.main4.ucenter.services.UserBaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * 用户基本信息查询
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/main4/spring/apache-shiro.xml" )
public class UserBaseServiceTest {

    @Resource(name = "userBaseService")
    private UserBaseService userBaseService;

    /**
     * 第三方解绑
     */
    @Test
    public void unBindUser(){
        Long userId = 1000038564L;
        Long suUserId = 1000051747L;

        System.out.println("删除用户子表第三方绑定>>此处删除失败返回记录数0不会抛异常");

        userBaseService.unBindUser(userId, suUserId);

    }

}
