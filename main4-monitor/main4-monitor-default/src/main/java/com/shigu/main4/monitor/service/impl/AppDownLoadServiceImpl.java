package com.shigu.main4.monitor.service.impl;

import com.opentae.data.mall.beans.ShiguAppDownLoad;
import com.opentae.data.mall.examples.ShiguAppDownLoadExample;
import com.opentae.data.mall.interfaces.ShiguAppDownLoadMapper;
import com.shigu.main4.monitor.enums.AppDownLoadTypeEnum;
import com.shigu.main4.monitor.services.AppDownLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * APP下载统计
 * Created by zhaohongbo on 17/2/16.
 */
@Service("appDownLoadService")
public class AppDownLoadServiceImpl implements AppDownLoadService {

    @Autowired
    private ShiguAppDownLoadMapper shiguAppDownLoadMapper;

    /**
     * 下载量+1
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ )
    public void addDownLoadNum(Integer type){
        AppDownLoadTypeEnum appDownLoadTypeEnum = AppDownLoadTypeEnum.paseType(type);
        if (appDownLoadTypeEnum == null) {
            return;
        }
        ShiguAppDownLoadExample example = new ShiguAppDownLoadExample();
        example.createCriteria().andTerminalTypeEqualTo(type);
        List<ShiguAppDownLoad> shiguAppDownLoads = shiguAppDownLoadMapper.selectByExample(example);
        ShiguAppDownLoad shiguAppDownLoad = shiguAppDownLoads.get(0);
        shiguAppDownLoad.setDownLoadNum(shiguAppDownLoad.getDownLoadNum() + 1);
        shiguAppDownLoadMapper.updateByPrimaryKeySelective(shiguAppDownLoad);
    }
}
