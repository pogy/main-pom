package com.shigu.main4.monitor.services;

/**
 * APP下载统计
 * Created by zhaohongbo on 17/2/16.
 */
public interface AppDownLoadService {
    /**
     * 下载记录
     */
    void addDownLoadRecord(Integer type);
}
