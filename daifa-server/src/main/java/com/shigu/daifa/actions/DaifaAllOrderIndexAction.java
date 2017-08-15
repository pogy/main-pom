package com.shigu.daifa.actions;

import com.opentae.data.daifa.beans.DaifaAllOrder;
import com.opentae.data.daifa.beans.DaifaWorker;
import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.AllOrderBO;
import com.shigu.daifa.services.DaifaAllOrderIndexService;
import com.shigu.daifa.vo.AllSubOrderVO;
import com.shigu.daifa.vo.DaifaAllOrderVO;
import com.shigu.daifa.vo.DaifaWorkerVO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.tools.JsonResponseUtil;
import com.sun.org.apache.bcel.internal.generic.RETURN;
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

    @RequestMapping("daifa/orderAll")
    public String allOrderPage(AllOrderBO bo,Model model){
        List<DaifaAllOrderVO> allOrders =  daifaAllOrderIndexService.allOrderPage(bo);
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);


        String pageOption = bo.getCount()+","+"10"+","+bo.getPage();
        model.addAttribute("orders",allOrders);
        model.addAttribute("query",bo);
        model.addAttribute("pageOption",pageOption);
        model.addAttribute("userName",auth.getUserName());
        return "daifa/orderAll";
    }

    @RequestMapping(value = "daifa/addChildRemarkJson",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addChildRemarkJson(@RequestParam(value = "childOrderId") Long childOrderId, String remarkCon) throws DaifaException {
        return daifaAllOrderIndexService.addChildRemarkJson(childOrderId,remarkCon);
    }
    @RequestMapping(value="daifa/getUserList",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getUserList(){
        List<DaifaWorkerVO> workers = daifaAllOrderIndexService.getUserList();
        return JsonResponseUtil.success().element("userList",workers);
    }

    /**
     * 设置有货时间
     * @param childOrderId 字单id
     * @param timeStr 时间
     * @return json
     */
    @RequestMapping(value = "daifa/setTimeJson",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject setTimeJson(@RequestParam(value = "childOrderId") Long childOrderId,String timeStr){

        return daifaAllOrderIndexService.setTimeJson(childOrderId,timeStr);
    }

    @RequestMapping(value = "daifa/setTallyJson",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject setTallyJson(Long userId,@RequestParam("childOrderId") Long childOrderId){

        return daifaAllOrderIndexService.setTallyJson(userId,childOrderId);
    }

}
