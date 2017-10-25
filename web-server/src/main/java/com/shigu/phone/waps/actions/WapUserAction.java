package com.shigu.phone.waps.actions;

import com.openJar.exceptions.OpenException;
import com.shigu.component.encryption.MD5;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.FileUtil;
import com.shigu.main4.tools.OssIO;

import com.shigu.phone.basebo.BindUserBO;
import com.shigu.phone.basevo.CreatePostSignInfoVO;
import com.shigu.phone.waps.service.WapPhoneUserService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.Rds3TempUser;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Map;

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

    /**
     * 账号密码登录
     * @param pwd
     * @return
     */
    @RequestMapping("accountLogin")
    @ResponseBody
    public JSONObject accountLogin(HttpServletRequest request,String user ,String pwd) {
        Subject currentUser = SecurityUtils.getSubject();
        CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                user, pwd, false, request.getRemoteAddr(), "", UserType.MEMBER);
        //星座用户登陆
        token.setLoginFromType(LoginFromType.XZ);
        token.setRememberMe(true);
        try {
            currentUser.login(token);
            currentUser.hasRole(RoleEnum.STORE.getValue());
            return JsonResponseUtil.success().element("success",true);
        } catch (AuthenticationException e) {
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
    public JSONObject msgCodeLogin(HttpServletRequest request,String telephone ,String msgCode) {
        try {
            wapPhoneUserService.msgCodeLogin(telephone, msgCode, request.getRemoteAddr());
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
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
    public JSONObject userRegist(HttpServletRequest request, String telephone,String msgCode,String pwd){
        try {
            wapPhoneUserService.regist(telephone, msgCode, pwd);
            accountLogin(request,telephone,pwd);//登录
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
            return JsonResponseUtil.error("参数错误").element("success",false);
        }
        try {
            wapPhoneUserService.changePassword(oldPwd,newPwd,ps.getUserId());
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
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
            return JsonResponseUtil.error(e.getErrMsg())
                    .element("success",false);
        }
    }

    @RequestMapping("needBindTelephone")
    @ResponseBody
    public JSONObject needBindTelephone(HttpSession session ) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success", false);
        }
        boolean needBindTelephone = false;
        needBindTelephone = wapPhoneUserService.needBindTelephone(ps.getUserId());
        return JsonResponseUtil.success().element("success",true)
                .element("type",needBindTelephone?0:1);
    }

    @RequestMapping("bindTelephone")
    @ResponseBody
    public JSONObject bindTelephone(HttpSession session,Long telephone,Integer msgCode) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false);
        }
        if (telephone == null) {
            return JsonResponseUtil.error("请输入手机号码").element("success",false);
        }
        if (msgCode == null) {
            return JsonResponseUtil.error("请输入验证码").element("success",false);
        }
        try {
            wapPhoneUserService.bindTelephone(ps.getUserId(),telephone,msgCode);
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
            return JsonResponseUtil.error(e.getMessage()).element("success",false);
        }

    }

    @RequestMapping("bindUser")
    @ResponseBody
    public JSONObject bindUser(HttpSession session,BindUserBO bo) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false);
        }
        try {
            wapPhoneUserService.bindUser(bo);
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
            return JsonResponseUtil.error(e.getMessage()).element("success",false);
        }

    }

    @RequestMapping("getUserLoginState")
    @ResponseBody
    public JSONObject getUserLoginState(HttpSession session) {
        try {
            PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
            if (ps == null || ps.getUserId() == null) {
                return JsonResponseUtil.error("用户未登录").element("success",false);
            }
            //是否是商户
            Subject subject = SecurityUtils.getSubject();
            boolean isStore = subject.hasRole(RoleEnum.STORE.getValue()) || subject.hasRole(RoleEnum.MORE_STORE.getValue());
            return JsonResponseUtil.success().element("success",true)
                                             .element("userId",ps.getUserId())
                                             .element("userType",isStore?2:1);
        } catch (Exception e) {
            return JsonResponseUtil.error("查询失败").element("success",false);
        }
    }

    @RequestMapping("loginOut")
    @ResponseBody
    public JSONObject loginOut(HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false);
        }
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return JsonResponseUtil.success().element("success",true);
    }

    @RequestMapping("getUserData")
    @ResponseBody
    public JSONObject getUserData(HttpSession session,String userId) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false);
        }
        Map<String, Object> otherPlatform = ps.getOtherPlatform();
        String bingdTelephone = null;
        if (otherPlatform != null) {
            bingdTelephone = (String) otherPlatform.get("__bindPhone__");
        }
        return JsonResponseUtil.success().element("success",true)
                                         .element("headUrl",ps.getHeadUrl())
                                         .element("userNick",ps.getUserNick())
                                         .element("phoneBind",bingdTelephone);
    }

    /**
     * 修改用户头像
     * @param session
     * @param headerImg base64图片
     * @return
     *<b>request payload<b/>
     *<a href="http://blog.csdn.net/mhmyqn/article/details/25561535"></a>
     */
    @RequestMapping("postHeaderImg")
    @ResponseBody
    public JSONObject imgUpload(HttpSession session,String headerImg,HttpServletRequest request) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success", false);
        }

        //解析文件
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = request.getReader();) {
            char[]buff = new char[1024];
            int len;
            while((len = reader.read(buff)) != -1) {
                sb.append(buff,0, len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        headerImg = (String)JSONObject.fromObject(sb.toString()).get("headerImg");
//        headerImg = headerImg.replace("/","\\/");

        if (StringUtil.isNull(headerImg)) {
            return JsonResponseUtil.error("该图片不支持上传").element("success", false);
        }
        byte[] bytes = Base64.decodeBase64(headerImg);
//        byte[] bytes = Base64.getDecoder().decode(headerImg);
        InputStream inputStream = new ByteArrayInputStream(bytes);

        String imgType = FileUtil.getFileType(inputStream);
        if (!FileUtil.imgTypes.contains(imgType.toLowerCase())) {
            return JsonResponseUtil.error("该图片不支持上传").element("success", false);
        }
        String filePath = "mall/appfile/headImg-"+ MD5.encrypt(String.valueOf(ps.getUserId())).toUpperCase()+"."+imgType;
        //上传头像
        String headerImgSrc = ossIO.uploadFile(inputStream, filePath);

        //修改头像
        try {
            wapPhoneUserService.imgUpload(ps.getUserId(),headerImgSrc);
            return JsonResponseUtil.success().element("sucess",true).element("headerImgSrc",headerImgSrc);
        } catch (OpenException e) {
            e.printStackTrace();
            return JsonResponseUtil.error("修改用户头像失败").element("success", false);
        }
    }

    @RequestMapping("getPostSignInfo")
    @ResponseBody
    public JSONObject createPostSignInfo(HttpSession session, HttpServletResponse response) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false);
        }

         //指定允许其他域名访问
        response.setHeader("Access-Control-Allow-Origin","*");
        // 响应类型
        response.setHeader("Access-Control-Allow-Methods","POST");
        // 响应头设置
        response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
        try {
            CreatePostSignInfoVO postSignInfo = wapPhoneUserService.createPostSignInfo();
            return JsonResponseUtil.success().element("success",true)
                    .element("postSignInfo",postSignInfo);
        } catch (OpenException e) {
            return JsonResponseUtil.error("获取授权失败").element("success",false);
        }

    }


}
