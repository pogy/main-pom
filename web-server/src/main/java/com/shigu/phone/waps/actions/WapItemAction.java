package com.shigu.phone.waps.actions;

import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.GoodsCollectRequest;
import com.openJar.responses.app.GoodsCollectResponse;
import com.shigu.phone.basevo.BaseCollectItemVO;
import com.shigu.phone.waps.service.WapItemService;
import com.shigu.phone.waps.service.WapPhoneStoreService;
import com.shigu.phone.waps.service.WapStoreService;
import com.shigu.phone.wrapper.WrapperUtil;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Admin on 2017/10/13.
 */
@Controller
@RequestMapping("/wap")
public class WapItemAction {
    @Autowired
    private WapItemService wapItemService;
    @Autowired
    private WapPhoneStoreService wapPhoneStoreService;

    @RequestMapping("queryGoodsCollectList")
    @ResponseBody
    public JSONObject itemCollect(HttpSession session,Integer size,Integer index){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps.getUserId() == null) {
            return JsonResponseUtil.error("userId si null");
        }
        try {
            BaseCollectItemVO baseCollectItemVO = wapItemService.collectItem(ps.getUserId(), index, size);
            return JsonResponseUtil
                    .success()
                    .element("hasNext",baseCollectItemVO.getHasNext())
                    .element("total",baseCollectItemVO.getTotal())
                    .element("items",baseCollectItemVO.getItems());
        } catch (OpenException e) {
            return JsonResponseUtil.error(e.getErrMsg());
        }
    }

    @RequestMapping("deleteCollect")
    @ResponseBody
    public JSONObject delItemCollect (HttpSession session,String type,List<Long> collectIds){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps.getUserId() == null) {
            return JsonResponseUtil.error("userId is null");
        }
        if ("goods".equalsIgnoreCase(type)){//取消收藏商品
            wapItemService.delItemCollect(collectIds,ps.getUserId());
            return JsonResponseUtil.success();
        }else if("shop".equalsIgnoreCase(type)){//取消收藏店铺
            wapPhoneStoreService.delStoreCollect(collectIds,ps.getUserId());
            return JsonResponseUtil.success();
        }else{
            return JsonResponseUtil.error("type can not be resolved");
        }
    }

    /**
     * 商品收藏/取消收藏
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
        return JSONObject.fromObject(response);
    }
}
