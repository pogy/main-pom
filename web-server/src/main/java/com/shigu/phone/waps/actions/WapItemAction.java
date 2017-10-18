package com.shigu.phone.waps.actions;

import com.openJar.requests.app.DelItemCollectRequest;
import com.openJar.requests.app.GoodsCollectRequest;
import com.openJar.requests.app.ItemCollectRequest;
import com.openJar.responses.app.DelItemCollectResponse;
import com.openJar.responses.app.GoodsCollectResponse;
import com.openJar.responses.app.ItemCollectResponse;
import com.shigu.main4.tools.RedisIO;
import com.shigu.phone.apps.services.AppItemService;
import com.shigu.phone.wrapper.WrapperUtil;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Admin on 2017/10/13.
 */
@Controller
@RequestMapping("/wap")
public class WapItemAction {
    @Autowired
    private AppItemService appItemService;

    @Autowired
    private RedisIO redisIO;


    @RequestMapping("itemCollect")
    @ResponseBody
    public JSONObject itemCollect(HttpSession session,Integer size,Integer index){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ItemCollectRequest request = new ItemCollectRequest();
        request.setIndex(index);
        request.setSize(size);
        request.setUserId(ps.getUserId());
        ItemCollectResponse response = new ItemCollectResponse();
        if (ps.getUserId() == null) {
            return WrapperUtil.wrapperOpenException("userId si null",response);
        }
        if (index == null)request.setIndex(1);
        if (size == null)request.setSize(30);
        response= appItemService.collectItem(request);
        return JSONObject.fromObject(response);
    }
    @RequestMapping("delItemCollect")
    @ResponseBody
    public JSONObject delItemCollect (HttpSession session,String collectIds){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String token = redisIO.get("phone_login_token" + ps.getUserId());
        DelItemCollectRequest request = new DelItemCollectRequest();
        DelItemCollectResponse response = new DelItemCollectResponse();
        request.setCollectIds(collectIds);
        request.setToken(token);
        request.setUserId(ps.getUserId());
        if (ps.getUserId() == null || StringUtils.isEmpty(collectIds)
                || StringUtils.isEmpty(token)) {
            return WrapperUtil.wrapperOpenException("参数错误",response);
        }
        response= appItemService.delItemCollect(request);
        return JSONObject.fromObject(response);
    }

    /**
     * 商品收藏/取消收藏
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("goodsCollect")
    @ResponseBody
    public JSONObject goodsCollect(HttpSession session,Long goodsId,Long storeId){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        GoodsCollectRequest request = new GoodsCollectRequest();
        GoodsCollectResponse response = new GoodsCollectResponse();
        request.setGoodsId(goodsId);
        request.setStoreId(storeId);
        request.setUserId(ps.getUserId());

        if (goodsId== null|| storeId == null || ps.getUserId() == null) {
            return WrapperUtil.wrapperOpenException("参数错误",response);
        }
        response=appItemService.collectGoods(request);
        return JSONObject.fromObject(response);
    }
}
