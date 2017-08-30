package com.shigu.phone.apps.actions;

import com.openJar.commons.ResponseUtil;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.MarketsRequest;
import com.openJar.requests.app.OneShopRequest;
import com.openJar.requests.app.ShopCatRequest;
import com.openJar.requests.app.ShopSearchRequest;
import com.openJar.responses.app.OneShopResponse;
import com.openJar.responses.app.ShopSearchResponse;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.phone.apps.services.AppStoreService;
import com.shigu.phone.services.PhoneSearchService;
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
    private PhoneSearchService phoneSearchService;

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
        return JSONObject.fromObject(ResponseUtil.dealResponse(appStoreService.selOneShopInfo(request)));
    }
    @RequestMapping("markets")
    @ResponseBody
    public JSONObject selMarketData(@Valid MarketsRequest request,BindingResult result) throws Main4Exception {
        if(result.hasErrors()){
            throw new Main4Exception(result.getAllErrors().get(0).getDefaultMessage());
        }
        return JSONObject.fromObject(ResponseUtil.dealResponse(appStoreService.selMarketData(request)));
    }
    @RequestMapping("shopCat")
    @ResponseBody
    public JSONObject selShopCat(@Valid ShopCatRequest request,BindingResult result) throws Main4Exception {
        if(result.hasErrors()){
            throw new Main4Exception(result.getAllErrors().get(0).getDefaultMessage());
        }
        return JSONObject.fromObject(ResponseUtil.dealResponse(appStoreService.selShopCat(request)));
    }


    /**
     * 店铺搜索
     * @param request
     * @return
     */
    @RequestMapping("shopSearch")
    @ResponseBody
    public JSONObject shopSearch(ShopSearchRequest request) {
        ShopSearchResponse response = phoneSearchService.shopSearch(request);
        return JSONObject.fromObject(response);
    }
}
