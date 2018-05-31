package com.shigu.search.services;

import com.opentae.data.mall.beans.ShiguTaobaocat;
import com.opentae.data.mall.examples.ShiguTaobaocatExample;
import com.opentae.data.mall.interfaces.ShiguTaobaocatMapper;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.main4.item.services.ItemSearchService;
import com.shigu.main4.item.vo.CategoryValue;
import com.shigu.search.vo.CateNav;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类目服务
 * Created by zhaohongbo on 17/4/5.
 */
@Service
public class CategoryInSearchService {

    @Autowired
    ShiguTaobaocatMapper shiguTaobaocatMapper;

    @Autowired
    ItemSearchService itemSearchService;

    @Autowired
    protected EhCacheCacheManager cacheManager;


    /**
     * 查搜索档口
     * @return
     */
    public List<CateNav> selMarkets(String website){
        if(StringUtils.isEmpty(website)){
            website = "hz";
        }
        Cache cache=cacheManager.getCache("searchCatesCache");
        List<CateNav> cateNavs=cache.get(website + "1",List.class);
        if(cateNavs!=null){
            return cateNavs;
        }
        List<CategoryValue> catlist=itemSearchService.selCategory(SearchCategory.MARKET,website);
        List<CateNav> markets=new ArrayList<>();
        for(CategoryValue gv:catlist){
            markets.add(new CateNav(gv.getCateValue(),gv.getCateName()));
        }
        cache.put(website + "1",markets);
        return markets;
    }

    /**
     * 查主类目
     * @return
     */
    public List<CateNav> selCates(String website){
        if(StringUtils.isEmpty(website)){
            website = "hz";
        }
        Cache cache=cacheManager.getCache("searchCatesCache");
        List<CateNav> cateNavs=cache.get(website + "2",List.class);
        if(cateNavs!=null){
            return cateNavs;
        }
        List<CategoryValue> cates=itemSearchService.selCategory(SearchCategory.CATEGORY,website);
        List<CateNav> navs=new ArrayList<>();
        for(CategoryValue gv:cates){
            navs.add(new CateNav(gv.getCateValue(),gv.getCateName()));
        }
        cache.put(website + "2",navs);
        return navs;
    }

    /**
     * 给商品库用的主类目
     * @return
     */
    public List<CateNav> selCatesForGoods(String website){
        List<CateNav> cates=new ArrayList<>();
        cates.addAll(selCates(website));
        cates.add(new CateNav("风格馆",null,"风格馆"));
        cates.add(new CateNav("大码区",null,"大码区"));
        return cates;
    }

    /**
     * 子级类目
     * @param cateValue
     * @return
     */
    public List<CateNav> selSubCates(String cateValue,SearchCategory category, String webSite){
//        Cache cache=cacheManager.getCache("searchSubCatesCache");
//
//        String key=webSite + cateValue+" is "+category.getValue();
//        List<CateNav> cateNavs=cache.get(key,List.class);
//        if(cateNavs!=null){
//            if(cateNavs.size()==0){
//                return null;
//            }else{
//                return cateNavs;
//            }
//        }
        List<CategoryValue> cates=itemSearchService.selSubCategory(cateValue,category, webSite);
        List<CategoryValue> returnCates = new ArrayList<>();
        List<String> keyWords = new ArrayList<>();
        for (CategoryValue item : cates){
            if (keyWords.contains(item.getCateValue())){
                continue;
            }
            keyWords.add(item.getCateValue());
            returnCates.add(item);
        }
        List<CateNav> navs=new ArrayList<>();
        for(CategoryValue gv:returnCates){
            if(category.equals(SearchCategory.STYLE)){
                navs.add(new CateNav(gv.getSubId()+"",gv.getCateName(),gv.getCateValue()));
            }else{
                if (gv.getType() == 5){
                    navs.add(new CateNav(gv.getCateValue(),gv.getCateName(),gv.getCateValue(),gv.getCateValue()));
                }
                if (gv.getType() == 1){}
                navs.add(new CateNav(gv.getCateValue(),gv.getCateName(),gv.getCateValue()));
            }
        }
        if (navs != null) {
            //cache.put(key,navs);
        }
        return navs.size()==0?null:navs;
    }
    /**
     * 查叶子类目
     * @param cid
     * @return
     */
    public List<Long> selCidsFromCid(Long cid){
        Cache cache=cacheManager.getCache("searchSubCatesCache");
        List<Long> cidsCache=cache.get(cid,List.class);
        if(cidsCache!=null){
            return cidsCache;
        }
        ShiguTaobaocat taobaocat=shiguTaobaocatMapper.selectByPrimaryKey(cid);
        List<Long> cids=new ArrayList<>();
        if (taobaocat != null) {
            if(taobaocat.getIsParent() == 1){//父类
                //查出所有子类目
                ShiguTaobaocatExample example=new ShiguTaobaocatExample();
                example.createCriteria().andParentCidEqualTo(taobaocat.getCid());
                List<ShiguTaobaocat> taobaocats=shiguTaobaocatMapper.selectByExample(example);
                for(ShiguTaobaocat cat:taobaocats){
                    if(cat.getIsParent()==1){
                        cids.addAll(selCidsFromCid(cat.getCid()));
                    }else{
                        cids.add(cat.getCid());
                    }
                }
            }else{
                cids.add(cid);
            }
        }
        cache.put(cid,cids);
        return cids;
    }
}
