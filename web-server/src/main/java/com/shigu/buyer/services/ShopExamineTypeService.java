package com.shigu.buyer.services;

import com.opentae.data.mall.beans.ShiguShopApply;
import com.opentae.data.mall.interfaces.ShiguShopApplyMapper;
import com.shigu.exceptions.RuzhuException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 店铺审核状态查询
 * Created by zhaohongbo on 17/3/3.
 */
@Service
public class ShopExamineTypeService {
    @Autowired
    ShiguShopApplyMapper shiguShopApplyMapper;
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
}
