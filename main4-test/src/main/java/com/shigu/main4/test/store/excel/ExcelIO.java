package com.shigu.main4.test.store.excel;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import jxl.write.biff.WritableFontRecord;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by wxc on 2017/2/9.
 *
 * Excel文件读写
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class ExcelIO {

    private static final Logger logger = Logger.getLogger(ExcelIO.class);


    /**
     * 从输入流读取Excel文件，并转化为指定returnType 的集合返回。
     * @param in 输入
     * @param returnType 指定的返回值类型
     * @param fieldConvertMap 指定类型 中 field 对应的列，并且给出数据转换方法，Key = fieldName, Value = Cell data convert to field type
     * @param <T> returnType泛型
     * @return 结果集合
     * @throws IOException 文件读写异常
     * @throws BiffException Excel解析异常
     */
    public static <T> List<T> read(InputStream in, Class<T> returnType, Map<String, ExcelColConvert> fieldConvertMap)
            throws IOException, BiffException {
        Workbook workbook = Workbook.getWorkbook(in);
        Sheet[] sheets = workbook.getSheets();
        //保证返回非NULL
        List<T> ts = new ArrayList<T>(0);
        if (sheets != null)
            for (Sheet sheet : sheets) {
                //列数
                int cols = sheet.getColumns();
                //验证文件列数
                if (cols > fieldConvertMap.size())
                    logger.warn("列转换器不足，某些列会被丢弃");
                //行数 以此遍历
                int rows = sheet.getRows();

                ts = new ArrayList<T>(rows);
                for (int i = 0; i < rows; i++) {
                    Cell[] row = sheet.getRow(i);
                    T t;
                    try {
                        t = returnType.newInstance();
                        for (Map.Entry<String, ExcelColConvert> entry : fieldConvertMap.entrySet()) {
                            Field field = returnType.getDeclaredField(entry.getKey());
                            ExcelColConvert convert = entry.getValue();
                            if (convert == null)
                                throw new RuntimeException(field.getName() + " has not convert.");
                            field.setAccessible(true);
                            field.set(t, convert.convert(row[convert.getIndex()], field.getType()));
                        }
                        ts.add(t);
                    } catch (Exception e) {
                        String errMsg = "第" + (i + 1) + "行错误：[";
                        for (Cell cell : row) {
                            errMsg += cell.getContents() + ", ";
                        }
                        logger.error(errMsg + "]", e);
                    }
                }
            }
        workbook.close();
        return ts;
    }

    /**
     *
     * @param outputStream 输出流
     * @param data 数据
     * @param fieldMapCol 数据映射列 配置
     * @param <T> 数据类型
     * @throws IOException 输出异常
     * @throws WriteException Excel写出异常
     */
    public static <T> void write(OutputStream outputStream, List<T> data, Map<String, ExcelCol> fieldMapCol) throws IOException, WriteException {
        WritableWorkbook workbook = Workbook.createWorkbook(outputStream);
        WritableSheet sheet = workbook.createSheet("Sheet1", 0);

        for (Map.Entry<String, ExcelCol> next : fieldMapCol.entrySet()) {
            ExcelCol value = next.getValue();
            sheet.addCell(new Label(value.getIndex(), 0, value.getColName(), getHead(-16)));
            sheet.setColumnView(value.getIndex(), value.getColWidth());
        }
        for (int i = 0; i < data.size(); i++) {
            T t = data.get(i);
            if (t == null)
                continue;
            Class<?> clazz = t.getClass();

            for (Map.Entry<String, ExcelCol> next : fieldMapCol.entrySet()) {
                String fieldName = next.getKey();
                ExcelCol col = next.getValue();
                try {
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    sheet.addCell(new Label(col.getIndex(), i + 1, col.value(field.get(t)), getHead(10)));
                } catch (Exception e) {
                    logger.error("写出异常  列：" + (col.getIndex() + 1) + ", 行：" + (i + 2) + ", 字段：" + fieldName, e);
                }
            }
        }
        workbook.write();
        workbook.close();
    }

    /**
     * 获取表格样式
     * @param size 小于0 的 ，字号取绝对值，字体加粗
     * @return 样式
     * @throws WriteException 异常
     */
    public static WritableCellFormat getHead(int size) throws WriteException {
        WritableFont.FontName fontName = WritableFont.createFont("Verdana");
        WritableFont font;
        if (size < 0)
            font = new WritableFont(fontName, -size, WritableFont.BOLD);
        else
            font = new WritableFont(fontName, size, WritableFont.NO_BOLD);
        WritableCellFormat format = new WritableCellFormat(font);
        format.setAlignment(jxl.format.Alignment.CENTRE);//左右居中
        format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//上下居中
        return format;
    }
}
