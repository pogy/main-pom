package com.shigu.search.services;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.storeservices.ShopSearchService;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.main4.vo.SearchShop;
import com.shigu.main4.vo.SearchShopSimple;
import com.shigu.search.bo.StorenumBO;
import com.shigu.search.utils.ShopWeightComparator;
import com.shigu.search.vo.GoodsInStoreSearch;
import com.shigu.search.vo.StoreInSearch;
import com.shigu.search.vo.TopShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 档口搜索
 * Created by zhaohongbo on 17/4/5.
 */
@Service
public class StoreSelFromEsService {
//    private String market="1087:电商基地,613:精品男装,621:四季星座,601:星座女装,617:钱塘大厦,1462:好四季,642:意法服饰,655:置地国际,1105:九星服饰,608:之江服饰,661:九天国际,670:新杭派,666:四季青,668:中纺服饰,652:中星外贸,674:周边市场";
//    private List<MarketNav> markets;

    @Autowired
    ShopSearchService shopSearchService;

    @Autowired
    ShopForCdnService shopForCdnService;


//    public void init(){
//        if (markets != null) {
//            markets=new ArrayList<>();
//            String[] marketArr=market.split(",");
//            for(String m:marketArr){
//                String[] marr=m.split(":");
//                markets.add(new MarketNav(marr[0],marr[1]));
//            }
//        }
//    }

    /**
     * 按档口号查询
     * @param shopNum
     */
    public List<TopShop> selByShopNum(String shopNum, String website){
        if(shopNum==null||"".equals(shopNum)){
            return null;
        }
        List<SearchShopSimple> simples=shopSearchService.selShopByShopNum(shopNum,website);
        List<TopShop> topShops=new ArrayList<>();
        if(simples!=null&&simples.size()>0){
            Collections.sort(simples,new ShopWeightComparator());
            SearchShopSimple s=simples.get(0);
            TopShop t=new TopShop();
            t.setMainCate(s.getMainBus());
            t.setMarketName(s.getMarket());
            t.setStoreId(s.getShopId());
            t.setOtherStoreUrl("/storenum.htm?keyword="+shopNum);
            t.setStoreNum(s.getShopNum());
            t.setGoodsCount(shopForCdnService.selItemNumberById(s.getShopId(),website).intValue());
            topShops.add(t);
        }
        return topShops;
    }

    /**
     * 搜档口
     * @return
     */
    public ShiguPager<StoreInSearch> searchStore(StorenumBO bo){
        ShiguPager<SearchShop> shopPager=shopSearchService.searchShop(bo.getKeyword(),bo.getWebSite(),bo.getMid(),bo.getPage(),bo.getRows());
        ShiguPager<StoreInSearch> pager=new ShiguPager<>();
        pager.setTotalPages(shopPager.getTotalPages());
        pager.setNumber(shopPager.getNumber());
        pager.setTotalCount(shopPager.getTotalCount());
        List<SearchShop> shops=shopPager.getContent();
        List<StoreInSearch> storeInSearches=new ArrayList<>();
        if (shops != null) {
            for(SearchShop s:shops){
                StoreInSearch sis=new StoreInSearch();
                sis.setAliww(s.getImAliww());
                sis.setFullMarketText(s.getAddress());
                sis.setId(s.getShopId().toString());
//                sis.setImgsrc("");
                sis.setName(s.getShopNum());
                sis.setImqq(s.getImQq());
                sis.setMainCate(s.getMainCase());
                sis.setMarketName(s.getMarket());
                sis.setTel(s.getTelephone());
                sis.setHighMarketName(s.getHighLightMarket());
                sis.setHighName(s.getHighLightShopNum());
                sis.setXy(shopForCdnService.selShopStarById(s.getShopId()));
                ShiguPager<ItemShowBlock> itemPager=shopForCdnService.searchItemOnsale(null,s.getShopId(),bo.getWebSite(),"common",1,4);
                sis.setGoodsCount(itemPager.getTotalCount());
                List<ItemShowBlock> simples=itemPager.getContent();
                List<GoodsInStoreSearch> goods=new ArrayList<>();
                if (simples != null) {
                    for(ItemShowBlock isb:simples){
                        GoodsInStoreSearch gis=new GoodsInStoreSearch();
                        gis.setId(isb.getItemId().toString());
                        gis.setImgsrc(isb.getImgUrl());
                        gis.setPiprice(isb.getPrice());
                        goods.add(gis);
                    }
                }
                sis.setGoodslist(goods);
                storeInSearches.add(sis);
            }
        }
        pager.setContent(storeInSearches);
        return pager;
    }


}
