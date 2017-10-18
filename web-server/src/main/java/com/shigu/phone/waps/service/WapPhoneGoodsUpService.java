package com.shigu.phone.waps.service;

import com.openJar.beans.app.AppItemUploaded;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.InstockMyItemRequest;
import com.openJar.requests.app.UpToWxRequest;
import com.openJar.requests.app.UploadedItemRequest;
import com.openJar.responses.app.InstockMyItemResponse;
import com.openJar.responses.app.UpToWxResponse;
import com.openJar.responses.app.UploadedItemResponse;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.shigu.buyer.services.MemberSimpleService;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.monitor.vo.OnekeyRecoreVO;
import com.shigu.main4.monitor.vo.SingleItemUpRecordVO;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.vo.ShopBase;
import com.shigu.main4.vo.StoreRelation;
import com.shigu.phone.baseservices.BasePhoneGoodsUpService;
import com.shigu.phone.basevo.UploadedItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 类名：PhoneGoodsUpService
 * 类路径：com.shigu.phone.apps.baseservices.PhoneGoodsUpService
 * 创建者：王浩翔
 * 创建时间：2017-08-30 9:22
 * 项目：main-pom
 * 描述：移动端商品上传
 */

@Service
public class WapPhoneGoodsUpService {

    @Autowired
    private BasePhoneGoodsUpService basePhoneGoodsUpService;

    public void upToWx(String webSite,Long goodsId,Long userId) throws OpenException {
        basePhoneGoodsUpService.upToWx(webSite,goodsId,userId);
    }

    public UploadedItemVO uploadedItem(Integer type,Integer index,Integer size,Long userId) {
        return basePhoneGoodsUpService.uploadedItem(type, index, size, userId);
    }

    public void instockMyItem(String upLoadId,Long userId) throws OpenException {
        basePhoneGoodsUpService.instockMyItem(upLoadId, userId);
    }
}
