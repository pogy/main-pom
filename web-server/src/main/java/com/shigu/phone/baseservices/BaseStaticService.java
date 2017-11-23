package com.shigu.phone.baseservices;

import com.google.common.collect.ImmutableSet;
import com.openJar.beans.app.*;
import com.opentae.data.mall.beans.ShiguSite;
import com.opentae.data.mall.examples.ShiguSiteExample;
import com.opentae.data.mall.interfaces.ShiguSiteMapper;
import com.shigu.main4.cdn.services.MarketListService;
import com.shigu.main4.cdn.vo.MarketTagVO;
import com.shigu.main4.cdn.vo.MarketVO;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.phone.api.enums.PhoneCategoryEnum;
import com.shigu.phone.api.enums.PhoneSearchCategoryEnum;
import com.shigu.search.services.CategoryInSearchService;
import com.shigu.search.vo.CateNav;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BaseStaticService {
    private final Logger logger = LoggerFactory.getLogger(BaseStaticService.class);

    @Autowired
    ShiguSiteMapper shiguSiteMapper;
    @Autowired
    EhCacheCacheManager ehCacheManager;
    @Autowired
    CategoryInSearchService categoryInSearchService;
    @Autowired
    private MarketListService marketListService;

    private static final Set<String> REMOVEIDS= ImmutableSet.of("50000852","50008897","1629","50001748","50005867","50011130");


    /**
     * 查询站点
     * @return
     */
    public List<AppSite> selWebSites(){
        Cache cache=ehCacheManager.getCache("appWebSite");
        List<AppSite> sites=cache.get("appWebSite",List.class);
        if(sites==null||sites.size()==0){
            ShiguSiteExample shiguSiteExample=new ShiguSiteExample();
            shiguSiteExample.createCriteria().andRemark1EqualTo("1");
            shiguSiteExample.setOrderByClause("sort_order asc");
            List<ShiguSite> shiguSites=shiguSiteMapper.selectByExample(shiguSiteExample);
            sites=new ArrayList<>();
            for(ShiguSite s:shiguSites){
                if("xh".equals(s.getCitySite())||"jf".equals(s.getCitySite())){
                    continue;
                }
                AppSite s1=new AppSite();
                s1.setSiteName(s.getCityName());
                s1.setWebSite(s.getCitySite());
                sites.add(s1);
            }
            cache.put("appWebSite",sites);
        }
        return sites;
    }

    public List<AppCatGroup>  selCat(String webSite,Integer type){
        PhoneCategoryEnum[] arr = PhoneCategoryEnum.values();
        List<AppCatGroup> catGroups=new ArrayList<>();

        Map<Integer,List<PhoneCategoryEnum>> map= BeanMapper.groupBy(Arrays.asList(arr),"index",Integer.class);
        for (Map.Entry<Integer, List<PhoneCategoryEnum>> entry :map.entrySet()){
            Integer key = entry.getKey();
            List<PhoneCategoryEnum> list = entry.getValue();
            //1男装，2女装
            if(type==1){
                //1男装
                if(key==1){
                    //男装上衣
                    List<AppCat> cats=new ArrayList<>();

                    AppCatGroup appCatGroup1=new AppCatGroup();
                    appCatGroup1.setTitle("男装上衣");
                    for(PhoneCategoryEnum categoryEnum:list){
                        AppCat appCat=new AppCat();
                        if(categoryEnum.getType()==1){
                            appCat.setCid(Long.valueOf(categoryEnum.getKeyword()));
                        }else if(categoryEnum.getType()==2){
                            appCat.setCid(categoryEnum.getCid());
                        }
                        appCat.setName(categoryEnum.getName());
                        appCat.setKeyword(categoryEnum.getKeyword());
                        appCat.setImgsrc(categoryEnum.getImgsrc());
                        appCat.setType(categoryEnum.getType());
                        cats.add(appCat);
                    }
                    appCatGroup1.setCats(cats);
                    catGroups.add(appCatGroup1);
                }else if(key==2){
                    //男士下装2
                    List<AppCat> cats=new ArrayList<>();

                    AppCatGroup appCatGroup1=new AppCatGroup();
                    appCatGroup1.setTitle("男士下装");
                    for(PhoneCategoryEnum categoryEnum:list){
                        AppCat appCat=new AppCat();
                        if(categoryEnum.getType()==1){
                            appCat.setCid(Long.valueOf(categoryEnum.getKeyword()));
                        }else if(categoryEnum.getType()==2){
                            appCat.setCid(categoryEnum.getCid());
                        }
                        appCat.setName(categoryEnum.getName());
                        appCat.setKeyword(categoryEnum.getKeyword());
                        appCat.setImgsrc(categoryEnum.getImgsrc());
                        appCat.setType(categoryEnum.getType());
                        cats.add(appCat);
                    }
                    appCatGroup1.setCats(cats);
                    catGroups.add(appCatGroup1);
                }else if(key==3){
                    //男鞋
                    List<AppCat> cats=new ArrayList<>();

                    AppCatGroup appCatGroup1=new AppCatGroup();
                    appCatGroup1.setTitle("男鞋");
                    for(PhoneCategoryEnum categoryEnum:list){
                        AppCat appCat=new AppCat();
                        if(categoryEnum.getType()==1){
                            appCat.setCid(Long.valueOf(categoryEnum.getKeyword()));
                        }else if(categoryEnum.getType()==2){
                            appCat.setCid(categoryEnum.getCid());
                        }
                        appCat.setName(categoryEnum.getName());
                        appCat.setKeyword(categoryEnum.getKeyword());
                        appCat.setImgsrc(categoryEnum.getImgsrc());
                        appCat.setType(categoryEnum.getType());
                        cats.add(appCat);
                    }
                    appCatGroup1.setCats(cats);
                    catGroups.add(appCatGroup1);
                }
            }else{
                //2女装
                if(key==4){
                    //女装上衣
                    List<AppCat> cats=new ArrayList<>();

                    AppCatGroup appCatGroup1=new AppCatGroup();
                    appCatGroup1.setTitle("女装上衣");
                    for(PhoneCategoryEnum categoryEnum:list){
                        AppCat appCat=new AppCat();
                        if(categoryEnum.getType()==1){
                            appCat.setCid(Long.valueOf(categoryEnum.getKeyword()));
                        }else if(categoryEnum.getType()==2){
                            appCat.setCid(categoryEnum.getCid());
                        }
                        appCat.setName(categoryEnum.getName());
                        appCat.setKeyword(categoryEnum.getKeyword());
                        appCat.setImgsrc(categoryEnum.getImgsrc());
                        appCat.setType(categoryEnum.getType());
                        cats.add(appCat);
                    }
                    appCatGroup1.setCats(cats);
                    catGroups.add(appCatGroup1);
                }else if(key==5){
                    //女士下装
                    List<AppCat> cats=new ArrayList<>();

                    AppCatGroup appCatGroup1=new AppCatGroup();
                    appCatGroup1.setTitle("女士下装");
                    for(PhoneCategoryEnum categoryEnum:list){
                        AppCat appCat=new AppCat();
                        if(categoryEnum.getType()==1){
                            appCat.setCid(Long.valueOf(categoryEnum.getKeyword()));
                        }else if(categoryEnum.getType()==2){
                            appCat.setCid(categoryEnum.getCid());
                        }
                        appCat.setName(categoryEnum.getName());
                        appCat.setKeyword(categoryEnum.getKeyword());
                        appCat.setImgsrc(categoryEnum.getImgsrc());
                        appCat.setType(categoryEnum.getType());
                        cats.add(appCat);
                    }
                    appCatGroup1.setCats(cats);
                    catGroups.add(appCatGroup1);
                }else if(key==6){
                    //女鞋
                    List<AppCat> cats=new ArrayList<>();

                    AppCatGroup appCatGroup1=new AppCatGroup();
                    appCatGroup1.setTitle("女鞋");
                    for(PhoneCategoryEnum categoryEnum:list){
                        AppCat appCat=new AppCat();
                        if(categoryEnum.getType()==1){
                            appCat.setCid(Long.valueOf(categoryEnum.getKeyword()));
                        }else if(categoryEnum.getType()==2){
                            appCat.setCid(categoryEnum.getCid());
                        }
                        appCat.setName(categoryEnum.getName());
                        appCat.setKeyword(categoryEnum.getKeyword());
                        appCat.setImgsrc(categoryEnum.getImgsrc());
                        appCat.setType(categoryEnum.getType());
                        cats.add(appCat);
                    }
                    appCatGroup1.setCats(cats);
                    catGroups.add(appCatGroup1);
                }
            }
            if(key==7){
                //箱包
                List<AppCat> cats=new ArrayList<>();

                AppCatGroup appCatGroup1=new AppCatGroup();
                appCatGroup1.setTitle("箱包");
                //日志
                if (logger.isDebugEnabled()) logger.debug("箱包");
                for(PhoneCategoryEnum categoryEnum:list){
                    AppCat appCat=new AppCat();
                    if(categoryEnum.getType()==1){
                        appCat.setCid(Long.valueOf(categoryEnum.getKeyword()));
                    }else if(categoryEnum.getType()==2){
                        appCat.setCid(categoryEnum.getCid());
                    }
                    appCat.setName(categoryEnum.getName());
                    appCat.setKeyword(categoryEnum.getKeyword());
                    appCat.setImgsrc(categoryEnum.getImgsrc());
                    appCat.setType(categoryEnum.getType());
                    cats.add(appCat);
                }
                appCatGroup1.setCats(cats);
                catGroups.add(appCatGroup1);
            }else if(key==8){
                //配饰
                List<AppCat> cats=new ArrayList<>();

                AppCatGroup appCatGroup1=new AppCatGroup();
                appCatGroup1.setTitle("配饰");
                for(PhoneCategoryEnum categoryEnum:list){
                    AppCat appCat=new AppCat();
                    if(categoryEnum.getType()==1){
                        appCat.setCid(Long.valueOf(categoryEnum.getKeyword()));
                    }else if(categoryEnum.getType()==2){
                        appCat.setCid(categoryEnum.getCid());
                    }
                    appCat.setName(categoryEnum.getName());
                    appCat.setKeyword(categoryEnum.getKeyword());
                    appCat.setImgsrc(categoryEnum.getImgsrc());
                    appCat.setType(categoryEnum.getType());
                    cats.add(appCat);
                }
                appCatGroup1.setCats(cats);
                catGroups.add(appCatGroup1);
            }
        }
        return catGroups;
    }

    public List<AppSearchNav> searchNav(Integer type,Long sid,String webSite){
        List<AppSearchNav> list=new ArrayList<>();
        List<CateNav> cates;
        if(sid == null){
            cates= categoryInSearchService.selCates(webSite);
        }else{
            cates=categoryInSearchService.selSubCates(String.valueOf(sid), type==0? SearchCategory.CATEGORY:SearchCategory.MARKET,webSite);
        }
        if (cates == null || cates.isEmpty()) {
            return null;
        }
        for(CateNav cate:cates){
            if(REMOVEIDS.contains(cate.getId())){
                continue;
            }
            if (type == 1){
                if (PhoneSearchCategoryEnum.WOMAN_CATEGORY.getCateValues().contains(cate.getId()))continue;
            }
            if (type == 2){
                if (PhoneSearchCategoryEnum.MAN_CATEGORY.getCateValues().contains(cate.getId()))continue;
            }
            AppSearchNav ca=new AppSearchNav();
            ca.setName(cate.getText());
            ca.setNavId(new Long(cate.getId()));
            list.add(ca);
        }
        return list;
    }

    public List<CateNav> queryParentCatList(String webSite) {
       return categoryInSearchService.selCates(webSite);
    }

    public List<CateNav> querySubCatList(String webSite, Integer pId) {
        return categoryInSearchService.selSubCates(String.valueOf(pId),SearchCategory.CATEGORY,webSite);
    }

    public List<MarketTagVO> queryMarketListByPid(String webSite, String pid) {
//        return categoryInSearchService.selSubCates(pid,SearchCategory.MARKET,webSite);
        Long mid  = null;
        switch (webSite){
            case "hz":{
                mid = 1L;
                break;
            }
            case "cs":{
                mid = 43L;
                break;
            }
            case "jx":{
                mid = 33L;
                break;
            }
            case "ss":{
                mid = 61L;
                break;
            }
            case "kx":{
                mid = 68L;
                break;
            }
            default:{
                break;
            }
        }
        MarketVO marketVO = marketListService.selMarketData(mid, new Long(pid));
        return marketVO == null ? null : marketVO.getMarketTags();
    }
}
