package com.shigu.main4.cdn.services;

import com.shigu.main4.cdn.bo.ScStoreBO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by cdh on 2017/9/27.
 * Path com.shigu.main4.cdn.services.CdnServiceTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/main4/spring/test.xml")
public class CdnServiceTest {
@Autowired
CdnService cdnService;

    @Test
    public void addShopCollect() throws Exception {

        ScStoreBO bo = new ScStoreBO();
        bo.setStore_id(43455L);
        cdnService.addShopCollect(1000085908L,bo);
    }

}