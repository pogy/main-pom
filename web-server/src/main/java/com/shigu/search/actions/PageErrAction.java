package com.shigu.search.actions;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述：
 * 项目：main-pom
 * 类路径： com.shigu.search.actions.PageErrAction
 * 创建人：wanghaoxiang
 * 时间： 18-1-16 下午6:22
 **/
@Controller
public class PageErrAction {

    /**
     * 页面不存在
     * @return
     */
    @RequestMapping("page404")
    public String pageNotFind() {
        return "xzSysPage/404";
    }

    /**
     * 页面请求异常
     * @param errorCon
     * @param model
     * @return
     */
    @RequestMapping
    public String pageErr(String errorCon, Model model) {
        if (StringUtils.isBlank(errorCon) || "系统异常".equals(errorCon)) {
            return "xzSysPage/500";
        }
        model.addAttribute("errorCon",errorCon);
        return "xzSysPage/otherError";
    }

    /**
     * 请求超时
     * @return
     */
    @RequestMapping("page503")
    public String pageTimeout() {
        return "xzSysPage/orderTimeout";
    }
}
