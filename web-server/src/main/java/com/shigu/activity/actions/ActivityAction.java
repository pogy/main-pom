package com.shigu.activity.actions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 活动
 * Created by zhaohongbo on 17/4/26.
 */
@Controller
public class ActivityAction {

    @RequestMapping("activity/redbull")
    public String findGodos(){
        return "activity/styleHuodong";
    }
}