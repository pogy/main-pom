package com.shigu.phone.waps.actions;

import com.openJar.beans.app.AppMarket;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.OneShopRequest;
import com.openJar.requests.app.ShopCatRequest;
import com.openJar.requests.app.ShopSearchRequest;
import com.shigu.phone.waps.service.WapPhoneStoreService;
import com.shigu.phone.waps.service.WapStoreService;
import com.shigu.phone.wrapper.WrapperUtil;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by Admin on 2017/10/13.
 */
@Controller
@RequestMapping("/wap")
public class WapStoreAction {
    @Autowired
    private WapStoreService wapStoreService;
    @Autowired
    private WapPhoneStoreService wapPhoneStoreService;

    @RequestMapping("oneShop")
    @ResponseBody
    public JSONObject selOneShopInfo(  String webSite,Long shopId  ) {

        OneShopRequest oneShopRequest = new OneShopRequest();
        oneShopRequest.setShopId(shopId);
        oneShopRequest.setWebSite(webSite);
        return JSONObject.fromObject(wapStoreService.selOneShopInfo(oneShopRequest));
    }


    @RequestMapping("queryShopCategory")
    @ResponseBody
    public JSONObject ShopCat( String webSite,Long shopId ){
        return JsonResponseUtil.success().element("cats",wapStoreService.selShopCat(webSite,shopId));
    }

    @RequestMapping("getMarketList")
    @ResponseBody
    public JSONObject selMarketData(Long mid,String webSite)  {
        try {
            AppMarket appMarket = wapStoreService.selMarketData(mid, webSite);
            return JsonResponseUtil.success().element("market",appMarket);
        } catch (OpenException e) {
            return JsonResponseUtil.error(e.getErrMsg());
        }
    }


    /**
     * 查询店铺列表
     * @param keyword
     * @param webSite
     * @param index
     * @param size
     * @return
     */
    @RequestMapping(" queryShopList")
    @ResponseBody
    public JSONObject shopSearch(String keyword, String webSite,Integer index,Integer size) {
        if(StringUtils.isEmpty(webSite)){
           webSite = "hz";
        }
        if (StringUtils.isEmpty(keyword)) {
            keyword = "";
        }
        if (index == null) {
            index = 1;
        }
        if (size == null) {
            size = 30;
        }
        return JSONObject.fromObject(wapPhoneStoreService.shopSearch(keyword,webSite,index,size));
    }



}
