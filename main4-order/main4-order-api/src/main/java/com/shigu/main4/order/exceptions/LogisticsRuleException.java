package com.shigu.main4.order.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * 快递规则
 * Created by bugzy on 2017/7/20 0020.
 */
public class LogisticsRuleException extends Main4Exception {
    public LogisticsRuleException() {
    }

    public LogisticsRuleException(String message) {
        super(message);
    }
}
