package com.shigu.admin.services;

import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.data.daifa.beans.DaifaOrder;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.interfaces.DaifaOrderMapper;
import com.shigu.admin.bo.OrderRefundBO;
import com.shigu.admin.vo.OrderRefundVO;
import com.shigu.daifa.vo.DaifaAllOrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;


/**
 * @类编号
 * @类名称：OrderRefundService
 * @文件路径：com.shigu.admin.services.OrderRefundService
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/12 17:48
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service
public class OrderRefundService {
    @Autowired
    DaifaOrderMapper daifaOrderMapper;

    public List<OrderRefundVO> refundOrderPage(OrderRefundBO bo) {

        DaifaOrderExample doex = new DaifaOrderExample();

        doex.setOrderByClause("df_trade_id desc,df_order_id asc");
        DaifaOrderExample.Criteria ce = doex.createCriteria();

        if (bo.getDfTradeId()!=null&&StringUtils.hasText(bo.getDfTradeId()+"")) {
            ce.andDfTradeIdLike("%" + bo.getDfTradeId()).or().andTradeCodeLike("%"+bo.getDfTradeId());
        }
        if (StringUtils.isEmpty(bo.getPage())) {
            bo.setPage("1");
        }
        if(bo.getSuborderId()!=null&&StringUtils.hasText(bo.getSuborderId()+"")){
            ce.andDfOrderIdLike ("%"+bo.getSuborderId ()+"").or ().andOrderCodeLike("%"+bo.getSuborderId());
        }
        List<OrderRefundVO> listVO=new ArrayList<> ();
        List<DaifaOrder> list=daifaOrderMapper.selectByExample (doex);
        if(list.size ()>0){
            for (DaifaOrder order: list) {

                OrderRefundVO vo=new OrderRefundVO ();
                BeanUtils.copyProperties(order, vo );
                listVO.add (vo);
            }
        }

        return listVO;
    }
}
