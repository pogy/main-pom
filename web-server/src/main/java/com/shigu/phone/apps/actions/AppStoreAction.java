package com.shigu.phone.apps.actions;

import com.google.gson.JsonObject;
import com.openJar.commons.ResponseUtil;
import com.openJar.requests.app.*;
import com.openJar.responses.app.ShopSearchResponse;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.phone.apps.services.AppStoreService;
import com.shigu.phone.services.PhoneStoreService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by pc on 2017-08-29.
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Controller
@RequestMapping("/app")
public class AppStoreAction {
    private AppStoreService appStoreService;

    @Autowired
    private PhoneStoreService phoneStoreService;
    @Autowired
    public void setAppStoreService(AppStoreService appStoreService) {
        this.appStoreService = appStoreService;
    }
    @RequestMapping("oneShop")
    @ResponseBody
    public JSONObject selOneShopInfo(@Valid OneShopRequest request, BindingResult result) throws Main4Exception {
        if(result.hasErrors()){
           throw new Main4Exception(result.getAllErrors().get(0).getDefaultMessage());
        }
        return JSONObject.fromObject(appStoreService.selOneShopInfo(request));
    }
    @RequestMapping("markets")
    @ResponseBody
    public JSONObject selMarketData(@Valid MarketsRequest request,BindingResult result) throws Main4Exception {
        if(result.hasErrors()){
            throw new Main4Exception(result.getAllErrors().get(0).getDefaultMessage());
        }
        return JSONObject.fromObject(appStoreService.selMarketData(request));
    }
    @RequestMapping("shopCat")
    @ResponseBody
    public JSONObject selShopCat(@Valid ShopCatRequest request,BindingResult result) throws Main4Exception {
        if(result.hasErrors()){
            throw new Main4Exception(result.getAllErrors().get(0).getDefaultMessage());
        }
        return JSONObject.fromObject(appStoreService.selShopCat(request));
    }


    /**
     * 店铺搜索
     * @param request
     * @return
     */
    @RequestMapping("shopSearch")
    @ResponseBody
    public JSONObject shopSearch(ShopSearchRequest request) throws Main4Exception {
        ShopSearchResponse response = phoneStoreService.shopSearch(request);
        return JSONObject.fromObject(response);
    }


    /**
     * 收藏OR取消收藏店铺
     * @param request
     * @return
     */
    @RequestMapping("doStoreCollectRequest")
    @ResponseBody
    public JSONObject doStoreCollectRequest(@Valid DoStoreCollectRequest request, BindingResult bindingResult) {
        return JSONObject.fromObject(phoneStoreService.doStoreCollect(request));
    }

    /**
     * 查询收藏的档口
     * @param request
     * @param bindingResult
     * @return
     */
    @RequestMapping("storeCollect")
    @ResponseBody
    public JSONObject storeCollect(StoreCollectRequest request, BindingResult bindingResult) {
        return JSONObject.fromObject(phoneStoreService.storeCollect(request));
    }
}
