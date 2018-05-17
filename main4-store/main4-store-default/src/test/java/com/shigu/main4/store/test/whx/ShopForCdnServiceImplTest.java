package com.shigu.main4.store.test.whx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.aliyun.opensearch.search.SearchParamsBuilder;
import com.opentae.data.mall.interfaces.ShiguFlickrMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.store.test.BaseSpringTest;
import com.shigu.main4.store.test.wxc.ShopForCdnServiceTest;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.storeservices.bo.ShopForCdnBo;
import com.shigu.main4.vo.FlickrHomeVo;
import com.shigu.main4.vo.ItemShowBlock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by whx on 2017/6/16 0016.
 *
 * @author whx
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional(rollbackFor = Exception.class)
@ContextConfiguration( value="/main4/spring/store_test.xml" )
public class ShopForCdnServiceImplTest extends AbstractJUnit4SpringContextTests {
    private static final Logger logger = LoggerFactory.getLogger(ShopForCdnServiceImplTest.class);

    @Resource
    private ShopForCdnService shopForCdnService;


    // test public ShiguPager<ItemShowBlock> searchItemOnsale(String keyword, Long shopId, String orderBy, int pageNo, int pageSize)
    @Test
    public void  searchItemOnsaleTestByKeywordAndShopIdAndOrderBy() {
        show(shopForCdnService.searchItemOnsale("夏装",41838L,"hz","price-asc",2,30));
        System.out.println("第1条测试");
        show(shopForCdnService.searchItemOnsale("夏装",41838L,"hz","price-desc",1,10));
        System.out.println("第2条测试");
        show(shopForCdnService.searchItemOnsale("春装",null,"hz","time_up",2,30));
        System.out.println("第3条测试");
        show(shopForCdnService.searchItemOnsale("夏天",null,"hz",null,1,10));
        System.out.println("第4条测试");
        show(shopForCdnService.searchItemOnsale(" ",41838L,"hz","price-asc",1,10));
        System.out.println("第5条测试");
    }

    // test public ShiguPager<ItemShowBlock> searchItemOnsale(List<Long> ids, int pageNo, int pageSize)
    @Test
    public void searchItemOnsaleTestByIds() {

        show(shopForCdnService.searchItemOnsale(null,"hz",1,10));

        show(shopForCdnService.searchItemOnsale(Lists.<Long>newArrayList(),"hz",1,10));

        show(shopForCdnService.searchItemOnsale(Lists.<Long>newArrayList(20278880L,20120674L,20120684L,20120697L,20120679L),"hz",1,10));
    }

    private Date dateFrom;
    private Date dateTo;
    {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateFrom = sdf.parse("2016-05-10 23:00:00");
            dateTo = sdf.parse("2017-01-01 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //test public ShiguPager<ItemShowBlock> searchItemOnsale(String keyword, Long shopId, Double priceFrom, Double priceTo, String orderBy,Date startTime,Date endTime, int pageNo, int pageSize)
    @Test
    public void searchItemOnsaleTestPriceFromAndPriceTo() {
        System.out.println("价格 10-500");
        show(shopForCdnService.searchItemOnsale("秋装",null,"hz",new Double(10),new Double(500),"price-desc",dateFrom,dateTo,1,20));
        System.out.println("价格 100-500");
        show(shopForCdnService.searchItemOnsale("秋装",null,"hz",new Double(100),new Double(500),"price-desc",dateFrom,dateTo,1,20));
        System.out.println("价格 不限-500");
        show(shopForCdnService.searchItemOnsale("秋装",null,"hz",null,new Double(500),"price-desc",dateFrom,dateTo,1,20));
        System.out.println("价格 100-不限");
        show(shopForCdnService.searchItemOnsale("秋装",null,"hz",new Double(100),null,"price-desc",dateFrom,dateTo,1,20));
        System.out.println("时间 2016-05-10 - 不限");
        show(shopForCdnService.searchItemOnsale("秋装",null,"hz",new Double(100),new Double(500),"price-desc",dateFrom,null,1,20));
        System.out.println("时间 不限 - 2017-01-01");
        show(shopForCdnService.searchItemOnsale("秋装",null,"hz",new Double(100),new Double(500),"price-desc",null,dateTo,1,20));
    }

    //test public ShiguPager<ItemShowBlock> searchItemOnsale(String keyword, Long shopId, Long cid, String scid, String orderBy,Date startTime,Date endTime, int pageNo, int pageSize)
    @Test
    public void searchItemOnsaleTestScidAndCidAndDateFromAndDateTo() {
        show(shopForCdnService.searchItemOnsale(null,36422L,"hz",null,"1124284939036422","price-desc",dateFrom,dateTo,1,20));
        show(shopForCdnService.searchItemOnsale(null,36422L,"hz",null,"1284219914036422","price-desc",dateFrom,dateTo,1,20));
        show(shopForCdnService.searchItemOnsale(null,null,"hz",null,"1284219914036422","price-desc",dateFrom,dateTo,1,20));
    }



    public ShopForCdnBo getShopForCdnBo(int pageNo, int pageSize, String keyword, String orderBy, List<Long> goodsIds,
                                                      Long shopId, Long cid, Double priceFrom, Double priceTo, Date dateFrom, Date dateTo, String scid) {
        ShopForCdnBo shopForCdnBo = new ShopForCdnBo();
        shopForCdnBo.setPageNo(pageNo);
        shopForCdnBo.setPageSize(pageSize);
        shopForCdnBo.setKeyword(keyword);
        shopForCdnBo.setOrderBy(orderBy);
        shopForCdnBo.setGoodsIds(goodsIds);
        shopForCdnBo.setShopId(shopId);
        shopForCdnBo.setPriceFrom(priceFrom);
        shopForCdnBo.setPriceTo(priceTo);
        shopForCdnBo.setDateFrom(dateFrom);
        shopForCdnBo.setDateTo(dateTo);
        shopForCdnBo.setScid(scid);
        return shopForCdnBo;
    }

    private ShopForCdnBo shopForCdnBo = new ShopForCdnBo();
    {
        shopForCdnBo.setPageNo(1);
        shopForCdnBo.setPageSize(30);
        shopForCdnBo.setShopId(41838L);
        shopForCdnBo.setIsOff(0);
    }

    public void show(Object object) {
        logger.info("\n" + JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss", SerializerFeature.PrettyFormat));
    }
}
