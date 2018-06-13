package com.shigu.sn.action;

import com.openJar.beans.SnAuthInfo;
import com.openJar.beans.SnTokenInfo;
import com.openJar.responses.api.SnAuthInfoResponse;
import com.shigu.exception.AppNotBuyException;
import com.shigu.exception.SnAuthfailExceptin;
import com.shigu.sn.api.service.SnAuthService;
import com.shigu.sn.api.util.SnKeyConfig;
import com.utils.publics.Opt3Des;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class SnAuthAction {
    @Autowired
    SnAuthService snAuthService;

    @RequestMapping("callback")
    public String callback(SnAuthInfo snAuthInfo, Map<String,Object> map) throws SnAuthfailExceptin{
        if(snAuthInfo.getError()!=null){
            map.put("errmsg",snAuthInfo.getErrorDescription());
            return "uperror";
        }
        if(StringUtils.isBlank(snAuthInfo.getCode())){
            return "redirect:http://www.571xz.com";
        }
        SnTokenInfo snTokenInfo;
        try{
            snTokenInfo =snAuthService.getSnTokenInfo(snAuthInfo.getCode());
        }catch (AppNotBuyException e){
            return "redirect:http://fuwu.suning.com/detail/"+ SnKeyConfig.snFuWuId+".html";
        }
        if(snTokenInfo==null){
            throw new SnAuthfailExceptin("授权失败");
        }
        SnAuthInfoResponse snAuthInfoResponse=new SnAuthInfoResponse();
        snAuthInfoResponse.setSuccess(true);
        snAuthInfoResponse.setData(snTokenInfo);
        JSONObject jsonObject = JSONObject.fromObject(snAuthInfoResponse);
        String encryptPlainData = Opt3Des.encryptPlainData(jsonObject.toString());//加密
        return "redirect:http://www.571xz.com/sn/callback.htm?code="+encryptPlainData;
    }
}
