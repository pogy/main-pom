package com.shigu.admin.services;

import com.opentae.data.daifa.beans.DaifaWaitSend;
import com.opentae.data.daifa.examples.DaifaWaitSendExample;
import com.opentae.data.daifa.interfaces.DaifaWaitSendMapper;
import com.shigu.admin.bo.OrderWaitSendBO;
import com.shigu.admin.vo.DaifaWaitSendDealVO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.tools.DateParseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * @类编号
 * @类名称：DaifaWaitSendDealService
 * @文件路径：com.shigu.admin.services.DaifaWaitSendDealService
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/10/16 10:49
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service
public class DaifaWaitSendDealService {
    @Autowired
    private DaifaWaitSendMapper daifaWaitSendMapper;//待发货
    @Autowired
    private OrderManageProcess orderManageProcess;//未发订单显示状态的处理

    /**
     * ====================================================================================
     * @方法名： waitSendList
     * @user gzy 2017/10/16 12:49
     * @功能：待发货的订单
     * @param: [bo]
     * @return: java.util.List<com.opentae.data.daifa.beans.DaifaWaitSend>
     * @exception:
     * ====================================================================================
     *
     */
    public List<DaifaWaitSendDealVO> waitSendList(OrderWaitSendBO bo){

        DaifaWaitSendExample example = new DaifaWaitSendExample ();
        DaifaWaitSendExample.Criteria exampleCriteria = example.createCriteria();

        exampleCriteria.andSendStatusEqualTo (1);
        if(bo.getDfTradeId ()!=null&&bo.getDfTradeId ().intValue ()>0){
            exampleCriteria.andDfTradeIdLike("%" + bo.getDfTradeId());
        }

        if (StringUtils.hasText(bo.getReceiverName ())) {
            exampleCriteria.andReceiverNameEqualTo (bo.getReceiverName ());
        }
        if(bo.getOrderDisplay ()==null||bo.getOrderDisplay ().intValue ()==-1){

        }else{
            exampleCriteria.andOrderDisplayEqualTo (bo.getOrderDisplay ());
        }


        if (StringUtils.isEmpty(bo.getPage())) {
            bo.setPage("1");
        }
        int page = Integer.parseInt(bo.getPage());
        int rows = 10;
        example.setStartIndex((page - 1) * rows);
        example.setEndIndex(rows);
        int count= daifaWaitSendMapper.countByExample (example);

        List<DaifaWaitSend> list= daifaWaitSendMapper.selectByConditionList (example);
        bo.setCount (count);
        List<DaifaWaitSendDealVO> listVO=new ArrayList<> ();
        if(list.size ()>0){
            for (DaifaWaitSend order: list) {
                //设置成前台可用的页面
                DaifaWaitSendDealVO vo=new DaifaWaitSendDealVO ();
                BeanUtils.copyProperties(order, vo );
                vo.setCreateTime (DateParseUtil.parseDate ("yyyy-MM-dd hh:mm:ss", order.getCreateTime ()));
                listVO.add (vo);
            }
        }
        //返回前台页面
        return listVO;

    }
    /**
     * ====================================================================================
     * @方法名： dealWaitSendOrderDisplay
     * @user gzy 2017/10/16 13:10
     * @功能：待发订单的显示修改
     * @param: [dfTradeId, orderDisplay]
     * @return: void
     * @exception:
     * ====================================================================================
     *
     */
    public void dealWaitSendOrderDisplay(Long dfTradeId,Integer orderDisplay)throws DaifaException {

        orderManageProcess.dealWaitSendOrderDisplay (dfTradeId,orderDisplay);
    }


}
