package com.shigu.phone.baseservices;

import com.openJar.exceptions.OpenException;
import com.opentae.data.mall.beans.ShiguGoodsCollect;
import com.opentae.data.mall.interfaces.ShiguGoodsCollectMapper;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.phone.api.enums.ImgFormatEnum;
import com.shigu.phone.apps.utils.ImgUtils;
import com.shigu.phone.basevo.BaseCollectItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pc on 2017-08-29.
 * app 店铺 service
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class BaseItemService {

    @Autowired
    private BasePhoneCdnService basePhoneCdnService;
    @Autowired
    private UserCollectService userCollectService;
    @Autowired
    private ShiguGoodsCollectMapper goodsCollectMapper;

    public BaseCollectItemVO selItemCollect(Long userId, Integer index, Integer size,String webSite) throws OpenException {
        BaseCollectItemVO vo=basePhoneCdnService.selItemCollect(userId,index, size,webSite);
        if (vo.getItems() != null &&  !vo.getItems().isEmpty()) {
            vo.getItems().forEach(appGoodsBlock -> {
                appGoodsBlock.setImgsrc(ImgUtils.formatImg(appGoodsBlock.getImgsrc(),ImgFormatEnum.GOODS_LIST));
            });
        }
        return vo;

    }

    public Boolean delItemCollect(List<Long> collectIds,Long userId){
        try {

            basePhoneCdnService.delItemCollect(userId,collectIds);
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }

    }

    public boolean addItemCollect(Long userId, Long storeId, Long goodsId, String webSite ){
        return basePhoneCdnService.addItemCollect(userId,storeId,goodsId,webSite);
    }

    public Long hasCollected(Long goodsId, Long userId){
        ShiguGoodsCollect shiguGoodsCollect = new ShiguGoodsCollect();
        shiguGoodsCollect.setGoodsId(goodsId);
        shiguGoodsCollect.setUserId(userId);
        shiguGoodsCollect = goodsCollectMapper.selectOne(shiguGoodsCollect);
        if (shiguGoodsCollect == null) {
          return null;
        }
        return shiguGoodsCollect.getGoodsCollectId();
    }
}
