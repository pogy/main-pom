package com.shigu.main4.order.process;

/**
 * 订单服务
 */
public interface ItemOrderProcess {

    void finish(Long oid);

    /**
     * 缺货
     * @param soidpid
     */
    void outOfStock(Long soidpid);

    /**
     * 缺货后，重新拿到货
     * @param soidpid
     */
    void cancleOutOfStock(Long soidpid);

    /**
     * 回标运单号
     * @param nick
     * @param tid
     * @param companyCode
     * @param expressCode
     */
    void tbSend(String nick,Long tid,String companyCode,String expressCode);
}
