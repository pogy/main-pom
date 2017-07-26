package com.shigu.order.decorateVo;

import com.shigu.main4.order.services.ReturnGoodsService;
import com.shigu.main4.order.servicevo.ReturnGoodsInfoVO;

import java.util.Map;

/**
 * Created by pc on 2017-07-25.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class RefundInfoDecorate extends RefundVoDecorate{

    private ReturnGoodsInfoVO returnGoodsInfoVO;

    public RefundInfoDecorate(AbstractRefundVo vo,ReturnGoodsInfoVO returnGoodsInfoVO){
        super(vo);
        this.returnGoodsInfoVO = returnGoodsInfoVO;
    }
    public RefundInfoDecorate(AbstractRefundVo vo) {
        super(vo);
    }

    public void setRefundInfo(){

        Map<String, Object> map = this.getViewVo();
        map.put("refundId",returnGoodsInfoVO.getRefundId());
        map.put("refundAmount",returnGoodsInfoVO.getRefundPrice());
        int refundStateNum = 0;
        int waitState = 0;
        int returnState = 0;
        switch (returnGoodsInfoVO.getRetrunGoodsStatus()){

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
                returnState = 2;
                break;
            }
            case WAIT_AFTER_SALE:{
                break;
            }
            case DISPOSE_RETRUN_GOODS:{
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


    }

    @Override
    public Map<String, Object> getViewVo() {
        setRefundInfo();
        return super.getViewVo();
    }
}
