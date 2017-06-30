package com.shigu.seller.actions;

import com.shigu.seller.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * 最新活动
 * Created by bugzy on 2017/6/30 0030.
 */
@Controller
@RequestMapping("seller/")
public class ActivitysAction {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("actDetails")
    public String actDetails(Model model) {
        model.addAttribute("activities", activityService.selAllActivities());
        return "seller/actDetails";
    }
}
