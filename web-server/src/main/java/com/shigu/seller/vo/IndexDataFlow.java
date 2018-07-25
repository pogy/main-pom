package com.shigu.seller.vo;

import com.shigu.main4.monitor.vo.DataLineVO;

import java.io.Serializable;
import java.util.List;

/**
 * 供货商,首页数据统计
 * Created by zhaohongbo on 17/3/19.
 */
public class IndexDataFlow implements Serializable{
    /**
     * 被代理商品图
     */
    private Integer dailiGoods;
    /**
     * 被上货的次数
     */
    private Integer dailiRecord;
    /**
     * 代理的人数
     */
    private Integer dailiPerson;
    /**
     * 热门商品
     */
    private List<HotItemVO> hotGoods;
    /**
     * 不热商品
     */
    private List<HotItemVO> nothotGoods;
    /**
     * PV流量
     */
    private List<DataLineVO> pvList;
    /**
     * ip流量
     */
    private List<DataLineVO> ipList;
    /**
     * 淘宝等级
     */
    private List<DataLineVO> xinList;

    public Integer getDailiGoods() {
        return dailiGoods;
    }

    public void setDailiGoods(Integer dailiGoods) {
        this.dailiGoods = dailiGoods;
    }

    public Integer getDailiRecord() {
        return dailiRecord;
    }

    public void setDailiRecord(Integer dailiRecord) {
        this.dailiRecord = dailiRecord;
    }

    public Integer getDailiPerson() {
        return dailiPerson;
    }

    public void setDailiPerson(Integer dailiPerson) {
        this.dailiPerson = dailiPerson;
    }

    public List<HotItemVO> getHotGoods() {
        return hotGoods;
    }

    public void setHotGoods(List<HotItemVO> hotGoods) {
        this.hotGoods = hotGoods;
    }

    public List<HotItemVO> getNothotGoods() {
        return nothotGoods;
    }

    public void setNothotGoods(List<HotItemVO> nothotGoods) {
        this.nothotGoods = nothotGoods;
    }

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

    public List<DataLineVO> getXinList() {
        return xinList;
    }

    public void setXinList(List<DataLineVO> xinList) {
        this.xinList = xinList;
    }
}
