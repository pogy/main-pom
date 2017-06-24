package com.shigu.main4.monitor.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.monitor.service.impl.ItemUpRecordServiceImpl;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.vo.DataLineVO;
import com.shigu.main4.monitor.vo.HotUpItem;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.monitor.vo.LastUploadedVO;
import com.shigu.main4.monitor.vo.NoUpItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *  上传记录TEST
 *
 *  @author shigu_zjb
 *  @date 2017/3/13
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/spring/store_test.xml" )
public class ItemUpRecordServiceTest {

    @Autowired
    private ItemUpRecordService itemUpRecordService;

    @Test
    public void pushMsgTest(){
        ItemUpRecordServiceImpl impl= (ItemUpRecordServiceImpl) itemUpRecordService;
        ItemUpRecordVO itemUpRecordVO = new ItemUpRecordVO();
        itemUpRecordVO.setFenPrice("165");
        itemUpRecordVO.setSupperPrice("165");
        itemUpRecordVO.setStatus(0L);
        itemUpRecordVO.setFenGoodsName("2017冬装新款棉衣 糖果色四色中长款修身棉衣1111");
        itemUpRecordVO.setSupperImage("http://img03.taobaocdn.com/bao/uploaded/i3/TB1dZ3eGXXXXXbzXFXXXXXXXXXX_!!0-item_pic.jpg");
        itemUpRecordVO.setSupperGoodsId(12270481L);
        itemUpRecordVO.setSupperServers("退现金,包换款");
        itemUpRecordVO.setSupperStoreId(32888L);
        itemUpRecordVO.setSupperMarketId(644L);
        itemUpRecordVO.setSupperNumiid(41268119989L);
        itemUpRecordVO.setFenImage("http://img03.taobaocdn.com/bao/uploaded/i3/TB1dZ3eGXXXXXbzXFXXXXXXXXXX_!!0-item_pic.jpg");
        itemUpRecordVO.setFlag("web-tb");
        itemUpRecordVO.setSupperGoodsName("2017冬装新款棉衣 糖果色四色中长款修身棉衣11111");
        itemUpRecordVO.setWebSite("hz");
        itemUpRecordVO.setFenUserNick("lyszhen4");
        itemUpRecordVO.setFenUserId(1000006627L);
        itemUpRecordVO.setDaiTime(DateUtil.dateToString(new Date(),DateUtil.patternD));
        itemUpRecordVO.setSupperStorenum("2058");
        itemUpRecordVO.setSupperPiPrice("30.05");
        itemUpRecordVO.setSupperImww("imwww");
        itemUpRecordVO.setSupperTelephone("1515115155");
        itemUpRecordVO.setSupperTaobaoUrl("httpppppp");
        itemUpRecordVO.setSupperMarket("asdasdasd");
        itemUpRecordVO.setSupperStoreName("ksskks");
        itemUpRecordVO.setSupperQq("123415432534");
        itemUpRecordVO.setFenNumiid(524121231L);
        impl.pushAddMessage(itemUpRecordVO);
    }
    /**
     * 添加上传记录
     */
    @Test
    public void addItemUpRecord(){
        ItemUpRecordVO itemUpRecordVO = new ItemUpRecordVO();
        itemUpRecordVO.setFenPrice("165");
        itemUpRecordVO.setSupperPrice("165");
        itemUpRecordVO.setStatus(0L);
        itemUpRecordVO.setFenGoodsName("2017冬装新款棉衣 糖果色四色中长款修身棉衣1111");
        itemUpRecordVO.setSupperImage("http://img03.taobaocdn.com/bao/uploaded/i3/TB1dZ3eGXXXXXbzXFXXXXXXXXXX_!!0-item_pic.jpg");
        itemUpRecordVO.setSupperGoodsId(12270481L);
        itemUpRecordVO.setSupperServers("退现金,包换款");
        itemUpRecordVO.setSupperStoreId(32888L);
        itemUpRecordVO.setSupperMarketId(644L);
        itemUpRecordVO.setSupperNumiid(41268119989L);
        itemUpRecordVO.setFenImage("http://img03.taobaocdn.com/bao/uploaded/i3/TB1dZ3eGXXXXXbzXFXXXXXXXXXX_!!0-item_pic.jpg");
        itemUpRecordVO.setFlag("web-tb");
        itemUpRecordVO.setSupperGoodsName("2017冬装新款棉衣 糖果色四色中长款修身棉衣11111");
        itemUpRecordVO.setWebSite("hz");
        itemUpRecordVO.setFenUserNick("lyszhen4");
        itemUpRecordVO.setFenUserId(1000006627L);
        itemUpRecordVO.setDaiTime(DateUtil.dateToString(new Date(),DateUtil.patternD));
        itemUpRecordVO.setSupperStorenum("2058");
        itemUpRecordVO.setSupperPiPrice("30.05");
        itemUpRecordVO.setSupperImww("imwww");
        itemUpRecordVO.setSupperTelephone("1515115155");
        itemUpRecordVO.setSupperTaobaoUrl("httpppppp");
        itemUpRecordVO.setSupperMarket("asdasdasd");
        itemUpRecordVO.setSupperStoreName("ksskks");
        itemUpRecordVO.setSupperQq("123415432534");
        itemUpRecordVO.setFenNumiid(524121231L);

        itemUpRecordService.addItemUpRecord(itemUpRecordVO);
        return;
    }


    /**
     * 查询最后一次上传时间
     */
    @Test
    public void selLastUpByIds(){
//        1612829    1000063657
        Long userId = 1000071161L;
        Long supperGoodsId = 20500978L;
        LastUploadedVO last = itemUpRecordService.selLastUpByIds(userId,supperGoodsId);
        String datestr = null;
        if(last != null){
            datestr = DateUtil.dateToString(last.getLastTime(), DateUtil.patternD);
        }
        System.out.println("最后上传时间：" + datestr);
        return;
    }

    /**
     * 上传最多的商品
     * @throws Exception
     */
    @Test
    public void selHotUpItems() throws Exception {
        List<HotUpItem> hotUpItems = itemUpRecordService.selHotUpItems(17828L, 5);
        System.out.println(JSON.toJSONString(hotUpItems, SerializerFeature.PrettyFormat));
    }

    @Test
    public void upedItemTimes() {
        Calendar calendar = Calendar.getInstance();
        Date to = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        System.out.println(itemUpRecordService.upedItemTimes(17828L, calendar.getTime(), to));
    }

    @Test
    public void upedItemNum() {
        Calendar calendar = Calendar.getInstance();
        Date to = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        System.out.println(itemUpRecordService.upedItemNum(17828L, calendar.getTime(), to));
    }

    @Test
    public void noUpItems() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -2);
        List<NoUpItem> noUpItems = itemUpRecordService.noUpItems(17828L, 5, calendar.getTime());
        System.out.println(JSON.toJSONString(noUpItems, SerializerFeature.PrettyFormat));
    }

    @Test
    public void countDailiSellerNum() {
        System.out.println(itemUpRecordService.countDailiSellerNum(32888L));
    }

    @Test
    public void dailiSellerLevelLine() {
        List<DataLineVO> vos = itemUpRecordService.dailiSellerLevelLine(17828L);
        System.out.println(JSON.toJSONString(vos, SerializerFeature.PrettyFormat));
    }
}
