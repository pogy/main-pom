package com.shigu.seller.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 店铺基本设置
 * Created by zhaohongbo on 17/3/18.
 */
public class ShopTypeSetVO implements Serializable{

    /**
     * 主营类目
     */
    private String mainBus;

    /**
     * 服务登录
     */
    private List<String> servers;

    /**
     * 经营种类
     */
    private String [] business_type;

    private List<ShopTagVO> server_level;

    public String getMainBus() {
        return mainBus;
    }

    public void setMainBus(String mainBus) {
        this.mainBus = mainBus;
    }

    public List<String> getServers() {
        return servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }

    public String[] getBusiness_type() {
        return business_type;
    }

    public void setBusiness_type(String[] business_type) {
        this.business_type = business_type;
    }

    public List<ShopTagVO> getServer_level() {
        return server_level;
    }

    public void setServer_level(List<ShopTagVO> server_level) {
        this.server_level = server_level;
    }
}
