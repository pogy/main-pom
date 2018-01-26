package com.shigu.search.actions;

import org.springframework.stereotype.Controller;
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


    @RequestMapping("page503")
    public String pageTimeout() {
        return "xzSysPage/orderTimeout";
    }
}
