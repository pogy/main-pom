package com.shigu.main4.daifa.process;


import com.shigu.main4.daifa.vo.PackResultVO;

/**
 * 打包发货
 * Created by zhaohongbo on 17/8/8.
 */
public interface PackDeliveryProcess {
    /**
     * 单件发货扫货
     *
     * @param subOrderId
     */
    PackResultVO packSubOrder(Long subOrderId);
}
