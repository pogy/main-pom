package com.shigu.main4.monitor.services;

import com.shigu.main4.monitor.bo.PageInfoBO;
import com.shigu.main4.monitor.vo.ClientMsg;

/**
 * 浏览记录监控服务
 * Created by zhaohongbo on 17/2/16.
 */
public interface BrowerMonitorService {
    /**
     * 进入页面时,记录数据
     * @param type 类型,item\shop\other
     * @param client 客户端信息
     * @return 主键key
     */
    String inPage(String type, Long userId, PageInfoBO pageInfo, ClientMsg client);

    /**
     * 离开页面时记录
     * @param idKey 主键key
     * @return
     */
    boolean outPage(String idKey);

    /**
     * 进入商品页面时,查询站点
     * @param idKey 主键key
     * @return
     */
    String selWebSite(Long idKey);

}
