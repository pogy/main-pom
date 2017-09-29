package com.shigu.phone.apps.actions;

import com.google.common.collect.ImmutableSet;
import com.openJar.beans.app.AppCat;
import com.openJar.beans.app.AppCatGroup;
import com.openJar.beans.app.AppSearchNav;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.CatRequest;
import com.openJar.requests.app.SearchNavRequest;
import com.openJar.requests.app.SitesRequest;
import com.openJar.responses.app.CatResponse;
import com.openJar.responses.app.SearchNavResponse;
import com.openJar.responses.app.SitesResponse;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.phone.api.enums.PhoneCategoryEnum;
import com.shigu.phone.apps.services.AppStaticService;
import com.shigu.search.services.CategoryInSearchService;
import com.shigu.search.vo.CateNav;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class AppStaticAction {
    private static final Set<Integer> TYPES = ImmutableSet.of(1,2);
    private static final Set<String> CATIDS = ImmutableSet.of("16", "30","50011740","50006843");
    private static final Set<String> REMOVEIDS=ImmutableSet.of("50000852","50008897","1629","50001748","50005867","50011130");
    private static final Set<String> SEXCIDS=ImmutableSet.of("50010850","50011277","162116","50000697","121434004","50008904",
                "50008905","50008898","50008899","121412004","50008900","50000671","50008901",
                "162103","50013194","162104","162105","1623","50013196",
                "50011123","50010158","50000557","50010159","50011153","50000436","50025883",
                "50011159","50011161","50010402","50010160","50011165","50011167");
    @Autowired
    AppStaticService appStaticService;
    @Autowired
    CategoryInSearchService categoryInSearchService;

    @RequestMapping("app/sites")
    @ResponseBody
    public JSONObject sites(SitesRequest request){
        return JSONObject.fromObject(appStaticService.selWebSites());
    }

    @RequestMapping("app/cat")
    @ResponseBody
    public JSONObject cat(CatRequest request) throws Main4Exception {
        CatResponse resp=new CatResponse();
        OpenException openException = new OpenException();
        PhoneCategoryEnum[] arr = PhoneCategoryEnum.values();
        List<AppCatGroup> catGroups=new ArrayList<>();
        if (request.getWebSite() == null||request.getType() == null) {
            openException.setErrMsg("未绑定手机号");
            resp.setException(openException);
            resp.setSuccess(false);
        }

        for(PhoneCategoryEnum categoryEnum:arr){
            if(request.getType()==1){
                //1男装，
                if(categoryEnum.getIndex()==1){
                    //男装上衣1
                    AppCat appCat=new AppCat();
                    AppCatGroup appCatGroup1=new AppCatGroup();
                    List<AppCat> cats=new ArrayList<>();
                    if(categoryEnum.getType()==1){
                        appCat.setCid(Long.valueOf(categoryEnum.getKeyword()));
                    }else if(categoryEnum.getType()==2){
                        appCat.setCid(categoryEnum.getCid());
                    }
                    appCat.setName(categoryEnum.getName());
                    appCat.setKeyword(categoryEnum.getKeyword());
                    appCat.setImgsrc(categoryEnum.getImgsrc());
                    cats.add(appCat);
                    appCatGroup1.setTitle("男装上衣");
                    appCatGroup1.setCats(cats);
                    catGroups.add(appCatGroup1);
                }else if(categoryEnum.getIndex()==2){
                    //男士下装2
                    AppCat appCat=new AppCat();
                    AppCatGroup appCatGroup2=new AppCatGroup();
                    List<AppCat> cats=new ArrayList<>();
                    if(categoryEnum.getType()==1){
                        appCat.setCid(Long.valueOf(categoryEnum.getKeyword()));
                    }else if(categoryEnum.getType()==2){
                        appCat.setCid(categoryEnum.getCid());
                    }
                    appCat.setName(categoryEnum.getName());
                    appCat.setKeyword(categoryEnum.getKeyword());
                    appCat.setImgsrc(categoryEnum.getImgsrc());
                    cats.add(appCat);
                    appCatGroup2.setTitle("男士下装");
                    appCatGroup2.setCats(cats);
                    catGroups.add(appCatGroup2);
                }else if(categoryEnum.getIndex()==3){
                    //男鞋3
                    AppCat appCat=new AppCat();
                    AppCatGroup appCatGroup3=new AppCatGroup();
                    List<AppCat> cats=new ArrayList<>();
                    if(categoryEnum.getType()==1){
                        appCat.setCid(Long.valueOf(categoryEnum.getKeyword()));
                    }else if(categoryEnum.getType()==2){
                        appCat.setCid(categoryEnum.getCid());
                    }
                    appCat.setName(categoryEnum.getName());
                    appCat.setKeyword(categoryEnum.getKeyword());
                    appCat.setImgsrc(categoryEnum.getImgsrc());
                    cats.add(appCat);
                    appCatGroup3.setTitle("男鞋");
                    appCatGroup3.setCats(cats);
                    catGroups.add(appCatGroup3);
                }
            }else{
                //2女装
                if(categoryEnum.getIndex()==4){
                    //女装上衣4
                    AppCat appCat=new AppCat();
                    AppCatGroup appCatGroup4=new AppCatGroup();
                    List<AppCat> cats=new ArrayList<>();
                    if(categoryEnum.getType()==1){
                        appCat.setCid(Long.valueOf(categoryEnum.getKeyword()));
                    }else if(categoryEnum.getType()==2){
                        appCat.setCid(categoryEnum.getCid());
                    }
                    appCat.setName(categoryEnum.getName());
                    appCat.setKeyword(categoryEnum.getKeyword());
                    appCat.setImgsrc(categoryEnum.getImgsrc());
                    cats.add(appCat);
                    appCatGroup4.setTitle("女装上衣");
                    appCatGroup4.setCats(cats);
                    catGroups.add(appCatGroup4);
                }else if(categoryEnum.getIndex()==5){
                    //女士下装5
                    AppCat appCat=new AppCat();
                    AppCatGroup appCatGroup5=new AppCatGroup();
                    List<AppCat> cats=new ArrayList<>();
                    if(categoryEnum.getType()==1){
                        appCat.setCid(Long.valueOf(categoryEnum.getKeyword()));
                    }else if(categoryEnum.getType()==2){
                        appCat.setCid(categoryEnum.getCid());
                    }
                    appCat.setName(categoryEnum.getName());
                    appCat.setKeyword(categoryEnum.getKeyword());
                    appCat.setImgsrc(categoryEnum.getImgsrc());
                    cats.add(appCat);
                    appCatGroup5.setTitle("女士下装");
                    appCatGroup5.setCats(cats);
                    catGroups.add(appCatGroup5);
                }else if(categoryEnum.getIndex()==6){
                    //女鞋6
                    AppCat appCat=new AppCat();
                    AppCatGroup appCatGroup6=new AppCatGroup();
                    List<AppCat> cats=new ArrayList<>();
                    if(categoryEnum.getType()==1){
                        appCat.setCid(Long.valueOf(categoryEnum.getKeyword()));
                    }else if(categoryEnum.getType()==2){
                        appCat.setCid(categoryEnum.getCid());
                    }
                    appCat.setName(categoryEnum.getName());
                    appCat.setKeyword(categoryEnum.getKeyword());
                    appCat.setImgsrc(categoryEnum.getImgsrc());
                    cats.add(appCat);
                    appCatGroup6.setTitle("女鞋");
                    appCatGroup6.setCats(cats);
                    catGroups.add(appCatGroup6);
                }
            }
            if(categoryEnum.getIndex()==7){
                //箱包7
                AppCat appCat=new AppCat();
                AppCatGroup appCatGroup7=new AppCatGroup();
                List<AppCat> cats=new ArrayList<>();
                if(categoryEnum.getType()==1){
                    appCat.setCid(Long.valueOf(categoryEnum.getKeyword()));
                }else if(categoryEnum.getType()==2){
                    appCat.setCid(categoryEnum.getCid());
                }
                appCat.setName(categoryEnum.getName());
                appCat.setKeyword(categoryEnum.getKeyword());
                appCat.setImgsrc(categoryEnum.getImgsrc());
                cats.add(appCat);
                appCatGroup7.setTitle("箱包");
                appCatGroup7.setCats(cats);
                catGroups.add(appCatGroup7);
            }else if(categoryEnum.getIndex()==8){
                //配饰8
                AppCat appCat=new AppCat();
                AppCatGroup appCatGroup8=new AppCatGroup();
                List<AppCat> cats=new ArrayList<>();
                if(categoryEnum.getType()==1){
                    appCat.setCid(Long.valueOf(categoryEnum.getKeyword()));
                }else if(categoryEnum.getType()==2){
                    appCat.setCid(categoryEnum.getCid());
                }
                appCat.setName(categoryEnum.getName());
                appCat.setKeyword(categoryEnum.getKeyword());
                appCat.setImgsrc(categoryEnum.getImgsrc());
                cats.add(appCat);
                appCatGroup8.setTitle("配饰");
                appCatGroup8.setCats(cats);
                catGroups.add(appCatGroup8);
            }
        }
        resp.setCatGroups(catGroups);
        resp.setSuccess(true);
        return JSONObject.fromObject(resp);
       /* List<AppCatGroup> list=new ArrayList<>();
        List<CateNav> cates= categoryInSearchService.selCates(request.getWebSite());
        for(CateNav cate:cates){
            if(CATIDS.contains(cate.getId())){
                switch (request.getType()){
                    case 1:{
                        if("16".equals(cate.getId())||"50006843".equals(cate.getId())){
                            continue;
                        }
                        break;
                    }
                    case 2:{
                        if("30".equals(cate.getId())||"50011740".equals(cate.getId())){
                            continue;
                        }
                        break;
                    }
                }
            }
            List<CateNav> subcates=categoryInSearchService.selSubCates(cate.getId(), SearchCategory.CATEGORY,request.getWebSite());
            List<AppCat> acs=new ArrayList<>(subcates.size());

            if("16".equals(cate.getId())||"30".equals(cate.getId())){
                String cname=request.getType()==1?"男装":"女装";
                AppCatGroup acg1=new AppCatGroup();
                acg1.setTitle(cname+"上装");
                acg1.setCats(new ArrayList<>());
                AppCatGroup acg2=new AppCatGroup();
                acg2.setTitle(cname+"下装");
                acg2.setCats(new ArrayList<>());
                for(CateNav subcate:subcates){
                    if(REMOVEIDS.contains(subcate.getId())){
                        continue;
                    }
                    AppCat ac=new AppCat();
                    ac.setCid(new Long(subcate.getId()));
                    ac.setKeyword(subcate.getKeyword());
                    ac.setName(subcate.getText());
                    //缺少封装参数
                   // ac.setImgsrc();
                    if(SEXCIDS.contains(subcate.getId())){
                        acg1.getCats().add(ac);
                    }else{
                        acg2.getCats().add(ac);
                    }
                }
                list.add(acg1);
                list.add(acg2);
            }else{
                AppCatGroup acg=new AppCatGroup();
                acg.setTitle(cate.getText());
                for(CateNav subcate:subcates){
                    AppCat ac=new AppCat();
                    ac.setCid(new Long(subcate.getId()));
                    ac.setKeyword(subcate.getKeyword());
                    ac.setName(subcate.getText());
                    //缺少封装参数
                    // ac.setImgsrc();
                    acs.add(ac);
                }
                acg.setCats(acs);
                list.add(acg);
            }
        }
        CatResponse response=new CatResponse();
        response.setCatGroups(list);*/
        /*resp.setSuccess(true);
        return JSONObject.fromObject(resp);*/
    }

    @RequestMapping("app/searchNav")
    @ResponseBody
    public JSONObject searchNav(SearchNavRequest request) throws Main4Exception {
        if (request.getType() == null||request.getWebSite()==null) {
            throw new Main4Exception("缺少参数");
        }
        if(!TYPES.contains(request.getType())){
            throw new Main4Exception("参数错误");
        }
        List<AppSearchNav> list=new ArrayList<>();
        List<CateNav> cates;
        if(request.getSid()==null){
            cates= categoryInSearchService.selCates(request.getWebSite());
        }else{
            cates=categoryInSearchService.selSubCates(request.getSid()+"", request.getType()==1?SearchCategory.CATEGORY:SearchCategory.MARKET,request.getWebSite());
        }
        for(CateNav cate:cates){
            if(REMOVEIDS.contains(cate.getId())){
                continue;
            }
            AppSearchNav ca=new AppSearchNav();
            ca.setName(cate.getText());
            ca.setNavId(new Long(cate.getId()));
            list.add(ca);
        }
        SearchNavResponse response=new SearchNavResponse();
        response.setSuccess(true);
        response.setNavs(list);
        return JSONObject.fromObject(response);
    }
}
