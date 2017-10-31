package com.shigu.admin.actions;

import com.shigu.admin.bo.RoleAndPermissionBO;
import com.shigu.admin.services.RoleAndPermissionService;
import com.shigu.admin.vo.*;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.main4.daifa.exceptions.DaifaException;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @类编号
 * @类名称：RoleAndPermissionAction
 * @文件路径：com.shigu.admin.actions.RoleAndPermissionAction
 * @内容摘要：角色权限
 * @编码作者：gzy
 * @创建日期：2017/9/22 14:55
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Controller
public class RoleAndPermissionAction {
    @Autowired
    RoleAndPermissionService roleAndPermissionService;
    /**
     * ====================================================================================
     * @方法名： roleAndPermission
     * @user gzy 2017/10/13 14:38
     * @功能：角色权限
     * @param: [bo, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/roleAndPermission")
    public String roleAndPermission(RoleAndPermissionBO bo, Model model) throws ExecutionException, InterruptedException {

        Session session = SecurityUtils.getSubject().getSession();
        String auth = (String) session.getAttribute(DaifaSessionConfig.DAIFA_SYS_SESSION);
        Long sellerId=999999990L;

        List<RoleTreeVO> roleTree= roleAndPermissionService.listAllRole (sellerId);
        List<PermissionTreeVO> permissionTree= roleAndPermissionService.listAllPermission (sellerId);
        model.addAttribute("permissionTree", permissionTree);
        model.addAttribute("query", bo);
        model.addAttribute("roleTree", roleTree);
        model.addAttribute("userName", auth);

        return "admin/roleAndPermission";
    }

    /**
     * ====================================================================================
     * @方法名： jsonRoleAndPermission
     * @user gzy 2017/9/21 14:00
     * @功能：角色权限显示
     * @param: [bo]
     * @return: net.sf.json.JSONArray
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/jsonRoleAndPermission")
    @ResponseBody
    public JSONObject jsonRoleAndPermission(RoleAndPermissionBO bo) throws DaifaException {

        List<RolePermissionVO> list=roleAndPermissionService.listPermissionByRoleId (bo.getRoleId ());
        JSONObject obj=new JSONObject ();
        obj.put ("list",list);
        obj.put ("result","success");
        obj.put ("msg","成功！");
        return obj;
        // return (JSONArray) JsonObjectFilter.getJsonObject(list).get("list");
    }
    /**
     * ====================================================================================
     * @方法名： jsonupdateRoleAndPermissions
     * @user gzy 2017/9/22 10:06
     * @功能： 更新用户角色
     * @param: [bo]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/jsonupdateRoleAndPermissions")
    @ResponseBody
    public JSONObject updateRoleAndPermissions(RoleAndPermissionBO bo)throws DaifaException{

        JSONObject obj=new JSONObject ();
        int i= roleAndPermissionService.updateRoleAndPermissions (bo);
        if(i>0){
            obj.put ("result","success");
            obj.put ("msg","操作成功");
        }else{
            obj.put ("result","error");
            obj.put ("msg","操作失败请稍后重新操作！");
        }

        return obj;
    }
}
