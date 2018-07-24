package com.shigu.main4.order.services.impl;

import com.shigu.main4.order.exceptions.LogisticsRuleException;
import com.shigu.main4.order.model.LogisticsTemplate;
import com.shigu.main4.order.services.LogisticsService;
import com.shigu.main4.order.vo.LogisticsShipDetail;
import com.shigu.main4.order.vo.LogisticsShipVo;
import com.shigu.main4.order.vo.PostVO;
import com.shigu.main4.tools.SpringBeanFactory;
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

    @Override
    public List<PostVO> getPostListByProvId(Long provId, Long senderId) throws LogisticsRuleException {
        LogisticsTemplate logisticsTemplate = SpringBeanFactory.getBean(LogisticsTemplate.class, senderId, null);
        return logisticsTemplate.getPostListByProvId(provId,senderId);
    }

    @Override
    public Long calculate(Long provId, Long companyId, Integer goodsNumber, Long weight,Long senderId) throws LogisticsRuleException {
        LogisticsTemplate logisticsTemplate = SpringBeanFactory.getBean(LogisticsTemplate.class, senderId, null);
        return logisticsTemplate.calculate(null,null,provId,companyId,goodsNumber,weight,false);
    }

    @Override
    public Long calculate(Long userId,Long provId, Long companyId, Integer goodsNumber, Long weight,Long senderId,Boolean discounts) throws LogisticsRuleException {
        LogisticsTemplate logisticsTemplate = SpringBeanFactory.getBean(LogisticsTemplate.class, senderId, null);
        return logisticsTemplate.calculate(userId,null,provId,companyId,goodsNumber,weight,discounts);
    }

    @Override
    public List<PostVO> defaultPost(Long senderId) throws LogisticsRuleException {
        LogisticsTemplate logisticsTemplate = SpringBeanFactory.getBean(LogisticsTemplate.class, senderId, null);
        return logisticsTemplate.defaultPost();
    }

    @Override
    public Boolean isMinusFreight(Long userId, Long oid) {
        LogisticsTemplate logisticsTemplate = SpringBeanFactory.getBean(LogisticsTemplate.class, 9999999990l, null);
        return logisticsTemplate.isMinusFreight(userId,null);
    }

}
