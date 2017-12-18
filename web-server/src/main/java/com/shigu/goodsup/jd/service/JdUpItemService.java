package com.shigu.goodsup.jd.service;

import com.opentae.data.mall.beans.ShiguGoodsIdGenerator;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShopNumAndMarket;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.goodsup.jd.vo.JdPageItem;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.tb.common.exceptions.TbException;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By admin on 2017/12/15/15:23
 */
@Service
public class JdUpItemService {

    @Autowired
    private ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapperImpl;

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapperImpl;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    /**
     * 得到商品
     * @return
     * @throws JdUpException
     */
    public JdPageItem findGoods(Long goodsId) throws JdUpException{
        ShiguGoodsIdGenerator sgig=shiguGoodsIdGeneratorMapperImpl.selectByPrimaryKey(goodsId);
        if(sgig==null){
            throw new JdUpException(goodsId+" goodsId生成表没找到");
        }
        ShiguGoodsTiny sgt=new ShiguGoodsTiny();
        sgt.setGoodsId(goodsId);
        sgt.setWebSite(sgig.getWebSite());
        sgt=shiguGoodsTinyMapperImpl.selectByPrimaryKey(sgt);
        if(sgt==null){
            throw new JdUpException(goodsId+" goodsTiny表没找到");
        }
        sgt.setWebSite(sgig.getWebSite());

        JdPageItem pageItem=new JdPageItem();
        pageItem.setNumIid(sgt.getNumIid());
        pageItem.setStoreId(sgt.getStoreId());
        pageItem.setWebSite(sgig.getWebSite());
        pageItem.setGoodsId(goodsId);
        pageItem.setHuohao(sgt.getGoodsNo());
        pageItem.setPiPrice(sgt.getPiPriceString());
        if (sgt.getStoreId() != null) {
            List<Long> storeIds=new ArrayList<>();
            storeIds.add(sgt.getStoreId());
            List<ShopNumAndMarket> gmi=shiguShopMapper.selShopNumAndMarkets(storeIds);
            if (gmi.size()>0) {
                pageItem.setParentMarketName(gmi.get(0).getMarket());
                pageItem.setStoreNum(gmi.get(0).getShopNum());
            }
        }

//        Item it= staticGoods(sgt);
//        pageItem.setItem(it);
//        if(sgt.getNumIid()==null){
//            pageItem.setGoodsType(2);
//        }else{
//            pageItem.setGoodsType(1);
//        }
        pageItem.setDataType(2);
        return pageItem;
    }

}
