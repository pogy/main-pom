package com.shigu.admin.services;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.shigu.main4.daifa.process.SysDealProcess;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import com.opentae.common.beans.LogUtil;
import com.opentae.data.daifa.beans.TsysPermission;
import com.opentae.data.daifa.examples.TsysPermissionExample;
import com.opentae.data.daifa.interfaces.TsysPermissionMapper;
import com.shigu.admin.bo.TsysPermissionBO;
import com.shigu.admin.vo.TsysPermissionVO;
import com.shigu.tools.DateParseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：TsysPermissionService.java
 *@文件路径：com.shigu.admin.services.TsysPermissionService
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-09-20 09:56:07
 *@comments:
 *@since 1.0
 *=========================================================
 */
@Service
public class TsysPermissionService {

	private static final Logger log = LogUtil.getLog( TsysPermissionService.class );
	
	 private TsysPermissionMapper tsysPermissionMapper;
   
    
    @Autowired
    public void setTsysPermissionMapper(TsysPermissionMapper tsysPermissionMapper) {
        this.tsysPermissionMapper = tsysPermissionMapper;
    }
    @Autowired
    private SysDealProcess sysDealProcess;
	
	
	/**
     * ====================================================================================
     * @方法名： listByPage
     * @user gzy 2017/9/19 11:32
     * @功能：
     * @param: [bo]
     * @return: java.util.List<com.shigu.admin.vo.TsysPermissionVO>
     * @exception:
     * ====================================================================================
     *
     */
    public List<TsysPermissionVO> listByPage(TsysPermissionBO bo) {

        TsysPermissionExample example = new TsysPermissionExample();
        example.setOrderByClause("permission_id desc");
        TsysPermissionExample.Criteria ce = example.createCriteria();
        //if (bo.getRoleName()!=null&& StringUtils.hasText(bo.getRoleName()+"")) {//
           // ce.andRoleNameEqualTo (bo.getRoleName());
            //ce.andDfTradeIdLike("%" + bo.getDfTradeId()).or().andTradeCodeLike("%"+bo.getDfTradeId());
        //}
        if (bo.getNamespace()!=null&& StringUtils.hasText(bo.getNamespace()+"")) {//
            ce.andNamespaceEqualTo (bo.getNamespace());
        }
        if (bo.getPermissionTag()!=null&& StringUtils.hasText(bo.getPermissionTag()+"")) {//
            ce.andPermissionTagEqualTo (bo.getPermissionTag());
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
        int count= tsysPermissionMapper.countByExample (example);
        bo.setCount (count);

        List<TsysPermissionVO> listVO=new ArrayList<> ();
        //按条件查询本页数据
        List<TsysPermission> list=tsysPermissionMapper.selectByConditionList (example);
        if(list.size ()>0){
            for (TsysPermission order: list) {
                //设置成前台可用的页面
                TsysPermissionVO vo=new TsysPermissionVO ();
                BeanUtils.copyProperties(order, vo );
                //vo.setCreateTime (DateParseUtil.parseDate ("yyyy-MM-dd hh:mm:ss",order.getCreateTime ()));
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
    public int insert(TsysPermissionBO bo){

        return sysDealProcess.permissionInsert (bo.getNamespace (),bo.getPermissionTag (),bo.getCreateUserId (),bo.getStatus (),bo.getPermissionComment (),bo.getParentPid ());
    	

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
    public int update(TsysPermissionBO bo){
        return sysDealProcess.permissionUpdate (bo.getPermissionId (),bo.getNamespace (),bo.getPermissionTag (),bo.getCreateUserId (),bo.getStatus (),bo.getPermissionComment (),bo.getParentPid ());
      
    }
	
}
