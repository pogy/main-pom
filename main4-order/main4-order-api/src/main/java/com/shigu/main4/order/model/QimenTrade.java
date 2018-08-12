package com.shigu.main4.order.model;

import com.shigu.main4.common.exceptions.Main4Exception;

public interface QimenTrade {
    void toTransfer(String tid) throws Main4Exception;

    void toCheck(String tid) throws Main4Exception;

    void toNotify(String tid) throws Main4Exception;

    void toOut(String tid) throws Main4Exception;
}
