package com.shigu.main4.item.services;


import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.item.exceptions.ItemException;
import com.shigu.main4.item.exceptions.ShopsItemException;
import com.shigu.main4.item.vo.InstockItem;
import com.shigu.main4.item.vo.ItemCount;
import com.shigu.main4.item.vo.OnsaleItem;
import com.shigu.main4.item.vo.XiufuItem;

/**
 * 店内宝贝服务
 * Created by zhaohongbo on 17/3/2.
 */
public interface ShopsItemService {
    /**
     * 查出售中的商品
     * @param keyword 宝贝名称
     * @param shopId 店铺ID
     * @param pageNo 当前页
     * @param pageSize 每页条数
     * @return
     */
    ShiguPager<OnsaleItem> selOnsaleItems(String keyword,String goodsNo,Long numIid, Long shopId, int pageNo, int pageSize) throws ItemException;

    /**
     * 给修复宝贝提供数据
     * 实际是查出淘宝过来的商品
     * @param keyword
     * @param goodsId
     * @param shopId
     * @param pageNo
     * @param pageSize
     * @return
     */
    ShiguPager<XiufuItem> selXiufuItem(String keyword,Long goodsId, Long shopId, int pageNo, int pageSize) throws ItemException;
    /**
     * 查仓库中的商品
     * @param keyword 宝贝名称
     * @param goodsNo 货号
     * @param numIid 淘宝宝贝ID
     * @param shopId 店铺ID
     * @param pageNo 当前页
     * @param pageSize 每页条数
     * @return
     */
    ShiguPager<InstockItem> selInstockItems(String keyword,String goodsNo,Long numIid,Long shopId,int pageNo,int pageSize) throws ItemException;

    /**
     * 店内商品统计
     * @param shopId
     * @return
     */
    ItemCount selItemCount(Long shopId) throws ItemException;

    /**
     * 获取商品图片下载压缩包链接
     * @param goodsId
     * @return
     */
    String itemImgzipUrl(Long goodsId);
}
