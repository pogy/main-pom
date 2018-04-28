package com.shigu.photo.actions;

import com.shigu.photo.process.PhotoUserProcess;
import com.shigu.photo.service.PhotoUserService;
import com.shigu.photo.service.PhotoWorksService;
import com.shigu.photo.vo.PhotoUserVO;
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
 * 路径: com.shigu.photo.actions.PhotoUserAction
 * 工程: main-pom
 * 时间: 18-4-27 下午6:59
 * 创建人: wanghaoxiang
 * 描述:
 */
@Controller
public class PhotoUserAction {

    @Autowired
    private PhotoUserService photoUserService;

    @Autowired
    private PhotoWorksService photoWorksService;

    /**
     * 用户认证页面
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("userValidate")
    public String userValidate(HttpSession session, Model model) {
        Long userId = ((PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue())).getUserId();
        model.addAttribute("userInfo", photoUserService.baseUserInfo(userId));
        //风格
        model.addAttribute("styleList",photoWorksService.selStyleListWithUser(userId));
        return "photo/userValidate";
    }


    @RequestMapping("getUserValidMsgCode")
    @ResponseBody
    public JSONObject getUserValidMsgCode(String telephone, HttpSession session) {
        if (StringUtils.isBlank(telephone)) {
            return JsonResponseUtil.error("请输入手机号");
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null) {
            return JsonResponseUtil.error("请先登陆");
        }
        if (ps.getUserId() == null) {
            return JsonResponseUtil.error("请先绑定星座网帐号");
        }
        photoUserService.sendValidCodeMsg(ps.getUserId(),telephone);
        return JsonResponseUtil.success();
    }


    @RequestMapping("userValidSubmit")
    @ResponseBody
    public JSONObject userValidSubmit() {
        return null;
    }
}
