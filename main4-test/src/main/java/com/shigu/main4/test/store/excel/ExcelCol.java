package com.shigu.main4.test.store.excel;

/**
 * Created by wxc on 2017/2/9.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public abstract class ExcelCol {

    private int index;

    private String colName;

    private int colWidth;


    public ExcelCol(int index, String colName) {
        this(index, colName, 20);
    }
    /**
     * 列属性初始化
     * @param index 列号， 从0开始
     * @param colName 列名字
     * @param colWidth 列宽, 默认20
     */
    public ExcelCol(int index, String colName, int colWidth) {
        this.index = index;
        this.colName = colName;
        this.colWidth = colWidth;
    }

    public abstract String value(Object object);

    public int getIndex() {
        return index;
    }

    public String getColName() {
        return colName;
    }

    public int getColWidth() {
        return colWidth;
    }
}
