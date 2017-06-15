package com.shigu.main4.storeservices.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.opensearch.SearcherClient;
import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.aliyun.opensearch.sdk.generated.commons.OpenSearchClientException;
import com.aliyun.opensearch.sdk.generated.commons.OpenSearchException;
import com.aliyun.opensearch.sdk.generated.search.Config;
import com.aliyun.opensearch.sdk.generated.search.SearchFormat;
import com.aliyun.opensearch.sdk.generated.search.SearchParams;
import com.aliyun.opensearch.sdk.generated.search.general.SearchResult;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.beans.ShiguShopLicense;
import com.opentae.data.mall.examples.ShiguMarketExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.examples.ShiguShopLicenseExample;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguShopLicenseMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.HighLightKit;
import com.shigu.main4.vo.OpenShopVo;
import com.shigu.main4.vo.SearchShop;
import com.shigu.main4.vo.SearchShopSimple;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 阿里开放搜索 实现店铺搜索
 * Created by bugzy on 2017/5/31 0031.
 */
@Service
public class ShopSearchServiceOpenImpl extends ShopSearchServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(ShopSearchServiceOpenImpl.class);

    @Autowired
    private SearcherClient searcherClient;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    /**
     * 查单店商品
     *
     * @param keyword  搜索词
     * @param webSite  分站
     * @param mid      市场ID
     * @param page     页码
     * @param pageSize 分页大小
     * @return 分页结构数据
     */
    @Override
    public ShiguPager<SearchShop> searchShop(String keyword, String webSite, Long mid, Integer page, Integer pageSize) {

        ShiguPager<SearchShop> pager = new ShiguPager<>();
        pager.setNumber(page);

        Config config = new Config(Lists.newArrayList("shop_search_ol"));
        config.setStart((page - 1) * page);
        config.setHits(pageSize);
        config.setFetchFields(Lists.newArrayList("shop_id", "market_id_1", "shop_name", "web_site_1", "tb_nick", "shop_num", "shop_status", "market_name"));
        config.setSearchFormat(SearchFormat.JSON);
        SearchParams searchParams = new SearchParams(config);
        String keywordNum = keyword.replaceAll(CHS_PATTERN.toString(), "");
        String keywordChina = keyword.replaceAll(NUMBER_PATTERN.toString(), "");
        if (StringUtils.isNotEmpty(keyword)) {
            String query = "shop_info:\"" + keyword + "\"";
            if (StringUtils.isNotEmpty(keywordChina)) {
                query += " OR (shop_market_info:'" + keywordChina + "'^5 AND shop_info:'" + keyword + "')";
            }
            if (StringUtils.isNotEmpty(keywordNum)) {
                query += " OR (shop_num_info:'" + keywordNum + "'^10 AND shop_info:'" + keyword + "')";
            }
            searchParams.setQuery(query);
        }
        String filter = "";
        if (StringUtils.isNotEmpty(webSite)) {
            filter = "web_site_1=\"" + webSite + "\"";
        }
        if (mid != null) {
            if (StringUtils.isNotEmpty(filter)) {
                filter += " AND ";
            }
            filter += "market_id_1=" + mid;
        }
        if (StringUtils.isNotEmpty(filter)) {
            searchParams.setFilter(filter);
        }
        try {
            SearchResult result = searcherClient.execute(searchParams);
            JSONObject jsonObject = JSON.parseObject(result.getResult());
            if ("OK".equals(jsonObject.getString("status"))) {
                JSONObject data = jsonObject.getJSONObject("result");
                int total = data.getIntValue("total");
                pager.calPages(total, pageSize);
                ArrayList<SearchShop> shop = Lists.newArrayList();
                pager.setContent(shop);

                JSONArray items = data.getJSONArray("items");
                List<OpenShopVo> openShopVos = items.toJavaList(OpenShopVo.class);
                if (!openShopVos.isEmpty()) {
                    HighLightKit defaultInstance = HighLightKit.getDefaultInstance();

                    List<Long> shopIds = BeanMapper.getFieldList(openShopVos, "shopId", Long.class);
                    ShiguShopExample shopExample = new ShiguShopExample();
                    shopExample.createCriteria().andShopIdIn(shopIds);
                    Map<Long, ShiguShop> shopMap
                            = BeanMapper.list2Map(shiguShopMapper.selectByExample(shopExample), "shopId", Long.class);
                    for (OpenShopVo vo : openShopVos) {
                        SearchShop searchShop = BeanMapper.map(vo, SearchShop.class);
                        searchShop.setMarket(vo.getMarketName());
                        searchShop.setHighLightMarket(defaultInstance.bright(keyword, vo.getMarketName()));
                        searchShop.setHighLightShopNum(defaultInstance.bright(keyword, vo.getShopNum()));
                        ShiguShop shiguShop = shopMap.get(vo.getShopId());
                        if (shiguShop != null) {
                            searchShop.setAddress(shiguShop.getAddress());
                            searchShop.setImAliww(shiguShop.getImAliww());
                            searchShop.setImQq(shiguShop.getImQq());
                            searchShop.setMainCase(shiguShop.getMainBus());
                            searchShop.setTelephone(shiguShop.getTelephone());

                        }
                        shop.add(searchShop);
                    }

                }
            } else throw new Main4Exception(jsonObject.getString("errors"));
        } catch (OpenSearchException | OpenSearchClientException ignored) {
        } catch (Main4Exception e) {
            logger.error("搜索失败", e);
        }
        return pager;
    }

    @Resource
    private ShiguMarketMapper shiguMarketMapper;
    @Resource
    private ShiguShopLicenseMapper shiguShopLicenseMapper;

    /**
     * 按shopId查店信息
     *
     * @param shopIds
     * @return
     */
    public List<SearchShopSimple> selShopByIds(List<Long> shopIds, String website) {
        if (shopIds == null || shopIds.isEmpty()) {
            return Collections.emptyList();
        }
        List<SearchShopSimple> searchShops = new ArrayList<SearchShopSimple>();
        /**
         * 创建shiguShop组合条件查询对象
         */
        ShiguShopExample shiguShopExample = new ShiguShopExample();
        /**
         * 创建shiguShopExample离线查询对象
         */
        ShiguShopExample.Criteria criteria = shiguShopExample.createCriteria();
        criteria.andShopIdIn(shopIds);
        criteria.andWebSiteEqualTo(website);
        /**
         * 根据shopId集合和网站名称查询
         * 返回一个shiguShop集合shiguShops
         */
        List<ShiguShop> shiguShops = shiguShopMapper.selectByExample(shiguShopExample);
        List<Long> marketIds = new ArrayList<>();
        /**
         *遍历shigushops封装到集合searchShopSimple
         * 添加marketID数据到集合marketIds
         */
        for (int j = 0; j < shiguShops.size(); j++) {
            searchShops.add(BeanMapper.map(shiguShops.get(j), SearchShopSimple.class));
            if (!marketIds.contains(shiguShops.get(j).getMarketId())) {

                marketIds.add(shiguShops.get(j).getMarketId());
            }
        }
        /**
         * 创建shiguMarketExample组合条件查询对象
         */
        ShiguMarketExample shiguMarketExample = new ShiguMarketExample();
        /**
         * 创建shiguMarketExample离线查询对象
         */
        ShiguMarketExample.Criteria shiguMarketExampleCriteria = shiguMarketExample.createCriteria();
        shiguMarketExampleCriteria.andMarketIdIn(marketIds);
        /**
         * 设置查询条件为根据marketIds集合查询
         * 返回一个shiguMarket集合shiguMarkets
         */
        List<ShiguMarket> shiguMarkets = shiguMarketMapper.selectFieldsByExample(shiguMarketExample, FieldUtil.codeFields("market_name,market_id"));
        /**
         * 创建一个map存放market的id和name
         */
        HashMap<Long, String> shiguMarketIdAndName = new HashMap<>();
        for (ShiguMarket shiguMarket : shiguMarkets) {
            shiguMarketIdAndName.put(shiguMarket.getMarketId(), shiguMarket.getMarketName());
        }
        /**
         * 创建shiguShopLicenseExample组合条件查询对象
         */
        ShiguShopLicenseExample shiguShopLicenseExample = new ShiguShopLicenseExample();
        /**
         * 创建shiguShopLicenseExample离线查询对象
         */
        ShiguShopLicenseExample.Criteria shiguShopLicenseExampleCriteria = shiguShopLicenseExample.createCriteria();
        /**
         * 设置查询条件为根据shopid集合查询
         */
        shiguShopLicenseExampleCriteria.andShopIdIn(shopIds);
        /**
         * 设置查询条件为LicenseFailure值为0（即有效的）
         */
        shiguShopLicenseExampleCriteria.andLicenseFailureEqualTo(0);
        /**
         * 设置查询条件为LicenseType值为6（即店铺的星星数）
         */
        shiguShopLicenseExampleCriteria.andLicenseTypeEqualTo(6);
        /**
         * 查询返回一个shiguShoplicense的集合shiguShopLicenses
         */
        List<ShiguShopLicense> shiguShopLicenses = shiguShopLicenseMapper.selectFieldsByExample(shiguShopLicenseExample, FieldUtil.codeFields("context"));
        /**
         * 遍历添加个别字段
         */
        for (int i = 0; i < searchShops.size(); i++) {
            searchShops.get(i).setMainCase(shiguShops.get(i).getMainBus());
            if (shiguShops.get(i).getMarketId() != null) {

                searchShops.get(i).setMarket(shiguMarketIdAndName.get(shiguShops.get(i).getMarketId()));
            }
            searchShops.get(i).setStarNum(shiguShopLicenses.get(i).getContext());
        }

        return searchShops;
    }

}
