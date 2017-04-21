package com.shigu.sysman.system.actions;


import com.shigu.component.common.globality.controller.BackBaseController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


/**
 * 后台系统主页
 *
 * @author shigu_zjb
 * @date 2017/03/09 10:38
 *
 */
@Controller
public class SystemIndexController extends BackBaseController{

    private static final Logger logger = Logger.getLogger(SystemIndexController.class);


    /**
     * 后台主页
     * @return
     */
    @RequestMapping(value = "/sysman/index/main" , method = RequestMethod.GET)
    public String main(HttpServletRequest request){
        request.setAttribute("userName", getUserName());
        request.setAttribute("loginName", getLoginName());
        return "sysman/mainIndex";
    }

    /**
     * 头部
     * @return
     */
    @RequestMapping(value = "/sysman/index/topPanel" , method = RequestMethod.GET)
    public String topPanel(){

        return "sysman/common/topPanel";
    }

    /**
     * 左侧菜单
     * @return
     */
    @RequestMapping(value = "sysman/index/leftPanel" , method = RequestMethod.GET)
    public String leftPanel(){

        return "sysman/common/leftpanel";
    }

    /**
     * 右侧主体内容
     * @return
     */
    @RequestMapping(value = "sysman/index/rightPanel" , method = RequestMethod.GET)
    public String rightPanel(){

        return "sysman/common/rightPanel";
    }

}
