package com.shigu.admin.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.DaifaWorker;
import com.opentae.data.daifa.beans.TsysRole;
import com.opentae.data.daifa.beans.TsysUserRole;
import com.opentae.data.daifa.examples.DaifaWorkerExample;
import com.opentae.data.daifa.examples.TsysRoleExample;
import com.opentae.data.daifa.examples.TsysUserRoleExample;
import com.opentae.data.daifa.interfaces.DaifaWorkerMapper;
import com.opentae.data.daifa.interfaces.TsysRoleMapper;
import com.opentae.data.daifa.interfaces.TsysUserRoleMapper;
import com.shigu.admin.bo.UserAndRoleBO;
import com.shigu.admin.vo.RoleTreeVO;
import com.shigu.admin.vo.UserRoleVO;
import com.shigu.admin.vo.UserTreeVO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.SysDealProcess;
import com.shigu.tools.DateParseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @类编号
 * @类名称：UserAndRoleService
 * @文件路径：com.shigu.admin.services.UserAndRoleService
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/21 12:54
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service
public class UserAndRoleService {


    @Autowired
    private SysDealProcess sysDealProcess;

    private TsysRoleMapper tsysRoleMapper;
    @Autowired
    public void setTsysRoleMapper(TsysRoleMapper tsysRoleMapper) {
        this.tsysRoleMapper = tsysRoleMapper;
    }
    private DaifaWorkerMapper daifaWorkerMapper;
    @Autowired
    public void setDaifaWorkerMapper(DaifaWorkerMapper daifaWorkerMapper) {
        this.daifaWorkerMapper = daifaWorkerMapper;
    }
    private TsysUserRoleMapper tsysUserRoleMapper;
    @Autowired
    public void setTsysUserRoleMapper(TsysUserRoleMapper tsysUserRoleMapper) {
        this.tsysUserRoleMapper = tsysUserRoleMapper;
    }
    /**
     * ====================================================================================
     * @方法名： listAllUser
     * @user gzy 2017/9/21 13:25
     * @功能：
     * @param: [sellerId]
     * @return: java.util.List<com.shigu.admin.vo.UserTreeVO>
     * @exception:
     * ====================================================================================
     *
     */
    public List<UserTreeVO> listAllUser(Long sellerId) {

        DaifaWorkerExample example=new DaifaWorkerExample ();
        example.createCriteria ().andDaifaSellerIdEqualTo (sellerId).andUseStatusEqualTo (1);
         List<DaifaWorker> list=daifaWorkerMapper.selectFieldsByExample (example, FieldUtil.codeFields ("daifa_worker_id,user_name"));//参数2是数据库中的字段以，分隔
        List<UserTreeVO> listVO=new ArrayList<> ();
        if(list.size ()>0){
            for (DaifaWorker user: list) {
                //设置成前台可用的页面
                UserTreeVO vo=new UserTreeVO ();
                BeanUtils.copyProperties(user, vo );
                listVO.add (vo);
            }
        }
        return listVO;
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
     * @方法名： listRoleByUserId
     * @user gzy 2017/9/21 13:47
     * @功能：用户角色树
     * @param: [userId]
     * @return: java.util.List<com.shigu.admin.vo.UserRoleVO>
     * @exception:
     * ====================================================================================
     *
     */
    public List<UserRoleVO> listRoleByUserId(Long userId){

        TsysUserRoleExample example=new TsysUserRoleExample ();
        example.createCriteria ().andUserIdEqualTo (userId);
        List<TsysUserRole> list=tsysUserRoleMapper.selectFieldsByExample (example,FieldUtil.codeFields ("user_role_id,user_id,role_id"));
        List<UserRoleVO> listVO=new ArrayList<> ();
        if(list.size ()>0){
            for (TsysUserRole record: list) {
                //设置成前台可用的页面
                UserRoleVO vo=new UserRoleVO ();
                BeanUtils.copyProperties(record, vo );
                listVO.add (vo);
            }
        }
        return listVO;

    }
    //=====================================以下是写的操作================================


    public int updateUserAndRoles(UserAndRoleBO bo)throws DaifaException {

       return sysDealProcess.updateUserAndRoles (bo.getUserId (),bo.getRoleIds ());
        //

    }

}
