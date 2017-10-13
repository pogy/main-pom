package com.shigu.phone.waps.actions;

import com.openJar.requests.app.ImgSpreadRequest;
import com.openJar.requests.app.ItemSpreadRequest;
import com.openJar.responses.app.ImgSpreadResponse;
import com.openJar.responses.app.ItemSpreadResponse;
import com.shigu.phone.apps.services.AppAdvertService;
import com.shigu.phone.wrapper.WrapperUtil;
import com.shigu.spread.enums.SpreadEnum;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Admin on 2017/10/13.
 */
@Controller
@RequestMapping("/wap")
public class WapAdvertAction {
    @Autowired
    AppAdvertService appAdvertService;

    @RequestMapping("imgSpread")
    @ResponseBody
    public JSONObject imgSpread(String code, String webSite){

        ImgSpreadRequest imgSpreadRequest = new ImgSpreadRequest();
        imgSpreadRequest.setSpreadCode(code);
        imgSpreadRequest.setWebSite(webSite);

        ImgSpreadResponse response = new ImgSpreadResponse();


        if(code == null || StringUtils.isEmpty(webSite)){
            return WrapperUtil.wrapperOpenException("缺少参数",response);
        }
        SpreadEnum spread=null;
        for(SpreadEnum spreadEnum:SpreadEnum.values()){
            if(spreadEnum.getCode().equals(code)){
                spread=spreadEnum;
                break;
            }
        }
        if (spread == null) {
            return WrapperUtil.wrapperOpenException("缺少错误:spreadCode="+code,response);
        }
        response=appAdvertService.imgSpread(spread);

        return JSONObject.fromObject(response);
    }


    @RequestMapping("itemSpread")
    @ResponseBody
    public JSONObject itemSpread(String code, String webSite) {
        ItemSpreadRequest request = new ItemSpreadRequest();
        request.setSpreadCode(code);
        request.setWebSite(webSite);
        ItemSpreadResponse response = new ItemSpreadResponse();
        if(request.getSpreadCode() == null || StringUtils.isEmpty(request.getWebSite())){
            return WrapperUtil.wrapperOpenException("缺少参数",response);
        }

        SpreadEnum spread=null;
        for(SpreadEnum spreadEnum:SpreadEnum.values()){
            if(spreadEnum.getCode().equals(request.getSpreadCode())){
                spread=spreadEnum;
                break;
            }
        }
        if (spread == null) {
            return WrapperUtil.wrapperOpenException("缺少错误:spreadCode="+request.getSpreadCode(),response);
        }
        response= appAdvertService.itemSpread(webSite, spread);
        return JSONObject.fromObject(response);
    }
}
