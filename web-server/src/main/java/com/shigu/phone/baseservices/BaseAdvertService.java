package com.shigu.phone.baseservices;

import com.openJar.beans.app.AppItemSpread;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.spread.services.SpreadService;
import com.shigu.spread.vo.ImgBannerVO;
import com.shigu.spread.vo.ItemSpreadVO;
import com.shigu.zhb.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        for(ItemSpreadVO item:itemGoat){
            AppItemSpread sp= BeanMapper.map(item,AppItemSpread.class);
            sp.setGoodsId(item.getId());
            sp.setTitle(item.getTitle());
            spreads.add(sp);
        }
        return spreads;
    }
}
