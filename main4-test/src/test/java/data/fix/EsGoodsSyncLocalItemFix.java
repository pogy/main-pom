//package data.fix;
//
//import com.alibaba.fastjson.JSON;
//import com.opentae.core.mybatis.utils.FieldUtil;
//import com.opentae.data.mall.beans.ESGoods;
//import com.opentae.data.mall.beans.ShiguGoodsSoldout;
//import com.opentae.data.mall.beans.ShiguGoodsTiny;
//import com.opentae.data.mall.beans.ShiguShop;
//import com.opentae.data.mall.examples.ShiguGoodsSoldoutExample;
//import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
//import com.opentae.data.mall.examples.ShiguShopExample;
//import com.opentae.data.mall.interfaces.ShiguGoodsSoldoutMapper;
//import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
//import com.opentae.data.mall.interfaces.ShiguShopMapper;
//import com.searchtool.configs.ElasticConfiguration;
//import com.searchtool.domain.SimpleElaBean;
//import com.searchtool.mappers.ElasticRepository;
//import com.shigu.main4.common.util.BeanMapper;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.SearchHit;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.atomic.AtomicInteger;
//
//import static org.slf4j.LoggerFactory.getLogger;
//
///**
// * Created by wxc on 2017/4/2.
// * <p>
// * 此类旨在修复ES上商品与本地数据不同步的情况
// * <p>
// * 修改店铺ID，运行此类，会将本地数据库的商品数据（包括下架的）同步到ES。
// *
// * @author wxc
// * @version main_site4.0 4.0.0
// * @since main_site4.0 4.0.0
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:ac.xml")
//public class EsGoodsSyncLocalItemFix {
//
//    private static final Logger logger = getLogger(EsGoodsSyncLocalItemFix.class);
//
//    @Autowired
//    private ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;
//
//    @Autowired
//    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;
//
//    @Autowired
//    private ShiguShopMapper shiguShopMapper;
//
//    @Autowired
//    private EsGoodsService esGoodsService;
//
//    private ElasticRepository repository = new ElasticRepository();
//
//    /**
//     * ES 商品包含出售中及已下架的商品
//     * <p>
//     * 功能入口在下面
//     */
//    public void syncEs(ShiguShop shop) throws Exception {
////         = 42450L;
//
//        String webSite = shop.getWebSite();
//        ShiguGoodsTinyExample goodsExample = new ShiguGoodsTinyExample();
//        goodsExample.setWebSite(webSite);
//        goodsExample.createCriteria().andStoreIdEqualTo(shop.getShopId());
//        List<ShiguGoodsTiny> tinies = shiguGoodsTinyMapper.selectByExample(goodsExample);
//        Map<Long, ShiguGoodsTiny> tinyGoodsIds = BeanMapper.list2Map(tinies, "goodsId", Long.class);
//        logger.debug(shop.getShopName() + ") 架上商品:" + tinies.size());
//
//        ShiguGoodsSoldoutExample soldoutExample = new ShiguGoodsSoldoutExample();
//        soldoutExample.setWebSite(webSite);
//        soldoutExample.createCriteria().andStoreIdEqualTo(shop.getShopId());
//        List<ShiguGoodsSoldout> soldouts = shiguGoodsSoldoutMapper.selectByExample(soldoutExample);
//        Map<Long, ShiguGoodsSoldout> soldoutGoodsIds = BeanMapper.list2Map(soldouts, "goodsId", Long.class);
//        logger.debug(shop.getShopName() + ") 下架商品:" + soldouts.size());
//
//        List<Long> esGoodsIds = new ArrayList<>();
//        SearchResponse response = ElasticConfiguration.searchClient.prepareSearch("goods").setFrom(0).setSize(10000).setTypes(webSite)
//                .setQuery(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("storeId", shop.getShopId()))).execute().actionGet();
//
//        SearchHit[] hits = response.getHits().getHits();
//
//        if (hits != null && hits.length > 0) {
//            logger.debug("ES商品数: " + hits.length);
//            List<SimpleElaBean> sebs = new ArrayList<>();
//            for (SearchHit hit : hits) {
//                Map<String, Object> source = hit.getSource();
//                Object is_off = source.get("is_off");
//                Long goodsId = Long.valueOf(source.get("goodsId").toString());
//                esGoodsIds.add(goodsId);
//                if (is_off != null && (Integer) is_off == 0) {
//                    ShiguGoodsTiny tiny = JSON.parseObject(hit.getSourceAsString(), ShiguGoodsTiny.class);
//                    if (tinyGoodsIds.keySet().contains(tiny.getGoodsId())) {
//                        ShiguGoodsTiny goodsTiny = tinyGoodsIds.get(tiny.getGoodsId());
//                        ESGoods esGoods = esGoodsService.createEsGoods(goodsTiny);
//                        insert(webSite, esGoods);
//                    } else {
//                        sebs.add(new SimpleElaBean("goods", webSite, hit.getId()));
//                    }
//                } else {
//                    ShiguGoodsSoldout soldout = JSON.parseObject(hit.getSourceAsString(), ShiguGoodsSoldout.class);
//                    if (soldoutGoodsIds.keySet().contains(soldout.getGoodsId())) {
//                        ShiguGoodsSoldout goodsSoldout = soldoutGoodsIds.get(soldout.getGoodsId());
//                        ESGoods esGoods = esGoodsService.createEsGoods(goodsSoldout);
//                        insert(webSite, esGoods);
//                    } else {
//                        sebs.add(new SimpleElaBean("goods", webSite, soldout.getGoodsId() + ""));
//                    }
//                }
//            }
//            repository.deleteListByKey(sebs, 10000);
//        }
//        List<Long> tinLong = new ArrayList<>(tinyGoodsIds.keySet());
//        tinLong.removeAll(esGoodsIds);
//        logger.debug("出售中缺少" + tinLong.size());
//        for (Long aLong : tinLong) {
//            ShiguGoodsTiny tiny = tinyGoodsIds.get(aLong);
//            ESGoods esGoods = esGoodsService.createEsGoods(tiny);
//            insert(webSite, esGoods);
//        }
//
//        ArrayList<Long> soldoutLong = new ArrayList<>(soldoutGoodsIds.keySet());
//        soldoutLong.removeAll(esGoodsIds);
//        logger.debug("下架缺少" + soldoutLong.size());
//        for (Long aLong : soldoutLong) {
//            ShiguGoodsSoldout soldout = soldoutGoodsIds.get(aLong);
//            ESGoods esGoods = esGoodsService.createEsGoods(soldout);
//            insert(webSite, esGoods);
//        }
//
//    }
//
//    AtomicInteger times = new AtomicInteger(0);
//    private void insert(String type, ESGoods esGoods) {
//        if ((times.addAndGet(1) % 500 == 0)) {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//            }
//        }
//        repository.insert(new SimpleElaBean("goods", type, esGoods.getGoodsId().toString(), JSON.toJSONStringWithDateFormat(esGoods, "yyyy-MM-dd HH:mm:ss")));
//    }
//
//
//    private LinkedBlockingQueue<List<ShiguShop>> queue = new LinkedBlockingQueue<>();
//
//    /**
//     * 按如下顺序
//     * 电商基地、钱塘大厦、星座女装、之江服饰、四季星座、好四季、意法服饰、置地国际、九星服饰、九天国际、新杭派、四季青、中纺服饰、中星外贸
//     * (1087,   617,    601,    608,    621,   1462,     642,   655,    1105,   661,    670,    666,    668,    652)
//     *
//     * @throws Exception
//     */
//    @Test
//    public void testSyncAll() throws Exception {
//
//        for (int i = 0; i < 5; i++) {
//            Thread thread = new Thread(
//                    new RunSyn()
//                    , "wk" + i
//            );
//            thread.setPriority(Thread.MAX_PRIORITY);
//            thread.start();
//        }
//
//        int[] marketIds = {1087, 617, 601, 608, 621, 1462, 642, 655, 1105, 661, 670, 666, 668, 652};
//
//        for (int marketId : marketIds) {
//            ShiguShopExample shopExample = new ShiguShopExample();
//            shopExample.createCriteria().andMarketIdEqualTo((long) marketId).andShopStatusEqualTo(0);
//            splitShop(shiguShopMapper.selectFieldsByExample(shopExample, FieldUtil.codeFields("shop_id, shop_name, web_site")));
//        }
//        while (true) {
//            logger.debug("wait...");
//            Thread.sleep(3333);
//            logger.info("队列" + String.valueOf(queue.size()));
//            logger.info("插入" + String.valueOf(times.get()));
//        }
//    }
//
//    private void splitShop(List<ShiguShop> shiguShops) throws InterruptedException {
//        int tmp = 50;
//        List<ShiguShop> shops = new ArrayList<>(tmp);
//        for (int i = 0; i < shiguShops.size(); i++) {
//            ShiguShop shiguShop = shiguShops.get(i);
//            if (i != 0 && i % tmp == 0) {
//                queue.put(shops);
//                shops = new ArrayList<>(tmp);
//            }
//            shops.add(shiguShop);
//        }
//        queue.put(shops);
//    }
//
//    class RunSyn implements Runnable {
//
//        @Override
//        public void run() {
//            while (true)
//                try {
//                    for (ShiguShop shop : queue.take()) {
//                        logger.info("sync " + shop.getShopName());
//                        try {
//                            syncEs(shop);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//        }
//    }
//
//    /**
//     * 同步Es与mysql
//     * @throws Exception
//     */
//    @Test
//    public void syncOne() throws Exception {
//        syncEs(shiguShopMapper.selectByPrimaryKey(42407L));
//    }
//}
