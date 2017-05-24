package com.shigu.buyer.services;

import com.opentae.data.mall.beans.ShiguShopApply;
import com.opentae.data.mall.beans.TaobaoSessionMap;
import com.opentae.data.mall.interfaces.ShiguShopApplyMapper;
import com.opentae.data.mall.interfaces.TaobaoSessionMapMapper;
import com.shigu.component.common.taobao.TaobaoConfig;
import com.shigu.component.common.taobao.TaobaoOpenClient;
import com.shigu.exceptions.RuzhuException;
import com.taobao.api.ApiException;
import com.taobao.api.request.ShopGetRequest;
import com.taobao.api.response.ShopGetResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 店铺审核状态查询
 * Created by zhaohongbo on 17/3/3.
 */
@Service
public class ShopExamineTypeService {

    private static final Logger logger = LoggerFactory.getLogger(ShopExamineTypeService.class);
    @Autowired
    ShiguShopApplyMapper shiguShopApplyMapper;

    @Autowired
    TaobaoSessionMapMapper taobaoSessionMapMapper;
    /**
     * 审核资料是否齐全,true齐全,false不齐全
     * @return
     */
    public boolean canExamine(Long userId,Long ruzhuId) throws RuzhuException {
        ShiguShopApply shiguShopApply=shiguShopApplyMapper.selectByPrimaryKey(ruzhuId);
        if(shiguShopApply==null||!userId.equals(shiguShopApply.getUserId())||shiguShopApply.getCanExamine()==2){
            throw new RuzhuException("入驻信息不存在");
        }
        return shiguShopApply.getCanExamine()==1;
    }

    public void examineInfoComplement(Long applyId) {
        ShiguShopApply shiguShopApply = shiguShopApplyMapper.selectByPrimaryKey(applyId);
        if (shiguShopApply != null) {
            TaobaoSessionMap map = new TaobaoSessionMap();
            map.setNick(shiguShopApply.getTbNick());
            map.setAppkey(TaobaoConfig.appKey);
            TaobaoSessionMap taobaoSessionMap = taobaoSessionMapMapper.selectOne(map);
            if (taobaoSessionMap != null) {
                shiguShopApply.setTbuserId(taobaoSessionMap.getUserId().toString());
            }

            ShopGetRequest req = new ShopGetRequest();
            req.setFields("sid");
            req.setNick(shiguShopApply.getTbNick());
            try {
                ShopGetResponse response = TaobaoOpenClient.getTaobaoClient().execute(req);
                Long taobaoShopId = response.getShop().getSid();
                shiguShopApply.setTbshopId(taobaoShopId.toString());
                shiguShopApply.setTbUrl("http://shop" + taobaoShopId +".taobao.com");
            } catch (ApiException e) {
                logger.error("淘宝接口失败", e);
            }
            shiguShopApplyMapper.updateByPrimaryKeySelective(shiguShopApply);
        }
    }
}
