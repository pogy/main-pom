package com.shigu.sn.action;

import com.openJar.commons.ResponseUtil;
import com.openJar.requests.img.SnImgAddRequest;
import com.openJar.responses.img.SnImgAddResponse;
import com.shigu.sn.api.service.SnImgService;
import com.suning.api.exception.SuningApiException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api")
public class SnImageAction {

    @Autowired
    SnImgService snImgService;

    @RequestMapping("imgAdd")
    @ResponseBody
    public JSONObject imgAdd(SnImgAddRequest request) throws SuningApiException{
        SnImgAddResponse response=new SnImgAddResponse();
        response.setSuccess(true);
        response.setAddNPics(snImgService.getSnImg(request.getUsername(),request.getPicContent()));
        return JSONObject.fromObject(ResponseUtil.dealResponse(response).toString());
    }
}
