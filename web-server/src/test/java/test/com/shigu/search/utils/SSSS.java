package test.com.shigu.search.utils;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ItemOrderExample;
import com.opentae.data.mall.examples.ItemOrderSubExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.*;
import com.searchtool.configs.ElasticConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/main4/spring/estest.xml")
public class SSSS {
    static List<String> sites = Arrays.asList("hz", "www", "so");
    static String url1 = "http://%s.571xz.com/shop.htm?id=%d";
    static String url2 = "http://%s.571xz.com";
    static String url3 = "http://%s.571xz.com/";
    static String url4 = "http://%s.571xz.com/%d";
    @Autowired
    ShiguShopMapper shiguShopMapper;
    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Autowired
    ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;
    @Autowired
    ItemOrderMapper itemOrderMapper;
    @Autowired
    ItemOrderSubMapper itemOrderSubMapper;

    @Test
    public void v() {
        ShiguShop s = new ShiguShop();
        s.setMarketId(1462L);
        s.setShopStatus(0);
        List<ShiguShop> shops = shiguShopMapper.select(s);
        for (ShiguShop shop : shops) {
            SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigupagerecode");
            List<String> urls = sites.stream().map(host -> {
                List<String> us = new ArrayList<>();
                us.add(String.format(url1, host, shop.getShopId()));
                if (StringUtils.isNotBlank(shop.getDomain())) {
                    us.add(String.format(url2, shop.getDomain()));
                    us.add(String.format(url3, shop.getDomain()));
                }
                if (!"www".equals(host)) {
                    us.add(String.format(url4, host, shop.getShopId()));
                }
                return us;
            }).flatMap(Collection::stream).collect(Collectors.toList());

            QueryBuilder itemQb = QueryBuilders.termsQuery("url", urls);
            srb.setQuery(itemQb);
            srb.setSize(0);
            SearchResponse response = srb.execute().actionGet();

            ShiguGoodsTinyExample shiguGoodsTinyExample = new ShiguGoodsTinyExample();
            shiguGoodsTinyExample.createCriteria().andStoreIdEqualTo(shop.getShopId());
            shiguGoodsTinyExample.setWebSite("hz");
            List<Long> itemIds = shiguGoodsTinyMapper
                    .selectFieldsByExample(shiguGoodsTinyExample, FieldUtil.codeFields("goods_id"))
                    .stream().map(ShiguGoodsTiny::getGoodsId).collect(Collectors.toList());

            List<Long> sitemIds = shiguGoodsSoldoutMapper
                    .selectFieldsByExample(shiguGoodsTinyExample, FieldUtil.codeFields("goods_id"))
                    .stream().map(ShiguGoodsSoldout::getGoodsId).collect(Collectors.toList());




            List<List<Long>> lists = splitList(itemIds, 1024);
            List<List<Long>> slists = splitList(sitemIds, 1024);
            Integer lll = lists.stream().mapToInt(value -> selLllTotalNum(value).intValue()).sum();
            Integer slll=slists.stream().mapToInt(value -> selLllTotalNum(value).intValue()).sum();

            Integer img = lists.stream().mapToInt(value -> selSclTotalNum(value, "imgzip").intValue()).sum();
            Integer simg = slists.stream().mapToInt(value -> selSclTotalNum(value, "imgzip").intValue()).sum();

            Integer up = lists.stream().mapToInt(value -> selSclTotalNum(value, null).intValue()).sum();
            Integer sup = slists.stream().mapToInt(value -> selSclTotalNum(value, null).intValue()).sum();

            ItemOrderSubExample itemOrderSubExample = new ItemOrderSubExample();
            itemOrderSubExample.createCriteria().andShopIdEqualTo(shop.getShopId());
            List<ItemOrderSub> subs = itemOrderSubMapper
                    .selectFieldsByExample(itemOrderSubExample, FieldUtil.codeFields("soid,oid,num"));
            Integer onum = 0;
            ;
            if (subs.size() > 0) {
                Map<Long, Integer> oidNumSum = subs.stream()
                        .collect(Collectors
                                .groupingBy(ItemOrderSub::getOid, Collectors.summingInt(ItemOrderSub::getNum)));
                ItemOrderExample itemOrderExample = new ItemOrderExample();
                itemOrderExample.createCriteria().andOidIn(new ArrayList<>(oidNumSum.keySet()))
                        .andOrderStatusNotIn(Arrays.asList(1, 5));
                List<Long> oids = itemOrderMapper.selectFieldsByExample(itemOrderExample, FieldUtil.codeFields("oid"))
                        .stream().map(ItemOrder::getOid).collect(Collectors.toList());
                if (oids.size() > 0) {
                    onum = oids.stream().mapToInt(oidNumSum::get).sum();
                }
            }

            System.out.println(
                    shop.getShopId()
                            + "\t" + shop.getShopNum()
                            + "\t" + response.getHits().getTotalHits()
                            + "\t" + itemIds.size()
                            + "\t" + onum
                            + "\t" + lll
                            + "\t" + up
                            + "\t" + img
                            + "\t" + sitemIds.size()
                            + "\t" + slll
                            + "\t" + sup
                            + "\t" + simg);

        }

    }

    private static List<List<Long>> splitList(List<Long> itemIds, Integer maxNum) {
        int y = itemIds.size() % maxNum;
        int n = itemIds.size() / maxNum;
        return Stream.iterate(0, t -> t + 1).limit(y > 0 ? (n + 1) : n).parallel()
                .map(integer -> itemIds.stream().skip(integer * maxNum).limit(maxNum).parallel()
                        .collect(Collectors.toList())).collect(Collectors.toList());
    }

    private Long selLllTotalNum(List<Long> itemIds) {
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigupagerecode");
        srb.setTypes("item");
        QueryBuilder itemQb = QueryBuilders.termsQuery("itemId", itemIds);
        srb.setQuery(itemQb);
        srb.setSize(0);
        SearchResponse response = srb.execute().actionGet();
        return response.getHits().totalHits();
    }

    private Long selSclTotalNum(List<Long> itemIds, String flag) {
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
        BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();
        QueryBuilder itemQb = QueryBuilders.termsQuery("supperGoodsId", itemIds);
        boleanQueryBuilder.must(itemQb);
        if (flag != null) {
            boleanQueryBuilder.must(QueryBuilders.termQuery("flag", flag));
        }
        srb.setQuery(boleanQueryBuilder);
        srb.setSize(0);
        SearchResponse response = srb.execute().actionGet();
        return response.getHits().totalHits();
    }
}
