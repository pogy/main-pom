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
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.phone.api.enums.PhoneCategoryEnum;
import com.shigu.phone.apps.services.AppStaticService;
import com.shigu.phone.wrapper.WrapperUtil;
import com.shigu.search.services.CategoryInSearchService;
import com.shigu.search.vo.CateNav;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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
    public JSONObject cat(CatRequest request) {
        CatResponse resp=new CatResponse();
        PhoneCategoryEnum[] arr = PhoneCategoryEnum.values();
        List<AppCatGroup> catGroups=new ArrayList<>();
        if (request.getWebSite() == null||request.getType() == null) {
            return WrapperUtil.wrapperOpenException("缺少参数",resp);
        }
        Map<Integer,List<PhoneCategoryEnum>> map= BeanMapper.groupBy(Arrays.asList(arr),"index",Integer.class);
        for (Map.Entry<Integer, List<PhoneCategoryEnum>> entry :map.entrySet()){
            Integer key = entry.getKey();
            List<PhoneCategoryEnum> list = entry.getValue();
            Integer type = request.getType();
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

        resp.setCatGroups(catGroups);
        resp.setSuccess(true);
        return JSONObject.fromObject(resp);

    }

    @RequestMapping("app/searchNav")
    @ResponseBody
    public JSONObject searchNav(SearchNavRequest request,SearchNavResponse response)  {
        if (request.getType() == null|| StringUtils.isEmpty(request.getWebSite())) {
            return WrapperUtil.wrapperOpenException("缺少参数",response);
        }
        if(!TYPES.contains(request.getType())){
            return WrapperUtil.wrapperOpenException("参数错误",response);
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
        response.setSuccess(true);
        response.setNavs(list);
        return JSONObject.fromObject(response);
    }
}
