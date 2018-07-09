package com.shigu.goodsup.sn.actions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SnUploadAction {

    @RequestMapping("sn/index")
    public String upload(){

        return "suning/part/success";
    }
}
