package com.shigu.main4.item.newservice;

import com.shigu.main4.item.vo.news.NewCdnItem;
import com.shigu.main4.item.vo.news.SingleSkuVO;

import java.util.List;

/**
 * 分站点显示用服务
 * Created by zhaohongbo on 17/2/16.
 */
public interface NewShowForCdnService {
    /**
     * 按商品ID查商品
     * @param id
     * @return
     */
    NewCdnItem selItemById(Long id);

    /**
     * 按商品ID和分站标识查商品
     * @param id
     * @param webSite
     * @return
     */
    NewCdnItem selItemById(Long id, String webSite);

    /**
     * 获取独立SKU
     * @param id
     * @return
     */
    List<SingleSkuVO> selSingleSkus(Long id);
    /**
     * 查询仓库中的商品信息,按商品ID
     * @param id 商品ID
     * @return 商品信息
     */
    NewCdnItem selItemInstockById(Long id);

    /**
     * 查询仓库中的商品信息,按商品ID,webSite
     * @param id 商品ID
     * @param webSite 分站标识
     * @return 商品信息
     */
    NewCdnItem selItemInstockById(Long id, String webSite);

    /**
     * 修改sku的库存数和价格
     * @param skus sku集合
     * @return 商品信息
     */
    Integer updateSkuPriceStock(List<SingleSkuVO> skus,String webSite);
}
