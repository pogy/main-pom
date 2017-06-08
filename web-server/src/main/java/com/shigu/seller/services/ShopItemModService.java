package com.shigu.seller.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsIdGenerator;
import com.opentae.data.mall.beans.ShiguGoodsSoldout;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.ShiguGoodsSoldoutExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsSoldoutMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.item.enums.ItemFrom;
import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.main4.item.vo.OnsaleItem;
import com.shigu.main4.item.vo.SynItem;
import com.shigu.seller.actions.ShopAction;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 店内商品修改服务
 * Created by zhaohongbo on 17/3/9.
 */
@Service
public class ShopItemModService {

    private static final Logger logger = Logger.getLogger(ShopItemModService.class);
    @Autowired
    ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;

    @Autowired
    ItemAddOrUpdateService itemAddOrUpdateService;


    @Transactional(rollbackFor = Exception.class)
    public void moreModify(List<SynItem> items) throws ItemModifyException {
        for(SynItem item:items){
            itemAddOrUpdateService.userUpdateItem(item);
        }
    }
    /**
     * 淘宝来的商品,查numIid
     * @param goodsId
     * @param webSite
     * @return
     */
    public Long selNumiidByGoodsId(Long goodsId,String webSite){
        ShiguGoodsTiny sgt=new ShiguGoodsTiny();
        sgt.setWebSite(webSite);
        sgt.setGoodsId(goodsId);
        sgt=shiguGoodsTinyMapper.selectFieldsByPrimaryKey(sgt,FieldUtil.codeFields("goods_id,num_iid,is_excel_imp"));
        if(sgt==null){
            return null;
        }
        if(0!=sgt.getIsExcelImp()){
            return null;
        }
        return sgt.getNumIid();
    }
    /**
     * 商品上架
     */
    public void upItems(Long shopId,String itemIds,String webSite){
        List<Long> ids=filterItemIds(shopId,itemIds,webSite,true);
        for(Long id:ids){
            try {
                itemAddOrUpdateService.userUpItem(id);
            } catch (ItemModifyException e) {
                logger.error("商品上架失败",e);
            }
        }
    }

    /**
     * 商品下架
     * @param shopId
     * @param itemIds
     * @param webSite
     */
    public void downItems(Long shopId,String itemIds,String webSite){
        List<Long> ids=filterItemIds(shopId,itemIds,webSite,false);
        for(Long id:ids){
            try {
                itemAddOrUpdateService.userDownItem(id);
            } catch (ItemModifyException e) {
                logger.error("商品下架失败",e);
            }
        }
    }

    /**
     * 删除商品
     * @param shopId
     * @param itemIds
     * @param webSite
     */
    public void delInstockItems(Long shopId,String itemIds,String webSite){
        List<Long> ids=filterItemIds(shopId,itemIds,webSite,true);
        for(Long id:ids){
            try {
                itemAddOrUpdateService.userDeleteItem(id);
            } catch (ItemModifyException e) {
                logger.error("商品删除失败",e);
            }
        }
    }

    /**
     * 按主键查商品
     * @param goodsId
     * @param webSite
     * @return
     */
    public OnsaleItem selItemByGoodsId(Long goodsId,String webSite){
        ShiguGoodsTiny sgt=new ShiguGoodsTiny();
        sgt.setGoodsId(goodsId);
        sgt.setWebSite(webSite);
        sgt=shiguGoodsTinyMapper.selectByPrimaryKey(sgt);
        if(sgt==null){
            return null;
        }
        OnsaleItem oi=new OnsaleItem();
        oi.setWebSite(webSite);
        oi.setCreated(sgt.getCreated());
        oi.setGoodsNo(sgt.getGoodsNo());
        return null;
    }
    /**
     * 把非本店的商品ID过滤掉
     * @param shopId
     * @param itemIds
     * @param webSite
     * @param soldout 是否下架区的
     * @return
     */
    private List<Long> filterItemIds(Long shopId,String itemIds,String webSite,boolean soldout){
        List<Long> ids=new ArrayList<>();
        List<Long> targetIds=new ArrayList<>();
        String[] idarr=itemIds.split(",");
        for(String id:idarr){
            ids.add(Long.valueOf(id));
        }
        if(ids.size()==0){
            return targetIds;
        }
        if(soldout){
            ShiguGoodsSoldoutExample example=new ShiguGoodsSoldoutExample();
            example.createCriteria().andGoodsIdIn(ids).andStoreIdEqualTo(shopId);
            example.setWebSite(webSite);
            List<ShiguGoodsSoldout> list=shiguGoodsSoldoutMapper.selectFieldsByExample(example, FieldUtil.codeFields("goods_id"));
            if(list.size()==0){
                return targetIds;
            }
            for(ShiguGoodsSoldout sgt:list){
                targetIds.add(sgt.getGoodsId());
            }
        }else{
            ShiguGoodsTinyExample example=new ShiguGoodsTinyExample();
            example.createCriteria().andGoodsIdIn(ids).andStoreIdEqualTo(shopId);
            example.setWebSite(webSite);
            List<ShiguGoodsTiny> list=shiguGoodsTinyMapper.selectFieldsByExample(example, FieldUtil.codeFields("goods_id"));
            if(list.size()==0){
                return targetIds;
            }
            for(ShiguGoodsTiny sgt:list){
                targetIds.add(sgt.getGoodsId());
            }
        }

        return targetIds;
    }
}
