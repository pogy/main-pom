package com.shigu.order.decorateVo.concreteDetorates;

import com.shigu.main4.order.servicevo.AfterSaleStatusVO;
import com.shigu.main4.order.servicevo.AfterSaleStatusVO;
import com.shigu.order.decorateVo.AbstractRefundVo;
import com.shigu.order.decorateVo.RefundVoDecorate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 2017-07-25.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description xx
 * @since 3.0.0-SNAPSHOT
 */
public class RefundStatusInfoDecorate extends RefundVoDecorate {

    private AfterSaleStatusVO afterSaleStatusVO;

    public RefundStatusInfoDecorate(AbstractRefundVo vo, AfterSaleStatusVO afterSaleStatusVO){
        super(vo);
        this.afterSaleStatusVO = afterSaleStatusVO;
    }


    private void setRefundInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("refundId",afterSaleStatusVO.getSubOrderId());
        map.put("refuseReason",afterSaleStatusVO.getContent());
        System.out.println("设置退款信息");
        int refundStateNum = 0;
        int waitState = 0;
        int returnState = 0;
        switch (afterSaleStatusVO.getAfterSaleStatus()){

            case RETURN_ENT:{
                refundStateNum = 4;
                break;
            }
            case AGREE_PROCESS:{
                refundStateNum = 3;
                returnState = 1;
                break;
            }
            case EXPRESS_SUBMIT:{
                refundStateNum = 3;
                returnState = 2;
                break;
            }
            case REFUSE_PROCESS:{
                refundStateNum = 2;
                waitState = 2;
                break;
            }
            case REFUSE_MONEY_CHANGED:{
                refundStateNum = 3;
                returnState =4;
                break;
            }
            case DISPOSE_RETRUN_GOODS:{
                refundStateNum =2 ;
                waitState =1;
                break;
            }
            case REFUND_MONEY_CHANGED:{
                refundStateNum = 3;
                returnState = 3;
            }
            default:{
                break;
            }
        }
        map.put("returnState",refundStateNum);
        map.put("waitState",waitState);
        map.put("returnState",returnState);
        super.addMap(map);


    }

//    @Override
//    public Map<String, Object> getViewVo() {
//        setRefundInfo();
//        return super.getViewVo();
//    }

    @Override
    public void doAdd() {
        setRefundInfo();
        super.doAdd();
    }
}
