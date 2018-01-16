package com.shigu.jd.actions;

import com.openJar.requests.api.GoodsCanbeUploadedToJdRequest;
import com.openJar.requests.api.JdPostTemplateRequest;
import com.openJar.requests.api.JdVenderBrandPubInfoRequest;
import com.openJar.responses.api.JdPostTemplateResponse;
import com.openJar.responses.api.JdVenderBrandPubInfoResponse;
import com.shigu.jd.api.service.JdCategoryService;
import com.shigu.jd.api.service.JdOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created By admin on 2018/1/16/14:21
 */
@Controller
@RequestMapping("userApi")
public class JdUserAction {

    @Autowired
    private JdCategoryService jdCategoryService;

    @Autowired
    private JdOrderService jdOrderService;

    /**
     * 获取用户所拥有的品牌
     * @param request
     * @param bindingResult
     * @return
     */
    @RequestMapping("jdVenderBrandPubInfo")
    @ResponseBody
    public JdVenderBrandPubInfoResponse jdVenderBrandPubInfo (
            @Valid JdVenderBrandPubInfoRequest request , BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            JdVenderBrandPubInfoResponse response = new JdVenderBrandPubInfoResponse();
            response.setSuccess(false);
            return response;
        }
        return jdCategoryService.getAllBrand(request.getJdUid());
    }

    /**
     * 获取用户所拥有的品牌
     * @param request
     * @param bindingResult
     * @return
     */
    @RequestMapping("jdPostTemplate")
    @ResponseBody
    public JdPostTemplateResponse JdPostTemplate (
            @Valid JdPostTemplateRequest request , BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            JdPostTemplateResponse response = new JdPostTemplateResponse();
            response.setSuccess(false);
            return response;
        }
        return jdOrderService.getPostTemplates(request.getJdUid());
    }
}
