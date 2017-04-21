package com.shigu.main4.test.store.excel;

/**
 * Created by wxc on 2017/2/9.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class SimpleExcelCol extends ExcelCol {
    /**
     * @param index
     * @param colName
     */
    public SimpleExcelCol(int index, String colName) {
        super(index, colName);
    }

    public String value(Object object) {
        if (object != null)
            return object.toString();
        return null;
    }
}
