package com.shigu.main4.cdn.services;

import com.opentae.data.mall.beans.ShiguStyle;
import com.opentae.data.mall.examples.ShiguGoodsIdGeneratorExample;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.opentae.data.mall.interfaces.ShiguStyleMapper;
import com.shigu.main4.cdn.vo.*;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.service.GoatDubboService;
import com.shigu.main4.goat.vo.TextGoatVO;
import com.shigu.main4.item.bo.GoodsSearchBO;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.item.services.ItemSearchService;
import com.shigu.main4.item.vo.ShiguAggsPager;
import com.shigu.search.services.CategoryInSearchService;
import com.shigu.search.services.GoodsSelFromEsService;
import com.shigu.search.utils.TimeParseUtil;
import com.shigu.search.vo.CateNav;
import com.shigu.search.vo.GoodsInSearch;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.spread.services.ObjFromCache;
import com.shigu.spread.services.RedisForIndexPage;
import com.shigu.spread.services.SpreadService;
import com.shigu.spread.vo.ItemSpreadVO;
import com.shigu.spread.vo.NewHzManIndexItemGoatVO;
import com.shigu.tools.KeyWordsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 首页数据支持
 * Created by Licca on 17/4/9.
 */
@Service
public class IndexShowService {

    private static final Logger logger = LoggerFactory.getLogger(IndexShowService.class);

    @Autowired
    private ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    @Autowired
    GoatDubboService goatDubboService;
    /**
     * 类目服务
     */
    @Autowired
    CategoryInSearchService categoryInSearchService;

    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    RedisForIndexPage redisForIndexPage;

    @Autowired
    SpreadService spreadService;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    ItemSearchService itemSearchService;

    @Autowired
    GoodsSelFromEsService goodsSelFromEsService;

    @Autowired
    private ShiguStyleMapper shiguStyleMapper;

    private final String HZ_MAN_INDEX_STYLE_CHANNEL_INDEX = "hz_man_index_style_channel_index";

    /**
     * 把商品总数数字按个排出
     *
     * @return
     */
    public ObjFromCache<List<Integer>> selNumList() {
        return new ObjFromCache<List<Integer>>(redisForIndexPage, "selNumList", Integer.class) {
            @Override
            public List<Integer> selReal() {
                int count = shiguGoodsIdGeneratorMapper.countByExample(new ShiguGoodsIdGeneratorExample());
                List<Integer> list = new ArrayList<>();
                while (count > 0) {
                    if (count / 10 > 0) {
                        list.add(count % 10);
                    } else {
                        list.add(count);
                    }
                    count = count / 10;
                }
                //反转
                Collections.reverse(list);
                return list;
            }
        };
    }

    /**
     * 取得会签
     *
     * @param parentValue
     * @param category
     * @return
     */
    public List<IndexNavVO> selStyleOrElementNav(String parentValue, SearchCategory category, String webSite) {
        List<CateNav> navs = categoryInSearchService.selSubCates(parentValue, category, webSite);
        List<IndexNavVO> vos = new ArrayList<>();
        if (navs != null) {
            for (CateNav cn : navs) {
                vos.add(new IndexNavVO(cn.getText(), Long.valueOf(parentValue)));
            }
        }
        return vos;
    }

    /**
     * 查首页标签类广告
     *
     * @param spread
     * @return
     */
    public ObjFromCache<List<IndexNavVO>> selNavVOs(final SpreadEnum spread) {
        return new ObjFromCache<List<IndexNavVO>>(redisForIndexPage, spread.getCode(), IndexNavVO.class) {
            @Override
            public List<IndexNavVO> selReal() {
                List<IndexNavVO> navVOs = new ArrayList<>();
                try {
                    List<TextGoatVO> goats = goatDubboService.selGoatsFromLocalCode(spread.getCode());
                    for (TextGoatVO tgv : goats) {
                        navVOs.add(new IndexNavVO(tgv.getHref(), KeyWordsUtil.duleKeyWords(tgv.getText())));
                    }
                } catch (GoatException e) {
                    logger.error("查询标签类广告,miss", e);
                }
                return navVOs;
            }
        };

    }


    /**
     * 猜你喜欢
     *
     * @return
     */
    public ObjFromCache<LoveGoodsList> loveGoods(final int number, final String text, final String webSite, final List<Long> cids) {
        return new ObjFromCache<LoveGoodsList>(redisForIndexPage, webSite + "_" + text, LoveGoodsList.class) {
            @Override
            public LoveGoodsList selReal() {
                ShiguAggsPager pager = itemSearchService.searchItem(null, webSite, null, cids, null, null, null, null,
                        null, null, SearchOrderBy.USER_LOVE, 1, number, false);
                ShiguPager<GoodsInSearch> goodsInSearch = goodsSelFromEsService.addShopInfoToGoods(pager, webSite);
                List<GoodsInSearch> items = goodsInSearch.getContent();
                LoveGoodsList loveGoodsList = new LoveGoodsList();
                loveGoodsList.setTypeText(text);
                List<ItemSpreadVO> spreadVOs = new ArrayList<>();
                loveGoodsList.setItems(spreadVOs);
                if (items != null) {
                    items.forEach(it -> {
                        ItemSpreadVO itemSpreadVO = new ItemSpreadVO();
                        itemSpreadVO.setId(it.getId());
                        itemSpreadVO.setImgsrc(it.getImgsrc());
                        itemSpreadVO.setMarketText(it.getFullStoreName());
                        itemSpreadVO.setPiprice(it.getPiprice());
                        itemSpreadVO.setStoreId(it.getStoreid().toString());
                        itemSpreadVO.setStoreNum(it.getStoreNum());
                        spreadVOs.add(itemSpreadVO);
                    });
                }
                return loveGoodsList;
            }
        };
    }

    /**
     * 女上装
     *
     * @return cid的list
     */
    public List<Long> womanUp() {
        //上装
        List<Long> cids = new ArrayList<>();
        cids.add(50011277L);
        cids.add(162116L);
        cids.add(50000697L);
        cids.add(50008904L);
        cids.add(50008905L);
        cids.add(50008898L);
        cids.add(50008899L);
        cids.add(50000671L);
        cids.add(50008901L);
        cids.add(162103L);
        cids.add(162104L);
        cids.add(50013196L);
        return cids;
    }

    /**
     * 女下装
     *
     * @return
     */
    public List<Long> womanBottom() {
        List<Long> cids = new ArrayList<>();
        cids.add(162205L);
        cids.add(1623L);
        return cids;
    }

    /**
     * 男夹克
     *
     * @return
     */
    public List<Long> manJack() {
        List<Long> cids = new ArrayList<>();
        cids.add(50010158L);
        return cids;
    }

    /**
     * 棉衣
     *
     * @return
     */
    public List<Long> manMianyi() {
        List<Long> cids = new ArrayList<>();
        cids.add(50011165L);
        return cids;
    }

    /**
     * 男休闲
     *
     * @return
     */
    public List<Long> manFree() {
        List<Long> cids = new ArrayList<>();
        cids.add(3035L);
        return cids;
    }

    /**
     * 看鞋的类目
     *
     * @return
     */
    public List<Long> xie() {
        List<Long> cids = new ArrayList<>();
        cids.add(50011746L);
        cids.add(50011744L);
        cids.add(50011745L);
        cids.add(50012906L);
        cids.add(50012907L);
        cids.add(50011743L);
        cids.add(50012047L);
        cids.add(50012042L);
        cids.add(50012027L);
        cids.add(50012028L);
        cids.add(50012033L);
        cids.add(50012825L);
        cids.add(50012032L);
        return cids;
    }


    /**
     * 商户个数
     *
     * @param webSite
     * @return
     */
    public int getShopAllCount(String webSite) {
        int shopcount = shiguShopMapper.selectShopCountByBo(null, null, null, null,
                null, null, null, null, null);
        return shopcount;
    }


    /**
     * 杭州男装首页风格频道数据
     *
     * @return
     */
    public ObjFromCache<List<StyleChannelVO>> selStyleChannelInfo() {
        return new ObjFromCache<List<StyleChannelVO>>(redisForIndexPage, HZ_MAN_INDEX_STYLE_CHANNEL_INDEX, StyleChannelVO.class) {
            @Override
            public List<StyleChannelVO> selReal() {
                ShiguStyle shiguStyle = new ShiguStyle();
                shiguStyle.setIsParent(1);
                List<ShiguStyle> parentStyles = shiguStyleMapper.select(shiguStyle);
                List<StyleChannelVO> list = new ArrayList<>(parentStyles.size());
                for (ShiguStyle parentStyle : parentStyles) {
                    StyleChannelVO vo = new StyleChannelVO();
                    vo.setSpid(parentStyle.getId());
                    vo.setSname(parentStyle.getStyleName());
                    vo.setImgsrc(parentStyle.getChannelImgUrl());
                    vo.setDesc(parentStyle.getDescription());
                    list.add(vo);
                }
                return list;
            }
        };
    }


    private List<StyleCateNavVO> styleCateNavVOStatic = null;

    /**
     * 风格频道导航栏
     *
     * @return
     */
    public List<StyleCateNavVO> selStyleChannelCateNavVO() {
        if (styleCateNavVOStatic == null) {
            styleCateNavVOStatic = new ArrayList<>();
            StyleCateNavVO manCoat = new StyleCateNavVO("manCoat", "男装上衣");
            manCoat.add(new SubStyleCateNavVO("T恤", 30L, 50000436L, null))
                    .add(new SubStyleCateNavVO("针织衫/毛衣", 30L, 50000557L, null))
                    .add(new SubStyleCateNavVO("民族服装", 30L, 50001748L, null))
                    .add(new SubStyleCateNavVO("工装制服", 30L, 50005867L, null))
                    .add(new SubStyleCateNavVO("夹克", 30L, 50010158L, null))
                    .add(new SubStyleCateNavVO("卫衣", 30L, 50010159L, null))
                    .add(new SubStyleCateNavVO("西服", 30L, 50010160L, null))
                    .add(new SubStyleCateNavVO("polo衫", 30L, 50010402L, null))
                    .add(new SubStyleCateNavVO("衬衫", 30L, 50011123L, null))
                    .add(new SubStyleCateNavVO("西服套装", 30L, 50011130L, null))
                    .add(new SubStyleCateNavVO("背心/马甲", 30L, 50011153L, null))
                    .add(new SubStyleCateNavVO("风衣", 30L, 50011159L, null))
                    .add(new SubStyleCateNavVO("皮衣", 30L, 50011161L, null))
                    .add(new SubStyleCateNavVO("棉衣", 30L, 50011165L, null))
                    .add(new SubStyleCateNavVO("羽绒服", 30L, 50011167L, null))
                    .add(new SubStyleCateNavVO("毛呢大衣", 30L, 50025883L, null));
            styleCateNavVOStatic.add(manCoat);

            StyleCateNavVO manPants = new StyleCateNavVO("manPants", "男装裤子");
            manPants.add(new SubStyleCateNavVO("休闲裤", 30L, 3035L, null))
                    .add(new SubStyleCateNavVO("牛仔裤", 30L, 50010167L, null))
                    .add(new SubStyleCateNavVO("皮裤", 30L, 50011127L, null))
                    .add(new SubStyleCateNavVO("西裤", 30L, 50011129L, null))
                    .add(new SubStyleCateNavVO("羽绒裤", 30L, 50025884L, null))
                    .add(new SubStyleCateNavVO("棉裤", 30L, 50025885L, null))
                    .add(new SubStyleCateNavVO("其他套装", 124730001L, 124688002L, null))
                    .add(new SubStyleCateNavVO("套装", 30L, 124730001L, null))
                    .add(new SubStyleCateNavVO("休闲运动套装", 124730001L, 124732001L, null));

            styleCateNavVOStatic.add(manPants);
        }
        return styleCateNavVOStatic;
    }


    public List<NewHzManIndexItemGoatVO> realTimeItems(List<Long> cids,String webSite){
        GoodsSearchBO bo=new GoodsSearchBO();
        bo.setCids(cids);
        bo.setPage(1);
        bo.setPageSize(10);
        bo.setOrderCase(SearchOrderBy.NEW);
        bo.setWebSite(webSite);
        ShiguAggsPager shiguAggsPager = itemSearchService.searchItem(bo);
        Long time=System.currentTimeMillis();
        return shiguAggsPager.getContent().stream().map(searchItem -> {
            NewHzManIndexItemGoatVO vo = new NewHzManIndexItemGoatVO();
            vo.setId(searchItem.getItemId().toString());
            vo.setPiprice(searchItem.getPrice());
            vo.setImgSrc(searchItem.getPicUrl());
            vo.setShopId(searchItem.getStoreId().toString());
            vo.setTime(TimeParseUtil.timeParse(searchItem.getCreated()));
            return vo;
        }).collect(Collectors.toList());
    }

}
