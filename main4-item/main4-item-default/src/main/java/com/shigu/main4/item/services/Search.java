package com.shigu.main4.item.services;

import com.searchtool.configs.ElasticConfiguration;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxc on 2017/4/7.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
public class Search {

    private SearchRequestBuilder searchRequestBuilder;

    private BoolQueryBuilder boolQueryBuilder;

    private List<SearchFilter> filters;

    private Search(String... indexes) {
        searchRequestBuilder = ElasticConfiguration.searchClient.prepareSearch(indexes);
        boolQueryBuilder = QueryBuilders.boolQuery();
        searchRequestBuilder.setQuery(boolQueryBuilder);
        filters = new ArrayList<>();
    }

    public static Search index(String... indexes) {
        return new Search(indexes);
    }

    public Search type(String... types) {
        searchRequestBuilder.setTypes(types);
        return this;
    }

    public Search formSize(Integer from, Integer size) {
        if (from != null) {
            searchRequestBuilder.setFrom(from);
        }
        if (size != null) {
            searchRequestBuilder.setSize(size);
        }
        return this;
    }

    public Search must(QueryBuilder queryBuilder) {
        boolQueryBuilder.must(queryBuilder);
        return this;
    }

    public Search should(QueryBuilder queryBuilder) {
        boolQueryBuilder.should(queryBuilder);
        return this;
    }

    public Search mustNot(QueryBuilder queryBuilder) {
        boolQueryBuilder.mustNot(queryBuilder);
        return this;
    }

    public Search sort(String field, SortOrder sortOrder) {
        searchRequestBuilder.addSort(field, sortOrder);
        return this;
    }

    public Search agg(AggregationBuilder aggregationBuilder) {
        searchRequestBuilder.addAggregation(aggregationBuilder);
        return this;
    }

    public Search heighLight(String pre, String post, String... fields) {
        searchRequestBuilder.setHighlighterPreTags(pre).setHighlighterPostTags(post);
        for (String field : fields) {
            searchRequestBuilder.addHighlightedField(field);
        }
        return this;
    }

    public SearchResponse go() {
        for (SearchFilter filter : filters) {
            filter.filter(searchRequestBuilder, boolQueryBuilder);
        }
        return searchRequestBuilder.execute().actionGet();
    }

    interface SearchFilter {
        void filter(SearchRequestBuilder searchRequestBuilder, BoolQueryBuilder boolQueryBuilder);
    }
}
