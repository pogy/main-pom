package com.shigu.phone.waps.actions;

import com.google.common.collect.ImmutableSet;
import com.openJar.beans.app.AppCatGroup;
import com.openJar.exceptions.OpenException;
import com.shigu.phone.basevo.MarketsVO;
import com.shigu.phone.waps.service.WapStaticService;
import com.shigu.phone.waps.vo.ParentCatVO;
import com.shigu.phone.waps.vo.SubCatVO;
import com.shigu.search.services.CategoryInSearchService;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("datas/")
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
        return JsonResponseUtil.success().element("success",true).element("sites",wapStaticService.selWebSites());
    }

    @RequestMapping("getGoodsCatList")
    @ResponseBody
    public JSONObject cat(String webSite,Integer pid) {
        if (pid != null && pid == 30) {
            pid = 1;
        }
        if (pid != null && pid == 16) {
            pid = 2;
        }
        List<AppCatGroup> appCatGroups = wapStaticService.selCat(webSite, pid);
        if (appCatGroups == null){
            return JsonResponseUtil.error("未查询到数据").element("success",false);
        }
        return JsonResponseUtil.success().element("success",true).element("catGroups",appCatGroups);
    }

    @RequestMapping("queryParentCatList")
    @ResponseBody
    public JSONObject queryParentCatList(String webSite) {
        List<ParentCatVO> list = null;
        try {
            list = wapStaticService.queryParentCatList(webSite);
            return JsonResponseUtil.success().element("success",true).element("catGroups",list);
        } catch (OpenException e) {
            e.printStackTrace();
            return JsonResponseUtil.error(e.getErrMsg()).element("success",false);
        }
    }

    @RequestMapping("querySubCatList")
    @ResponseBody
    public JSONObject querySubCatList(String webSite,String pid) {
        Integer parentId = null;
        try {
            parentId = Integer.valueOf(pid);
        } catch (NumberFormatException e) {
            return JsonResponseUtil.error("参数错误 [pid = "+pid+"]").element("success",false);
        }
        List<SubCatVO> list = null;
        try {
            list = wapStaticService.querySubCatList(webSite,parentId);
            return JsonResponseUtil.success().element("success",true).element("subCats",list);
        } catch (OpenException e) {
            e.printStackTrace();
            return JsonResponseUtil.error(e.getErrMsg()).element("success",false);
        }

    }

    @RequestMapping("queryMarketListByPid")
    @ResponseBody
    public JSONObject queryMarketListByPid(String pid,String webSite)  {
        try {
            List<MarketsVO> vos = wapStaticService.queryMarketListByPid(pid,webSite);
            return JsonResponseUtil.success().element("success",true).element("markets",vos);
        } catch (OpenException e) {
            e.printStackTrace();
            return JsonResponseUtil.error(e.getErrMsg()).element("success",false);
        }
    }
}
