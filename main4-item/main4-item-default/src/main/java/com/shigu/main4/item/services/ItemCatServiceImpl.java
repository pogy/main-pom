package com.shigu.main4.item.services;

import com.opentae.data.mall.beans.ShiguGoodsIdGenerator;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguStoreUsercat;
import com.opentae.data.mall.beans.ShiguTaobaocat;
import com.opentae.data.mall.examples.ShiguStoreUsercatExample;
import com.opentae.data.mall.examples.ShiguTaobaocatExample;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguStoreUsercatMapper;
import com.opentae.data.mall.interfaces.ShiguTaobaocatMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.exceptions.ItemException;
import com.shigu.main4.item.vo.EverUsedCat;
import com.shigu.main4.item.vo.EverUsedCatForAdd;
import com.shigu.main4.item.vo.ItemGoatCidAndWebsiteVO;
import com.shigu.main4.item.vo.TbCat;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 类目服务
 * Created by zhaohongbo on 17/3/15.
 */
@Service("itemCatService")
public class ItemCatServiceImpl implements ItemCatService{

    @Resource(name = "tae_mall_shiguStoreUsercatMapper")
    private ShiguStoreUsercatMapper shiguStoreUsercatMapper;

    @Resource(name = "tae_mall_shiguTaobaocatMapper")
    private ShiguTaobaocatMapper shiguTaobaocatMapper;

    @Resource(name = "tae_mall_shiguGoodsIdGeneratorMapper")
    private ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    @Resource(name = "tae_mall_shiguGoodsTinyMapper")
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    /**
     * 用户曾经使用过得发布类目
     * @param shopId 店铺ID
     * @param size
     * @return
     */
    @Override
    public List<EverUsedCat> everUsedCats(Long shopId, Integer size) {
        List<EverUsedCat> everUsedCatList = new ArrayList<EverUsedCat>();
        if(shopId == null){
            return everUsedCatList;
        }
        ShiguStoreUsercatExample shiguStoreUsercatExample = new ShiguStoreUsercatExample();
        shiguStoreUsercatExample.createCriteria().andStoreIdEqualTo(shopId);
        shiguStoreUsercatExample.setStartIndex(0);
        shiguStoreUsercatExample.setEndIndex(size);
        List<ShiguStoreUsercat> storeUsercatList = shiguStoreUsercatMapper.selectByConditionList(shiguStoreUsercatExample);
        everUsedCatList = BeanMapper.mapList(storeUsercatList, EverUsedCat.class);
        return everUsedCatList;
    }

    /**
     * 保存用户使用记录
     * @param shopId
     * @param cat
     */
    @Override
    public void saveEverUsedCat(Long shopId,EverUsedCatForAdd cat) {
        if(shopId == null || cat == null){
            return;
        }
        ShiguStoreUsercatExample storeUsercatExample = new ShiguStoreUsercatExample();
        storeUsercatExample.createCriteria().andCidEqualTo(cat.getCid()).andStoreIdEqualTo(shopId);
        int storeCatCount = shiguStoreUsercatMapper.countByExample(storeUsercatExample);
        if(storeCatCount > 0){
            return;
        }
        ShiguStoreUsercat shiguStoreUsercat = new ShiguStoreUsercat();
        shiguStoreUsercat.setAllcids(cat.getAllcids());
        shiguStoreUsercat.setCid(cat.getCid());
        shiguStoreUsercat.setCname(cat.getCname());
        shiguStoreUsercat.setCreated(new Date());
        shiguStoreUsercat.setShowName(cat.getShowName());
        shiguStoreUsercat.setStoreId(shopId);
        shiguStoreUsercatMapper.insertSelective(shiguStoreUsercat);
    }

    /**
     * 子类
     * @param cid
     * @return
     */
    @Override
    public List<TbCat> subCats(Long cid) {
        ShiguTaobaocatExample example=new ShiguTaobaocatExample();
        example.createCriteria().andParentCidEqualTo(cid);
        List<ShiguTaobaocat> cats=shiguTaobaocatMapper.selectByExample(example);
        return BeanMapper.mapList(cats,TbCat.class);
    }

    @Override
    public Long parentCats(Long cid) {

        ShiguTaobaocat shiguTaobaocat = new ShiguTaobaocat();
        shiguTaobaocat.setCid(cid);
        shiguTaobaocat  = shiguTaobaocatMapper.selectOne(shiguTaobaocat);
        if (shiguTaobaocat == null) {
            return null;
        }
        return shiguTaobaocat.getParentCid();
    }

    @Override
    public boolean instanOfWoman(Long cid) {
        Long parentId = parentCats(cid);
        if (parentId != null && parentId == 16){//父级或者父父级的cid等于16为女装
            return true;
        }else{
            parentId =  parentCats(parentId);
            if (parentId != null && parentId == 16) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ItemGoatCidAndWebsiteVO getItemCid(Long goodsId) throws ItemException {
        ShiguGoodsIdGenerator generator;
        // 验证参数，并查询分站存在
        if (goodsId == null || (generator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(goodsId)) == null) {
            throw new ItemException("未查询到分站信息",goodsId);
        }
        String webSite = generator.getWebSite();
        // 获取出售中商品
        ShiguGoodsTiny tiny = new ShiguGoodsTiny();
        tiny.setGoodsId(goodsId);
        tiny.setWebSite(webSite);
        if ((tiny = shiguGoodsTinyMapper.selectByPrimaryKey(tiny)) == null) {
            throw new ItemException("未查询到商品信息",goodsId);
        }
        ItemGoatCidAndWebsiteVO itemGoatCidAndWebsiteVO= new ItemGoatCidAndWebsiteVO();
        itemGoatCidAndWebsiteVO.setCid(tiny.getCid());
        itemGoatCidAndWebsiteVO.setWebsite(tiny.getWebSite());
        return itemGoatCidAndWebsiteVO;
    }
}
