package com.shigu.phone.apps.actions;

import com.openJar.requests.app.ImgSearchRequest;
import com.openJar.requests.app.ItemSearchRequest;
import com.openJar.requests.app.OneItemRequest;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.phone.services.PhoneGoodsSearchService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 类名：AppGoodsSearchAction
 * 类路径：com.shigu.phone.apps.actions.AppGoodsSearchAction
 * 创建者：王浩翔
 * 创建时间：2017-08-29 14:22
 * 项目：main-pom
 * 描述：App商品搜索
 */
@Controller
@RequestMapping("app/")
public class AppGoodsSearchAction {

    @Autowired
    private PhoneGoodsSearchService phoneGoodsSearchService;

    @RequestMapping("itemSearch")
    @ResponseBody
    public JSONObject itemSearch(ItemSearchRequest request) {
        if (request.getType() == null) {
            //TODO 统一异常处理 OpenException
        }
        if (request.getType() == 1 && request.getCid() ==null) {//1商品库(cid不能为空)

        }
        if (request.getType() == 2 && request.getKeyword() ==null) {//2普通搜索(keywords不为空)

        }
        if (request.getOrderBy() == null) {
            request.setOrderBy(SearchOrderBy.NEW.getValue());
        }
        return JSONObject.fromObject(phoneGoodsSearchService.itemSearch(request));
    }

    @RequestMapping("imgSearch")
    @ResponseBody
    public JSONObject imgSearch(@Valid ImgSearchRequest request,BindingResult bindingResult) {
        if (request.getImgurl() == null) {
            //TODO 异常
        }
        if (request.getWebSite() == null) {
            request.setWebSite("hz");
        }
        return JSONObject.fromObject(phoneGoodsSearchService.imgSearch(request));
    }

    @RequestMapping("oneItem")
    @ResponseBody
    public JSONObject oneItem(@Valid OneItemRequest request, BindingResult bindingResult) {
        return JSONObject.fromObject(phoneGoodsSearchService.oneItem(request));
    }







}
