package com.shigu.main4.test.store.excel;

import jxl.Cell;

/**
 * Created by wxc on 2017/2/9.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public abstract class ExcelColConvert<T> {

    /**
     * Excel文件 列号， 从0开始
     */
    private int index;

    /**
     * Excel 列值处理器
     * @param index col index , start with 0
     */
    public ExcelColConvert(int index) {
        this.index = index;
    }

    /**
     * 处理
     * @param cell 该列某格
     * @param fieldType 转换类型
     * @return 返回值
     */
    public abstract T convert(Cell cell, Class<T> fieldType);

    public int getIndex() {
        return index;
    }
}
