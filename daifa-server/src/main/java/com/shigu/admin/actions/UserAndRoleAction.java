package com.shigu.admin.actions;


import com.shigu.admin.bo.UserAndRoleBO;
import com.shigu.admin.services.UserAndRoleService;
import com.shigu.admin.vo.RoleTreeVO;
import com.shigu.admin.vo.UserRoleVO;
import com.shigu.admin.vo.UserTreeVO;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @类编号
 * @类名称：UserAndRoleAction
 * @文件路径：com.shigu.admin.actions.UserAndRoleAction
 * @内容摘要：用户角色
 * @编码作者：gzy
 * @创建日期：2017/9/21 11:12
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Controller
public class UserAndRoleAction {
    @Autowired
    UserAndRoleService userAndRoleService;
    /**
     * ====================================================================================
     * @方法名： userAndRole
     * @user gzy 2017/10/13 14:36
     * @功能：用户角色
     * @param: [bo, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/userAndRole")
    public String userAndRole(UserAndRoleBO bo, Model model) throws ExecutionException, InterruptedException {

        Session session = SecurityUtils.getSubject().getSession();
        String auth = (String) session.getAttribute(DaifaSessionConfig.DAIFA_SYS_SESSION);
        Long sellerId=999999990L;

        List<UserTreeVO> userTree= userAndRoleService.listAllUser (sellerId);
        List<RoleTreeVO> roleTree= userAndRoleService.listAllRole (sellerId);

        model.addAttribute("userTree", userTree);
        model.addAttribute("query", bo);
        model.addAttribute("roleTree", roleTree);
        model.addAttribute("userName", auth);

        return "admin/userAndRole";

    }

    /**
     * ====================================================================================
     * @方法名： jsonUserAndRole
     * @user gzy 2017/9/21 14:00
     * @功能：
     * @param: [bo]
     * @return: net.sf.json.JSONArray
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/jsonUserAndRole")
    @ResponseBody
    public JSONObject jsonUserAndRole(UserAndRoleBO bo) throws DaifaException {

        List<UserRoleVO> list=userAndRoleService.listRoleByUserId (bo.getUserId ());
        JSONObject obj=new JSONObject ();
        obj.put ("list",list);
        obj.put ("result","success");
        obj.put ("msg","成功！");
        return obj;
       // return (JSONArray) JsonObjectFilter.getJsonObject(list).get("list");
    }
    /**
     * ====================================================================================
     * @方法名： jsonInsertUserAndRoles
     * @user gzy 2017/9/22 10:06
     * @功能： 更新用户角色
     * @param: [bo]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/jsonupdateUserAndRoles")
    @ResponseBody
    public JSONObject updateUserAndRoles(UserAndRoleBO bo)throws DaifaException{

        JSONObject obj=new JSONObject ();
       int i= userAndRoleService.updateUserAndRoles (bo);
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
