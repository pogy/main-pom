package com.shigu.main4.item.services;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.item.exceptions.ItemException;
import com.shigu.main4.item.exceptions.ShowCaseException;
import com.shigu.main4.item.vo.ShowCaseItem;

import java.util.List;

/**
 * 商品推荐
 * Created by zhaohongbo on 17/3/9.
 */
public interface ItemShowCaseService {
    /**
     * 用户更新推荐
     * @param shopId 店铺ID   session中拿
     * @param webSite 分站标识
     * @param itemIds 商品ID串   前台传
     * @param showCase 1表示推荐,0表示不推荐
     */
    void modifyShowcase(Long shopId,String webSite, List<Long> itemIds, Integer showCase) throws ShowCaseException;

    /**
     * 查showCase列表
     * @param keyword
     * @param goodsNo
     * @param numIid
     * @param shopId
     * @param pageNo
     * @param pageSize
     * @return
     * @throws ItemException
     */
    ShiguPager<ShowCaseItem> selShowCases(String keyword,String goodsNo,Long numIid, Long shopId, int pageNo,
                                          int pageSize) throws ItemException;
}
