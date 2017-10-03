package com.shigu.phone.apps.services;

import com.openJar.beans.app.*;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.*;
import com.openJar.responses.app.*;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.cdn.services.MarketListService;
import com.shigu.main4.cdn.vo.MarketTagVO;
import com.shigu.main4.cdn.vo.MarketVO;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.newcdn.vo.CdnShopCatVO;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.vo.StoreRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017-08-29.
 * app 店铺 service
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class AppItemService {

    public ItemCollectResponse collectItem(ItemCollectRequest request){
        ItemCollectResponse response = new ItemCollectResponse();

        return response;
    }
    public DelItemCollectResponse delItemCollect(DelItemCollectRequest request){
        DelItemCollectResponse response = new DelItemCollectResponse();

        return response;
    }




}
