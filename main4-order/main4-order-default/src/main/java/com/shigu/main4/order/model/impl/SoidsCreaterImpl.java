package com.shigu.main4.order.model.impl;

import com.opentae.data.mall.beans.SubOrderSoidps;
import com.opentae.data.mall.examples.SubOrderSoidpsExample;
import com.opentae.data.mall.interfaces.SubOrderSoidpsMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.model.SoidsCreater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 子单拆分生成器
 */
@Service
public class SoidsCreaterImpl implements SoidsCreater {

    @Autowired
    SubOrderSoidpsMapper subOrderSoidpsMapper;

    @Override
    public List<Long> makeSoidps(Long soid, Integer number) {
        SubOrderSoidpsExample example=new SubOrderSoidpsExample();
        example.createCriteria().andSoidEqualTo(soid);
        subOrderSoidpsMapper.deleteByExample(example);
        List<SubOrderSoidps> waitInsert=new ArrayList<>();
        for(int i=0;i<number;i++){
            SubOrderSoidps soidps=new SubOrderSoidps();
            soidps.setSoid(soid);
            waitInsert.add(soidps);
        }
        subOrderSoidpsMapper.insertListNoId(waitInsert);
        return soidToSoidps(soid);
    }

    @Override
    public List<Long> soidToSoidps(Long soid) {
        SubOrderSoidpsExample example=new SubOrderSoidpsExample();
        example.createCriteria().andSoidEqualTo(soid);
        List<SubOrderSoidps> list=subOrderSoidpsMapper.selectByExample(example);
        return BeanMapper.getFieldList(list,"soidpId",Long.class);
    }

    @Override
    public Long selSoidBySoidp(Long soidp) {
        SubOrderSoidps soidps=subOrderSoidpsMapper.selectByPrimaryKey(soidp);
        return soidps!=null?soidps.getSoidpId():null;
    }
}
