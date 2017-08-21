package com.shigu.main4.order.process;

import com.opentae.data.mall.beans.ShiguGoodsTaoRelation;
import com.opentae.data.mall.examples.ShiguGoodsTaoRelationExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTaoRelationMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.GoodsTaoRelationBO;
import com.shigu.main4.order.model.ItemProduct;
import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 对外接口实现
 * Created by bugzy on 2017/8/12 0012.
 */
@Component("itemProductProcess")
public class ItemProductProcessImpl implements ItemProductProcess {
    @Autowired
    private ShiguGoodsTaoRelationMapper shiguGoodsTaoRelationMapper;

    @Override
    public ItemProductVO generateProduct(Long goodsId, String color, String size) {
        return SpringBeanFactory.getBean(ItemProduct.class, goodsId, color, size).info();
    }

    @Override
    public void relationTaoGoods(GoodsTaoRelationBO bo) {
        ShiguGoodsTaoRelation shiguGoodsTaoRelation= BeanMapper.map(bo,ShiguGoodsTaoRelation.class);
        try {
            shiguGoodsTaoRelationMapper.insertSelective(shiguGoodsTaoRelation);
        } catch (Exception e) {
            ShiguGoodsTaoRelationExample relationExample=new ShiguGoodsTaoRelationExample();
            relationExample.createCriteria().andNumIidEqualTo(shiguGoodsTaoRelation.getNumIid());
            shiguGoodsTaoRelationMapper.updateByExampleSelective(shiguGoodsTaoRelation,relationExample);
        }
    }
}
