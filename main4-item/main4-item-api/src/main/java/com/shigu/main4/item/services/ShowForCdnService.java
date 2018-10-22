package com.shigu.main4.item.services;

import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.item.vo.news.SingleSkuVO;

import java.util.List;

/**
 * 分站点显示用服务
 * Created by zhaohongbo on 17/2/16.
 */
public interface ShowForCdnService {
    /**
     * 按商品ID查商品
     * @param id
     * @return
     */
    CdnItem selItemById(Long id);

    /**
     * 按商品ID和分站标识查商品
     * @param id
     * @param webSite
     * @return
     */
    CdnItem selItemById(Long id,String webSite);

    /**
     * 查询仓库中的商品信息,按商品ID
     * @param id 商品ID
     * @return 商品信息
     */
    CdnItem selItemInstockById(Long id);

    /**
     * 查询仓库中的商品信息,按商品ID,webSite
     * @param id 商品ID
     * @param webSite 分站标识
     * @return 商品信息
     */
    CdnItem selItemInstockById(Long id,String webSite);

    /**
     * 商品权益
     * @param id 商品ID
     * @return 权益的value
     */
    List<String> selItemLicenses(Long id);

    /**
     * 商品权益
     * @param id 商品ID
     * @param shopId 店铺ID
     * @return 权益的value
     */
    List<String> selItemLicenses(Long id,Long shopId);

    /**
     * 修改sku的库存数和价格
     * @param skus sku集合
     * @return 商品信息
     */
    Integer updateSkuPriceStock(List<SingleSkuVO> skus,String webSite);
}
