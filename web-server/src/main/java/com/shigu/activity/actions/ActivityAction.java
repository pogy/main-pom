package com.shigu.activity.actions;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ActiveDrawGoods;
import com.shigu.activity.service.ActiveDrawService;
import com.shigu.activity.vo.*;
import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawGoodsVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawPemVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawRecordUserVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawShopVo;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 活动
 * Created by zhaohongbo on 17/4/26.
 */
@Controller
public class ActivityAction {

    @Autowired
    private ActiveDrawService activeDrawService;

    /**
     * 发现好货
     * @param model
     * @return
     */
    @RequestMapping(value = "activity/redbull" , method = RequestMethod.GET)
    public String findGodos(HttpSession session, Model model){
        // 当前期次
        ActiveDrawPemVo drawPem = activeDrawService.selNowDrawPem(null);
        // 发现好货商品
        List<ActiveDrawGoodsVo> faGoodsVoList = activeDrawService.selGoodsList(
                drawPem.getId(),
                ActiveDrawGoods.TYPE_FAGOODS,
                20,
                null);
        // 发现好店
        List<ActiveDrawShopVo> faShopVoList = activeDrawService.selShopList(drawPem.getId());
        ActiveDrawStyleVo drawStyleVo = new ActiveDrawStyleVo();
        drawStyleVo.setGoodsList(faGoodsVoList);
        drawStyleVo.setShopList(faShopVoList);

        // 每日发现商品
        List<ActiveDrawGoodsVo> daliyGoodsVoList = activeDrawService.selGoodsList(
                drawPem.getId(),
                ActiveDrawGoods.TYPE_DAILYFIND,
                60,
                null
                );
        // 获奖数据
        List<ActiveDrawRecordUserVo> recordUserVoList = activeDrawService.selDrawRecordList(null,null, "ben");

        // 用户上一期获奖数据
        List<ActiveDrawRecordUserVo> userVoList = new ArrayList<ActiveDrawRecordUserVo>();
        Object object = session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(object != null){
            PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
            ActiveDrawPemVo drawLastPem = activeDrawService.selNowDrawPem(drawPem.getStartTime());
            if(drawLastPem != null){
                // 用户上一期获奖数据
                userVoList = activeDrawService.selDrawRecordList(drawLastPem.getId(),ps.getUserId(), null);
            }
        }

        model.addAttribute("lastUserAward", JSON.toJSONString(userVoList));
        model.addAttribute("styleItem", drawStyleVo);
        model.addAttribute("likeGoodsList", daliyGoodsVoList);
        model.addAttribute("awardList", recordUserVoList);
        model.addAttribute("webSite","hz");
        return "activity/styleHuodong";
    }

    /**
     * 用户中奖记录
     * @param session
     * @return
     */
    @RequestMapping(value = "activity/userWard" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject userWard(HttpSession session){

        ResponseBase rsp = new ResponseBase();

        Object object = session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());

        if(object == null){
            // 未登录
            rsp.setMsg("用户未登陆");
            return JSONObject.fromObject(rsp);
        }

        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        // 当前期次
        ActiveDrawPemVo drawPem = activeDrawService.selNowDrawPem(null);
        // 中奖记录
        List<ActiveDrawRecordUserVo> drawRecordList = activeDrawService.selDrawNowUserRecord(ps.getUserId());

        rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);
        rsp.setData(drawRecordList);

        return JSONObject.fromObject(rsp);
    }
}
