package com.shigu.phone.apps.actions;

import com.google.common.collect.ImmutableSet;
import com.openJar.beans.app.AppCat;
import com.openJar.beans.app.AppCatGroup;
import com.openJar.beans.app.AppSearchNav;
import com.openJar.commons.ResponseUtil;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.CatRequest;
import com.openJar.requests.app.SearchNavRequest;
import com.openJar.requests.app.SitesRequest;
import com.openJar.responses.app.CatResponse;
import com.openJar.responses.app.SearchNavResponse;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.phone.api.enums.PhoneCategoryEnum;
import com.shigu.phone.api.enums.PhoneSearchCategoryEnum;
import com.shigu.phone.apps.services.AppStaticService;
import com.shigu.phone.apps.services.AppStoreService;
import com.shigu.phone.wrapper.WrapperUtil;
import com.shigu.search.services.CategoryInSearchService;
import com.shigu.search.vo.CateNav;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import javax.validation.Valid;
import java.util.*;

@Controller
public class AppStaticAction {
    private static final Logger logger = LoggerFactory.getLogger(AppStaticAction.class);

    private static final Set<String> CATIDS = ImmutableSet.of("16", "30","50011740","50006843");
    private static final Set<String> REMOVEIDS=ImmutableSet.of("50000852","50008897","1629","50001748","50005867","50011130");
    private static final Set<String> SEXCIDS=ImmutableSet.of("50010850","50011277","162116","50000697","121434004","50008904",
                "50008905","50008898","50008899","121412004","50008900","50000671","50008901",
                "162103","50013194","162104","162105","1623","50013196",
                "50011123","50010158","50000557","50010159","50011153","50000436","50025883",
                "50011159","50011161","50010402","50010160","50011165","50011167");
    @Autowired
    AppStaticService appStaticService;


    @RequestMapping("app/sites")
    @ResponseBody
    public JSONObject sites(@Valid SitesRequest request, BindingResult bindingResult){
        return JSONObject.fromObject(appStaticService.selWebSites());
    }

    @RequestMapping("app/cat")
    @ResponseBody
    public JSONObject cat(@Valid CatRequest request, BindingResult bindingResult) {

        return JSONObject.fromObject(appStaticService.getCat(request));

    }

    @RequestMapping("app/searchNav")
    @ResponseBody
    public JSONObject searchNav(@Valid SearchNavRequest request,SearchNavResponse response, BindingResult bindingResult)  {

        return JSONObject.fromObject(appStaticService.getSearchNav(request));
    }
}
