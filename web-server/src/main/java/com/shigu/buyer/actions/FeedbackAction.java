package com.shigu.buyer.actions;

import com.shigu.buyer.services.FeedbackService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("xzPage")
public class FeedbackAction {
    @Autowired
    private FeedbackService feedbackService;


    @RequestMapping("submitFeedback")
    @ResponseBody
    public JSONObject submitFeedback(HttpSession session, String content)throws Exception{
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
//        model.addAttribute("webSite", "hz");
       if (ps == null || ps.getUserId() == null){
           return JsonResponseUtil.error("请先登陆");
        }else{
           if(StringUtils.isEmpty(content)||content.trim().length()>=500){
               return JsonResponseUtil.error("提交失败");
           }
           feedbackService.addFeedback(ps.getUserId(),content.trim());
           return  JsonResponseUtil.success("提交成功");
        }
    }

    @RequestMapping("feedbackV1")
    public String feedbackPage() {
//        model.addAttribute("webSite", "hz");
        return "xzPage/feedbackV1";
    }
}
