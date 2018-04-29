package com.shigu.photo.actions;

import com.shigu.photo.process.PhotoGoatProcess;
import com.shigu.photo.process.PhotoWorksProcess;
import com.shigu.photo.service.PhotoWorksService;
import com.shigu.photo.vo.GoatAuthorVO;
import com.shigu.photo.vo.GoatBannerVO;
import com.shigu.photo.vo.GoatMenuVO;
import com.shigu.photo.vo.PhotoWorksSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("photo/")
public class PhotoIndexAction {
    @Autowired
    PhotoGoatProcess photoGoatProcess;

    @RequestMapping("photoIndex")
    public String index(Model model) {
        model.addAttribute("menuList",photoGoatProcess.selMenus());
        model.addAttribute("photoBanner",photoGoatProcess.selBanner());
        model.addAttribute("littleBannerSrc",photoGoatProcess.selRightImg());
        model.addAttribute("modelCoverList",photoGoatProcess.selModel());
        model.addAttribute("orgCoverList",photoGoatProcess.selOff());
        model.addAttribute("workList",photoGoatProcess.selWorks().stream().map(PhotoWorksService::toSearchVO).collect(Collectors.toList()));
        return "photo/photoIndex";
    }

}
