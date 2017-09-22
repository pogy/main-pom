package com.shigu.main4.daifa.process.impl;

import com.opentae.data.daifa.beans.TsysPermission;
import com.opentae.data.daifa.beans.TsysRole;
import com.opentae.data.daifa.beans.TsysUserRole;
import com.opentae.data.daifa.examples.TsysUserRoleExample;
import com.opentae.data.daifa.interfaces.TsysPermissionMapper;
import com.opentae.data.daifa.interfaces.TsysRoleMapper;
import com.opentae.data.daifa.interfaces.TsysUserRoleMapper;
import com.shigu.main4.daifa.bo.TsysRoleBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.SysDealProcess;
import com.shigu.main4.daifa.vo.OrderSendErrorDealVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @类编号
 * @类名称：SysDealProcessImpl
 * @文件路径：com.shigu.main4.daifa.process.impl.SysDealProcessImpl
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/19 11:08
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service("sysDealProcess")
public class SysDealProcessImpl implements SysDealProcess{
    @Resource(name = "tae_daifa_tsysRoleMapper")
    TsysRoleMapper tsysRoleMapper;
    @Resource(name = "tae_daifa_tsysPermissionMapper")
    TsysPermissionMapper tsysPermissionMapper;
    @Resource(name = "tae_daifa_tsysUserRoleMapper")
    TsysUserRoleMapper tsysUserRoleMapper;

    /**
     * ====================================================================================
     * @方法名： roleInsert
     * @user gzy 2017/9/19 11:23
     * @功能：
     * @param: [roleName, roleTag, createUserId, status, roleComment]
     * @return: int
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public int roleInsert (String roleName, String roleTag, Long createUserId, Long status, String roleComment) {

        TsysRole role=new TsysRole ();
        role.setRoleName (roleName);
        role.setRoleTag (roleTag);
        role.setCreateUserId (createUserId);
        role.setStatus (status);
        role.setRoleComment (roleComment);
        role.setCreateTime (new Date ());
        return tsysRoleMapper.insertSelective (role);
    }
    /**
     * ====================================================================================
     * @方法名： roleUpdate
     * @user gzy 2017/9/19 11:24
     * @功能：
     * @param: [roleId, roleName, roleTag, createUserId, status, roleComment]
     * @return: int
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public int roleUpdate (Long roleId, String roleName, String roleTag, Long createUserId, Long status, String roleComment) {

        TsysRole role=new TsysRole ();
        role.setRoleId (roleId);
        role.setRoleName (roleName);
        role.setRoleTag (roleTag);
        role.setCreateUserId (createUserId);
        role.setStatus (status);
        role.setRoleComment (roleComment);
        return tsysRoleMapper.updateByPrimaryKeySelective (role);

    }

    @Override public int permissionInsert (String namespace, String permissionTag, Long createUserId, Long status, String permissionComment, Long parentPid) {
        TsysPermission record=new TsysPermission ();
        record.setNamespace (namespace);
        record.setCreateUserId (createUserId);
        record.setParentPid (parentPid);
        record.setPermissionTag (permissionTag);
        record.setPermissionComment (permissionComment);
        record.setStatus (status);
        return tsysPermissionMapper.insertSelective (record);
    }

    @Override public int permissionUpdate (Long permissionId, String namespace, String permissionTag, Long createUserId, Long status, String permissionComment, Long parentPid) {
        TsysPermission record=new TsysPermission ();
        record.setPermissionId (permissionId);
        record.setNamespace (namespace);
        record.setCreateUserId (createUserId);
        record.setParentPid (parentPid);
        record.setPermissionTag (permissionTag);
        record.setPermissionComment (permissionComment);
        record.setStatus (status);


        return tsysPermissionMapper.updateByPrimaryKeySelective (record);
    }


    @Override
    @Transactional(rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public int updateUserAndRoles (Long userId, String roleIds) throws DaifaException {

        String roleIdss[]=roleIds.split (",");
        //删除原有的用户角色，
        TsysUserRoleExample example=new TsysUserRoleExample();
        example.createCriteria ().andUserIdEqualTo (userId);
        tsysUserRoleMapper.deleteByExample (example);
        List<TsysUserRole> list=new ArrayList<> ();
        //再进行插入相应的用户角色
        if(roleIdss.length>0){
            for(String sroleId:roleIdss){
                Long roleId=new Long(sroleId);
                TsysUserRole userRole=new TsysUserRole();
                userRole.setRoleId (roleId);
                userRole.setUserId (userId);
                userRole.setCreateTime (new Date ());
                list.add (userRole);
            }
        }

       return tsysUserRoleMapper.insertListNoId (list);

    }
}
