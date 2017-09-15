package com.shigu.daifa.services;

import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.data.daifa.beans.DaifaOrder;
import com.opentae.data.daifa.beans.DaifaSendOrderSimple;
import com.opentae.data.daifa.beans.DaifaSendSimple;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaSendExample;
import com.opentae.data.daifa.examples.DaifaSendOrderExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.interfaces.DaifaMultipleMapper;
import com.opentae.data.daifa.interfaces.DaifaOrderMapper;
import com.opentae.data.daifa.interfaces.DaifaSendMapper;
import com.shigu.daifa.bo.SendBO;
import com.shigu.daifa.vo.DaifaSendVO;
import com.shigu.daifa.vo.SendOrderVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    private DaifaOrderMapper daifaOrderMapper;
    @Autowired
    public void setDaifaOrderMapper(DaifaOrderMapper daifaOrderMapper) {
        this.daifaOrderMapper = daifaOrderMapper;
    }

    public ShiguPager<DaifaSendVO> selPageData(SendBO bo, Long daifaSellerId) {



        List<DaifaSendVO> sends = new ArrayList<>();
        int count = daifaMultipleMapper.countByMultipleExample(build(daifaSellerId,bo,false));
        if (count > 0) {
            List<DaifaSendSimple> daifaSendSimples = daifaMultipleMapper.selectFieldsByMultipleExample(build(daifaSellerId,bo,true), DaifaSendSimple.class);
            List<Long> oids=new ArrayList<>();
            for (DaifaSendSimple daifaSendSimple : daifaSendSimples) {
                DaifaSendVO vo = new DaifaSendVO();
                sends.add(vo);
                BeanUtils.copyProperties(daifaSendSimple, vo, "childOrders");
                List<SendOrderVO> subList = new ArrayList<>();
                for (DaifaSendOrderSimple daifaSendOrderSimple : daifaSendSimple.getChildOrders()) {
                    SendOrderVO subVo = new SendOrderVO();
                    BeanUtils.copyProperties(daifaSendOrderSimple, subVo);
                    subList.add(subVo);
                    oids.add(new Long(daifaSendOrderSimple.getChildOrderId()));
                }
                vo.setChildOrders(subList);
            }
            if(oids.size()>0){
                DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
                daifaOrderExample.createCriteria().andDfOrderIdIn(oids);
                List<DaifaOrder> os=daifaOrderMapper.selectByExample(daifaOrderExample);
                Map<Long,DaifaOrder> map= BeanMapper.list2Map(os,"dfOrderId",Long.class);
                for(DaifaSendVO send:sends){
                    for(SendOrderVO so:send.getChildOrders()){
                        DaifaOrder o=map.get(new Long(so.getChildOrderId()));
                        if(o!=null){
                            so.setChildServersFee(o.getSingleServicesFee());
                            so.setChildRemark(o.getOrderRemark());
                        }
                    }
                }
            }
        }
        ShiguPager<DaifaSendVO> pager = new ShiguPager<>();
        pager.setTotalCount(count);
        pager.setContent(sends);
        pager.setNumber(bo.getPage());
        return pager;
    }

    private MultipleExample build(Long daifaSellerId,SendBO bo,boolean isList){
        DaifaSendExample daifaSendExample = new DaifaSendExample();
        DaifaSendOrderExample daifaSendOrderExample = new DaifaSendOrderExample();
        DaifaSendExample.Criteria ce = daifaSendExample.createCriteria();
        daifaSendExample.setOrderByClause("send_id desc");
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
        if(StringUtils.hasText(bo.getPostCode())){
            ce.andExpressCodeEqualTo(bo.getPostCode());
        }
        if (bo.getPage() <= 0) {
            bo.setPage(1);
        }
        DaifaTradeExample daifaTradeExample=new DaifaTradeExample();
        DaifaTradeExample.Criteria ce1=daifaTradeExample.createCriteria();
        if(StringUtils.hasText(bo.getStartTime())){
            ce1.andCreateTimeGreaterThanOrEqualTo(DateUtil.stringToDate(bo.getStartTime()+" 00:00:00"));
        }
        if(StringUtils.hasText(bo.getEndTime())){
            ce1.andCreateTimeLessThanOrEqualTo(DateUtil.stringToDate(bo.getEndTime()+" 23:59:59"));
        }
        if(isList){
            daifaSendExample.setStartIndex((bo.getPage() - 1) * 10);
            daifaSendExample.setEndIndex(10);
        }
        return MultipleExampleBuilder.from(daifaSendExample)
                .join(daifaTradeExample)
                .on(daifaSendExample.createCriteria().equalTo(DaifaSendExample.dfTradeId,DaifaTradeExample.dfTradeId))
                .leftJoin(daifaSendOrderExample)
                .on(daifaSendExample.createCriteria()
                        .equalTo(DaifaSendExample.sendId, DaifaSendOrderExample.sendId)).build();
    }
}
