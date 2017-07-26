package com.shigu.seller.services;

import com.opentae.data.mall.beans.ActiveDrawGoods;
import com.opentae.data.mall.beans.GoodsFile;
import com.opentae.data.mall.examples.ActiveDrawGoodsExample;
import com.opentae.data.mall.examples.GoodsFileExample;
import com.opentae.data.mall.interfaces.GoodsFileMapper;
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

    /**
     * g更加文件路径获取
     */
    public List<GoodsFile> selGoodsFileByFile( String fileKey) {
        GoodsFileExample goodsExample=new GoodsFileExample();
        goodsExample.createCriteria().andFileKeyEqualTo(fileKey);
        List<GoodsFile> goodsFiles = goodsFileMapper.selectByExample(goodsExample);
        return goodsFiles;
    }

    /**
     * 更加goodsId获取
     * @param goodsId
     * @return
     */
    public GoodsFile selGoodsFileByFile(Long goodsId) {
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
}
