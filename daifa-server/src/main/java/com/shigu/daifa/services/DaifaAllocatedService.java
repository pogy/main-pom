package com.shigu.daifa.services;

import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.data.daifa.beans.DaifaGgoods;
import com.opentae.data.daifa.beans.DaifaWorker;
import com.opentae.data.daifa.custom.beans.DaifaGgoodsJoinOrder;
import com.opentae.data.daifa.examples.DaifaGgoodsExample;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.examples.DaifaWorkerExample;
import com.opentae.data.daifa.interfaces.DaifaGgoodsMapper;
import com.opentae.data.daifa.interfaces.DaifaMultipleMapper;
import com.opentae.data.daifa.interfaces.DaifaWorkerMapper;
import com.shigu.daifa.vo.DaifaAllocatedVO;
import com.shigu.daifa.vo.DaifaWorkerVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DaifaAllocatedService {
    @Autowired
    private DaifaGgoodsMapper daifaGgoodsMapper;
    @Autowired
    private DaifaMultipleMapper daifaMultipleMapper;
    @Autowired
    private DaifaWorkerMapper daifaWorkerMapper;
    @Autowired
    private TakeGoodsIssueProcess takeGoodsIssueProcess;

    public ShiguPager<DaifaAllocatedVO> selectDaifaGgoodsList(Long workerId, String lastOrderId, String lastSubOrderId,
                                                              String startDate, String endDate, Integer page, Integer size) {
        DaifaGgoodsExample daifaGgoodsExample = new DaifaGgoodsExample();
        DaifaGgoodsExample.Criteria ce = daifaGgoodsExample.createCriteria().andDaifaWorkerIdEqualTo(workerId)
                .andUseStatusEqualTo(1).andOperateIsEqualTo(0);
        if (lastOrderId != null) {
            ce.andDfTradeIdLike("%" + lastOrderId);
        }
        if (lastSubOrderId != null) {
            ce.andDfOrderIdLike("%" + lastSubOrderId);
        }
        if (startDate != null) {
            String st = DateUtil.dateToString(DateUtil.stringToDate(startDate, DateUtil.patternA), DateUtil.patternB);
            ce.andCreateDateGreaterThanOrEqualTo(st);
        }
        if (endDate != null) {
            String et = DateUtil.dateToString(DateUtil.stringToDate(endDate, DateUtil.patternA), DateUtil.patternB);
            ce.andCreateDateLessThanOrEqualTo(et);
        }
        Integer count = daifaGgoodsMapper.countByExample(daifaGgoodsExample);
        List<DaifaAllocatedVO> vos = new ArrayList<>();
        if (count > 0) {
            daifaGgoodsExample.setStartIndex((page - 1) * size);
            daifaGgoodsExample.setEndIndex(size);
            DaifaOrderExample daifaOrderExample = new DaifaOrderExample();
            DaifaTradeExample daifaTradeExample = new DaifaTradeExample();
            MultipleExample example = MultipleExampleBuilder.from(daifaGgoodsExample)
                    .join(daifaOrderExample)
                    .on(ce.equalTo(DaifaGgoodsExample.dfOrderId, DaifaOrderExample.dfOrderId))
                    .join(daifaTradeExample)
                    .on(daifaOrderExample.createCriteria().equalTo(DaifaOrderExample.dfTradeId, DaifaTradeExample.dfTradeId))
                    .build();
            List<DaifaGgoodsJoinOrder> ggoodsForPrints = daifaMultipleMapper
                    .selectFieldsByMultipleExample(example, DaifaGgoodsJoinOrder.class);
            for (DaifaGgoodsJoinOrder g : ggoodsForPrints) {
                DaifaAllocatedVO vo = new DaifaAllocatedVO();
                vo.setChildOrderId(g.getDfOrderId());
                vo.setChildRemark(g.getOrderRemark());
                vo.setDffs(g.getDaifaType());
                vo.setGoodsNo(g.getStoreGoodsCode());
                vo.setGoodsProperty(g.getPropStr());
                vo.setHaveGoodsTime(DateUtil.dateToString(g.getYouhuoDate(), DateUtil.patternC));
                vo.setImgSrc(g.getPicPath());
                vo.setNoSale(g.getDelistIs() == 1);
                vo.setNum(g.getGoodsNum());
                vo.setPiPrice(g.getSinglePiPrice());
                vo.setPayPrice(MoneyUtil.dealPrice(
                        MoneyUtil.StringToLong(g.getSinglePay())
                                + MoneyUtil.StringToLong(g.getOrderDiscountFee())
                                - MoneyUtil.StringToLong(g.getSingleServicesFee()))
                );
                vo.setTitle(g.getTitle());
                vo.setTakeGoodsState(g.getTakeGoodsStatus());
                vos.add(vo);
            }
        }
        ShiguPager<DaifaAllocatedVO> pager=new ShiguPager<>();
        pager.setContent(vos);
        pager.setNumber(page);
        pager.calPages(count,size);
        return pager;
    }

    public void takeGoods(Long workerId,Long takeGoodsId,Integer takeType) throws DaifaException {
        if (takeType != null) {
            throw new DaifaException("类型为空");
        }
        DaifaGgoods g=new DaifaGgoods();
        g.setDaifaWorkerId(workerId);
        g.setTakeGoodsId(takeGoodsId);
        g=daifaGgoodsMapper.selectOne(g);
        if (g != null) {
            throw new DaifaException("不是分配给该拿货员的商品");
        }
        switch (takeType){
            case 1:{
                takeGoodsIssueProcess.complete(takeGoodsId);
                break;
            }
            case 2:{
                takeGoodsIssueProcess.uncomplete(takeGoodsId);
                break;
            }
        }
    }

    public List<DaifaWorkerVO> selWorkerList(Long sellerId){
        DaifaWorker tmpw=new DaifaWorker();
        tmpw.setDaifaSellerId(sellerId);
        tmpw.setUseStatus(1);
        List<DaifaWorker> ws=daifaWorkerMapper.select(tmpw);
        List<DaifaWorkerVO> vos=new ArrayList<>();
        for(DaifaWorker w:ws){
            DaifaWorkerVO vo=new DaifaWorkerVO();
            vo.setId(w.getDaifaWorkerId());
            vo.setName(w.getDaifaWorker());
            vos.add(vo);
        }
        return vos;
    }
}