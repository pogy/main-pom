package com.shigu.jd.actions;

import com.openJar.beans.JdPostTemplate;
import com.openJar.beans.JdVenderBrandPubInfo;
import com.openJar.requests.api.GoodsCanbeUploadedToJdRequest;
import com.openJar.requests.api.JdPostTemplateRequest;
import com.openJar.requests.api.JdVenderBrandPubInfoRequest;
import com.openJar.responses.api.JdPostTemplateResponse;
import com.openJar.responses.api.JdVenderBrandPubInfoResponse;
import com.shigu.exceptions.JdAuthOverdueException;
import com.shigu.exceptions.OtherCustomException;
import com.shigu.jd.api.service.JdCategoryService;
import com.shigu.jd.api.service.JdOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created By admin on 2018/1/16/14:21
 */
@Controller
@RequestMapping("api")
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
            @Valid JdVenderBrandPubInfoRequest request , BindingResult bindingResult) throws JdAuthOverdueException, OtherCustomException {

        if (bindingResult.hasErrors()) {
            throw new OtherCustomException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        List<JdVenderBrandPubInfo> datas=jdCategoryService.getAllBrand(request.getJdUid());
        JdVenderBrandPubInfoResponse res = new JdVenderBrandPubInfoResponse();
        res.setSuccess(true);
        res.setJdVenderBrandPubInfos(datas);
        return res;
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
            @Valid JdPostTemplateRequest request , BindingResult bindingResult) throws JdAuthOverdueException, OtherCustomException {
        if (bindingResult.hasErrors()) {
            throw new OtherCustomException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        List<JdPostTemplate> datas=jdOrderService.getPostTemplates(request.getJdUid());
        JdPostTemplateResponse res=new JdPostTemplateResponse();
        res.setSuccess(true);
        res.setJdPostTemplates(datas);
        return res;
    }
}
