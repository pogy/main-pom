package com.shigu.main4.ucenter.services.test.zjb;

import com.alibaba.fastjson.JSON;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.vo.DataPackage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据包生成
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/main4/spring/*" )
public class UserCollectServiceTest {

    @Autowired
    private UserCollectService userCollectService;

    /**
     * 创建数据包
     */
    @Test
    public void createPackage(){

        List<Long> itemIds = new ArrayList<Long>();
    /* *//*   itemIds.add(213445L);
        itemIds.add(165791L);
        itemIds.add(165843L);*/
        itemIds.add(169944L);

//        System.out.println(FilePathConstant.ITEM_COLLECT_PACKAGE_PATH_URL);
        userCollectService.createDataPackage(1000000808L, itemIds);
    }

    /**
     * 查询数据包
     */
    @Test
    public void selectPackage(){
        Long userId = 9968L;
        int pageNo = 1;
        int pageSize = 10;
        ShiguPager<DataPackage> dataPackageShiguPager =  userCollectService.selPackages(userId, pageNo, pageSize);
        System.out.println("正常显示数据：");
        System.out.println(JSON.toJSONString(dataPackageShiguPager));

        pageNo = 10;
        System.out.println("无数据显示：");
        dataPackageShiguPager =  userCollectService.selPackages(userId, pageNo, pageSize);
        System.out.println(JSON.toJSONString(dataPackageShiguPager));
    }

    /**
     * 删除数据包
     */
    @Test
    public void deletePackageIds(){
        List<Long> packageIds = new ArrayList<Long>();
        packageIds.add(99349L);
        Long userId = 1000000808L;
        System.out.println("正常删除数据：");
        userCollectService.delPackagesById(userId, packageIds);
        System.out.println("无法删除数据：");
        userCollectService.delPackagesById(32888L,packageIds);
    }

}
