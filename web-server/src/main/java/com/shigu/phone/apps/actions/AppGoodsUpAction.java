package com.shigu.phone.apps.actions;

import com.openJar.requests.app.InstockMyItemRequest;
import com.openJar.requests.app.UpToWxRequest;
import com.openJar.requests.app.UploadedItemRequest;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.phone.apps.services.PhoneGoodsUpService;
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

    @RequestMapping("upToWx")
    @ResponseBody
    public JSONObject upToWx(@Valid UpToWxRequest request, BindingResult bindingResult) throws Main4Exception {
        if(bindingResult.hasErrors()){
            throw new Main4Exception(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return JSONObject.fromObject(phoneGoodsUpService.upToWx(request));
    }

    @RequestMapping("uploadedItem")
    @ResponseBody
    public JSONObject uploadedItem(@Valid UploadedItemRequest request, BindingResult bindingResult) throws Main4Exception {
        if(bindingResult.hasErrors()){
            throw new Main4Exception(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        if (request.getIndex() == null) {
            request.setIndex(1);
        }
        if (request.getSize() == null || request.getSize() > 30) {
            request.setSize(30);
        }
        return JSONObject.fromObject(phoneGoodsUpService.uploadedItem(request));
    }
    @RequestMapping("instockMyItem")
    @ResponseBody
    public JSONObject instockMyItem(@Valid InstockMyItemRequest request, BindingResult bindingResult) throws Main4Exception {
        if(bindingResult.hasErrors()){
            throw new Main4Exception(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return JSONObject.fromObject(phoneGoodsUpService.instockMyItem(request));
    }
}
