package com.shigu.seller.actions;

import com.shigu.main4.activity.enums.ActivityType;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.activity.service.ActivityDubboService;
import com.shigu.main4.activity.vo.ActivityEnlistVO;
import com.shigu.main4.activity.vo.ActivityTermVO;
import com.shigu.main4.activity.vo.ActivityVO;
import com.shigu.main4.activity.vo.GoatActivityVO;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.seller.bo.AuctionApplyBo;
import com.shigu.seller.bo.GoatApplyTypeBO;
import com.shigu.seller.services.ADAuctionService;
import com.shigu.seller.vo.ADAuctionResultVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.KeyWordsUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wxc on 2017/3/22.
 *
 * 商户广告竞拍大厅
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@Controller
@RequestMapping("seller")
public class ADAuctionAction {


    String ftlDir="gys";

    @Autowired
    ActivityDubboService activityDubboService;

    @Autowired
    ADAuctionService adAuctionService;

    private String introductionHtml="";

    /**
     * 广告区域列表
     * @return
     */
    @RequestMapping(value = "/indexgglist" , method = RequestMethod.GET)
    public String dtgTypeList(HttpSession session, Model model, GoatApplyTypeBO bo){
//        List<SpreadTypeViewVo> spreadAuctTypeList = adAuctionService.getSpreadAuctTypeList();
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (StringUtils.isBlank(bo.getType())) {
            bo.setType("man");
        }
        model.addAttribute("adsBoxList", adAuctionService.selSellGoats(ps.getUserId(), bo.getType()));
        model.addAttribute("query",bo);
        return "gys/indexgglist";
    }

    /**
     * 竞拍中奖结果列表页面
     */
    @RequestMapping("/dtggapply")
    public String auctionIndex(Long id,HttpSession session, Model model) throws ActivityException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShopSession logshop = ps.getLogshop();
        // 电商基地&精品男装& (!测试店铺32888)
        if(id==null||id==1001L)
        if (logshop.getShopId() != 35992 && logshop.getMarketId() != 1087 && logshop.getMarketId() != 613) {
             return ftlDir+"/dtggapplyNull";
        }

        ActivityVO activityVO=selActivityById(id);
        if (activityVO == null) {
            return "redirect:dtgglist.htm?id="+(id!=null?id:"");
        }
        ActivityTermVO t=activityDubboService.selByTermId(activityVO.getTermId());
        if(t.getEndTime().getTime()<System.currentTimeMillis()){//已经结束
            return "redirect:dtgglist.htm?id="+(id!=null?id:"");
        }
        model.addAttribute("activityId",activityVO.getActivityId());
        model.addAttribute("introductionHtml",introductionHtml);
        //是否已经报名
        ActivityEnlistVO enlistVO=activityDubboService.activityJoinMsg(activityVO.getActivityId(),ps.getUserId());
        if(enlistVO!=null){
            //如果已经报名,去applyinfo
            model.addAttribute("lxuser",enlistVO.getName());
            model.addAttribute("lxtel",enlistVO.getTelephone());
            model.addAttribute("marketText",logshop.getMarket());
            model.addAttribute("storeNum",logshop.getShopNum());
            model.addAttribute("typeId",activityVO.getActivityId());
            model.addAttribute("nowTimeValue",new Date().getTime());
            ActivityTermVO term=activityDubboService.selByTermId(activityVO.getTermId());
            model.addAttribute("countdownValue",term.getEndTime().getTime());
            return ftlDir+"/dtggapplyinfo";
        }
        //没报名去,apply
        return ftlDir+"/dtggapply";
    }

    private ActivityVO selActivityById(Long id) throws ActivityException {
        if (id == null||id==1001L) {
            //活动是否还在进行中
            ActivityTermVO term=activityDubboService.selTermByTime(ActivityType.GOAT_LED,new Date(),null);
            if(term==null){//已经结束
                return null;
            }
            return activityDubboService.selActivityInTerm(term.getTermId()).get(0);
        }else{
            return activityDubboService.selActivityById(id);
        }
    }

    /**
     * 本期列表
     * @return
     */
    @RequestMapping("/dtgglist")
    public String gglist(Long id,Model model) throws ActivityException {
        model.addAttribute("introductionHtml",introductionHtml);
        ActivityTermVO term;
        if(id==null||id==1001L){
            term=activityDubboService.selNowFinishedTerm(ActivityType.GOAT_LED,new Date(),null);
            if (term != null) {
                ActivityVO activityVO=activityDubboService.selActivityInTerm(term.getTermId()).get(0);
                model.addAttribute("ggList", adAuctionService.selLedWinner(activityDubboService.selEnlist(1,activityVO.getActivityId())));
            }
        }else{
            term=activityDubboService.selNowFinishedTerm(ActivityType.GOAT_SELL,new Date(),null);
            ActivityVO activityVO=activityDubboService.selActivityById(id);
            model.addAttribute("ggList", adAuctionService.selLedWinner(activityDubboService.selEnlist(1,activityVO.getActivityId())));
        }
        if (term != null) {
            ActivityTermVO nextTerm = activityDubboService.selafterTermId(term.getActivityType(), term.getTermId(),null);
            if (nextTerm != null) {
                model.addAttribute("nexttimeText", DateUtil.dateToString(nextTerm.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
            } else {
                model.addAttribute("nexttimeText", "");
            }
        }
        return ftlDir+"/dtgglist";
    }

    @RequestMapping("/dtggapplyinfo")
    public String auctionApply(HttpSession session, AuctionApplyBo bo, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShopSession logshop = ps.getLogshop();
        String msg = null;
        if (StringUtils.isEmpty(bo.getLxtel())) {
            msg = "请输入联系电话";
        }
        if (StringUtils.isEmpty(bo.getLxuser())) {
            msg = "请输入联系人";
        }
        if (msg != null) {
            model.addAttribute("msg",msg);
        }
        bo.setShopId(ps.getLogshop().getShopId());
        try {
            activityDubboService.joinActivity(bo.getId(),ps.getUserId(),logshop.getShopId(),bo.getLxuser(),bo.getLxtel());
        } catch (Exception e) {
            model.addAttribute("msg", "很抱歉，该活动已经结束");
//            return "redirect:/seller/dtggapply.htm?id="+spreadAuctScren.getSpreadPmId();
        }
        return "redirect:/seller/dtggapply.htm?id="+(bo.getId()!=null?bo.getId():"");
    }

    /**
     * 查看所有结果
     * @return
     */
    @RequestMapping("/dtgglistFinish")
    public String dtgglistFinish(GoatApplyTypeBO bo,Model model){
//        model.addAttribute("indexggList",auctionService.auctionResults());
        if (StringUtils.isBlank(bo.getType())) {
            bo.setType("man");
        }
        ActivityTermVO term=activityDubboService.selNowFinishedTerm(ActivityType.GOAT_SELL,new Date(),bo.getType());
        List<ADAuctionResultVO> list=new ArrayList<>();
        if (term != null) {
            List<GoatActivityVO> activityVOs=activityDubboService.selActivityInTerm(term.getTermId());
            if (activityVOs != null) {
                for(GoatActivityVO vo:activityVOs){
                    ADAuctionResultVO resultVO=new ADAuctionResultVO();
                    resultVO.setTitle(vo.getDescription());
                    try {
                        resultVO.setGgList(adAuctionService.selLedWinner(activityDubboService.selEnlist(1,vo.getActivityId())));
                    } catch (ActivityException e) {

                    }
                    list.add(resultVO);
                }
            }
            model.addAttribute("indexggQ",term.getTermId());
        }
        model.addAttribute("query",bo);
        //极限词过滤
        model.addAttribute("indexggList",list.stream().peek(adAuctionResultVO -> adAuctionResultVO.setTitle(KeyWordsUtil.duleKeyWords(adAuctionResultVO.getTitle()))).collect(Collectors.toList()));
        return ftlDir+"/dtgglistFinish";
    }
}
