package com.item.test.zjb;

import com.item.test.BaseSpringTest;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DownTest extends BaseSpringTest {

    @Autowired
    ItemAddOrUpdateService itemAddOrUpdateService;

    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Test
    public void downTiny() throws ItemModifyException {
        ShiguGoodsTinyExample example=new ShiguGoodsTinyExample();
        example.createCriteria().andStoreIdEqualTo(41452L);
        example.setWebSite("hz");
        List<ShiguGoodsTiny> tinys=shiguGoodsTinyMapper.selectByExample(example);
        for(ShiguGoodsTiny tiny:tinys){
            itemAddOrUpdateService.userDownItem(tiny.getGoodsId());
        }
    }
}
