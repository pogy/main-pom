package com.shigu.main4.item.services;/**
 * Created by pc on 2017-09-21.
 *
 * @author pc
 * @description
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */

import com.item.test.BaseSpringTest;
import com.shigu.main4.item.exceptions.ItemException;
import com.shigu.main4.item.vo.ItemGoatCidAndWebsiteVO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *Created By pc on 2017-09-21/14:50
 *
 */
public class ItemCatServiceImplTest extends BaseSpringTest{
    @Autowired
    ItemCatService itemCatService;

    @Test
    public void getItemCid_test1() throws ItemException {
        //女装1
        Long goodsId  =  21381630l;
        Long cid  = 50010850l;
        String website  = "hz";

        ItemGoatCidAndWebsiteVO itemGoatCidAndWebsiteVO = itemCatService.getItemCid(goodsId);
        Assert.assertEquals(cid,itemGoatCidAndWebsiteVO.getCid());
        Assert.assertEquals(website,itemGoatCidAndWebsiteVO.getWebsite());

        boolean instanOfWoman =  itemCatService.instanOfWoman(itemGoatCidAndWebsiteVO.getCid());
        Assert.assertTrue(instanOfWoman);

    }

    @Test
    public void getItemCid_test2() throws ItemException {
        //女装2
        Long goodsId  =  3182103l;
        Long cid  = 50008897l;
        String website  = "bj";

        ItemGoatCidAndWebsiteVO itemGoatCidAndWebsiteVO = itemCatService.getItemCid(goodsId);
        Assert.assertEquals(cid,itemGoatCidAndWebsiteVO.getCid());
        Assert.assertEquals(website,itemGoatCidAndWebsiteVO.getWebsite());

        boolean instanOfWoman =  itemCatService.instanOfWoman(itemGoatCidAndWebsiteVO.getCid());
        Assert.assertTrue(instanOfWoman);

    }

    @Test
    public void getItemCid_test3() throws ItemException {
        //女装2
        Long goodsId  =  21297907l;
        Long cid  = 50000697l;
        String website  = "hz";

        ItemGoatCidAndWebsiteVO itemGoatCidAndWebsiteVO = itemCatService.getItemCid(goodsId);
        Assert.assertEquals(cid,itemGoatCidAndWebsiteVO.getCid());
        Assert.assertEquals(website,itemGoatCidAndWebsiteVO.getWebsite());

        boolean instanOfWoman =  itemCatService.instanOfWoman(itemGoatCidAndWebsiteVO.getCid());
        Assert.assertTrue(instanOfWoman);

    }

    @Test
    public void getItemCid_test4() throws ItemException {
        //男装1
        Long goodsId  =  21196369l;
        Long cid  = 50011153l;
        String website  = "hz";

        ItemGoatCidAndWebsiteVO itemGoatCidAndWebsiteVO = itemCatService.getItemCid(goodsId);
        Assert.assertEquals(cid,itemGoatCidAndWebsiteVO.getCid());
        Assert.assertEquals(website,itemGoatCidAndWebsiteVO.getWebsite());

        boolean instanOfWoman =  itemCatService.instanOfWoman(itemGoatCidAndWebsiteVO.getCid());
        Assert.assertFalse(instanOfWoman);

    }

    @Test
    public void getItemCid_test5() throws ItemException {
        //男装2
        Long goodsId  =  2981419l;
        Long cid  = 50011161l;
        String website  = "bj";

        ItemGoatCidAndWebsiteVO itemGoatCidAndWebsiteVO = itemCatService.getItemCid(goodsId);
        Assert.assertEquals(cid,itemGoatCidAndWebsiteVO.getCid());
        Assert.assertEquals(website,itemGoatCidAndWebsiteVO.getWebsite());

        boolean instanOfWoman =  itemCatService.instanOfWoman(itemGoatCidAndWebsiteVO.getCid());
        Assert.assertFalse(instanOfWoman);

    }

}
