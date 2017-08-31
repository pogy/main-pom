package com.shigu.phone.apps.actions;

import com.google.common.collect.ImmutableSet;
import com.openJar.beans.app.AppCat;
import com.openJar.beans.app.AppCatGroup;
import com.openJar.requests.app.CatRequest;
import com.openJar.requests.app.SitesRequest;
import com.openJar.responses.app.CatResponse;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.item.enums.SearchCategory;
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
    private static final Set<String> IDS = ImmutableSet.of("16", "30");
    @Autowired
    AppStaticService appStaticService;
    @Autowired
    CategoryInSearchService categoryInSearchService;

    @RequestMapping("app/sites")
    @ResponseBody
    public JSONObject sites(){
        return JSONObject.fromObject(appStaticService.selWebSites());
    }

    @RequestMapping("app/cat")
    @ResponseBody
    public JSONObject cat(CatRequest request) throws Main4Exception {
        if (request.getWebSite() == null||request.getType() == null) {
            throw new Main4Exception("缺少参数");
        }
        String cid=null;
        switch (request.getType()){
            case 1:{
                cid="30";
                break;
            }
            case 2:{
                cid="16";
                break;
            }
        }
        if(cid==null){
            throw new Main4Exception("参数错误:'type="+request.getType()+"'");
        }
        List<AppCatGroup> list=new ArrayList<>();
        List<CateNav> cates= categoryInSearchService.selCates(request.getWebSite());
        for(CateNav cate:cates){
            AppCatGroup acg=new AppCatGroup();
            acg.setTitle(cate.getText());
            if(IDS.contains(cate.getId())){
                if(!cid.equals(cate.getId())){
                    continue;
                }
            }
            List<CateNav> subcates=categoryInSearchService.selSubCates(cate.getId(), SearchCategory.CATEGORY,request.getWebSite());
            List<AppCat> acs=new ArrayList<>(subcates.size());
            for(CateNav subcate:subcates){
                AppCat ac=new AppCat();
                ac.setCid(new Long(subcate.getId()));
                ac.setKeyword(subcate.getKeyword());
                ac.setName(subcate.getText());
                acs.add(ac);
            }
            acg.setCats(acs);
            list.add(acg);
        }
        CatResponse response=new CatResponse();
        response.setCatGroups(list);
        response.setSuccess(true);
        return JSONObject.fromObject(response);
    }
}
