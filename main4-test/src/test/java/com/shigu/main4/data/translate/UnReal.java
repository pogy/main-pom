package com.shigu.main4.data.translate;

import com.opentae.data.mall.beans.GoatField;
import com.opentae.data.mall.beans.GoatFieldValue;
import com.opentae.data.mall.beans.GoatLocation;
import com.opentae.data.mall.beans.GoodsupNoreal;
import com.opentae.data.mall.examples.GoatFieldExample;
import com.opentae.data.mall.examples.GoatFieldValueExample;
import com.opentae.data.mall.examples.GoatLocationExample;
import com.opentae.data.mall.examples.GoodsupNorealExample;
import com.opentae.data.mall.interfaces.GoatFieldMapper;
import com.opentae.data.mall.interfaces.GoatFieldValueMapper;
import com.opentae.data.mall.interfaces.GoatLocationMapper;
import com.opentae.data.mall.interfaces.GoodsupNorealMapper;
import com.searchtool.configs.ElasticConfiguration;
import org.apache.lucene.index.Term;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxc on 2017/4/10.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ac.xml")
public class UnReal {

    @Autowired
    private GoodsupNorealMapper goodsupNorealMapper;

    @Autowired
    GoatFieldMapper goatFieldMapper;

    @Autowired
    GoatFieldValueMapper goatFieldValueMapper;

    @Autowired
    GoatLocationMapper goatLocationMapper;


    @Test
    public void sync() {
        GoatLocationExample locationExample=new GoatLocationExample();
        locationExample.createCriteria().andLocalCodeLike("MAN-%");
        List<GoatLocation> locations=goatLocationMapper.selectByExample(locationExample);
        List<Long> manIds=new ArrayList<>();
        for(GoatLocation gl:locations){
            manIds.add(gl.getLocalId());
        }
        GoatFieldExample fieldExample=new GoatFieldExample();
        fieldExample.createCriteria().andFieldNameEqualTo("goods_id").andLocationIdIn(manIds);
        List<GoatField> fields=goatFieldMapper.selectByExample(fieldExample);
        List<Long> fids=new ArrayList<>();
        for(GoatField field:fields){
            fids.add(field.getFid());
        }
        GoatFieldValueExample fieldValueExample=new GoatFieldValueExample();
        fieldValueExample.createCriteria().andFidIn(fids);
        List<GoatFieldValue> fieldValues=goatFieldValueMapper.selectByExample(fieldValueExample);

        List<Long> goodsIds=new ArrayList<>();
        for(GoatFieldValue g:fieldValues){
            goodsIds.add(Long.valueOf(g.getValue()));
        }
        SearchResponse response = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup")
                .setSearchType(SearchType.COUNT)
//                .setQuery(QueryBuilders.termsQuery("supperGoodsId", new long[]{8334659L, 9920368L, 20182225L, 20140119L, 20193147L, 20073935L, 9978407L, 20068260L, 20181209L, 20194127L, 20137028L, 20142140L, 20178834L, 20033950L, 20144287L, 20127485L, 20138947L, 9851318L, 20178752L, 20194057L, 20194094L, 20001700L, 20194092L, 9882035L, 20082747L, 20046322L, 20194103L, 20107838L, 20108559L, 20142147L, 20156485L, 20156483L, 20178796L, 9880372L, 20182439L, 20138946L, 20178737L, 20187778L, 20078500L, 20095632L, 9978406L, 20053850L, 20187817L, 20165263L, 9873566L, 20078499L, 20142154L, 20139232L, 20130561L, 20181599L, 20181487L, 20130580L, 9905784L, 9948160L, 20193989L, 20002024L, 9905797L, 10004967L, 9978405L, 9978399L, 9978414L, 20189159L, 20141199L, 20187008L, 20175928L, 20124459L, 20187411L, 20057329L, 9796828L, 20019511L, 20165048L, 20058024L, 9943127L, 20065556L, 9939552L, 20131449}))
//                .setQuery(QueryBuilders.termsQuery("supperGoodsId", new long[]{20136945,20194127,20140119,20073520,20095632,20068260,20181209,20130561,20091634,20033950,20214944,20001700,20138947,20182225,20194187,20178895,20195541,20142196,20208007,20137380,20202263,20187783,20152280,20156485,20129544,20178620,20138458,20161521,20147907,20136893,20156126,20186401,20183296,20140210,20217372,20130851,20171892,20141301,9980077,20216411,20197733,20165505,20187204,20206821,20191722,20068181,20076619,20206858,20060621,20018101,9953281,10016518,20120100,9953253,20071245,10020123,9960780,20135661,20128063,20165073,20058214,20011439,20178834,20145069,20101581,20194515,20194855,9978407,20142140,20165263}))
                .setQuery(QueryBuilders.termsQuery("supperGoodsId", goodsIds))
                .addAggregation(AggregationBuilders.terms("supperGoodsId_count").field("supperGoodsId").size(100)).execute().actionGet();

        LongTerms count = response.getAggregations().get("supperGoodsId_count");
        for (Terms.Bucket bucket : count.getBuckets()) {
            GoodsupNoreal noreal = new GoodsupNoreal();
            noreal.setRealNum((int) bucket.getDocCount());
            noreal.setActiveNum(12);
            GoodsupNorealExample goodsupNorealExample = new GoodsupNorealExample();
            goodsupNorealExample.createCriteria().andItemIdEqualTo((long) bucket.getKeyAsNumber());
            if (goodsupNorealMapper.countByExample(goodsupNorealExample) == 0) {
                noreal.setItemId((long) bucket.getKeyAsNumber());
                goodsupNorealMapper.insertSelective(noreal);
            } else {
                goodsupNorealMapper.updateByExampleSelective(noreal, goodsupNorealExample);
            }
            System.out.println(bucket.getKey() + ": " + bucket.getDocCount());
        }

    }
}
