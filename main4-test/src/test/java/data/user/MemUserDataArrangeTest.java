package data.user;


import com.opentae.data.mall.interfaces.MemberUserSubCopy2Mapper;
import com.shigu.main4.test.user.service.MemberUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/ac.xml")
public class MemUserDataArrangeTest {

    @Autowired
    private MemberUserService memberUserService;

    @Autowired
    private MemberUserSubCopy2Mapper memberUserSubCopy2Mapper;

    /**
     * 整理用户数据
     */
    @Test
    public void clearUserData(){
        System.out.println("用户数 据整理开始...");

        memberUserService.clearUserData();

        System.out.println("用户数据整理结束...");
    }



}
