package com.shigu.main4.order.model.impl;

import com.opentae.data.mall.beans.ItemOrderSub;
import com.opentae.data.mall.beans.SubOrderSoidps;
import com.opentae.data.mall.examples.SubOrderSoidpsExample;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.opentae.data.mall.interfaces.SubOrderSoidpsMapper;
import com.shigu.main4.order.model.SoidsModel;
import com.shigu.main4.order.zfenums.SubOrderSoidpsEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 类名：SoidsModelImpl
 * 类路径：com.shigu.main4.order.model.impl.SoidsModelImpl
 * 创建者：王浩翔
 * 创建时间：2017-09-11 16:36
 * 项目：main-pom
 * 描述：
 */

@Service
@Scope("prototype")
public class SoidsModelImpl implements SoidsModel {


    @Autowired
    private SubOrderSoidpsMapper subOrderSoidpsMapper;

    @Autowired
    private ItemOrderSubMapper itemOrderSubMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void outOfStock(Long soidpid) {
        //更新拆单状态
        SubOrderSoidps subOrderSoidps = subOrderSoidpsMapper.selectByPrimaryKey(soidpid);
        subOrderSoidps.setStockStatus(SubOrderSoidpsEnum.OUT_OF_STOCK.getStatus());
        subOrderSoidpsMapper.updateByPrimaryKeySelective(subOrderSoidps);
        //更新子单状态
        SubOrderSoidpsExample subOrderSoidpsExample = new SubOrderSoidpsExample();
        subOrderSoidpsExample.createCriteria().andSoidEqualTo(subOrderSoidps.getSoid()).andStockStatusEqualTo(SubOrderSoidpsEnum.OUT_OF_STOCK.getStatus());
        int stockNum = subOrderSoidpsMapper.countByExample(subOrderSoidpsExample);
        ItemOrderSub itemOrderSub = itemOrderSubMapper.selectByPrimaryKey(subOrderSoidps.getSoid());
        itemOrderSub.setOutOfStok(stockNum);
        itemOrderSubMapper.updateByPrimaryKeySelective(itemOrderSub);
    }

    @Override
    public void havaTime(Long soidpid, String day) {
        SubOrderSoidps subOrderSoidps = subOrderSoidpsMapper.selectByPrimaryKey(soidpid);
        ItemOrderSub itemOrderSub = new ItemOrderSub();
        itemOrderSub.setSoid(subOrderSoidps.getSoid());
        itemOrderSub.setOutOfStokReason(day);
        itemOrderSubMapper.updateByPrimaryKeySelective(itemOrderSub);
    }

    @Override
    public void cancleOutOfStock(Long soidpid) {
        //更新拆单状态
        SubOrderSoidps subOrderSoidps = subOrderSoidpsMapper.selectByPrimaryKey(soidpid);
        subOrderSoidps.setStockStatus(SubOrderSoidpsEnum.DEFAULT_STATUS.status);
        subOrderSoidpsMapper.updateByPrimaryKeySelective(subOrderSoidps);
        //更新子单状态
        SubOrderSoidpsExample subOrderSoidpsExample = new SubOrderSoidpsExample();
        subOrderSoidpsExample.createCriteria().andSoidEqualTo(subOrderSoidps.getSoid()).andStockStatusEqualTo(SubOrderSoidpsEnum.OUT_OF_STOCK.getStatus());
        int stockNum = subOrderSoidpsMapper.countByExample(subOrderSoidpsExample);//查缺货量
        ItemOrderSub itemOrderSub = itemOrderSubMapper.selectByPrimaryKey(subOrderSoidps.getSoid());
        itemOrderSub.setOutOfStok(stockNum);
        if (stockNum == 0) {
            //没有缺货时，将有货时间置为空
            itemOrderSub.setOutOfStokReason(null);
            itemOrderSubMapper.updateByPrimaryKey(itemOrderSub);
            return;
        }
        itemOrderSubMapper.updateByPrimaryKeySelective(itemOrderSub);
    }

    @Override
    public void updateInStok(Long soidpid) {
        SubOrderSoidps subOrderSoidps = subOrderSoidpsMapper.selectByPrimaryKey(soidpid);
        subOrderSoidps.setStockStatus(SubOrderSoidpsEnum.ARRIVAL.status);
        subOrderSoidpsMapper.updateByPrimaryKeySelective(subOrderSoidps);
        SubOrderSoidpsExample subOrderSoidpsExample2 = new SubOrderSoidpsExample();
        subOrderSoidpsExample2.createCriteria().andSoidEqualTo(subOrderSoidps.getSoid()).andStockStatusEqualTo(SubOrderSoidpsEnum.ARRIVAL.getStatus());
        int inStock = subOrderSoidpsMapper.countByExample(subOrderSoidpsExample2);//拿到货量
        ItemOrderSub itemOrderSub = itemOrderSubMapper.selectByPrimaryKey(subOrderSoidps.getSoid());
        itemOrderSub.setInStok(inStock);
        itemOrderSubMapper.updateByPrimaryKeySelective(itemOrderSub);
    }

}
