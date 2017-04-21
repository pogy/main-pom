package com.shigu.main4.item.services.utils;

import com.opentae.data.mall.beans.GoodsupNoreal;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.GoodsupNorealExample;
import com.opentae.data.mall.interfaces.GoodsupNorealMapper;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.beans.GoodsupLongTerms;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    /**
     * 统计 架上商品的一键上传数量
     * @param tinies 商品集合
     * @return
     */
    public GoodsupLongTerms countItemUp(List<ShiguGoodsTiny> tinies) {
        LongTerms terms = null;
        Set<Long> goodsIds = null;
        try {
            goodsIds = BeanMapper.getFieldSet(tinies, "goodsId", Long.TYPE);
        } catch (Exception e) {
            logger.warn("统计上传数异常", e);
        }
        if (!CollectionUtils.isEmpty(goodsIds)) {
            SearchRequestBuilder prepareSearch = ElasticConfiguration.client.prepareSearch("shigugoodsup");
            SearchResponse response
                    = prepareSearch.setSearchType("count")
                    .setQuery(QueryBuilders.termsQuery("supperGoodsId", goodsIds))
                    .addAggregation(AggregationBuilders.terms("up_count").field("supperGoodsId"))
                    .execute().actionGet();
            terms = response.getAggregations().get("up_count");
        }
        GoodsupLongTerms goodsupLongTerms=new GoodsupLongTerms();
        //把增量数据补上
        if(terms!=null){
            List<Long> goodsIdsList=new ArrayList<>(goodsIds);
            GoodsupNorealExample example=new GoodsupNorealExample();
            example.createCriteria().andItemIdIn(goodsIdsList);
            List<GoodsupNoreal> reals=goodsupNorealMapper.selectByExample(example);
            for(GoodsupNoreal gn:reals){
                goodsupLongTerms.put(gn.getItemId().toString(),gn.getAddNum());
            }
            //数据包装
            List<Terms.Bucket> buckets=terms.getBuckets();
            for(Terms.Bucket b:buckets){
                Integer addNum=goodsupLongTerms.get(b.getKey().toString());
                int docCount=(int)b.getDocCount();
                int count=addNum==null?docCount:(addNum+docCount);
                goodsupLongTerms.put(b.getKey().toString(),count);
            }
        }
        return goodsupLongTerms;
    }
}
