package com.shigu.main4.order.services.impl;

import com.shigu.main4.order.services.LogisticsService;
import com.shigu.main4.order.vo.LogisticsShipDetail;
import com.shigu.main4.order.vo.LogisticsShipVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017-07-26.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service("logisticsService")
public class LogisticsServiceImpl implements LogisticsService {


    @Override
    public LogisticsShipVo logisticsInfo(Long refundId) {

        LogisticsShipVo vo = new LogisticsShipVo();
        vo.setPostName("zf快递");
        vo.setPostName("10086");
        LogisticsShipDetail detail,detail1;
        detail = new LogisticsShipDetail();
        detail1 = new LogisticsShipDetail();
        detail.setDate("2017-09-08");
        detail.setTime("11:11:11");
        detail.setDesc("天堂街11 已喝孟婆汤 请上路:马云");
        detail1.setDesc("地狱口 已捆版 请凌迟:马化腾");
        detail1.setTime("11:11:11");
        detail1.setDate("2017-10-08");
        List<LogisticsShipDetail> list = new ArrayList<>();
        list.add(detail);
        list.add(detail1);
        vo.setDetail(list);
        return vo;
    }
}
