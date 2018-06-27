package com.shigu.sn.action;

import com.openJar.commons.ResponseUtil;
import com.openJar.requests.api.SnBrandRequest;
import com.openJar.requests.api.SnCategoryRequest;
import com.openJar.requests.api.SnCategoryredictRequest;
import com.openJar.responses.api.SnBrandResponse;
import com.openJar.responses.api.SnCategoryResponse;
import com.openJar.responses.api.SnCategoryredictResponse;
import com.shigu.sn.api.service.SnGoodsService;
import com.suning.api.exception.SuningApiException;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api")
public class SnCategoryredictAction {
    @Autowired
    private SnGoodsService snGoodsService;

    @RequestMapping("snCategory")
    @ResponseBody
    public JSONObject getCategory(SnCategoryRequest request) throws SuningApiException{
        SnCategoryResponse response = new SnCategoryResponse();
        response.setSuccess(true);
        response.setCategoryQueryList(snGoodsService.getCategory(request.getUsername()));
        return JSONObject.fromObject(ResponseUtil.dealResponse(response).toString());
    }

    @RequestMapping("snCategoryredict")
    @ResponseBody
    public JSONObject getCategoryredict(SnCategoryredictRequest snCategoryredictRequest) throws SuningApiException{
        SnCategoryredictResponse snCategoryredictResponse = new SnCategoryredictResponse();
        snCategoryredictResponse.setSuccess(true);
        snCategoryredictResponse.setGetCategoryredict(snGoodsService.getCategoryredict(snCategoryredictRequest.getUsername()));
        return JSONObject.fromObject(ResponseUtil.dealResponse(snCategoryredictResponse).toString());
    }

    @RequestMapping("getBrand")
    @ResponseBody
    public JSONObject getBrand(SnBrandRequest snBrandRequest) throws SuningApiException{
        SnBrandResponse response = new SnBrandResponse();
        response.setSuccess(true);
        response.setQueryNewbrand(snGoodsService.getBrand(snBrandRequest.getUsername(),snBrandRequest.getCategoryCode()));
        return JSONObject.fromObject(ResponseUtil.dealResponse(response).toString());
    }
}
