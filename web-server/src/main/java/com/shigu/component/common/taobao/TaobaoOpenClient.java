package com.shigu.component.common.taobao;


import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;

/**
 * 淘宝客户端调用
 *
 */
public class TaobaoOpenClient {

    public static TaobaoClient taobaoClient = null;

    public static TaobaoClient getTaobaoClient() {
        if (taobaoClient == null) {
            taobaoClient = new DefaultTaobaoClient(TaobaoConfig.appServerUrl, TaobaoConfig.appKey, TaobaoConfig.appSecret);
        }
        return taobaoClient;
    }

}
