package com.shigu.main4.data.translate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.MemberUserExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.examples.ShiguStoreExample;
import com.opentae.data.mall.examples.ShiguStoreIdGeneratorExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by wxc on 2017/3/9.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/ac.xml")
public class ShopTrans {

    @Autowired
    private ShiguStoreMapper shiguStoreMapper;

    @Autowired
    private MemberUserMapper memberUserMapper;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    private ShiguShopLicenseMapper shiguShopLicenseMapper;

    @Autowired
    private ShiguStoreIdGeneratorMapper shiguStoreIdGeneratorMapper;

    @Autowired
    private ShiguStoreNumShowMapper shiguStoreNumShowMapper;

    @Autowired
    private ShiguSiteMapper shiguSiteMapper;

    @Autowired
    private ShiguMarketMapper shiguMarketMapper;

    @Test
    public void dataTans() throws Exception {

        String[] sites = {
                "hz",
                "cs",
                "bb",
                "bj",
                "gz",
                "jf",
                "jx",
                "ss",
                "wa",
                "xh",
        };

        ShiguStoreExample storeExample = new ShiguStoreExample();
        int size = 500;
        storeExample.setEndIndex(size);
        for (String site : sites) {
            storeExample.setWebSite(site);
            int step = 0;
            int count = shiguStoreMapper.countByExample(storeExample);
            while (step < count) {
                List<ShiguShop> shops = new ArrayList<>();
                List<ShiguShopLicense> licenses = new ArrayList<>();

                storeExample.setStartIndex(step);
                List<ShiguStore> shiguStores = shiguStoreMapper.selectByConditionList(storeExample);

                Set<Long> userIds = BeanMapper.getFieldSet(shiguStores, "userId", Long.class);
                userIds.add(-100866L);
                MemberUserExample userExample = new MemberUserExample();
                userExample.createCriteria().andUserIdIn(new ArrayList<>(userIds));
                List<MemberUser> memberUsers = memberUserMapper.selectByExample(userExample);
                Map<Long, MemberUser> userMap = BeanMapper.list2Map(memberUsers, "userId", Long.TYPE);

                for (ShiguStore store : shiguStores) {
                    ShiguShop shop = BeanMapper.map(store, ShiguShop.class);
                    shops.add(shop);
                    shop.setShopId(store.getStoreId());
                    shop.setFloorId(store.getMarketId());
                    shop.setShopName(store.getStoreName());
                    shop.setMarketId(store.getParentMarketId());
                    shop.setWebSite(site);
                    shop.setTbNick(store.getNick());//TODO: 原来的nick -> sessionMap = null continue;
                    shop.setShopNum(store.getStoreNum());
                    shop.setPriceRule(store.getPriceMatcherRule());
//                    shop.setTelephone(store.getPhone());
//                    shop.setMobilePhone(store.getTelephone());
                    shop.setDataPacketUrl(store.getPacketUrl());
                    shop.setShopAnnouncement(store.getRemark13());
                    shop.setSystemRecommon(store.getRemark5());
                    shop.setItemLinkId(store.getStoreId());
                    shop.setSortOrderKey(shop.getShopNum());
                    shop.setDisplayInMarket(1L);
                    shop.setUserManager(1);
                    int status = 0;
                    if (store.getStoreStatus() != null && store.getUseStatus() != null)
                        status = store.getStoreStatus() == 0 && store.getUseStatus() == 1 ? 0 : 1;
                    shop.setShopStatus(status);
//                    shop.setSynTaobao(store.get); // null

                    MemberUser memberUser = userMap.get(shop.getUserId());
                    if (memberUser != null) {
                        shop.setImWx(memberUser.getImWeixin());
                        shop.setEmail(memberUser.getEmail());
                    }

                    String servers = store.getServers();
                    if (StringUtils.isNotEmpty(servers)) {
                        ShiguShopLicense shopLicense = new ShiguShopLicense();
                        shopLicense.setShopId(shop.getShopId());
                        shopLicense.setLicenseType(5);
                        shopLicense.setLicenseFailure(0);
                        String context = null;
                        if (servers.equals("包换款")) {
                            context = "2";
                        } else if (servers.equals("退现金,包换款")) {
                            context = "1,2";
                        }
                        shopLicense.setContext(context);
                        if (context != null && context.length() > 0)
                            licenses.add(shopLicense);
                    }
                }
                shiguShopMapper.insertListHasId(shops);
                if (!licenses.isEmpty()) {
                    shiguShopLicenseMapper.insertListNoId(licenses);
                }
                step += size;
            }
        }
    }

    @Test
    public void reShop2Store() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        ShiguShopExample shopExample = new ShiguShopExample();
        List<Long> list = new ArrayList<>();
        list.add(42415L);
        list.add(42419L);
        list.add(42418L);
        list.add(42407L);
        shopExample.createCriteria().andShopIdIn(list);
        List<ShiguShop> shiguShops = shiguShopMapper.selectByExample(shopExample);

        List<ShiguSite> select = shiguSiteMapper.select(new ShiguSite());
        Map<String, ShiguSite> stringShiguSiteMap = BeanMapper.list2Map(select, "citySite", String.class);
        System.out.println(shiguShops.size());
        for (ShiguShop shiguShop : shiguShops) {
            System.out.println(JSON.toJSONString(shiguShop, SerializerFeature.PrettyFormat));

            ShiguStore shiguStore = new ShiguStore();
            shiguStore.setWebSite(shiguShop.getWebSite());
            shiguStore.setStoreId(shiguShop.getShopId());

//            ShiguStore store = shiguStoreMapper.selectOne(shiguStore);
//
//            ShiguSite shiguSite = stringShiguSiteMap.get(shiguShop.getWebSite());
//            if (store == null) {
//                ShiguMarket market = new ShiguMarket();
//                market.setWebSite(shiguShop.getWebSite());
//                market.setMarketId(shiguShop.getMarketId());
//                ShiguMarket shiguMarket = shiguMarketMapper.selectByPrimaryKey(market);
//                market.setMarketId(shiguShop.getFloorId());
//                ShiguMarket floor = shiguMarketMapper.selectByPrimaryKey(market);
//
//                ShiguStoreIdGenerator idGenerator = new ShiguStoreIdGenerator();
//                idGenerator.setWebSite(shiguShop.getWebSite());
//                idGenerator.setRemark("1");
//                idGenerator.setStoreId(shiguShop.getShopId());
//                idGenerator.setUserId(shiguShop.getUserId());
//                shiguStoreIdGeneratorMapper.insert(idGenerator);
//
//                store = BeanMapper.map(shiguShop, ShiguStore.class);
//                store.setStoreId(shiguShop.getShopId());
//                store.setMarketId(shiguShop.getFloorId());
//                store.setStoreName(shiguShop.getShopName());
//                store.setParentMarketId(shiguShop.getMarketId());
//                store.setNick(shiguShop.getTbNick());//TODO: 原来的nick -> sessionMap = null continue;
//                store.setStoreNum(shiguShop.getShopNum());
//                store.setPriceMatcherRule(shiguShop.getPriceRule());
//                store.setPacketUrl(shiguShop.getDataPacketUrl());
//                store.setRemark13(shiguShop.getShopAnnouncement());
//                store.setRemark5(shiguShop.getSystemRecommon());
//                store.setBuycityId(shiguSite.getBuycityId());
//                store.setMarket(floor.getMarketName());
//                store.setParentMarket(shiguMarket.getParentMarketName());
////                store.setSortOrder(shiguShop.getSortOrderKey());
//
//                shiguStoreMapper.insertSelective(store);
//                System.out.println(JSON.toJSONStringWithDateFormat(store, "yyyy-MM-dd HH:mm:ss", SerializerFeature.PrettyFormat));
//
//                ShiguStoreNumShow show = new ShiguStoreNumShow();
//                show.setStoreNumId(shiguShop.getShopId());
//                show.setStoreId(shiguShop.getShopId());
//                show.setWebSite(shiguShop.getWebSite());
//                show.setStoreNum(shiguShop.getShopNum());
//                show.setBuycityId(shiguSite.getBuycityId());
//                show.setLastModifyTime(shiguShop.getLastModifyTime());
//                show.setMainType(shiguShop.getMainBus());
//                show.setStoreNum(shiguShop.getShopNum());
//                show.setMarketId(shiguShop.getFloorId());
//                show.setParentMarketId(shiguShop.getMarketId());
//                show.setServices("退现金,包换款");
//                show.setMarket(floor.getMarketName());
//                show.setParentMarket(shiguMarket.getParentMarketName());
////                show.setServices();
//                shiguStoreNumShowMapper.insert(show);
//            }
        }
    }
}
