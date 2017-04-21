package com.shigu.component.shiro;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建角色权限对应类
 * Created by zhaohongbo on 16/5/27.
 */
//@Repository
public class SimpleRolePermissionReader {

    private static Map<String,Long> relationTime=new HashMap<String, Long>();
    private static Map<String,Collection> rolePermissions=new HashMap<String, Collection>();

    /**
     * 返回角色权限对应关系
     * @param s
     * @return
     */
    public Collection<Permission> resolvePermissionsInRole(String s) {

        //拿到这个角色最新的权限时间
//        Long lastTime=managerRolePermissionMapper.selLastModifyByRoleTag(s);
//        Long hereTime=relationTime.get(s);
//        Collection<Permission> list=null;
//        if(hereTime==null||!hereTime.equals(lastTime)){//拿动态
//            list=makeActivePermission(s);
//            rolePermissions.put(s,list);
//            relationTime.put(s,lastTime);
//        }else{//拿静态
//            list=rolePermissions.get(s);
//        }
//        return list;
        return null;
    }

    /**
     * 制作动态权限
     * @param s
     * @return
     */
    public Collection<Permission> makeActivePermission(String s){
//        List<RolePermission> permissions=managerPermissionMapper.selPermissiontagsByroleTag(s);
//        List<Permission> list=new ArrayList<Permission>();
//        for(RolePermission rp:permissions){
//            list.add(new WildcardPermission(rp.getPermissionTag()));
//        }
//        return list;
        return null;
    }
}
