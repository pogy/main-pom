package com.shigu.main4.data.translate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.beans.ShiguShopFitment;
import com.opentae.data.mall.beans.ShopFitmentArea;
import com.opentae.data.mall.beans.ShopFitmentModule;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.examples.ShiguShopFitmentExample;
import com.opentae.data.mall.examples.ShopFitmentAreaExample;
import com.opentae.data.mall.examples.ShopFitmentModuleExample;
import com.opentae.data.mall.interfaces.ShiguShopFitmentMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.opentae.data.mall.interfaces.ShopFitmentAreaMapper;
import com.opentae.data.mall.interfaces.ShopFitmentModuleMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.enums.FitmentAreaType;
import com.shigu.main4.enums.FitmentModuleType;
import com.shigu.main4.exceptions.ShopFitmentException;
import com.shigu.main4.storeservices.ShopFitmentService;
import com.shigu.main4.vo.FitmentArea;
import com.shigu.main4.vo.fitment.CustomModule;
import com.shigu.main4.vo.fitment.ImageInfo;
import com.shigu.main4.vo.fitment.SlideshowModule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * 店铺装修导入
 * Created by Administrator on 2017/4/25 0025.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ac.xml")
public class ShiguShopFitmentTrans {

    private static final Logger logger = LoggerFactory.getLogger(ShiguShopFitmentTrans.class);

    @Autowired
    private ShiguShopFitmentMapper shiguShopFitmentMapper;

    @Autowired
    private ShopFitmentModuleMapper shopFitmentModuleMapper;

    @Autowired
    private ShopFitmentAreaMapper shopFitmentAreaMapper;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    private ShopFitmentService shopFitmentService;

    @Test
    public void trans() throws ShopFitmentException {

        int size = 200;
        int start = 0;
        ShiguShopExample shiguShopExample = new ShiguShopExample();
        shiguShopExample.setStartIndex(start);
        shiguShopExample.setEndIndex(size);
        List<ShiguShop> shops;
        while (!(shops = shiguShopMapper.selectByConditionList(shiguShopExample)).isEmpty()) {

            List<Long> shopIds = new ArrayList<>();
            logger.info("正在初始化店铺：" + start + "-" + (start + size));
            for (ShiguShop shop : shops) {
                Long shopId = shop.getShopId();
                if (shop.getShopStatus() == 0) {
                    shopIds.add(shopId);
                }
                shopFitmentService.initShopFitment(shopId);
            }
            if (shopIds.isEmpty()) {
                continue;
            }
            ShiguShopFitmentExample fitmentExample = new ShiguShopFitmentExample();
            fitmentExample.createCriteria().andShopIdIn(shopIds);
            List<ShiguShopFitment> shiguShopFitments = shiguShopFitmentMapper.selectByExample(fitmentExample);
            logger.info("初始化完成，正在提取旧装修数据。共有" + shiguShopFitments.size() + "家店铺需要提取");
            for (ShiguShopFitment shiguShopFitment : shiguShopFitments) {
                Long shopId = shiguShopFitment.getShopId();
//                shopFitmentService.initShopFitment(shopId);
                Long indexPage = shopFitmentService.selIndexPageIdByShopId(shopId);
                List<FitmentArea> fitmentAreas = shopFitmentService.selAreaByPageId(indexPage);
                FitmentArea fitmentArea = fitmentAreas.get(0);
                Long areaId = fitmentArea.getAreaId();
                if (shiguShopFitment.getShowSlide() == 1) {
                    Long wadeImage = areaId = shopFitmentService.addArea(indexPage, areaId, FitmentAreaType.CENTER.value(), 1);
                    Long slideModule = shopFitmentService.addModule(wadeImage, null, FitmentModuleType.Slideshow.value, 3, null);
                    List<ImageInfo> images = new ArrayList<>();
                    for (Field field : ShiguShopFitment.class.getDeclaredFields()) {
                        if (field.getModifiers() == Modifier.PRIVATE) {
                            String name = field.getName();
                            if (name.startsWith("shopBanner")) {
                                field.setAccessible(true);
                                try {
                                    Object v = field.get(shiguShopFitment);
                                    if (v != null && !"".equals(v)) {
                                        ImageInfo info = new ImageInfo();
                                        info.setPicUrl(v.toString());
                                        info.setTargetUrl("http://www.571xz.com/shop.htm?id=" + shopId);
                                        images.add(info);
                                    }
                                } catch (Exception ignored) {
                                }
                            }
                        }
                    }
                    SlideshowModule slideshowModule = new SlideshowModule();
                    slideshowModule.setAreaId(wadeImage);
                    slideshowModule.setModuleId(slideModule);
                    slideshowModule.setAreaId(0L);
                    slideshowModule.setSideType(3);
                    slideshowModule.setImages(images);
                    shopFitmentService.revalueModule(slideModule, slideshowModule);
                }
                if (shiguShopFitment.getShowDescription() == 1) {
                    Long customArea = shopFitmentService.addArea(indexPage, areaId, FitmentAreaType.CENTER.value(), 1);
                    Long customModuleId = shopFitmentService.addModule(customArea, null, FitmentModuleType.Custom.value, 3, null);
                    CustomModule customModule = new CustomModule();
                    customModule.setTitleShow(0);
                    customModule.setAreaId(customArea);
                    customModule.setModuleId(customModuleId);
                    customModule.setSideType(3);
                    customModule.setContent(shiguShopFitment.getDescription());
                    shopFitmentService.revalueModule(customModuleId, customModule);
                }
            }
            shiguShopExample.setStartIndex(start += size);
        }
    }

    @Test
    public void test() throws ShopFitmentException {
//        List<FitmentArea> fitmentAreas = shopFitmentService.selAreaByPageId(79L);
        shopFitmentService.initShopFitment(35747L);
//        System.out.println(JSON.toJSONString(fitmentAreas, SerializerFeature.PrettyFormat));
    }
}
