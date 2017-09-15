package com.shigu.main4.spread.processes.impl;

import com.opentae.data.mall.beans.ShiguTemp;
import com.opentae.data.mall.examples.ShiguTempExample;
import com.opentae.data.mall.interfaces.ShiguTempMapper;
import com.shigu.main4.spread.processes.ActivityApply;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 类名：ActivityApplyImpl
 * 类路径：com.shigu.main4.spread.processes.impl.ActivityApplyImpl
 * 创建者：王浩翔
 * 创建时间：2017-09-15 10:42
 * 项目：main-pom
 * 描述：秋装报名，临时用下，独立出来，避免与其他分支修改冲突
 */
public class ActivityApplyImpl implements ActivityApply{

    @Autowired
    ShiguTempMapper tempMapper;

    @Override
    public String apply(String flag, Long userId, Long shopId) {
        if (userId==null||shopId==null){
            return "本次活动报名面向档口";
        }
        ShiguTempExample shiguTempExample =new ShiguTempExample();
        shiguTempExample.createCriteria().andKey1EqualTo(userId.toString()).andKey2EqualTo(shopId.toString()).andFlagEqualTo(flag);
        List<ShiguTemp> temps = tempMapper.selectByExample(shiguTempExample);
        if (temps.size()>0){
            return "您已经报过名了";
        }
        ShiguTemp shiguTemp=new ShiguTemp();
        shiguTemp.setFlag(flag);
        shiguTemp.setKey1(userId.toString());
        shiguTemp.setKey2(shopId.toString());
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        shiguTemp.setKey3(dateFormat.format(new Date()));
        tempMapper.insertSelective(shiguTemp);
        return "true";
    }
}
