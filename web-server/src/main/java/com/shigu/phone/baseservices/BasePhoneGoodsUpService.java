package com.shigu.phone.baseservices;

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
import com.shigu.buyer.bo.OnekeyRecordBO;
import com.shigu.buyer.services.GoodsupRecordSimpleService;
import com.shigu.buyer.services.MemberSimpleService;
import com.shigu.buyer.vo.OnekeyRecoreVO;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.monitor.vo.SingleItemUpRecordVO;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.vo.ShopBase;
import com.shigu.main4.vo.StoreRelation;
import com.shigu.phone.api.enums.ImgFormatEnum;
import com.shigu.phone.apps.utils.ImgUtils;
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
public class BasePhoneGoodsUpService {

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
    private GoodsupRecordSimpleService goodsupRecordSimpleService;

    public void upToWx(String webSite,Long goodsId,Long userId) throws OpenException {
        OpenException openException = new OpenException();

        ItemUpRecordVO bo = new ItemUpRecordVO();
        bo.setFlag("wx");
        bo.setDaiTime(DateUtil.dateToString(new Date(),DateUtil.patternD));
        MemberUser memberUser = memberUserMapper.selectFieldsByPrimaryKey(userId, FieldUtil.codeFields("user_id,user_nick"));
        bo.setFenUserId(userId);
        bo.setFenUserNick(memberUser.getUserNick());
        CdnItem cdnItem = showForCdnService.selItemById(goodsId, webSite);
        if (cdnItem == null) {
            openException.setErrMsg("未查询到商品："+goodsId);
            throw openException;
        }
        bo.setFenPrice(cdnItem.getPiPrice());
        bo.setSupperPiPrice(cdnItem.getPiPrice());
        bo.setSupperPrice(cdnItem.getPrice());
        bo.setStatus(0L);
        bo.setFenGoodsName(cdnItem.getTitle());
        bo.setSupperGoodsId(goodsId);
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
        StoreRelation storeRelation = storeRelationService.selRelationById(cdnItem.getShopId(), webSite);
        if (storeRelation != null) {
            bo.setSupperStorenum(storeRelation.getStoreNum());
            bo.setSupperImww(storeRelation.getImWw());
            bo.setSupperTelephone(storeRelation.getTelephone());
            bo.setSupperMarket(storeRelation.getMarketName());
            bo.setSupperQq(storeRelation.getImQq());
        }
        StringBuilder sb = new StringBuilder();
        for (String s : showForCdnService.selItemLicenses(goodsId, cdnItem.getShopId())) {
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

    }

    public UploadedItemVO uploadedItem(Integer type,Integer index,Integer size,Long userId) {
        if(index == null){
            index = 1;
        }
        UploadedItemVO uploadedItemVO = new UploadedItemVO();
        String nick=memberSimpleService.selNick(userId);
//        ShiguPager<OnekeyRecoreVO> pager;
//        if(nick==null){
//            pager=itemUpRecordService.uploadedItems(userId,type,index,size);
//        }else{
//            pager=itemUpRecordService.uploadedItems(userId,nick,type,index,size);
//        }
        OnekeyRecordBO bo = new OnekeyRecordBO();
        bo.setPage(index);
        bo.setRows(size);
        if(type != 1){
            // 2 待处理： 应档口已下架 淘宝未下架
            // 3 淘宝已下架
            bo.setUploadGoodsState(type);
            bo.setFlag("web-tb");
        }

        ShiguPager<OnekeyRecoreVO> pager = goodsupRecordSimpleService.selOnekeyRecore(userId, nick, bo);

        pager.calPages(pager.getTotalCount(),size);
        uploadedItemVO.setTotal(pager.getTotalCount());
        uploadedItemVO.setHasNext(index<100&&index<pager.getTotalPages());

        List<AppItemUploaded> eds=new ArrayList<>();
        for(OnekeyRecoreVO vo:pager.getContent()){
            if (vo == null || StringUtil.isNull(vo.getPiprice())) {
                continue;
            }
            AppItemUploaded ed=new AppItemUploaded();
            ed.setGoodsId(vo.getGoodsId());
            ed.setSupperDown(vo.getShopSaleState());
            ed.setImDown(vo.getTaobaoSaleState());
            ed.setImgsrc(ImgUtils.formatImg(vo.getImgsrc(), ImgFormatEnum.GOODS_LIST));
            ed.setPiprice(vo.getPiprice());
            ed.setTitle(vo.getTitle());
            ed.setUploadId(vo.getOnekeyId());
            eds.add(ed);
        }
        uploadedItemVO.setItems(eds);
        return uploadedItemVO;
    }

    public void instockMyItem(String uploadId,Long userId) throws OpenException {
        //查询上传记录
        SingleItemUpRecordVO singleItemUpRecordVO= itemUpRecordService.singleUploadedItem(uploadId);
        if(singleItemUpRecordVO != null){
            //下架淘宝
            try {
                itemUpRecordService.soldOutTbItem(userId,singleItemUpRecordVO.getFenNumiid());
            } catch (Main4Exception e) {
                OpenException openException = new OpenException();
                openException.setErrMsg("下架淘宝失败");
                throw openException;
            }
            //再修改上传记录
            ItemUpRecordVO itemUpRecordVO= BeanMapper.map(singleItemUpRecordVO,ItemUpRecordVO.class);
            itemUpRecordService.updateItemUpload(itemUpRecordVO,singleItemUpRecordVO.getOneKeyId());
        }

    }
}
