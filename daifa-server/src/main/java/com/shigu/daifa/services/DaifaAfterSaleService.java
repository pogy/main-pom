package com.shigu.daifa.services;

import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.data.daifa.beans.AfterSaleData;
import com.opentae.data.daifa.beans.AfterSaleSubData;
import com.opentae.data.daifa.examples.DaifaAfterSaleExample;
import com.opentae.data.daifa.examples.DaifaAfterSaleSubExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.interfaces.DaifaAfterSaleMapper;
import com.opentae.data.daifa.interfaces.DaifaMultipleMapper;
import com.opentae.data.daifa.interfaces.DaifaTradeMapper;
import com.shigu.daifa.bo.AfterSaleBO;
import com.shigu.daifa.vo.AfterSaleDataSubVO;
import com.shigu.daifa.vo.AfterSaleDataVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017-08-31.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class DaifaAfterSaleService {

    private DaifaMultipleMapper daifaMultipleMapper;

    @Autowired
    public void setMultipleMapper(DaifaMultipleMapper multipleMapper) {
        this.daifaMultipleMapper = multipleMapper;
    }

    private DaifaAfterSaleMapper daifaAfterSaleMapper;

    @Autowired
    public void setDaifaAfterSaleMapper(DaifaAfterSaleMapper daifaAfterSaleMapper) {
        this.daifaAfterSaleMapper = daifaAfterSaleMapper;
    }
    private DaifaTradeMapper daifaTradeMapper;
    @Autowired
    public void setDaifaTradeMapper(DaifaTradeMapper daifaTradeMapper) {
        this.daifaTradeMapper = daifaTradeMapper;
    }

    private OrderManageProcess orderManageProcess;
    @Autowired
    public void setOrderManageProcess(OrderManageProcess orderManageProcess) {
        this.orderManageProcess = orderManageProcess;
    }

    public ShiguPager<AfterSaleDataVO> afterSaleData(Long daifaSellerId, AfterSaleBO bo) {
        ShiguPager<AfterSaleDataVO> pager = new ShiguPager<>();
        DaifaAfterSaleExample daifaAfterSaleExample = new DaifaAfterSaleExample();
        DaifaAfterSaleSubExample daifaAfterSaleSubExample = new DaifaAfterSaleSubExample();
        DaifaTradeExample daifaTradeExample = new DaifaTradeExample();
        DaifaAfterSaleExample.Criteria salece = daifaAfterSaleExample.createCriteria();
        DaifaAfterSaleSubExample.Criteria subSale = daifaAfterSaleSubExample.createCriteria();
        salece.andSellerIdEqualTo(daifaSellerId);
        daifaAfterSaleExample.setOrderByClause("after_sale_id desc");
        if (StringUtils.isEmpty(bo.getPage())) {
            bo.setPage("1");
        }
        if (bo.getOrderId() != null) {
            salece.andDfTradeIdLike("%" + bo.getOrderId());
        }
        if (StringUtils.hasText(bo.getTelphone())) {
            salece.andReceiverMobileEqualTo(bo.getTelphone());
        }
        if (StringUtils.hasText(bo.getReceiver())) {
            salece.andReceiverNameEqualTo(bo.getReceiver());
        }

        int count = daifaAfterSaleMapper.countByExample(daifaAfterSaleExample);
        List<AfterSaleDataVO> afterSaleDataVOS = new ArrayList<>();
        if (count > 0) {
            int start = (Integer.parseInt(bo.getPage()) - 1) * 10;
            int end = 10;
            daifaAfterSaleExample.setStartIndex(start);
            daifaAfterSaleExample.setEndIndex(end);
            MultipleExample multipleExample = MultipleExampleBuilder.from(daifaAfterSaleExample).join(daifaTradeExample)
                    .on(new DaifaAfterSaleExample().createCriteria().equalTo(DaifaAfterSaleExample.dfTradeId, DaifaTradeExample.dfTradeId))
                    .leftJoin(daifaAfterSaleSubExample)
                    .on(salece.equalTo(DaifaAfterSaleExample.afterSaleId, DaifaAfterSaleSubExample.afterSaleId)).where(subSale).build();
            List<AfterSaleData> afterSaleData = daifaMultipleMapper.selectFieldsByMultipleExample(multipleExample, AfterSaleData.class);


            for (AfterSaleData afterSaleDatum : afterSaleData) {
                AfterSaleDataVO vo = new AfterSaleDataVO();
                BeanUtils.copyProperties(afterSaleDatum, vo, "childOrders");
                vo.setSendTime(DateUtil.dateToString(afterSaleDatum.getSendTime(), DateUtil.patternA));
                vo.setTradeTime(DateUtil.dateToString(afterSaleDatum.getCreateTime(), DateUtil.patternA));
                afterSaleDataVOS.add(vo);
                List<AfterSaleDataSubVO> afterSaleDataSubVOS = new ArrayList<>();
                for (AfterSaleSubData afterSaleSubData : afterSaleDatum.getChildOrders()) {
                    AfterSaleDataSubVO subVO = new AfterSaleDataSubVO();
                    BeanUtils.copyProperties(afterSaleSubData, subVO);
                    afterSaleDataSubVOS.add(subVO);
                }
                vo.setChildOrders(afterSaleDataSubVOS);

            }
        }
        pager.setContent(afterSaleDataVOS);
        pager.setTotalCount(count);
        pager.setNumber(Integer.parseInt(bo.getPage()));
        return pager;
    }

    public JSONObject addServerRemarkJson(Long orderId, String remarkCon) {

        try {
            orderManageProcess.addAfterRemark(orderId,remarkCon);
        } catch (DaifaException e) {
            return JsonResponseUtil.error(e.getMessage());
        }

        return JsonResponseUtil.success("修改成功");
    }

}
