package com.shigu.seller.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ActiveDrawGoods;
import com.opentae.data.mall.beans.GoodsFile;
import com.opentae.data.mall.examples.ActiveDrawGoodsExample;
import com.opentae.data.mall.examples.GoodsFileExample;
import com.opentae.data.mall.interfaces.GoodsFileMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.enums.ShopLicenseTypeEnum;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.storeservices.ShopLicenseService;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.seller.vo.GoodsFileVO;
import com.shigu.tools.Arith;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Autowired
    ShopLicenseService shopLicenseService;

    /**
     * 查店铺的容量支持
     * @param shopId
     * @return
     */
    public Long shopDataSize(Long shopId){
        shopLicenseService.selShopLIcenseByType(shopId, ShopLicenseTypeEnum.DATA_DEV);
        return null;
    }
    /**
     * g更加文件路径获取
     */
    public List<ItemShowBlock> selGoodsFileByFile( String fileKey) {
        GoodsFileExample goodsExample=new GoodsFileExample();
        goodsExample.createCriteria().andFileKeyEqualTo(fileKey);
        List<GoodsFile> goodsFiles = goodsFileMapper.selectByExample(goodsExample);

        List<ItemShowBlock> items = shopForCdnService.searchItemOnsale( BeanMapper.getFieldList(goodsFiles, "id", Long.class), "hz", 1, goodsFiles.size()).getContent();
        return items;
    }

    /**
     * 获取文件列表
     */
    public List<GoodsFileVO> selFilesByFileId( String fileKey,  String userId) {
        String homeDirZip = getHomeDir(userId) + "zip/";
        List<GoodsFileVO> files = BeanMapper.mapList(ossIO.getFileList(homeDirZip), GoodsFileVO.class);
        List<GoodsFileVO> newFiles = new ArrayList<GoodsFileVO>();
        GoodsFileVO lastItem = null;
        List<String> fileKeys=BeanMapper.getFieldList(files,"fileId",String.class);//文件ID
        List<String> hasConnected=new ArrayList<>();
        if(fileKeys.size()>0){
            GoodsFileExample goodsFileExample=new GoodsFileExample();
            goodsFileExample.createCriteria().andFileKeyIn(fileKeys);
            goodsFileExample.setDistinct(true);
            List<GoodsFile> gfiles=goodsFileMapper.selectFieldsByExample(goodsFileExample, FieldUtil.codeFields("file_key"));
            hasConnected=BeanMapper.getFieldList(gfiles,"fileKey",String.class);
        }
        for (GoodsFileVO item : files) {
            fileKeys.add(item.getFileId());
            item.setHasLinkGoods(hasConnected.contains(item.getFileId()));
            item.setFileId(item.getFileId().replace(homeDirZip,""));
            if(item.getFileId().equals("")){
                item.setIsRoot(true);
                item.setFileName("/");
            }
            if (lastItem != null && -1 <item.getFileId().indexOf(lastItem.getFileId())) {//过滤下层文件的显示
                continue;
            }
            if (!fileKey.equalsIgnoreCase(item.getFileId())) {
                lastItem = item;
            }

            if (item.getFileId().endsWith(".zip") || item.getFileId().endsWith(".7z") || item.getFileId().endsWith(".rar") ) {
                item.setFileType("picBkg");
            } else if(item.getFileId().endsWith("/")) {
                item.setFileType("folder");
            } else {
                item.setFileType("other");
            }

            double fileSize = Double.parseDouble(item.getFileSize());

            if (1048576 < fileSize) {
                double mSize = div(fileSize, (double)1048576, 3);
                item.setFileSize(mSize + "mb");
            } else {
                double kSize = div(fileSize, (double)1024, 3);
                item.setFileSize(kSize + "kb");
            }
            if ("folder".equalsIgnoreCase(item.getFileType())) {

            }
            newFiles.add(item);
         }

         return newFiles;
    }


    public  double div(double v1,double v2,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
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
    public boolean deleteFile(String fileKey, String fileType) {
        if (!fileKey.endsWith("/") && fileType.equalsIgnoreCase("folder") ) {
            fileKey = fileKey +"/";
        }
        return ossIO.deleteFile(fileKey);
    }

    /**
     * 重命名文件
     * @param fileKey
     * @param fileType
     * @param newName
     * @return
     */
    public boolean  rename(String fileKey, String fileType, String newName) {
        if (!fileKey.endsWith("/") && fileType.equalsIgnoreCase("folder") ) {
            fileKey = fileKey +"/";
        }
        if (!newName.endsWith("/") && fileType.equalsIgnoreCase("folder") ) {
            newName = newName +"/";
        }
        String[] items = fileKey.split("/");
        int len = items.length-1;
        String newPath =  fileKey.substring(0, fileKey.length()-items[len].length()-1) + newName;

        return ossIO.renameFile(fileKey, newPath);
    }

    /**
     * 移动文件
     * @param fileId
     * @param targetFileId
     * @return
     */
    public boolean moveFile(String fileId,  String targetFileId) {
        return ossIO.moveFile(fileId, targetFileId);
    }

    /**
     * 移动文件
     * @param parentDir
     * @param dir
     * @return
     */
    public String createDir(String parentDir, String dir) {
        return ossIO.createDir(parentDir, dir);
    }

    public double getSizeInfo(String filePath) {
        return div((double)ossIO.getSizeInfo(filePath), (double)1024*1024, 3);
    }

    public boolean fileExist(String filePath) {
        return ossIO.fileExist(filePath);
    }

    public String getHomeDir(String userId) {
        return ossIO.getDir() + userId + "/";
    }

}
