package com.shigu.main4.storeservices.impl;

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
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.HighLightKit;
import com.shigu.main4.storeservices.ShopSearchService;
import com.shigu.main4.vo.OpenShopVo;
import com.shigu.main4.vo.SearchShop;
import com.shigu.main4.vo.SearchShopSimple;
import com.shigu.opensearchsdk.OpenSearch;
import com.shigu.opensearchsdk.builder.FilterBuilder;
import com.shigu.opensearchsdk.builder.QueryBuilder;
import com.shigu.opensearchsdk.query.SearchQuery;
import com.shigu.opensearchsdk.response.Result;
import com.shigu.opensearchsdk.response.SearchResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 阿里开放搜索 实现店铺搜索
 * Created by bugzy on 2017/5/31 0031.
 */
@Service("shopSearchOpenService")
public class ShopSearchServiceOpenImpl implements ShopSearchService {

    private static final Logger logger = LoggerFactory.getLogger(ShopSearchServiceOpenImpl.class);
    public static final Pattern CHS_PATTERN = Pattern.compile("[\\u4E00-\\u9FA5]+");
    public static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    private OpenSearch openSearch;

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

        OpenSearch.RequestBuilder<OpenShopVo> requestBuilder
                = openSearch.searchFrom(OpenShopVo.class).from((page - 1) * pageSize).size(pageSize);
        String keywordNum = keyword.replaceAll(CHS_PATTERN.toString(), "");
        String keywordChina = keyword.replaceAll(NUMBER_PATTERN.toString(), "");
        if (StringUtils.isNotEmpty(keyword)) {
            SearchQuery searchQuery = QueryBuilder.search("shop_info", keyword);
            if (StringUtils.isNotEmpty(keywordChina)) {
                searchQuery.or(QueryBuilder.search("shop_market_info", keywordChina).boost(5)
                        .and(QueryBuilder.search("shop_info", keyword)));
            }
            if (StringUtils.isNotEmpty(keywordNum)) {
                searchQuery.or(QueryBuilder.search("shop_num_info", keywordNum).boost(10)
                        .and(QueryBuilder.search("shop_info", keyword)));
            }
            requestBuilder.setQuery(searchQuery);
        }
        if (StringUtils.isNotEmpty(webSite)) {
            requestBuilder.addFilter(FilterBuilder.term("web_site_1", webSite));
        }
        if (mid != null) {
            requestBuilder.addFilter(FilterBuilder.number("market_id_1", mid));
        }
        SearchResponse<OpenShopVo> response = requestBuilder.execute();
        if (response.isSuccess()) {
            Result<OpenShopVo> result = response.getResult();
            pager.calPages(result.getTotal(), pageSize);
            pager.setContent(new ArrayList<SearchShop>(result.getItems().size()));
            List<OpenShopVo> openShopVos = BeanMapper.getFieldList(result.getItems(), "fields", OpenShopVo.class);
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
                    pager.getContent().add(searchShop);
                }
            }
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
        ShiguShopExample shiguShopExample = new ShiguShopExample();
        shiguShopExample.createCriteria().andShopIdIn(shopIds).andWebSiteEqualTo(website);
        List<ShiguShop> shiguShops = shiguShopMapper.selectByExample(shiguShopExample);

        if (shiguShops.isEmpty()) {
            return Collections.emptyList();
        }

        List<SearchShopSimple> searchShops = BeanMapper.mapList(shiguShops, SearchShopSimple.class);

        ShiguMarketExample shiguMarketExample = new ShiguMarketExample();
        shiguMarketExample.createCriteria().andMarketIdIn(new ArrayList<>(BeanMapper.getFieldSet(shiguShops, "marketId", Long.class)));
        List<ShiguMarket> shiguMarkets = shiguMarketMapper.selectFieldsByExample(shiguMarketExample, FieldUtil.codeFields("market_name,market_id"));
        Map<Long, ShiguMarket> marketMap = BeanMapper.list2Map(shiguMarkets, "marketId", Long.class);

        ShiguShopLicenseExample shiguShopLicenseExample = new ShiguShopLicenseExample();
        shiguShopLicenseExample.createCriteria().andShopIdIn(shopIds).andLicenseFailureEqualTo(0).andLicenseTypeEqualTo(6);
        List<ShiguShopLicense> shiguShopLicenses = shiguShopLicenseMapper.selectFieldsByExample(shiguShopLicenseExample, FieldUtil.codeFields("license_id,context"));
        Map<Long, ShiguShopLicense> licenseMap = BeanMapper.list2Map(shiguShopLicenses, "shopId", Long.class);

        for (SearchShopSimple searchShop : searchShops) {
            ShiguMarket shiguMarket = marketMap.get(searchShop.getMarketId());
            if (shiguMarket != null) {
                searchShop.setMarket(shiguMarket.getMarketName());
            }
            ShiguShopLicense shiguShopLicense = licenseMap.get(searchShop.getShopId());
            if (shiguShopLicense != null) {
                searchShop.setStarNum(shiguShopLicense.getContext());
            }
        }
        return searchShops;
    }

    /**
     * 按shopNum精确匹配一个店
     *
     * @param shopNum
     * @param webSite
     * @return
     */
    @Override
    public List<SearchShopSimple> selShopByShopNum(String shopNum,String webSite) {
        if (StringUtils.isEmpty(shopNum)) {
            return Collections.emptyList();
        }

        ShiguShopExample shiguShopExample = new ShiguShopExample();
        shiguShopExample.createCriteria().andShopNumEqualTo(shopNum).andWebSiteEqualTo(webSite);
        List<ShiguShop> shiguShopList = shiguShopMapper.selectByExample(shiguShopExample);
        List<Long> marketIdList = new ArrayList<>(BeanMapper.getFieldSet(shiguShopList, "marketId", Long.class));
        List<Long> shopIdList = new ArrayList<>(BeanMapper.getFieldSet(shiguShopList, "shopId", Long.class));

        //获取相关联market实体类集合
        List<ShiguMarket> shiguMarketList;
        if (0 < marketIdList.size()) {
            ShiguMarketExample shiguMarketExample = new ShiguMarketExample();
            shiguMarketExample.createCriteria().andMarketIdIn(new ArrayList<>(marketIdList));
            shiguMarketList =  shiguMarketMapper.selectByExample(shiguMarketExample);
        } else {
            shiguMarketList = new ArrayList<>();
        }
        Map<Long, ShiguMarket> shiguMarketMap =  BeanMapper.list2Map(shiguMarketList, "marketId", Long.class);

        //获取相关联shoplicense实体类集合
        List<ShiguShopLicense> shiguShopLicenseList;
        if (0 < shopIdList.size()) {
            ShiguShopLicenseExample licenseExample = new ShiguShopLicenseExample();
            licenseExample.createCriteria().andShopIdIn(shopIdList).andLicenseTypeEqualTo(6);
            shiguShopLicenseList = shiguShopLicenseMapper.selectByExample(licenseExample);
        } else {
            shiguShopLicenseList = new ArrayList<>();
        }

        Map<Long, ShiguShopLicense> shiguShopLicenseMap =  BeanMapper.list2Map(shiguShopLicenseList, "shopId", Long.class);

        List<SearchShopSimple> shiguShopSimpleList = new ArrayList<>();
        for(ShiguShop item : shiguShopList) {
            SearchShopSimple searchShopSimple = BeanMapper.map(item, SearchShopSimple.class);
            ShiguMarket market = shiguMarketMap.get(searchShopSimple.getMarketId());
            if (market != null) {
                searchShopSimple.setMarket(market.getMarketName());
            }
            ShiguShopLicense shopLicense = shiguShopLicenseMap.get(searchShopSimple.getShopId());
            if (shopLicense != null) {
                searchShopSimple.setStarNum(shopLicense.getContext());
            }

            shiguShopSimpleList.add(searchShopSimple);
        }

        return shiguShopSimpleList;
    }

}
