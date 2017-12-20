package com.shigu.admin.actions;

import com.shigu.admin.bo.OrderWaitSendBO;
import com.shigu.admin.services.DaifaWaitSendDealService;
import com.shigu.admin.vo.DaifaWaitSendDealVO;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @类编号
 * @类名称：DaifaWaitSendDealAction
 * @文件路径：com.shigu.admin.actions.DaifaWaitSendDealAction
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/10/12 16:05
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Controller
public class DaifaWaitSendDealAction {

    //设置待发货订单不显示

    @Autowired
    private DaifaWaitSendDealService daifaWaitSendDealService;
    /**
     * ====================================================================================
     * @方法名： waitSendList
     * @user gzy 2017/10/16 15:12
     * @功能：
     * @param: [bo, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/orderWaitSendList")
    public String waitSendList(OrderWaitSendBO bo, Model model){

        Session session = SecurityUtils.getSubject().getSession();
        String auth = (String) session.getAttribute(DaifaSessionConfig.DAIFA_SYS_SESSION);
        List<DaifaWaitSendDealVO> list=null;
        if(bo.getCount ()==null){
            bo.setCount (1);
        }
        if(bo.getPage ()==null){
            bo.setPage (1+"");
        }
        if(bo.getOrderDisplay ()==null){
            bo.setOrderDisplay (-1);
        }
        list = daifaWaitSendDealService.waitSendList (bo);
        String pageOption = bo.getCount() + "," + "10" + "," + bo.getPage();
        model.addAttribute("lists", list);
        model.addAttribute("query", bo);
        model.addAttribute("pageOption", pageOption);
        model.addAttribute("userName", auth);
        return "admin/orderWaitSendList";
    }
    /**
     * ====================================================================================
     * @方法名： dealWaitSendOrderDisplay
     * @user gzy 2017/10/16 15:39
     * @功能：处理是否显示待发货订单
     * @param: [bo]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/dealWaitSendOrderDisplay")
    @ResponseBody
    public JSONObject dealWaitSendOrderDisplay(OrderWaitSendBO bo) throws DaifaException {

        daifaWaitSendDealService.dealWaitSendOrderDisplay (bo.getDfTradeId (),bo.getOrderDisplay ());

        return JsonResponseUtil.success();
    }
}
