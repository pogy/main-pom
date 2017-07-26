package com.shigu.seller.services;

import com.opentae.data.mall.beans.ActiveDrawGoods;
import com.opentae.data.mall.beans.GoodsFile;
import com.opentae.data.mall.examples.ActiveDrawGoodsExample;
import com.opentae.data.mall.examples.GoodsFileExample;
import com.opentae.data.mall.interfaces.GoodsFileMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.seller.vo.GoodsFileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品文件关联类
 * Created by zlm on 2017/7/25.
 */
@Service
public class GoodsFileService {
    @Autowired
    GoodsFileMapper goodsFileMapper;

    @Autowired
    ShopForCdnService shopForCdnService;

    @Autowired
    OssIO ossIO;

    /**
     * g更加文件路径获取
     */
    public List<ItemShowBlock> selGoodsFileByFile( String fileKey) {
        GoodsFileExample goodsExample=new GoodsFileExample();
        goodsExample.createCriteria().andFileKeyEqualTo(fileKey);
        List<GoodsFile> goodsFiles = goodsFileMapper.selectByExample(goodsExample);

        List<ItemShowBlock> items = shopForCdnService.searchItemOnsale( BeanMapper.getFieldList(goodsFiles, "goodsId", Long.class), "hz", 1, goodsFiles.size()).getContent();
        return items;
    }

    /**
     * 更加goodsId获取
     * @param goodsId
     * @return
     */
    public GoodsFile selGoodsFileByGoodsId(Long goodsId) {
        GoodsFile goodsFile = new GoodsFile();
        goodsFile.setGoodsId(goodsId);
        goodsFile = (GoodsFile) goodsFileMapper.selectOne(goodsFile);
        return goodsFile;
    }

    /**
     * 增加关联关系
     * @param fileKey
     * @param goodsId
     * @return
     */
    public int  saveGoodsFile(String fileKey, Long goodsId) {
        GoodsFile goodsFile = new GoodsFile();
        goodsFile.setGoodsId(goodsId);
        goodsFile.setFileKey(fileKey);
        return goodsFileMapper.insert(goodsFile);
    }

    /**
     * 取消关联关系
     * @param goodsId
     * @return
     */
    public int delGoodsfile(Long goodsId) {
        GoodsFile goodsFile = new GoodsFile();
        goodsFile.setGoodsId(goodsId);
        return goodsFileMapper.delete(goodsFile);
    }

    /**
     * 删除文件
     * @param fileKey
     *  @param fileType
     * @return
     */
    public void deleteFile(String fileKey, String fileType) {
        if (!fileKey.endsWith("/") && fileType.equalsIgnoreCase("1") ) {
            fileKey = fileKey +"/";
        }
        ossIO.deleteFile(fileKey);
    }

    /**
     * 重命名文件
     * @param fileKey
     * @param fileType
     * @param newName
     * @return
     */
    public void rename(String fileKey, String fileType, String newName) {
        if (!fileKey.endsWith("/") && fileType.equalsIgnoreCase("1") ) {
            fileKey = fileKey +"/";
        }
        if (!newName.endsWith("/") && fileType.equalsIgnoreCase("1") ) {
            newName = newName +"/";
        }
        String[] items = fileKey.split("/");
        int len = items.length-1;
        String newPath =  fileKey.substring(0, fileKey.length()-items[len].length()-1) + newName;

        ossIO.renameFile(fileKey, newPath);
    }

    /**
     * 移动文件
     * @param fileId
     * @param targetFileId
     * @return
     */
    public void moveFile(String fileId,  String targetFileId) {
        ossIO.moveFile(fileId, targetFileId);
    }

}
