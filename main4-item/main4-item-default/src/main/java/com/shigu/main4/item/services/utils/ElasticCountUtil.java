package com.shigu.main4.item.services.utils;

import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.GoodsCountForsearchExample;
import com.opentae.data.mall.examples.GoodsupNorealExample;
import com.opentae.data.mall.examples.ShiguGoodsModifiedExample;
import com.opentae.data.mall.examples.VirtualFlowExample;
import com.opentae.data.mall.interfaces.GoodsCountForsearchMapper;
import com.opentae.data.mall.interfaces.GoodsupNorealMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsModifiedMapper;
import com.opentae.data.mall.interfaces.VirtualFlowMapper;
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
 * <p>
 * Es 搜索引擎 聚合搜索公用方法工具箱
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@Service
public class ElasticCountUtil {

    private static final Logger logger = LoggerFactory.getLogger(ElasticCountUtil.class);

//    @Autowired
//    GoodsupNorealMapper goodsupNorealMapper;
    @Autowired
    VirtualFlowMapper virtualFlowMapper;

    @Autowired
    GoodsCountForsearchMapper goodsCountForsearchMapper;

    @Autowired
    ShiguGoodsModifiedMapper shiguGoodsModifiedMapper;




    /**
     * 统计 架上商品的一键上传数量
     *
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
            List<Long> goodsIdsList = new ArrayList<>(goodsIds);
            VirtualFlowExample example=new VirtualFlowExample();
            example.createCriteria().andGoodsIdIn(goodsIdsList);
            for (VirtualFlow v : virtualFlowMapper.selectByExample(example)) {
                Integer value = goodsupLongTerms.get(v.getGoodsId().toString());
                int count = v.getVirtualUploadNum().intValue() + (value == null ? 0 : value);
                goodsupLongTerms.put(v.getGoodsId().toString(), count);
            }
        }
        return goodsupLongTerms;
    }

    public GoodsupLongTerms<GoodsAggsVO> selItemCountData(List<Long> goodsIds) {
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
                goodsAggsVO.setStyleId(goodsCountForsearch.getStyleId());
                goodsAggsVO.setGoodsStyleName(goodsCountForsearch.getStyleName());
                // TODO: 18-1-23 兼容旧版，等新版风格上线后去掉goodsStyleId
                if (goodsCountForsearch.getSid() != null) {
                    goodsAggsVO.setGoodsStyleId(goodsCountForsearch.getSid().intValue());
                }

                itemResult.put(goodsCountForsearch.getGoodsId().toString(), goodsAggsVO);
            }
            VirtualFlowExample virtualFlowExample=new VirtualFlowExample();
            virtualFlowExample.createCriteria().andGoodsIdIn(goodsIds);
            for (VirtualFlow v : virtualFlowMapper.selectByExample(virtualFlowExample)) {
                GoodsAggsVO goodsAggsVO = itemResult.get(v.getGoodsId().toString());
                if (goodsAggsVO == null) {
                    goodsAggsVO = new GoodsAggsVO();
                    itemResult.put(v.getGoodsId().toString(), goodsAggsVO);
                }
                goodsAggsVO.addGoodsupNum(v.getVirtualUploadNum().intValue());
            }
            ShiguGoodsModifiedExample modifiedExample = new ShiguGoodsModifiedExample();
            modifiedExample.createCriteria().andItemIdIn(goodsIds);
            List<ShiguGoodsModified> shiguGoodsModifieds = shiguGoodsModifiedMapper.selectByExample(modifiedExample);
            for (ShiguGoodsModified shiguGoodsModified : shiguGoodsModifieds) {
                GoodsAggsVO goodsAggsVO = itemResult.get(shiguGoodsModified.getItemId().toString());
                if (goodsAggsVO == null) {
                    goodsAggsVO = new GoodsAggsVO();
                    itemResult.put(shiguGoodsModified.getItemId().toString(), goodsAggsVO);
                }
                goodsAggsVO.setHasRetailPriceSet(shiguGoodsModified.getHasSetPrice());
            }
        }
        return itemResult;
    }
}
