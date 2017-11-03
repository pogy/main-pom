package com.shigu.seller.services;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.services.PackageImportGoodsDataService;
import com.shigu.main4.ucenter.vo.ShiguGoodsTinyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @类编号
 * @类名称：DataPackageImportService
 * @文件路径：com.shigu.seller.services.DataPackageImportService
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/3 20:01
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service
public class DataPackageImportService {
    @Autowired
    PackageImportGoodsDataService packageImportGoodsDataService;

    public List<ShiguGoodsTinyVO> importtempGoods(String packageUrl, Long storeId, String flag)throws Main4Exception{
      return  packageImportGoodsDataService.packageImporttempGoods (packageUrl,  storeId,  flag);
    }
}
