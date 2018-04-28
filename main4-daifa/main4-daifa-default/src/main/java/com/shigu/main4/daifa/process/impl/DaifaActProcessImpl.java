package com.shigu.main4.daifa.process.impl;

import com.opentae.data.daifa.beans.DaifaAct;
import com.opentae.data.daifa.interfaces.DaifaActMapper;
import com.shigu.main4.daifa.process.DaifaActProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service("daifaActProcess")
public class DaifaActProcessImpl implements DaifaActProcess {
    @Autowired
    DaifaActMapper daifaActMapper;
    @Override
    public void addAct(Long workerId, String param, String url) {
        DaifaAct act=new DaifaAct();
        act.setCreated(new Date());
        act.setParam(param);
        act.setUrl(url);
        act.setWorkerId(workerId);
        daifaActMapper.insertSelective(act);
    }
}
