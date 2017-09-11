package com.shigu.daifa.services;

import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.DaifaGgoodsTasks;
import com.opentae.data.daifa.beans.DaifaWaitSendOrderSimple;
import com.opentae.data.daifa.beans.DaifaWaitSendSimple;
import com.opentae.data.daifa.examples.DaifaGgoodsTasksExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.examples.DaifaWaitSendExample;
import com.opentae.data.daifa.examples.DaifaWaitSendOrderExample;
import com.opentae.data.daifa.interfaces.DaifaGgoodsTasksMapper;
import com.opentae.data.daifa.interfaces.DaifaMultipleMapper;
import com.opentae.data.daifa.interfaces.DaifaWaitSendMapper;
import com.shigu.daifa.bo.WaitSendBO;
import com.shigu.daifa.vo.DaifaWaitSendVO;
import com.shigu.daifa.vo.WaitSendOrderVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
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
public class DaifaWaitSendService {

    private DaifaMultipleMapper daifaMultipleMapper;

    @Autowired
    public void setDaifaMultipleMapper(DaifaMultipleMapper daifaMultipleMapper) {
        this.daifaMultipleMapper = daifaMultipleMapper;
    }

    private DaifaWaitSendMapper daifaWaitSendMapper;

    @Autowired
    public void setDaifaWaitSendMapper(DaifaWaitSendMapper daifaWaitSendMapper) {
        this.daifaWaitSendMapper = daifaWaitSendMapper;
    }

    private DaifaGgoodsTasksMapper daifaGgoodsTasksMapper;
    @Autowired
    public void setDaifaGgoodsTasksMapper(DaifaGgoodsTasksMapper daifaGgoodsTasksMapper) {
        this.daifaGgoodsTasksMapper = daifaGgoodsTasksMapper;
    }

    public ShiguPager<DaifaWaitSendVO> selPageData(WaitSendBO bo, Long daifaSellerId) {
        if(bo.getPage()<1){
            bo.setPage(1);
        }
        List<DaifaWaitSendVO> sends = new ArrayList<>();
        int count = daifaWaitSendMapper.selectWaitSendsCount(daifaSellerId,
                bo.getOrderId(),
                StringUtils.hasText(bo.getTelphone())?bo.getTelphone():null,
                bo.getBuyerId(),
                StringUtils.hasText(bo.getStartTime())?DateUtil.stringToDate(bo.getStartTime()+" 00:00:00"):null,
                StringUtils.hasText(bo.getEndTime())?DateUtil.stringToDate(bo.getEndTime()+" 23:59:59"):null,
                bo.getCanSendState());
        if (count > 0) {
//            MultipleExample multipleExample = MultipleExampleBuilder.from(daifaWaitSendExample).join(daifaTradeExample).on(new DaifaWaitSendExample().createCriteria()
//                    .equalTo(DaifaWaitSendExample.dfTradeId,DaifaTradeExample.dfTradeId))
//                    .leftJoin(daifaWaitSendOrderExample)
//                    .on(daifaWaitSendExample.createCriteria()
//                            .equalTo(DaifaWaitSendExample.dwsId, DaifaWaitSendOrderExample.dwsId)).build();
//            List<DaifaWaitSendSimple> daifaWaitSendSimples = daifaMultipleMapper.selectFieldsByMultipleExample(multipleExample, DaifaWaitSendSimple.class);
            List<DaifaWaitSendSimple> daifaWaitSendSimples=daifaWaitSendMapper.selectWaitSends(daifaSellerId,
                    bo.getOrderId(),
                    StringUtils.hasText(bo.getTelphone())?bo.getTelphone():null,
                    bo.getBuyerId(),
                    StringUtils.hasText(bo.getStartTime())?DateUtil.stringToDate(bo.getStartTime()+" 00:00:00"):null,
                    StringUtils.hasText(bo.getEndTime())?DateUtil.stringToDate(bo.getEndTime()+" 23:59:59"):null,
                    bo.getCanSendState(),
                    (bo.getPage() - 1) * 10,
                    10);

            DaifaGgoodsTasksExample daifaGgoodsTasksExample = new DaifaGgoodsTasksExample();
            daifaGgoodsTasksExample.setOrderByClause("tasks_id desc");

            for (DaifaWaitSendSimple daifaWaitSendSimple : daifaWaitSendSimples) {
                DaifaWaitSendVO vo = new DaifaWaitSendVO();
                sends.add(vo);
                BeanUtils.copyProperties(daifaWaitSendSimple, vo, "childOrders");
                List<WaitSendOrderVO> subList = new ArrayList<>();
                for (DaifaWaitSendOrderSimple daifaWaitSendOrderSimple : daifaWaitSendSimple.getChildOrders()) {
                    daifaGgoodsTasksExample.clear();
                    daifaGgoodsTasksExample.createCriteria()
                            .andDfOrderIdEqualTo(Long.parseLong(daifaWaitSendOrderSimple.getChildOrderId()));

                    List<DaifaGgoodsTasks> ggoodsTasks = daifaGgoodsTasksMapper.selectFieldsByExample(daifaGgoodsTasksExample,FieldUtil.codeFields("end_status"));
                    DaifaGgoodsTasks tasks = ggoodsTasks.get(0);
                    WaitSendOrderVO subVo = new WaitSendOrderVO();
                    subVo.setRefundState(daifaWaitSendOrderSimple.getRefundStatus());
                    if(tasks.getEndStatus() == 1 && daifaWaitSendOrderSimple.getRefundStatus() == 2){
                        subVo.setRefundState(3);
                    }
                    BeanUtils.copyProperties(daifaWaitSendOrderSimple, subVo);
                    subList.add(subVo);
                }
                vo.setChildOrders(subList);

            }
        }
        ShiguPager<DaifaWaitSendVO> pager = new ShiguPager<>();
        pager.setTotalCount(count);
        pager.setContent(sends);
        pager.setNumber(bo.getPage());
        return pager;
    }


}
