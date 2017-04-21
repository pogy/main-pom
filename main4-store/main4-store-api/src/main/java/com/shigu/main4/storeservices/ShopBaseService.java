package com.shigu.main4.storeservices;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.exceptions.ShopDomainException;
import com.shigu.main4.vo.DmlReason;
import com.shigu.main4.vo.ShopBase;

import java.util.Date;

/**
 * 店铺基本操作
 * Created by zhaohongbo on 17/2/25.
 */
public interface ShopBaseService {
    /**
     * 更新店铺二级域名
     * @param shopId
     * @param domain
     * @return
     */
    void updateDomain(Long shopId,String domain) throws ShopDomainException;

    /**
     * 查询店铺二级域名
     * @param shopId
     * @return
     */
    String selDomain(Long shopId);

    /**
     * 按二级域名查店铺ID
     * @param domain
     * @return
     */
    Long selShopIdByDomain(String domain);

    /**
     * 关店
     * @param shopId
     * @param reason
     */
    void closeShop(Long shopId, DmlReason reason);

    /**
     * 开店
     * @param shopId
     * @param reason
     */
    void openShop(Long shopId,DmlReason reason) throws Main4Exception;

    /**
     * 修改店铺基本信息
     * @param shopId
     * @param shopBase
     */
    void modifyShopBase(Long shopId,ShopBase shopBase);

    /**
     * 提供给更新用的店铺信息
     * @param shopId
     * @return
     */
    ShopBase shopBaseForUpdate(Long shopId);

    /**
     * 档口迁移
     * @param shopId 档口ID,必填
     * @param toMarketId 目标市场ID,必填
     * @param toFloorId 目标楼层ID,必填
     * @param shopNum 目标档口号,可为空
     */
    void moveMarket(Long shopId,Long toMarketId,Long toFloorId,String shopNum) throws Main4Exception;

    /**
     * 查询店铺授权情况
     * @param shopId 店铺ID
     * @return 授权同步信息,0代表没有授权,1代表已授权,2代表授权过期
     */
    int shopAuthState(Long shopId);

    /**
     * 店铺状态
     * @param shopId
     * @return
     */
    int getShopStatus(Long shopId);

    /**
     * 授权时间判断
     * @param refreshTime
     * @param expiredIn
     * @return
     */
    int panssShopAuthState(Date refreshTime, Long expiredIn);

    /**
     * 更换淘宝链接
     * @param shopId 店铺ID
     * @param tbNick 淘宝nick
     * @throws Main4Exception
     */
    void changeTbLink(Long userId,Long shopId, String tbNick, Long tbShopId) throws Main4Exception;

    /**
     * 添加数据到Es
     * @param shopId
     */
    void addToEs(Long shopId);
}
