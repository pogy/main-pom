package com.shigu.phone.apps.services;

import com.google.common.collect.ImmutableSet;
import com.openJar.beans.app.AppCat;
import com.openJar.beans.app.AppCatGroup;
import com.openJar.beans.app.AppSearchNav;
import com.openJar.beans.app.AppSite;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.CatRequest;
import com.openJar.requests.app.CatSearchRequest;
import com.openJar.requests.app.SearchNavRequest;
import com.openJar.responses.app.CatResponse;
import com.openJar.responses.app.CatSearchResponse;
import com.openJar.responses.app.SearchNavResponse;
import com.openJar.responses.app.SitesResponse;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.phone.api.enums.PhoneCatSearchEnum;
import com.shigu.phone.api.enums.PhoneCategoryEnum;
import com.shigu.phone.api.enums.PhoneSearchCategoryEnum;
import com.shigu.phone.baseservices.BaseStaticService;
import com.shigu.phone.wrapper.WrapperUtil;
import com.shigu.search.services.CategoryInSearchService;
import com.shigu.search.vo.CateNav;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class AppStaticService {
    private static final Set<String> REMOVEIDS= ImmutableSet.of("50000852","50008897","1629","50001748","50005867","50011130");
    @Autowired
    private BaseStaticService baseStaticService;
    @Autowired
    CategoryInSearchService categoryInSearchService;
    /**
     * 查询站点
     * @return
     */
    public SitesResponse selWebSites(){
        List<AppSite> appSites = baseStaticService.selWebSites();
        SitesResponse response=new SitesResponse();
        response.setSites(appSites);
        response.setSuccess(true);
        return response;
    }

    public List<AppCatGroup>  selCat(String webSite, Integer type){
        return baseStaticService.selCat(webSite,type);
    }

    public List<AppSearchNav> searchNav(Integer type, Long sid, String webSite){
        return baseStaticService.searchNav(type,sid,webSite);
    }
    public SearchNavResponse getSearchNav(SearchNavRequest request){
        SearchNavResponse response=new SearchNavResponse();
        OpenException openException = new OpenException();
        if(!PhoneSearchCategoryEnum.TOTAL_CATEGORY.getTypes().contains(request.getType())){
            openException.setErrMsg("参数错误");
            response.setException(openException);
            return response;
        }
        List<AppSearchNav> list=new ArrayList<>();
        List<CateNav> cates;
        if(request.getSid()==null){
            cates= categoryInSearchService.selCates(request.getWebSite());
        }else{
            cates=categoryInSearchService.selSubCates(request.getSid()+"", request.getType()==0? SearchCategory.CATEGORY:SearchCategory.MARKET,request.getWebSite());
        }
        if (cates == null || cates.isEmpty()) {
            response.setSuccess(true);
            response.setNavs(null);
            return response;
        }
        for(CateNav cate:cates){
            if(REMOVEIDS.contains(cate.getId())){
                continue;
            }
            if (request.getType() == 1){
                if (PhoneSearchCategoryEnum.WOMAN_CATEGORY.getCateValues().contains(cate.getId()))continue;
            }
            if (request.getType() == 2){
                if (PhoneSearchCategoryEnum.MAN_CATEGORY.getCateValues().contains(cate.getId()))continue;
            }
            AppSearchNav ca=new AppSearchNav();
            ca.setName(cate.getText());
            ca.setNavId(new Long(cate.getId()));
            list.add(ca);
        }
        response.setSuccess(true);
        response.setNavs(list);
        return response;
    }
    //类目
    public CatResponse getCat( CatRequest request) {
        CatResponse resp = new CatResponse();
        PhoneCategoryEnum[] arr = PhoneCategoryEnum.values();
        List<AppCatGroup> catGroups = new ArrayList<>();
        Map<Integer, List<PhoneCategoryEnum>> map = BeanMapper.groupBy(Arrays.asList(arr), "index", Integer.class);
        for (Map.Entry<Integer, List<PhoneCategoryEnum>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<PhoneCategoryEnum> list = entry.getValue();
            Integer type = request.getType();
            //1男装，2女装
            if (type == 1) {
                //1男装
                if (key == 1) {
                    //男装上衣
                    List<AppCat> cats = new ArrayList<>();
                    AppCatGroup appCatGroup1 = new AppCatGroup();
                    appCatGroup1.setTitle("男装上衣");
                    appCatGroup1.setId("30");
                    getTraverse(list, cats);
                    appCatGroup1.setCats(cats);
                    catGroups.add(appCatGroup1);
                } else if (key == 2) {
                    //男士下装2
                    List<AppCat> cats = new ArrayList<>();
                    AppCatGroup appCatGroup1 = new AppCatGroup();
                    appCatGroup1.setTitle("男士下装");
                    appCatGroup1.setId("30");
                    getTraverse(list, cats);
                    appCatGroup1.setCats(cats);
                    catGroups.add(appCatGroup1);
                } else if (key == 3) {
                    //男鞋
                    List<AppCat> cats = new ArrayList<>();
                    AppCatGroup appCatGroup1 = new AppCatGroup();
                    appCatGroup1.setTitle("男鞋");
                    appCatGroup1.setId("50011740");
                    getTraverse(list, cats);
                    appCatGroup1.setCats(cats);
                    catGroups.add(appCatGroup1);
                }
            } else {
                //2女装
                if (key == 4) {
                    //女装上衣
                    List<AppCat> cats = new ArrayList<>();
                    AppCatGroup appCatGroup1 = new AppCatGroup();
                    appCatGroup1.setTitle("女装上衣");
                    appCatGroup1.setId("16");
                    getTraverse(list, cats);
                    appCatGroup1.setCats(cats);
                    catGroups.add(appCatGroup1);
                } else if (key == 5) {
                    //女士下装
                    List<AppCat> cats = new ArrayList<>();
                    AppCatGroup appCatGroup1 = new AppCatGroup();
                    appCatGroup1.setTitle("女士下装");
                    appCatGroup1.setId("16");
                    getTraverse(list, cats);
                    appCatGroup1.setCats(cats);
                    catGroups.add(appCatGroup1);
                } else if (key == 6) {
                    //女鞋
                    List<AppCat> cats = new ArrayList<>();
                    AppCatGroup appCatGroup1 = new AppCatGroup();
                    appCatGroup1.setTitle("女鞋");
                    appCatGroup1.setId("50006843");
                    getTraverse(list, cats);
                    appCatGroup1.setCats(cats);
                    catGroups.add(appCatGroup1);
                }
            }
            if (key == 7) {
                //箱包
                List<AppCat> cats = new ArrayList<>();
                AppCatGroup appCatGroup1 = new AppCatGroup();
                appCatGroup1.setTitle("箱包");
                appCatGroup1.setId("50006842");
                //日志
                getTraverse(list, cats);
                appCatGroup1.setCats(cats);
                catGroups.add(appCatGroup1);
            } else if (key == 8) {
                //配饰
                List<AppCat> cats = new ArrayList<>();
                AppCatGroup appCatGroup1 = new AppCatGroup();
                appCatGroup1.setTitle("配饰");
                appCatGroup1.setId("50010404");
                getTraverse(list, cats);
                appCatGroup1.setCats(cats);
                catGroups.add(appCatGroup1);
            }
        }

        resp.setCatGroups(catGroups);
        resp.setSuccess(true);

        return resp;
    }
    //搜索类目
    public CatSearchResponse getCatSearch(CatSearchRequest request) {
        CatSearchResponse resp=new CatSearchResponse();
        PhoneCatSearchEnum[] arr = PhoneCatSearchEnum.values();
        List<AppCatGroup> catGroups = new ArrayList<>();
        Map<Integer, List<PhoneCatSearchEnum>> map = BeanMapper.groupBy(Arrays.asList(arr), "index", Integer.class);
        for (Map.Entry<Integer, List<PhoneCatSearchEnum>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<PhoneCatSearchEnum> list = entry.getValue();
            Integer type = request.getType();
            //1男装，2女装
            if (type == 1) {
                //1男装
                if (key == 1) {
                    //男装上衣
                    List<AppCat> cats = new ArrayList<>();
                    AppCatGroup appCatGroup1 = new AppCatGroup();
                    appCatGroup1.setTitle("男装");
                    appCatGroup1.setId("30");
                    getCatSearchTraverse(list, cats);
                    appCatGroup1.setCats(cats);
                    catGroups.add(appCatGroup1);
                } else if (key == 2) {
                    //男鞋
                    List<AppCat> cats = new ArrayList<>();
                    AppCatGroup appCatGroup1 = new AppCatGroup();
                    appCatGroup1.setTitle("男鞋");
                    appCatGroup1.setId("50011740");
                    getCatSearchTraverse(list, cats);
                    appCatGroup1.setCats(cats);
                    catGroups.add(appCatGroup1);
                }
            } else {
                //2女装
                if (key == 3) {
                    //女装上衣
                    List<AppCat> cats = new ArrayList<>();
                    AppCatGroup appCatGroup1 = new AppCatGroup();
                    appCatGroup1.setTitle("女装");
                    appCatGroup1.setId("16");
                    getCatSearchTraverse(list, cats);
                    appCatGroup1.setCats(cats);
                    catGroups.add(appCatGroup1);
                } else if (key ==4) {
                    //女鞋
                    List<AppCat> cats = new ArrayList<>();
                    AppCatGroup appCatGroup1 = new AppCatGroup();
                    appCatGroup1.setTitle("女鞋");
                    appCatGroup1.setId("50006843");
                    getCatSearchTraverse(list, cats);
                    appCatGroup1.setCats(cats);
                    catGroups.add(appCatGroup1);
                }
            }
            if (key == 5) {
                //箱包
                List<AppCat> cats = new ArrayList<>();
                AppCatGroup appCatGroup1 = new AppCatGroup();
                appCatGroup1.setTitle("箱包");
                appCatGroup1.setId("50006842");
                //日志
                getCatSearchTraverse(list, cats);
                appCatGroup1.setCats(cats);
                catGroups.add(appCatGroup1);
            } else if (key == 6) {
                //配饰
                List<AppCat> cats = new ArrayList<>();
                AppCatGroup appCatGroup1 = new AppCatGroup();
                appCatGroup1.setTitle("配饰");
                appCatGroup1.setId("50010404");
                getCatSearchTraverse(list, cats);
                appCatGroup1.setCats(cats);
                catGroups.add(appCatGroup1);
            }
        }





        resp.setCatGroups(catGroups);
        resp.setSuccess(true);

        return resp;
    }
    //遍历类目枚举
    private void getTraverse( List<PhoneCategoryEnum> list, List<AppCat> cats ) {
        for (PhoneCategoryEnum categoryEnum : list) {
            AppCat appCat = new AppCat();
            if (categoryEnum.getType() == 1) {
                //搜索栏搜索
                appCat.setCid(Long.valueOf(categoryEnum.getKeyword()));
            } else if (categoryEnum.getType() == 2) {
                //类目搜索
                appCat.setCid(categoryEnum.getCid());
            }
            appCat.setName(categoryEnum.getName());
            appCat.setKeyword(categoryEnum.getKeyword());
            appCat.setImgsrc(categoryEnum.getImgsrc());
            appCat.setType(categoryEnum.getType());
            cats.add(appCat);
        }
    }
    private void getCatSearchTraverse( List<PhoneCatSearchEnum> list, List<AppCat> cats ) {
        for (PhoneCatSearchEnum categoryEnum : list) {
            AppCat appCat = new AppCat();
            if (categoryEnum.getType() == 1) {
                //搜索栏搜索
                appCat.setCid(Long.valueOf(categoryEnum.getKeyword()));
            } else if (categoryEnum.getType() == 2) {
                //类目搜索
                appCat.setCid(categoryEnum.getCid());
            }
            appCat.setName(categoryEnum.getName());
            appCat.setKeyword(categoryEnum.getKeyword());
            appCat.setImgsrc(categoryEnum.getImgsrc());
            appCat.setType(categoryEnum.getType());
            cats.add(appCat);
        }
    }
}
