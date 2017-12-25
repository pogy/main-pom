package com.shigu.main4.jd.service.impl;

import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.request.ware.ImageWriteUpdateRequest;
import com.jd.open.api.sdk.request.ware.WareAddRequest;
import com.jd.open.api.sdk.response.ware.ImageWriteUpdateResponse;
import com.jd.open.api.sdk.response.ware.WareAddResponse;
import com.opentae.data.jd.beans.JdTbBind;
import com.opentae.data.jd.interfaces.JdTbBindMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.jd.bo.JdImageUpdateBO;
import com.shigu.main4.jd.bo.JdUpBO;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdAuthService;
import com.shigu.main4.jd.service.JdGoodsService;
import com.shigu.main4.jd.util.JdUtil;
import com.shigu.main4.jd.vo.JdAuthedInfoVO;
import com.shigu.main4.jd.vo.JdWareAddVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created By admin on 2017/12/14/16:45
 * 京东商品接口
 */
@Service("jdGoodsService")
public class JdGoodsServiceImpl implements JdGoodsService{

    @Autowired
    private JdUtil jdUtil;

    @Autowired
    private JdAuthService jdAuthService;

    @Autowired
    private JdTbBindMapper jdTbBindMapper;


    /**
     * 商品一键上传到京东
     * @param bo
     * @param userId
     * @throws JdException
     * @throws IOException
     */
    @Override
    public JdWareAddVO upToJd(JdUpBO bo, Long userId) throws JdUpException {
        JdAuthedInfoVO authedInfo = jdAuthService.getAuthedInfo(userId);
        if (authedInfo == null) {
            throw new JdUpException("未获取到京东授权信息");
        }
        WareAddRequest request = BeanMapper.map(bo, WareAddRequest.class);
        request.setWarePackType("1");//普通商品
        WareAddResponse response;
        jdUtil.execute(request,authedInfo.getAccessToken());
        return null;
    }

    /**
     * 新增和修改商品图片
     */
    @Override
    public Boolean jdImageUpdate(JdImageUpdateBO bo, Long  userId) throws JdUpException {
        JdAuthedInfoVO authedInfo = jdAuthService.getAuthedInfo(userId);
        if (authedInfo == null) {
            throw new JdUpException("未获取到京东授权信息");
        }
        ImageWriteUpdateRequest request=new ImageWriteUpdateRequest();
        request.setColorId(bo.getColorId());
        request.setImgId(bo.getImgId());
        request.setImgIndex(bo.getImgIndex());
        request.setImgUrl(bo.getImgUrl());
        request.setImgZoneId(bo.getImgZoneId());
        request.setWareId(bo.getGoodsId());
        ImageWriteUpdateResponse response = jdUtil.execute(request, authedInfo.getAccessToken());
        return response.getSuccess();
    }

    @Override
    public Boolean goodsCanbeUploadedToJd(Long tbCid) {
        JdTbBind jdTbBind = new JdTbBind();
        jdTbBind.setTbCid(tbCid);
        jdTbBind = jdTbBindMapper.selectOne(jdTbBind);
        return jdTbBind != null;
    }
}
