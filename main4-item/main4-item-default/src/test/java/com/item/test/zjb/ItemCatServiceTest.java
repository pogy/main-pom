package com.item.test.zjb;


import com.alibaba.fastjson.JSON;
import com.shigu.main4.item.services.ItemCatService;
import com.shigu.main4.item.vo.EverUsedCat;
import com.shigu.main4.item.vo.EverUsedCatForAdd;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 发布类目
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:main4/spring/item_test.xml"})
public class ItemCatServiceTest {

    @Autowired
    private ItemCatService itemCatService;

    /**
     * 用户曾经使用过的发布类目
     */
    @Test
    public void everUsedCats(){
        Long shopId = 32888L;
        int size = 10;
        List<EverUsedCat> everUsedCatList = itemCatService.everUsedCats(shopId, size);
        System.out.println("发布类目：" + JSON.toJSONString(everUsedCatList));
    }

    /**
     * 保存用户的使用记录
     */
    @Test
    public void saveEverUsedCat(){
        System.out.println("保存用戶的使用记录，已经存在，不插入");
        Long shipId = 32888L;
        EverUsedCatForAdd everUsedCatForAdd = new EverUsedCatForAdd();
        everUsedCatForAdd.setShowName("户外/登山/野营/旅行用品>>睡袋");
        everUsedCatForAdd.setCname("睡袋");
        everUsedCatForAdd.setCid(50013908L);
        everUsedCatForAdd.setAllcids("50013886,50013908");
        itemCatService.saveEverUsedCat(shipId, everUsedCatForAdd);

        System.out.println("保存用戶的使用记录，正常插入");
        everUsedCatForAdd = new EverUsedCatForAdd();
        everUsedCatForAdd.setShowName("男装>>羽绒裤");
        everUsedCatForAdd.setCname("羽绒裤");
        everUsedCatForAdd.setCid(50025884L);
        everUsedCatForAdd.setAllcids("30,50025884");
        itemCatService.saveEverUsedCat(shipId, everUsedCatForAdd);
    }
    


}
