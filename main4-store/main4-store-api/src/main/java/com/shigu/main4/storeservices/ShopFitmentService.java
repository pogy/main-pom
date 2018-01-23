package com.shigu.main4.storeservices;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.enums.FitmentModuleType;
import com.shigu.main4.exceptions.ShopFitmentException;
import com.shigu.main4.vo.*;
import com.shigu.main4.vo.fitment.ItemPromoteModule;
import com.shigu.main4.vo.fitment.ShopBanner;

import java.util.List;

/**
 * 店铺装修类服务
 * Created by zhaohongbo on 17/2/16.
 */
public interface ShopFitmentService {

    /**
     * 初始化店铺装修
     * @param shopId
     */
    void initShopFitment(Long shopId) throws ShopFitmentException;

    int updatePageBackground(Long shopId,Long pageId,Integer type,String picUrl);

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
     * @param shopId
     * @return
     */
    ShiguPager<ItemShowBlock> selItemByPromote(Long shopId,String webSite,ItemPromoteModule promoteModule);

    /**
     * 取首页pageId
     * @param shopId
     * @return
     */
    Long selIndexPageIdByShopId(Long shopId) throws ShopFitmentException;

    /**
     * 取搜索页面pageId
     * @param shopId
     * @return
     */
    Long selSearchPageIdByShopId(Long shopId) throws ShopFitmentException;

    /**
     * 尝试删除区域
     * 1、如果区域内有模块,不删除
     * 2、如果区域是顶级区域,after_area_id=0 页面中再没有其它区域,不删除
     * @param areaId
     */
    void tryRmArea(Long areaId);

    /**
     * 初始化发布
     * @param shopId
     */
    void initPublish(Long shopId) throws ShopFitmentException;

    /**
     * 发布banner
     * @param shopId
     */
    void publishBanner(Long shopId);

    /**
     * 查询已发布的banner
     * @param shopId
     * @return
     */
    FitmentArea bannerOnpub(Long shopId);
    /**
     * 发布页面
     * @param pageId
     */
    void publishPage(Long pageId,Long shopId);

    /**
     * 查询已发布的页面设置
     * @param pageId
     * @return
     */
    FitmentPage selPageOnpub(Long pageId) throws ShopFitmentException;
}
