package com.shigu.admin.actions;

import com.shigu.admin.bo.TsysRoleBO;
import com.shigu.admin.services.TsysRoleService;
import com.shigu.admin.vo.TsysRoleVO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @类编号
 * @类名称：TsysRoleAction
 * @文件路径：com.shigu.admin.actions.TsysRoleAction
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/18 09:15
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Controller
public class TsysRoleAction {
    @Autowired
    TsysRoleService tsysRoleService;

    @RequestMapping("admin/roleListByPage")
    public String listByPage(TsysRoleBO bo, Model model) throws ExecutionException, InterruptedException {

        //Session session = SecurityUtils.getSubject().getSession();
        //  AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        List<TsysRoleVO> allOrders = tsysRoleService.listByPage(bo);

        String pageOption = bo.getCount() + "," + "10" + "," + bo.getPage();
        model.addAttribute("orders", allOrders);
        model.addAttribute("query", bo);
        model.addAttribute("pageOption", pageOption);
        model.addAttribute("userName", "gzy");
        return "admin/roleListByPage";
    }

    //添加
    /**
     * ====================================================================================
     * @方法名： insert
     * @user gzy 2017/9/12 17:47
     * @功能：插入
     * @param: [dfTradeId, receiverName, receiverAddr]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
   @RequestMapping("admin/roleAdd")
    @ResponseBody
    public JSONObject insert(TsysRoleBO bo) throws DaifaException {
        System.out.println("11111111");
       int i=tsysRoleService.insert (bo);
       if(i>0){
           return JsonResponseUtil.success();
       }else{
           return JsonResponseUtil.error ("修改错误！");
       }

    }

    /**
     * ====================================================================================
     * @方法名： update
     * @user gzy 2017/9/19 11:36
     * @功能：修改
     * @param: [bo]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/roleEdit")
    @ResponseBody
    public JSONObject update(TsysRoleBO bo) throws DaifaException {
        System.out.println("2222222");
        int i= tsysRoleService.update (bo);
            if(i>0){
                return JsonResponseUtil.success();
            }else{
                return JsonResponseUtil.error ("修改错误！");
            }

    }
}
