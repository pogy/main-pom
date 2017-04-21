package com.shigu.search.utils;

import com.shigu.main4.vo.SearchShopSimple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 市场权重比较器
 * Created by zhaohongbo on 17/4/12.
 */
public class ShopWeightComparator implements Comparator<SearchShopSimple>{

    static List<Long> marketIds=new ArrayList<>();
    static {
        marketIds.add(621L);
        marketIds.add(617L);
        marketIds.add(1087L);
    }

    @Override
    public int compare(SearchShopSimple o1, SearchShopSimple o2) {
        if(o1==null||o2==null){
            return 0;
        }
        return (marketIds.indexOf(o2.getMarketId())-marketIds.indexOf(o1.getMarketId()))*10;
    }
}
