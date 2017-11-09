package com.shigu.phone.waps.actions;

import com.openJar.exceptions.OpenException;
import com.opentae.data.mall.beans.ShiguGoodsCollect;
import com.opentae.data.mall.beans.ShiguStoreCollect;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.phone.basevo.BaseCollectItemVO;
import com.shigu.phone.waps.service.WapItemService;
import com.shigu.phone.waps.service.WapPhoneCdnService;
import com.shigu.phone.waps.service.WapPhoneStoreService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * Created by Admin on 2017/10/13.
 */
@Controller
@RequestMapping("datas/")
public class WapItemAction {
    @Autowired
    private WapItemService wapItemService;
    @Autowired
    private WapPhoneStoreService wapPhoneStoreService;
    @Autowired
    private WapPhoneCdnService wapPhoneCdnService;

    @RequestMapping("queryGoodsCollectList")
    @ResponseBody
    public JSONObject itemCollect(HttpSession session,Integer size,Integer index,String webSite){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false).element("stateCode",3);
        }
        if (size == null) {
            size = 1;
        }
        if (index == null || index > 30) {
            index = 30;
        }
        if (StringUtil.isNull(webSite))webSite = null;
        try {
            BaseCollectItemVO baseCollectItemVO = wapItemService.selItemCollect(ps.getUserId(), index, size,webSite);
            return JsonResponseUtil
                    .success()
                    .element("success",true)
                    .element("hasNext",baseCollectItemVO.getHasNext())
                    .element("total",baseCollectItemVO.getTotal())
                    .element("items",baseCollectItemVO.getItems());
        } catch (OpenException e) {
            e.printStackTrace();
            return JsonResponseUtil.error(e.getErrMsg()).element("success",false);
        }
    }

    @RequestMapping("deleteCollect")
    @ResponseBody
    public JSONObject delItemCollect (HttpSession session,String type,Long[] collectIds){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false).element("stateCode",3);
        }
        if ("goods".equalsIgnoreCase(type)){//取消收藏商品
            wapItemService.delItemCollect(Arrays.asList(collectIds),ps.getUserId());
            return JsonResponseUtil.success().element("success",true);
        }else if("shop".equalsIgnoreCase(type)){//取消收藏店铺
            wapPhoneStoreService.delStoreCollect(Arrays.asList(collectIds),ps.getUserId());
            return JsonResponseUtil.success().element("success",true);
        }else{
            return JsonResponseUtil.error("参数错误").element("success",false);
        }
    }

    @RequestMapping("addCollect")
    @ResponseBody
    public JSONObject addCollect (HttpSession session,String type,Long id,String webSite){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null ||ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false).element("stateCode",3);
        }
        try {
            if ("goods".equalsIgnoreCase(type)){//收藏商品
                ShiguGoodsCollect shiguGoodsCollect = wapPhoneCdnService.collectItem(ps.getUserId(), null, id, webSite);
                return JsonResponseUtil.success().element("success",true).element("collectId",shiguGoodsCollect.getGoodsCollectId());
            }else if("shop".equalsIgnoreCase(type)){//收藏店铺
                ShiguStoreCollect shiguStoreCollect = wapPhoneStoreService.collectStore( ps.getUserId(),id);
                return JsonResponseUtil.success().element("success",true).element("collectId",shiguStoreCollect.getStoreCollectId());
            }else{
                return JsonResponseUtil.error("参数错误").element("success",false);
            }
        } catch (OpenException e) {
            e.printStackTrace();
            return JsonResponseUtil.error(e.getErrMsg()).element("success",false);
        }
    }

    /**
     * 查询收藏状态
     * @return
     */
    @RequestMapping("hasCollected")
    @ResponseBody
    public JSONObject hasCollected(String userId,String type,String id,HttpSession session){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false).element("stateCode",3);
        }
        try {
            Long collectId;
            if ("goods".equalsIgnoreCase(type)){//商品
                collectId = wapItemService.hasCollected(id,ps.getUserId());
            }else if("shop".equalsIgnoreCase(type)){//店铺
                collectId = wapPhoneStoreService.hasCollected(id,ps.getUserId());
            }else{
                return JsonResponseUtil.error("参数错误").element("success",false);
            }
            return JsonResponseUtil.success().element("success",true).element("collectId",collectId);
        } catch (OpenException e) {
            e.printStackTrace();
            return JsonResponseUtil.error(e.getErrMsg()).element("success",false);
        }
    }
}
