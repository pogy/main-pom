package com.shigu.main4.daifa.process.impl;

import com.opentae.data.daifa.beans.TsysRole;
import com.opentae.data.daifa.interfaces.TsysRoleMapper;
import com.shigu.main4.daifa.bo.TsysRoleBO;
import com.shigu.main4.daifa.process.SysDealProcess;
import org.springframework.beans.BeanUtils;

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
public class SysDealProcessImpl implements SysDealProcess{
    @Resource(name = "tae_daifa_tsysRoleMapper")
    TsysRoleMapper tsysRoleMapper;

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
        return tsysRoleMapper.insert (role);
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
}
