package com.shigu.jd.actions;

import com.openJar.beans.JdCategoryAttrValueJos;
import com.openJar.beans.SdkJdImgzoneCategory;
import com.openJar.beans.SdkJdShopCategory;
import com.openJar.requests.api.JdCategoryAttrValueJosRequest;
import com.openJar.requests.api.JdImgzoneCategoryAddRequest;
import com.openJar.requests.api.JdImgzoneCategoryRequest;
import com.openJar.requests.api.JdShopCategoryRequest;
import com.openJar.responses.api.JdCategoryAttrValueJosResponse;
import com.openJar.responses.api.JdImgzoneCategoryAddResponse;
import com.openJar.responses.api.JdImgzoneCategoryResponse;
import com.openJar.responses.api.JdShopCategoryResponse;
import com.shigu.exceptions.JdAuthOverdueException;
import com.shigu.exceptions.OtherCustomException;
import com.shigu.jd.api.service.JdCategoryService;
import com.shigu.jd.api.service.JdShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created By admin on 2018/1/16/14:05
 */
@Controller
@RequestMapping("api")
public class JdShopAction {

    @Autowired
    private JdCategoryService jdCategoryService;
    @Autowired
    private JdShopService jdShopService;

    @RequestMapping("jdShopCategory")
    @ResponseBody
    public JdShopCategoryResponse goodsCanbeUploadedToJdResponse (
            @Valid JdShopCategoryRequest request, BindingResult bindingResult) throws JdAuthOverdueException, OtherCustomException {

        if (bindingResult.hasErrors()) {
            throw new OtherCustomException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        List<SdkJdShopCategory> datas=jdCategoryService.selJdSellercats(request.getJdUid());
        JdShopCategoryResponse res=new JdShopCategoryResponse();
        res.setSuccess(true);
        res.setJdShopCategories(datas);
        return res;
    }

    @RequestMapping("jdCategoryAttrValueJos")
    @ResponseBody
    public JdCategoryAttrValueJosResponse goodsCanbeUploadedToJdResponse (
            @Valid JdCategoryAttrValueJosRequest request, BindingResult bindingResult) throws OtherCustomException, JdAuthOverdueException {
        if (bindingResult.hasErrors()) {
            throw new OtherCustomException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        List<JdCategoryAttrValueJos> datas=jdCategoryService.getCategoryReadFindValuesByAttrId(request.getJdUid(),request.getPid());
        JdCategoryAttrValueJosResponse res=new JdCategoryAttrValueJosResponse();
        res.setJdCategoryAttrValueJos(datas);
        res.setSuccess(true);
        return res;
    }

    @RequestMapping("jdImgzoneCategory")
    @ResponseBody
    public JdImgzoneCategoryResponse selImgCategory(JdImgzoneCategoryRequest request) throws JdAuthOverdueException, OtherCustomException {
        List<SdkJdImgzoneCategory> datas=jdShopService.selImgCategory(request.getJdUid(),request.getImgCategory(),request.getParentCateId());
        JdImgzoneCategoryResponse res=new JdImgzoneCategoryResponse();
        res.setSuccess(true);
        res.setDatas(datas);
        return res;
    }

    @RequestMapping("jdAuthedInfo")
    @ResponseBody
    public JdImgzoneCategoryAddResponse addImgCategory(JdImgzoneCategoryAddRequest request) throws JdAuthOverdueException, OtherCustomException {
        Long id=jdShopService.addImgCategory(request.getJdUid(),request.getImgCategory(),request.getParentCateId());
        JdImgzoneCategoryAddResponse response=new JdImgzoneCategoryAddResponse();
        response.setSuccess(true);
        response.setImgZoneId(id);
        return response;
    }

}
