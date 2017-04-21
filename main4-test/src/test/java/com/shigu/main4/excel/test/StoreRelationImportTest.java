package com.shigu.main4.excel.test;

import com.shigu.main4.exceptions.StoreException;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.test.store.StoreRelationExcelService;
import com.shigu.main4.vo.StoreRelation;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 把店铺联系方式信息导入
 * Created by zhaohongbo on 17/2/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/spring/store_test.xml" )
public class StoreRelationImportTest
{

    @Autowired
    StoreRelationExcelService excelService;

    @Autowired
    StoreRelationService storeRelationService;
    /**
     * 标记说明：
     被改动的字段：字体标红
     问题档口：黄色填充

     市场核实标准（我们的表格依据）：
     所有数据以旺旺为准，匹配手机，QQ，微信

     技术录入标准：
     1、当旺旺与店铺ID，档口号，有1项无法匹配，那么手机，QQ，微信这类信息暂时不进行录入，单独摘录出来，以表格形式发给我，再次进行核实。
     2、当旺旺与店铺ID，档口号完全匹配，那么手机，QQ，微信这类信息，以我的表格数据为准。
     * 更新店铺数据
     */
    @Test
    public void importData() throws IOException, BiffException, WriteException {
        List<StoreRelation> data=excelService.readStoreRelationExcel(getClass().getResourceAsStream("/real/店铺信息-核实版20170207.xls"));
        String webSite="hz";
        List<StoreRelation> exceptionData=new ArrayList<StoreRelation>();
        List<StoreRelation> unequalData=new ArrayList<StoreRelation>();
        List<StoreRelation> wwdata=new ArrayList<StoreRelation>();
        List<StoreRelation> storedata=new ArrayList<StoreRelation>();
        for(StoreRelation sr:data){
            //得到这个店铺老的联系方式
            StoreRelation oldsr=storeRelationService.selRelationById(sr.getStoreId(),webSite);
            if(oldsr==null){
                unequalData.add(sr);
                continue;
            }
            if(!isEqual(sr.getImWw(),oldsr.getImWw())){
                wwdata.add(sr);
                continue;
            }
            if(!isEqual(sr.getStoreNum(),oldsr.getStoreNum())){
                storedata.add(sr);
                continue;
            }
            //比较
                try {
                    storeRelationService.updateRelation(sr,webSite);
                } catch (Exception e) {
                    e.printStackTrace();
                    exceptionData.add(sr);
                }
        }
        System.out.println(exceptionData);
        System.out.println(unequalData);
        excelService.writeStoreRelationExcel(exceptionData, new FileOutputStream("/Users/zhaohongbo/Workspaces/idea-workspace8/main_site4.0/main4-test/src/test/resources/real/e1.xls"));
        excelService.writeStoreRelationExcel(unequalData, new FileOutputStream("/Users/zhaohongbo/Workspaces/idea-workspace8/main_site4.0/main4-test/src/test/resources/real/u1.xls"));
        excelService.writeStoreRelationExcel(wwdata, new FileOutputStream("/Users/zhaohongbo/Workspaces/idea-workspace8/main_site4.0/main4-test/src/test/resources/real/w1.xls"));
        excelService.writeStoreRelationExcel(storedata, new FileOutputStream("/Users/zhaohongbo/Workspaces/idea-workspace8/main_site4.0/main4-test/src/test/resources/real/s1.xls"));
    }

    private boolean isEqual(String s1,String s2){
        if(s1==null&&s2!=null){
            return false;
        }
        if(s1!=null&&s2==null){
            return false;
        }
        if(s1==null&&s2==null){
            return true;
        }
        return s1.equals(s2);
    }
}
