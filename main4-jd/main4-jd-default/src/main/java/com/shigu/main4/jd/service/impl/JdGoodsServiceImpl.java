package com.shigu.main4.jd.service.impl;

import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.request.ware.ImageReadFindImagesByColorRequest;
import com.jd.open.api.sdk.request.ware.ImageWriteUpdateRequest;
import com.jd.open.api.sdk.request.ware.WareAddRequest;
import com.jd.open.api.sdk.request.ware.WarePropimgAddRequest;
import com.jd.open.api.sdk.response.ware.ImageWriteUpdateResponse;
import com.jd.open.api.sdk.response.ware.WareAddResponse;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.jd.bo.JdImageUpdateBO;
import com.shigu.main4.jd.bo.JdUpBO;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdGoodsService;
import com.shigu.main4.jd.util.JdUtil;
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


    /**
     * 商品一键上传到京东
     * @param bo
     * @param accessToken
     * @throws JdException
     * @throws IOException
     */
    @Override
    public JdWareAddVO upToJd(JdUpBO bo, String accessToken) throws JdUpException {
        WareAddRequest request = BeanMapper.map(bo, WareAddRequest.class);
        request.setWarePackType("1");//普通商品
        WareAddResponse response;
        jdUtil.execute(request,accessToken);
        return null;
    }

    /**
     * 新增和修改商品图片
     */
    @Override
    public Boolean jdImageUpdate(JdImageUpdateBO bo, String accessToken) throws JdUpException {
        ImageWriteUpdateRequest request=new ImageWriteUpdateRequest();
        request.setColorId(bo.getColorId());
        request.setImgId(bo.getImgId());
        request.setImgIndex(bo.getImgIndex());
        request.setImgUrl(bo.getImgUrl());
        request.setImgZoneId(bo.getImgZoneId());
        request.setWareId(bo.getGoodsId());
        ImageWriteUpdateResponse response = jdUtil.execute(request, accessToken);
        return response.getSuccess();
    }
}
