package com.shigu.phone.apps.actions;

import com.openJar.requests.app.ImgSearchRequest;
import com.openJar.requests.app.ItemSearchRequest;
import com.openJar.requests.app.OneItemRequest;
import com.openJar.responses.app.ImgSearchResponse;
import com.openJar.responses.app.ItemSearchResponse;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.phone.apps.services.PhoneGoodsSearchService;
import com.shigu.phone.wrapper.WrapperUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

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
    public JSONObject itemSearch(@Valid ItemSearchRequest request, ItemSearchResponse response, BindingResult bindingResult) {
        List<Integer> types = Arrays.asList(1,2,3);
        if (!types.contains(request.getType())){
            return WrapperUtil.wrapperOpenException("参数错误",response);
        }
        if (request.getType() == null) {
            return WrapperUtil.wrapperOpenException("参数错误",response);
        }
        if (request.getType() == 1 && request.getCid() ==null) {//1商品库(cid不能为空)
            return WrapperUtil.wrapperOpenException("参数错误",response);
        }
        if (request.getType() == 2 && StringUtils.isEmpty(request.getKeyword())) {//2普通搜索(keywords不为空)
            return WrapperUtil.wrapperOpenException("参数错误",response);
        }
        if (request.getType() == 3 && StringUtils.isEmpty(request.getStoreId())) {//3店铺(storeId不为空)
            return WrapperUtil.wrapperOpenException("参数错误",response);
        }
        if (StringUtils.isEmpty(request.getOrderBy())) {
            request.setOrderBy(SearchOrderBy.GOODS_COMMON.getValue());
        }
        if (StringUtils.isEmpty(request.getWebSite())) {
            request.setWebSite("hz");
        }
        if (request.getIndex() == null) {
            request.setIndex(1);
        }
        if (request.getSize() == null || request.getSize() > 30) {
            request.setSize(30);
        }
        return JSONObject.fromObject(phoneGoodsSearchService.itemSearch(request));
    }

    @RequestMapping("imgSearch")
    @ResponseBody
    public JSONObject imgSearch(@Valid ImgSearchRequest request, ImgSearchResponse response, BindingResult bindingResult) {
        if (request.getImgurl() == null) {
            return WrapperUtil.wrapperOpenException("参数错误",response);
        }
        if (request.getWebSite() == null) {
            request.setWebSite("hz");
        }
        return JSONObject.fromObject(phoneGoodsSearchService.imgSearch(request));
    }

    @RequestMapping("oneItem")
    @ResponseBody
    public JSONObject oneItem(@Valid OneItemRequest request, BindingResult bindingResult) {
        if (request.getWebSite() == null) {
            request.setWebSite("hz");
        }
        return JSONObject.fromObject(phoneGoodsSearchService.oneItem(request));
    }







}
