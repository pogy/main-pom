package com.shigu.daifa.actions;

import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.services.DaifaOrderStatusMoveService;
import com.shigu.daifa.vo.StatusMoveVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created By zyl on 2018/9/19 0019/16:22
 * action  用于代发系统订单流转状态查询页
 */
@Controller
public class DaifaOrderStatusMoveAction {

    @Autowired
    private DaifaOrderStatusMoveService daifaOrderStatusMoveService;

    /**
     * 订单流转状态
     * 查询当日所有的订单，及订单执行状态   分页显示
     *
     */

    @RequestMapping("daifa/selOrderMove")
    public String scanBarCode(Model model){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser daifaUser = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        model.addAttribute("userIcon","");
        model.addAttribute("userName",daifaUser.getDaifaUserName());
        model.addAttribute("menu","selOrderMove.htm");//前台所要的左边菜单
        return "daifa/selOrderMove";
    }


    @RequestMapping("daifa/getDaifaTrade")
    @ResponseBody
    public List<StatusMoveVo> getPage(Long dfTradeId, Long dfOrderId, Model model){
        List<StatusMoveVo> moveVoList= daifaOrderStatusMoveService.getStatusMoveVo(dfTradeId, dfOrderId);
        model.addAttribute("moveVoList",moveVoList);
        return moveVoList;
    }



}
