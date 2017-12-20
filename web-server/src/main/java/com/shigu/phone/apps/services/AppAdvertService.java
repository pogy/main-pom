package com.shigu.phone.apps.services;

import com.openJar.beans.app.AppImgBanner;
import com.openJar.beans.app.AppItemSpread;
import com.openJar.responses.app.ImgSpreadResponse;
import com.openJar.responses.app.ItemSpreadResponse;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.phone.api.enums.ImgFormatEnum;
import com.shigu.phone.apps.utils.ImgUtils;
import com.shigu.phone.baseservices.BaseAdvertService;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.spread.services.SpreadService;
import com.shigu.spread.vo.ImgBannerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by pc on 2017-08-29.
 *app 广告service
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class AppAdvertService {
    @Autowired
    private BaseAdvertService baseAdvertService;

    /**
     * 图片式广告数据
     * @param spread
     * @return
     */
    public ImgSpreadResponse imgSpread(SpreadEnum spread){
        List<ImgBannerVO> imgBannerVOS = baseAdvertService.imgSpread(spread);
        List<AppImgBanner> spreads = BeanMapper.mapList(imgBannerVOS,AppImgBanner.class);
        ImgSpreadResponse response=new ImgSpreadResponse();
        response.setSpreads(spreads);
        response.setSuccess(true);
        return response;
    }

    /**
     * 商品广告数据
     * @param webSite
     * @param spread
     * @return
     */
    public ItemSpreadResponse itemSpread(String webSite, SpreadEnum spread){
        List<AppItemSpread> appItemSpreads = baseAdvertService.itemSpread(webSite, spread);
        ItemSpreadResponse response=new ItemSpreadResponse();
        response.setSpreads(appItemSpreads);
        response.setSuccess(true);
        return response;
    }
}
