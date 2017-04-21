package com.shigu.main4.excel.test;

import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.test.store.StoreRelationExcelService;
import com.shigu.main4.vo.StoreRelation;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by wxc on 2017/2/9.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class StoreExcelTest {

    private static final Logger logger = Logger.getLogger(StoreExcelTest.class);

    private StoreRelationExcelService excelService;


    @Before
    public void init() {
        excelService = new StoreRelationExcelService();
    }

    @Test
    public void testRead() throws IOException, BiffException {
        List<StoreRelation> testDate = getTestDate();
        assertFalse("数据为空", testDate.isEmpty());
        for (StoreRelation storeRelation : testDate) {
            logger.info(storeRelation.toString());
        }
    }

    private List<StoreRelation> getTestDate() throws IOException, BiffException {
        return excelService.readStoreRelationExcel(getClass().getResourceAsStream("/店铺信息-核实版20170207.xls"));
    }

    @Test
    public void testWrite() throws IOException, BiffException, WriteException {
        List<StoreRelation> testDate = getTestDate();
        excelService.writeStoreRelationExcel(testDate, new FileOutputStream("/Users/zhaohongbo/Desktop/test/store.xls"));
    }



}
