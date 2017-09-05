package com.shigu.daifa.services;

import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.data.daifa.beans.DaifaSendOrderSimple;
import com.opentae.data.daifa.beans.DaifaSendSimple;
import com.opentae.data.daifa.beans.DaifaWaitSendOrderSimple;
import com.opentae.data.daifa.beans.DaifaWaitSendSimple;
import com.opentae.data.daifa.examples.DaifaSendExample;
import com.opentae.data.daifa.examples.DaifaWaitSendExample;
import com.opentae.data.daifa.examples.DaifaWaitSendOrderExample;
import com.opentae.data.daifa.interfaces.DaifaMultipleMapper;
import com.opentae.data.daifa.interfaces.DaifaSendMapper;
import com.opentae.data.daifa.interfaces.DaifaWaitSendMapper;
import com.shigu.daifa.bo.AllOrderBO;
import com.shigu.daifa.bo.WaitSendBO;
import com.shigu.daifa.vo.DaifaSendVO;
import com.shigu.daifa.vo.DaifaWaitSendVO;
import com.shigu.daifa.vo.SendOrderVO;
import com.shigu.daifa.vo.WaitSendOrderVO;
import com.shigu.main4.common.tools.ShiguPager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017-09-05.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class DaifaSendService {


    private DaifaMultipleMapper daifaMultipleMapper;

    @Autowired
    public void setDaifaMultipleMapper(DaifaMultipleMapper daifaMultipleMapper) {
        this.daifaMultipleMapper = daifaMultipleMapper;
    }

    private DaifaSendMapper daifaSendMapper;

    @Autowired
    public void setDaifaWaitSendMapper(DaifaSendMapper daifaSendMapper) {
        this.daifaSendMapper = daifaSendMapper;
    }

    public ShiguPager<DaifaSendVO> selPageData(WaitSendBO bo, Long daifaSellerId) {
         DaifaSendExample daifaWaitSendExample = new DaifaSendExample();
        DaifaWaitSendOrderExample daifaWaitSendOrderExample = new DaifaWaitSendOrderExample();
        DaifaSendExample.Criteria ce = daifaWaitSendExample.createCriteria();
        daifaWaitSendExample.setOrderByClause("dws_id desc");
        ce.andSellerIdEqualTo(daifaSellerId);
        if (StringUtils.hasText(bo.getReceiver())) {
            ce.andReceiverNameEqualTo(bo.getReceiver());
        }
        if (StringUtils.hasText(bo.getTelphone())) {
            ce.andReceiverPhoneEqualTo(bo.getTelphone());
        }
        if (bo.getBuyerId() != null) {
            ce.andBuyerIdEqualTo(bo.getBuyerId());
        }
        if (bo.getOrderId() != null) {
            ce.andDfTradeIdLike("%" + bo.getOrderId());
        }
        if (bo.getPage() <= 0) {
            bo.setPage(1);
        }
        daifaWaitSendExample.setStartIndex((bo.getPage() - 1) * 10);
        daifaWaitSendExample.setEndIndex(10);
        List<DaifaSendVO> sends = new ArrayList<>();
        int count = daifaSendMapper.countByExample(daifaWaitSendExample);
        if (count > 0) {
            MultipleExample multipleExample = MultipleExampleBuilder.from(daifaWaitSendExample)
                    .leftJoin(daifaWaitSendOrderExample)
                    .on(daifaWaitSendExample.createCriteria()
                            .equalTo(DaifaWaitSendExample.dwsId, DaifaWaitSendOrderExample.dwsId)).build();
            List<DaifaSendSimple> daifaWaitSendSimples = daifaMultipleMapper.selectFieldsByMultipleExample(multipleExample, DaifaSendSimple.class);

            for (DaifaSendSimple daifaWaitSendSimple : daifaWaitSendSimples) {
                DaifaSendVO vo = new DaifaSendVO();
                sends.add(vo);
                BeanUtils.copyProperties(daifaWaitSendSimple, vo, "childOrders");
                List<SendOrderVO> subList = new ArrayList<>();
                for (DaifaSendOrderSimple daifaWaitSendOrderSimple : daifaWaitSendSimple.getChildOrders()) {
                    SendOrderVO subVo = new SendOrderVO();
                    BeanUtils.copyProperties(daifaWaitSendOrderSimple, subVo);
                    subList.add(subVo);
                }
                vo.setChildOrders(subList);

            }
        }
        ShiguPager<DaifaSendVO> pager = new ShiguPager<>();
        pager.setTotalCount(count);
        pager.setContent(sends);
        pager.setNumber(bo.getPage());
        return pager;
    }
}
