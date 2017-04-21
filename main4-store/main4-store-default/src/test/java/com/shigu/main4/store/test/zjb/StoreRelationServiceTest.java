package com.shigu.main4.store.test.zjb;

import com.alibaba.fastjson.JSON;
import com.shigu.main4.exceptions.StoreException;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.vo.StoreRelation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * 店铺联系方式测试类
 * Created by zhaohongbo on 17/2/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/main4/spring/store_test.xml" )
public class StoreRelationServiceTest {

    @Autowired
    StoreRelationService storeRelationService;

    @Test
    public void selRelationByIdtest(){
        //ID不存在的情况
        assertEquals(null, storeRelationService.selRelationById(328881L));
        //店铺存在的情况
        assertNotNull(storeRelationService.selRelationById(1L));
        //ID不存在的情况
        assertEquals(null, storeRelationService.selRelationById(2L,"hz"));
        //站点传错
        assertEquals(null, storeRelationService.selRelationById(32888L,"gz"));
        //店铺存在的情况
        assertNotNull(storeRelationService.selRelationById(1L,"hz"));

        StoreRelation storeRelation = storeRelationService.selRelationById(32888L);
        System.out.println(JSON.toJSONString(storeRelation));
    }

    @Test
    public void updateRelation(){
        StoreRelation sr=new StoreRelation();
        try {
            storeRelationService.updateRelation(sr);
            fail("No exception thrown.");
        } catch (Exception e) {
            assertTrue(e instanceof StoreException);
        }
        sr.setStoreId(2L);
        try {
            storeRelationService.updateRelation(sr);
            fail("No exception thrown.");
        } catch (Exception e) {
            assertTrue(e instanceof StoreException);
        }
        sr.setStoreId(1L);
//        sr.setImWw("阿里旺旺1");
        sr.setImWx("zhujiabao8139");
        sr.setStoreNum("测试不要乱点啊-8000");
        sr.setTelephone("18888888888");
        try {
            storeRelationService.updateRelation(sr);
            StoreRelation sr2 = storeRelationService.selRelationById(1L);
            assertEquals("18888888888",sr2.getTelephone());
        } catch (Exception e) {
            fail("update error.");
        }
    }
}
