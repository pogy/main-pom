package com.shigu.seller.services;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.seller.bo.FindGoodsSelBO;
import com.shigu.seller.vo.FindGoodsItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaohongbo on 17/5/27.
 */
@Service
public class FindGoodsService {

    @Autowired
    ShopForCdnService shopForCdnService;

    public ShiguPager<FindGoodsItemVO> selItemsForFindGoods(FindGoodsSelBO bo,Long shopId,Integer size){
        ShiguPager<ItemShowBlock> pager=shopForCdnService.searchItemOnsale(bo.getQ(),shopId
                ,bo.getStartPrice(),bo.getEndPrice(),"time_down",null,null,bo.getPage(),size);
        List<FindGoodsItemVO> items=new ArrayList<>();
        for(ItemShowBlock isb:pager.getContent()){
            items.add(new FindGoodsItemVO(isb));
        }
        ShiguPager<FindGoodsItemVO> resultpager=new ShiguPager<>();
        resultpager.setContent(items);
        resultpager.setTotalCount(pager.getTotalCount());
        resultpager.setNumber(pager.getNumber());
        resultpager.setTotalPages(pager.getTotalPages());
        return resultpager;
    }
}
