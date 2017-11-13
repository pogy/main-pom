package com.shigu.phone.apps.services;

import com.openJar.beans.app.AppGoodsBlock;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.ImgSearchRequest;
import com.openJar.requests.app.ItemSearchRequest;
import com.openJar.requests.app.OneItemRequest;
import com.openJar.responses.app.ImgSearchResponse;
import com.openJar.responses.app.ItemSearchResponse;
import com.openJar.responses.app.OneItemResponse;
import com.shigu.main4.cdn.exceptions.CdnException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.phone.baseservices.BasePhoneGoodsSearchService;
import com.shigu.phone.basevo.ItemSearchVO;
import com.shigu.phone.basevo.OneItemVO;
import com.shigu.search.bo.WapSearchBO;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 类名：PhoneGoodsSearchService
 * 类路径：com.shigu.phone.apps.baseservices.PhoneGoodsSearchService
 * 创建者：王浩翔
 * 创建时间：2017-08-29 14:35
 * 项目：main-pom
 * 描述：移动端商品搜索service
 */
@Service
public class PhoneGoodsSearchService {

    @Autowired
    private BasePhoneGoodsSearchService basePhoneGoodsSearchService;


    /**
     * 移动端商品搜索
     *
     * @param request
     * @return
     */
    public ItemSearchResponse itemSearch(ItemSearchRequest request) {
        ItemSearchResponse resp = new ItemSearchResponse();
        try {
            WapSearchBO bo = new WapSearchBO();
            bo.setWebSite(request.getWebSite());
            bo.setKeyword(request.getKeyword());
            bo.setMid(request.getMarketId());
            bo.setCid(request.getCid());
//            bo.setPid(request.getCid());
            bo.setShopId(request.getStoreId());
            if (request.getType() != null && request.getType() == 2) {
                //商品库搜索顺序
                bo.setFrom("goods");
            }
            bo.setSort(request.getOrderBy());
            final String dateFormat = "yyyy.MM.dd";
            SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.patternA);
            Date startTime = null;
            Date endtTime = null;
            if (!StringUtils.isEmpty(request.getStartTime())) {
                startTime  = sdf.parse(request.getStartTime());
            }
            if (!StringUtils.isEmpty(request.getEndTime())) {
                endtTime  = sdf.parse(request.getEndTime());
            }

            bo.setSt(startTime == null? null : DateUtil.dateToString(startTime, dateFormat));
            bo.setEt(endtTime == null ? null : DateUtil.dateToString(endtTime, dateFormat));
            bo.setSp(StringUtil.isNull(request.getStartPrice()) ? null : Double.valueOf(request.getStartPrice()));
            bo.setEp(StringUtil.isNull(request.getEndPrice()) ? null : Double.valueOf(request.getEndPrice()));
            bo.setPage(request.getIndex());
            bo.setRows(request.getSize());
            ItemSearchVO itemSearchVO;
            if(request.getStoreId()==null){
                itemSearchVO = basePhoneGoodsSearchService.itemSearch(bo, request.getOrderBy());
            }else{
                itemSearchVO = basePhoneGoodsSearchService.itemSearch(bo, request.getOrderBy(),request.getStoreId());
            }
            resp.setSuccess(true);
            resp.setHasNext(itemSearchVO.getHasNext());
            resp.setItems(itemSearchVO.getItems());
            resp.setTotal(itemSearchVO.getTotal());
            return resp;
        } catch (ParseException|OpenException e) {
            OpenException openException = new OpenException();
            openException.setErrMsg(e.getMessage());
            resp.setException(openException);
            resp.setSuccess(false);
            return resp;
        }
    }

    /**
     * 移动端图搜
     *
     * @param request
     * @return
     */
    public ImgSearchResponse imgSearch(ImgSearchRequest request) {
        ImgSearchResponse resp = new ImgSearchResponse();
        try {
            List<AppGoodsBlock> appGoodsBlocks = basePhoneGoodsSearchService.imgSearch(request.getImgurl(), request.getWebSite());
            resp.setItems(appGoodsBlocks);
            resp.setSuccess(true);
        } catch (IOException e) {
           OpenException openException = new OpenException();
           openException.setErrMsg(e.getMessage());
           resp.setSuccess(false);
           resp.setException(openException);
        }
        return resp;
    }

    /**
     * app单商品信息
     * @param request
     * @return
     */
    public OneItemResponse oneItem(OneItemRequest request) {
        OneItemResponse resp = new OneItemResponse();
        resp.setSuccess(true);
        try {
            OneItemVO oneItemVO = basePhoneGoodsSearchService.oneItem(request.getWebSite(), request.getItemId(), request.getUserId());
            resp.setTitle(oneItemVO.getTitle());
            resp.setGoodsId(oneItemVO.getGoodsId());
            resp.setImgSrcs(oneItemVO.getImgSrcs());
            resp.setGoodsNo(oneItemVO.getGoodsNo());
            resp.setCreateTime(oneItemVO.getCreateTime());
            resp.setGoodsLicenses(oneItemVO.getGoodsLicenses());
            resp.setPrice(oneItemVO.getLiPrice());
            resp.setStoreId(oneItemVO.getStoreId());
            resp.setMarket(oneItemVO.getMarket());
            resp.setStoreNum(oneItemVO.getStoreNum());
            resp.setStarNum(oneItemVO.getStarNum());
            resp.setColors(oneItemVO.getColors());
            resp.setSize(oneItemVO.getSize());
            resp.setItemKvs(oneItemVO.getItemKvs());
            resp.setShopHeadUrl(oneItemVO.getShopHeadUrl());
            resp.setCollectId(oneItemVO.getCollectId());
        } catch (TemplateException|CdnException|IOException e) {
            OpenException openException = new OpenException();
            openException.setErrMsg(e.getMessage());
            resp.setSuccess(false);
            resp.setException(openException);
        } catch (Main4Exception e) {
            e.printStackTrace();
        }
        return resp;
    }


}
