package com.shigu.phone.apps.actions;

import com.openJar.requests.app.UpToWxRequest;
import com.shigu.phone.services.PhoneGoodsUpService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 类名：AppGoodsUpAction
 * 类路径：com.shigu.phone.apps.actions.AppGoodsUpAction
 * 创建者：王浩翔
 * 创建时间：2017-08-30 9:18
 * 项目：main-pom
 * 描述：app端商品上传
 */
@Controller
@RequestMapping("/app")
public class AppGoodsUpAction {

    @Autowired
    private PhoneGoodsUpService phoneGoodsUpService;

    //todo:token验证
    @RequestMapping("upToWx")
    @ResponseBody
    public JSONObject upToWx(@Valid UpToWxRequest request, BindingResult bindingResult) {
        return JSONObject.fromObject(phoneGoodsUpService.upToWx(request));
    }

}