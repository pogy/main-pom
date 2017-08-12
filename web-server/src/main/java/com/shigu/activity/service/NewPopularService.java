package com.shigu.activity.service;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.beans.ShiguTemp;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.examples.ShiguMarketExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.examples.ShiguTempExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.opentae.data.mall.interfaces.ShiguTempMapper;
import com.shigu.activity.tempvo.PopularGoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 类名：NewPopularService
 * 类路径：com.shigu.activity.service.NewPopularService
 * 创建者：王浩翔
 * 创建时间：2017-08-11 11:27
 * 项目：main-pom
 * 描述：秋装新品发布会0811临时使用
 */

@Service("newPopularService")
public class NewPopularService {

    @Autowired
    ShiguTempMapper shiguTempMapper;

    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    ShiguMarketMapper shiguMarketMapper;

    @Autowired
    ShiguShopMapper shiguShopMapper;

    /**
     * 获取秋装新品发布会0811数据
     * 在shigu_temp表中flag=new_autumn_0811的记录上存储数据
     * key1 存储对应商品id
     * key2 存储shopId
     * key3 存储商品对应权益
     *
     * @return
     */
    public List<PopularGoodsVO> selNewPopularGoodsList() {
        ShiguTempExample shiguTempExample = new ShiguTempExample();
        shiguTempExample.createCriteria().andFlagEqualTo("new_autumn_0811");
        List<ShiguTemp> shiguTemps = shiguTempMapper.selectByExample(shiguTempExample);
        if (shiguTemps.size() == 0) {
            return Collections.EMPTY_LIST;
        }
        Map<String, String> goodsIdShStatusMap = new HashMap<>();
        shiguTemps.forEach(o -> {
            if (o.getKey1() != null) {
                goodsIdShStatusMap.put(o.getKey1(), o.getKey3());
            }
        });
        ShiguGoodsTinyExample example = new ShiguGoodsTinyExample();
        example.setWebSite("hz");
        ArrayList<Long> goodsIds = new ArrayList<>(100);
        for (String goodsId : goodsIdShStatusMap.keySet()) {
            if (goodsId != null) {
                goodsIds.add(Long.valueOf(goodsId));
            }
        }
        example.createCriteria().andWebSiteEqualTo("hz").andGoodsIdIn(goodsIds);
        List<ShiguGoodsTiny> shiguGoodsTinies = shiguGoodsTinyMapper.selectByExample(example);
        //处理goods_tiny中一些记录没有parentMarketName信息
        ShiguMarketExample shiguMarketExample = new ShiguMarketExample();
        shiguMarketExample.createCriteria().andMarketIdIn(shiguGoodsTinies.stream().map(ShiguGoodsTiny::getParentMarketId).collect(Collectors.toList()));
        Map<Long, String> marketIdNameMap = shiguMarketMapper.selectFieldsByExample(shiguMarketExample, FieldUtil.codeFields("market_id,market_name"))
                .stream().collect(Collectors.toMap(ShiguMarket::getMarketId, ShiguMarket::getMarketName));
        //处理goods_tiny中一些记录没有shopNum信息
        ShiguShopExample shiguShopExample = new ShiguShopExample();
        shiguShopExample.createCriteria().andShopIdIn(shiguGoodsTinies.stream().map(ShiguGoodsTiny::getStoreId).collect(Collectors.toList()));
        Map<Long, String> shopIdNumMap = shiguShopMapper.selectFieldsByExample(shiguShopExample, FieldUtil.codeFields("shop_id,shop_num")).stream().collect(Collectors.toMap(ShiguShop::getShopId, ShiguShop::getShopNum));
        return shiguGoodsTinies.stream().map(o -> {
            PopularGoodsVO vo = new PopularGoodsVO();
            vo.setGoodsId(o.getGoodsId());
            vo.setImgSrc(o.getPicUrl());
            vo.setShopId(o.getStoreId());
            vo.setShopNum(o.getStoreNum()==null?shopIdNumMap.get(o.getStoreId()):o.getStoreNum());
            vo.setMarketName(marketIdNameMap.get(o.getParentMarketId()));
            vo.setTitle(o.getTitle());
            String shStatus = goodsIdShStatusMap.get(o.getGoodsId().toString());
            vo.setShStatus(shStatus == null ? 0 : new Integer(shStatus));
            vo.setPiPriceString(o.getPiPriceString());
            return vo;
        }).collect(Collectors.toList());
    }
}
