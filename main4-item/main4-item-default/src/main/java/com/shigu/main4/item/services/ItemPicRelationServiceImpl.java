package com.shigu.main4.item.services;

import com.opentae.data.mall.beans.GoodsFile;
import com.opentae.data.mall.examples.GoodsFileExample;
import com.opentae.data.mall.interfaces.GoodsFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 数据包关联
 * Created by zhaohongbo on 17/7/31.
 */
@Service
public class ItemPicRelationServiceImpl implements ItemPicRelationService{

    @Autowired
    GoodsFileMapper goodsFileMapper;

    @Override
    public boolean removeFileRelation(String fileId, Long goodsId) {
        GoodsFileExample example=new GoodsFileExample();
        example.createCriteria().andFileKeyEqualTo(fileId).andGoodsIdEqualTo(goodsId);
        return goodsFileMapper.deleteByExample(example)>0;
    }

    @Override
    public boolean removeFileRelation(String fileId, String fileType) {
        GoodsFileExample goodsFileExample=new GoodsFileExample();
        if(fileType.equals("folder")&&!fileId.equals("/")){//文件夹
            goodsFileExample.createCriteria().andFileKeyLike(fileId+"%");
        }else {
            goodsFileExample.createCriteria().andFileKeyEqualTo(fileId);
        }
        return goodsFileMapper.deleteByExample(goodsFileExample)>0;
    }

    @Override
    public void addFileRelation(Long goodsId, String fileId) {
        GoodsFile gf=new GoodsFile();
        gf.setFileKey(fileId);
        gf.setGoodsId(goodsId);
        goodsFileMapper.insertSelective(gf);
    }

    @Override
    public int updateFileRelation(String from, String to) {
        GoodsFileExample example=new GoodsFileExample();
        example.createCriteria().andFileKeyEqualTo(from);
        GoodsFile df=new GoodsFile();
        df.setFileKey(to);
        return goodsFileMapper.updateByExampleSelective(df,example);
    }

    @Override
    public int updateFileRelationByDir(String from, String to) {
        return goodsFileMapper.replaceFileDir(from,to);
    }

}
