package com.shigu.main4.order.services.impltest;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.bo.GoodsTaoRelationBO;
import com.shigu.main4.order.process.ItemProductProcess;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Licca on 17/9/2.
 */
public class ItemProductProcessImplTest extends BaseTest{

    @Autowired
    ItemProductProcess itemProductProcess;

    @Test
    public void test(){
        GoodsTaoRelationBO bo=new GoodsTaoRelationBO();
        bo.setWebSite("hz");
        bo.setGoodsId(21195361L);
        bo.setNumIid(556613638156L);
        bo.setUserId(1000074682L);
        itemProductProcess.relationTaoGoods(bo);
    }
}
