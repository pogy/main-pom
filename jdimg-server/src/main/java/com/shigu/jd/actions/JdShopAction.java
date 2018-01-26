package com.shigu.jd.actions;

import com.openJar.beans.JdCategoryAttrValueJos;
import com.openJar.beans.SdkJdImgzoneCategory;
import com.openJar.beans.SdkJdShopCategory;
import com.openJar.commons.ResponseUtil;
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
import net.sf.json.JSONObject;
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
    public JSONObject goodsCanbeUploadedToJdResponse (
            @Valid JdShopCategoryRequest request, BindingResult bindingResult) throws JdAuthOverdueException, OtherCustomException {

        if (bindingResult.hasErrors()) {
            throw new OtherCustomException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        List<SdkJdShopCategory> datas=jdCategoryService.selJdSellercats(request.getJdUid());
        JdShopCategoryResponse res=new JdShopCategoryResponse();
        res.setSuccess(true);
        res.setJdShopCategories(datas);
        return JSONObject.fromObject(ResponseUtil.dealResponse(res).toString());
    }

    @RequestMapping("jdCategoryAttrValueJos")
    @ResponseBody
    public JSONObject goodsCanbeUploadedToJdResponse (
            @Valid JdCategoryAttrValueJosRequest request, BindingResult bindingResult) throws OtherCustomException, JdAuthOverdueException {
        if (bindingResult.hasErrors()) {
            throw new OtherCustomException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        List<JdCategoryAttrValueJos> datas=jdCategoryService.getCategoryReadFindValuesByAttrId(request.getJdUid(),request.getPid());
        JdCategoryAttrValueJosResponse res=new JdCategoryAttrValueJosResponse();
        res.setJdCategoryAttrValueJos(datas);
        res.setSuccess(true);
        return JSONObject.fromObject(ResponseUtil.dealResponse(res).toString());
    }

    @RequestMapping("jdImgzoneCategory")
    @ResponseBody
    public JSONObject selImgCategory(JdImgzoneCategoryRequest request) throws JdAuthOverdueException, OtherCustomException {
        List<SdkJdImgzoneCategory> datas=jdShopService.selImgCategory(request.getJdUid(),request.getImgCategory(),request.getParentCateId());
        JdImgzoneCategoryResponse res=new JdImgzoneCategoryResponse();
        res.setSuccess(true);
        res.setDatas(datas);
        return JSONObject.fromObject(ResponseUtil.dealResponse(res).toString());
    }

    @RequestMapping("jdImgzoneCategoryAdd")
    @ResponseBody
    public JSONObject addImgCategory(JdImgzoneCategoryAddRequest request) throws JdAuthOverdueException, OtherCustomException {
        Long id=jdShopService.addImgCategory(request.getJdUid(),request.getImgCategory(),request.getParentCateId());
        JdImgzoneCategoryAddResponse response=new JdImgzoneCategoryAddResponse();
        response.setSuccess(true);
        response.setImgZoneId(id);
        return JSONObject.fromObject(ResponseUtil.dealResponse(response).toString());
    }

}
