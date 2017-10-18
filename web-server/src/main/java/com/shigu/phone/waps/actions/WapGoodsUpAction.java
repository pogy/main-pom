package com.shigu.phone.waps.actions;

import com.openJar.requests.app.UpToWxRequest;
import com.openJar.requests.app.UploadedItemRequest;
import com.openJar.responses.app.UploadedItemResponse;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.tools.RedisIO;
import com.shigu.phone.apps.services.PhoneGoodsUpService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 类名：AppGoodsUpAction
 * 类路径：com.shigu.phone.apps.actions.AppGoodsUpAction
 * 创建者：王浩翔
 * 创建时间：2017-08-30 9:18
 * 项目：main-pom
 * 描述：app端商品上传
 */
@Controller
@RequestMapping("/wap")
public class WapGoodsUpAction {

    @Autowired
    private PhoneGoodsUpService phoneGoodsUpService;
    @Autowired
    private RedisIO redisIO;

    @RequestMapping("queryUploadedGoodsList")
    @ResponseBody
    public JSONObject uploadedItem(HttpSession session,Integer type, Integer index, Integer size){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        UploadedItemRequest request=new UploadedItemRequest();
        request.setIndex(index);
        request.setSize(size);
        request.setType(type);
        request.setUserId(ps.getUserId());
        UploadedItemResponse res=phoneGoodsUpService.uploadedItem(request);
        return JSONObject.fromObject(res);
    }


    @RequestMapping("upToWx")
    @ResponseBody
    public JSONObject upToWx(HttpSession session, String webSite,Long goodsId) {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String token = redisIO.get("phone_login_token" + ps.getUserId());
        UpToWxRequest upToWxRequest = new UpToWxRequest();
        upToWxRequest.setGoodsId(goodsId);
        upToWxRequest.setToken(token);
        upToWxRequest.setUserId(ps.getUserId());
        upToWxRequest.setWebSite(webSite);
        return JSONObject.fromObject(phoneGoodsUpService.upToWx(upToWxRequest));
    }

    @RequestMapping("instockUploadGoods")
    @ResponseBody
    public JSONObject instockMyItem(HttpSession session,String uploadId) throws Main4Exception {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        InstockMyItemRequest request = new InstockMyItemRequest();
        request.setUploadId(uploadId);
        request.setUserId(ps.getUserId());
        return JSONObject.fromObject(phoneGoodsUpService.instockMyItem(request));
    }
}
