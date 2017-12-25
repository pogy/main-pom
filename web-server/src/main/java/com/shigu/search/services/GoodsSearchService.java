package com.shigu.search.services;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.main4.item.enums.SearchCheckd;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.item.services.ItemSearchService;
import com.shigu.main4.item.vo.AggsCount;
import com.shigu.main4.item.vo.SearchItem;
import com.shigu.main4.item.vo.ShiguAggsPager;
import com.shigu.main4.storeservices.ShopSearchService;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.vo.SearchShopSimple;
import com.shigu.productAi.beans.AiImageInfo;
import com.shigu.productAi.beans.ProductAiSearchBo;
import com.shigu.productAi.services.ProductAiInterface;
import com.shigu.search.bo.SearchBO;
import com.shigu.search.utils.ShopWeightComparator;
import com.shigu.search.vo.*;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.spread.services.ObjFromCache;
import com.shigu.spread.services.SpreadService;
import com.shigu.spread.vo.ItemSpreadVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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
    @Autowired
    ProductAiInterface productAiInterface;

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
                String subcname=selNavName(categoryInSearchService.selSubCates(bo.getPid().toString(),SearchCategory.CATEGORY,bo.getWebSite()),
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
        if (cates !=null) {
            for(CateNav c:cates){
                if(c.getId().equals(value)){
                    return c.getText();
                }
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
        SpreadEnum manOrWoman=getSpreadEnum(webSite, type, pid);
        if (manOrWoman == null) {
            return new ArrayList<>();
        }
        ObjFromCache<List<ItemSpreadVO>> objFromCache=spreadService.selItemSpreads(webSite, manOrWoman);
        List<ItemSpreadVO> list=objFromCache.selObj();
        Collections.shuffle(list);
        return BeanMapper.mapList(list,TjGoods.class);
    }

    /**
     * 获取男装商品库底部广告
     * @param webSite
     * @return
     */
    public List<BottomGoodsGoat> selBottomGoat(String webSite) {
        List<ItemSpreadVO> list = spreadService.selItemSpreads(webSite, SpreadEnum.MAN_GOODS_BOTTOM).selObj();
        Collections.shuffle(list);
        return list.stream().map(o->{
            BottomGoodsGoat result = BeanMapper.map(o, BottomGoodsGoat.class);
            result.setFullStoreName(o.getStoreText());
            return result;
        }).collect(Collectors.toList());
    }

    /**
     * 取广告类别
     * @param webSite
     * @param type   0是商品库  否则 搜索
     * @param pid 大类ID
     * @return
     */
    private SpreadEnum getSpreadEnum(String webSite,int type,  Long  pid) {
        SpreadEnum pEnum = null;
        switch (webSite){
            case "hz":
                if (type==0) {//商品库
                    if(pid!=null&&(pid==50006843L||pid==16L)){
                        pEnum = SpreadEnum.WOMAN_GOODS_RIGHT;
                    }else{
                        pEnum = SpreadEnum.MAN_GOODS_RIGHT;
                    }
                }else{
                    pEnum = SpreadEnum.SEARCH_RIGHT;
                }
                break;
            case "bj":break;
            case "kx":pEnum = SpreadEnum.KX_GOODS_RIGHT;break;
            case "cs":break;
            case "ss":break;
            case "jx":break;
            case "gz":break;
        }
        return pEnum;
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

        List<SearchShopSimple> shops = shopSearchService.selShopByShopNum(bo.getKeyword(), bo.getWebSite());
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
        List<SearchCheckd> checkds=new ArrayList<>();
        if(bo.getBpic()!=null&&bo.getBpic()==1){
            checkds.add(SearchCheckd.BIGZIP);
        }
        if (Objects.equals(1,bo.getGoodsVideo())) {
            checkds.add(SearchCheckd.VIDEO);
        }
        ShiguAggsPager pager=itemSearchService.searchItem(bo.getKeyword(),bo.getWebSite(),bo.getMid(),
                checkds,//大图
                cids.size()==0?null:cids,
                shouldShopId.size()==0?null:shouldShopId,null,
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
        ProductAiSearchBo bo =new ProductAiSearchBo();
        bo.setUrl(picUrl);
        bo.setCount(20);
        bo.setTags(webSite);
        List<AiImageInfo> search = productAiInterface.search(bo);

        //添加搜索记录
        String dateKey=webSite+"img_search_"+ DateUtil.dateToString(new Date(),"yyyy_MM");
        Long searched=redisIO.get(dateKey,Long.class);
        if(searched==null){
            searched=0L;
        }
        searched++;
        redisIO.put(dateKey,searched);

        if(search.size()>0){
            List<Long> goodsId = new ArrayList<>();
            for(AiImageInfo info:search){
                if(StringUtils.isNotEmpty(info.getMeta())){
                    goodsId.add(Long.parseLong(info.getMeta()));
                }
            }
            List<GoodsInSearch> imgGoods = new ArrayList<>();
            if(goodsId.size()>0){
                ShiguPager<SearchItem> pager=itemSearchService.searchItemByIds(goodsId,webSite,1,20);
                ShiguPager<GoodsInSearch> goodsPager=goodsSelFromEsService.addShopInfoToGoods(pager,webSite);
                if (goodsPager != null) {
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
