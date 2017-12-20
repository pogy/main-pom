package com.shigu.order.decorateUtil.concreteDetorates;

import com.shigu.main4.order.servicevo.ExpressLogVO;
import com.shigu.main4.order.servicevo.ReturnableExpressInfoVO;
import com.shigu.order.decorateUtil.AbstractRefundVo;
import com.shigu.order.decorateUtil.RefundVoDecorate;
import com.shigu.order.vo.ExpressDetailVO;
import com.shigu.order.vo.ExpressVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pc on 2017-07-26.
 *修饰快递日志
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class RefundExpressInfoDecorate extends RefundVoDecorate {
    private ReturnableExpressInfoVO returnableExpressInfoVO;
    private List<ExpressLogVO> loglist = new ArrayList<>();

    public RefundExpressInfoDecorate(AbstractRefundVo vo, ReturnableExpressInfoVO returnableExpressInfoVO
            ,List<ExpressLogVO> loglist){
        super(vo);
        this.returnableExpressInfoVO =returnableExpressInfoVO;
        this.loglist = loglist;
    }
    private void setRefundExpressInfo(){
        Map<String,Object> map = new HashMap<>();
        ExpressVO vo = new ExpressVO();
//        vo.setId(returnableExpressInfoVO.getExpressCode());
        vo.setCode(returnableExpressInfoVO.getExpressCode());
        vo.setName(returnableExpressInfoVO.getExpressName());
        vo.setCreateTime(returnableExpressInfoVO.getReturnableExpressTime());
        List<ExpressDetailVO> elist= new ArrayList<>();
        vo.setDetail(elist);
        if (loglist != null) {
            for (ExpressLogVO logVO : loglist) {
                ExpressDetailVO vode = new ExpressDetailVO();
                vode.setDate(logVO.getLogDate());
                vode.setDesc(logVO.getLogDesc());
                vode.setTime(logVO.getLogTime());
                elist.add(vode);

            }
        }
        map.put("express",vo);
        super.addMap(map);
    }

    @Override
    public void doAdd() {
        setRefundExpressInfo();
        super.doAdd();
    }
}
