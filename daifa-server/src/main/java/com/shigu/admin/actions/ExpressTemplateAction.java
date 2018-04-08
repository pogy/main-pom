package com.shigu.admin.actions;



import com.shigu.main4.order.process.TemplateProcess;
import com.shigu.main4.order.vo.ExpressCompanyVo;
import com.shigu.main4.order.vo.ExpressProv;
import com.shigu.main4.order.vo.ShowTempVo;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping("addCourierTemp")
    public String addCourierTemp(Model model){
        Long tempId = templateProcess.addExpressTemplate();
        List<ExpressCompanyVo> courierList = templateProcess.selectExpressCompany();
        model.addAttribute("tempId",tempId);
        model.addAttribute("courierList",courierList);
        return "daifa/addCourierTemp";
    }

    /*
     * 跳转到添加页面
     * 返回模版id
     * 返回快递公司列表
     */
    @RequestMapping("addTempGroup")
    @ResponseBody
    public JSONObject addTempGroup(Long tempId,Model model){
        Long groupId = templateProcess.addExpressParentRule(tempId);
        if (groupId == null || groupId < 0){
            return JsonResponseUtil.error("添加失败，请重试");
        }
        model.addAttribute("groupId",groupId);
        return  JsonResponseUtil.success();
    }

    /*
     * 跳转到添加页面
     * 返回模版id
     * 返回快递公司列表
     */
    @RequestMapping("addFreightBar")
    @ResponseBody
    public JSONObject addFreightBar(Long tempId,String freightText,Integer threshold,Model model){
        Long freightId = templateProcess.addExpressdefaultRule(tempId,threshold,freightText);
        if (freightId == null || freightId < 0){
            return JsonResponseUtil.error("添加失败，请重试");
        }
        model.addAttribute("freightId",freightId);
        return  JsonResponseUtil.success();
    }

    @RequestMapping("deleteFreightBar")
    @ResponseBody
    public JSONObject deleteFreightBar(Long tempId,Integer threshold){
        Integer b = templateProcess.deleteExpressdefaultRule(tempId,threshold);
        if (b == null || b <= 0){
            return JsonResponseUtil.error("删除失败，请重试");
        }
        return  JsonResponseUtil.success();
    }

    @RequestMapping("getProvsData")
    @ResponseBody
    public JSONObject getProvsData(Model model){
        List<ExpressProv> expressProvList = templateProcess.selectProvList();
        if (expressProvList == null || expressProvList.size() <= 0){
            return JsonResponseUtil.error("获取失败，请重试");
        }
        model.addAttribute("expressProvList",expressProvList);
        return  JsonResponseUtil.success();
    }

    @RequestMapping("setGroupProvsData")
    @ResponseBody
    public JSONObject setGroupProvsData(Long tempId,String provIds,Long groupId,Model model){
        Integer b = templateProcess.insertExpressProv(tempId,groupId,provIds);
        if (b == null || b <= 0){
            return JsonResponseUtil.error("添加失败，请重试");
        }
        return  JsonResponseUtil.success();
    }

    @RequestMapping("deleteGroupData")
    @ResponseBody
    public JSONObject deleteGroupData(Long groupId,Model model){
        Integer b = templateProcess.deleteParentRule(groupId);
        if (b == null || b <= 0){
            return JsonResponseUtil.error("删除失败，请重试");
        }
        return  JsonResponseUtil.success();
    }

    @RequestMapping("saveCourierTemp")
    @ResponseBody
    public JSONObject saveCourierTemp(String expressTemplate,Model model){
        Integer b = templateProcess.saveExpressTemplate(expressTemplate);
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
    @RequestMapping("editCourierTemp")
    public String editCourierTemp(Long tempId,Model model){
        Map<String,Object> editTemplate = templateProcess.selectEditTemplate(tempId);
        List<ExpressCompanyVo> courierList = templateProcess.selectExpressCompany();
        model.addAttribute("tempId",tempId);
        model.addAttribute("courierId",editTemplate.get("courierId"));
        model.addAttribute("initiateIs",editTemplate.get("initiateIs"));
        model.addAttribute("freightList",editTemplate.get("freightList"));
        model.addAttribute("groupList",editTemplate.get("groupList"));
        model.addAttribute("courierList",courierList);
        return  "daifa/editCourierTemp";
    }

    @RequestMapping("saveEditCourierTemp")
    @ResponseBody
    public JSONObject saveEditCourierTemp(String expressTemplate,Model model){
        Integer b = templateProcess.EditExpressTemplate(expressTemplate);
        if (b == null || b <= 0){
            return JsonResponseUtil.error("添加失败，请重试");
        }
        return  JsonResponseUtil.success();
    }

    @RequestMapping("showCourierTemp")
    public String showCourierTemp(Model model){
        List<ShowTempVo> courierTempList = templateProcess.selectTemplateAll();
        model.addAttribute("courierTempList",courierTempList);
        return  "daifa/showCourierTemp";
    }
}
