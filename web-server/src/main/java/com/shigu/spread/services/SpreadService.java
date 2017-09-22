package com.shigu.spread.services;

import com.opentae.data.mall.beans.ItemForList;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.service.GoatDubboService;
import com.shigu.main4.goat.vo.ImgGoatVO;
import com.shigu.main4.goat.vo.ItemGoatVO;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.spread.vo.ImgBannerVO;
//import com.shigu.spread.vo.ItemDetailGoatVO;
import com.shigu.spread.vo.ItemSimpleInfo;
import com.shigu.spread.vo.ItemSpreadVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 广告服务
 * Created by zhaohongbo on 17/4/12.
 */
@Service
public class SpreadService {

    private static final Logger logger = LoggerFactory.getLogger(SpreadService.class);

    @Autowired
    GoatDubboService goatDubboService;
    
    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    RedisForIndexPage redisForIndexPage;
    
    /**
     * 查广告数据
     * @param spread
     * @return
     */
    public ObjFromCache<List<ItemSpreadVO>> selItemSpreads(final String webSite, final SpreadEnum spread){
        return new ObjFromCache<List<ItemSpreadVO>>(redisForIndexPage,spread.getCode(),
                ItemSpreadVO.class) {
            @Override
            public List<ItemSpreadVO> selReal() {
                List<ItemSpreadVO> vos=new ArrayList<>();
                try {
                    List<Long> goodsIds=new ArrayList<>();
                    Map<Long,ItemSimpleInfo> itemMap=new HashMap<>();
                    List<ItemGoatVO> goats=goatDubboService.selGoatsFromLocalCode(spread.getCode());
                    for(ItemGoatVO igv:goats){
                        String tag=igv.getTag1();
//                        String element=igv.getElement();
//                        String shopTitle=igv.getShopTitle();
                        if (igv.getItemId() != null) {
                            itemMap.put(igv.getItemId(),new ItemSimpleInfo(igv.getItemId(),tag,tag,tag,igv.getTitle()));
                            goodsIds.add(igv.getItemId());
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
                            if(spreadMap.get(gid)!=null)
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

//    /**
//     * 查商品详情页广告数据
//     * @param spread
//     * @return
//     */
//    public ObjFromCache<List<ItemDetailGoatVO>> selItemDetailSpreads(final String webSite, final SpreadEnum spread) {
//        return new ObjFromCache<List<ItemDetailGoatVO>>(redisForIndexPage, spread.getCode(),
//                ItemDetailGoatVO.class) {
//            @Override
//            public List<ItemDetailGoatVO> selReal() {
//                List<ItemDetailGoatVO> vos = new ArrayList<>();
//                try {
//                    List<Long> goodsIds = new ArrayList<>();
//                    Map<Long, ItemSimpleInfo> itemMap = new HashMap<>();
//                    List<ItemGoatVO> goats = goatDubboService.selGoatsFromLocalCode(spread.getCode());
//
//                    for (ItemGoatVO igv : goats) {
//                        String tag = igv.getTag1();
////                        String element=igv.getElement();
////                        String shopTitle=igv.getShopTitle();
//                        if (igv.getItemId() != null) {
//                            itemMap.put(igv.getItemId(), new ItemSimpleInfo(igv.getItemId(), tag, tag, tag, igv.getTitle()));
//                            goodsIds.add(igv.getItemId());
//                        }
//                    }
//                    List<Long> sortIds = new ArrayList<>();
//                    sortIds.addAll(goodsIds);
//
//                    if (goodsIds.size() > 0) {
//                        Map<Long,ItemDetailGoatVO> spreadMap = new HashMap<>();
//                        List<ItemForList> list = shiguGoodsTinyMapper.selItemsForList(webSite, goodsIds);
//                        for (int i = 0; i < list.size(); i++) {
//                            ItemForList ifl = list.get(i);
//                            ItemDetailGoatVO idgv = new ItemDetailGoatVO(ifl);
//                            spreadMap.put(ifl.getGoodsId(),idgv);
//                            goodsIds.remove(ifl.getGoodsId());
//                        }
//
//                        //如果有下架
//                        if(goodsIds.size()>0){
//                            List<ItemForList> soldoutlist=shiguGoodsTinyMapper.selSoldItemsForList(webSite,goodsIds);
//                            for(int i=0;i<soldoutlist.size();i++){
//                                ItemForList ifl=soldoutlist.get(i);
//                                ItemDetailGoatVO idgv = new ItemDetailGoatVO(ifl);
//                                spreadMap.put(ifl.getGoodsId(),idgv);
//                            }
//                        }
//                        //按顺序搞进去
//                        for(Long gid:sortIds){
//                            if(spreadMap.get(gid)!=null)
//                                vos.add(spreadMap.get(gid));
//                        }
//                    }
//                } catch (Exception e) {
//                    logger.error("获取商品类数据[" + spread + "]失败", e);
//                }
//                return vos;
//            }
//        };
//    }
    /**
     * 图片类广告
     * @param spread
     * @return
     */
    public ObjFromCache<List<ImgBannerVO>> selImgBanners(final SpreadEnum spread){
        return new ObjFromCache<List<ImgBannerVO>>(redisForIndexPage,spread.getCode(),ImgBannerVO.class) {
            @Override
            public List<ImgBannerVO> selReal() {
                List<ImgBannerVO> vos=new ArrayList<>();
                try {
                    List<ImgGoatVO> goats = goatDubboService.selGoatsFromLocalCode(spread.getCode());
                    Date now = new Date();
                    for (ImgGoatVO gv : goats) {
                        if ((SpreadEnum.BACK_MEMBER.equals(spread)||SpreadEnum.BACK_SHOP.equals(spread))&&gv.getToTime().before(now)) {
                            continue;
                        }
                        vos.add(new ImgBannerVO(gv.getLinkUrl(), gv.getPicUrl(), gv.getText()));
                    }
                }catch (GoatException e){
                    logger.error("查图片类广告Miss",e);
                }
                return vos;
            }
        };
    }

//    /**
//     * 用于造缓存
//     */
//    @Async
//    public void createBySync(ObjFromCache fromCache) {
//        Object obj=fromCache.selReal();
//        redisForIndexPage.putCache(fromCache.key,obj);
//    }
}
