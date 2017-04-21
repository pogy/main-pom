package com.shigu.main4.store.test.wxc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.storeservices.ShopLicenseService;
import com.shigu.main4.vo.CatPolymerization;
import com.shigu.main4.vo.ShopBaseForCdn;
import com.shigu.main4.vo.ShopCat;
import com.shigu.main4.vo.ShopLicense;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wxc on 2017/2/20.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
@ContextConfiguration( value="/main4/spring/store_test.xml" )
public class ShopForCdnServiceTest extends AbstractJUnit4SpringContextTests{

    private static final Logger logger = LoggerFactory.getLogger(ShopForCdnServiceTest.class);

    @Resource
    private ShopForCdnService shopForCdnService;

    @Autowired
    ShopLicenseService shopLicenseService;

    @Autowired
    ShiguShopMapper shiguShopMapper;

    @Test
    public void selWsy() throws IOException, ParseException {
        Connection conn= Jsoup.connect("http://wsy.com/market.htm?kid=18");
        Elements eles=conn.get().select("#shoplist1 a");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        for(Element e:eles){
            String url=e.attr("href");
            conn=Jsoup.connect(url);
            Document dom=conn.get();
            String shopNum=dom.select(".shop-name").text().trim().replace("电商基地", "");
            String time=dom.select(".shop-msg-con .smcm-li span").get(2).text();
            //查店
            ShiguShopExample example=new ShiguShopExample();
            example.createCriteria().andShopNumEqualTo(shopNum).andMarketIdEqualTo(1087L).andShopStatusEqualTo(0);
            if(shiguShopMapper.countByExample(example)>0){
                ShiguShop shop=new ShiguShop();
                shop.setCreateDate(sdf.parse(time));
                shiguShopMapper.updateByExampleSelective(shop, example);
                System.out.println(shopNum+"   "+time);
            }
        }
    }

    /**
     * 按店ID查店内类目 测试
     *
     */
    @Test
    public void testSelShopCatsById() {
        List<ShopCat> shopCats = shopForCdnService.selShopCatsById(15418L);
        List<ShopCat> shopCatsHit = shopForCdnService.selShopCatsById(15418L);

        assertTrue("未cache住哇哇哇哇!", shopCats == shopCatsHit);
    }

    /**
     *  查店铺的星星数
     */
    @Test
    public void testSelShopStarById() {
        Long starById = shopForCdnService.selShopStarById(16080L);
        Long starByCache = shopForCdnService.selShopStarById(16080L);

        assertTrue(starById == starByCache);
    }


    /**
     * 查本店类目商品数聚合情况
     */
    @Test
    public void testSelCatRolymerizations() {
        List<CatPolymerization> catPolymerizations = shopForCdnService.selCatRolymerizations(40904L);
        List<CatPolymerization> cacheObj = shopForCdnService.selCatRolymerizations(40904L);

        logger.info("\n" + JSON.toJSONString(cacheObj, SerializerFeature.PrettyFormat));
        assertTrue(catPolymerizations == cacheObj);
    }

    /**
     * 店铺权益
     */
    @Test
    public void testSelShopLicences() {
        List<ShopLicense> shopLicenses = shopLicenseService.selShopLicenses(15418L);

        logger.info("\n" + JSON.toJSONString(shopLicenses, SerializerFeature.PrettyFormat));

        assertFalse(shopLicenses.isEmpty());
    }


    /**
     * 测试查询店铺基本信息
     */
    @Test
    public void testSelShopBase() {

        // 不存在的
        ShopBaseForCdn forCdn = shopForCdnService.selShopBase(2333333L);

        assertNull(forCdn);

        // 存在的
        forCdn = shopForCdnService.selShopBase(39887L);
        logger.info("\n" + JSON.toJSONString(forCdn, SerializerFeature.PrettyFormat));
        assertNotNull(forCdn);

        //缓存的
        ShopBaseForCdn cache = shopForCdnService.selShopBase(39887L);

        assertTrue(forCdn == cache);
    }
}
