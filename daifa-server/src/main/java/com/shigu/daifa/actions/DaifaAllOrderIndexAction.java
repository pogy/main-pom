package com.shigu.daifa.actions;

import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.AllOrderBO;
import com.shigu.daifa.services.DaifaAllOrderIndexService;
import com.shigu.daifa.vo.DaifaAllOrderVO;
import com.shigu.daifa.vo.DaifaWorkerVO;
import com.shigu.daifa.vo.OrderStatisticsVO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by pc on 2017-08-14.
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Controller
public class DaifaAllOrderIndexAction {

    private DaifaAllOrderIndexService daifaAllOrderIndexService;

    @Autowired
    public void setDaifaAllOrderIndexService(DaifaAllOrderIndexService daifaAllOrderIndexService) {
        this.daifaAllOrderIndexService = daifaAllOrderIndexService;
    }
    /**
     * ====================================================================================
     * @方法名： allOrderPage
     * @user gzy 2017/10/13 13:06
     * @功能：全部订单
     * @param: [bo, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("daifa/orderAll")
    public String allOrderPage(AllOrderBO bo, Model model) throws ExecutionException, InterruptedException {
        daifaAllOrderIndexService.timeOutExcute();
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        Future<OrderStatisticsVO> future = daifaAllOrderIndexService.statisticsToday(auth.getDaifaSellerId());
        List<DaifaAllOrderVO> allOrders = daifaAllOrderIndexService.allOrderPage(bo, auth.getDaifaSellerId());

        String pageOption = bo.getCount() + "," + "10" + "," + bo.getPage();
        model.addAttribute("orders", allOrders);
        model.addAttribute("query", bo);
        model.addAttribute("pageOption", pageOption);
        model.addAttribute("userName", auth.getDaifaUserName());
        model.addAttribute("orderStatistics",future.get());
        model.addAttribute("menu","orderAll.htm");//前台所要的左边菜单
        return "daifa/orderAll";

    }
    /**
     * ====================================================================================
     * @方法名： addChildRemarkJson
     * @user gzy 2017/10/13 13:06
     * @功能：
     * @param: [childOrderId, remarkCon]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping(value = "daifa/addChildRemarkJson", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addChildRemarkJson(@RequestParam(value = "childOrderId") Long childOrderId, String remarkCon) throws DaifaException {

        return daifaAllOrderIndexService.addChildRemarkJson(childOrderId, remarkCon);
    }
    /**
     * ====================================================================================
     * @方法名： getUserList
     * @user gzy 2017/10/13 13:07
     * @功能：
     * @param: []
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping(value = "daifa/getUserList", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getUserList() {
        List<DaifaWorkerVO> workers = daifaAllOrderIndexService.getUserList(null);
        return JsonResponseUtil.success().element("userList", workers);
    }

    
    /**
     * ====================================================================================
     * @方法名： setTimeJson
     * @user gzy 2017/10/13 13:07
     * @功能：设置有货时间
     * @param: [childOrderId 子单id, timeStr 时间]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping(value = "daifa/setTimeJson", method = RequestMethod.POST)
    @ResponseBody
    public synchronized JSONObject setTimeJson(@RequestParam(value = "childOrderId") Long childOrderId, String timeStr) throws DaifaException {

        return daifaAllOrderIndexService.setTimeJson(childOrderId, timeStr);
    }
    /**
     * ====================================================================================
     * @方法名： setTallyJson
     * @user gzy 2017/10/13 13:08
     * @功能：
     * @param: [userId, childOrderId]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping(value = "daifa/setTallyJson", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject setTallyJson(Long userId, @RequestParam("childOrderId") Long childOrderId) throws DaifaException {

        return daifaAllOrderIndexService.setTallyJson(childOrderId);
    }

}
