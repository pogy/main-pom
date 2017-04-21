package com.shigu.sysman.taobao.service;


import com.alibaba.fastjson.JSON;
import com.shigu.component.common.taobao.TaobaoConfig;
import com.shigu.component.common.taobao.TaobaoOpenClient;
import com.taobao.api.ApiException;
import com.taobao.api.request.ShopGetRequest;
import com.taobao.api.response.ShopGetResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 淘宝开放接口
 *
 * @author shigu_zjb
 * @date 2017/04/03 10:34
 *
 */
@Service
public class TaobaoOpenService {

    private static final Logger logger = LoggerFactory.getLogger(TaobaoOpenService.class);

    /**
     * 淘宝店铺基本信息
     * @param nick
     * @return
     */
    public ShopGetResponse getShopGetResponse(String nick){
        logger.info("淘宝店铺基本信息>>nick：" + nick);
        if(StringUtils.isEmpty(nick)){
            return null;
        }
        ShopGetRequest req = new ShopGetRequest();
        req.setFields("sid,cid,title,nick,desc,bulletin,pic_path,created,modified");
        req.setNick(nick);
        try{
            ShopGetResponse rsp = TaobaoOpenClient.getTaobaoClient().execute(req);
            logger.info("淘宝店铺基本信息>>调用成功>>rsp：" + JSON.toJSONString(rsp));
            return rsp;
        }catch (ApiException e){
            e.printStackTrace();
            logger.error("淘宝店铺基本信息>>调用出错>>error：" + e.toString());
        }
        return null;
    }

}
