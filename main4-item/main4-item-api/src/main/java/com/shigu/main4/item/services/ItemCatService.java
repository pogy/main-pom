package com.shigu.main4.item.services;

import com.shigu.main4.item.exceptions.ItemException;
import com.shigu.main4.item.vo.EverUsedCat;
import com.shigu.main4.item.vo.EverUsedCatForAdd;
import com.shigu.main4.item.vo.ItemGoatCidAndWebsiteVO;
import com.shigu.main4.item.vo.TbCat;

import java.util.List;

/**
 * 宝贝类目服务
 * Created by zhaohongbo on 17/3/15.
 */
public interface ItemCatService {
    /**
     * 曾经使用过的一些类目
     * @param shopId
     * @param size
     * @return
     */
    List<EverUsedCat> everUsedCats(Long shopId,Integer size);

    /**
     * 保存使用类目的记录
     * 如果存在,跳过不处理
     * @param cat
     */
    void saveEverUsedCat(Long shopId,EverUsedCatForAdd cat);
    /**
     * 子类目
     * @param cid
     * @return
     */
    List<TbCat> subCats(Long cid);

    /**
     * 父类目id(parent_id)
     * @param cid
     * @return
     */
    Long parentCats(Long cid);

    /**
     *查看商品是否属于女装
     * @param cid
     * @return
     */
    boolean instanOfWoman(Long cid);

    /**
     * 根据goodsId查cid
     * @param goodsId
     * @return
     throws ItemException
     */
    public ItemGoatCidAndWebsiteVO getItemCid(Long goodsId) throws ItemException;
}
