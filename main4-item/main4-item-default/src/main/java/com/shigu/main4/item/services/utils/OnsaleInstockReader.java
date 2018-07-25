package com.shigu.main4.item.services.utils;

import com.opentae.core.mybatis.SgExample;
import com.shigu.main4.item.exceptions.ItemException;

import java.util.List;

/**
 * Created by zhaohongbo on 17/3/9.
 */
public abstract class OnsaleInstockReader<T> {
    private Long shopId;
    private String webSite;
    protected OnsaleInstockReader(Long shopId) throws ItemException {
        this.shopId = shopId;
        this.webSite = selWebSite(shopId);
    }
    protected abstract SgExample makeExample(String webSite, int pageNo, int PageSize);
    protected abstract int countByExample(SgExample example);
    protected abstract List<T> selectByExample(SgExample example);
    public Long getShopId() {
        return shopId;
    }
    public String getWebSite() {
        return webSite;
    }

    /**
     * 根据店铺ID查询分站
     * @param shopId 店铺ID
     * @return 分站
     * @throws ItemException 店铺不存在
     */
    protected abstract String selWebSite(Long shopId) throws ItemException ;
}
