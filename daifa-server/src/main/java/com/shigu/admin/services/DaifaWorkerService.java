package com.shigu.admin.services;


import java.util.List;
import java.util.ArrayList;
import com.shigu.main4.daifa.process.SysDealProcess;
import org.apache.log4j.Logger;
import com.opentae.common.beans.LogUtil;
import com.opentae.data.daifa.beans.DaifaWorker;
import com.opentae.data.daifa.examples.DaifaWorkerExample;
import com.opentae.data.daifa.interfaces.DaifaWorkerMapper;
import com.shigu.admin.bo.DaifaWorkerBO;
import com.shigu.admin.vo.DaifaWorkerVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：DaifaWorkerService.java
 *@文件路径：com.shigu.admin.services.DaifaWorkerService
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-10-26 01:54:17
 *@comments:
 *@since 1.0
 *=========================================================
 */
@Service
public class DaifaWorkerService {

	private static final Logger log = LogUtil.getLog( DaifaWorkerService.class );
	
	 private DaifaWorkerMapper daifaWorkerMapper;
    @Autowired
    private SysDealProcess sysDealProcess;
    
    @Autowired
    public void setDaifaWorkerMapper(DaifaWorkerMapper daifaWorkerMapper) {
        this.daifaWorkerMapper = daifaWorkerMapper;
    }

    public DaifaWorker selectById(Long workerId){
        return daifaWorkerMapper.selectByPrimaryKey(workerId);
    }
	
	/**
     * ====================================================================================
     * @方法名： listByPage
     * @user gzy 2017/9/19 11:32
     * @功能：
     * @param: [bo]
     * @return: java.util.List<com.shigu.admin.vo.DaifaWorkerVO>
     * @exception:
     * ====================================================================================
     *
     */
    public List<DaifaWorkerVO> listByPage(DaifaWorkerBO bo) {

        DaifaWorkerExample example = new DaifaWorkerExample();
        example.setOrderByClause("daifa_worker_id desc");
        DaifaWorkerExample.Criteria ce = example.createCriteria();
        //if (bo.getRoleName()!=null&& StringUtils.hasText(bo.getRoleName()+"")) {//
           // ce.andRoleNameEqualTo (bo.getRoleName());
            //ce.andDfTradeIdLike("%" + bo.getDfTradeId()).or().andTradeCodeLike("%"+bo.getDfTradeId());
        //}

        if (StringUtils.isEmpty(bo.getPage())) {
            bo.setPage("1");
        }
        //分页
        int page = Integer.parseInt(bo.getPage());
        int rows = 10;
        example.setStartIndex((page - 1) * rows);
        example.setEndIndex(rows);
        //总条数
        int count= daifaWorkerMapper.countByExample (example);
        bo.setCount (count);

        List<DaifaWorkerVO> listVO=new ArrayList<> ();
        //按条件查询本页数据
        List<DaifaWorker> list=daifaWorkerMapper.selectByConditionList (example);
        if(list.size ()>0){
            for (DaifaWorker order: list) {
                //设置成前台可用的页面
                DaifaWorkerVO vo=new DaifaWorkerVO ();
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
    public int insert(DaifaWorkerBO bo){
    	
    	DaifaWorker record=new DaifaWorker();
    	BeanUtils.copyProperties(bo, record );

    	return sysDealProcess.userInsert (record.getDaifaSellerId (),record.getDfGroupId (),record.getDaifaWorker (),record.getPassword (),record.getUserName (),record.getPhone (),record.getWorkType (),record.getPayBaoAccount (),record.getWorkerId (),record.getRoleId ());
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
    public int update(DaifaWorkerBO bo){
			DaifaWorker record=new DaifaWorker();
    	BeanUtils.copyProperties(bo, record );
    	return sysDealProcess.userUpdate (record.getDaifaWorkerId (),record.getDaifaSellerId (),record.getDfGroupId (),record.getDaifaWorker (),record.getPassword (),record.getUserName (),record.getPhone (),record.getWorkType (),record.getPayBaoAccount (),record.getWorkerId (),record.getRoleId (),record.getUseStatus ());
    }
	
}
