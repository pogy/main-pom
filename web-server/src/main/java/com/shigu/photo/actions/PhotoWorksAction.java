package com.shigu.photo.actions;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.photo.bo.PhotoUploadBO;
import com.shigu.photo.bo.PhotoWorksBO;
import com.shigu.photo.bo.PhotoWorksSearchBO;
import com.shigu.photo.bo.SynPhotoUploadBO;
import com.shigu.photo.process.PhotoWorksProcess;
import com.shigu.photo.vo.PhotoCatVO;
import com.shigu.photo.vo.PhotoStyleVO;
import com.shigu.photo.vo.PhotoWorksVO;
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



    @RequestMapping("wokes")
    public String wokes(PhotoWorksSearchBO bo, Model model){
        ShiguPager<PhotoWorksVO> photoWorksVOShiguPager = photoWorksProcess.selPhotoWorksVos(bo.toPhotoWorksBO(null));
        model.addAttribute("list",photoWorksVOShiguPager.getContent());
        model.addAttribute("query",bo);
        model.addAttribute("pageOption",photoWorksVOShiguPager.selPageOption(10));
        return "wokes";
    }

    @RequestMapping("authorWokes")
    public String authorWokes(HttpSession session,PhotoWorksSearchBO bo,Model model){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShiguPager<PhotoWorksVO> photoWorksVOShiguPager = photoWorksProcess.selPhotoWorksVos(bo.toPhotoWorksBO(ps.getUserId()));
        model.addAttribute("list",photoWorksVOShiguPager.getContent());
        model.addAttribute("query",bo);
        model.addAttribute("pageOption",photoWorksVOShiguPager.selPageOption(10));
        return "authorWokes";
    }


    //上传作品页
    @RequestMapping("uploadWork")
    public String uploadWork(HttpSession session, Model model){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        //准备风格
        List<PhotoStyleVO> photoStyleVOS = photoWorksProcess.selPhotoStyleVos(ps.getUserId());
        //准备类目
        List<PhotoCatVO> photoCatVOS = photoWorksProcess.selPhotoCatVos();
        model.addAttribute("styles",photoStyleVOS);
        model.addAttribute("cats",photoCatVOS);
        return "uploadWork";
    }

    @RequestMapping("uploadWorkAction")
    @ResponseBody
    public JSONObject uploadWorkAction(@Valid PhotoUploadBO bo, BindingResult result){
        if (result.hasErrors()) {
            return JsonResponseUtil.error(result.getAllErrors().get(0).getDefaultMessage());
        }
        if(bo.getHavePrice()==1&& StringUtils.isBlank(bo.getPriceString())){
            return JsonResponseUtil.error("请填写价格");
        }
        SynPhotoUploadBO synPhotoUploadBO= BeanMapper.map(bo,SynPhotoUploadBO.class);
        photoWorksProcess.uploadWorks(synPhotoUploadBO);
        return JsonResponseUtil.success();
    }


}
