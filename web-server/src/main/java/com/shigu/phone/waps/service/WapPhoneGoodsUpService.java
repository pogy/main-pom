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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 类名：PhoneGoodsUpService
 * 类路径：com.shigu.phone.services.PhoneGoodsUpService
 * 创建者：王浩翔
 * 创建时间：2017-08-30 9:22
 * 项目：main-pom
 * 描述：移动端商品上传
 */

@Service
public class WapPhoneGoodsUpService {

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

    @Autowired
    private MemberSimpleService memberSimpleService;

    @Autowired
    private RedisIO redisIO;

    public UpToWxResponse upToWx(UpToWxRequest request) {
        UpToWxResponse resp = new UpToWxResponse();
        OpenException openException = new OpenException();
        //验证不通过
        if (!request.getToken().equals(redisIO.get("phone_login_token" + request.getUserId()))) {
            openException.setErrMsg("tocken验证失败");
            resp.setException(openException);
            resp.setSuccess(false);
            return resp;
        }
        ItemUpRecordVO bo = new ItemUpRecordVO();
        bo.setFlag("wx");
        bo.setDaiTime(DateUtil.dateToString(new Date(),DateUtil.patternD));
        MemberUser memberUser = memberUserMapper.selectFieldsByPrimaryKey(request.getUserId(), FieldUtil.codeFields("user_id,user_nick"));
        bo.setFenUserId(request.getUserId());
        bo.setFenUserNick(memberUser.getUserNick());
        CdnItem cdnItem = showForCdnService.selItemById(request.getGoodsId(), request.getWebSite());
        if (cdnItem == null) {
            openException.setErrMsg("未查询到商品："+request.getGoodsId());
            resp.setException(openException);
            resp.setSuccess(false);
            return resp;
        }
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
        resp.setSuccess(true);
        return resp;
    }

    public UploadedItemResponse uploadedItem(UploadedItemRequest request) {
        if(request.getIndex()==null){
            request.setIndex(1);
        }
        UploadedItemResponse res=new UploadedItemResponse();
        String nick=memberSimpleService.selNick(request.getUserId());
        ShiguPager<OnekeyRecoreVO> pager;
        if(nick==null){
            pager=itemUpRecordService.uploadedItems(request.getUserId(),request.getType(),request.getIndex(),10);
        }else{
            pager=itemUpRecordService.uploadedItems(request.getUserId(),nick,request.getType(),request.getIndex(),10);
        }
        pager.calPages(pager.getTotalCount(),10);
        res.setTotal(pager.getTotalCount());
        res.setHasNext(request.getIndex()<100&&request.getIndex()<pager.getTotalPages());

        List<AppItemUploaded> eds=new ArrayList<>();
        for(OnekeyRecoreVO vo:pager.getContent()){
            AppItemUploaded ed=new AppItemUploaded();
            ed.setGoodsId(vo.getId());
            ed.setSupperDown(vo.getUnShelve());
            ed.setImDown(vo.getTbUnSheLve());
            ed.setImgsrc(vo.getImgsrc());
            ed.setPiprice(vo.getPiprice());
            ed.setTitle(vo.getTitle());
            ed.setUploadId(vo.getOnekeyId());
            eds.add(ed);
        }
        res.setItems(eds);
        res.setSuccess(true);
        return res;
    }

    public InstockMyItemResponse instockMyItem(InstockMyItemRequest request) {
        //查询上传记录
        SingleItemUpRecordVO singleItemUpRecordVO= itemUpRecordService.singleUploadedItem(request.getUploadId());
        if(singleItemUpRecordVO != null){
            //todo 先下架淘宝

            //再修改上传记录
            ItemUpRecordVO itemUpRecordVO= BeanMapper.map(singleItemUpRecordVO,ItemUpRecordVO.class);
            itemUpRecordService.updateItemUpload(itemUpRecordVO,singleItemUpRecordVO.getOneKeyId());
        }
        InstockMyItemResponse res=new InstockMyItemResponse();
        res.setSuccess(true);
        return res;
    }
}
