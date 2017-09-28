package com.shigu.main4.order.model.impl;

import com.opentae.data.mall.beans.SubOrderSoidps;
import com.opentae.data.mall.examples.SubOrderSoidpsExample;
import com.opentae.data.mall.interfaces.SubOrderSoidpsMapper;
import com.shigu.main4.order.model.SoidsCreater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 子单拆分生成器
 */
@Service
public class SoidsCreaterImpl implements SoidsCreater {

    @Autowired
    SubOrderSoidpsMapper subOrderSoidpsMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Long> makeSoidps(Long soid, Integer number) {
        SubOrderSoidpsExample example=new SubOrderSoidpsExample();
        example.createCriteria().andSoidEqualTo(soid);
        subOrderSoidpsMapper.deleteByExample(example);
        List<SubOrderSoidps> waitInsert=new ArrayList<>();
        for(int i=0;i<number;i++){
            SubOrderSoidps soidps=new SubOrderSoidps();
            soidps.setSoid(soid);
            soidps.setStockStatus(0);
            waitInsert.add(soidps);
        }
        subOrderSoidpsMapper.insertListNoId(waitInsert);
        return soidToSoidps(soid);
    }

    @Override
    public List<Long> soidToSoidps(Long soid) {
        SubOrderSoidpsExample example=new SubOrderSoidpsExample();
        example.createCriteria().andSoidEqualTo(soid);
        return subOrderSoidpsMapper.selectByExample(example).stream().map(SubOrderSoidps::getSoidpId).collect(Collectors.toList());
    }

    @Override
    public Long selSoidBySoidp(Long soidp) {
        SubOrderSoidps soidps=subOrderSoidpsMapper.selectByPrimaryKey(soidp);
        return soidps!=null?soidps.getSoid():null;
    }

    @Override
    public Map<Long, List<Long>> selSoidsBySoidps(List<Long> soidp) {
        if (soidp.isEmpty()) {
            return Collections.emptyMap();
        }
        SubOrderSoidpsExample subOrderSoidpsExample = new SubOrderSoidpsExample();
        subOrderSoidpsExample.createCriteria().andSoidpIdIn(soidp);
        return subOrderSoidpsMapper.selectByExample(subOrderSoidpsExample).stream()
                .collect(Collectors.groupingBy(SubOrderSoidps::getSoid)).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream().map(SubOrderSoidps::getSoidpId).collect(Collectors.toList())));
    }
}
