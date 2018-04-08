package com.shigu.daifa.vo;

import com.createExcel.confs.CellIndex;
import com.createExcel.confs.CellTitle;
import com.opentae.core.mybatis.config.Column;

public class WorkerOutStockExcelVO {

    @CellIndex("0")
    @CellTitle("市场")
    private Long marketId;

    @CellIndex("1")
    @CellTitle("档口")
    private String storeNum;

    @CellIndex("2")
    @CellTitle("商品货号")
    private String goodsNo;

    @CellIndex("3")
    @CellTitle("价格")
    private String pirice;

    @CellIndex("4")
    @CellTitle("颜色尺码")
    private String prop;

    @CellIndex("5")
    @CellTitle("备注")
    private String remark;

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getPirice() {
        return pirice;
    }

    public void setPirice(String pirice) {
        this.pirice = pirice;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
