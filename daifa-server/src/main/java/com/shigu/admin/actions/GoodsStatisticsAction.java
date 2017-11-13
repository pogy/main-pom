package com.shigu.admin.actions;

import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.shigu.admin.bo.StatisGoodsBO;
import com.shigu.admin.services.GoodsStatisticsService;
import com.shigu.admin.vo.StatisGoodsVO;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.AllOrderBO;
import com.shigu.daifa.vo.DaifaAllOrderVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private GoodsStatisticsService goodsStatisticsService;


    /**
     * ====================================================================================
     * @方法名： statisGoodsbyGoodsByPage
     * @user gzy 2017/11/7 15:22
     * @功能：按拿货状态，开始时间，结束时间统计商品信息
     * @param: [bo, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/statisGoodsbyGoods")
    public String statisGoodsbyGoodsByPage(StatisGoodsBO bo, Model model) throws ExecutionException, InterruptedException {

        Session session = SecurityUtils.getSubject().getSession();
        String auth = (String) session.getAttribute(DaifaSessionConfig.DAIFA_SYS_SESSION);
        List<StatisGoodsVO> list= goodsStatisticsService.statisGoodsbyGoodsByPage( bo);

        String pageOption = bo.getCount() + "," + "10" + "," + bo.getPage();
        model.addAttribute("lists", list);
        if(bo.getTakeGoodsStatus ()==null){
            bo.setTakeGoodsStatus (0);
        }
        model.addAttribute("query", bo);
        model.addAttribute("pageOption", pageOption);
        model.addAttribute("userName", auth);

        return "admin/statisGoodsbyGoodsByPage";

    }
    /**
     * ====================================================================================
     * @方法名： statisGoodsByStoreNumByPage
     * @user gzy 2017/11/7 15:23
     * @功能：按拿货状态，开始时间，结束时间统计档口信息
     * @param: [bo, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/statisGoodsByStoreNum")
    public String statisGoodsByStoreNumByPage(StatisGoodsBO bo, Model model) throws ExecutionException, InterruptedException {

        Session session = SecurityUtils.getSubject().getSession();
        String auth = (String) session.getAttribute(DaifaSessionConfig.DAIFA_SYS_SESSION);
        List<StatisGoodsVO> list= goodsStatisticsService.statisGoodsByStoreNumByPage(bo);
        String pageOption = bo.getCount() + "," + "10" + "," + bo.getPage();
        model.addAttribute("lists", list);
        if(bo.getTakeGoodsStatus ()==null){
            bo.setTakeGoodsStatus (0);
        }
        model.addAttribute("query", bo);
        model.addAttribute("pageOption", pageOption);
        model.addAttribute("userName", auth);

        return "admin/statisGoodsByStoreNumByPage";

    }
}
