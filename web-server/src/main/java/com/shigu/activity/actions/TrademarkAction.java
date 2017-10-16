package com.shigu.activity.actions;

import com.shigu.main4.spread.bo.TrademarkApplyBO;
import com.shigu.main4.spread.service.TrademarkService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 类名：TrademarkAction
 * 类路径：com.shigu.activity.actions.TrademarkAction
 * 创建者：王浩翔
 * 创建时间：2017-10-13 17:17
 * 项目：main-pom
 * 描述：
 */
@Controller
public class TrademarkAction {

    @Autowired
    TrademarkService trademarkService;

    @RequestMapping("giveInfoToServer")
    @ResponseBody
    public JSONObject giveInfoToServer(TrademarkApplyBO bo, HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        trademarkService.giveInfoToServer(ps.getUserId(),bo);
        return JsonResponseUtil.success();
    }

    @RequestMapping("bqsqIndex")
    public String bqsqIndex(){
        return "xzSearch/bqsqIndex";
    }
}
