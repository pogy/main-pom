package com.shigu.activity.service;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.examples.ShiguMarketActivityGoodsExample;
import com.opentae.data.mall.examples.ShiguMarketExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.activity.vo.ActivityGoodsVo;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.activity.service
 * @ClassName: MarketActivityService
 * @Author: sy
 * @CreateDate: 2018/9/20 0020 17:36
 */
@Service
public class MarketActivityService {

    @Autowired
    private ShiguMarketActivitysMapper shiguMarketActivitysMapper;
    @Autowired
    private ShiguMarketActivityGoodsMapper shiguMarketActivityGoodsMapper;
    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Autowired
    private ShiguMarketMapper shiguMarketMapper;
    @Autowired
    private ShiguShopMapper shiguShopMapper;
    public ShiguPager<ActivityGoodsVo> selActivityGoods(Long maId ,Integer pageNo, Integer pageSize){
        ShiguPager<ActivityGoodsVo> pager = new ShiguPager<>();
        if (pageNo==null || pageNo < 1) {
            pageNo = 1;
        }
        if (pageSize==null ||pageSize < 1) {
            pageSize = 10;
        }
        pager.setNumber(pageNo);
        int pageno = (pageNo-1)*pageSize;
        ShiguMarketActivityGoods goodsCount = new ShiguMarketActivityGoods();
        goodsCount.setMagStatus(1);
        goodsCount.setMaId(maId);
        int count = shiguMarketActivityGoodsMapper.selectCount(goodsCount);
        pager.calPages(count, pageSize);
        if (count < 0) {
                pager.setContent(new ArrayList<>());
                return pager;
        }
        ShiguMarketActivityGoodsExample activityGoodsexample = new ShiguMarketActivityGoodsExample();
        activityGoodsexample.createCriteria().andMagStatusEqualTo(1).andMaIdEqualTo(maId);
        activityGoodsexample.setOrderByClause("sort ASC , mag_id ASC");
        activityGoodsexample.setStartIndex(pageno);
        activityGoodsexample.setEndIndex(pageSize);
        List<ShiguMarketActivityGoods> marketActivityGoodsList = shiguMarketActivityGoodsMapper.selectFieldsByConditionList(activityGoodsexample,"goods_id");
        List<Long> goodsIds = BeanMapper.getFieldList(marketActivityGoodsList, "goodsId", Long.class);

        ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
        tinyExample.setWebSite("hz");
        tinyExample.createCriteria().andGoodsIdIn(goodsIds);
        List<ShiguGoodsTiny> shiguGoodsTinyList = shiguGoodsTinyMapper.selectFieldsByExample(tinyExample, FieldUtil.codeFields("goods_id,pic_url,parent_market_id,store_id,pi_price_string,title"));
        List<ActivityGoodsVo> voList = new ArrayList<>();
        List<Long> marketIds=new ArrayList<>();
        List<Long> shopIds=new ArrayList<>();
        for (ShiguGoodsTiny tiny : shiguGoodsTinyList) {
            ActivityGoodsVo vo = new ActivityGoodsVo();
            vo.setGoodsId(tiny.getGoodsId());
            vo.setImgSrc(tiny.getPicUrl());
            vo.setPiPriceString(tiny.getPiPriceString());
            vo.setShopId(tiny.getStoreId());
            vo.setMarketId(tiny.getParentMarketId());
            vo.setTitle(tiny.getTitle());
            marketIds.add(tiny.getParentMarketId());
            shopIds.add(tiny.getStoreId());
            voList.add(vo);
        }
        if(marketIds.size()>0){
            ShiguMarketExample shiguMarketExample=new ShiguMarketExample();
            shiguMarketExample.createCriteria().andMarketIdIn(marketIds);
            List<ShiguMarket> ms=shiguMarketMapper.selectFieldsByExample(shiguMarketExample, FieldUtil.codeFields("market_id,market_name"));
            Map<Long,String> mmap=ms.stream().collect(Collectors.toMap(ShiguMarket::getMarketId,ShiguMarket::getMarketName));
            voList.forEach(activityGoodsVo -> activityGoodsVo.setMarketName(mmap.get(activityGoodsVo.getMarketId())));
        }
        if(shopIds.size()>0){
            ShiguShopExample shiguShopExample=new ShiguShopExample();
            shiguShopExample.createCriteria().andShopIdIn(shopIds);
            List<ShiguShop> shops=shiguShopMapper.selectFieldsByExample(shiguShopExample,FieldUtil.codeFields("shop_id,shop_num"));
            Map<Long,String> smap=shops.stream().collect(Collectors.toMap(ShiguShop::getShopId,ShiguShop::getShopNum));
            voList.forEach(activityGoodsVo -> activityGoodsVo.setShopNum(smap.get(activityGoodsVo.getShopId())));
        }
        pager.setContent(voList);
        return pager;
    }

    public ShiguMarketActivitys selActivity(Long maId){
        return shiguMarketActivitysMapper.selectByPrimaryKey(maId);
    }
}
