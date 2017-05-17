package com.shigu.main4.monitor.test;

import com.shigu.main4.monitor.service.impl.ItemBrowerServiceImpl;
import com.shigu.main4.monitor.vo.ItemBrowerFlowVO;
import com.shigu.main4.tools.RedisIO;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:/spring/store_test.xml" )
public class ItemBrowerServiceTest {


    private static final Logger logger = LoggerFactory.getLogger(ItemBrowerServiceTest.class);

    @Resource(name = "itemBrowerService")
    private ItemBrowerServiceImpl itemBrowerService;

    @Resource
    private RedisIO redisIO;

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
    public void selItemIP(){
        Long itemId = 9901299L;
        //独立IP数查询
        Long total = itemBrowerService.selItemIP(itemId);
        logger.error("独立IP数：" + total);

        // 讲道理，独立IP会小于PV
        assertTrue(total <= itemBrowerService.selItemBrower(itemId));
    }

    @Test
    public void selMoreItemBrower(){
        List<Long> itemIds=new ArrayList<>();
        itemIds.add(9901299L);
        itemIds.add(20176121L);
        itemBrowerService.selMoreItemBrower(itemIds);
    }

    @Test
    public void selUnrealBrower() throws Exception {
        ItemBrowerFlowVO itemBrowerFlowVO = itemBrowerService.selUnrealBrower(9901299L);
        ItemBrowerFlowVO item_flow_9901299 = redisIO.get("item_flow_9901299", ItemBrowerFlowVO.class);

        // 查询并创建成功
        assertTrue(item_flow_9901299.getNumber() == itemBrowerFlowVO.getNumber());
        redisIO.del("item_flow_9901299");
    }

    @Test
    public void makeUnrealBrower() throws Exception {
        ItemBrowerFlowVO itemBrowerFlowVO = itemBrowerService.makeUnrealBrower(9901299L);
        assertNotNull(itemBrowerFlowVO);

        ItemBrowerFlowVO item_flow_9901299 = redisIO.get("item_flow_9901299", ItemBrowerFlowVO.class);

        // 创建成功
        assertTrue(item_flow_9901299.getNumber() == itemBrowerFlowVO.getNumber());
        redisIO.del("item_flow_9901299");
    }

    @Test
    public void addUnrealBrower() throws Exception {
        ItemBrowerFlowVO itemBrowerFlowVO = itemBrowerService.addUnrealBrower(9901299L, 10);

        // 创建并增加成功
        assertNotNull(itemBrowerFlowVO);

        // 尝试还原初始值

        // 去除增量并转化为字符串
        String numberStr = String.valueOf(itemBrowerFlowVO.getNumber() - 10);
        // 10 倍数下还原真实值
        Long realNumber = Long.valueOf(numberStr.substring(0, numberStr.length() - 1));
        // 验证真实值有效
        assertTrue(realNumber.equals(itemBrowerService.selItemBrower(9901299L)));

        redisIO.del("item_flow_9901299");
    }
}
