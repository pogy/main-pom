package com.shigu.main4.storeservices;

import com.shigu.main4.bo.OnsaleItemQueryBO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.vo.*;

import java.util.Date;
import java.util.List;

/**
 * 给显示用的店铺服务
 * Created by zhaohongbo on 17/2/16.
 */
public interface ShopForCdnService {

    /**
     * 按店ID查店内类目
     * @param shopId 店铺ID
     * @return 按顺序排列的店内类目列表
     */
    List<ShopCat> selShopCatsById(Long shopId);

    /**
     * 查店铺的星星数
     * @param shopId 店铺ID
     * @return 星星数值
     */
    Long selShopStarById(Long shopId);

    /**
     * 按店铺ID查商品总数
     * @param shopId
     * @return
     */
    Long selItemNumberById(Long shopId,String webSite);

    /**
     * 查店铺推荐宝贝,按shopId
     * @param shopId 店铺ID
     * @return 商品豆腐块信息
     */
    List<ItemShowBlock> selRecomments(Long shopId);

    /**
     * 查本店类目聚合情况
     * @param shopId 店铺ID
     * @return 类目聚合父级信息集合
     */
    List<CatPolymerization> selCatRolymerizations(Long shopId);

    /**
     * 查询店内出售中的商品
     * @param keyword 关键字
     * @param orderBy 排序
     * @param pageNo 当前页码
     * @return 商品豆腐块分页信息
     */
    ShiguPager<ItemShowBlock> searchItemOnsale(String keyword,Long shopId,String webSite,String orderBy,int pageNo,int pageSize);

    /**
     * 根据id列表分页查询
     * @param ids
     * @return
     */
    ShiguPager<ItemShowBlock> searchItemOnsale(List<Long> ids,String webSite,int pageNo,int pageSize);

    /**
     * 查询店内出售中的商品
     * @param keyword 关键字
     * @param cid 淘宝标准类目ID
     * @param scid 店内类目ID
     * @param orderBy 排序
     * @param pageNo 当前页
     * @param pageSize 每页数量
     * @return 商品豆腐块分页信息
     */
    ShiguPager<ItemShowBlock> searchItemOnsale(String keyword,Long shopId,String webSite,Long cid,String scid,String orderBy,Date startTime,Date endTime,int pageNo,int pageSize);

    /**
     * 查询店内出售中的商品
     * @param keyword 关键字
     * @param priceFrom 价格开始值
     * @param priceTo 价格结束值
     * @param orderBy 排序
     * @param pageNo 当前页
     * @param pageSize 每页数量
     * @return 商品豆腐块分页信息
     */
    ShiguPager<ItemShowBlock> searchItemOnsale(String keyword,Long shopId,String webSite,Double priceFrom,Double priceTo,String orderBy,Date startTime,Date endTime,int pageNo
            ,int pageSize);

    /**
     * 出售中的商品,shopId非空则查店内商品
     * @param onsaleItemQueryBO
     * @param webSite
     * @param paggeNo
     * @param pageSize
     * @return
     */
    ShiguPager<ItemShowBlock> searchItemOnsaleByBO(OnsaleItemQueryBO onsaleItemQueryBO, String webSite, int paggeNo, int pageSize);

    /**
     * 查询店内下架的商品
     * @param from 开始时间
     * @param to 结束时间
     * @param pageNo 当前页
     * @param pageSize 每页条数
     * @return 商品豆腐块分页信息
     */
    ShiguPager<ItemShowBlock> searchItemInstock(Date from, Date to,Long shopId,int pageNo,int pageSize);


    /**
     * 查店铺基本信息,用于店铺页
     * @param shopId
     * @return
     */
    ShopBaseForCdn selShopBase(Long shopId);

    /**
     * 店铺上新数据
     * @param shopId
     * @return
     */
    List<ItemShowBlock> shopGoodsNew(Long shopId);

    /**
     * 获取店内商品风格（风格频道）
     * @param shopId
     * @return
     */
    List<ShiguStyleShowVO> selShopStyleById(Long shopId);

}
