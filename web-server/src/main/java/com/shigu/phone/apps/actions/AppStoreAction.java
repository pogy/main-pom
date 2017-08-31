package com.shigu.phone.apps.actions;

import com.openJar.commons.ResponseUtil;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.MarketsRequest;
import com.openJar.requests.app.DoStoreCollectRequest;
import com.openJar.requests.app.OneShopRequest;
import com.openJar.requests.app.ShopCatRequest;
import com.openJar.requests.app.ShopSearchRequest;
import com.openJar.responses.app.OneShopResponse;
import com.openJar.responses.app.ShopSearchResponse;
import com.shigu.main4.cdn.bo.ScStoreBO;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.vo.ShopCollect;
import com.shigu.phone.apps.services.AppStoreService;
import com.shigu.phone.services.PhoneGoodsSearchService;
import com.shigu.phone.services.PhoneSearchService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

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
    private PhoneGoodsSearchService phoneGoodsSearchService;
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
    public JSONObject shopSearch(ShopSearchRequest request) throws Main4Exception {
        ShopSearchResponse response = phoneSearchService.shopSearch(request);
        return JSONObject.fromObject(response);
    }
    /**
     * 按主键删除店铺收藏
     * @return collectIds 收藏记录ID的集合
     */
    @RequestMapping("delShopCollection")
    @ResponseBody
    public JSONObject delShopCollection(DoStoreCollectRequest  request) throws Main4Exception {

        boolean result=phoneGoodsSearchService.delShopCollection(request.getUserId(),request.getCollectId());
        if (result){
            return JSONObject.fromObject("删除成功");
        }
        return JSONObject.fromObject("删除失败");
    }

    /**
     * 添加店铺收藏
     * @param userId
     * @param bo 收藏店铺
     * @return
     */
    @RequestMapping("addShopCollection")
    @ResponseBody
    public JSONObject addShopCollection(DoStoreCollectRequest  request) throws Main4Exception {
        ScStoreBO bo = new ScStoreBO();
        bo.setStore_id(request.getStore_id());
        boolean result=phoneGoodsSearchService.addShopCollect(request.getUserId(),bo);
        if (result){
            return JSONObject.fromObject("添加成功");
        }
        return JSONObject.fromObject("添加失败");
    }
}
