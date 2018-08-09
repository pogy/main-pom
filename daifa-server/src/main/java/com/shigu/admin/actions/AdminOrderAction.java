package com.shigu.admin.actions;

import com.shigu.admin.services.AdminOrderService;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.AllOrderBO;
import com.shigu.daifa.services.DaifaAllOrderIndexService;
import com.shigu.daifa.vo.DaifaAllOrderVO;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.process.ItemOrderProcess;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @类编号
 * @类名称：AdminOrderAction
 * @文件路径：com.shigu.admin.actions.AdminOrderAction
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/13 10:01
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Controller
public class AdminOrderAction {

    private DaifaAllOrderIndexService daifaAllOrderIndexService;
    @Autowired
    ItemOrderProcess itemOrderProcess;
    @Value("${DAIFA_GROUP}")
    Long sellerId;
    @Autowired
    public void setDaifaAllOrderIndexService(DaifaAllOrderIndexService daifaAllOrderIndexService) {
        this.daifaAllOrderIndexService = daifaAllOrderIndexService;
    }

    private AdminOrderService adminOrderService;
    @Autowired
    public void setAdminOrderService(AdminOrderService adminOrderService) {
        this.adminOrderService = adminOrderService;
    }

    @RequestMapping("admin/adminOrder")
    public String adminOrder(AllOrderBO bo, Model model) throws ExecutionException, InterruptedException {

        Session session = SecurityUtils.getSubject().getSession();
        String auth = (String) session.getAttribute(DaifaSessionConfig.DAIFA_SYS_SESSION);
        List<DaifaAllOrderVO> allOrders = daifaAllOrderIndexService.allOrderPage(bo,sellerId);

        String pageOption = bo.getCount() + "," + "10" + "," + bo.getPage();
        model.addAttribute("orders", allOrders);
        model.addAttribute("query", bo);
        model.addAttribute("pageOption", pageOption);
        model.addAttribute("userName", auth);

        return "admin/index";

    }

    @RequestMapping("admin/printExcel")
    public String printExcel(String buyerNick, HttpServletResponse response) throws IOException, Main4Exception {
        if(StringUtils.isEmpty(buyerNick)){
            throw new Main4Exception("请输入昵称");
        }
        adminOrderService.pushExcel(response,buyerNick);
        return null;
    }

    @RequestMapping("admin/orderFinish")
    @ResponseBody
    public JSONObject ent(Long oid) throws Main4Exception {
        itemOrderProcess.sysFinish(oid);
        return JsonResponseUtil.success();
    }
}
