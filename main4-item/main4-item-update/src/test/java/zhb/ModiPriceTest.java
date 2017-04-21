package zhb;

import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.main4.item.vo.SynItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 模拟价格修改
 * Created by zhaohongbo on 17/4/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/main4/spring/item-update.xml")
public class ModiPriceTest {

    @Autowired
    ItemAddOrUpdateService itemAddOrUpdateService;

    @Test
    public void modifyPrice() throws ItemModifyException {
        Long goodsId=20211490L;
        String webSite="hz";
        String piprice="30.00";
        Long shopId=40491L;
        SynItem si=new SynItem();
        si.setWebSite(webSite);
        si.setGoodsId(goodsId);
        si.setShopId(shopId);
        si.setPiPriceString(piprice);
        itemAddOrUpdateService.userUpdateItem(si);
    }
}
