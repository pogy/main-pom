package com.shigu.wx_share;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShareAction {
    @RequestMapping("offer/{id}")
    public String share(@PathVariable("id") String id) {
        return "h5/shareWxIntro";
    }
}
