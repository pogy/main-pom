package com.shigu.seller.services;

import com.shigu.main4.monitor.enums.FlowType;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.services.ShopBrowerService;
import com.shigu.main4.monitor.vo.HotUpItem;
import com.shigu.main4.monitor.vo.NoUpItem;
import com.shigu.seller.vo.DateDataLineVO;
import com.shigu.seller.vo.HotItemVO;
import com.shigu.seller.vo.IndexDataFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 店铺首屏数据服务
 * Created by zhaohongbo on 17/3/19.
 */
@Service
public class ShopIndexDataService {

    @Autowired
    protected EhCacheCacheManager cacheManager;

    @Autowired
    ShopBrowerService shopBrowerService;

    @Autowired
    ItemUpRecordService itemUpRecordService;

    /**
     * 商户中心,首屏数据
     * @param shopId
     * @return
     */
    public IndexDataFlow selIndexDataFlow(Long shopId){
        Cache cache=cacheManager.getCache("sellerIndexDataCache");
        if(cache.get(shopId)!=null){
            return cache.get(shopId,IndexDataFlow.class);
        }
        IndexDataFlow data=new IndexDataFlow();
        Calendar cal=Calendar.getInstance();
        Date now=cal.getTime();
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        Date from=cal.getTime();
        cal.add(Calendar.MONTH,-3);
        Date threeMonthAgo=cal.getTime();
        cal.add(Calendar.YEAR,-10);
        Date fifthMonthAgo=cal.getTime();
//        data.setDailiRecord(itemUpRecordService.upedItemTimes(shopId,fifthMonthAgo,now));
//        data.setDailiGoods(itemUpRecordService.upedItemNum(shopId,from,now));
//        data.setDailiPerson(itemUpRecordService.countDailiSellerNum(shopId));
        data.setDailiRecord(-1);
        data.setDailiGoods(-1);
        data.setDailiPerson(-1);
        List<HotUpItem> upItems=itemUpRecordService.selHotUpItems(shopId,7);
        List<HotItemVO> hots=new ArrayList<>();
        for(HotUpItem hui:upItems){
            hots.add(new HotItemVO(hui));
        }
        data.setHotGoods(hots);
        List<NoUpItem> noups=itemUpRecordService.noUpItems(shopId,7,threeMonthAgo);
        List<HotItemVO> nos=new ArrayList<>();
        for(NoUpItem nui:noups){
            nos.add(new HotItemVO(nui));
        }
        data.setNothotGoods(nos);
        data.setIpList(shopBrowerService.selShopFlowByHour(shopId,from,24, FlowType.IP));
        data.setPvList(shopBrowerService.selShopFlowByHour(shopId,from,24,FlowType.PV));
        cache.put(shopId,data);
        return data;
    }

    /**
     * 走线图
     * @param shopId
     * @param type
     * @return
     */
    public DateDataLineVO selGhTongjiByDay(Long shopId,int type){
        DateDataLineVO vo=new DateDataLineVO();
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        if(type==1){//今天
            Date from=cal.getTime();
            vo.setIpList(shopBrowerService.selShopFlowByHour(shopId,from,24,FlowType.IP));
            vo.setPvList(shopBrowerService.selShopFlowByHour(shopId,from,24,FlowType.PV));
        }else if(type==2){//最近7天
            cal.add(Calendar.DATE,-6);
            Date from=cal.getTime();
            vo.setIpList(shopBrowerService.selShopFlowByDay(shopId,from,7,FlowType.IP));
            vo.setPvList(shopBrowerService.selShopFlowByDay(shopId,from,7,FlowType.PV));
        }else if(type==3){//最近30天
            cal.add(Calendar.DATE,-29);
            Date from=cal.getTime();
            vo.setIpList(shopBrowerService.selShopFlowByDay(shopId,from,30,FlowType.IP));
            vo.setPvList(shopBrowerService.selShopFlowByDay(shopId,from,30,FlowType.PV));
        }
        return vo;
    }
}
