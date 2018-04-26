package com.shigu.photo.actions;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.photo.bo.PhotoWorksSearchBO;
import com.shigu.photo.process.PhotoWorksProcess;
import com.shigu.photo.vo.PhotoWorksVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("photo")
public class PhotoIndexAction {
    @Autowired
    PhotoWorksProcess photoWorksProcess;

    public String index(){
        return "";
    }


}
