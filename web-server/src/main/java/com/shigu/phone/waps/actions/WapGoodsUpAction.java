package com.shigu.phone.waps.actions;

import com.openJar.exceptions.OpenException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.phone.basevo.UploadedItemVO;
import com.shigu.phone.waps.service.WapPhoneGoodsUpService;
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
import java.util.List;

/**
 * 类名：AppGoodsUpAction
 * 类路径：com.shigu.phone.apps.actions.AppGoodsUpAction
 * 创建者：王浩翔
 * 创建时间：2017-08-30 9:18
 * 项目：main-pom
 * 描述：app端商品上传
 */
@Controller
@RequestMapping("datas/")
public class WapGoodsUpAction {

    @Autowired
    private WapPhoneGoodsUpService wapPhoneGoodsUpService;

    /**
     * 查询已上传的商品列表
     * @param session
     * @param type
     * @param index
     * @param size
     * @return
     */
    @RequestMapping("queryUploadedGoodsList")
    @ResponseBody
    public JSONObject queryUploadedGoodsList(HttpSession session,Integer type, Integer index, Integer size){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false).element("stateCode",3);
        }
        List<Integer> types = Arrays.asList(1,2,3);//1所有宝贝，2等待处理的，3淘宝已下架
        if (type == null || !types.contains(type)) {
            return JsonResponseUtil.error("参数错误").element("success",false);
        }
        UploadedItemVO uploadedItemVO = wapPhoneGoodsUpService.uploadedItem(type, index, size, ps.getUserId());
        if (uploadedItemVO == null) {
            return JsonResponseUtil.success().element("success",true).element("hasNext",false).element("total",0);
        }
        return JsonResponseUtil.success().element("success",true)
                .element("hasNext",uploadedItemVO.getHasNext())
                .element("total",uploadedItemVO.getTotal())
                .element("items",uploadedItemVO.getItems());
    }

    /**
     * 上传微信
     * @param session
     * @param webSite
     * @param goodsId
     * @return
     */
    @RequestMapping("upToWx")
    @ResponseBody
    public JSONObject upToWx(HttpSession session,String webSite,Long goodsId) throws OpenException {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false).element("stateCode",3);
        }
        wapPhoneGoodsUpService.upToWx(webSite,goodsId,ps.getUserId());
        return JsonResponseUtil.success().element("success",true).element("upToWx","上传成功");
    }

    /**
     * 下架已上传的商品
     * @param session
     * @param uploadId
     * @return
     * @throws Main4Exception
     * @throws OpenException
     */
    @RequestMapping("instockUploadGoods")
    @ResponseBody
    public JSONObject downGoodsUploaded(HttpSession session,String uploadId) throws Main4Exception, OpenException {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false).element("stateCode",3);
        }
        try {
            wapPhoneGoodsUpService.instockMyItem(uploadId,ps.getUserId());
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
            e.printStackTrace();
            return JsonResponseUtil.error(e.getErrMsg()).element("success",false);
        }
    }
}
