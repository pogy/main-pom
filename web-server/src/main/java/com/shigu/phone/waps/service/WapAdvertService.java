package com.shigu.phone.waps.service;

import com.openJar.beans.app.AppImgBanner;
import com.openJar.beans.app.AppItemSpread;
import com.openJar.responses.app.ImgSpreadResponse;
import com.openJar.responses.app.ItemSpreadResponse;
import com.shigu.phone.waps.vo.ImgSpreadVO;
import com.shigu.phone.waps.vo.WapItemSpreadVo;
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
public class WapAdvertService {
    @Autowired
    SpreadService spreadService;

    /**
     * 图片式广告数据
     * @param spread
     * @return
     */
    public List<ImgSpreadVO> imgSpread(SpreadEnum spread){
        List<ImgBannerVO> imageGoat = spreadService.selImgBanners(spread).selReal();
        List<ImgSpreadVO> list = new ArrayList<>();
        imageGoat.stream().forEach(item->{
            ImgSpreadVO vo  = new ImgSpreadVO();
            vo.setHref(item.getHref());
            vo.setText(item.getText());
            vo.setImgsrc(item.getImgsrc());
            list.add(vo);
        });
        return list;
    }

    /**
     * 商品广告数据
     * @param webSite
     * @param spread
     * @return
     */
    public ItemSpreadResponse itemSpread(String webSite, SpreadEnum spread){
        List<ItemSpreadVO> itemGoat = spreadService.selItemSpreads(webSite,spread).selReal();
        List<WapItemSpreadVo> list=new ArrayList<>();
        itemGoat.stream().forEach(o->{
            new WapItemSpreadVo();
        });
        for(ItemSpreadVO item:itemGoat){
            AppItemSpread sp= BeanMapper.map(item,AppItemSpread.class);
            sp.setGoodsId(item.getId());





            sp.setTitle(item.getTitle());
//            spreads.add(sp);
        }
        ItemSpreadResponse response=new ItemSpreadResponse();
//        response.setSpreads(spreads);
        response.setSuccess(true);
        return response;
    }
}
