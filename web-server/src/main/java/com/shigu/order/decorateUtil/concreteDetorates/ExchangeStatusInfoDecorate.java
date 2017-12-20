package com.shigu.order.decorateUtil.concreteDetorates;

import com.shigu.main4.order.servicevo.AfterSaleStatusVO;
import com.shigu.order.decorateUtil.AbstractRefundVo;
import com.shigu.order.decorateUtil.RefundVoDecorate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 2017-07-27.
 *换货状态修饰
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class ExchangeStatusInfoDecorate extends RefundVoDecorate {
    private AfterSaleStatusVO afterSaleStatusVO;

    public ExchangeStatusInfoDecorate(AbstractRefundVo vo, AfterSaleStatusVO afterSaleStatusVO) {
        super(vo);
        this.afterSaleStatusVO = afterSaleStatusVO;
    }


    private void setExchangeStatusInfo() {
        Map<String, Object> map = new HashMap<>();
        int exchangeStateNum = 0;
        int exchangeWaitState = 0;
        map.put("subOrderId", afterSaleStatusVO.getSubOrderId());
        map.put("refuseReason", afterSaleStatusVO.getContent());
        switch (afterSaleStatusVO.getAfterSaleStatus()) {
            case REFUND_FAIL:{
                exchangeStateNum=2;
                exchangeWaitState=4;
                break;
            }
            case DISPOSE_RETRUN_GOODS: {
                exchangeStateNum = 2;
                exchangeWaitState = 1;
                break;
            }
            case REFUSE_PROCESS: {
                exchangeStateNum = 2;
                exchangeWaitState = 4;
                break;
            }
            case EXPRESS_SUBMIT: {
                exchangeStateNum = 2;
                exchangeWaitState = 3;
                break;
            }
            case AGREE_PROCESS: {
                exchangeStateNum = 2;
                exchangeWaitState = 2;
                break;
            }
            case RETURN_ENT: {
                exchangeStateNum = 3;
                break;
            }
            default: {
                break;
            }

        }
        map.put("exchangeStateNum", exchangeStateNum);
        map.put("exchangeWaitState", exchangeWaitState);
        super.addMap(map);

    }

    @Override
    public void doAdd() {
        setExchangeStatusInfo();
        super.doAdd();
    }
}
