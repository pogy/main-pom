package com.shigu.daifa.vo;

import java.util.List;

public class DaifaStockVO {
    private List<DaifaStockRecordVO> putInOutRecords;

    public List<DaifaStockRecordVO> getPutInOutRecords() {
        return this.putInOutRecords;
    }

    public void setPutInOutRecords(List<DaifaStockRecordVO> putInOutRecords) {
        this.putInOutRecords = putInOutRecords;
    }
}
