package com.shigu.main4.order.process;

import com.shigu.main4.order.bo.GoodsTaoRelationBO;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.vo.ItemProductVO;

/**
 * 商品产品处理对外接口
 * Created by bugzy on 2017/8/12 0012.
 */
public interface ItemProductProcess {

    /**
     * 获取/生成进货车产品信息
     * @param goodsId 商品id
     * @param color 颜色
     * @param size 尺码
     * @return 产品详细信息
     */
    ItemProductVO generateProduct(Long goodsId, String color, String size);

    /**
     * 淘宝商品关联
     * @param bo
     */
    void relationTaoGoods(GoodsTaoRelationBO bo);

    /**
     * 修改订单系统中的货号
     * @param goodsId
     * @param goodsNo
     */
    void updateGoodsNo(Long goodsId,String goodsNo) throws OrderException;
}
