package com.shigu.activity.actions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.activity.actions
 * @ClassName: ShareWeChatAction
 * @Author: sy
 * @CreateDate: 2018/8/31 0031 16:24
 */
@Controller
public class ShareWeChatAction {

    @RequestMapping("static/shareWxIntro")
    public String shareWeChat (){
        return "h5/shareWxIntro";
    }
}
