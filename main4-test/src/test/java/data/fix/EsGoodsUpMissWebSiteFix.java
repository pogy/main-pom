package data.fix;

import com.alibaba.fastjson.JSON;
import com.searchtool.configs.ElasticConfiguration;
import com.searchtool.domain.SimpleElaBean;
import com.searchtool.mappers.ElasticRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wxc on 2017/3/27.
 *
 *  修复商品上传记录中缺少webSite字段数据
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ac.xml")
public class EsGoodsUpMissWebSiteFix {

    @Test
    public void fixGoodsUp() {
        ElasticRepository repository = new ElasticRepository();
        SearchHits response;
        while ((
        response = ElasticConfiguration.searchClient
                .prepareSearch("shigugoodsup")
                .setQuery(QueryBuilders.missingQuery("webSite"))
                .setSize(3000).setFrom(0).execute().actionGet().getHits()).getTotalHits() != 0) {
            List<SimpleElaBean> sebs = new ArrayList<>();
            for (SearchHit hit : response.getHits()) {
                SimpleElaBean seb = new SimpleElaBean(hit.getIndex(), hit.getType(), hit.getId());
                sebs.add(seb);
                Map<String, Object> source = hit.getSource();
                source.put("webSite", hit.getType());
                seb.setSource(JSON.toJSONString(source));
            }
            repository.insertList(sebs, 50000);
        }

    }
}
