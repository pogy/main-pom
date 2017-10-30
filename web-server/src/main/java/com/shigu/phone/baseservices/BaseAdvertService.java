package com.shigu.phone.baseservices;

import com.openJar.beans.app.AppItemSpread;
import com.shigu.phone.api.enums.ImgFormatEnum;
import com.shigu.phone.apps.utils.ImgUtils;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.spread.services.SpreadService;
import com.shigu.spread.vo.ImgBannerVO;
import com.shigu.spread.vo.ItemSpreadVO;
import com.shigu.zhb.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.shigu.spread.enums.SpreadEnum.WOMAN_TJDK;

/**
 * Created by pc on 2017-08-29.
 *app 广告service
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class BaseAdvertService {
    @Autowired
    SpreadService spreadService;

    /**
     * 图片式广告数据
     * @param spread
     * @return
     */
    public List<ImgBannerVO> imgSpread(SpreadEnum spread){
        List<ImgBannerVO> imageGoat = spreadService.selImgBanners(spread).selReal();
        switch (spread){
            case HZ_APP_MAN_DT:case HZ_APP_WOMAN_DT:{
                imageGoat.forEach(appImgBanner -> {
                    appImgBanner.setImgsrc(ImgUtils.formatImg(appImgBanner.getImgsrc(), ImgFormatEnum.DT));
                });
                break;
            }
        }
        return imageGoat;
    }

    /**
     * 商品广告数据
     * @param webSite
     * @param spread
     * @return
     */
    public List<AppItemSpread> itemSpread(String webSite, SpreadEnum spread){
        List<ItemSpreadVO> itemGoat = spreadService.selItemSpreads(webSite,spread).selReal();
        List<AppItemSpread> spreads=new ArrayList<>();
        ImgFormatEnum format=null;
        switch (spread){
            case HZ_APP_MAN_TJDK:case HZ_APP_WOMAN_TJDK:{
                format=ImgFormatEnum.SHOP_TJ;
                break;
            }
            case HZ_APP_MAN_RM:case HZ_APP_WOMAN_RM:{
                format=ImgFormatEnum.GOODS_LIST;
                break;
            }
        }
        for(ItemSpreadVO item:itemGoat){
            AppItemSpread sp= BeanMapper.map(item,AppItemSpread.class);
            sp.setGoodsId(item.getId());
            sp.setTitle(item.getTitle());
            sp.setImgsrc(ImgUtils.formatImg(sp.getImgsrc(), format));
            spreads.add(sp);
        }
        return spreads;
    }
}
