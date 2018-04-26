package com.shigu.photo.actions;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.photo.bo.*;
import com.shigu.photo.process.PhotoWorksProcess;
import com.shigu.photo.service.PhotoWorksService;
import com.shigu.photo.vo.PhotoCatVO;
import com.shigu.photo.vo.PhotoStyleVO;
import com.shigu.photo.vo.PhotoWorksDetailWebVO;
import com.shigu.photo.vo.PhotoWorksVO;
import com.shigu.search.actions.PageErrAction;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
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
import java.util.List;

@Controller
@RequestMapping("photo/")
public class PhotoWorksAction {
    @Autowired
    PhotoWorksProcess photoWorksProcess;

    @Autowired
    PhotoWorksService photoWorksService;

    @Autowired
    PageErrAction pageErrAction;

    @RequestMapping("wokes")
    public String wokes(PhotoWorksSearchBO bo, Model model) {
        ShiguPager<PhotoWorksVO> photoWorksVOShiguPager = photoWorksProcess.selPhotoWorksVos(bo.toPhotoWorksBO(null));
        model.addAttribute("list", photoWorksVOShiguPager.getContent());
        model.addAttribute("query", bo);
        model.addAttribute("pageOption", photoWorksVOShiguPager.selPageOption(10));
        return "wokes";
    }

    @RequestMapping("authorWokes")
    public String authorWokes(HttpSession session, PhotoWorksSearchBO bo, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShiguPager<PhotoWorksVO> photoWorksVOShiguPager = photoWorksProcess.selPhotoWorksVos(bo.toPhotoWorksBO(ps.getUserId()));
        model.addAttribute("list", photoWorksVOShiguPager.getContent());
        model.addAttribute("query", bo);
        model.addAttribute("pageOption", photoWorksVOShiguPager.selPageOption(10));
        return "authorWokes";
    }


    //上传作品页
    @RequestMapping("uploadWork")
    public String uploadWork(HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        //准备风格
        List<PhotoStyleVO> photoStyleVOS = photoWorksProcess.selPhotoStyleVos(ps.getUserId());
        //准备类目
        List<PhotoCatVO> photoCatVOS = photoWorksProcess.selPhotoCatVos();
        model.addAttribute("styles", photoStyleVOS);
        model.addAttribute("cats", photoCatVOS);
        return "uploadWork";
    }

    @RequestMapping("uploadWorkAction")
    @ResponseBody
    public JSONObject uploadWorkAction(@Valid PhotoUploadBO bo, BindingResult result) {
        if (result.hasErrors()) {
            return JsonResponseUtil.error(result.getAllErrors().get(0).getDefaultMessage());
        }
        if (bo.getHavePrice() == 1 && StringUtils.isBlank(bo.getPriceString())) {
            return JsonResponseUtil.error("请填写价格");
        }
        SynPhotoUploadBO synPhotoUploadBO = BeanMapper.map(bo, SynPhotoUploadBO.class);
        photoWorksProcess.uploadWorks(synPhotoUploadBO);
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
        PhotoWorksDetailWebVO workDetail = photoWorksService.photoWorksDetail(bo.getId(), userId);
        model.addAttribute("worksData", workDetail);
        model.addAttribute("userInfo", photoWorksService.totalAuthInfo(workDetail.getAuthorId(), userId));
        model.addAttribute("query", bo);
        return "";
    }

}
