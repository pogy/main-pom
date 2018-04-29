package com.shigu.photo.actions;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.photo.bo.SynPhotoUploadBO;
import com.shigu.main4.photo.exceptions.PhotoException;
import com.shigu.main4.photo.process.PhotoImgProcess;
import com.shigu.main4.photo.process.PhotoUserProcess;
import com.shigu.main4.photo.process.PhotoWorksProcess;
import com.shigu.main4.photo.vo.PhotoWorksClickVO;
import com.shigu.photo.bo.PhotoUploadBO;
import com.shigu.photo.bo.PhotoWorkDetailViewBO;
import com.shigu.photo.bo.PhotoWorksSearchBO;
import com.shigu.photo.service.PhotoUserService;
import com.shigu.photo.service.PhotoWorksService;
import com.shigu.photo.vo.*;
import com.shigu.search.actions.PageErrAction;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequestMapping("photo/")
public class PhotoWorksAction {
    @Autowired
    PhotoWorksProcess photoWorksProcess;

    @Autowired
    PhotoWorksService photoWorksService;

    @Autowired
    PhotoUserService photoUserService;

    @Autowired
    PhotoUserProcess photoUserProcess;

    @Autowired
    PageErrAction pageErrAction;
    @Autowired
    PhotoImgProcess photoImgProcess;

    //作品列表
    @RequestMapping("photoWorks")
    public String wokes(PhotoWorksSearchBO query, Model model) throws PhotoException {
        model.addAttribute("roleList", Arrays.asList(new PhotoCateVO("1", "模特"), new PhotoCateVO("2,3", "摄影机构"), new PhotoCateVO("4", "场地")));
        model.addAttribute("cateList", photoWorksProcess.selPhotoCatVos()
                .stream().map(photoCatVO -> new PhotoCateVO(photoCatVO.getCid().toString(), photoCatVO.getCname())).collect(Collectors.toList()));
        model.addAttribute("styleList", photoWorksProcess.selPhotoStyleVos(null)
                .stream().map(photoStyleVO -> new PhotoCateVO(photoStyleVO.getStyleId().toString(), photoStyleVO.getStyleName())).collect(Collectors.toList()));

        ShiguPager<PhotoWorksSearchVO> photoWorksVOShiguPager = photoWorksService.selList(query);
        model.addAttribute("list", photoWorksVOShiguPager.getContent());
        model.addAttribute("query", query);
        model.addAttribute("pageOption", photoWorksVOShiguPager.selPageOption(10));
        return "photo/photoWorks";
    }

    //作者主页
    @RequestMapping(value={"userHomePage","userWorkList"})
    public String authorWokes(PhotoWorksSearchBO query, Model model,HttpSession session) throws PhotoException {
        ShiguPager<PhotoWorksSearchVO> photoWorksVOShiguPager = photoWorksService.selList(query);
        PhotoAuthWorkUserInfoWebVO photoAuthWorkUserInfoWebVO = photoUserService.totalAuthInfo(query.getId(), null);
        model.addAttribute("userWorksList", photoWorksVOShiguPager.getContent());
        model.addAttribute("query", query);
        model.addAttribute("userInfo", photoAuthWorkUserInfoWebVO);
        model.addAttribute("pageOption", photoWorksVOShiguPager.selPageOption(10));
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(ps!=null&&photoAuthWorkUserInfoWebVO.getUserId().equals(ps.getUserId())){
            return "photo/userWorkList";
        }
        return "photo/userHomePage";
    }


    //上传作品页
    @RequestMapping("uploadWork")
    public String uploadWork(HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        //准备风格
        model.addAttribute("styleList", photoWorksProcess.selPhotoStyleVos(null)
                .stream().map(photoStyleVO -> new PhotoCateVO(photoStyleVO.getStyleId().toString(), photoStyleVO.getStyleName())).collect(Collectors.toList()));
        model.addAttribute("cateList", photoWorksProcess.selPhotoCatVos()
                .stream().map(photoCatVO -> new PhotoCateVO(photoCatVO.getCid().toString(), photoCatVO.getCname())).collect(Collectors.toList()));
        model.addAttribute("userInfo", photoUserService.totalAuthInfo(ps.getUserId(), null));
        return "photo/uploadWork";
    }

    //修改作品页
    @RequestMapping(value = "uploadWork",params = "id")
    public String uploadWork(HttpSession session,Long id, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        //准备风格
        model.addAttribute("styleList", photoWorksProcess.selPhotoStyleVos(null)
                .stream().map(photoStyleVO -> new PhotoCateVO(photoStyleVO.getStyleId().toString(), photoStyleVO.getStyleName())).collect(Collectors.toList()));
        model.addAttribute("cateList", photoWorksProcess.selPhotoCatVos()
                .stream().map(photoCatVO -> new PhotoCateVO(photoCatVO.getCid().toString(), photoCatVO.getCname())).collect(Collectors.toList()));
        model.addAttribute("userInfo", photoUserService.totalAuthInfo(ps.getUserId(), null));
        PhotoWorksChangeVO photoWorksChangeVO = photoWorksService.selUpdateBean(id);
        model.addAttribute("worksData",photoWorksChangeVO);
        return "photo/uploadWork";
    }

    //提交作品添加或修改
    @RequestMapping("uploadWorkSubmit")
    @ResponseBody
    public JSONObject uploadWorkAction(@Valid PhotoUploadBO bo, BindingResult result,HttpSession session) {
        if (result.hasErrors()) {
            return JsonResponseUtil.error(result.getAllErrors().get(0).getDefaultMessage());
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        SynPhotoUploadBO synPhotoUploadBO = new SynPhotoUploadBO();
        synPhotoUploadBO.setCid(bo.getCate());
        synPhotoUploadBO.setContent(bo.getDesc());
        synPhotoUploadBO.setForbidSave(bo.getSaveType());
        synPhotoUploadBO.setHavePrice(bo.getPrice()==1?0:1);
        synPhotoUploadBO.setImages(bo.getImgs());
        synPhotoUploadBO.setPicUrl(bo.getCover());
        synPhotoUploadBO.setStyleId(bo.getStyles());
        synPhotoUploadBO.setTitle(bo.getTitle());
        synPhotoUploadBO.setUserId(ps.getUserId());
        synPhotoUploadBO.setWorksId(bo.getWorksId());
        try {
            photoWorksProcess.uploadWorks(synPhotoUploadBO);
        } catch (PhotoException e) {
            return JsonResponseUtil.error(e.getMessage());
        }
        return JsonResponseUtil.success();
    }

    /**
     * 作品详情页
     *
     * @param bo
     * @param session
     * @param model
     * @param bindingResult
     * @return
     */
    @RequestMapping("photoDetail")
    public String photoDetail(PhotoWorkDetailViewBO bo, HttpSession session, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return pageErrAction.pageErr(bindingResult.getAllErrors().get(0).getDefaultMessage(), model);
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = null;
        if (ps != null) {
            userId = ps.getUserId();
        }
        PhotoWorksDetailWebVO workDetail = photoWorksService.photoWorksDetailForUser(bo.getId(), userId);
        model.addAttribute("worksData", workDetail);
        model.addAttribute("userInfo", photoUserService.totalAuthInfo(workDetail.getAuthorId(), userId));
        model.addAttribute("query", bo);
        // TODO: 18-4-26 模版地址
        return "";
    }

    /**
     * 作品点赞 需要登陆
     *
     * @param worksId
     * @param session
     * @return
     */
    @RequestMapping("addThumbUpCount")
    @ResponseBody
    public JSONObject addThumbUpCount(Long worksId, HttpSession session) {
        if (worksId == null) {
            return JsonResponseUtil.error("非法的参数");
        }
        Long userId = ((PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue())).getUserId();
        photoUserProcess.praiseWork(userId, worksId);
        return JsonResponseUtil.success();
    }

    /**
     * 取消点赞 需要登陆
     *
     * @param worksId
     * @param session
     * @return
     */
    @RequestMapping("removeThumbUpCount")
    @ResponseBody
    public JSONObject removeThumbUpCount(Long worksId, HttpSession session) {
        if (worksId == null) {
            return JsonResponseUtil.error("非法的参数");
        }
        Long userId = ((PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue())).getUserId();
        photoUserProcess.praiseWorkCancel(userId, worksId);
        return JsonResponseUtil.success();
    }

    /**
     * 获取点击量
     *
     * @param worksId
     * @return
     */
    @RequestMapping("getReadCount")
    @ResponseBody
    public JSONObject getReadCount(Long worksId) {
        if (worksId == null) {
            return JsonResponseUtil.error("作品不存在");
        }
        PhotoWorksClickVO clicks = photoWorksProcess.incrementClicks(worksId);
        if (clicks == null) {
            return JsonResponseUtil.error("作品不存在");
        }
        return JsonResponseUtil.success().element("readCount", clicks.getTotalClick());
    }
}
