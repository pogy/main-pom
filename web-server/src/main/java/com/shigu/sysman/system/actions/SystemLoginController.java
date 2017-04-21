package com.shigu.sysman.system.actions;


import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.controller.BackBaseController;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.UserType;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 后台系统登录
 *
 * @author shigu_zjb
 * @date 2017/03/09 11:01
 *
 */
@Controller
public class SystemLoginController extends BackBaseController{

    private static final Logger logger = Logger.getLogger(SystemLoginController.class);

    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "/sysman/system/login" , method = RequestMethod.GET)
    public String loginView(){
        return "sysman/login";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping(value = "sysman/system/loginIn" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(String userName, String password, String valicode, HttpServletRequest request){
        ResponseBase rsp = new ResponseBase();

        if(StringUtils.isEmpty(userName)){
            rsp.setMsg("请输入用户名");
            return JSONObject.fromObject(rsp);
        }
        if(StringUtils.isEmpty(password)){
            rsp.setMsg("请输入密码");
            return JSONObject.fromObject(rsp);
        }

        try{
            Subject currentUser = SecurityUtils.getSubject();
            CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                    userName, password, false, request.getRemoteAddr(), valicode, UserType.SYSTEM);
            token.setRememberMe(true);
            currentUser.login(token);
            if (!currentUser.isAuthenticated())
                token.clear();
            rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);
        } catch (ShiroException e) {
            e.printStackTrace();
            rsp.setMsg("用户名或密码错误");
        } catch (Exception e) {
            e.printStackTrace();
            rsp.setMsg("系统错误");
        }

        return JSONObject.fromObject(rsp);
    }

    /**
     *  登录退出注销
     * @return
     */
    @RequestMapping(value = "/sysman/system/loginout" , method = RequestMethod.GET)
    public String loginout(){
        removeShiroSession();
        return "sysman/login";
    }

}
