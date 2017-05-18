package com.shigu.activity.service;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ESGoods;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.activity.bo.QueryBo;
import com.shigu.activity.vo.PicCatVo;
import com.shigu.activity.vo.PicCateNav;
import com.shigu.activity.vo.StyleNavVo;
import com.shigu.activity.vo.TextCateNav;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.item.services.ItemSearchService;
import com.shigu.main4.item.vo.ShiguAggsPager;
import com.shigu.search.services.CategoryInSearchService;
import com.shigu.search.vo.CateNav;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 风格馆服务
 * Created by bugzy on 2017/5/18 0018.
 */
@Service
public class StyleService {

    @Autowired
    private ItemSearchService itemSearchService;

    @Autowired
    private CategoryInSearchService categoryInSearchService;

    private static final Map<String, String> PIC_CATE_URL;
    private static final List<StyleNavVo> NEW_STYLE;

    static {
        PIC_CATE_URL = new HashMap<>();
        PIC_CATE_URL.put("店主", "https://img.alicdn.com/bao/uploaded/i2/154127602/TB2JtouoNXkpuFjy0FiXXbUfFXa-154127602.jpg_300x300.jpg");
        PIC_CATE_URL.put("休闲", "https://img.alicdn.com/bao/uploaded/i2/154127602/TB2JtouoNXkpuFjy0FiXXbUfFXa-154127602.jpg_300x300.jpg");
        PIC_CATE_URL.put("运动", "https://img.alicdn.com/bao/uploaded/i2/154127602/TB2JtouoNXkpuFjy0FiXXbUfFXa-154127602.jpg_300x300.jpg");
        PIC_CATE_URL.put("情侣", "https://img.alicdn.com/bao/uploaded/i2/154127602/TB2JtouoNXkpuFjy0FiXXbUfFXa-154127602.jpg_300x300.jpg");
        PIC_CATE_URL.put("大码", "https://img.alicdn.com/bao/uploaded/i2/154127602/TB2JtouoNXkpuFjy0FiXXbUfFXa-154127602.jpg_300x300.jpg");

        NEW_STYLE = new ArrayList<>();
        NEW_STYLE.add(new StyleNavVo("11", "欧美"));
        NEW_STYLE.add(new StyleNavVo("13", "原宿"));
        NEW_STYLE.add(new StyleNavVo("9", "港风"));
        NEW_STYLE.add(new StyleNavVo("12", "英伦"));
        NEW_STYLE.add(new StyleNavVo("10", "日系"));
        NEW_STYLE.add(new StyleNavVo("22", "中国风"));
    }

    private static PicCateNav picCateNav;
    private static TextCateNav textCateNav;

    public PicCateNav selPicCateNav() {
        if (picCateNav == null) {
            List<PicCatVo> picCate = new ArrayList<>();

            List<CateNav> cateNavs = categoryInSearchService.selSubCates("30", SearchCategory.STYLE);
            List<CateNav> picNavs = cateNavs.subList(0, 5);
            for (CateNav picNav : picNavs) {
                PicCatVo picCatVo = new PicCatVo(picNav.getId(), picNav.getText());
                picCatVo.setImgsrc(PIC_CATE_URL.get(picCatVo.getText()));
                picCate.add(picCatVo);
            }
            picCateNav = new PicCateNav();
            picCateNav.setPicCates(picCate);
            picCateNav.setTextCates(BeanMapper.mapList(cateNavs.subList(5, cateNavs.size()), StyleNavVo.class));
        }
        for (PicCatVo picCatVo : picCateNav.getPicCates()) {
            picCatVo.setGoodscount(calStyle(picCatVo.getId()));
        }
        return picCateNav;
    }

    private int calStyle(String sid) {
        return ((int) ElasticConfiguration.searchClient.prepareSearch("goods").setSearchType(SearchType.COUNT)
                .setQuery(QueryBuilders.matchQuery("sids", sid)).execute().actionGet().getHits().getTotalHits());
    }

    public TextCateNav selTextCateNav(QueryBo bo) {
        if (textCateNav == null) {
            textCateNav = new TextCateNav();
            textCateNav.setCates(BeanMapper.mapList(categoryInSearchService.selSubCates("30", SearchCategory.CATEGORY), StyleNavVo.class));
            textCateNav.setMarkets(BeanMapper.mapList(categoryInSearchService.selSubCates("30", SearchCategory.MARKET), StyleNavVo.class));
            textCateNav.setStyles(NEW_STYLE);
        }
        return textCateNav;
    }

    public ShiguAggsPager searchGoods(QueryBo bo) {
        SearchOrderBy orderCase;
        if (bo.getSort() == null) {
            bo.setSort("comp");
        }
        if (bo.getSort().equals("xp")) {
            orderCase = SearchOrderBy.NEW;
        } else if (bo.getSort().equals("comp")) {
            orderCase = SearchOrderBy.GOODS_COMMON;
        } else if (bo.getSort().equals("price-asc")) {
            orderCase = SearchOrderBy.PRICEUP;
        } else if (bo.getSort().equals("price-desc")) {
            orderCase = SearchOrderBy.PRICEDOWN;
        } else {
            orderCase = SearchOrderBy.GOODS_COMMON;
        }
        if (bo.getPage() == null) {
            bo.setPage(1);
        }
        if (StringUtils.isEmpty(bo.getWebSite())) {
            bo.setWebSite("hz");
        }

        List<Long> cids = new ArrayList<>();
        if (bo.getCid() != null) {
            cids.add(bo.getCid());
        }

        Date from = null;
        Date to = new Date();
        if (bo.getD() != null) {
            from = DateUtil.addDay(to, -bo.getD());
        }
        return itemSearchService.searchItem(
                bo.getKeyword(),
                bo.getWebSite(),
                bo.getMid(),
                cids,
                null,
                bo.getSid(),
                bo.getSp(),
                bo.getEp(),
                from,
                to,
                orderCase,
                bo.getPage(),
                20,
                false
        );
    }
}
