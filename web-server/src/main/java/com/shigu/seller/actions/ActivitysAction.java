package com.shigu.seller.actions;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.seller.bo.ActivityApplyBO;
import com.shigu.seller.services.ActivityService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 *
 * 最新活动
 * Created by bugzy on 2017/6/30 0030.
 */
@Controller
@RequestMapping("seller/")
public class ActivitysAction {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("actRegister")
    public String actRegister(HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        model.addAttribute("activities", activityService.selAllActivities(ps.getUserId()));
        return "seller/actRegister";
    }

    @RequestMapping("actDetails")
    public String actDetails(Long actid, Model model) {
        if (actid == null) {
            return "redirect:/seller/actRegister.htm";
        }

        model.addAttribute("actDetails", activityService.selActivityDetails(actid));
        return "seller/actDetails";
    }

    @RequestMapping("applyGoodsLists")
    @ResponseBody
    public JSONObject applyItems(Long actid, HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        return JsonResponseUtil.success().element("applyGoodsLists", activityService.applyItems(actid, ps.getUserId()));
    }

    @RequestMapping("submitInputInfo")
    @ResponseBody
    public JSONObject submitInputInfo(Long actid, String inputInfo, HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ActivityApplyBO bo = com.alibaba.fastjson.JSONObject.parseObject(inputInfo, ActivityApplyBO.class);
        activityService.submitApply(actid, ps.getLogshop().getShopId(), ps.getUserId(), StringUtils.join(bo.getActivityInfo(), ","), bo.getPhoneInfo());
        return JsonResponseUtil.success();
    }

}
