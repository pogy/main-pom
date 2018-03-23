package com.shigu.activity.actions;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AttractBusinessAction {

    @RequestMapping("qtdsMerchants")
    public String contact(){

        return "xzPage/qtdsMerchants";
    }
}
