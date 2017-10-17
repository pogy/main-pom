package com.shigu.phone.waps.actions;

import com.openJar.requests.app.MarketsRequest;
import com.openJar.requests.app.OneShopRequest;
import com.openJar.requests.app.ShopCatRequest;
import com.openJar.responses.app.MarketsResponse;
import com.openJar.responses.app.ShopCatResponse;
import com.shigu.phone.wrapper.WrapperUtil;
import net.sf.json.JSONObject;
import com.shigu.phone.apps.services.AppStoreService;
import com.shigu.phone.services.PhoneStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by Admin on 2017/10/13.
 */
@Controller
@RequestMapping("/wap")
public class WapStoreAction {
    private AppStoreService appStoreService;
    @Autowired
    private PhoneStoreService phoneStoreService;
    @Autowired
    public void setAppStoreService(AppStoreService appStoreService) {
        this.appStoreService = appStoreService;
    }

    @RequestMapping("oneShop")
    @ResponseBody
    public JSONObject selOneShopInfo(  String webSite,Long shopId  ) {

        OneShopRequest oneShopRequest = new OneShopRequest();
        oneShopRequest.setShopId(shopId);
        oneShopRequest.setWebSite(webSite);
        return JSONObject.fromObject(appStoreService.selOneShopInfo(oneShopRequest));
    }


    @RequestMapping("shopCat")
    @ResponseBody
    public JSONObject ShopCat( String webSite,Long shopId ){
        ShopCatRequest shopCatRequest = new ShopCatRequest();
        shopCatRequest.getShopId();
        shopCatRequest.getWebSite();
        return JSONObject.fromObject(appStoreService.selShopCat(shopCatRequest));
    }

    @RequestMapping("markets")
    @ResponseBody
    public JSONObject selMarketData(@Valid MarketsRequest request, MarketsResponse response, BindingResult result)  {
        if(result.hasErrors()){
            return WrapperUtil.wrapperOpenException(result.getAllErrors().get(0).getDefaultMessage(),response);
        }
        return JSONObject.fromObject(appStoreService.selMarketData(request));
    }

}
