package com.shigu.daifa.actions;

import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.AfterSaleBO;
import com.shigu.daifa.services.DaifaCustomerService;
import com.shigu.daifa.vo.DaifaCutomerDataVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * ====================================================================================
 * @方法名：
 * @user gzy 2017/10/13 13:09
 * @功能： 客服查询
 * @param: 
 * @return: 
 * @exception: 
 * ====================================================================================
 * 
 */
@Controller
public class DaifaCustomerAction {

    private DaifaCustomerService daifaCustomerService;
    @Autowired
    public void setDaifaCustomerService(DaifaCustomerService daifaCustomerService) {
        this.daifaCustomerService = daifaCustomerService;
    }
    /**
     * ====================================================================================
     * @方法名： afterSale
     * @user gzy 2017/10/13 13:08
     * @功能：客服查询
     * @param: [bo, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("daifa/orderForServer")
    public String afterSale(AfterSaleBO bo,Model model) {

        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        ShiguPager<DaifaCutomerDataVO> pager = daifaCustomerService.afterSaleData(auth.getDaifaSellerId(),bo);


        model.addAttribute("orders",pager.getContent());
        model.addAttribute("pageOption",pager.selPageOption(10));
        model.addAttribute("query",bo);
        model.addAttribute("userName",auth.getDaifaUserName ());
        model.addAttribute("menu","orderForServer.htm");//前台所要的左边菜单
        return "daifa/orderForServer";
    }
    /**
     * ====================================================================================
     * @方法名： addServerRemarkJson
     * @user gzy 2017/10/13 13:09
     * @功能：
     * @param: [orderId, remarkCon]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping(value = "daifa/addServerRemarkJson",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addServerRemarkJson(Long orderId,String remarkCon){

        if(orderId == null){
            return JsonResponseUtil.error("单号不能空");
        }
        if(StringUtils.isEmpty(remarkCon)){
            return JsonResponseUtil.error("备注不能为空");
        }
        return daifaCustomerService.addServerRemarkJson(orderId,remarkCon);
    }
}
