package com.shigu.photo.actions;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.photo.bo.PhotoWorksBO;
import com.shigu.main4.photo.process.PhotoUserProcess;
import com.shigu.main4.photo.process.PhotoWorksProcess;
import com.shigu.main4.photo.vo.AuthApplyInfoVO;
import com.shigu.main4.photo.vo.PhotoAuthorVO;
import com.shigu.photo.bo.PhotoAuthorListBO;
import com.shigu.photo.bo.PhotoUserProfileEditBO;
import com.shigu.photo.bo.PhotoUserValidBO;
import com.shigu.photo.service.PhotoUserService;
import com.shigu.photo.service.PhotoWorksService;
import com.shigu.photo.vo.PhotoAreaVO;
import com.shigu.photo.vo.PhotoAuthWorkUserInfoWebVO;
import com.shigu.photo.vo.PhotoCateVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 路径: com.shigu.photo.actions.PhotoUserAction
 * 工程: main-pom
 * 时间: 18-4-27 下午6:59
 * 创建人: wanghaoxiang
 * 描述:
 */
@Controller
@RequestMapping("photo/")
public class PhotoUserAction {

    @Autowired
    private PhotoUserService photoUserService;

    @Autowired
    private PhotoWorksService photoWorksService;
    @Autowired
    PhotoWorksProcess photoWorksProcess;

    @Autowired
    private PhotoUserProcess photoUserProcess;

    /**
     * 用户认证页面
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("member/userValidate")
    public String userValidate(HttpSession session, Model model) {
        Long userId = ((PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue())).getUserId();
        PhotoAuthWorkUserInfoWebVO userInfo = photoUserService.baseUserInfo(userId);
        Integer authType = userInfo.getAuthType();
        if (authType != null && authType > 0) {
            return "redirect:/photo/member/userWorkList.htm";
        }
        List<AuthApplyInfoVO> applyInfo = photoUserProcess.userAuthApplyInfo(userId, 0);
        //一个用户只会存在一条未审核的身份认证信息，若信息存在，说明已经有申请了，进行跳转
        if (applyInfo.size() > 0) {
            return "redirect:/photo/member/userWorkList.htm";
        }
        //普通用户且没有未审核的申请，可以进行申请
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("styleList", photoWorksService.selStyleListWithUser(null));
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
    @RequestMapping({"member/getUserValidMsgCode", "member/changePhotoTeleGetMsgCode"})
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
    @RequestMapping("member/userValidSubmit")
    @ResponseBody
    public JSONObject userValidSubmit(@Valid PhotoUserValidBO bo, HttpSession session, BindingResult bindingResult) throws JsonErrException {
        if (bindingResult.hasErrors()) {
            return JsonResponseUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        JSONObject result = photoUserService.submitUserValid(userId, bo);

        ////若不需要审核，直接通过，进行以下步骤
        //photoUserProcess.applyPass(userId, "认证通过（暂时不需要审核，自动通过时）");
        //ps.getOtherPlatform().put(OtherPlatformEnum.PHOTO_AUTH.getValue(), photoUserProcess.userBaseInfo(userId).getUserType());
        //session.setAttribute(SessionEnum.LOGIN_SESSION_USER.getValue(), ps);
        return result;
    }

    /**
     * 模特列表
     *
     * @param bo
     * @param model
     * @return
     */
    @RequestMapping("photoModel")
    public String photoModel(PhotoAuthorListBO bo, Model model) {
        model.addAttribute("styleList", photoWorksProcess.selPhotoStyleVos(null)
                .stream().map(photoStyleVO -> new PhotoCateVO(photoStyleVO.getStyleId().toString(), photoStyleVO.getStyleName())).collect(Collectors.toList()));
        model.addAttribute("childRoleList", Arrays.asList(new PhotoCateVO("0", "男模"), new PhotoCateVO("1", "女模")));
        PhotoWorksBO photoWorksBO = bo.toPhotoWorksBO(1);
        ShiguPager<PhotoAuthorVO> photoAuthorVOShiguPager = photoUserProcess.selAuthors(photoWorksBO);
        model.addAttribute("modelList", photoAuthorVOShiguPager.getContent());
        model.addAttribute("query", bo);
        model.addAttribute("pageOption", photoAuthorVOShiguPager.selPageOption(photoWorksBO.getPageSize()));
        return "photo/photoModel";
    }

    /**
     * 摄影机构列表
     *
     * @param bo
     * @param model
     * @return
     */
    @RequestMapping("photoOrg")
    public String photoOrg(PhotoAuthorListBO bo, Model model) {
        model.addAttribute("styleList", photoWorksProcess.selPhotoStyleVos(null)
                .stream().map(photoStyleVO -> new PhotoCateVO(photoStyleVO.getStyleId().toString(), photoStyleVO.getStyleName())).collect(Collectors.toList()));
        model.addAttribute("childOrgList", Arrays.asList(new PhotoCateVO("2", "摄影师"), new PhotoCateVO("3", "摄影公司")));
        PhotoWorksBO photoWorksBO = bo.toPhotoWorksBO(2);
        ShiguPager<PhotoAuthorVO> photoAuthorVOShiguPager = photoUserProcess.selAuthors(photoWorksBO);
        model.addAttribute("orgList", photoAuthorVOShiguPager.getContent());
        model.addAttribute("query", bo);
        model.addAttribute("pageOption", photoAuthorVOShiguPager.selPageOption(photoWorksBO.getPageSize()));
        return "photo/photoOrg";
    }

    /**
     * 摄影场地列表
     *
     * @param bo
     * @param model
     * @return
     */
    @RequestMapping("photoPlace")
    public String photoPlace(PhotoAuthorListBO bo, Model model) {
        model.addAttribute("styleList", photoWorksProcess.selPhotoStyleVos(null)
                .stream().map(photoStyleVO -> new PhotoCateVO(photoStyleVO.getStyleId().toString(), photoStyleVO.getStyleName())).collect(Collectors.toList()));
        PhotoWorksBO photoWorksBO = bo.toPhotoWorksBO(null);
        ShiguPager<PhotoAuthorVO> photoAuthorVOShiguPager = photoUserProcess.selAuthors(photoWorksBO);
        model.addAttribute("placeList", photoAuthorVOShiguPager.getContent());
        model.addAttribute("query", bo);
        model.addAttribute("pageOption", photoAuthorVOShiguPager.selPageOption(photoWorksBO.getPageSize()));
        return "photo/photoPlace";
    }


    /**
     * 个人主页
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("member/userProfile")
    public String userProfile(HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        model.addAttribute("userInfo", photoUserService.baseUserInfo(userId));
        return "photo/userProfile";
    }

    /**
     * 用户信息编辑页面
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("member/userProfileEdit")
    public String userProfileEdit(HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        PhotoAuthWorkUserInfoWebVO baseInfo = photoUserService.baseUserInfo(userId);
        PhotoAreaVO provsAndCitys = photoUserService.provsAndCitys();
        model.addAttribute("userInfo", photoUserService.resolveUserAddrInfo(baseInfo, provsAndCitys));
        model.addAttribute("provsAndCitys", JSONArray.fromObject(provsAndCitys.getProvs()).toString());
        return "photo/userProfileEdit";
    }

    /**
     * 提交修改用户信息结果
     *
     * @param bo
     * @param session
     * @return
     */
    @RequestMapping("member/submitProfileInfo")
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
    @RequestMapping("member/saveHeadPortrait")
    @ResponseBody
    public JSONObject saveHeadPortrait(String imgSrc, HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        return photoUserService.saveHeadPortrait(ps.getUserId(), imgSrc);
    }

}
