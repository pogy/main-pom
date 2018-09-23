package com.shigu.daifa.actions;

import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.services.DaifaOrderStatusMoveService;
import com.shigu.daifa.vo.OpenInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("daifa/orderOpeInfo")
    public String showCourierTemp(String childOrderId,Model model){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser daifaUser = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);

        List<OpenInfo> openInfoList = new ArrayList<>();
        if (StringUtils.isNotBlank(childOrderId)) {
            try {
                openInfoList = daifaOrderStatusMoveService.getStatusMoveVo(Long.valueOf(childOrderId));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        Map map = new HashMap();
        map.put("childOrderId",childOrderId);
        model.addAttribute("opeInfoList",openInfoList);
        model.addAttribute("query",map);
        model.addAttribute("userIcon","");
        model.addAttribute("userName",daifaUser.getDaifaUserName());
        model.addAttribute("menu","orderOpeInfo.htm");//前台所要的左边菜单
        return "daifa/orderOpeInfo";
    }

}
