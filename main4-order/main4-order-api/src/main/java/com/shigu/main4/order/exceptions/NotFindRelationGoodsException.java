package com.shigu.main4.order.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * Created by whx on 2017/6/20 0020.
 * 未找到关联的商品
 */
public class NotFindRelationGoodsException extends Main4Exception {
    public NotFindRelationGoodsException() {
    }

    public NotFindRelationGoodsException(String message) {
        super(message);
    }
}
