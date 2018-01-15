package com.shigu.main4.spread.service;

/**
 * 类名：VoucherService
 * 类路径：com.shigu.main4.spread.service.VoucherService
 * 创建者：王浩翔
 * 创建时间：2017-11-17 16:06
 * 项目：main-pom
 * 描述：代金券活动
 */
public interface VoucherService {

    void obtainVoucher(Long userId, Integer uploadNum, Long pemId);

}
