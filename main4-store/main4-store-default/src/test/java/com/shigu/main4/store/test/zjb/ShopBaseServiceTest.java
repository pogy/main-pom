package com.shigu.main4.store.test.zjb;


import com.alibaba.fastjson.JSON;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.searchtool.configs.ElasticConfiguration;
import com.searchtool.domain.SimpleElaBean;
import com.searchtool.mappers.ElasticRepository;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.exceptions.ShopDomainException;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.storeservices.ShopToEsService;
import com.shigu.main4.vo.DmlReason;
import com.shigu.main4.vo.ShopBase;
import com.shigu.main4.vo.ShopInES;
import org.apache.ibatis.type.Alias;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.client.Client;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 店铺基本操作测试
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/main4/spring/store_test.xml")
public class ShopBaseServiceTest {

    @Resource(name = "shopBaseService")
    private ShopBaseService shopBaseService;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    ShiguMarketMapper shiguMarketMapper;

    @Autowired
    ShopToEsService shopToEsService;

    @Test
    public void addToEsTest() throws ExecutionException, InterruptedException {
        ShiguShopExample example=new ShiguShopExample();
        example.setStartIndex(0);
        example.setEndIndex(30000);
//        example.setOrderByClause("shop_id asc");
        List<ShiguShop> shops=shiguShopMapper.selectByConditionList(example);
        Client client = ElasticConfiguration.client;
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        for(ShiguShop s:shops){
            ShopInES sies= BeanMapper.map(s,ShopInES.class);
            ShiguMarket floor=shiguMarketMapper.selectByPrimaryKey(s.getFloorId());
            if(floor!=null){
                sies.setMarket(floor.getParentMarketName());
                sies.setFloor(floor.getMarketName());
            }
            bulkRequest.add(client.prepareIndex("shop_v6"
                    , s.getWebSite()
                    , s.getShopId().toString()).setSource(JSON.toJSONStringWithDateFormat(sies, "yyyy-MM-dd HH:mm:ss")));
        }
        bulkRequest.execute().get();
    }

    @Test
    public void addToEsDsTest(){
        ShiguShopExample example=new ShiguShopExample();
        example.createCriteria().andMarketIdEqualTo(1087L);
        List<ShiguShop> shops=shiguShopMapper.selectFieldsByExample(example, FieldUtil.codeFields("shop_id"));
        for(ShiguShop s:shops){
            shopToEsService.addToEs(s.getShopId());
        }

    }

    @Test
    public void addToEsOne(){
        shopToEsService.addToEs(42996L);
    }

    /**
     * 删除shop误添加进goods的
     */
    @Test
    public void deleteEsShopInGoods(){
        List<ShiguShop> shops=shiguShopMapper.selectFieldsByExample(new ShiguShopExample(), FieldUtil.codeFields("shop_id,web_site"));
        for(ShiguShop s:shops){
            new ElasticRepository().deleteByKey( new SimpleElaBean(
                    "goods",
                    s.getWebSite(),
                    s.getShopId().toString(),
                    null
            ));
        }

    }
    /**
     * 店铺二级域名查询
     *
     */
    @Test
    public void selDomain(){
        Long shopId = 32888L;
        String domain =  shopBaseService.selDomain(shopId);

        System.out.println("存在店铺的domain:" + domain);

        shopId = 32998L;
        domain = shopBaseService.selDomain(shopId);

        System.out.println("不存在店铺的domain:" + domain);

    }


    /**
     * 二级域名
     *
     */
    @Test
    public void updateDomainNew() throws ShopDomainException {
        Long shopId = 35992L;
        String domain = "5007";
        shopBaseService.updateDomain(shopId, domain);
    }

    /**
     * 更新二级域名
     */
    @Test
    public void updateDomain(){
        Long shopId = 35992L;
        String domain =  shopBaseService.selDomain(shopId);
        String newdomain = "5007";

        System.out.println("验证规则“4位及4位以下二级域名，不与自己当前域名一样不能修改” 当前域名：" + domain + " 修改成：" + newdomain);
        try{
            shopBaseService.updateDomain(shopId, newdomain);
            System.out.println("修改成功");
        }catch (ShopDomainException e){
            Assert.assertTrue(e.getCode().equals(ShopDomainException.ShopDomainExceptionErrorCode.DOMAIN_WITH_NUM4_REPEAT.getCode()));
            System.out.println("修改失败：" + e.toString());
        }

        newdomain = "5006";
        System.out.println("验证规则“4位及4位以下二级域名，与自己当前域名一样，可以修改” 当前域名：" + domain + " 修改成：" + newdomain);
        try{
            shopBaseService.updateDomain(shopId, newdomain);
            System.out.println("修改成功");
        }catch (ShopDomainException e){
            Assert.assertTrue(e.getCode().equals(ShopDomainException.ShopDomainExceptionErrorCode.DOMAIN_WITH_NUM4_REPEAT.getCode()));
            System.out.println("修改失败：" + e.toString());
        }


        newdomain = "B5171";
        System.out.println("验证规则“档口号不能重复，不能修改” 当前域名：" + domain + " 修改成：" + newdomain);
        try{
            shopBaseService.updateDomain(shopId, newdomain);
            System.out.println("修改成功");
        }catch (ShopDomainException e){
            Assert.assertTrue(e.getCode().equals(ShopDomainException.ShopDomainExceptionErrorCode.DOMAIN_WITH_SHOPNUM_REPEAT.getCode()));
            System.out.println("修改失败：" + e.toString());
        }

        newdomain = "123465";
        System.out.println("验证规则“域名不能重复，不能修改” 当前域名：" + domain + " 修改成：" + newdomain);
        try{
            shopBaseService.updateDomain(shopId, newdomain);
            System.out.println("修改成功");
        }catch (ShopDomainException e){
            Assert.assertTrue(e.getCode().equals(ShopDomainException.ShopDomainExceptionErrorCode.DOMAIN_WITH_REPEAT.getCode()));
            System.out.println("修改失败：" + e.toString());
        }

        newdomain = "gz_haha";
        System.out.println("验证规则“不能与系统保留域名重复，不能修改” 当前域名：" + domain + " 修改成：" + newdomain);
        try{
            shopBaseService.updateDomain(shopId, newdomain);
            System.out.println("修改成功");
        }catch (ShopDomainException e){
            Assert.assertTrue(e.getCode().equals(ShopDomainException.ShopDomainExceptionErrorCode.DOMAIN_WITH_SYSTEM_REPEAT.getCode()));
            System.out.println("修改失败：" + e.toString());
        }

    }

    @Test
    public void selShopIdByDomain(){
        String domain = "123";
        Long shopId = shopBaseService.selShopIdByDomain(domain);
        System.out.println("店铺ID:" + shopId);

        System.out.println("缓存效果");
        // 缓存效果
        shopId = shopBaseService.selShopIdByDomain(domain);
        System.out.println("缓存效果：" + shopId);

        // 无domain
        domain = "123465111";
        shopId = shopBaseService.selShopIdByDomain(domain);
        System.out.println("店铺ID:" + shopId);
    }


    @Test
    public void modifyShopBase(){
        ShopBase shopBase = new ShopBase();
        shopBase.setShopNum("A201");
        shopBase.setTaobaoUrl("http://www.baidu.com11");
        shopBase.setShopName("我是灰太狼");
        shopBase.setMainBus("1,2");
        shopBase.setDataPackageUrl("http://shigu.oss.datapackage.com");
        shopBase.setTbNick("小雨");
        shopBaseService.modifyShopBase(1L,shopBase);

        // 查询店铺信息
        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(1L);
        System.out.println("会更新taobaoUrl:"+shiguShop.getTaobaoUrl());


        shopBase.setTbNick(null);
        shopBase.setTaobaoUrl("http://www.baidu.com/22");
        shopBaseService.modifyShopBase(1L,shopBase);
        // 查询店铺信息
        shiguShop = shiguShopMapper.selectByPrimaryKey(1L);
        System.out.println("不会更新taobaoUrl:"+shiguShop.getTaobaoUrl());
    }


    /**
     * 关店
     */
    @Test
    public void closeShop(){
        System.out.println("关店测试------------------------");

        Long shopId = 32888L;
        DmlReason dmlReason = new DmlReason();
        dmlReason.setDoWhat("关店");
        dmlReason.setReason("不想了");
        dmlReason.setWho("我自己");

        shopBaseService.closeShop(shopId, dmlReason);
        System.out.println("关店成功，查看店铺状态------------------------");
        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);
        System.out.println("店铺状态:" + shiguShop.getShopStatus() + " 关店原因：" + shiguShop.getCloseReason());
    }

    /**
     * 开店
     */
    @Test
    public void openShop() throws Main4Exception {
        System.out.println("开店测试---------------------------");

        Long shopId = 32888L;
        DmlReason dmlReason = new DmlReason();
        dmlReason.setWho("我自己");
        dmlReason.setReason("突然又想");
        dmlReason.setDoWhat("开店");

        shopBaseService.openShop(shopId, dmlReason);
        System.out.println("开店成功，查看店铺状态-------------------------");
        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);
        System.out.println("店铺状态:" + shiguShop.getShopStatus() + " 开关店原因：" + shiguShop.getCloseReason());
    }

    @Test
    public void moveMarket() throws Main4Exception {
        //  记录最初的数据 marketid 603 parentMarketId 602

        System.out.println("档口迁移测试-----------------------------");

        Long shopId = 35992L;
        Long toMarketId = 674L;
        Long toFloorId = 1305L;
        String shopNum = "B410-1";

        shopBaseService.moveMarket(shopId, toMarketId ,toFloorId, shopNum);

        System.out.println("档口迁移完成-----------------------------");

        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);

        System.out.println("店铺ID:" + shiguShop.getShopId() + " marketId:" + shiguShop.getMarketId() + " floorId:" +
                shiguShop.getFloorId() + " shopNum:" + shiguShop.getShopNum());
    }

    /**
     * 查询淘宝授权同步信息
     */
    @Test
    public void shopAuthState(){
        Long shopId = 32888L;

        // 有关联map 有效时间在3-31
        int result = shopBaseService.shopAuthState(shopId);
        Assert.assertTrue(result == 1);

        // 无关联map 为null
        shopId = 32890L;
        result = shopBaseService.shopAuthState(shopId);
        Assert.assertTrue(result == 0);

        // 有关联map 时间过期
        shopId = 32891L;
        result = shopBaseService.shopAuthState(shopId);
        Assert.assertTrue(result == 2);

    }


    @Test
    public void shopBaseForUpdate(){
        Long shopId = 35992L;
        ShopBase shopBase = shopBaseService.shopBaseForUpdate(shopId);
        System.out.println("店铺基本信息>>有数据:" + JSON.toJSONString(shopBase));
        
        shopId = 328888L;
        shopBase = shopBaseService.shopBaseForUpdate(shopId);
        System.out.println("店铺基本信息>>无数据:" + JSON.toJSONString(shopBase));
    }



}
