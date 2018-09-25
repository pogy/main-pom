package com.shigu.main4.order.process;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.vo.KdnPostInfoVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by gtx on 2018/9/5 0005.
 *
 * @author gtx
 * @since
 */
public class KdnProcessImplTest extends BaseTest {

    @Autowired
    private KdnProcess kdnProcess;

    @Test
    public void selPostInfoByOidTest(){
//        KdnPostInfoVO kdnPostInfoVO = kdnProcess.selPostInfoByOid(289875L);
        KdnPostInfoVO kdnPostInfoVO = kdnProcess.selPostInfoByOid(289345L);
        System.err.println(kdnPostInfoVO.toString());
    }

    @Test
    public void selPostInfoByExpressCodeTest(){
        KdnPostInfoVO kdnPostInfoVO = kdnProcess.selPostInfoByExpressCode("636142814528");
        System.err.println(kdnPostInfoVO.toString());
    }
}
