package com.shigu.main4.daifa.process;

public interface DaifaActProcess {

    /**
     * 添加操作记录
     * @param workerId
     * @param param
     * @param url
     */
    void addAct(Long workerId, String param, String url);
}
