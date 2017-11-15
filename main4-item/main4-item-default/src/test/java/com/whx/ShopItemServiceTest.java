package com.whx;

import com.item.test.BaseSpringTest;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.item.bo.StoreGoodsListSearchBO;
import com.shigu.main4.item.exceptions.ItemException;
import com.shigu.main4.item.services.ShopsItemService;
import com.shigu.main4.item.vo.OnsaleItem;
import com.shigu.main4.item.vo.ShopUnprocessItemCount;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类名：ShopItemServiceTest
 * 类路径：com.whx.ShopItemServiceTest
 * 创建者：王浩翔
 * 创建时间：2017-10-25 16:56
 * 项目：main-pom
 * 描述：
 */
public class ShopItemServiceTest extends BaseSpringTest {

    @Autowired
    ShopsItemService shopsItemService;

    @Test
    public void setVideoUrlTest() throws JsonErrException {
        shopsItemService.setGoodsVideo(43429L,"hz",21742997L,"https://cloud.video.taobao.com/play/u/2978147014/p/1/e/6/t/1/50018260348.mp4",true);
    }

    @Test
    public void testOldOnsaleItem() throws ItemException {
        ShiguPager<OnsaleItem> oldPager1 = shopsItemService.selOnsaleItems(null, null, null, 29911L, 1, 10);
        ShiguPager<OnsaleItem> oldPager2 = shopsItemService.selOnsaleItems("秋冬", null, null, 29911L, 1, 10);
        System.out.println("end");
    }

    @Test
    public void testNewOnsaleItem() throws Main4Exception {
        StoreGoodsListSearchBO bo = new StoreGoodsListSearchBO();
        bo.setKeyword("水洗");
        ShiguPager<OnsaleItem> onSale = shopsItemService.selOnsaleItems(29911L, "hz", bo, 2, 10);
        ShiguPager<OnsaleItem> totalOnSale = shopsItemService.selOnsaleItems(29911L, "hz", new StoreGoodsListSearchBO(), 2, 10);
        System.out.println("end");
    }
}
