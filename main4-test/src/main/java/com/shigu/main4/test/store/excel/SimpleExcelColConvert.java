package com.shigu.main4.test.store.excel;

import jxl.Cell;

/**
 * Created by wxc on 2017/2/9.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class SimpleExcelColConvert extends ExcelColConvert {
    /**
     * Excel 列值处理器
     *
     * @param index col index , start with 0
     */
    public SimpleExcelColConvert(int index) {
        super(index);
    }

    /**
     * 处理
     *
     * @param cell      该列某格
     * @param fieldType 转换类型
     *
     * @return 返回值
     */
    public Object convert(Cell cell, Class fieldType) {
        Object value = null;
        String contents = cell.getContents();
        if (String.class.equals(fieldType))
            value = contents;
        else if (Long.TYPE.equals(fieldType))
            value = Long.valueOf(contents);
        else if (Integer.TYPE.equals(fieldType))
            value = Integer.valueOf(contents);
        else if (Double.TYPE.equals(fieldType))
            value = Double.valueOf(contents);
        else if (Float.TYPE.equals(fieldType))
            value = Float.valueOf(contents);
        else if (Boolean.TYPE.equals(fieldType))
            value = Boolean.valueOf(contents);
        else if (Short.TYPE.equals(fieldType))
            value = Short.valueOf(contents);
        else if (Byte.TYPE.equals(fieldType))
            value = Byte.valueOf(contents);
        else if (Character.TYPE.equals(fieldType))
            value = contents.charAt(0);
        return value;
    }
}
