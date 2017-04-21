package com.shigu.spread.services;

import com.opentae.data.mall.beans.ItemForList;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.spread.exceptions.GoatException;
import com.shigu.main4.spread.service.GoatGetService;
import com.shigu.main4.spread.vo.GoatALocation;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.spread.vo.ImgBannerVO;
import com.shigu.spread.vo.ItemSimpleInfo;
import com.shigu.spread.vo.ItemSpreadVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 广告服务
 * Created by zhaohongbo on 17/4/12.
 */
@Service
public class SpreadService {

    private static final Logger logger = LoggerFactory.getLogger(SpreadService.class);

    @Autowired
    GoatGetService goatGetService;
    
    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    EhCacheForIndexPage ehCacheForIndexPage;
    
    /**
     * 查广告数据
     * @param spread
     * @return
     */
    public ObjFromCache<List<ItemSpreadVO>> selItemSpreads(final String webSite, final SpreadEnum spread){
        return new ObjFromCache<List<ItemSpreadVO>>(ehCacheForIndexPage,"selItemSpreads_"+webSite+"_"+spread.getCode(),
                List.class) {
            @Override
            public List<ItemSpreadVO> selReal() {
                List<ItemSpreadVO> vos=new ArrayList<>();
                try {
                    GoatALocation location=goatGetService.getLocationData(spread.getCode());
                    List<Long> goodsIds=new ArrayList<>();
                    Map<Long,ItemSimpleInfo> itemMap=new HashMap<>();
                    for(GoatALocation.GoatAItem gai:location.getItems()){
                        String goodsId=gai.selValueByFieldName("goods_id");
                        String style=gai.selValueByFieldName("style");
                        String element=gai.selValueByFieldName("element");
                        String shopTitle=gai.selValueByFieldName("shop_title");
                        if (goodsId != null) {
                            goodsId=goodsId.trim();
                            Long goodsIdLong=Long.valueOf(goodsId);
                            itemMap.put(goodsIdLong,new ItemSimpleInfo(goodsIdLong,style,element,shopTitle));
                            goodsIds.add(goodsIdLong);
                        }
                    }
                    List<Long> sortIds=new ArrayList<>();
                    sortIds.addAll(goodsIds);
                    if(goodsIds.size()>0){
                        Map<Long,ItemSpreadVO> spreadMap=new HashMap<>();
                        List<ItemForList> list=shiguGoodsTinyMapper.selItemsForList(webSite,goodsIds);
                        for(int i=0;i<list.size();i++){
                            ItemForList ifl=list.get(i);
                            ItemSpreadVO isv=new ItemSpreadVO(ifl);
                            isv.setStyleText(itemMap.get(ifl.getGoodsId()).getStyle());
                            isv.setElementText(itemMap.get(ifl.getGoodsId()).getElement());
                            isv.setUserText(itemMap.get(ifl.getGoodsId()).getShopTitle());
                            spreadMap.put(ifl.getGoodsId(),isv);
                            goodsIds.remove(ifl.getGoodsId());
                        }
                        //如果有下架
                        if(goodsIds.size()>0){
                            List<ItemForList> soldoutlist=shiguGoodsTinyMapper.selSoldItemsForList(webSite,goodsIds);
                            for(int i=0;i<soldoutlist.size();i++){
                                ItemForList ifl=soldoutlist.get(i);
                                ItemSpreadVO isv=new ItemSpreadVO(ifl);
                                isv.setStyleText(itemMap.get(ifl.getGoodsId()).getStyle());
                                isv.setElementText(itemMap.get(ifl.getGoodsId()).getElement());
                                isv.setUserText(itemMap.get(ifl.getGoodsId()).getShopTitle());
                                spreadMap.put(ifl.getGoodsId(),isv);
                            }
                        }
                        //按顺序搞进去
                        for(Long gid:sortIds){
                            vos.add(spreadMap.get(gid));
                        }
                    }
                } catch (Exception e) {
                    logger.error("获取商品类数据["+spread+"]失败",e);
                }
                return vos;
            }
        };
    }
    /**
     * 图片类广告
     * @param spread
     * @return
     */
    public ObjFromCache<List<ImgBannerVO>> selImgBanners(final SpreadEnum spread){
        return new ObjFromCache<List<ImgBannerVO>>(ehCacheForIndexPage,"selImgBanners_"+spread.getCode(),List.class) {
            @Override
            public List<ImgBannerVO> selReal() {
                List<ImgBannerVO> vos=new ArrayList<>();
                try {
                    GoatALocation location=goatGetService.getLocationData(spread.getCode());
                    for(GoatALocation.GoatAItem gai:location.getItems()){
                        vos.add(new ImgBannerVO(gai.selValueByFieldName("link"),gai.selValueByFieldName("pic"),null));
                    }
                } catch (GoatException e) {
                    logger.error("获取广告位数据["+spread+"]失败");
                }
                return vos;
            }
        };
    }

    /**
     * 用于造缓存
     */
    @Async
    public void createBySync(ObjFromCache fromCache) {
        Object obj=fromCache.selReal();
        ehCacheForIndexPage.putCache(fromCache.key,obj);
    }
}
