package com.shigu.main4.store.test.wxc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.aliyun.opensearch.SearcherClient;
import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.aliyun.opensearch.sdk.generated.commons.OpenSearchClientException;
import com.aliyun.opensearch.sdk.generated.commons.OpenSearchException;
import com.aliyun.opensearch.sdk.generated.search.Config;
import com.aliyun.opensearch.sdk.generated.search.SearchFormat;
import com.aliyun.opensearch.sdk.generated.search.SearchParams;
import com.aliyun.opensearch.sdk.generated.search.general.SearchResult;
import com.aliyun.opensearch.search.SearchParamsBuilder;
import com.shigu.main4.store.test.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * 开放搜 测试
 * Created by bugzy on 2017/5/31 0031.
 */
public class OpenSearchServiceTest extends BaseSpringTest {

    @Autowired
    private SearcherClient searcherClient;

    @Test
    public void queryApi() throws OpenSearchClientException, OpenSearchException {
        Config config = new Config(Lists.newArrayList("search_shop"));
        config.setStart(0);
        config.setHits(10);
        config.setSearchFormat(SearchFormat.JSON);
        config.setFetchFields(Lists.newArrayList("shop_id", "market_id", "floor_id", "user_id", "shop_name", "web_site", "tb_nick", "shop_num", "shop_status", "market_name"));

        SearchResult searchResult = searcherClient.execute(SearchParamsBuilder.create(config).build().setQuery("shop_info:'100'"));
        System.out.println(searchResult.getResult());
    }
}
