package com.shigu.activity.service;

import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguTemp;
import com.opentae.data.mall.beans.ShopNumAndMarket;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.examples.ShiguTempExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.opentae.data.mall.interfaces.ShiguTempMapper;
import com.shigu.activity.tempvo.PopularGoodsVO;
import com.shigu.main4.common.util.BeanMapper;
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
    ShiguShopMapper shiguShopMapper;

    /**
     * 获取秋装新品发布会数据
     * 在shigu_temp表中，flag标记转由{@link com.shigu.main4.spread.enums.AutumnNewConstant}维护
     * key1 存储对应商品id
     * key2 存储shopId
     * key3 存储商品对应权益
     *
     * @return
     */
    public List<PopularGoodsVO> selNewPopularGoodsList(String flag) {
        ShiguTempExample shiguTempExample = new ShiguTempExample();
        shiguTempExample.createCriteria().andFlagEqualTo(flag);
        shiguTempExample.setOrderByClause("key2+0 asc,key4+0 asc");
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
        if (goodsIds.size()==0) {
            return new ArrayList<>();
        }

        example.createCriteria().andWebSiteEqualTo("hz").andGoodsIdIn(goodsIds);
        List<ShiguGoodsTiny> shiguGoodsTinies = shiguGoodsTinyMapper.selectByExample(example);
        Map<Long,ShiguGoodsTiny> tinyMap= BeanMapper.list2Map(shiguGoodsTinies,"goodsId",Long.class);
        //得到店铺市场信息
        List<ShopNumAndMarket> markets=shiguShopMapper.selShopNumAndMarkets(shiguGoodsTinies.stream().map(ShiguGoodsTiny::getStoreId).collect(Collectors.toList()));
        Map<Long,ShopNumAndMarket> marketMap=BeanMapper.list2Map(markets,"shopId",Long.class);

        List<PopularGoodsVO> results=new ArrayList<>();
        //为了做整行随机
        Set<String> shopSet=new HashSet<>();
        Map<String,List<PopularGoodsVO>> lineMap=new HashMap<>();
        shiguTemps.forEach(o ->{
            ShiguGoodsTiny tiny=tinyMap.get(Long.valueOf(o.getKey1()));
            if (tiny == null) {
                //处理已下架商品数据
                return;
            }
            ShopNumAndMarket store=marketMap.get(Long.valueOf(o.getKey2()));
            PopularGoodsVO vo = new PopularGoodsVO();
            vo.setGoodsId(tiny.getGoodsId());
            vo.setImgSrc(tiny.getPicUrl());
            vo.setShopId(tiny.getStoreId());
            vo.setShopNum(store.getShopNum());
            vo.setMarketName(store.getMarket());
            vo.setTitle(tiny.getTitle());
            String shStatus = goodsIdShStatusMap.get(tiny.getGoodsId().toString());
            vo.setShStatus(shStatus == null ? 0 : new Integer(shStatus));
            vo.setPiPriceString(tiny.getPiPriceString());
            List<PopularGoodsVO> line=lineMap.get(o.getKey2());
            if (line == null) {
                line=new ArrayList<>();
                lineMap.put(o.getKey2(),line);
                shopSet.add(o.getKey2());
            }
            line.add(vo);
        });
        List<String> shopList=new ArrayList<>(shopSet);
        Collections.shuffle(shopList);
        shopList.forEach(shopId ->{
            results.addAll(lineMap.get(shopId));
        });
        return results;
    }

    /**
     * 检测是否已经报过名
     * @param flag
     * @param userId
     * @param shopId
     * @return
     */
    public boolean checkTempSignUp(String flag, Long userId, Long shopId) {
        ShiguTempExample shiguTempExample =new ShiguTempExample();
        shiguTempExample.createCriteria().andKey1EqualTo(userId.toString()).andKey2EqualTo(shopId.toString()).andFlagEqualTo(flag);
        List<ShiguTemp> temps = shiguTempMapper.selectByExample(shiguTempExample);
        return temps.size()>0;
    }
}
