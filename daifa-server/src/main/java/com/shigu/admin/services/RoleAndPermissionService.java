package com.shigu.admin.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.*;

import com.opentae.data.daifa.interfaces.TsysPermissionMapper;
import com.opentae.data.daifa.interfaces.TsysRoleMapper;
import com.opentae.data.daifa.interfaces.TsysRolePermissionMapper;
import com.opentae.data.daifa.interfaces.TsysUserRoleMapper;
import com.shigu.admin.bo.RoleAndPermissionBO;
import com.shigu.admin.bo.UserAndRoleBO;
import com.shigu.admin.vo.*;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.SysDealProcess;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @类编号
 * @类名称：RoleAndPermissionService
 * @文件路径：com.shigu.admin.services.RoleAndPermissionService
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/22 14:56
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service
public class RoleAndPermissionService {
    @Autowired
    private SysDealProcess sysDealProcess;

    private TsysRoleMapper tsysRoleMapper;
    @Autowired
    public void setTsysRoleMapper(TsysRoleMapper tsysRoleMapper) {
        this.tsysRoleMapper = tsysRoleMapper;
    }
    private TsysPermissionMapper tsysPermissionMapper;
    @Autowired
    public void setTsysPermissionMapper(TsysPermissionMapper tsysPermissionMapper) {
        this.tsysPermissionMapper = tsysPermissionMapper;
    }
    private TsysRolePermissionMapper tsysRolePermissionMapper;
    @Autowired
    public void setTsysRolePermissionMapper(TsysRolePermissionMapper tsysRolePermissionMapper) {
        this.tsysRolePermissionMapper = tsysRolePermissionMapper;
    }

    /**
     * ====================================================================================
     * @方法名： listAllRole
     * @user gzy 2017/9/21 13:33
     * @功能：
     * @param: [sellerId]
     * @return: java.util.List<com.shigu.admin.vo.RoleTreeVO>
     * @exception:
     * ====================================================================================
     *
     */
    public List<RoleTreeVO> listAllRole(Long sellerId){

        TsysRoleExample example=new TsysRoleExample ();
        example.createCriteria ().andCreateUserIdEqualTo (sellerId).andStatusEqualTo (1L);
        List<TsysRole> list=tsysRoleMapper.selectFieldsByExample (example, FieldUtil.codeFields ("role_id,role_name,role_tag"));
        List<RoleTreeVO> listVO=new ArrayList<> ();
        if(list.size ()>0){
            for (TsysRole record: list) {
                //设置成前台可用的页面
                RoleTreeVO vo=new RoleTreeVO ();
                BeanUtils.copyProperties(record, vo );
                listVO.add (vo);
            }
        }
        return listVO;
    }

    /**
     * ====================================================================================
     * @方法名： listAllPermission
     * @user gzy 2017/9/21 13:25
     * @功能：
     * @param: [sellerId]
     * @return: java.util.List<com.shigu.admin.vo.PermissionTreeVO>
     * @exception:
     * ====================================================================================
     *
     */
    public List<PermissionTreeVO> listAllPermission(Long sellerId) {

        TsysPermissionExample example=new TsysPermissionExample ();
        example.createCriteria ().andCreateUserIdEqualTo (sellerId).andStatusEqualTo (1L);
        List<TsysPermission> list=tsysPermissionMapper.selectFieldsByExample (example, FieldUtil.codeFields ("permission_id,permission_comment,permission_tag"));//参数2是数据库中的字段以，分隔
        List<PermissionTreeVO> listVO=new ArrayList<> ();
        if(list.size ()>0){
            for (TsysPermission record: list) {
                //设置成前台可用的页面
                PermissionTreeVO vo=new PermissionTreeVO ();
                BeanUtils.copyProperties(record, vo );
                listVO.add (vo);
            }
        }
        return listVO;
    }

    /**
     * ====================================================================================
     * @方法名： listPermissionByRoleId
     * @user gzy 2017/9/21 13:47
     * @功能：用户角色树
     * @param: [roleId]
     * @return: java.util.List<com.shigu.admin.vo.RolePermissionVO>
     * @exception:
     * ====================================================================================
     *
     */
    public List<RolePermissionVO> listPermissionByRoleId(Long roleId){

        TsysRolePermissionExample example=new TsysRolePermissionExample ();
        example.createCriteria ().andRoleIdEqualTo (roleId);
        List<TsysRolePermission> list=tsysRolePermissionMapper.selectFieldsByExample (example, FieldUtil.codeFields ("role_permission_id,role_id,permission_id"));
        List<RolePermissionVO> listVO=new ArrayList<> ();
        if(list.size ()>0){
            for (TsysRolePermission record: list) {
                //设置成前台可用的页面
                RolePermissionVO vo=new RolePermissionVO ();
                BeanUtils.copyProperties(record, vo );
                listVO.add (vo);
            }
        }
        return listVO;

    }
    //=====================================以下是写的操作================================


    public int updateRoleAndPermissions(RoleAndPermissionBO bo)throws DaifaException {

        return sysDealProcess.updateRoleAndPermissions (bo.getRoleId (),bo.getPermissionIds ());
        //

    }
}
