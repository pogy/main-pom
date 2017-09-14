package com.shigu.main4.store.test.wxc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opentae.data.mall.beans.ShopFitmentArea;
import com.opentae.data.mall.beans.ShopFitmentModule;
import com.opentae.data.mall.examples.ShopFitmentFtlExample;
import com.opentae.data.mall.interfaces.ShopFitmentAreaMapper;
import com.opentae.data.mall.interfaces.ShopFitmentFtlMapper;
import com.opentae.data.mall.interfaces.ShopFitmentModuleMapper;
import com.shigu.main4.enums.FitmentAreaType;
import com.shigu.main4.enums.FitmentModuleType;
import com.shigu.main4.exceptions.ShopFitmentException;
import com.shigu.main4.store.test.BaseSpringTest;
import com.shigu.main4.storeservices.ShopFitmentService;
import com.shigu.main4.vo.FitmentArea;
import com.shigu.main4.vo.FitmentPage;
import com.shigu.main4.vo.fitment.WideImageModule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by wxc on 2017/4/17.
 *
 * @author wxc
 * @version main_site4.0 4.0.6
 * @since main_site4.0 4.0.6
 */
public class ShopFitmentServiceImplTest extends BaseSpringTest {

    @Autowired
    private ShopFitmentService shopFitmentService;

    @Autowired
    private ShopFitmentAreaMapper shopFitmentAreaMapper;

    @Autowired
    private ShopFitmentModuleMapper shopFitmentModuleMapper;

    @Autowired
    private ShopFitmentFtlMapper shopFitmentFtlMapper;

    @Test
    public void initShopFitment() throws Exception {
//        shopFitmentService.initShopFitment(32888L);
        shopFitmentService.initShopFitment(35992L);
    }

    @Test
    public void tryRmAreatest(){
        shopFitmentService.tryRmArea(186L);
    }

    @Test
    public void createPage() throws Exception {
        Long test1 = shopFitmentService.createPage(32888L, "测试一", null, 1);
        System.out.println(JSON.toJSONString(shopFitmentService.selPage(test1), SerializerFeature.PrettyFormat));
        Long test2 = shopFitmentService.createPage(32888L, "测试2", null, 2);
        System.out.println(JSON.toJSONString(shopFitmentService.selPage(test2), SerializerFeature.PrettyFormat));
    }

    @Test
    public void publishBannerTest(){
        shopFitmentService.publishBanner(35992L);
        ShopFitmentFtlExample example=new ShopFitmentFtlExample();
        example.createCriteria().andShopIdEqualTo(35992L);
        System.out.println(shopFitmentFtlMapper.selectByExample(example));
    }

    @Test
    public void bannerOnpubTest(){
        shopFitmentService.bannerOnpub(35992L);
    }

    @Test
    public void rmPage() throws Exception {
    }

    @Test
    public void selShopIdByPageId() throws Exception {
    }

    @Test
    public void selItemByPromote() throws Exception {
    }

    @Test
    public void selShopIdByAreaId() throws Exception {
    }

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void rmArea() throws Exception {
        Long page = shopFitmentService.createPage(32888L, "测试啦啦啦", 10010L, 1);
        Long first = shopFitmentService.selAreaByPageId(page).get(0).getAreaId();
        Long second = shopFitmentService.addArea(page, first, FitmentAreaType.CENTER.value(), 2);
        Long third = shopFitmentService.addArea(page, second, FitmentAreaType.LEFTRIGHT.value(), 2);

        shopFitmentService.rmArea(second);

        ShopFitmentArea fitmentArea = shopFitmentAreaMapper.selectByPrimaryKey(first);
        assertTrue(fitmentArea.getAfterAreaId() == 0L);

        ShopFitmentArea secondArea = shopFitmentAreaMapper.selectByPrimaryKey(second);
        assertNull(secondArea);

        ShopFitmentArea thirdArea = shopFitmentAreaMapper.selectByPrimaryKey(third);
        assertEquals(thirdArea.getAfterAreaId() , first);
    }

    @Test
    public void rmModule() throws Exception {
    }

    @Test
    public void selShopIdByModuleId() throws Exception {
    }

    @Test
    public void revalueModule() throws Exception {
        WideImageModule module = new WideImageModule();
        module.setAreaId(5L);
        module.setModuleId(10L);
        module.setSideType(3);
        module.setPicUrl("http://style.571xz.com/xz/css/img/logoWeb.png");
        module.setTargetUrl("http://www.571xz.com");
        shopFitmentService.revalueModule(10L, module);

        System.out.println(JSON.toJSONString(shopFitmentModuleMapper.selectByPrimaryKey(10L), SerializerFeature.PrettyFormat));
    }

    @Test
    public void selShopHead() throws Exception {

    }

    @Test
    public void selAreaByPageId() throws Exception {

    }

    @Test
    public void selAreaByAreaId() throws Exception {

    }

    @Test
    public void selModuleByAreaId() throws Exception {
        System.out.println(JSON.toJSONString(shopFitmentService.selModuleByAreaId(5L), SerializerFeature.PrettyFormat));
    }

    @Test
    public void selModuleByModuleId() throws Exception {
        WideImageModule wideImageModule = shopFitmentService.selModuleByModuleId(10L);
        System.out.println(JSON.toJSONString(wideImageModule, SerializerFeature.PrettyFormat));
    }

    @Test
    public void selPartByModuleId() throws Exception {

    }

    @Test
    public void selPage() throws Exception {
        FitmentPage fitmentPage = shopFitmentService.selPage(35L);
        System.out.println(JSON.toJSONString(fitmentPage, SerializerFeature.PrettyFormat));
    }

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void addArea() throws Exception {

        //1.0 页面ID必传
        try {
            shopFitmentService.addArea(null, null, FitmentAreaType.LEFTRIGHT.value(),null);
        } catch (Exception e) {
            // pageId must not null
            assertTrue(true);
        }
        Long page = shopFitmentService.createPage(32888L, "测试页面", null, 3);
        // 2.1 为店铺第一页添加第一块区域
        Long firstAreaId = shopFitmentService.addArea(page, null, FitmentAreaType.CENTER.value(),null);
        assertNotNull(firstAreaId);
        ShopFitmentArea firstArea = shopFitmentAreaMapper.selectByPrimaryKey(firstAreaId);
        assertNotNull(firstArea);
        assertTrue(firstArea.getAreaType() == FitmentAreaType.CENTER.value());
        assertEquals(firstArea.getPageId() , page);
        assertTrue(firstArea.getAfterAreaId() == 0);

        // 2.2 每个店铺的每一页只能至多1个最上层区域， 下面测试尝试再次添加top区域（显著特征：areaType=2 && afterAreaId=0）
        try {
            shopFitmentService.addArea(page, null, FitmentAreaType.CENTER.value(),null);
            fail("对于相同页面不能第二次添加top区域");
        } catch (ShopFitmentException e) {
            assertTrue(true);
        }

        // 3.1 在店铺第一页的第一块区域后添加一个区域, 先测试错误做法
        Long secondAreaId;
        try {
            secondAreaId = shopFitmentService.addArea(page, firstAreaId, FitmentAreaType.CENTER.value(),null);
            fail("after 为null，不知道怎么处理邻域" + secondAreaId);
        } catch (ShopFitmentException e) {
            // 当saidId 不为null 并且不等于0时，必须传入type参数指定区域添加方式
            assertTrue(true);
        }

        // 3.2 在原区域上方添加一个区域
        secondAreaId = shopFitmentService.addArea(page, firstAreaId, FitmentAreaType.CENTER.value(),1);
        assertNotNull(secondAreaId);
        ShopFitmentArea secondArea = shopFitmentAreaMapper.selectByPrimaryKey(secondAreaId);
        assertNotNull(secondArea);
        assertTrue(secondArea.getAreaType() == FitmentAreaType.CENTER.value());
        assertTrue(secondArea.getAfterAreaId() == 0); // 这里替换掉原top自己成了top,

        // 原top发生了一些变化
        firstArea = shopFitmentAreaMapper.selectByPrimaryKey(firstAreaId);
        // 原top的上级区域从0变为新区域ID
        assertEquals(firstArea.getAfterAreaId(), secondArea.getAreaId());

        // 4 在现在两个区域中间插入一个区域，有两种做法，在top下面添加一个区域 或者 在第二个区域上方添加一个区域 下面测试第二种

        Long betweenId = shopFitmentService.addArea(page, firstAreaId, FitmentAreaType.CENTER.value(),1);
        assertNotNull(betweenId);
        ShopFitmentArea betweenArea = shopFitmentAreaMapper.selectByPrimaryKey(betweenId);
        assertNotNull(betweenArea);
        assertEquals(betweenArea.getAfterAreaId(), secondAreaId); // 中间区域的上级区域为 之前的头部区域，

        firstArea = shopFitmentAreaMapper.selectByPrimaryKey(firstAreaId);
        assertEquals(firstArea.getAfterAreaId(), betweenId); // 现在的第三个区域的上级是刚刚插入的区域

        // 5 在页面底部添加一个区域
        Long bottomAreaId = shopFitmentService.addArea(page, firstAreaId, FitmentAreaType.CENTER.value(),2);
        assertNotNull(bottomAreaId);
        assertNotNull(shopFitmentAreaMapper.selectByPrimaryKey(bottomAreaId));


    }

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void addModule() throws Exception {

        Long firstAreaId = 5L;

        // 1.1 为店铺添加一个轮播模块
        Long moduleId = shopFitmentService.addModule(firstAreaId, null, FitmentModuleType.Viwepager.value, 3, null);
        assertNotNull(moduleId);
        ShopFitmentModule firstModule = shopFitmentModuleMapper.selectByPrimaryKey(moduleId);
        assertNotNull(firstModule);
        assertTrue(firstModule.getType() == FitmentModuleType.Viwepager.value);

        // 2.1 为本区域第一个模块上方添加一个模块
        Long secondMuduleId;
        try {
            secondMuduleId = shopFitmentService.addModule(firstAreaId, moduleId, FitmentModuleType.Category.value, 1, null);
            fail();
        } catch (Exception e) {
            //传入临模块id时必须指定插入位置after
            assertTrue(true);
            //after=1   表示在传入模块的上方添加一个模块
            secondMuduleId = shopFitmentService.addModule(firstAreaId, moduleId, FitmentModuleType.Category.value, 1, 1);
        }
        assertNotNull(secondMuduleId);
        ShopFitmentModule secondMudule = shopFitmentModuleMapper.selectByPrimaryKey(secondMuduleId);
        assertNotNull(secondMudule);
        assertTrue(secondMudule.getAfterModuleId() == 0);

        firstModule = shopFitmentModuleMapper.selectByPrimaryKey(moduleId);
        assertEquals(secondMudule.getModuleId(), firstModule.getAfterModuleId());//验证第二个模块是在第一个模块上方

        // 3.1 在第一个模块下方添加一个模块
        Long bottomModuleId = shopFitmentService.addModule(firstAreaId, moduleId, FitmentModuleType.Custom.value, 1, 2);
        assertNotNull(bottomModuleId);
        ShopFitmentModule bottomModule = shopFitmentModuleMapper.selectByPrimaryKey(bottomModuleId);
        assertNotNull(bottomModule);
        assertTrue(bottomModule.getType() == FitmentModuleType.Custom.value);
        assertEquals(bottomModule.getAreaId(), firstAreaId);
        assertEquals(bottomModule.getAfterModuleId(), moduleId); // 这里替换掉原bottom自己成了bottom,
    }

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void changeModuleLocation() throws Exception {
        Long firstAreaId = shopFitmentService.addArea(3L, 5L, FitmentAreaType.CENTER.value(),2);
        Long moduleId = shopFitmentService.addModule(firstAreaId, null, FitmentModuleType.Viwepager.value, 3, null);
        Long secondModuleId = shopFitmentService.addModule(firstAreaId, moduleId, FitmentModuleType.Category.value, 1, 2);

        //验证测试数据有效
        ShopFitmentModule secondModule = shopFitmentModuleMapper.selectByPrimaryKey(secondModuleId);
        assertNotNull(secondModule);
        //验证 secondModule 确实是第二个模块
        assertEquals(secondModule.getAfterModuleId(), moduleId);

        //1. 把第二个模块上移
        shopFitmentService.changeModuleLocation(secondModuleId, 1);

        secondModule = shopFitmentModuleMapper.selectByPrimaryKey(secondModuleId);
        assertTrue(secondModule.getAfterModuleId() == 0);

        ShopFitmentModule firstModule = shopFitmentModuleMapper.selectByPrimaryKey(moduleId);

        //2. 验证第一个模块确实次序降低
        assertNotNull(firstModule);
        assertEquals(firstModule.getAfterModuleId(), secondModuleId);

        //3. 再次添加两个模块
        Long nextModuleId = shopFitmentService.addModule(firstAreaId, moduleId, FitmentModuleType.Category.value, 3, 2);
        Long endModuleId = shopFitmentService.addModule(firstAreaId, nextModuleId, FitmentModuleType.Category.value, 3, 2);

        shopFitmentService.changeModuleLocation(nextModuleId, 2); // 第三个下移

        ShopFitmentModule shopFitmentModule = shopFitmentModuleMapper.selectByPrimaryKey(nextModuleId);
        assertEquals(shopFitmentModule.getAfterModuleId(), endModuleId);

        //4. 顶部向上移动，底部向下移动 测试
        shopFitmentService.changeModuleLocation(nextModuleId, 2);// 再次下移
        shopFitmentModule = shopFitmentModuleMapper.selectByPrimaryKey(nextModuleId);
        assertEquals(shopFitmentModule.getAfterModuleId(), endModuleId);// 到底了并没有什么乱用

        shopFitmentService.changeModuleLocation(secondModuleId, 1);
        secondModule = shopFitmentModuleMapper.selectByPrimaryKey(secondModuleId);
        assertTrue(secondModule.getAfterModuleId() == 0);//同样没卵用

        //5. 中间模块移动
        shopFitmentService.changeModuleLocation(moduleId, 2); // 现在第二个模块下移
        firstModule = shopFitmentModuleMapper.selectByPrimaryKey(moduleId);
        assertEquals(firstModule.getAfterModuleId(), endModuleId);

        // 刚刚的第三位模块现在变成第二位， 父级变为第一模块
        ShopFitmentModule endModule = shopFitmentModuleMapper.selectByPrimaryKey(endModuleId);
        assertEquals(endModule.getAfterModuleId(), secondModuleId);

        // 现在最下层模块的父级是刚刚移动的第二模块
        shopFitmentModule = shopFitmentModuleMapper.selectByPrimaryKey(nextModuleId);
        assertEquals(shopFitmentModule.getAfterModuleId(), moduleId);

        //.... 你还没晕？
    }

}