package com.shigu.main4.item.services;

import com.opentae.data.mall.beans.GoodsCountForsearch;
import com.opentae.data.mall.beans.GoodsFile;
import com.opentae.data.mall.examples.GoodsCountForsearchExample;
import com.opentae.data.mall.examples.GoodsFileExample;
import com.opentae.data.mall.interfaces.GoodsCountForsearchMapper;
import com.opentae.data.mall.interfaces.GoodsFileMapper;
import com.shigu.main4.item.tools.ItemCache;
import com.shigu.main4.tools.RedisIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 数据包关联
 * Created by zhaohongbo on 17/7/31.
 */
@Service("itemPicRelationService")
public class ItemPicRelationServiceImpl implements ItemPicRelationService{

    @Autowired
    GoodsFileMapper goodsFileMapper;

    @Autowired
    GoodsCountForsearchMapper goodsCountForsearchMapper;
    @Autowired
    ItemCache itemCache;

    @Autowired
    RedisIO redisIO;


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

    @Override
    public int updateBigPicWeight(Boolean hadBigPic, Long goodsId, String webSite) {
        GoodsCountForsearchExample countForsearchExample=new GoodsCountForsearchExample();
        countForsearchExample.createCriteria().andGoodsIdEqualTo(goodsId);
        GoodsCountForsearch countForsearch=new GoodsCountForsearch();
        countForsearch.setHadBigzip(hadBigPic?1:0);
        countForsearch.setWebSite(webSite);
        countForsearch.setGoodsId(goodsId);

        int u;
        try {
            u=goodsCountForsearchMapper.insertSelective(countForsearch);
        } catch (Exception e) {
            u=goodsCountForsearchMapper.updateByExampleSelective(countForsearch, countForsearchExample);
        }
        itemCache.cleanItemCache(goodsId);
        return u;
    }

    @Override
    public void updateFileOuter(Long goodsId,String webSite, String password, String link, Integer type) {
        GoodsFile goodsFile = new GoodsFile();
        goodsFile.setGoodsId(goodsId);
        goodsFileMapper.delete(goodsFile);
        goodsFile.setNeedPwd(password != null && !password.isEmpty());
        if (goodsFile.getNeedPwd()) {
            goodsFile.setPasswd(password);
        }
        goodsFile.setFileKey(link);
        goodsFile.setType(2);
        goodsFileMapper.insertSelective(goodsFile);
        updateBigPicWeight(true,goodsId,webSite);
    }


}
