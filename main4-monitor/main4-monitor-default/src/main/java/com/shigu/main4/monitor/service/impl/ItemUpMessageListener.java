package com.shigu.main4.monitor.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.opentae.data.mall.beans.GoodsCountForsearch;
import com.opentae.data.mall.interfaces.GoodsCountForsearchMapper;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import org.elasticsearch.action.count.CountRequestBuilder;
import org.elasticsearch.action.count.CountResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品上传记录监听
 * Created by zhaohongbo on 17/6/24.
 */
@Service("itemUpMessageListener")
public class ItemUpMessageListener implements MessageListener {

    @Autowired
    GoodsCountForsearchMapper goodsCountForsearchMapper;

    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        ItemUpRecordVO itemUpRecordVO= JSON.parseObject(message.getBody(),ItemUpRecordVO.class);
        GoodsCountForsearch goodsCountForsearch=new GoodsCountForsearch();
        goodsCountForsearch.setGoodsId(itemUpRecordVO.getSupperGoodsId());
        goodsCountForsearch=goodsCountForsearchMapper.selectOne(goodsCountForsearch);
        if(goodsCountForsearch==null){
            goodsCountForsearch=new GoodsCountForsearch();
            goodsCountForsearch.setGoodsId(itemUpRecordVO.getSupperGoodsId());
            goodsCountForsearch.setUp(1L);
            goodsCountForsearch.setUpMan(1L);
            goodsCountForsearch.setWebSite(itemUpRecordVO.getWebSite());
            goodsCountForsearchMapper.insertSelective(goodsCountForsearch);
            return Action.CommitMessage;
        }
        //确定要不要加up_man
        CountRequestBuilder srb = ElasticConfiguration.searchClient.prepareCount("shigugoodsup");
        BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();
        boleanQueryBuilder.must(QueryBuilders.termQuery("supperGoodsId",itemUpRecordVO.getSupperGoodsId()));
        boleanQueryBuilder.must(QueryBuilders.termQuery("fenUserId",itemUpRecordVO.getFenUserId()));
        boleanQueryBuilder.must(QueryBuilders.rangeQuery("daiTime").lt(itemUpRecordVO.getDaiTime()));
        srb.setQuery(boleanQueryBuilder);
        CountResponse response = srb.execute().actionGet();
        long oldernum=response.getCount();
        GoodsCountForsearch goodsCountForsearchForUpdate=new GoodsCountForsearch();
        goodsCountForsearchForUpdate.setSearchId(goodsCountForsearch.getSearchId());
        goodsCountForsearchForUpdate.setUp(goodsCountForsearch.getUp()+1);
        goodsCountForsearchForUpdate.setUpMan(goodsCountForsearch.getUpMan()+(oldernum>0?0L:1L));
        goodsCountForsearchMapper.updateByPrimaryKeySelective(goodsCountForsearchForUpdate);
        return Action.CommitMessage;
    }
}
