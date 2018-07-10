package com.shigu.main4.order.services.impltest;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.services.SellerMsgService;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by gtx on 2018/7/10.
 *
 * @author gtx
 * @since
 */
public class SellerMsgServiceImplTest extends BaseTest {

    @Resource
    private SellerMsgService sellerMsgService;

    @Test
    @Transactional
    public void markReadedTest(){
        sellerMsgService.markReaded(10000361142L,"1,,2");
//        sellerMsgService.markReaded(1000036114L,"1,,2,a");
    }

    @Test
    @Transactional
    public void deleteMsg(){
        sellerMsgService.deleteMsg(1000036114L,"3,,2");
    }
}
