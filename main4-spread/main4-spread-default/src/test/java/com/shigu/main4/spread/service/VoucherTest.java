package com.shigu.main4.spread.service;

import com.shigu.main4.spread.vo.ActiveDrawRecordVO;
import com.shigu.main4.spread.vo.ActiveForShowVO;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawPemVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 类名：VoucherTest
 * 类路径：com.shigu.main4.spread.service.VoucherTest
 * 创建者：王浩翔
 * 创建时间：2017-11-21 13:44
 * 项目：main-pom
 * 描述：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/store_test.xml")
public class VoucherTest {

    @Autowired
    VoucherService vipVoucherService;

    @Autowired
    ActiveShowService activeShowService;



    @Test
    public void obtainVoucherTest(){
        vipVoucherService.obtainVoucher(9968L,4,25L);
        vipVoucherService.obtainVoucher(9968L,5,25L);
        vipVoucherService.obtainVoucher(9968L,8,25L);
        vipVoucherService.obtainVoucher(9968L,9,25L);
        vipVoucherService.obtainVoucher(9968L,11,25L);
        vipVoucherService.obtainVoucher(9968L,13,25L);
        vipVoucherService.obtainVoucher(9968L,15,25L);
        vipVoucherService.obtainVoucher(9968L,17,25L);
        vipVoucherService.obtainVoucher(9968L,20,25L);
        vipVoucherService.obtainVoucher(9968L,21,25L);
    }

    @Test
    public void pemInfoReferTest(){
        List<ActiveDrawPemVo> activeDrawPemVos = activeShowService.selShowAwardPems();
        System.out.println(activeDrawPemVos);
        List<ActiveForShowVO> activeForShowVOS = activeShowService.selCurrentAwardInfoWithoutUser();
        System.out.println(activeForShowVOS);
        List<ActiveDrawRecordVO> activeDrawRecordVOS = activeShowService.selUserAwardInfo(9968L, activeDrawPemVos.stream().map(ActiveDrawPemVo::getId).collect(Collectors.toList()));
        System.out.println(activeDrawRecordVOS);

    }
}
