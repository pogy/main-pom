package com.shigu.sn.action;

import com.openJar.commons.ResponseUtil;
import com.openJar.requests.api.SnItemAddRequest;
import com.openJar.responses.api.SnItemAddResponse;
import com.shigu.sn.api.service.SnGoodsService;
import com.suning.api.exception.SuningApiException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api")
public class SnGoodsUpAction {

    @Autowired
    SnGoodsService snGoodsService;

    @RequestMapping("itemAdd")
    @ResponseBody
    public JSONObject itemAdd(SnItemAddRequest request) throws SuningApiException{
        SnItemAddResponse response=new SnItemAddResponse();
        response.setSuccess(true);
        response.setApplyParams(snGoodsService.getItemAdd(request.getUsername(),request.getSnGood()));
        return JSONObject.fromObject(ResponseUtil.dealResponse(response).toString());
    }
}
