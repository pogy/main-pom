package com.shigu.main4.test.store;

import com.shigu.main4.test.store.excel.*;
import com.shigu.main4.vo.StoreRelation;
import jxl.Cell;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wxc on 2017/2/9.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@Service
public class StoreRelationExcelService {

    /**
     * 店铺信息Excel读取
     * @param inputStream 输入
     * @return 返回店铺信息集合
     * @throws IOException 输入流异常
     * @throws BiffException 解析数据异常
     */
    public List<StoreRelation> readStoreRelationExcel(InputStream inputStream) throws IOException, BiffException {
        Map<String, ExcelColConvert> map = new HashMap<String, ExcelColConvert>();
        map.put("marketName", new SimpleExcelColConvert(0));
        map.put("floor", new SimpleExcelColConvert(1));
        map.put("storeNum", new SimpleExcelColConvert(2));
        map.put("storeId", new ExcelColConvert<Long>(3) {
            public Long convert(Cell cell, Class<Long> fieldType) {
                String contents = cell.getContents();
                int i = contents.indexOf("=");
                String storeId = contents.substring(i + 1);
                return Long.valueOf(storeId);
            }
        });
        map.put("telephone", new SimpleExcelColConvert(4));
        map.put("imQq", new SimpleExcelColConvert(5));
        map.put("imWw", new SimpleExcelColConvert(6));
        map.put("imWx", new SimpleExcelColConvert(7));
        return ExcelIO.read(inputStream, StoreRelation.class, map);
    }

    /**
     * 店铺信息写出Excel
     * @param excelData 数据
     * @param outputStream 输出
     * @throws IOException 输出流异常
     * @throws WriteException Excel写出异常
     */
    public void writeStoreRelationExcel(List<StoreRelation> excelData, OutputStream outputStream) throws IOException, WriteException {
        LinkedHashMap<String, ExcelCol> map = new LinkedHashMap<String, ExcelCol>();
        map.put("marketName", new SimpleExcelCol(0, "市场"));
        map.put("floor", new SimpleExcelCol(1, "楼层"));
        map.put("storeNum", new SimpleExcelCol(2, "档口号"));
        map.put("storeId", new ExcelCol(3, "店铺链接", 40) {
            public String value(Object object) {
                if (object != null)
                    return "http://hz.571xz.com/shop.htm?id=" + object;
                return null;
            }
        });
        map.put("telephone", new SimpleExcelCol(4, "手机号"));
        map.put("imQq", new SimpleExcelCol(5, "QQ"));
        map.put("imWw", new SimpleExcelCol(6, "旺旺"));
        map.put("imWx", new SimpleExcelCol(7, "微信"));
        ExcelIO.write(outputStream, excelData, map);
    }
}
