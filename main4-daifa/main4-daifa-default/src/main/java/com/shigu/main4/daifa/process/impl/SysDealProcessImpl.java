package com.shigu.main4.daifa.process.impl;

import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.TsysRolePermissionExample;
import com.opentae.data.daifa.examples.TsysUserRoleExample;
import com.opentae.data.daifa.interfaces.*;
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
    @Resource(name = "tae_daifa_tsysRolePermissionMapper")
    TsysRolePermissionMapper tsysRolePermissionMapper;
    @Resource(name = "tae_daifa_daifaWorkerMapper")
    DaifaWorkerMapper daifaWorkerMapper;

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

    /**
     * ====================================================================================
     * @方法名： updateUserAndRoles
     * @user gzy 2017/9/22 15:23
     * @功能：修改用户角色
     * @param: [userId, roleIds]
     * @return: int
     * @exception:
     * ====================================================================================
     *
     */
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
        DaifaWorker worker=new DaifaWorker ();
        worker.setDaifaWorkerId (userId);
        worker.setRoleId (new Long(roleIdss[0]));
        worker.setRemark2 (roleIds);
        daifaWorkerMapper.updateByPrimaryKeySelective (worker);

       return tsysUserRoleMapper.insertListNoId (list);

    }
    /**
     * ====================================================================================
     * @方法名： updateRoleAndPermissions
     * @user gzy 2017/9/22 15:22
     * @功能：修改角色权限
     * @param: [roleId, permissionIds]
     * @return: int
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    @Transactional(rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public int updateRoleAndPermissions (Long roleId, String permissionIds) throws DaifaException {

        String permissionIdss[]=permissionIds.split (",");
        //删除原有的角色权限，
        TsysRolePermissionExample example=new TsysRolePermissionExample ();
        example.createCriteria ().andRoleIdEqualTo (roleId);
        tsysRolePermissionMapper.deleteByExample (example);
        List<TsysRolePermission> list=new ArrayList<> ();
        //再进行插入相应的角色权限
        if(permissionIdss.length>0){
            for(String spermissionId:permissionIdss){
                Long permissionId=new Long(spermissionId);
                TsysRolePermission rolePermission=new TsysRolePermission();
                rolePermission.setPermissionId (permissionId);
                rolePermission.setRoleId (roleId);
                rolePermission.setCreateTime (new Date ());
                rolePermission.setLastModifyTime (new Date ());
                list.add (rolePermission);
            }
        }

        return tsysRolePermissionMapper.insertListNoId (list);
    }
    /**
     * ====================================================================================
     * @方法名： userInsert
     * @user gzy 2017/10/26 14:17
     * @功能：
     * @param: daifaSellerId 代发机构ID
     * @param: dfGroupId 代发组ID
     * @param: daifaWorker代发人
     * @param: password 密码
     * @param: userName代发用户名
     * @param: phone手机号
     * @param: workType 类别@0管理员1拿货人2退货人3换货人4库管员
     * @param: payBaoAccount 付宝账户
     * @param: workerId
     * @param: roleId角色ID
     * @return: int
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public int userInsert (Long daifaSellerId, Long dfGroupId, String daifaWorker, String password, String userName, String phone, Integer workType,String payBaoAccount, Long workerId, Long roleId) {
        DaifaWorker worker=new DaifaWorker ();
        worker.setDaifaSellerId (daifaSellerId);
        worker.setDfGroupId (dfGroupId);
        worker.setDaifaWorker (daifaWorker);
        worker.setPassword (password);
        worker.setUserName (userName);
        worker.setPhone (phone);
        worker.setWorkType (workType);
        worker.setPayBaoAccount (payBaoAccount);
        worker.setWorkerId (workerId);
        worker.setRoleId (roleId);
        worker.setUseStatus (1);
        worker.setRemark2 (roleId+"");
        worker.setAccountId (-1L);
        return daifaWorkerMapper.insertSelective (worker);

    }
    /**
     * ====================================================================================
     * @方法名： userUpdate
     * @user gzy 2017/10/26 14:17
     * @功能：
     * @param: daifaWorkerId
     * @param: daifaSellerId 代发机构ID
     * @param: dfGroupId 代发组ID
     * @param: daifaWorker代发人
     * @param: password 密码
     * @param: userName代发用户名
     * @param: phone手机号
     * @param: workType 类别@0管理员1拿货人2退货人3换货人4库管员
     * @param: payBaoAccount 付宝账户
     * @param: workerId
     * @param: roleId角色ID
     * @param: useStatus状态0不可用1可用
     * @return: int
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public int userUpdate (Long daifaWorkerId, Long daifaSellerId, Long dfGroupId, String daifaWorker, String password, String userName, String phone, Integer workType,String payBaoAccount, Long workerId, Long roleId,Integer useStatus) {
        DaifaWorker worker=new DaifaWorker ();
        worker.setDaifaWorkerId (daifaWorkerId);
        worker.setDaifaSellerId (daifaSellerId);
        worker.setDfGroupId (dfGroupId);
        worker.setDaifaWorker (daifaWorker);
        worker.setPassword (password);
        worker.setUserName (userName);
        worker.setPhone (phone);
        worker.setWorkType (workType);
        worker.setPayBaoAccount (payBaoAccount);
        worker.setWorkerId (workerId);
        worker.setRoleId (roleId);
        worker.setUseStatus (useStatus);
        worker.setRemark2 (roleId+"");
        worker.setAccountId (-1L);
        return daifaWorkerMapper.updateByPrimaryKeySelective (worker);
    }
}
