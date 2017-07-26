package com.shigu.order.decorateVo;

import com.shigu.main4.order.services.LogisticsService;
import com.shigu.main4.order.vo.LogisticsShipVo;

import java.util.Map;

/**
 * Created by pc on 2017-07-26.
 *添加物流信息
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class LogisticsDecorate extends RefundVoDecorate{
    private LogisticsService logisticsService;
    private Long refundId;
    public LogisticsDecorate(AbstractRefundVo vo) {
        super(vo);
    }
    public LogisticsDecorate(AbstractRefundVo vo,LogisticsService logisticsService,Long refundId){
        super(vo);
        this.logisticsService = logisticsService;
        this.refundId = refundId;
    }

    public void setLogisticsInfo(){
        LogisticsShipVo logisticsShipVo = logisticsService.logisticsInfo(this.refundId);
        Map<String, Object> map = this.getViewVo();
        map.put("express",logisticsShipVo);

    }

    @Override
    public Map<String, Object> getViewVo() {
        setLogisticsInfo();
        return super.getViewVo();
    }
}
