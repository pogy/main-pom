package com.shigu.seller.vo;

import com.shigu.main4.monitor.vo.DataLineVO;

import java.io.Serializable;
import java.util.List;

/**
 * 按日统计流量
 * Created by zhaohongbo on 17/3/19.
 */
public class DateDataLineVO implements Serializable{
    /**
     * PV流量
     */
    private List<DataLineVO> pvList;
    /**
     * ip流量
     */
    private List<DataLineVO> ipList;

    public List<DataLineVO> getPvList() {
        return pvList;
    }

    public void setPvList(List<DataLineVO> pvList) {
        this.pvList = pvList;
    }

    public List<DataLineVO> getIpList() {
        return ipList;
    }

    public void setIpList(List<DataLineVO> ipList) {
        this.ipList = ipList;
    }
}
