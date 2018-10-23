package com.shigu.main4.storeservices;

import com.shigu.main4.common.vo.ShiguTags;
import com.shigu.main4.enums.ShopLicenseTypeEnum;
import com.shigu.main4.vo.LinceseVo;
import com.shigu.main4.vo.ShopLicense;

import java.util.List;

/**
 * 店铺权益服务
 * Created by zhaohongbo on 17/3/13.
 */
public interface ShopLicenseService {
    /**
     * 按主键查询店铺标签服务
     * 如果没有记录,返回空集
     * @param shopId
     * @return
     */
    List<ShiguTags> selTagLicenseByShopId(Long shopId);

    /**
     * 标签
     * 如果原记录不存在,需要创建
     * @param shopId
     * @param tags
     */
    void updateShopTagLicense(Long shopId,List<ShiguTags> tags);

    /**
     * 店铺权益
     * 只查有用的
     * @param shopId 店铺ID
     * @return 权益列表
     */
    List<ShopLicense> selShopLicenses(Long shopId);

    /**
     *
     * @param shopId
     * @param type
     * @return
     */
    ShopLicense selShopLIcenseByType(Long shopId, ShopLicenseTypeEnum type);

    /**
     * 据shopid type 改店铺权益
     * @param shopId
     * @param
     */
    Integer updateShopLIcenseByType(Long shopId,Integer type, Integer licenseFailure, String content);

    List<LinceseVo> selShopLIcenseByIds(List<Long> shopIds);
}
