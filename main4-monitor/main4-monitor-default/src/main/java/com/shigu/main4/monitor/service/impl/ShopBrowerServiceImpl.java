package com.shigu.main4.monitor.service.impl;

import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.monitor.enums.FlowType;
import com.shigu.main4.monitor.services.ShopBrowerService;
import com.shigu.main4.monitor.vo.DataLineVO;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramInterval;
import org.elasticsearch.search.aggregations.bucket.histogram.InternalHistogram;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.cardinality.InternalCardinality;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by wxc on 2017/3/13.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@Service("shopBrowerService")
public class ShopBrowerServiceImpl implements ShopBrowerService {
    /**
     * 按小时统计店铺流量
     *
     * @param start
     * @param number
     * @param type
     * @return
     */
    @Override
    public List<DataLineVO> selShopFlowByHour(Long shopId, Date start, Integer number, FlowType type) {
        return selShopFlowByRange(shopId, start, number, type, Calendar.HOUR);
    }

    public List<DataLineVO> selShopFlowByRange(Long shopId, Date start, Integer number, FlowType type, int field) {
        List<DataLineVO> shopFlows = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.add(field, number);
        Date end = calendar.getTime();
        for (Object o : getFlowFromEs(shopId, start, end, type).getBuckets()) {
            InternalHistogram.Bucket bucket = (InternalHistogram.Bucket) o;
            DateTime dateTime = (DateTime) bucket.getKey();
            DataLineVO vo = new DataLineVO();
            vo.setDatestr(dateTime.getMonthOfYear() + "-" + dateTime.getDayOfMonth());
            if (type == FlowType.PV) {
                vo.setHour(dateTime.getHourOfDay());
                vo.setFlow(((int) bucket.getDocCount()));
            } else {
                vo.setHour(23);
                InternalCardinality ip_count = bucket.getAggregations().get("ip_count");
                vo.setFlow(((int) ip_count.getValue()));
            }
            vo.setType(type);
            shopFlows.add(vo);
        }
        return shopFlows;
    }

    public InternalHistogram getFlowFromEs(Long shop, Date start, Date end, FlowType type) {
        String startTime = DateFormatUtils.format(start, "yyyy-MM-dd HH:mm:ss");
        String endTime = DateFormatUtils.format(end, "yyyy-MM-dd HH:mm:ss");
        SearchRequestBuilder builder = ElasticConfiguration.searchClient.prepareSearch("shigupagerecode")
                .setTypes("shop", "item")
                .setSearchType(SearchType.COUNT)
                .setQuery(
                        QueryBuilders.boolQuery()
                                .must(QueryBuilders.termQuery("shop", shop))
                                .filter(QueryBuilders.rangeQuery("inTime").gte(startTime).lt(endTime))
                );
        switch (type) {
            case PV:
                builder.addAggregation(AggregationBuilders.dateHistogram("flow").field("inTime").interval(DateHistogramInterval.HOUR).format("yyyy-MM-dd HH:mm:ss"));
                return builder.execute().actionGet().getAggregations().get("flow");
            case IP:
                SearchResponse response = builder
                        .addAggregation(AggregationBuilders.dateHistogram("flow").field("inTime").interval(DateHistogramInterval.DAY).format("yyyy-MM-dd HH:mm:ss")
                                .subAggregation(AggregationBuilders.cardinality("ip_count").field("clientMsg.clientIp")))
                        .execute().actionGet();
                return response.getAggregations().get("flow");
            default:
                return null;
        }
    }

    /**
     * 按天统计店铺流量
     *
     * @param start
     * @param number
     * @param type
     * @return
     */
    @Override
    public List<DataLineVO> selShopFlowByDay(Long shopId, Date start, Integer number, FlowType type) {
        return selShopFlowByRange(shopId, start, number, type, Calendar.DAY_OF_MONTH);
    }
}
