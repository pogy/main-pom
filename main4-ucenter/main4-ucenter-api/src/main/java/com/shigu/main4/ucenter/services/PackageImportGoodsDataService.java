package com.shigu.main4.ucenter.services;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.vo.ShiguGoodsTinyVO;

import java.util.List;

/**
 * @类编号
 * @类名称：PackageImportGoodsDataService
 * @文件路径：com.shigu.main4.ucenter.services.PackageImportGoodsDataService
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/2 15:14
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */

public interface PackageImportGoodsDataService {
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
    List<ShiguGoodsTinyVO> packageImporttempGoods(String packageUrl, Long storeId, String flag) throws Main4Exception;
}
