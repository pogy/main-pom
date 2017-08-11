package com.shigu.activity.service;

import com.opentae.data.mall.beans.ShiguTemp;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.examples.ShiguTempExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguTempMapper;
import com.shigu.activity.tempvo.PopularGoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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

    /**
     * 获取秋装新品发布会0811数据
     * 在shigu_temp表中flag=new_autumn_0811的记录上存储数据
     * key1存储对应商品id
     * key2存储shopId
     * key3存储商品对应权益
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
        Map<String, String> goodsIdShStatusMap = shiguTemps.stream().collect(Collectors.toMap(ShiguTemp::getKey1, ShiguTemp::getKey3));
        ShiguGoodsTinyExample example = new ShiguGoodsTinyExample();
        example.setWebSite("hz");
        example.createCriteria().andWebSiteEqualTo("hz").andGoodsIdIn(goodsIdShStatusMap.keySet().stream().map(o->{return Long.valueOf(o);}).collect(Collectors.toList()));
        return shiguGoodsTinyMapper.selectByExample(example).stream().map(o -> {
            PopularGoodsVO vo = new PopularGoodsVO();
            vo.setGoodsId(o.getGoodsId());
            vo.setImgSrc(o.getPicUrl());
            vo.setShopId(o.getStoreId());
            vo.setShopNum(o.getStoreNum());
            vo.setMarketName(o.getParentMarketName());
            vo.setTitle(o.getTitle());
            vo.setPiPriceString(o.getPiPriceString());
            String shStatus = goodsIdShStatusMap.get(o.getGoodsId().toString());
            vo.setShStatus(shStatus == null ? 0 : new Integer(shStatus));
            return vo;
        }).collect(Collectors.toList());
    }
}
