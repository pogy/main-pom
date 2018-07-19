package com.shigu.buyer.actions;

import com.shigu.buyer.bo.RegistBO;
import com.shigu.buyer.bo.RegistVerifyBO;
import com.shigu.buyer.services.InviteService;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.component.shiro.exceptions.LoginAuthException;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.services.MemberInviteService;
import com.shigu.main4.ucenter.services.RegisterAndLoginService;
import com.shigu.main4.ucenter.vo.RegisterUser;
import com.shigu.services.SendMsgService;
import com.shigu.session.main4.PhoneVerify;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.tools.RedomUtil;
import com.shigu.tools.VerifyUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 注册类服务,用户注册、开店申请
 * Created by zhaohongbo on 17/3/2.
 */
@Controller
public class RegistAction {
    private static final Logger logger = Logger.getLogger(RegistAction.class);

    @Autowired
    SendMsgService sendMsgService;

    @Autowired
    RegisterAndLoginService registerAndLoginService;

    @Autowired
    InviteService inviteService;

    /**
     * 用户注册
     *
     * @return
     */
    @RequestMapping(value = "regedit", method = RequestMethod.GET)
    public String regedit(String inviteCode, Model model) {
        if (StringUtils.isNotBlank(inviteCode)) {
            model.addAttribute("inviteCode", inviteCode);
        }
        return "login/regedit";
    }

    /**
     * 验证码图片
     */
    @RequestMapping("IMG")
    public void img(HttpSession session, HttpServletResponse response) throws IOException {
        String code= RedomUtil.redomNumber(4);
        BufferedImage img= VerifyUtil.creatVerifyImg(code);
        ImageIO.write(img, "JPEG", response.getOutputStream());
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0L);
        response.setContentType("image.jpeg");
        session.setAttribute(SessionEnum.SEND_REGISTER_MSG.getValue(),code);
    }

    /**
     * 注册手机验证
     * @return
     */
    @RequestMapping("getMsgCode")
    @ResponseBody
    public JSONObject registPhoneVerification(@Valid RegistVerifyBO bo, BindingResult result, HttpSession session) throws JsonErrException {
        if(result.hasErrors()){
            throw new JsonErrException(result.getAllErrors().get(0).getDefaultMessage()).addErrMap("ele", "msgValidate");
        }
        //如果手机已经被注册,直接返回
        if(!registerAndLoginService.userCanRegist(bo.getTelephone(),LoginFromType.PHONE)){
            throw new JsonErrException("手机号已经注册，请尝试直接使用手机登录").addErrMap("ele", "telephone");
        }
        String imgcode= (String) session.getAttribute(SessionEnum.SEND_REGISTER_MSG.getValue());
        if(imgcode==null||!imgcode.equals(bo.getImgValidate())){//图片验证通不过
            throw new JsonErrException("图片验证码不正确").addErrMap("ele", "msgValidate");
        }
        String code=RedomUtil.redomNumber(6);
        sendMsgService.sendVerificationCode(bo.getTelephone(),code);
//        //System.out.println(code);
        session.setAttribute(SessionEnum.PHONE_REGISTER_MSG.getValue(),new PhoneVerify(bo.getTelephone(),code));
        return JsonResponseUtil.success();
    }

    /**
     * 用户注册信息提交
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "regedit", method = RequestMethod.POST)
    public JSONObject jsonregeditSubmit(@Valid RegistBO bo, BindingResult result, HttpSession session,
                                        HttpServletRequest request) throws JsonErrException {
        if(result.hasErrors()){
            return JsonResponseUtil.error(result.getAllErrors().get(0).getDefaultMessage());
            //throw new JsonErrException(result.getAllErrors().get(0).getDefaultMessage());
        }
        //认证手机
        PhoneVerify pv= (PhoneVerify) session.getAttribute(SessionEnum.PHONE_REGISTER_MSG.getValue());
        if(!bo.getTelephone().equals(pv.getPhone())||!bo.getMsgValidate().equals(pv.getVerify())){
            return JsonResponseUtil.error("手机验证码错误").element("ele", "msgValidate");
            //throw new JsonErrException("手机验证码错误").addErrMap("ele", "msgValidate");
        }
        RegisterUser registerUser=new RegisterUser();
        registerUser.setPassword(bo.getPassword());
        registerUser.setTelephone(bo.getTelephone());
        String inviteCode = bo.getInviteCode();
        if (StringUtils.isNotBlank(inviteCode)) {
            //有邀请码时验证邀请码
            Long invitedUserId = inviteService.findUserByInviteCode(inviteCode);
            if (invitedUserId == null) {
                return JsonResponseUtil.error("邀请码错误");
            }
            registerUser.setInviteUserId(invitedUserId);
        }
        Long userId = null;
        try {
            userId = registerAndLoginService.registerByPhone(registerUser);
            if(userId ==null){
                return JsonResponseUtil.error("用户已经存在");
                //throw new JsonErrException("用户已经存在");
            }
        } catch (Main4Exception e) {
            return JsonResponseUtil.error(e.getMessage()).element("ele","telephone");
            //throw new JsonErrException(e.getMessage()).addErrMap("ele","telephone");
        }
        //成功以后,需要登陆一下
        Subject currentUser = SecurityUtils.getSubject();
        CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                bo.getTelephone(), bo.getPassword(), false, request.getRemoteAddr(), "", UserType.MEMBER);
        //星座用户登陆
        token.setLoginFromType(LoginFromType.PHONE);
        token.setRememberMe(true);
        try {
            currentUser.login(token);
        } catch (LoginAuthException e) {
            logger.error("注册成功后,自动登陆失败",e);
        }
        Long outUid = registerAndLoginService.selOutUidByUid(userId);
        JSONObject jsonObject = JsonResponseUtil.success().element("OK", "OK");
        if (outUid != null) {
            jsonObject.element("id",outUid.toString());
        }
        return jsonObject;
    }

    /**
     * 隐私政策
     */
    @RequestMapping("privacy")
    public String privacy(Model model){
        model.addAttribute("webSite", "hz");
        return "login/privacy";
    }

    /**
     * 服务条款
     */
    @RequestMapping("contract")
    public String contract(Model model){
        model.addAttribute("webSite", "hz");
        return "login/contract";
    }

}
