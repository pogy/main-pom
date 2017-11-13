package com.shigu.main4.ucenter.services.test.sjb;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.services.impl.PackageImportGoodsDataServiceImpl;
import com.shigu.main4.ucenter.services.test.wxc.TestCase;
import com.shigu.main4.ucenter.vo.ShiguGoodsTinyVO;
import junit.runner.BaseTestRunner;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @类编号
 * @类名称：PackageImportGoodsDataServiceImplTest
 * @文件路径：com.shigu.main4.ucenter.services.test.sjb.PackageImportGoodsDataServiceImplTest
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/3 20:51
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class PackageImportGoodsDataServiceImplTest extends BaseTest{

    private static final Logger logger = LoggerFactory.getLogger(PackageImportGoodsDataServiceImplTest.class);

    @Autowired
    PackageImportGoodsDataServiceImpl packageImportGoodsDataServiceImpl;

    @Test
    public void packageImporttempGoods_test(){
        String packageUrl="/Users/gzy/Downloads/ffpic/555.zip";
        Long storeId=24806L;
        String flag="test";

        try {
            List<ShiguGoodsTinyVO> list= packageImportGoodsDataServiceImpl.packageImporttempGoods ( packageUrl,  storeId, flag);


            if(list.size ()>0){
                for(ShiguGoodsTinyVO goodsVO:list){

                    System.out.println("goodsId="+goodsVO.getGoodsId ()+"@@cname="+goodsVO.getCname ()+"@@OuterId="+goodsVO.getOuterId ()+"@@Title="+goodsVO.getTitle ()+"@@PiPrice="+goodsVO.getPiPriceString ());

                }

            }
        } catch (Main4Exception e) {
            e.printStackTrace ();
        }

    }

}
