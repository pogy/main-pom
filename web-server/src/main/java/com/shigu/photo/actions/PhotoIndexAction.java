package com.shigu.photo.actions;

import com.shigu.photo.process.PhotoWorksProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("photo")
public class PhotoIndexAction {
    @Autowired
    PhotoWorksProcess photoWorksProcess;

    public String index(){
        return "";
    }


}
