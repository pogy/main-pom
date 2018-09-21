package com.shigu.activity.service;

import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguMarketActivityGoods;
import com.opentae.data.mall.beans.ShiguMarketActivitys;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.examples.ShiguMarketActivityGoodsExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguMarketActivityGoodsMapper;
import com.opentae.data.mall.interfaces.ShiguMarketActivitysMapper;
import com.opentae.data.mall.interfaces.ShiguShopLicenseMapper;
import com.shigu.activity.vo.ActivityGoodsVo;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
        activityGoodsexample.setOrderByClause("sort asc");
        activityGoodsexample.setStartIndex(pageno);
        activityGoodsexample.setEndIndex(pageSize);
        List<ShiguMarketActivityGoods> marketActivityGoodsList = shiguMarketActivityGoodsMapper.selectFieldsByConditionList(activityGoodsexample,"goods_id");
        List<Long> goodsIds = BeanMapper.getFieldList(marketActivityGoodsList, "goodsId", Long.class);

        ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
        tinyExample.setWebSite("hz");
        tinyExample.createCriteria().andGoodsIdIn(goodsIds);
        List<ShiguGoodsTiny> shiguGoodsTinyList = shiguGoodsTinyMapper.selectFieldsByExample(tinyExample, "goods_id,pic_url,parent_market_name,store_num,store_id,pi_price_string,title");
        List<ActivityGoodsVo> voList = new ArrayList<>();
        for (int i = 0; i <shiguGoodsTinyList.size() ; i++) {
            ActivityGoodsVo vo = new ActivityGoodsVo();
            vo.setGoodsId(shiguGoodsTinyList.get(i).getGoodsId());
            vo.setImgSrc(shiguGoodsTinyList.get(i).getPicUrl());
            vo.setMarketName(shiguGoodsTinyList.get(i).getParentMarketName());
            vo.setPiPriceString(shiguGoodsTinyList.get(i).getPiPriceString());
            vo.setShopId(shiguGoodsTinyList.get(i).getStoreId());
            vo.setShopNum(shiguGoodsTinyList.get(i).getStoreNum());
            vo.setTitle(shiguGoodsTinyList.get(i).getTitle());
            voList.add(vo);
        }
        pager.setContent(voList);
        return pager;
    }

    public ShiguMarketActivitys selActivity(Long maId){
        return shiguMarketActivitysMapper.selectByPrimaryKey(maId);
    }
}
