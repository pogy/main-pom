package com.shigu.main4.store.test.wxc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opentae.data.mall.beans.ShiguShopApply;
import com.opentae.data.mall.interfaces.ShiguShopApplyMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.exceptions.ShopRegistException;
import com.shigu.main4.storeservices.ShopRegistService;
import com.shigu.main4.vo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wxc on 2017/2/21.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/main4/spring/store_test.xml")
public class ShopRegistServiceImplTest{

    private static final Logger logger = LoggerFactory.getLogger(ShopRegistServiceImplTest.class);

    @Resource
    private ShopRegistService shopRegistService;

    @Resource
    private ShiguShopApplyMapper shiguShopApplyMapper;

    @Test
    public void registShop() throws Exception {

        // 新注册
        ShopRegister shop = new ShopRegister();
        shop.setShopNum("B517999");
        shop.setImQq("18888971970");
        shop.setImWx("18888971970");
        shop.setCanExamine(false);
        shop.setFloorId(622L);
        shop.setImAliww("18888971970");
        shop.setMainBus("女装");
        shop.setMarketId(621L);
        shop.setTbNick("赵洪波5");

        long l = shopRegistService.registShop(shop);
        ShiguShopApply apply = shiguShopApplyMapper.selectByPrimaryKey(l);
        assertTrue("创建新纪录失败", l > 0 && apply != null);
        logger.info("注册成功。\n" + JSON.toJSONString(apply, SerializerFeature.PrettyFormat));


        // 修改信息
        shop.setImQq("345421211");
        long l1 = shopRegistService.registShop(shop);
        apply = shiguShopApplyMapper.selectByPrimaryKey(l1);
        assertTrue("修改失败", l1 == l && shop.getImQq().equals(apply.getImQq()));
        logger.info("修改成功。\n" + JSON.toJSONString(apply, SerializerFeature.PrettyFormat));


        // 更新审核状态为已审核，准备下面的测试
        apply.setCanExamine(2);
        shiguShopApplyMapper.updateByPrimaryKeySelective(apply);

        // ！重复注册！预期抛异常
        try {
            // 修改信息
            shop.setImWx("ihgkjlasda");
            long l2 = shopRegistService.registShop(shop);
            fail("can not be here.");
        } catch (ShopRegistException ex) {
            assertTrue(true);
        }

        // 删除测试数据
        shiguShopApplyMapper.deleteByPrimaryKey(l);
    }

    @Test
    public void completeRegist() throws Exception {
        // 新注册
        ShopRegister shop = new ShopRegister();
        shop.setShopNum("B517");
        long l = shopRegistService.registShop(shop);
        ShiguShopApply apply = shiguShopApplyMapper.selectByPrimaryKey(l);
        assertTrue("创建新纪录失败", l > 0 && apply != null);
        logger.info("注册成功。\n" + JSON.toJSONString(apply, SerializerFeature.PrettyFormat));

        // 测试目标方法
        assertTrue(shopRegistService.completeRegist(l, 571L, 571L, "571xz", "https://www.taobao.com/"));

        // 删除测试数据
        //shiguShopApplyMapper.deleteByPrimaryKey(l);
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void toExamine() throws Exception {
        long l = shopRegistService.toExamine(9L);
        assertTrue(l > 0);
    }

    @Test
    public void selSites() {
        List<SiteForRegist> forRegists = shopRegistService.selSites();

        List<SiteForRegist> cache = shopRegistService.selSites();

        assertTrue(cache == forRegists);
    }


    /**
     *  测试 缓存查询可注册的市场列表
     */
    @Test
    public void selMarkets() {
        List<MarketForRegist> forRegists = shopRegistService.selMarkets("hz");
        List<MarketForRegist> cache = shopRegistService.selMarkets("hz");

        assertTrue(cache == forRegists);
    }

    /**
     *  查询可注册的楼层列表
     */
    @Test
    public void selFloors() {
        List<FloorForRegist> forRegists = shopRegistService.selFloors(1063L);
        logger.info("\n" + JSON.toJSONString(forRegists, SerializerFeature.PrettyFormat));
        assertFalse(forRegists.isEmpty());
    }


    @Test
    public void selApplysByUserId(){
        Long userId = 9968L;
        int pageNo = 1;
        int pageSize = 2;
        ShiguPager<ShopApply> shopApplyShiguPager = shopRegistService.selApplysByUserId(userId, pageNo ,pageSize);
        System.out.println("申请数据:" + JSON.toJSONString(shopApplyShiguPager));
    }

    @Test
    public void selDetailById(){
        Long userId = 9968L;
        Long ruzhuId = 11L;
        ShopApplyDetail shopApplyDetail = shopRegistService.selDetailById(userId, ruzhuId);
        System.out.println("申请数据：" + JSON.toJSONString(shopApplyDetail));
    }


    /**
     * 重新提交申请
     */
    @Test
    public void resubmitShopApply(){
        Long userId = 9968L;
        Long ruzhuId = 12L;
        try{
            shopRegistService.resubmitShopApply(userId, ruzhuId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void shopCanOpen() throws Exception {
        shopRegistService.shopCanOpen(0L,null, 0L, "");
    }
}