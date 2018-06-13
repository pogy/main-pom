package com.shigu.main4.storeservices;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.vo.GoodsVo;
import com.shigu.main4.vo.TabDatasVo;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.storeservices
 * @ClassName: ShopCategoryClassifyService
 * @Author: sy
 * @CreateDate: 2018/5/31 0031 13:07
 */
public interface ShopCategoryClassifyService {

    /**
     * 获取店铺自定义分类页面选项卡数据
     * @param shopId
     * @return
     */
    TabDatasVo getShopTabDatas(Long shopId,String webSite);

    /**
     * 获取店铺自定义分类页面商品数据
     * @param shopId
     * @param cnameId
     * @return
     */
    ShiguPager<GoodsVo> getShopShowGoods(Long shopId,Long cnameId,Integer page,Integer size,String webSite);

    /**
     * 添加店铺自定义类目
     * @param cname
     * @param shopId
     * @return
     */
    Integer addCustomCategory(String cname,Long shopId);

    /**
     * 设置商品所属类目
     * @param ids
     * @param cnameId
     * @return
     */
    Integer setCategoryForGoods(String ids,Long cnameId,Integer zt,Long shopId,String webSite);

    /**
     * 删除店铺自定义分类
     * @param cateId
     * @return
     */
    Integer deleCate(Long cateId);
}
