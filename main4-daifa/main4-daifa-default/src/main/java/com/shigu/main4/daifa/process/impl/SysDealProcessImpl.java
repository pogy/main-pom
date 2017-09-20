package com.shigu.main4.daifa.process.impl;

import com.opentae.data.daifa.beans.TsysPermission;
import com.opentae.data.daifa.beans.TsysRole;
import com.opentae.data.daifa.interfaces.TsysPermissionMapper;
import com.opentae.data.daifa.interfaces.TsysRoleMapper;
import com.shigu.main4.daifa.bo.TsysRoleBO;
import com.shigu.main4.daifa.process.SysDealProcess;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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
}
