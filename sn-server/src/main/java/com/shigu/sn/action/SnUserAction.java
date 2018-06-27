package com.shigu.sn.action;

import com.openJar.commons.ResponseUtil;
import com.openJar.requests.api.SnFreightTemplateRequest;
import com.openJar.responses.api.SnFreightTemplateResponse;
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

    @RequestMapping("getFreight")
    @ResponseBody
    public JSONObject getFreight(SnFreightTemplateRequest request) throws SuningApiException{
        SnFreightTemplateResponse response=new SnFreightTemplateResponse();
        response.setSuccess(true);
        response.setQueryFreighttemplateList(snOrderService.getFreight(request.getUsername()));
        return JSONObject.fromObject(ResponseUtil.dealResponse(response).toString());
    }
}
