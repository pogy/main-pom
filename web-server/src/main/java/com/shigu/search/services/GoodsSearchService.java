package com.shigu.search.services;

import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.imgsearch.ImgSearchClient;
import com.shigu.imgsearch.beans.Record;
import com.shigu.imgsearch.requests.RetrieveImageRequest;
import com.shigu.imgsearch.responses.RetrieveImageResponse;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.item.services.ItemSearchService;
import com.shigu.main4.item.vo.AggMarketAndCats;
import com.shigu.main4.item.vo.AggsCount;
import com.shigu.main4.item.vo.SearchItem;
import com.shigu.main4.item.vo.ShiguAggsPager;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.storeservices.ShopSearchService;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.main4.vo.SearchShopSimple;
import com.shigu.search.bo.SearchBO;
import com.shigu.search.utils.ShopWeightComparator;
import com.shigu.search.vo.CateNav;
import com.shigu.search.vo.CateNavsInSearch;
import com.shigu.search.vo.GoodsInSearch;
import com.shigu.search.vo.SearchDateFormat;
import com.shigu.search.vo.SearchKey;
import com.shigu.search.vo.SearchNav;
import com.shigu.search.vo.SearchVO;
import com.shigu.search.vo.TjGoods;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.spread.exceptions.SpreadCacheException;
import com.shigu.spread.services.ObjFromCache;
import com.shigu.spread.services.SpreadService;
import com.shigu.spread.vo.ItemSpreadVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品搜索服务
 * Created by zhaohongbo on 17/4/6.
 */
@Service
public class GoodsSearchService {
    @Autowired
    CategoryInSearchService categoryInSearchService;

    @Autowired
    ItemSearchService itemSearchService;

    @Autowired
    ShopSearchService shopSearchService;

    @Autowired
    GoodsSelFromEsService goodsSelFromEsService;

    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    ShiguMarketMapper shiguMarketMapper;

    @Autowired
    ShiguShopMapper shiguShopMapper;

    @Autowired
    protected EhCacheCacheManager cacheManager;

    @Autowired
    SpreadService spreadService;

    String dbUid="aliyun_1582227";
    String dbSeckey="vsDnnCviEeeHHwAWPhwgkg";

    @Autowired
    RedisIO redisIO;


    /**
     * 搜索中的类目
     */
    public SearchNav categoryInSearch(SearchBO bo){
        SearchNav sn=new SearchNav();
        List<SearchKey> keys=new ArrayList<>();
        String beforeUrl="?";
        if(StringUtils.isNotEmpty(bo.getKeyword())){
            keys.add(new SearchKey(bo.getKeyword(),"&keyword="+bo.getKeyword()));
        }
        //分类
        if(bo.getPid()!=null){
            String name=selNavName(categoryInSearchService.selCates(null),bo.getPid().toString());
            beforeUrl+="&pid="+bo.getPid();
            keys.add(new SearchKey(name,beforeUrl));
            if(bo.getCid()!=null){
                String subcname=selNavName(categoryInSearchService.selSubCates(bo.getPid().toString(),SearchCategory.CATEGORY),
                        bo.getCid().toString());
                beforeUrl+="&cid="+bo.getCid();
                keys.add(new SearchKey(subcname,beforeUrl));
            }
        }
        //市场
        if (bo.getMid() != null) {
            String name=selNavName(categoryInSearchService.selMarkets(bo.getWebSite()),bo.getMid().toString());
            beforeUrl+="&mid="+bo.getMid();
            keys.add(new SearchKey(name,beforeUrl));
        }
        sn.setCates(keys);
        return sn;
    }

    /**
     * 查类目或市场名称
     * @return
     */
    public String selNavName(List<CateNav> cates,String value){
        for(CateNav c:cates){
            if(c.getId().equals(value)){
                return c.getText();
            }
        }
        return null;
    }

    /**
     * 临时用,查推荐款
     * @param type 0商品库,1搜索
     * @param pid 类目ID
     * @return
     */
    public List<TjGoods> selTj(String webSite,int type,Long pid){
        SpreadEnum manOrWoman=SpreadEnum.MAN_GOODS_RIGHT;
        if(type==0){//商品库
            if(pid!=null&&(pid==50006843L||pid==16L)){
                manOrWoman=SpreadEnum.WOMAN_GOODS_RIGHT;
            }
        }else{
            manOrWoman=SpreadEnum.SEARCH_RIGHT;
        }
        ObjFromCache<List<ItemSpreadVO>> objFromCache=spreadService.selItemSpreads(webSite, manOrWoman);
        List<ItemSpreadVO> list=objFromCache.selObj();
        if(objFromCache.getType().equals(SpreadCacheException.CacheType.LONG))//如果是从长缓存得到的,需要创建缓存
            spreadService.createBySync(objFromCache);
        Collections.shuffle(list);
        return BeanMapper.mapList(list,TjGoods.class);
    }

    /**
     * 处理一个聚合结果
     * @param cateCache
     * @param aggs
     * @return
     */
    public List<CateNav> aggOneCate(List<CateNav> cateCache,List<AggsCount> aggs){
        List<CateNav> cates=new ArrayList<>();
        Map<Long,CateNav> cateMap=new HashMap<>();
        for(CateNav cn:cateCache){
            if (cn.getId() != null) {
                cateMap.put(Long.valueOf(cn.getId()),cn);
            }
        }
        for(AggsCount ac:aggs){
            CateNav cn=cateMap.get(ac.getValue());
            if (cn != null) {
                cates.add(cn);
            }
        }
        return cates.size()==0?cateCache:cates;
    }

    /**
     * 搜索
     * @param bo
     */
    public SearchVO search(SearchBO bo,SearchOrderBy orderBy,boolean needaggs){
        List<Long> cids=new ArrayList<>();
        if (bo.getCid() != null) {
            cids.addAll(categoryInSearchService.selCidsFromCid(bo.getCid()));
        }else if(bo.getPid() !=null ){
            cids.addAll(categoryInSearchService.selCidsFromCid(bo.getPid()));
        }
        //查店
        List<SearchShopSimple> shops=shopSearchService.selShopByShopNum(bo.getKeyword(),bo.getWebSite());
        List<Long> shouldShopId=new ArrayList<>();
        if(shops!=null&&shops.size()!=0){
            //按电商基地  >  钱塘大厦  >  四季星座 排序
            Collections.sort(shops,new ShopWeightComparator());
            shouldShopId.add(shops.get(0).getShopId());
        }
        //算时间开始与结束
        Date start=null;
        Date end=null;
        if (bo.getD() != null) {
            Calendar cal=Calendar.getInstance();
            end=cal.getTime();
            cal.add(Calendar.DAY_OF_YEAR,0-bo.getD());
            start=cal.getTime();
        }else{
            if (bo.getSt() != null) {
                start = DateUtil.stringToDate(bo.getSt(),"yyyy.MM.dd");
            }
            if (bo.getEt() != null) {
                end = DateUtil.stringToDate(bo.getEt(),"yyyy.MM.dd");
            }
        }
        ShiguAggsPager pager=itemSearchService.searchItem(bo.getKeyword(),bo.getWebSite(),bo.getMid(),
                cids.size()==0?null:cids,
                shouldShopId.size()==0?null:shouldShopId,
                bo.getSp(),bo.getEp(),start,end,orderBy,bo.getPage(),bo.getRows(), needaggs
        );
        SearchVO vo=new SearchVO();
        vo.setSearchData(goodsSelFromEsService.addShopInfoToGoods(pager,bo.getWebSite()));
        vo.setMarkets(pager.getMarkets());
        vo.setParentCats(pager.getParentCats());
        return vo;
    }

    /**
     * 图搜
     *
     *
     * @param picUrl
     * @param webSite
     */
    public List<GoodsInSearch> searchByPic(String picUrl, String webSite) throws IOException {
        //得到IDs
        RetrieveImageRequest request=new RetrieveImageRequest();
        if(picUrl!=null){
            request.setPicUrl(picUrl);
        }else{
            return new ArrayList<>();
        }
        request.setMinSim(0.1f);
        request.setWp("intfield1");
        request.setWs("textfield1 = '"+webSite+"'");
        request.setSel2(20);

        RetrieveImageResponse response=new ImgSearchClient(dbUid,dbSeckey).execute(request);
        //添加搜索记录
        String dateKey="img_search_"+ DateUtil.dateToString(new Date(),"yyyy_MM");
        Long searched=redisIO.get(dateKey,Long.class);
        if(searched==null){
            searched=0L;
        }
        searched++;
        redisIO.put(dateKey,searched);
        if(response.getRetcode()==0&&response.getRecord()!=null){
            List<Long> goodsId=new ArrayList<>();
            for(Record r:response.getRecord()){
                List<String> para=r.getPara();
                if(para!=null&&para.size()>0){
                    goodsId.add(Long.valueOf(para.get(0)));
                }
            }
            List<GoodsInSearch> imgGoods=new ArrayList<>();
            if(goodsId.size()>0){
                ShiguPager<SearchItem> pager=itemSearchService.searchItemByIds(goodsId,"hz",1,20);
                ShiguPager<GoodsInSearch> goodsPager=goodsSelFromEsService.addShopInfoToGoods(pager,"hz");
                if (goodsPager != null) {
//                    return pager.getContent();
                    List<GoodsInSearch> imgs = goodsPager.getContent();
                    Map<Long,GoodsInSearch> imgMap=new HashMap<>();
                    for(GoodsInSearch gis:imgs){
                        imgMap.put(Long.valueOf(gis.getId()),gis);
                    }
                    for(Long gid:goodsId){
                        imgGoods.add(imgMap.get(gid));
                    }
                }
            }
            return imgGoods;
        }
        return new ArrayList<>();
    }
}
