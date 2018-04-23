package com.shigu.main4.ucenter.services.impl;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.ucenter.services.PackageImportGoodsDataService;
import com.shigu.main4.ucenter.util.*;
import com.shigu.main4.ucenter.vo.ShiguGoodsTinyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @类编号
 * @类名称：PackageImportGoodsDataServiceImpl
 * @文件路径：com.shigu.main4.ucenter.services.impl.PackageImportGoodsDataServiceImpl
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/2 15:27
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service("packageImportGoodsDataServiceImpl")
public class PackageImportGoodsDataServiceImpl implements PackageImportGoodsDataService{

    @Resource
    ImportCsvFileService importCsvFileService;
    @Autowired
    OssIO oss;

    @Autowired
    private WorkerMan workerMan = WorkerMan.getInstance();
    /**
     * ====================================================================================
     * @方法名： packageImporttempGoods
     * @user gzy 2017/11/2 17:02
     * @功能：数据包转成商品临时数据
     * @param: packageUrl数据包地址
     * @param: userId用户ID
     * @param: storeId店铺ID
     * @param: storeNum店铺档口号
     * @param: flag是否为测试的标识 test/rest
     * @return: com.shigu.main4.ucenter.vo.ShiguGoodsTinyVO
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public List<ShiguGoodsTinyVO> packageImporttempGoods (String packageUrl, Long storeId,String flag) throws Main4Exception {
        PackageTask packageTask=new PackageTask(packageUrl,storeId,flag,importCsvFileService,oss);
        return workerMan.start(packageTask);
    }







}
