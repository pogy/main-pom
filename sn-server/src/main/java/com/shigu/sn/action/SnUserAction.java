package com.shigu.sn.action;

import com.openJar.commons.ResponseUtil;
import com.openJar.requests.api.SnFreightTemplateRequest;
import com.openJar.requests.api.SnGetProductCodeRequest;
import com.openJar.requests.api.SnShopCategoryRequest;
import com.openJar.responses.api.SnFreightTemplateResponse;
import com.openJar.responses.api.SnGetProductCodeResponse;
import com.openJar.responses.api.SnShopCategoryResponse;
import com.shigu.sn.api.service.SnGoodsService;
import com.shigu.sn.api.service.SnOrderService;
import com.suning.api.exception.SuningApiException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api")
public class SnUserAction {
    @Autowired
    SnOrderService snOrderService;
    @Autowired
    SnGoodsService snGoodsService;

    @RequestMapping("getFreight")
    @ResponseBody
    public JSONObject getFreight(SnFreightTemplateRequest request) throws SuningApiException{
        SnFreightTemplateResponse response=new SnFreightTemplateResponse();
        response.setSuccess(true);
        response.setQueryFreighttemplateList(snOrderService.getFreight(request.getUsername()));
        return JSONObject.fromObject(ResponseUtil.dealResponse(response).toString());
    }

    @RequestMapping("getShopCategory")
    @ResponseBody
    public JSONObject getShopCategory(SnShopCategoryRequest request) throws SuningApiException{
        SnShopCategoryResponse response = new SnShopCategoryResponse();
        response.setSuccess(true);
        response.setSnShopCategories(snGoodsService.selSnCats(request.getUsername()));
        return JSONObject.fromObject(ResponseUtil.dealResponse(response).toString());
    }

    @RequestMapping("getCode")
    @ResponseBody
    public JSONObject getCode(SnGetProductCodeRequest request) throws SuningApiException{
        SnGetProductCodeResponse response=new SnGetProductCodeResponse();
        response.setSuccess(true);
        response.setProductCode(snOrderService.getCode(request.getUsername(),request.getApplyCode()));
        return JSONObject.fromObject(ResponseUtil.dealResponse(response).toString());
    }
}
