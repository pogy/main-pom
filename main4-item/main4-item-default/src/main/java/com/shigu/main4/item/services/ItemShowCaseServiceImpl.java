package com.shigu.main4.item.services;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.item.beans.GoodsupLongTerms;
import com.shigu.main4.item.enums.ItemFrom;
import com.shigu.main4.item.exceptions.ItemException;
import com.shigu.main4.item.exceptions.ShopsItemException;
import com.shigu.main4.item.exceptions.ShowCaseException;
import com.shigu.main4.item.services.utils.ElasticCountUtil;
import com.shigu.main4.item.services.utils.OnsaleInstockReader;
import com.shigu.main4.item.services.utils.SelIOItemsUtil;
import com.shigu.main4.item.vo.ShowCaseItem;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * showcase服务
 * Created by zhaohongbo on 17/3/9.
 */
@Service("itemShowCaseService")
public class ItemShowCaseServiceImpl implements ItemShowCaseService{

    private static final Logger logger = LoggerFactory.getLogger(ItemShowCaseServiceImpl.class);

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    protected EhCacheCacheManager cacheManager;
    /**
     * 商品ID产生表
     */
    @Autowired
    ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;
    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    SelIOItemsUtil selIOItems;

    @Autowired
    private ElasticCountUtil elasticCountUtil;
    /**
     * 最大推荐10个,如果以后按用户有不同,可能需要走用户权益
     */
    int showcaseSize=10;

    @Override
    public void modifyShowcase(Long shopId,String webSite, List<Long> itemId, Integer showCase) throws ShowCaseException {
        ShiguGoodsTinyExample shiguGoodsTinyExample=new ShiguGoodsTinyExample();
        if(showCase==1){//是要去推荐的
            shiguGoodsTinyExample.createCriteria().andStoreIdEqualTo(shopId).andIsShowcaseEqualTo(1);//是推荐的
            shiguGoodsTinyExample.setWebSite(webSite);
            int count=shiguGoodsTinyMapper.countByExample(shiguGoodsTinyExample);
            if(count>=showcaseSize){
                throw new ShowCaseException("最大推荐个数"+showcaseSize+"个,现在已经达到"+showcaseSize+"个");
            }
            shiguGoodsTinyExample.clear();
        }
        ShiguGoodsTinyExample.Criteria cri=shiguGoodsTinyExample.createCriteria().andGoodsIdIn(itemId);
        if(shopId!=null){
            cri.andStoreIdEqualTo(shopId);
        }
        shiguGoodsTinyExample.setWebSite(webSite);
        ShiguGoodsTiny update=new ShiguGoodsTiny();
        update.setWebSite(webSite);
        update.setIsShowcase(showCase);
        shiguGoodsTinyMapper.updateByExampleSelective(update,shiguGoodsTinyExample);
        cacheManager.getCache("shopRecommentsCache").evict(shopId);
    }

    @Override
    public ShiguPager<ShowCaseItem> selShowCases(final String keyword, final String goodsNo, final Long numIid, Long shopId, int pageNo, int pageSize) throws ItemException {

        return selIOItems.selIOItems(new OnsaleInstockReader<ShowCaseItem>(shopId) {
            @Override
            protected SgExample makeExample(String webSite, int pageNo, int pageSize) {
                ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
                tinyExample.setWebSite(webSite);
                tinyExample.setStartIndex((pageNo - 1) * pageSize);
                tinyExample.setEndIndex(pageSize);
                tinyExample.setOrderByClause("last_modify_time DESC");

                ShiguGoodsTinyExample.Criteria criteria = tinyExample.createCriteria()
                        .andStoreIdEqualTo(getShopId())
                        .andIsClosedEqualTo(0L);//TODO: 店铺中的 is_closed = 0 ??

                criteria.andIsShowcaseEqualTo(1);
                if (StringUtils.isNotEmpty(keyword))
                    criteria.andTitleLike("%" + keyword + "%");
                if (StringUtils.isNotEmpty(goodsNo))
                    criteria.andGoodsNoLike("%" + goodsNo + "%");
                if (numIid != null)
                    criteria.andNumIidEqualTo(numIid);
                return tinyExample;
            }

            @Override
            protected int countByExample(SgExample example) {
                return shiguGoodsTinyMapper.countByExample(example);
            }

            @Override
            protected List<ShowCaseItem> selectByExample(SgExample example) {
                List<ShiguGoodsTiny> shiguGoodsTinies = shiguGoodsTinyMapper.selectByConditionList(example);
                GoodsupLongTerms<Integer> countAgg = elasticCountUtil.countItemUp(shiguGoodsTinies);
                List<ShowCaseItem> onsaleItems = new ArrayList<>();
                for (ShiguGoodsTiny tiny : shiguGoodsTinies) {
                    ShowCaseItem item = new ShowCaseItem();
                    onsaleItems.add(item);
                    if (tiny.getIsExcelImp() != null)
                        item.setItemFrom(ItemFrom.values()[tiny.getIsExcelImp()]);
                    item.setPiPrice(tiny.getPiPriceString());
                    item.setPrice(tiny.getPriceString());
                    item.setTitle(tiny.getTitle());
                    item.setGoodsNo(tiny.getGoodsNo());
                    item.setPicUrl(tiny.getPicUrl());
                    item.setCreated(tiny.getCreated());
                    item.setWebSite(tiny.getWebSite());
                    item.setItemId(tiny.getGoodsId());
                    item.setIsShowCase(tiny.getIsShowcase());
                    if (countAgg != null && countAgg.get(tiny.getGoodsId().toString()) != null) {
                        item.setGoodsUpNum(countAgg.get(tiny.getGoodsId().toString()));
                    }
                }
                return onsaleItems;
            }

            @Override
            protected String selWebSite(Long shopId) throws ItemException {
                ShiguShop shiguShop;
                if (shopId == null || (shiguShop = shiguShopMapper.selectFieldsByPrimaryKey(shopId, FieldUtil.codeFields("shop_id,web_site"))) == null)
                    throw new ShopsItemException(ShopsItemException.ShopsItemExceptionEnum.SHOP_DOES_NOT_EXIST);
                return shiguShop.getWebSite();
            }
        }, pageNo, pageSize);
    }
}
