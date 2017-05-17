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
        String ids="20350398,20436928,20393881,20476643,20458247,20420378,20411779,20486173,20422561,20415264,20396297,20393820,20361266,20346502,20330455,20140367,20072650,20477521,20433766,20445645,20429635,20339641,20339288,20307785,20435314,20357051,20252168,20385949,20385071,20154487,20129544,20312845,20308182,20140351,20416489,20279460,20465236,20225840,20134170,20339319,20267233,20202220,20451309,20340628,9980847,20301022,9949012,9892065,20451118,20385063,20266818,20311868,20340629,20478082,20191733,20149389";
        String[] idsarr=ids.split(",");
        for(String i:idsarr){
            Long itemId = Long.valueOf(i);
            Long total = itemBrowerService.selItemBrower(itemId);
            System.out.println(i+"  itemTotal:" + total);
        }

    }
    @Test
    public void selOneItemBrower(){
        Long itemId =20208007L;
        Long total = itemBrowerService.selItemBrower(itemId);
        System.out.println("  itemTotal:" + total);
    }

    @Test
    public void selMoreItemBrower(){
        List<Long> itemIds=new ArrayList<>();
        itemIds.add(9901299L);
        itemIds.add(20176121L);
        itemBrowerService.selMoreItemBrower(itemIds);
    }
}
