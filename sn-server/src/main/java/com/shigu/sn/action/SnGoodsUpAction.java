package com.shigu.sn.action;

import com.openJar.commons.ResponseUtil;
import com.openJar.requests.api.SnItemAddRequest;
import com.openJar.requests.api.SnItemParametersRequest;
import com.openJar.responses.api.SnItemAddResponse;
import com.openJar.responses.api.SnItemParametersResponse;
import com.shigu.sn.api.service.SnGoodsService;
import com.suning.api.entity.item.ItemAddResponse;
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
        ItemAddResponse itemAddResponse=snGoodsService.getItemAdd(request.getUsername(),request.getSnGood());
        if(itemAddResponse.getSnerror()!=null){
            response.setErrmsg(itemAddResponse.getSnerror().getErrorCode());
        }else {
            response.setApplyParams(response.getApplyParams());
        }
        return JSONObject.fromObject(ResponseUtil.dealResponse(response).toString());
    }

    @RequestMapping("getItem")
    @ResponseBody
    public JSONObject getItem(SnItemParametersRequest request) throws SuningApiException{
        SnItemParametersResponse response=new SnItemParametersResponse();
        response.setSuccess(true);
        response.setItemparametersQueries(snGoodsService.getItem(request.getUsername(),request.getCategoryCode()));
        return JSONObject.fromObject(ResponseUtil.dealResponse(response).toString());
    }
}
