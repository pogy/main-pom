package com.shigu.jd.actions;

import com.openJar.requests.api.GoodsCanbeUploadedToJdRequest;
import com.openJar.requests.api.JdCategoryAttrValueJosRequest;
import com.openJar.requests.api.JdShopCategoryRequest;
import com.openJar.responses.api.GoodsCanbeUploadedToJdResponse;
import com.openJar.responses.api.JdCategoryAttrValueJosResponse;
import com.openJar.responses.api.JdShopCategoryResponse;
import com.shigu.jd.api.service.JdCategoryService;
import com.shigu.jd.api.service.JdGoodsService;
import com.shigu.jd.api.service.JdShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created By admin on 2018/1/16/14:05
 */
@Controller
@RequestMapping("shopApi")
public class JdShopAction {

    @Autowired
    private JdCategoryService jdCategoryService;


    @RequestMapping("jdShopCategory")
    @ResponseBody
    public JdShopCategoryResponse goodsCanbeUploadedToJdResponse (
            @Valid JdShopCategoryRequest request,
            JdShopCategoryResponse response, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            response.setSuccess(false);
            return response;
        }
        return jdCategoryService.getJdSellercats(request.getJdUid());
    }

    @RequestMapping("JdCategoryAttrValueJos")
    @ResponseBody
    public JdCategoryAttrValueJosResponse goodsCanbeUploadedToJdResponse (
            @Valid JdCategoryAttrValueJosRequest request,
            JdCategoryAttrValueJosResponse response, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            response.setSuccess(false);
            return response;
        }
        return jdCategoryService.getCategoryReadFindValuesByAttrId(request.getJdUid(),request.getPid());
    }

}
