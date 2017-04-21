package com.shigu.main4.ucenter.services.test.zjb;


import com.alibaba.fastjson.JSON;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 关于用户的商品操作服务测试
 *
 * @author shigu_zjb
 * @date 2017/02/24 15:51
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/main4/spring/apache-shiro.xml" )
public class UserItemServiceTest {

//    @Resource(name = "userItemService")
//    private UserItemService userItemService;

//    /**
//     * 查询已上传的宝贝
//     */
//    @Test
//    public void uploadedItemsTest(){
//        Long userId = 1000000808L;
//        String target = "web-tb";
//        String keyword = null;
//        Date dateFrom = stringToDate("2017-01-01 13:35:00");
//        Date dateto = stringToDate("2017-02-23 13:35:00");
//        int pageNo = 1;
//        int pageSize = 10;
//        // 完整参数查询
//        ShiguPager<OnekeyRecoreVO> onekeyRecoreVOShiguPager = userItemService.uploadedItems(userId, target, keyword, dateFrom, dateto, pageNo, pageSize);
//        System.out.println("onkey:" + JSON.toJSONString(onekeyRecoreVOShiguPager));
//
//        // 无userId
//        onekeyRecoreVOShiguPager = userItemService.uploadedItems(null, target, keyword, dateFrom, dateto, pageNo, pageSize);
//        Assert.assertTrue(onekeyRecoreVOShiguPager.getContent().size() == 0);
//
//        // keyword 判断 target
//        onekeyRecoreVOShiguPager = userItemService.uploadedItems(userId, target, null, null, dateto, pageNo, pageSize);
//        System.out.println("onkey:" + JSON.toJSONString(onekeyRecoreVOShiguPager));
//        if(onekeyRecoreVOShiguPager.getContent().size() !=0){
//            Assert.assertTrue(onekeyRecoreVOShiguPager.getContent().get(0).getTarget().equals(target));
//            for(int i = 0;i <onekeyRecoreVOShiguPager.getContent().size();i++){
//                OnekeyRecoreVO onekeyRecoreVO = onekeyRecoreVOShiguPager.getContent().get(i);
//                boolean panss = onekeyRecoreVO.getCreateDate().after(dateFrom) && onekeyRecoreVO.getCreateDate().before(dateto);
//                Assert.assertTrue(panss);
//            }
//        }
//    }
//
//    @Test
//    public void deleteUploadItem() throws Main4Exception {
//        // 用户下包含此ID
//        Long userId = 1000000808L;
//        List<String> onekeyIds = new ArrayList<String>();
//        onekeyIds.add("AVo2BzAGDe9IicjuDXnq");
//        userItemService.deleteUploadedItems(userId,onekeyIds);
//
//        // 用户不包含此ID
////        userId = 1000000808L;
////        onekeyIds = new ArrayList<String>();
////        onekeyIds.add("AVfW2ES-hgRJvn9rRcy11111");
////        userItemService.deleteUploadedItems(userId,onekeyIds);
//    }

    public static Date stringToDate(String str) {
        if (str == null) {
            return null;
        }
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(str);
        } catch (ParseException ex) {
            return null;
        }
    }

}
