package com.shigu.main4.item.services.utils;

import com.opentae.data.mall.beans.GoodsCountForsearch;
import com.opentae.data.mall.beans.GoodsupNoreal;
import com.opentae.data.mall.beans.ShiguGoodsModified;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.GoodsCountForsearchExample;
import com.opentae.data.mall.examples.GoodsupNorealExample;
import com.opentae.data.mall.examples.ShiguGoodsModifiedExample;
import com.opentae.data.mall.interfaces.GoodsCountForsearchMapper;
import com.opentae.data.mall.interfaces.GoodsupNorealMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsModifiedMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.beans.GoodsupLongTerms;
import com.shigu.main4.item.vo.GoodsAggsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxc on 2017/3/13.
 *
 * Es 搜索引擎 聚合搜索公用方法工具箱
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@Service
public class ElasticCountUtil {

    private static final Logger logger = LoggerFactory.getLogger(ElasticCountUtil.class);

    @Autowired
    GoodsupNorealMapper goodsupNorealMapper;

    @Autowired
    GoodsCountForsearchMapper goodsCountForsearchMapper;

    @Autowired
    ShiguGoodsModifiedMapper shiguGoodsModifiedMapper;


    /**
     * 统计 架上商品的一键上传数量
     * @param tinies 商品集合
     * @return
     */
    public GoodsupLongTerms<Integer> countItemUp(List<ShiguGoodsTiny> tinies) {
        GoodsupLongTerms<Integer> goodsupLongTerms = new GoodsupLongTerms<Integer>();

        List<Long> goodsIds = new ArrayList<>(BeanMapper.getFieldSet(tinies, "goodsId", Long.class));
        if (!CollectionUtils.isEmpty(goodsIds)) {
            GoodsCountForsearchExample countForsearchExample = new GoodsCountForsearchExample();
            countForsearchExample.createCriteria().andGoodsIdIn(goodsIds);
            for (GoodsCountForsearch forsearch : goodsCountForsearchMapper.selectByExample(countForsearchExample)) {
                goodsupLongTerms.put(forsearch.getGoodsId().toString(), forsearch.getUp().intValue());
            }

            //把增量数据补上
            List<Long> goodsIdsList=new ArrayList<>(goodsIds);
            GoodsupNorealExample example=new GoodsupNorealExample();
            example.createCriteria().andItemIdIn(goodsIdsList);
            for (GoodsupNoreal gn : goodsupNorealMapper.selectByExample(example)) {
                Integer value = goodsupLongTerms.get(gn.getItemId().toString());
                int count = gn.getAddNum() + (value == null ? 0 : value);
                goodsupLongTerms.put(gn.getItemId().toString(),count);
            }
        }
        return goodsupLongTerms;
    }

    public GoodsupLongTerms<GoodsAggsVO> selItemCountData(List<Long> goodsIds){
        GoodsupLongTerms<GoodsAggsVO> itemResult = new GoodsupLongTerms<>();
        if (!CollectionUtils.isEmpty(goodsIds)) {
            GoodsCountForsearchExample example = new GoodsCountForsearchExample();
            example.createCriteria().andGoodsIdIn(goodsIds);
            for (GoodsCountForsearch goodsCountForsearch : goodsCountForsearchMapper.selectByExample(example)) {
                GoodsAggsVO goodsAggsVO = new GoodsAggsVO();
                goodsAggsVO.addGoodsupNum(goodsCountForsearch.getUp().intValue());
                goodsAggsVO.addSaleCount(goodsCountForsearch.getTrade().intValue());
                goodsAggsVO.setFabric(goodsCountForsearch.getFabric());
                goodsAggsVO.setInFabric(goodsCountForsearch.getInfabric());
                goodsAggsVO.setVideoUrl(goodsCountForsearch.getVideoUrl());
                itemResult.put(goodsCountForsearch.getGoodsId().toString(),goodsAggsVO);
            }
            GoodsupNorealExample norealExample = new GoodsupNorealExample();
            norealExample.createCriteria().andItemIdIn(goodsIds);
            for (GoodsupNoreal goodsupNoreal : goodsupNorealMapper.selectByExample(norealExample)) {
                GoodsAggsVO goodsAggsVO = itemResult.get(goodsupNoreal.getItemId().toString());
                if (goodsAggsVO == null) {
                    goodsAggsVO = new GoodsAggsVO();
                    itemResult.put(goodsupNoreal.getItemId().toString(),goodsAggsVO);
                }
                goodsAggsVO.addGoodsupNum(goodsupNoreal.getAddNum());
            }
            ShiguGoodsModifiedExample modifiedExample = new ShiguGoodsModifiedExample();
            modifiedExample.createCriteria().andItemIdIn(goodsIds);
            List<ShiguGoodsModified> shiguGoodsModifieds = shiguGoodsModifiedMapper.selectByExample(modifiedExample);
            for (ShiguGoodsModified shiguGoodsModified : shiguGoodsModifieds) {
                GoodsAggsVO goodsAggsVO = itemResult.get(shiguGoodsModified.getItemId().toString());
                if (goodsAggsVO == null) {
                    goodsAggsVO = new GoodsAggsVO();
                    itemResult.put(shiguGoodsModified.getItemId().toString(),goodsAggsVO);
                }
                goodsAggsVO.setHasRetailPriceSet(shiguGoodsModified.getHasSetPrice());
            }
        }
        return itemResult;
    }
}
