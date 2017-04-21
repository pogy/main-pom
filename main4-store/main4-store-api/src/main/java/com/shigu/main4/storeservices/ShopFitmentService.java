package com.shigu.main4.storeservices;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.enums.FitmentModuleType;
import com.shigu.main4.exceptions.ShopFitmentException;
import com.shigu.main4.vo.*;
import com.shigu.main4.vo.fitment.ItemPromoteModule;

import java.util.List;

/**
 * 店铺装修类服务
 * Created by zhaohongbo on 17/2/16.
 */
public interface ShopFitmentService {
    /**
     * 查询店内装修情况
     * @param shopId
     * @return
     */
    ShopFitmentForUpadte selFitmentForUpadte(Long shopId);

    /**
     * 更新店内装修
     * @param shopId 店铺ID
     * @param fitmentForUpadte 更新的数据
     */
    void updateFitment(Long shopId,ShopFitmentForUpadte fitmentForUpadte) throws ShopFitmentException;

    /**
     * 初始化店铺装修
     * @param shopId
     */
    void initShopFitment(Long shopId) throws ShopFitmentException;

    /**
     * 创建页面
     * @param pageName
     * @param pageType 版式
     * @return
     */
    Long createPage(Long shopId, String pageName, Long code, Integer pageType) throws ShopFitmentException;

    /**
     * 删除一个页面
     * @param pageId
     */
    void rmPage(Long pageId) throws ShopFitmentException;

    /**
     * 查页面的属主店铺ID
     * @param pageId
     * @return
     */
    Long selShopIdByPageId(Long pageId);



    /**
     * 添加区域
     * @param pageId 页面ID
     * @param sideId 邻模块ID
     * @param after 1代表上方，2代表下方
     * @return
     */
    Long addArea(Long pageId,Long sideId,Integer type, Integer after) throws ShopFitmentException;

    /**
     * 查区域的属主店铺ID
     * @param areaId
     * @return
     */
    Long selShopIdByAreaId(Long areaId);
    /**
     * 删除一个区域
     * @param areaId
     */
    void rmArea(Long areaId);

    /**
     * 添加模块
     * @param areaId 区域ID
     * @param sideId 相邻的模块
     * @param sideType 位置类型，1左侧，2右侧，3全屏
     * @param type 模块类型 {@link com.shigu.main4.enums.FitmentModuleType}
     * @param after 1上方插入、2下方插入
     * @return
     */
    Long addModule(Long areaId,Long sideId,Integer type,Integer sideType,Integer after) throws ShopFitmentException;

    /**
     * 删除一个模块
     * @param moduleId
     */
    void rmModule(Long moduleId);

    /**
     * 查模块的属主店铺ID
     * @param moduleId
     * @return
     */
    Long selShopIdByModuleId(Long moduleId);
    /**
     * 移动
     * @param moduleId
     * @param after 1代表上移，2代表下移
     */
    void changeModuleLocation(Long moduleId,Integer after);

    /**
     * 重建模块数据
     * @param module
     */
    <T extends FitmentModule> void revalueModule(Long moduleId,T module) throws ShopFitmentException;

    /**
     * 更新模块特殊设置
     * @param moduleId 模块id
     * @param Option 特殊设置
     * @throws ShopFitmentException
     */
    void revalueModuleOption(Long moduleId, String Option) throws ShopFitmentException;

    /**
     * 按区域ID取得区域数据
     * @param areaId
     * @return
     */
    FitmentArea selAreaByAreaId(Long areaId);

    /**
     * 按模块ID获得一个模块
     * @param moduleId
     * @return
     */
    <T extends FitmentModule> T selModuleByModuleId(Long moduleId);

    /**
     * 查店铺顶
     * @param shopId
     * @return
     */
    FitmentArea selShopHead(Long shopId);

    /**
     * 查装修页面
     * @param pageId
     * @return
     */
    FitmentPage selPage(Long pageId);

    /**
     * 按areaID查区域
     * @param pageId
     * @return
     */
    List<FitmentArea> selAreaByPageId(Long pageId);

    /**
     * 按区域ID获取所有模块
     * @param areaId
     * @return
     */
    <T extends FitmentModule> List<T> selModuleByAreaId(Long areaId);

    /**
     * 查询推荐位的商品
     * @param promoteModule
     * @return
     */
    ShiguPager<ItemShowBlock> selItemByPromote(ItemPromoteModule promoteModule);

    /**
     * 取首页pageId
     * @param shopId
     * @return
     */
    Long selIndexPageIdByShopId(Long shopId) throws ShopFitmentException;


}
