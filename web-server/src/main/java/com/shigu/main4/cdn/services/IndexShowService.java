package com.shigu.main4.cdn.services;

import com.opentae.data.mall.examples.ShiguGoodsIdGeneratorExample;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.cdn.vo.IndexNavVO;
import com.shigu.main4.cdn.vo.LoveGoodsList;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.main4.spread.exceptions.GoatException;
import com.shigu.main4.spread.service.GoatGetService;
import com.shigu.main4.spread.vo.GoatALocation;
import com.shigu.search.services.CategoryInSearchService;
import com.shigu.search.vo.CateNav;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.spread.services.EhCacheForIndexPage;
import com.shigu.spread.services.ObjFromCache;
import com.shigu.spread.services.SpreadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页数据支持
 * Created by Licca on 17/4/9.
 */
@Service
public class IndexShowService {

    private static final Logger logger = LoggerFactory.getLogger(IndexShowService.class);

    @Autowired
    private ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    @Autowired
    GoatGetService goatGetService;
    /**
     * 类目服务
     */
    @Autowired
    CategoryInSearchService categoryInSearchService;

    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    EhCacheForIndexPage ehCacheForIndexPage;

    @Autowired
    SpreadService spreadService;

    /**
     * 把商品总数数字按个排出
     * @return
     */
    public ObjFromCache<List<Integer>> selNumList(){
        return new ObjFromCache<List<Integer>>(ehCacheForIndexPage,"selNumList",List.class){
            @Override
            public List<Integer> selReal() {
                int count=shiguGoodsIdGeneratorMapper.countByExample(new ShiguGoodsIdGeneratorExample());
                List<Integer> list=new ArrayList<>();
                while(count>0){
                    if(count/10>0){
                        list.add(count%10);
                    }else{
                        list.add(count);
                    }
                    count=count/10;
                }
                //反转
                Collections.reverse(list);
                return list;
            }
        };
    }

    /**
     * 取得会签
     * @param parentValue
     * @param category
     * @return
     */
    public List<IndexNavVO> selStyleOrElementNav(String parentValue,SearchCategory category){
        List<CateNav> navs=categoryInSearchService.selSubCates(parentValue,category);
        List<IndexNavVO> vos=new ArrayList<>();
        if (navs != null) {
            for(CateNav cn:navs){
                vos.add(new IndexNavVO(cn.getText(),Long.valueOf(parentValue)));
            }
        }
        return vos;
    }

    /**
     * 查首页标签类广告
     * @param spread
     * @return
     */
    public ObjFromCache<List<IndexNavVO>> selNavVOs(final SpreadEnum spread){
        return new ObjFromCache<List<IndexNavVO>>(ehCacheForIndexPage,"selNavVOs_"+spread.getCode(),List.class) {
            @Override
            public List<IndexNavVO> selReal() {
                List<IndexNavVO> navVOs=new ArrayList<>();
                try {
                    GoatALocation location=goatGetService.getLocationData(spread.getCode());
                    for(GoatALocation.GoatAItem gai:location.getItems()){
                        navVOs.add(new IndexNavVO(gai.selValueByFieldName("href"),gai.selValueByFieldName("text")));
                    }
                } catch (GoatException e) {
                    logger.error("获取广告位数据["+spread+"]失败",e);
                }
                return navVOs;
            }
        };

    }



    /**
     * 猜你喜欢
     * @return
     */
    public ObjFromCache<LoveGoodsList> loveGoods(final String text, final String webSite, final SpreadEnum spread){
        return new ObjFromCache<LoveGoodsList>(ehCacheForIndexPage,"loveGoods_"+webSite+"_"+spread.getCode(),LoveGoodsList.class) {
            @Override
            public LoveGoodsList selReal() {
                LoveGoodsList love=new LoveGoodsList();
                love.setTypeText(text);
                love.setItems(spreadService.selItemSpreads(webSite,spread).selReal());
                return love;
            }
        };
    }

}
