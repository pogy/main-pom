package com.shigu.services;

import com.shigu.tb.finder.services.MainTbOnsaleService;
import com.shigu.tb.finder.services.TaobaoSynService;
import com.shigu.tb.finder.services.TaobaoTmcService;
import com.shigu.tb.finder.services.TbPropsService;

/**
 * 放所有的dubbo的服务类
 * Created by zhaohongbo on 17/2/28.
 */
public class DubboAllService {
    /**
     * 淘宝店出售中的
     */
    private MainTbOnsaleService maintbOnsaleService;

    /**
     * 淘宝类目属性
     */
    private TbPropsService tbPropsService;
    /**
     * 同步淘宝商品用
      */
    private TaobaoSynService taobaoSynService;

    /**
     * 淘宝推送
     *
     */
    private TaobaoTmcService taobaoTmcService;

    public TbPropsService getTbPropsService() {
        return tbPropsService;
    }

    public void setTbPropsService(TbPropsService tbPropsService) {
        this.tbPropsService = tbPropsService;
    }

    public MainTbOnsaleService getMaintbOnsaleService() {
        return maintbOnsaleService;
    }

    public void setMaintbOnsaleService(MainTbOnsaleService maintbOnsaleService) {
        this.maintbOnsaleService = maintbOnsaleService;
    }

    public TaobaoSynService getTaobaoSynService() {
        return taobaoSynService;
    }

    public void setTaobaoSynService(TaobaoSynService taobaoSynService) {
        this.taobaoSynService = taobaoSynService;
    }

    public TaobaoTmcService getTaobaoTmcService() {
        return taobaoTmcService;
    }

    public void setTaobaoTmcService(TaobaoTmcService taobaoTmcService) {
        this.taobaoTmcService = taobaoTmcService;
    }
}
