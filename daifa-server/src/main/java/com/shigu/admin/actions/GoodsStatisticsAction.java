package com.shigu.admin.actions;

import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.AllOrderBO;
import com.shigu.daifa.vo.DaifaAllOrderVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @类编号
 * @类名称：GoodsStatisticsAction
 * @文件路径：com.shigu.admin.actions.GoodsStatisticsAction
 * @内容摘要：商品统计
 * @编码作者：gzy
 * @创建日期：2017/11/2 11:31
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Controller
public class GoodsStatisticsAction {




    //按月统计
    @RequestMapping("admin/goodsStatisticsByMonth")
    public String goodsStatisticsByMonth(AllOrderBO bo, Model model) throws ExecutionException, InterruptedException {

        Session session = SecurityUtils.getSubject().getSession();
        String auth = (String) session.getAttribute(DaifaSessionConfig.DAIFA_SYS_SESSION);
        /*List<DaifaAllOrderVO> allOrders = daifaAllOrderIndexService.allOrderPage(bo, 999999990L);

        String pageOption = bo.getCount() + "," + "10" + "," + bo.getPage();
        model.addAttribute("orders", allOrders);
        model.addAttribute("query", bo);
        model.addAttribute("pageOption", pageOption);*/
        model.addAttribute("userName", auth);

        return "admin/index";

    }
    //按季度统计
    @RequestMapping("admin/goodsStatisticsByQuarterly")
    public String goodsStatisticsByQuarterly(AllOrderBO bo, Model model) throws ExecutionException, InterruptedException {

        Session session = SecurityUtils.getSubject().getSession();
        String auth = (String) session.getAttribute(DaifaSessionConfig.DAIFA_SYS_SESSION);
        /*List<DaifaAllOrderVO> allOrders = daifaAllOrderIndexService.allOrderPage(bo, 999999990L);

        String pageOption = bo.getCount() + "," + "10" + "," + bo.getPage();
        model.addAttribute("orders", allOrders);
        model.addAttribute("query", bo);
        model.addAttribute("pageOption", pageOption);*/
        model.addAttribute("userName", auth);

        return "admin/index";

    }
}
