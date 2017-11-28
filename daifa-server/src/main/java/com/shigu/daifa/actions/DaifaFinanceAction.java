package com.shigu.daifa.actions;

import com.shigu.admin.services.GgoodsUnCompleteService;
import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.FinancialDetailBO;
import com.shigu.daifa.services.DaifaFinanceService;
import com.shigu.daifa.vo.*;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class DaifaFinanceAction {
    @Autowired
    DaifaFinanceService daifaFinanceService;
    @Autowired
    GgoodsUnCompleteService ggoodsUnCompleteService;
    @Autowired
    TakeGoodsIssueProcess takeGoodsIssueProcess;
    /**
     * ====================================================================================
     * @方法名： financialStatistic
     * @user gzy 2017/10/13 13:09
     * @功能：财务统计
     * @param: [time, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("daifa/financialStatistic")
    public String financialStatistic(String time, Model model){

        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        if(StringUtils.isEmpty(time)){
            time=DateUtil.dateToString(new Date(),DateUtil.patternA);
        }


        FinanceVO vo=daifaFinanceService.selFinace(time,auth.getDaifaSellerId());
        Map<String,String> map=new HashMap<>();
        map.put("time",time);
        model.addAttribute("query",map);
        model.addAttribute("orderStatistics",vo);
        model.addAttribute("userName",auth.getDaifaUserName ());
        model.addAttribute("menu","financialStatistic.htm");//前台所要的左边菜单
        return  "daifa/financialStatistic";
    }

    /**
     * 财务统计,拿货金额信息列表
     * @param bo
     * @param model
     * @return
     */
    @RequestMapping("daifa/financialGoodsFeeDetail")
    public String financialGoodsFeeDetail(FinancialDetailBO bo, Model model){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        if(StringUtils.isEmpty(bo.getTime())){
            bo.setTime(DateUtil.dateToString(new Date(),DateUtil.patternA));
        }
        String day= DateUtil.dateToString(DateUtil.stringToDate(bo.getTime(),DateUtil.patternA),DateUtil.patternB);
        List<FinancialGoodsFeeDetailVO> vos= daifaFinanceService.workerTakeFeeDetail(day,auth.getDaifaSellerId());
        model.addAttribute("query",bo);
        model.addAttribute("goodsFeeList",vos);
        model.addAttribute("userName",auth.getDaifaUserName());
        return  "daifa/financialGoodsFeeDetail";
    }

    /**
     * 财务统计,代发人员退回金额
     * @return
     */
    @RequestMapping("daifa/userRefundedFee")
    @ResponseBody
    public JSONObject userRefundedFee(Long userId,String refundedFee,String time) throws DaifaException {
        String day= DateUtil.dateToString(DateUtil.stringToDate(time,DateUtil.patternA),DateUtil.patternB);
        takeGoodsIssueProcess.userRefundedFee(day,userId,refundedFee);
        return JsonResponseUtil.success();
    }

    /**
     * 财务统计,用户拿货数据详情
     * @param bo
     * @param model
     * @return
     */
    @RequestMapping("daifa/userTakeGoodsDetail")
    public String userTakeGoodsDetail(FinancialDetailBO bo, Model model){
        if(bo.getPage()==null){
            bo.setPage(1);
        }
        if(StringUtil.isNull(bo.getTime())){
            bo.setTime(DateUtil.dateToString(new Date(),DateUtil.patternA));
        }
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        Map<String,Object> map= new HashMap<>();
        map.put("time",bo.getTime());
        map.put("userId",bo.getUserId());
        map.put("page",bo.getPage());
        model.addAttribute("query",map);
        model.addAttribute("userName",auth.getDaifaUserName ());
        model.addAttribute("pageOption",0+","+10+","+1);
        model.addAttribute("childOrders",new ArrayList<>());
        if(bo.getUserId()==null){
            return "daifa/userTakeGoodsDetail";
        }
        ShiguPager<DaifaAllocatedVO> pager=ggoodsUnCompleteService.workerTakeGoods(bo.getUserId(),bo.getTime(),bo.getPage());
        model.addAttribute("childOrders",pager.getContent());
        model.addAttribute("pageOption",pager.getTotalCount()+","+10+","+bo.getPage());
        return "daifa/userTakeGoodsDetail";
    }

    /**
     * 财务统计,快递费详情列表
     * @param bo
     * @param model
     * @return
     */
    @RequestMapping("daifa/postFeeDetail")
    public String postFeeDetail(FinancialDetailBO bo, Model model){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        if(StringUtils.isEmpty(bo.getTime())){
            bo.setTime(DateUtil.dateToString(new Date(),DateUtil.patternA));
        }
        if(bo.getPage()==null){
            bo.setPage(1);
        }
        String day= DateUtil.dateToString(DateUtil.stringToDate(bo.getTime(),DateUtil.patternA),DateUtil.patternB);
        ShiguPager<TodayPostDetailVO> pager= daifaFinanceService.todaySendPostDetail(day,auth.getDaifaSellerId(),bo.getPage());

        model.addAttribute("postFeeList",pager.getContent());
        model.addAttribute("pageOption",pager.selPageOption(10));
        model.addAttribute("query",bo);
        model.addAttribute("userName",auth.getDaifaUserName ());
        return "daifa/postFeeDetail";
    }

    /**
     * 财务统计,库存商品
     * @param bo
     * @param model
     * @return
     */
    @RequestMapping("daifa/afterSaleStockFee")
    public String afterSaleStockFee(FinancialDetailBO bo,Model model){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        if(StringUtils.isEmpty(bo.getTime())){
            bo.setTime(DateUtil.dateToString(new Date(),DateUtil.patternA));
        }
        if(bo.getPage()==null){
            bo.setPage(1);
        }
        String day= DateUtil.dateToString(DateUtil.stringToDate(bo.getTime(),DateUtil.patternA),DateUtil.patternB);
        ShiguPager<StockGoodsVO> pager=daifaFinanceService.afterSaleStockFee(day,auth.getDaifaSellerId(),bo.getPage());
        model.addAttribute("stockFeeList",pager.getContent());
        model.addAttribute("pageOption",pager.selPageOption(10));
        model.addAttribute("allStockFee",daifaFinanceService.stockFee(day,auth.getDaifaSellerId()));
        model.addAttribute("query",bo);
        model.addAttribute("userName",auth.getDaifaUserName ());
        return "daifa/afterSaleStockFee";
    }

    @RequestMapping("daifa/afterSaleRefundedFee")
    public String afterSaleRefundedFee(FinancialDetailBO bo,Model model){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        if(StringUtils.isEmpty(bo.getTime())){
            bo.setTime(DateUtil.dateToString(new Date(),DateUtil.patternA));
        }
        if(bo.getPage()==null){
            bo.setPage(1);
        }
        String day= DateUtil.dateToString(DateUtil.stringToDate(bo.getTime(),DateUtil.patternA),DateUtil.patternB);
        ShiguPager<RefundedFeeVO> pager=daifaFinanceService.afterSaleRefundedFee(day,auth.getDaifaSellerId(),bo.getPage());
        model.addAttribute("refundedFeeList",pager.getContent());
        model.addAttribute("pageOption",pager.selPageOption(10));
        model.addAttribute("allRefundedFee",daifaFinanceService.refundFee(day,auth.getDaifaSellerId()));
        model.addAttribute("query",bo);
        model.addAttribute("userName",auth.getDaifaUserName ());
        return "daifa/afterSaleRefundedFee";
    }


    @RequestMapping("daifa/takeGoodsStatistic")
    public String takeGoodsStatistic(Model model){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        Date startDate=DateUtil.getStartMouth();
        String day= DateUtil.dateToString(startDate,DateUtil.patternB);
        List<WorkerTakeNumVO> vos= daifaFinanceService.takeGoodsStatistic(day,auth.getDaifaSellerId());
        String timeArea=DateUtil.dateToString(startDate,DateUtil.patternA)+"至"+DateUtil.dateToString(new Date(),DateUtil.patternA);
        model.addAttribute("takeGoodsStatisticList",vos);
        model.addAttribute("timeArea",timeArea);
        model.addAttribute("userName",auth.getDaifaUserName ());
        return  "daifa/takeGoodsStatistic";
    }
}
