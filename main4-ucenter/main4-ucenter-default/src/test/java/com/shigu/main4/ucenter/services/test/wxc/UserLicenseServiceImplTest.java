package com.shigu.main4.ucenter.services.test.wxc;

import com.opentae.data.mall.beans.MemberLicense;
import com.opentae.data.mall.interfaces.MemberLicenseMapper;
import com.shigu.main4.ucenter.enums.MemberLicenseType;
import com.shigu.main4.ucenter.services.UserLicenseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by wxc on 2017/4/13.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="classpath*:/main4/spring/spring.xml" )
public class UserLicenseServiceImplTest {

    @Autowired
    private UserLicenseService userLicenseService;

    @Autowired
    private MemberLicenseMapper memberLicenseMapper;

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void selUserScore() throws Exception {
        assertTrue(0 == userLicenseService.selUserScore(null));
        assertTrue(0 == userLicenseService.selUserScore(-256L));

        MemberLicense memberLicense = new MemberLicense();
        memberLicense.setLicenseFailure(1);
        memberLicense.setContext("571");
        memberLicense.setLicenseType(MemberLicenseType.SCORE.getValue());
        memberLicense.setUserId(2024L);
        memberLicenseMapper.insertSelective(memberLicense);

        assertTrue(571L == userLicenseService.selUserScore(2024L));
    }

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void addScore() throws Exception {
        // 首次创建
        userLicenseService.addScore(9968L, 100);
        assertTrue(userLicenseService.selUserScore(9968L) == 100L);

        // 减分
        userLicenseService.addScore(2024L, -50);
        assertTrue(userLicenseService.selUserScore(2024L) == 50L);

        // 减分异常 -- 积分不足
        try {
            userLicenseService.addScore(2024L, -51);
            fail("积分不足应该抛出异常");
        } catch (Exception right) {
            assertTrue(true);
        }
    }

}