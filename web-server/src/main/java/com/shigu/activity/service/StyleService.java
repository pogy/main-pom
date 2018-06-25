package com.shigu.activity.service;

import com.searchtool.configs.ElasticConfiguration;
import com.shigu.activity.bo.QueryBo;
import com.shigu.activity.vo.PicCatVo;
import com.shigu.activity.vo.PicCateNav;
import com.shigu.activity.vo.StyleNavVo;
import com.shigu.activity.vo.TextCateNav;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.item.services.ItemSearchService;
import com.shigu.main4.item.vo.AggsCount;
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
        PIC_CATE_URL = new LinkedHashMap<>();
        PIC_CATE_URL.put("港风", "http://style.571xz.com/searchV5/css/img/styleGoods/gf.jpg");
        PIC_CATE_URL.put("日系", "http://style.571xz.com/searchV5/css/img/styleGoods/rx.jpg");
        PIC_CATE_URL.put("硬汉", "http://style.571xz.com/searchV5/css/img/styleGoods/yh.jpg");
        PIC_CATE_URL.put("情侣", "http://style.571xz.com/searchV5/css/img/styleGoods/lover.jpg");
        PIC_CATE_URL.put("中国风", "http://style.571xz.com/searchV5/css/img/styleGoods/chineseStyle.jpg");

        NEW_STYLE = new ArrayList<>();
        NEW_STYLE.add(new StyleNavVo("11", "欧美"));
        NEW_STYLE.add(new StyleNavVo("13", "原宿"));
        NEW_STYLE.add(new StyleNavVo("9", "港风"));
        NEW_STYLE.add(new StyleNavVo("12", "英伦"));
        NEW_STYLE.add(new StyleNavVo("10", "日系"));
        NEW_STYLE.add(new StyleNavVo("22", "中国风"));
    }

    private static PicCateNav picCateNav;

    public PicCateNav selPicCateNav(String webSite) {
        if (picCateNav == null) {
            List<PicCatVo> picCate = new ArrayList<>();

            List<CateNav> cateNavs = categoryInSearchService.selSubCates("30", SearchCategory.STYLE,webSite);
            Map<String, CateNav> navMap = BeanMapper.list2Map(cateNavs, "text", String.class);
            for (Map.Entry<String, String> entry : PIC_CATE_URL.entrySet()) {
                CateNav nav = navMap.get(entry.getKey());
                if (nav != null) {
                    PicCatVo picCatVo = new PicCatVo(nav.getId(), nav.getText());
                    picCatVo.setImgsrc(entry.getValue());
                    picCate.add(picCatVo);
                    cateNavs.remove(nav);
                }
            }
            picCateNav = new PicCateNav();
            picCateNav.setPicCates(picCate);
            picCateNav.setTextCates(BeanMapper.mapList(cateNavs, StyleNavVo.class));
        }
        for (PicCatVo picCatVo : picCateNav.getPicCates()) {
            picCatVo.setGoodscount(calStyle(picCatVo.getId(), webSite));
        }
        return picCateNav;
    }

    private int calStyle(String sid, String webSite) {
        return ((int) ElasticConfiguration.searchClient
                .prepareSearch("goods")
                .setSearchType(SearchType.COUNT)
                .setTypes(webSite)
                .setQuery(QueryBuilders.boolQuery()
                        .must(QueryBuilders.matchQuery("sids", sid))
                        .must(QueryBuilders.termQuery("is_off", 0)))
                .execute().actionGet().getHits().getTotalHits());
    }

    public TextCateNav selTextCateNav(List<AggsCount> cats, List<AggsCount> markets,String webSite) {
        TextCateNav textCateNav = new TextCateNav();
        textCateNav.setCates(clearNavs(cats, categoryInSearchService.selSubCates("30", SearchCategory.CATEGORY,webSite)));
        textCateNav.setMarkets(clearNavs(markets, categoryInSearchService.selSubCates("30", SearchCategory.MARKET,webSite)));
        textCateNav.setStyles(NEW_STYLE);
        return textCateNav;
    }

    private List<StyleNavVo> clearNavs(List<AggsCount> aggs, List<CateNav> navs) {
        List<Long> values = BeanMapper.getFieldList(aggs, "value", Long.class);
        navs = new ArrayList<>(navs);
        for (Iterator<CateNav> iterator = navs.iterator(); iterator.hasNext(); ) {
            CateNav nav = iterator.next();
            try {
                if (!values.contains(Long.valueOf(nav.getId()))) {
                    iterator.remove();
                }
            } catch (Exception ignored){}
        }
        return BeanMapper.mapList(navs, StyleNavVo.class);
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
                50,
                false
        );
    }
}
