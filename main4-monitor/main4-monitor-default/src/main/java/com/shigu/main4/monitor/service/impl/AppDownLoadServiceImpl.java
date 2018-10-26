package com.shigu.main4.monitor.service.impl;

import com.opentae.data.mall.beans.ShiguAppDownLoad;
import com.opentae.data.mall.interfaces.ShiguAppDownLoadMapper;
import com.shigu.main4.monitor.enums.AppDownLoadTypeEnum;
import com.shigu.main4.monitor.services.AppDownLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * APP下载统计
 * Created by zhaohongbo on 17/2/16.
 */
@Service("appDownLoadService")
public class AppDownLoadServiceImpl implements AppDownLoadService {

    @Autowired
    private ShiguAppDownLoadMapper shiguAppDownLoadMapper;

    /**
     * 下载记录
     */
    public void addDownLoadRecord(Integer type){
        AppDownLoadTypeEnum appDownLoadTypeEnum = AppDownLoadTypeEnum.paseType(type);
        if (appDownLoadTypeEnum == null) {
            return;
        }
        ShiguAppDownLoad shiguAppDownLoad = new ShiguAppDownLoad();
        shiguAppDownLoad.setTerminalType(type);
        shiguAppDownLoad.setGmtCreate(new Date());
        shiguAppDownLoadMapper.insert(shiguAppDownLoad);
    }
}
