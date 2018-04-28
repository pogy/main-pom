package com.shigu.photo.actions;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.photo.bo.PhotoUserProfileEditBO;
import com.shigu.photo.bo.PhotoUserValidBO;
import com.shigu.photo.process.PhotoUserProcess;
import com.shigu.photo.service.PhotoUserService;
import com.shigu.photo.service.PhotoWorksService;
import com.shigu.photo.vo.PhotoAreaVO;
import com.shigu.photo.vo.PhotoAuthWorkUserInfoWebVO;
import com.shigu.photo.vo.PhotoUserVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("userValidate")
    public String userValidate(HttpSession session, Model model) {
        Long userId = ((PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue())).getUserId();
        model.addAttribute("userInfo", photoUserService.baseUserInfo(userId));
        model.addAttribute("styleList", photoWorksService.selStyleListWithUser(userId));
        return "photo/userValidate";
    }

    /**
     * getUserValidMsgCode.json 获取用户认证短信验证码
     * changePhotoTeleGetMsgCode.json 获取更换手机短信验证码
     *
     * @param telephone 手机号码
     * @param session
     * @return
     */
    @RequestMapping({"getUserValidMsgCode", "changePhotoTeleGetMsgCode"})
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
        photoUserService.sendValidCodeMsg(ps.getUserId(), telephone);
        return JsonResponseUtil.success();
    }

    /**
     * 提交用户认证申请
     *
     * @param bo
     * @param session
     * @param bindingResult
     * @return
     * @throws JsonErrException
     */
    @RequestMapping("userValidSubmit")
    @ResponseBody
    public JSONObject userValidSubmit(@Valid PhotoUserValidBO bo, HttpSession session, BindingResult bindingResult) throws JsonErrException {
        if (bindingResult.hasErrors()) {
            return JsonResponseUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        return photoUserService.submitUserValid(userId, bo);
    }

    /**
     * 用户信息编辑页面
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("userProfileEdit")
    public String userProfileEdit(HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        PhotoAuthWorkUserInfoWebVO baseInfo = photoUserService.baseUserInfo(userId);
        PhotoAreaVO provsAndCitys = photoUserService.provsAndCitys();
        model.addAttribute("userInfo", photoUserService.resolveUserAddrInfo(baseInfo, provsAndCitys));
        model.addAttribute("provsAndCitys", provsAndCitys);
        return "photo/userProfileEdit";
    }

    /**
     * 提交修改用户信息结果
     *
     * @param bo
     * @param session
     * @return
     */
    @RequestMapping("submitProfileInfo")
    @ResponseBody
    public JSONObject submitProfileInfo(PhotoUserProfileEditBO bo, HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        return photoUserService.submitProfileInfo(ps.getUserId(), bo);
    }

    /**
     * 修改用户头像
     *
     * @param imgSrc
     * @param session
     * @return
     */
    @RequestMapping("saveHeadPortrait")
    @ResponseBody
    public JSONObject saveHeadPortrait(String imgSrc, HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        return photoUserService.saveHeadPortrait(ps.getUserId(), imgSrc);
    }

}
