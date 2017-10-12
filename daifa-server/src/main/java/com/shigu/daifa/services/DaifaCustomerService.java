package com.shigu.daifa.services;

import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.data.daifa.beans.AfterSaleData;
import com.opentae.data.daifa.beans.AfterSaleSubData;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.interfaces.DaifaAfterSaleMapper;
import com.opentae.data.daifa.interfaces.DaifaMultipleMapper;
import com.opentae.data.daifa.interfaces.DaifaTradeMapper;
import com.shigu.daifa.bo.AfterSaleBO;
import com.shigu.daifa.vo.DaifaCustomerDataSubVO;
import com.shigu.daifa.vo.DaifaCutomerDataVO;
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
public class DaifaCustomerService {

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

    public ShiguPager<DaifaCutomerDataVO> afterSaleData(Long daifaSellerId, AfterSaleBO bo) {
        ShiguPager<DaifaCutomerDataVO> pager = new ShiguPager<>();
        DaifaTradeExample daifaTradeExample = new DaifaTradeExample();
        DaifaOrderExample daifaOrderExample = new DaifaOrderExample();
        DaifaTradeExample.Criteria salece = daifaTradeExample.createCriteria();
        salece.andSellerIdEqualTo(daifaSellerId);
        daifaTradeExample.setOrderByClause("df_trade_id desc");
        if (StringUtils.isEmpty(bo.getPage())) {
            bo.setPage("1");
        }
        if (bo.getOrderId() != null) {
            salece.andDfTradeIdLike("%" + bo.getOrderId()).or().andTradeCodeLike("%"+bo.getOrderId());
        }
        if (StringUtils.hasText(bo.getTelphone())) {
            salece.andReceiverPhoneEqualTo(bo.getTelphone());
        }
        if (StringUtils.hasText(bo.getReceiver())) {
            salece.andReceiverNameEqualTo(bo.getReceiver());
        }
        if(bo.getBuyerId()!= null){
            salece.andBuyerIdEqualTo(bo.getBuyerId());
        }

        int count = daifaTradeMapper.countByExample(daifaTradeExample);
        List<DaifaCutomerDataVO> afterSaleDataVOS = new ArrayList<>();
        if (count > 0) {
            int start = (Integer.parseInt(bo.getPage()) - 1) * 10;
            int end = 10;
            daifaTradeExample.setStartIndex(start);
            daifaTradeExample.setEndIndex(end);
            MultipleExample multipleExample = MultipleExampleBuilder.from(daifaTradeExample)
                    .leftJoin(daifaOrderExample)
                    .on(salece.equalTo(DaifaTradeExample.dfTradeId,DaifaOrderExample.dfTradeId)).build();
            List<AfterSaleData> afterSaleData = daifaMultipleMapper.selectFieldsByMultipleExample(multipleExample, AfterSaleData.class);


            for (AfterSaleData afterSaleDatum : afterSaleData) {
                DaifaCutomerDataVO vo = new DaifaCutomerDataVO();
                switch (afterSaleDatum.getOldOrder()){
                    case 0:{
                        vo.setOldOrder(false);
                        break;
                    }
                    case 1:{
                        vo.setOldOrder(true);
                        break;
                    }
                    default:{
                        break;
                    }
                }
                BeanUtils.copyProperties(afterSaleDatum, vo, "childOrders");
                if("无".equals(vo.getImWw())){
                    vo.setImWw(null);
                }
                afterSaleDataVOS.add(vo);
                List<DaifaCustomerDataSubVO> afterSaleDataSubVOS = new ArrayList<>();
                for (AfterSaleSubData afterSaleSubData : afterSaleDatum.getChildOrders()) {
                    DaifaCustomerDataSubVO subVO = new DaifaCustomerDataSubVO();
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
