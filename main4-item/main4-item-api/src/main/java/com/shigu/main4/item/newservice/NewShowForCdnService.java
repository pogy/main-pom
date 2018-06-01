package com.shigu.main4.item.newservice;

import com.shigu.main4.item.vo.news.NewCdnItem;

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

}
