package com.shigu.main4.cdn.services;

import com.shigu.main4.cdn.vo.*;
import com.shigu.main4.spread.service.ActiveDrawService;
import com.shigu.main4.storeservices.MarketShopService;
import com.shigu.main4.vo.FloorShow;
import com.shigu.main4.vo.MarketNavShow;
import com.shigu.main4.vo.MarketShow;
import com.shigu.main4.vo.ShopShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 市场列表服务
 * Created by Licca on 17/3/25.
 */
@Service
public class MarketListService {
    private Map<Long,String> cidToCatMap;

    private Map<String,Long> catToCidMap;

    @Autowired
    ActiveDrawService activeDrawService;

    /**
     * 给个ID方便前端参数传递
     */
    private void initCidToCatMap(){
        if(cidToCatMap==null){
            cidToCatMap=new LinkedHashMap<>();
            cidToCatMap.put(30L,"男装");
            cidToCatMap.put(16L,"女装");
            cidToCatMap.put(50008165L,"童装");
            cidToCatMap.put(50011740L,"男鞋");
            cidToCatMap.put(50010404L,"配件");
            cidToCatMap.put(50006848L,"女鞋");
            cidToCatMap.put(50006842L,"包包");
            cidToCatMap.put(50016741L,"情侣装");
            cidToCatMap.put(1625L,"内衣");
            cidToCatMap.put(404L,"其他");
        }
    }

    /**
     * 方便反取
     */
    private void initCatToCidMap(){
        if(catToCidMap==null){
            if(cidToCatMap==null){
                initCidToCatMap();
            }
            catToCidMap=new LinkedHashMap<>();
            Iterator<Long> keyit=cidToCatMap.keySet().iterator();
            while (keyit.hasNext()){
                Long key=keyit.next();
                catToCidMap.put(cidToCatMap.get(key),key);
            }
        }
    }

    /**
     * 按名字拿
     * @param name
     * @return
     */
    private Long getCidByName(String name){
        if(catToCidMap==null){
            initCatToCidMap();
        }
        return catToCidMap.get(name)==null?404L:catToCidMap.get(name);
    }

    /**
     * 按cid拿名字
     * @param cid
     * @return
     */
    private String getNameByCid(Long cid){
        if(cidToCatMap==null){
            initCidToCatMap();
        }
        return cidToCatMap.get(cid)==null?cidToCatMap.get(404L):cidToCatMap.get(cid);
    }



    /**
     * 市场页面店铺服务
     */
    @Autowired
    MarketShopService marketShopService;

    /**
     * 查询市场数据
     * @param mid
     * @param cid
     * @return
     */
    public MarketVO selMarketData(Long mid,Long cid){
        //因为单个市场的店铺有限，此处为了缓存方便，每次取全市场，由程序实现筛选
        MarketShow marketShow=marketShopService.selMarketShow(mid);
        if (marketShow == null) {
            return null;
        }
        MarketVO vo=new MarketVO();
        vo.setWebSite(marketShow.getWebSite());
        //准备存储主营类目
        List<CateVO> cates=new ArrayList<>();
        //类目暂时取Map里全类目
        if(catToCidMap==null)
            initCatToCidMap();
//        for (Long key : cidToCatMap.keySet()) {
//            cates.add(new CateVO(key, cidToCatMap.get(key)));
//        }
        //准备存放所有市场
        List<MarketTagVO> marketTagVOs=new ArrayList<>();
        //准备存放所有楼层
        List<FloorVO> floorVos=new ArrayList<>();
        //处理所有市场信息
        List<MarketShow> otherMarkets=marketShow.getOtherMarkets();
        for(MarketShow ms:otherMarkets){
            marketTagVOs.add(new MarketTagVO(ms.getMarketOuterId(),ms.getMarketName()));
            if (Objects.equals(ms.getMarketOuterId(), mid)) {
                vo.setMarketName(ms.getMarketName());
            }
        }
        if (vo.getMarketName() == null && !otherMarkets.isEmpty()) {
            vo.setMarketName(marketTagVOs.get(0).getName());
        }
        //拿到发现好货的ID
        List<Long> shopIds=activeDrawService.findDrawShopIds();
        //处理楼层店铺
        List<FloorShow> floors=marketShow.getFloors();
        long now = System.currentTimeMillis();
        Set<String> thisCats = new HashSet<>();
        for(FloorShow fs:floors){
            FloorVO fv=new FloorVO();
            fv.setTitle(fs.getShowName());
            fv.setStores(new ArrayList<ShopInFloorVO>());
            for(ShopShow ss:fs.getShops()){
                ShopInFloorVO sifv=new ShopInFloorVO();
                sifv.setId(ss.getShopId());
                sifv.setCate(ss.getSystemComment());
                sifv.setNum(ss.getShopNum());
                sifv.setTags(ss.getTags());
                sifv.setIsfdGoods(shopIds.contains(ss.getShopId())?1:0);
                if (ss.getCreateDate() != null && now - ss.getCreateDate().getTime() < 1000L * 3600 * 24 * 30) {
                    sifv.setIsNew(1);
                }
                thisCats.add(ss.getMainBus());
                //无条件，或满足类目条件
                if(cid==null||getNameByCid(cid).equals(ss.getMainBus())){
                    fv.getStores().add(sifv);
                }
            }
            //如果本楼层有
            if(fv.getStores().size()>0){
                floorVos.add(fv);
            }
        }
        for (Map.Entry<String, Long> entry : catToCidMap.entrySet()) {
            if (thisCats.contains(entry.getKey())) {
                cates.add(new CateVO(entry.getValue(), entry.getKey()));
            }
        }
        vo.setCates(cates);
        vo.setFloorVOs(floorVos);
        vo.setMarketTags(marketTagVOs);
        return vo;
    }

    /**
     * 网站导航市场展示数据
     * @param website
     * @return
     */
    public List<MarketNavShow> selMarketNavShow(String website){
        return marketShopService.selMarketNavShowList(website);
    }
}
