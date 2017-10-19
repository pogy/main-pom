package com.shigu.phone.waps.actions;

import com.google.common.collect.ImmutableSet;
import com.openJar.beans.app.AppCat;
import com.openJar.beans.app.AppCatGroup;
import com.openJar.beans.app.AppSearchNav;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.CatRequest;
import com.openJar.requests.app.SearchNavRequest;
import com.openJar.responses.app.CatResponse;
import com.openJar.responses.app.SearchNavResponse;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.phone.api.enums.PhoneCategoryEnum;
import com.shigu.phone.api.enums.PhoneSearchCategoryEnum;
import com.shigu.phone.waps.service.WapStaticService;
import com.shigu.phone.waps.vo.ParentCatVO;
import com.shigu.phone.waps.vo.SubCatVO;
import com.shigu.phone.wrapper.WrapperUtil;
import com.shigu.search.services.CategoryInSearchService;
import com.shigu.search.vo.CateNav;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/wap")
public class WapStaticAction {
    private static final Set<String> CATIDS = ImmutableSet.of("16", "30","50011740","50006843");
    private static final Set<String> REMOVEIDS=ImmutableSet.of("50000852","50008897","1629","50001748","50005867","50011130");
    private static final Set<String> SEXCIDS=ImmutableSet.of("50010850","50011277","162116","50000697","121434004","50008904",
                "50008905","50008898","50008899","121412004","50008900","50000671","50008901",
                "162103","50013194","162104","162105","1623","50013196",
                "50011123","50010158","50000557","50010159","50011153","50000436","50025883",
                "50011159","50011161","50010402","50010160","50011165","50011167");
    @Autowired
    WapStaticService wapStaticService;
    @Autowired
    CategoryInSearchService categoryInSearchService;

    @RequestMapping("getWebSites")
    @ResponseBody
    public JSONObject sites(){
        return JsonResponseUtil.success().element("sites",wapStaticService.selWebSites());
    }

    @RequestMapping("getGoodsCatList")
    @ResponseBody
    public JSONObject cat(String webSite,Integer type) {
        List<AppCatGroup> appCatGroups = wapStaticService.selCat(webSite, type);
        if (appCatGroups == null){
            return JsonResponseUtil.error("未查询到数据");
        }
        return JsonResponseUtil.success().element("catGroups",appCatGroups);
    }

    @RequestMapping("queryParentCatList")
    @ResponseBody
    public JSONObject queryParentCatList(String webSite) {
        List<ParentCatVO> list = null;
        try {
            list = wapStaticService.queryParentCatList(webSite);
            return JsonResponseUtil.success().element("catGroups",list);
        } catch (OpenException e) {
            return JsonResponseUtil.error(e.getErrMsg());
        }
    }

    @RequestMapping("querySubCatList")
    @ResponseBody
    public JSONObject querySubCatList(String webSite,String pid) {
        Integer parentId = null;
        try {
            parentId = Integer.valueOf(pid);
        } catch (NumberFormatException e) {
            return JsonResponseUtil.error("pid can not be format to Integer [pid = "+pid+"]");
        }
        List<SubCatVO> list = null;
        try {
            list = wapStaticService.querySubCatList(webSite,parentId);
            return JsonResponseUtil.success().element("subCats",list);
        } catch (OpenException e) {
            return JsonResponseUtil.error(e.getErrMsg());
        }

    }




    @RequestMapping("searchNav")
    @ResponseBody
    public JSONObject searchNav(Integer type,Long sid,String webSite)  {
        wapStaticService.searchNav(type, sid, webSite);
        return null;
    }
}
