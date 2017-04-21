package com.shigu.main4.monitor.test;

import com.shigu.main4.monitor.service.impl.ItemBrowerServiceImpl;
import com.shigu.main4.monitor.services.ItemBrowerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/spring/store_test.xml" )
public class ItemBrowerServiceTest {

    @Resource(name = "itemBrowerService")
    private ItemBrowerServiceImpl itemBrowerService;

    @Test
    public void selItemBrower(){
        Long itemId = 9901299L;
        Long total = itemBrowerService.selItemBrower(itemId);
        System.out.println("itemTotal:" + total);
    }

    @Test
    public void selMoreItemBrower(){
        List<Long> itemIds=new ArrayList<>();
        itemIds.add(9901299L);
        itemIds.add(20176121L);
        itemBrowerService.selMoreItemBrower(itemIds);
    }
}
