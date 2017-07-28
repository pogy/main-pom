package com.shigu.order.decorateVo.concreteDetorates;

import com.shigu.main4.order.servicevo.ExpressLogVO;
import com.shigu.main4.order.servicevo.ReturnableExpressInfoVO;
import com.shigu.order.decorateVo.AbstractRefundVo;
import com.shigu.order.decorateVo.RefundVoDecorate;
import com.shigu.order.vo.ExpressDetailVo;
import com.shigu.order.vo.ExpressVo;

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
    private List<ExpressLogVO> loglist;

    public RefundExpressInfoDecorate(AbstractRefundVo vo, ReturnableExpressInfoVO returnableExpressInfoVO
            ,List<ExpressLogVO> loglist){
        super(vo);
        this.returnableExpressInfoVO =returnableExpressInfoVO;
        this.loglist = loglist;
    }
    private void setRefundExpressInfo(){
        Map map = new HashMap<>();
        ExpressVo vo = new ExpressVo();
        vo.setId(returnableExpressInfoVO.getExpressCode());
        vo.setName(returnableExpressInfoVO.getExpressName());
        vo.setCreateTime(returnableExpressInfoVO.getReturnableExpressTime());
        List<ExpressDetailVo> elist= new ArrayList<>();
        vo.setDetail(elist);
        for(ExpressLogVO logVO:loglist){
            ExpressDetailVo vode = new ExpressDetailVo();
            vode.setDate(logVO.getLogDate());
            vode.setDesc(logVO.getLogDesc());
            vode.setTime(logVO.getLogTime());
            elist.add(vode);

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
