package com.shigu.seller.actions;

import com.opentae.data.mall.beans.SpreadAuctScren;
import com.opentae.data.mall.beans.SpreadAuctShop;
import com.opentae.data.mall.beans.SpreadAuctType;
import com.shigu.seller.bo.AuctionApplyBo;
import com.shigu.seller.services.AuctionService;
import com.shigu.seller.services.api.ADAuctionService;
import com.shigu.seller.vo.SpreadTypeViewVo;
import com.shigu.seller.vo.WinnerVo;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.names.SessionEnum;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private ADAuctionService adAuctionService;
    /**
     * 自行包装用的service
     */
    @Autowired
    private AuctionService auctionService;

    String ftlDir="seller";

    /**
     * 广告区域列表
     * @return
     */
    @RequestMapping(value = "/indexgglist" , method = RequestMethod.GET)
    public String dtgTypeList(HttpServletRequest request){
        List<SpreadTypeViewVo> spreadAuctTypeList = adAuctionService.getSpreadAuctTypeList();
        request.setAttribute("adsBoxList", spreadAuctTypeList);
        return ftlDir + "/indexgglist";
    }

    /**
     * 竞拍中奖结果列表页面
     */
    @RequestMapping("/dtggapply")
    public String auctionIndex(Long id,HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShopSession logshop = ps.getLogshop();
        // 电商基地&精品男装& (!测试店铺32888)

        if(id == 1001){
            if (logshop.getShopId() != 35992 && logshop.getMarketId() != 1087 && logshop.getMarketId() != 613) {
                return ftlDir+"/dtggapplyNull";
            }
        }

        String introductionHtml = adAuctionService.getActRulesDesc(id);
        model.addAttribute("introductionHtml", introductionHtml);

        SpreadAuctScren currentAuction = adAuctionService.getCurrentAuction(id);

        if(currentAuction != null){
            model.addAttribute("id",currentAuction.getId());
        }

        model.addAttribute("typeId",id);

        // 正在进行活动
        if (currentAuction != null) {
            SpreadAuctShop spreadAuctShop = adAuctionService.checkWin(logshop.getShopId(),id);
            // 没有加入活动
            if (spreadAuctShop == null) {
                return ftlDir+"/dtggapply";
            } else {
                model.addAttribute("lxtel", spreadAuctShop.getContactsPhone());
                 model.addAttribute("lxuser",  spreadAuctShop.getContactsName());
                model.addAttribute("marketText", spreadAuctShop.getMarketName());
                model.addAttribute("storeNum", spreadAuctShop.getShopNum());
                model.addAttribute("countdownValue", currentAuction.getEndTime().getTime());
                model.addAttribute("nowTimeValue", System.currentTimeMillis());
                return ftlDir+"/dtggapplyinfo";
            }
        }
        // 当前没有活动
        List<WinnerVo> winners = adAuctionService.getWinners(id);
        for (int i = 0; i < winners.size(); i++) {
            winners.get(i).setNum(i + 1L);
        }

        model.addAttribute("ggList", winners);

        Date nexttime =  adAuctionService.nextAuctionTime(id);
        if(nexttime != null){
            model.addAttribute("nexttimeText", DateFormatUtils.format(nexttime, "yyyy-MM-dd"));
        }
        return ftlDir+"/dtgglist";
    }

    @RequestMapping("/dtggapplyinfo")
    public String auctionApply(HttpSession session, AuctionApplyBo bo, Model model) {
        String msg = null;
        if (StringUtils.isEmpty(bo.getLxtel())) {
            msg = "请输入联系电话";
        }
        if (StringUtils.isEmpty(bo.getLxuser())) {
            msg = "请输入联系人";
        }
        SpreadAuctScren spreadAuctScren = adAuctionService.getSpreadScrenById(bo.getId());
        if (msg != null) {
            model.addAttribute("msg", msg);
            model.addAttribute("lxuser", bo.getLxuser());
            model.addAttribute("lxtel", bo.getLxtel());
            return "redirect:/seller/dtggapply.htm?id="+spreadAuctScren.getSpreadPmId();
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        bo.setShopId(ps.getLogshop().getShopId());
        try {

            adAuctionService.applyAuction(bo);
            return "redirect:/seller/dtggapply.htm?id="+spreadAuctScren.getSpreadPmId();
        } catch (Exception e) {
            model.addAttribute("msg", "很抱歉，该活动已经结束");
            return "redirect:/seller/dtggapply.htm?id="+spreadAuctScren.getSpreadPmId();
        }
    }

    /**
     * 查看所有结果
     * @return
     */
    @RequestMapping("/dtgglistFinish")
    public String dtgglistFinish(Model model){
        model.addAttribute("indexggList",auctionService.auctionResults());
        return ftlDir+"/dtgglistFinish";
    }
}
