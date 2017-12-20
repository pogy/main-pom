package com.shigu.phone.waps.actions;

import com.openJar.exceptions.OpenException;
import com.shigu.api.exceptions.SystemException;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.FileUtil;
import com.shigu.main4.spread.bo.TrademarkApplyBO;
import com.shigu.main4.spread.service.TrademarkService;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.phone.api.enums.ImgFormatEnum;
import com.shigu.phone.apps.utils.ImgUtils;
import com.shigu.phone.apps.utils.TokenUtil;
import com.shigu.phone.basebo.BindUserBO;
import com.shigu.phone.basebo.TrademarkRegistBO;
import com.shigu.phone.basevo.UserWinningInfo;
import com.shigu.phone.waps.service.WapPhoneUserService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Admin on 2017/10/13.
 */
@Controller
@RequestMapping("datas/")
public class WapUserAction {
    @Autowired
    private WapPhoneUserService wapPhoneUserService;
    @Autowired
    private OssIO ossIO;
    @Autowired
    TrademarkService trademarkService;
    @Autowired
    private RedisIO redisIO;

    /**
     * 账号密码登录
     * @param pwd
     * @return
     */
    @RequestMapping("accountLogin")
    @ResponseBody
    public JSONObject accountLogin(String user ,String pwd,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
        Subject currentUser = SecurityUtils.getSubject();
        CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                user, pwd, false, request.getRemoteAddr(), "", UserType.MEMBER);
        //星座用户登陆
        token.setLoginFromType(LoginFromType.XZ);
        token.setRememberMe(true);
        try {
            currentUser.login(token);
            PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
            if(wapPhoneUserService.needBindTelephone(ps.getUserId())){
                return JsonResponseUtil.success().element("success",true).element("bindTel",true);//老用户，没绑定手机
            }

            currentUser.hasRole(RoleEnum.STORE.getValue());
            return JsonResponseUtil.success().element("success",true);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            //登陆失败
            token.clear();
            return JsonResponseUtil.error("账号或密码错误").element("success",false);
        }
    }

    /**
     * 短信验证码登录
     * @param request
     * @param telephone
     * @param msgCode
     * @return
     */
    @RequestMapping("msgCodeLogin")
    @ResponseBody
    public JSONObject msgCodeLogin(HttpServletRequest request,String telephone ,String msgCode,HttpSession session) {
        try {
            wapPhoneUserService.msgCodeLogin(telephone, msgCode, request.getRemoteAddr());
            PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
            if(wapPhoneUserService.needBindTelephone(ps.getUserId())){
                return JsonResponseUtil.success().element("success",true).element("bindTel",true);
            }
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
            e.printStackTrace();
            return JsonResponseUtil.error(e.getErrMsg()).element("success",false);
        }
    }

    /**
     * 获取手机验证码
     * @return
     */
    @RequestMapping("getPhoneMsgCode")
    @ResponseBody
    public JSONObject getPhoneMsgCode(Long telephone,Integer type) {
        try {
            wapPhoneUserService.getPhoneMsg(String.valueOf(telephone),type);
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
            e.printStackTrace();
            return JsonResponseUtil.error(e.getErrMsg())
                                    .element("success",false);
        }

    }

    /**
     * 注册
     * @return
     */
    @RequestMapping("userRegist")
    @ResponseBody
    public JSONObject userRegist(HttpServletRequest request, String telephone,String msgCode,String pwd) throws IOException {
        try {
            wapPhoneUserService.regist(telephone, msgCode, pwd);
            Subject currentUser = SecurityUtils.getSubject();
            CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                    telephone, pwd, false, request.getRemoteAddr(), "", UserType.MEMBER);
            //星座用户登陆
            token.setLoginFromType(LoginFromType.XZ);
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            } catch (AuthenticationException e) {
                e.printStackTrace();
                //登陆失败
                token.clear();
                return JsonResponseUtil.error("登录异常").element("success",false);
            }
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
            return JsonResponseUtil.error(e.getErrMsg())
                    .element("success",false);
        }
    }


    @RequestMapping("changePassword")
    @ResponseBody
    public JSONObject ChangePassword(HttpSession session,String newPwd,String oldPwd) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false).element("stateCode",3);
        }
        try {
            wapPhoneUserService.changePassword(oldPwd,newPwd,ps.getUserId());
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
            e.printStackTrace();
            return JsonResponseUtil.error(e.getErrMsg()).element("success",false);
        }
    }




    @RequestMapping("forgetPassword")
    @ResponseBody
    public JSONObject ForgetPassword(String msgCode,String newPwd,String telephone) {
        try {
            wapPhoneUserService.forgetPassword(telephone,msgCode,newPwd);
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
            e.printStackTrace();
            return JsonResponseUtil.error(e.getErrMsg())
                    .element("success",false);
        }
    }

    @RequestMapping("bindTelephone")
    @ResponseBody
    public JSONObject bindTelephone(HttpSession session,Long telephone,Integer msgCode,String tempId) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (telephone == null) {
            return JsonResponseUtil.error("请输入手机号码").element("success",false);
        }
        if (msgCode == null) {
            return JsonResponseUtil.error("请输入验证码").element("success",false);
        }
        try {
            if (ps != null) {//不是第三方
                if (ps.getUserId() == null) {
                    return JsonResponseUtil.error("用户未登录").element("success",false).element("stateCode",3);
                }
                wapPhoneUserService.bindTelephone(ps.getUserId(),telephone,msgCode);
                return JsonResponseUtil.success().element("success",true);
            }
            JSONObject otherPlatform = JSONObject.fromObject(redisIO.get("otherLogin_info"+tempId));
            Object userNickObj = otherPlatform.get("userNick");
            if (StringUtil.isNull(tempId)) {
                return JsonResponseUtil.error("参数错误").element("success",false);
            }
            BindUserBO bo = new BindUserBO();
            bo.setUserNick((String)userNickObj);
            bo.setTempId((String)otherPlatform.get("tempId"));
            bo.setType((String)otherPlatform.get("type"));
            bo.setTelephone(String.valueOf(telephone));
            bo.setCode(String.valueOf(msgCode));
            wapPhoneUserService.bindUser(bo);
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
            e.printStackTrace();
            return JsonResponseUtil.error(e.getMessage()).element("success",false);
        }
    }

    @RequestMapping("getUserLoginState")
    @ResponseBody
    public JSONObject getUserLoginState(HttpSession session) {
        try {
            PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
            if (ps == null || ps.getUserId() == null) {
                return JsonResponseUtil.success().element("success",true);
            }
            //是否是商户
            Subject subject = SecurityUtils.getSubject();
            boolean isStore = subject.hasRole(RoleEnum.STORE.getValue()) || subject.hasRole(RoleEnum.MORE_STORE.getValue());
            return JsonResponseUtil.success().element("success",true)
                                             .element("userId",ps.getUserId())
                                             .element("userType",isStore?2:1);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResponseUtil.error("查询失败").element("success",false);
        }
    }

    @RequestMapping("loginOut")
    @ResponseBody
    public JSONObject loginOut(HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false).element("stateCode",3);
        }
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return JsonResponseUtil.success().element("success",true);
    }

    @RequestMapping("getUserData")
    @ResponseBody
    public JSONObject getUserData(HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false).element("stateCode",3);
        }
        Map<String, Object> otherPlatform = ps.getOtherPlatform();
        String bingdTelephone = null;
        if (otherPlatform != null) {
            bingdTelephone = (String) otherPlatform.get("__bindPhone__");
        }
        return JsonResponseUtil.success().element("success",true)
                                         .element("headUrl",ImgUtils.formatImg(ps.getHeadUrl(), ImgFormatEnum.HEAD))
                                         .element("userNick",ps.getUserNick())
                                         .element("phoneBind",bingdTelephone);
    }

    /**
     * 修改用户头像
     * @param session
     * @return
     */
    @RequestMapping("postHeaderImg")
    @ResponseBody
    public JSONObject imgUpload(HttpSession session, HttpServletRequest request) throws IOException, FileUploadException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success", false).element("stateCode",3);
        }

        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  //转换成多部分request
        MultipartFile item = null;
        for(Map.Entry<String, MultipartFile> entry : multiRequest.getFileMap().entrySet()){
            item = entry.getValue();  //取得上传文件
            break;
        }
        byte[] bytes = item.getBytes();
        String imgType = FileUtil.getFileType(bytes);

        if (!FileUtil.imgTypes.contains(imgType.toLowerCase())) {
            return JsonResponseUtil.error("该图片不支持上传").element("success", false);
        }
        String filePath = "tmp/headImg-"+ UUID.randomUUID().toString().toUpperCase()+"."+imgType;//UUID可能会生成包含tem的

        try {
            //上传头像
            String headerImgSrc = ossIO.uploadFile(bytes, filePath);
            //修改头像
            wapPhoneUserService.imgUpload(ps.getUserId(),headerImgSrc);
            ps.setHeadUrl(headerImgSrc.replace("tmp","mall/head"));//修改缓存头像
            return JsonResponseUtil.success().element("success",true).element("headerImgSrc",ImgUtils.formatImg(ps.getHeadUrl(), ImgFormatEnum.HEAD));
        } catch (OpenException e) {
            e.printStackTrace();
            return JsonResponseUtil.error("修改用户头像失败").element("success", false);
        }
    }

    /**
     * 商标注册提交信息
     * @param session
     * @param bo
     * @return
     */
    @RequestMapping("submitRegeditInfo")
    @ResponseBody
    public JSONObject submitRegeditInfo(HttpSession session, TrademarkRegistBO bo){
        Long userId;
        if (!StringUtil.isNull(bo.getToken())) {
            try {
                userId = TokenUtil.parseUserId(bo.getToken(),redisIO);
            } catch (SystemException e) {
                return JsonResponseUtil.error(e.getErrMsg()).element("success", false);
            }
        }else{
            PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
            if (ps == null || ps.getUserId() == null) {
                return JsonResponseUtil.error("用户未登录").element("success", false).element("stateCode",3);
            }
            userId = ps.getUserId();
        }

        TrademarkApplyBO trademarkApplyBO = new TrademarkApplyBO();
        trademarkApplyBO.setName(bo.getUserName());
        trademarkApplyBO.setTelephone(bo.getUserTele());
        trademarkApplyBO.setType(bo.getType());
        trademarkApplyBO.setDetailText(bo.getAskFor());
        trademarkService.giveInfoToServer(userId,trademarkApplyBO);
        return JsonResponseUtil.success().element("success",true);
    }

    /**
     * 中奖结果
     * @param session
     * @return
     */
    @RequestMapping("getUserWinningInfoList")
    @ResponseBody
    public JSONObject getUserWinningInfoList(HttpSession session,String token) throws OpenException {
        Long userId;
        if (!StringUtil.isNull(token)) {
            try {
                userId = TokenUtil.parseUserId(token,redisIO);
            } catch (SystemException e) {
                return JsonResponseUtil.error(e.getErrMsg()).element("success", false);
            }
        }else{
            PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
            if (ps == null || ps.getUserId() == null) {
                return JsonResponseUtil.error("用户未登录").element("success", false).element("stateCode",3);
            }
            userId = ps.getUserId();
        }
        List<UserWinningInfo> userWinningInfoList = wapPhoneUserService.getUserWinningInfoList(userId);
        return JsonResponseUtil.success().element("success",true).element("userWinningInfoList",userWinningInfoList);
    }

}
