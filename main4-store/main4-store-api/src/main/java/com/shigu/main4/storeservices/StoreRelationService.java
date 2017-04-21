package com.shigu.main4.storeservices;

import com.shigu.main4.exceptions.StoreException;
import com.shigu.main4.vo.StoreRelation;

/**
 * 店铺联系方式服务
 * Created by zhaohongbo on 17/2/8.
 */
public interface StoreRelationService {
    /**
     * 按店铺ID查店铺的联系方式
     * @param storeId 店铺ID
     * @return
     */
    StoreRelation selRelationById(Long storeId);

    /**
     * 指定分站及店铺ID查联系方式
     * @param storeId 店铺ID
     * @param webSite 分站标识
     * @return
     */
    StoreRelation selRelationById(Long storeId,String webSite);
    /**
     * 修改店铺联系信息
     * 其中storeId不能为空
     * 如果更新失败,扔出异常
     * @param relation 联系方式
     * @throws StoreException
     */
    void updateRelation(StoreRelation relation) throws StoreException;
    /**
     * 批定分站修改店铺联系信息
     * 其中storeId不能为空
     * 如果更新失败,扔出异常
     * @param relation 联系方式
     * @param webSite 分站
     * @throws StoreException
     */
    void updateRelation(StoreRelation relation,String webSite) throws StoreException;

}
