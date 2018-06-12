package com.shigu.sn.action;

import com.openJar.beans.SnAuthInfo;
import com.openJar.beans.SnTokenInfo;
import com.shigu.exception.AppNotBuyException;
import com.shigu.exception.SnAuthfailExceptin;
import com.shigu.sn.api.service.SnAuthService;
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
            return "redirect:";
        }
        if(snTokenInfo==null){
            throw new SnAuthfailExceptin("授权失败");
        }
        return "redirect:http://www.571xz.com/sn/callback.htm";
    }
}
