package com.shigu.daifa.admin.actions;

import com.shigu.config.DaifaSessionConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DaifaSysAdminLoginAction {
    static final String checkerPass = "571zfws";


    @RequestMapping("init/adminLogin")
    public String adminLogin(String pass, Model model) {
        Session session = SecurityUtils.getSubject().getSession();
        Object object = session.getAttribute(DaifaSessionConfig.DAIFA_SYS_SESSION);
        if (object != null) {
            return "redirect:/admin/adminOrder.htm";
        }
        if (checkerPass.equals(pass)) {

            String daifaAdmin=DaifaSessionConfig.DAIFA_SYS_DISPLAY;

            session.setAttribute(DaifaSessionConfig.DAIFA_SYS_SESSION, daifaAdmin);
            return "redirect:/admin/adminOrder.htm";
        }
        model.addAttribute("pass", pass);
        model.addAttribute("msg",StringUtils.isEmpty(pass)?null:"密码错误");
        return "admin/adminLogin";
    }

}
