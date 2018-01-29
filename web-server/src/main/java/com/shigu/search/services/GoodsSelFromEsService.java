package com.shigu.search.services;

import com.opentae.data.mall.beans.ShiguTaobaocat;
import com.opentae.data.mall.examples.ShiguTaobaocatExample;
import com.opentae.data.mall.interfaces.ShiguTaobaocatMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.item.services.ItemSearchService;
import com.shigu.main4.item.vo.SearchItem;
import com.shigu.main4.monitor.services.ItemBrowerService;
import com.shigu.main4.storeservices.ShopSearchService;
import com.shigu.main4.vo.SearchShopSimple;
import com.shigu.search.bo.PageInSearchBO;
import com.shigu.search.vo.GoodsInSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 纯商品查询服务
 * Created by zhaohongbo on 17/4/5.
 */
@Service
public class GoodsSelFromEsService {
    @Autowired
    ItemSearchService itemSearchService;

    @Autowired
    CategoryInSearchService categoryInSearchService;

    @Autowired
    ShopSearchService shopSearchService;

    @Autowired
    ItemBrowerService itemBrowerService;
    /**
     * 搜索商品
     * @return
     */
    public ShiguPager<GoodsInSearch> selGoodsInSearch(String keyword,String webSite, Long cid, Long mid,Date from,Date to, PageInSearchBO page){
        //如果类目要查
        List<Long> cids=null;
        if (cid != null) {
            cids=categoryInSearchService.selCidsFromCid(cid);
        }
        ShiguPager<SearchItem> pager=itemSearchService.searchItem(keyword, webSite,mid,cids,null,null,null,null,from,to
                , SearchOrderBy.NEW,page.getPage(),page.getRows(), true);
        //加工对象
        return addShopInfoToGoods(pager,webSite);
    }

    /**
     * 转化商品,加信息
     * @param itemShiguPager
     * @return
     */
    public ShiguPager<GoodsInSearch> addShopInfoToGoods(ShiguPager<SearchItem> itemShiguPager,String website){
        List<SearchItem> items=itemShiguPager.getContent();
        Set<Long> storeIds=new HashSet<>();
        ShiguPager<GoodsInSearch> pager=new ShiguPager<>();
        pager.setTotalCount(itemShiguPager.getTotalCount());
        pager.setNumber(itemShiguPager.getNumber());
        pager.setTotalPages(itemShiguPager.getTotalPages());
        if (items != null&&items.size()>0) {
            for(SearchItem si:items){
                storeIds.add(si.getStoreId());
            }
            List<SearchShopSimple> shops=shopSearchService.selShopByIds(new ArrayList<Long>(storeIds),website);
            Map<Long,SearchShopSimple> shopMap=new HashMap<>();
            for(SearchShopSimple sss:shops){
                shopMap.put(sss.getShopId(),sss);
            }
            List<GoodsInSearch> goods=new ArrayList<>();
            for(SearchItem si:items){
                GoodsInSearch g=new GoodsInSearch();
                g.setId(si.getItemId()+"");
                g.setImgsrc(si.getPicUrl());
                g.setTitle(si.getTitle());
                g.setPiprice(si.getPrice());
                g.setGoodsNo(si.getGoodsNo());
                g.setHighLightGoodsNo(si.getHighLightGoodsNo());
                g.setHighLightTitle(si.getHighLightTitle());
                g.setPostTimeText(timeParse(si.getCreated()));
                SearchShopSimple shop=shopMap.get(si.getStoreId());
                if (shop != null) {
                    g.setAliww(shop.getImAliww());
                    g.setFullStoreName(shop.getMarket()+" "+shop.getShopNum());
                    g.setStoreNum(shop.getShopNum());
                    g.setMarketName(shop.getMarket());
                }
                g.setStoreid(si.getStoreId());
                goods.add(g);
            }
            pager.setContent(goods);
        }
        return pager;
    }

    /**
     * 添加商品流量到结果
     * @param pager
     * @return
     */
    public ShiguPager<GoodsInSearch> addItemFlowToGoods(ShiguPager<GoodsInSearch> pager){
        List<GoodsInSearch> goods=pager.getContent();
        if (goods != null) {
            List<Long> itemIds=new ArrayList<>();
            for(GoodsInSearch g:goods){
                itemIds.add(Long.valueOf(g.getId()));
            }
            if(itemIds.size()==0)
                return pager;
            Map<Long,Long> flows=itemBrowerService.selMoreItemBrower(itemIds);
            for(GoodsInSearch g:goods){
                Long flow=flows.get(Long.valueOf(g.getId()));
                g.setViewCount(flow==null?"0":flow.toString());
            }
        }
        return pager;
    }

    /**
     * 时间转化
     * @param t
     * @return
     */
    public String timeParse(Date t){
        Long time=System.currentTimeMillis();
        Long tt=t.getTime();
        long jiange=300000;//5分钟
        long cha=(time-tt)/jiange;//多少个5分钟
        if(cha==0){
            return "刚刚";
        }
        if(cha>=12){
            return cha/12+"小时前";
        }else{
            return cha*5+"分钟前";
        }
    }


}
