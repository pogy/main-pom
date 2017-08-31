package com.shigu.daifa.actions;

import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.AfterSaleBO;
import com.shigu.daifa.services.DaifaAfterSaleService;
import com.shigu.daifa.vo.AfterSaleDataVO;
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
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pc on 2017-08-31.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Controller
public class DaifaAfterSaleAction {

    private DaifaAfterSaleService daifaAfterSaleService;
    @Autowired
    public void setDaifaAfterSaleService(DaifaAfterSaleService daifaAfterSaleService) {
        this.daifaAfterSaleService = daifaAfterSaleService;
    }
    @RequestMapping("daifa/orderForServer")
    public String afterSale(AfterSaleBO bo,Model model) {
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        ShiguPager<AfterSaleDataVO> pager = daifaAfterSaleService.afterSaleData(auth.getDaifaSellerId(),bo);


        model.addAttribute("orders",pager.getContent());
        model.addAttribute("pageOption",pager.selPageOption(10));
        model.addAttribute("query",bo);

        return "daifa/orderForServer";
    }

    @RequestMapping("daifa/addChildRemarkJson")
    @ResponseBody
    public JSONObject addChildRemarkJson(Long orderId,String remarkCon){
        if(orderId == null){
            return JsonResponseUtil.error("单号不能空");
        }
        if(StringUtils.isEmpty(remarkCon)){
            return JsonResponseUtil.error("备注不能为空");
        }
        return daifaAfterSaleService.addChildRemarkJson(orderId,remarkCon);
    }
}
