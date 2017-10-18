package com.shigu.phone.waps.actions;

import com.openJar.beans.app.AppMarket;
import com.openJar.exceptions.OpenException;
import com.shigu.phone.basevo.OneShopVO;
import com.shigu.phone.waps.service.WapPhoneStoreService;
import com.shigu.phone.waps.service.WapStoreService;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("queryShopData")
    @ResponseBody
    public JSONObject selOneShopInfo(String webSite,Long shopId ) {
        try {
            OneShopVO oneShopVO = wapStoreService.selOneShopInfo(shopId, webSite, null);
            return JsonResponseUtil.success().element("cats",oneShopVO);
        } catch (OpenException e) {
           return JsonResponseUtil.error(e.getErrMsg());
        }
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
    @RequestMapping("queryShopList")
    @ResponseBody
    public JSONObject shopSearch(String keyword, String webSite,Integer index,Integer size) {
        return JsonResponseUtil.success().element("",wapPhoneStoreService.shopSearch(keyword,webSite,index,size));
    }



}
