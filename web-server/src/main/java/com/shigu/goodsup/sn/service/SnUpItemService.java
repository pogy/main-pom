package com.shigu.goodsup.sn.service;

import com.opentae.data.mall.beans.ShiguGoodsIdGenerator;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShopNumAndMarket;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.jd.service.JdUpItemService;
import com.shigu.goodsup.sn.vo.SnPageItem;
import com.shigu.tools.KeyWordsUtil;
import com.taobao.api.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SnUpItemService {

    @Autowired
    ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;
    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Autowired
    ShiguShopMapper shiguShopMapper;
    @Autowired
    JdUpItemService jdUpItemService;

    public SnPageItem findGoods(Long goodsId) throws CustomException{
        ShiguGoodsTiny shiguGoodsTiny = selTiny(goodsId);
        SnPageItem snPageItem=new SnPageItem();
        snPageItem.setNumIid(shiguGoodsTiny.getNumIid());
        snPageItem.setStoreId(shiguGoodsTiny.getStoreId());
        snPageItem.setWebSite(shiguGoodsTiny.getWebSite());
        snPageItem.setGoodsId(shiguGoodsTiny.getGoodsId());
        snPageItem.setHuohao(shiguGoodsTiny.getGoodsNo());
        snPageItem.setGoodsId(goodsId);
        snPageItem.setPiPrice(shiguGoodsTiny.getPiPriceString());
        if (shiguGoodsTiny.getStoreId()!=null){
            List<Long> storeIds=new ArrayList<>();
            storeIds.add(shiguGoodsTiny.getStoreId());
            List<ShopNumAndMarket> gmi=shiguShopMapper.selShopNumAndMarkets(storeIds);
            if (gmi.size()>0) {
                snPageItem.setParentMarketName(gmi.get(0).getMarket());
                snPageItem.setStoreNum(gmi.get(0).getShopNum());
            }
        }
        Item item = jdUpItemService.staticGoods(shiguGoodsTiny);
        item.setTitle(KeyWordsUtil.duleKeyWords(item.getTitle()));
        item.setDesc(KeyWordsUtil.duleKeyWords(item.getDesc()));
        snPageItem.setItem(item);
        if(shiguGoodsTiny.getNumIid()==null){
            snPageItem.setGoodsType(2);
        }else {
            snPageItem.setGoodsType(1);
        }
        snPageItem.setDataType(2);

        return snPageItem;
    }

    public ShiguGoodsTiny selTiny(Long goodsId) throws CustomException{
        ShiguGoodsIdGenerator shiguGoodsIdGenerator=shiguGoodsIdGeneratorMapper.selectByPrimaryKey(goodsId);
        if(shiguGoodsIdGenerator==null){
            throw new CustomException(goodsId+" goodsId生成表没找到");
        }
        ShiguGoodsTiny shiguGoodsTiny=new ShiguGoodsTiny();
        shiguGoodsTiny.setGoodsId(goodsId);
        shiguGoodsTiny.setWebSite(shiguGoodsIdGenerator.getWebSite());
        shiguGoodsTiny=shiguGoodsTinyMapper.selectByPrimaryKey(shiguGoodsTiny);
        if(shiguGoodsTiny==null){
            throw new CustomException(goodsId+" goodsTiny表没找到");
        }
        return shiguGoodsTiny;
    }
}
