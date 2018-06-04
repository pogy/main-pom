package com.shigu.order.services;

import com.opentae.data.mall.beans.ShiguOrderCashback;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ShiguOrderCashbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.order.services
 * @ClassName: OrderReturnMoneyService
 * @Author: sy
 * @CreateDate: 2018/5/25 0025 17:43
 */
@Service
public class OrderReturnMoneyService {

    @Autowired
    private ShiguOrderCashbackMapper shiguOrderCashbackMapper;
    @Autowired
    private ItemOrderMapper itemOrderMapper;

    public ShiguOrderCashback getOrderCashback(Long oid){
        ShiguOrderCashback shiguOrderCashback = new ShiguOrderCashback();
        shiguOrderCashback.setOId(oid);
        List<ShiguOrderCashback> shiguOrderCashbacks = shiguOrderCashbackMapper.select(shiguOrderCashback);
        if (shiguOrderCashbacks==null || shiguOrderCashbacks.size()<=0){
            return null;
        }
        return shiguOrderCashbacks.get(0);
    }

    public Long getUserId(Long oid){
        return itemOrderMapper.selectUserIdByOid(oid);
    }

    public Boolean updateCashback(ShiguOrderCashback cashback){
        Integer b = shiguOrderCashbackMapper.updateCashback(cashback);
        if (b == null || b <= 0)
            return false;
        return true;
    }
}
