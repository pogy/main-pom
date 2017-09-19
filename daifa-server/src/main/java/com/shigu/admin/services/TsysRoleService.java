package com.shigu.admin.services;

import com.opentae.data.daifa.beans.TsysRole;
import com.opentae.data.daifa.examples.TsysRoleExample;
import com.opentae.data.daifa.interfaces.TsysRoleMapper;

import com.shigu.admin.bo.TsysRoleBO;
import com.shigu.admin.vo.TsysRoleVO;
import com.shigu.main4.daifa.process.SysDealProcess;
import com.shigu.tools.DateParseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @类编号
 * @类名称：TsysRoleService
 * @文件路径：com.shigu.admin.services.TsysRoleService
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/18 09:19
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service
public class TsysRoleService {
    private TsysRoleMapper tsysRoleMapper;
    @Autowired
    private SysDealProcess sysDealProcess;
    @Autowired
    public void setTsysRoleMapper(TsysRoleMapper tsysRoleMapper) {
        this.tsysRoleMapper = tsysRoleMapper;
    }
    /**
     * ====================================================================================
     * @方法名： listByPage
     * @user gzy 2017/9/19 11:32
     * @功能：
     * @param: [bo]
     * @return: java.util.List<com.shigu.admin.vo.TsysRoleVO>
     * @exception:
     * ====================================================================================
     *
     */
    public List<TsysRoleVO> listByPage(TsysRoleBO bo) {

        TsysRoleExample example = new TsysRoleExample();
        example.setOrderByClause("role_id desc");
        TsysRoleExample.Criteria ce = example.createCriteria();
        if (bo.getRoleName()!=null&& StringUtils.hasText(bo.getRoleName()+"")) {//角色名
            ce.andRoleNameEqualTo (bo.getRoleName());
            //ce.andDfTradeIdLike("%" + bo.getDfTradeId()).or().andTradeCodeLike("%"+bo.getDfTradeId());
        }

        if(bo.getRoleTag()!=null&&StringUtils.hasText(bo.getRoleTag()+"")){//标签名
            ce.andRoleTagEqualTo (bo.getRoleTag ());
        }

        if(bo.getCreateUserId()!=null&&StringUtils.hasText(bo.getCreateUserId()+"")){//sellerId
            ce.andCreateUserIdEqualTo (bo.getCreateUserId ());
        }
        if(bo.getStatus()!=null&&StringUtils.hasText(bo.getStatus()+"")){//可用状态
            ce.andStatusEqualTo (bo.getStatus ());
        }

        if (StringUtils.isEmpty(bo.getPage())) {
            bo.setPage("1");
        }
        //分页
        int page = Integer.parseInt(bo.getPage());
        int rows = 10;
        example.setStartIndex((page - 1) * rows);
        example.setEndIndex(rows);
        //总条数
        int count= tsysRoleMapper.countByExample (example);
        bo.setCount (count);

        List<TsysRoleVO> listVO=new ArrayList<> ();
        //按条件查询本页数据
        List<TsysRole> list=tsysRoleMapper.selectByConditionList (example);
        if(list.size ()>0){
            for (TsysRole order: list) {
                //设置成前台可用的页面
                TsysRoleVO vo=new TsysRoleVO ();
                BeanUtils.copyProperties(order, vo );
                vo.setCreateTime (DateParseUtil.parseDate ("yyyy-MM-dd hh:mm:ss",order.getCreateTime ()));
                listVO.add (vo);
            }
        }
        //返回前台页面
        return listVO;
    }
    /**
     * ====================================================================================
     * @方法名： insert
     * @user gzy 2017/9/19 11:31
     * @功能：插入角色
     * @param: [bo]
     * @return: int
     * @exception:
     * ====================================================================================
     *
     */
    public int insert(TsysRoleBO bo){

        return sysDealProcess.roleInsert (bo.getRoleName (),bo.getRoleTag (),bo.getCreateUserId (),bo.getStatus (),bo.getRoleComment ());
    }
    /**
     * ====================================================================================
     * @方法名： update
     * @user gzy 2017/9/19 11:31
     * @功能：修改角色
     * @param: [bo]
     * @return: int
     * @exception:
     * ====================================================================================
     *
     */
    public int update(TsysRoleBO bo){

        return sysDealProcess.roleUpdate (bo.getRoleId (),bo.getRoleName (),bo.getRoleTag (),bo.getCreateUserId (),bo.getStatus (),bo.getRoleComment ());
    }


}
