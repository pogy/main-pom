package com.shigu.daifa.actions;

import com.opentae.common.beans.LogUtil;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.daifa.bo.LoginBO;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @类编号
 * @类名称：DaifaAdminLoginAction
 * @文件路径：com.shigu.daifa.actions.DaifaAdminLoginAction
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/8/12 17:34
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Controller
public class DaifaAdminLoginAction {

    private static final Logger log = LogUtil.getLog(DaifaAdminLoginAction.class);
    /**
     * ====================================================================================
     * @方法名： login
     * @user gzy 2017/8/12 18:08
     * @功能：登录初始化页面
     * @param: [request, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("init/daifaLogin")
    public String login(HttpServletRequest request, Model model){

       // Session session = SecurityUtils.getSubject().getSession();
       // Object object = session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);


        return "daifa/login/login";
    }


    /**
     * ====================================================================================
     * @方法名： login
     * @user gzy 2017/8/12 18:08
     * @功能：提交登录
     * @param: [bo, request, model, session]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping(value = "init/login",method = RequestMethod.GET)
    public String loginPage(){
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {//如果已经登陆，去登陆页面
            return "redirect:/daifa/orderAll.htm";
        }
        return "daifa/login/login";
    }

    @RequestMapping(value = "init/daifa/login",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(LoginBO bo, HttpServletRequest request, HttpSession session){
        JSONObject result = new JSONObject();
        if(StringUtils.isEmpty(bo.getUsername())) {
            return result.element("success",false).element("msg","请输入账号");
        }
        if(StringUtils.isEmpty(bo.getPassword())) {
            return result.element("success",false).element("msg","请输入密码");
        }
        Subject currentUser = SecurityUtils.getSubject();
        CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                bo.getUsername(), bo.getPassword(), false, request.getRemoteAddr(), "");
        token.setRememberMe(true);
        try {
            currentUser.login(token);
            /*if("kf".equals (bo.getUsername())){
                return "redirect:/daifa/orderForServer.htm";//客服售后
            }*/
            return result.element("success",true);
        } catch (AuthenticationException e) {
            //登陆失败
            token.clear();
            return result.element("success",false).element("msg","账号或密码错误");
        }
    }



    /**
     * ====================================================================================
     * @方法名： logout
     * @user gzy 2017/8/12 18:09
     * @功能：登出
     * @param: [session]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping(value = "init/logout",method = RequestMethod.GET)
    public String logout(HttpSession session){

        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "redirect:/init/login.htm";
    }
    
}
