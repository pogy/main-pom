package com.shigu.admin.actions;



import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.main4.order.process.TemplateProcess;
import com.shigu.main4.order.vo.*;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @编码作者：sy
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Controller
public class ExpressTemplateAction {

    @Autowired
    TemplateProcess templateProcess;

    /*
    * 跳转到添加页面
    * 返回模版id
    * 返回快递公司列表
    */
    @RequestMapping("/daifa/addCourierTemp")
    public String addCourierTemp(HttpServletRequest request,Model model){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser daifaUser = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        Long tempId = templateProcess.addExpressTemplate(daifaUser.getDaifaSellerId());
        List<ExpressCompanyVo> courierList = templateProcess.selectExpressCompany();
        JSONArray json = JSONArray.fromObject(courierList);
        model.addAttribute("tempId",tempId);
        model.addAttribute("courierList",json.toString());
        return "daifa/addCourierTemp";
    }

    /*
     * 跳转到添加页面
     * 返回模版id
     * 返回快递公司列表
     */
    @RequestMapping("/daifa/addTempGroup")
    @ResponseBody
    public JSONObject addTempGroup(Long tempId,Model model){
        Long groupId = templateProcess.addExpressParentRule(tempId);
        if (groupId == null || groupId < 0){
            return JsonResponseUtil.error("添加失败，请重试");
        }
        return  JsonResponseUtil.success().element("groupId",groupId);
    }

    /*
     * 跳转到添加页面
     * 返回模版id
     * 返回快递公司列表
     */
    @RequestMapping("/daifa/addFreightBar")
    @ResponseBody
    public JSONObject addFreightBar(Long tempId,String freightText,Integer threshold,Model model){
        Long freightId = templateProcess.addExpressdefaultRule(tempId,threshold,freightText);
        if (freightId == null || freightId < 0){
            return JsonResponseUtil.error("添加失败，请重试");
        }
        model.addAttribute("freightId",freightId);
        return  JsonResponseUtil.success().element("freightId",freightId);
    }

    @RequestMapping("/daifa/deleteFreightBar")
    @ResponseBody
    public JSONObject deleteFreightBar(Long tempId,Integer threshold){
        Integer b = templateProcess.deleteExpressdefaultRule(tempId,threshold);
        if (b == null || b <= 0){
            return JsonResponseUtil.error("删除失败，请重试");
        }
        return  JsonResponseUtil.success();
    }

    @RequestMapping("/daifa/getProvsData")
    @ResponseBody
    public JSONObject getProvsData(Model model){
        List<ExpressProv> expressProvList = templateProcess.selectProvList();
        if (expressProvList == null || expressProvList.size() <= 0){
            return JsonResponseUtil.error("获取失败，请重试");
        }
        return  JsonResponseUtil.success().element("provList",expressProvList);
    }

    @RequestMapping("/daifa/setGroupProvsData")
    @ResponseBody
    public JSONObject setGroupProvsData(Long tempId,String provIds,Long groupId,Model model){
        Integer b = templateProcess.insertExpressProv(tempId,groupId,provIds);
        if (b == null || b <= 0){
            return JsonResponseUtil.error("添加失败，请重试");
        }
        return  JsonResponseUtil.success();
    }

    @RequestMapping("/daifa/deleteGroupData")
    @ResponseBody
    public JSONObject deleteGroupData(Long groupId,Model model){
        Integer b = templateProcess.deleteParentRule(groupId);
        if (b == null || b <= 0){
            return JsonResponseUtil.error("删除失败，请重试");
        }
        return  JsonResponseUtil.success();
    }

    @RequestMapping("/daifa/saveCourierTemp")
    @ResponseBody
    public JSONObject saveCourierTemp(Integer webType, String courierTemp, Model model){
        Integer b = null;
        if (webType == 1){
          b = templateProcess.EditExpressTemplate(courierTemp);
        }else {
          b = templateProcess.saveExpressTemplate(courierTemp);
        }
        if (b == null || b <= 0){
            return JsonResponseUtil.error("添加失败，请重试");
        }
        return  JsonResponseUtil.success();
    }

    /*
     * 跳转到编辑页面
     * 返回模版信息
     * 返回快递公司列表
     */
    @RequestMapping("/daifa/editCourierTemp")
    public String editCourierTemp(Long tempId,Model model){
        editExpressTemplate editTemplate = templateProcess.selectEditTemplate(tempId);
        List<ExpressCompanyVo> courierList = templateProcess.selectExpressCompany();
        JSONArray json = JSONArray.fromObject(courierList);
        model.addAttribute("tempId",tempId);
        model.addAttribute("courierId",editTemplate.getCourierId());
        model.addAttribute("initiateIs",editTemplate.getInitiateIs());
        model.addAttribute("freightList",editTemplate.getEditDefaultRuleVos());
        model.addAttribute("groupList",editTemplate.getParentRuleGroups());
        model.addAttribute("courierList",json.toString());
        return  "daifa/editCourierTemp";
    }

//    @RequestMapping("/daifa/saveEditCourierTemp")
//    @ResponseBody
//    public JSONObject saveEditCourierTemp(String expressTemplate,Model model){
//        Integer b = templateProcess.EditExpressTemplate(expressTemplate);
//        if (b == null || b <= 0){
//            return JsonResponseUtil.error("添加失败，请重试");
//        }
//        return  JsonResponseUtil.success();
//    }

    @RequestMapping("/daifa/showCourierTemp")
    public String showCourierTemp(Model model){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser daifaUser = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        List<ShowTempVo> courierTempList = templateProcess.selectTemplateAll(daifaUser.getDaifaSellerId());
        model.addAttribute("courierTempList",courierTempList);
        return  "daifa/showCourierTemp";
    }

    @RequestMapping("/daifa/setInitiateOrStopTemp")
    @ResponseBody
    public JSONObject deleteGroupData(Long tempId,Boolean checkedIs,Model model){
        Integer b = templateProcess.templateEnabled(tempId,checkedIs);
        if (b == null || b <= 0){
            return JsonResponseUtil.error("删除失败，请重试");
        }
        return  JsonResponseUtil.success();
    }
}
