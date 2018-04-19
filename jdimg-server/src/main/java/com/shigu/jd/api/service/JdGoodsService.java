package com.shigu.jd.api.service;

import com.alibaba.fastjson.JSONObject;
import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.request.ware.ImageWriteUpdateRequest;
import com.jd.open.api.sdk.request.ware.TransportWriteUpdateWareTransportIdRequest;
import com.jd.open.api.sdk.request.ware.WareAddRequest;
import com.jd.open.api.sdk.response.ware.ImageWriteUpdateResponse;
import com.jd.open.api.sdk.response.ware.WareAddResponse;
import com.openJar.beans.JdAuthedInfo;
import com.openJar.beans.SdkJdWareAdd;
import com.openJar.exceptions.imgs.JdApiException;
import com.openJar.responses.api.GoodsCanbeUploadedToJdResponse;
import com.openJar.responses.api.JdAuthedInfoResponse;
import com.openJar.responses.api.JdSkuInfoResponse;
import com.openJar.responses.api.JdWareAddResponse;
import com.opentae.data.jd.beans.JdTbBind;
import com.opentae.data.jd.interfaces.JdTbBindMapper;
import com.openJar.beans.SdkJdImageUpdate;
import com.openJar.beans.JdUpGoods;
import com.shigu.exceptions.CustomException;
import com.shigu.exceptions.ImgDownloadException;
import com.shigu.exceptions.JdAuthOverdueException;
import com.shigu.exceptions.OtherCustomException;
import com.shigu.jd.api.exceptions.JdAuthFailureException;
import com.shigu.jd.tools.DownImage;
import com.shigu.main4.common.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created By admin on 2017/12/14/16:45
 * 京东商品接口
 */
@Service
public class JdGoodsService {

    @Autowired
    private JdClientService jdClientService;

    @Autowired
    private JdAuthService jdAuthService;

    @Autowired
    private JdTbBindMapper jdTbBindMapper;


    /**
     * 商品一键上传到京东
     * @param bo
     * @param jdUid
     * @throws JdException
     */
    public SdkJdWareAdd upToJd(JdUpGoods bo, Long jdUid) throws OtherCustomException, JdAuthOverdueException {
        JdAuthedInfo authedInfo = jdAuthService.getAuthedInfo(jdUid);
        WareAddRequest request = new WareAddRequest();
        request.setInputStrs(bo.getInputStrs());
        request.setInputPids(bo.getInputPids());
        request.setImported(bo.getImported());
        request.setPayFirst(bo.getPayFirst());
        request.setOuterId(bo.getOuterId());
        request.setPropertyAlias(bo.getPropertyAlias());
        request.setAttributes(bo.getAttributes());
        request.setSkuStocks(bo.getSkuStocks());
        request.setSkuPrices(bo.getSkuPrices());
        request.setSkuProperties(bo.getSkuProperties());
        request.setNotes(bo.getNotes());
        request.setJdPrice(bo.getJdPrice());
        request.setMarketPrice(bo.getMarketPrice());
        request.setCostPrice(bo.getCostPrice());
        request.setWeight(bo.getWeight());
        request.setHigh(bo.getHigh());
        request.setWide(bo.getWide());
        request.setLength(bo.getLength());
        request.setStockNum(bo.getStockNum());
        request.setItemNum(bo.getItemNum());
        request.setOptionType(bo.getOptionType());
        request.setTitle(bo.getTitle());
        request.setShopCategory(bo.getShopCategory());
        request.setCid(bo.getCid());
        request.setWarePackType(bo.getWarePackType());
        request.setCanVAT(bo.getCanVAT());
        request.setHasCheckCode(bo.getHasCheckCode());
        request.setListTime(bo.getListTime());
        request.setPackListing(bo.getPackListing());
        request.setProducter(bo.getProducter());
        request.setService(bo.getService());
        request.setTradeNo(bo.getTradeNo());
        request.setWareBigSmallModel(bo.getWareBigSmallModel());
        request.setWareLocation(bo.getWareLocation());
        request.setWrap(bo.getWrap());
        request.setWareImage(DownImage.downImgFile(bo.getWareImageUrl()));
        WareAddResponse response = jdClientService.execute(request,authedInfo.getAccessToken());
        SdkJdWareAdd goods=new SdkJdWareAdd();
        goods.setGoodsId(response.getWareId());
        goods.setJdSkuInfoVOS(response.getSkuInfo().stream().map(skuInfo -> BeanMapper.map(skuInfo,JdSkuInfoResponse.class)).collect(Collectors.toList()));
        return goods;
    }

    /**
     * 新增和修改商品图片
     */
    public void jdImageUpdate(SdkJdImageUpdate bo, Long  jdUid) throws JdAuthOverdueException, OtherCustomException {
        JdAuthedInfo authedInfo = jdAuthService.getAuthedInfo(jdUid);
        ImageWriteUpdateRequest request=new ImageWriteUpdateRequest();
        request.setColorId(bo.getColorId());
        request.setImgId(bo.getImgId());
        request.setImgIndex(bo.getImgIndex());
        request.setImgUrl(bo.getImgUrl());
        request.setImgZoneId(bo.getImgZoneId());
        request.setWareId(bo.getGoodsId());
        jdClientService.execute(request, authedInfo.getAccessToken());
    }

    /**
     * 根据cid查询商品是否可上传到京东
     * @param tbCid
     */
    public boolean goodsCanbeUploadedToJd(Long tbCid) {
        JdTbBind jdTbBind = new JdTbBind();
        jdTbBind.setTbCid(tbCid);
        jdTbBind = jdTbBindMapper.selectOne(jdTbBind);
        return jdTbBind != null;
    }

    /**
     * 绑定运费模板到商品
     * @param jdUid
     * @param wareId
     * @param templateId
     */
    public boolean bindPostTemplate(Long jdUid, Long wareId, Long templateId) throws JdAuthOverdueException, OtherCustomException {
        JdAuthedInfo authedInfo = jdAuthService.getAuthedInfo(jdUid);
        TransportWriteUpdateWareTransportIdRequest request=new TransportWriteUpdateWareTransportIdRequest();
        request.setWareId(wareId);
        request.setTransportId(templateId);
        return jdClientService.execute(request, authedInfo.getAccessToken()).getSuccess();
    }
}
