package com.shigu.main4.order.process;

import com.shigu.main4.order.model.ItemProduct;
import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 对外接口实现
 * Created by bugzy on 2017/8/12 0012.
 */
@Component("itemProductProcess")
public class ItemProductProcessImpl implements ItemProductProcess {
    @Override
    public ItemProductVO generateProduct(Long goodsId, String color, String size) {
        return SpringBeanFactory.getBean(ItemProduct.class, goodsId, color, size).info();
    }
}
