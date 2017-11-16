package com.shigu.main4.ucenter.vo;

/**
 * @类编号
 * @类名称：PriceDataGrid
 * @文件路径：com.shigu.main4.ucenter.vo.PriceDataGrid
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/3 19:01
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class PriceDataGrid {
    private String pPriceString;
    private ShiguGoodsTinyVO goods;
    private Boolean success;
    private String msg;

    public PriceDataGrid() {
    }

    public String getpPriceString() {
        return this.pPriceString;
    }

    public void setpPriceString(String pPriceString) {
        this.pPriceString = pPriceString;
    }

    public ShiguGoodsTinyVO getGoods () {
        return goods;
    }

    public void setGoods (ShiguGoodsTinyVO goods) {
        this.goods = goods;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
