package com.shigu.phone.services;

import com.openJar.requests.app.UpToWxRequest;
import com.openJar.responses.app.UpToWxResponse;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.vo.ShopBase;
import com.shigu.main4.vo.StoreRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 类名：PhoneGoodsUpService
 * 类路径：com.shigu.phone.services.PhoneGoodsUpService
 * 创建者：王浩翔
 * 创建时间：2017-08-30 9:22
 * 项目：main-pom
 * 描述：移动端商品上传
 */

@Service
public class PhoneGoodsUpService {

    @Autowired
    private ItemUpRecordService itemUpRecordService;

    @Autowired
    private ShowForCdnService showForCdnService;

    @Autowired
    private StoreRelationService storeRelationService;

    @Autowired
    private ShopBaseService shopBaseService;

    @Autowired
    private MemberUserMapper memberUserMapper;

    public UpToWxResponse upToWx(UpToWxRequest request) {
        ItemUpRecordVO bo = new ItemUpRecordVO();
        bo.setFlag("wx");
        bo.setDaiTime(DateUtil.dateToString(new Date(),DateUtil.patternD));
        MemberUser memberUser = memberUserMapper.selectFieldsByPrimaryKey(request.getUserId(), FieldUtil.codeFields("user_id,user_nick"));
        bo.setFenUserId(request.getUserId());
        bo.setFenUserNick(memberUser.getUserNick());

        CdnItem cdnItem = showForCdnService.selItemById(request.getGoodsId(), request.getWebSite());
        bo.setFenPrice(cdnItem.getPiPrice());
        bo.setSupperPiPrice(cdnItem.getPiPrice());
        bo.setSupperPrice(cdnItem.getPrice());
        bo.setStatus(0L);
        bo.setFenGoodsName(cdnItem.getTitle());
        bo.setSupperGoodsId(request.getGoodsId());
        bo.setSupperStoreId(cdnItem.getShopId());
        bo.setSupperMarketId(cdnItem.getMarketId());
        bo.setSupperNumiid(cdnItem.getTbNumIid());
        if (!cdnItem.getImgUrl().isEmpty()) {
            String img = cdnItem.getImgUrl().get(0);
            bo.setSupperImage(img);
            bo.setFenImage(img);
        }
        bo.setSupperGoodsName(cdnItem.getTitle());
        bo.setWebSite(cdnItem.getWebSite());
        bo.setFenNumiid(cdnItem.getTbNumIid());
        ShopBase shopBase = shopBaseService.shopBaseForUpdate(cdnItem.getShopId());
        bo.setSupperTaobaoUrl(shopBase.getTaobaoUrl());
        bo.setSupperStoreName(shopBase.getShopName());
        StoreRelation storeRelation = storeRelationService.selRelationById(cdnItem.getShopId(), request.getWebSite());
        if (storeRelation != null) {
            bo.setSupperStorenum(storeRelation.getStoreNum());
            bo.setSupperImww(storeRelation.getImWw());
            bo.setSupperTelephone(storeRelation.getTelephone());
            bo.setSupperMarket(storeRelation.getMarketName());
            bo.setSupperQq(storeRelation.getImQq());
        }
        StringBuilder sb = new StringBuilder();
        for (String s : showForCdnService.selItemLicenses(request.getGoodsId(), cdnItem.getShopId())) {
            switch (s) {
                case "1":
                    sb.append("退现金");
                    sb.append(',');
                    break;
                case "2":
                    sb.append("包换款");
                    sb.append(',');
                    break;
                default:
            }
        }
        if (sb.length()>0) {
            sb.setLength(sb.length()-1);
        }
        bo.setSupperServers(sb.toString());
        itemUpRecordService.addItemUpRecord(bo);
        UpToWxResponse resp = new UpToWxResponse();
        resp.setSuccess(true);
        return resp;
    }
}
