package com.shigu.main4.data.translate;

import com.opentae.data.mall.beans.ShiguPageRecode;
import com.opentae.data.mall.examples.ShiguPageRecodeExample;
import com.opentae.data.mall.interfaces.ShiguPageRecodeMapper;
import com.searchtool.domain.SimpleElaBean;
import com.searchtool.mappers.ElasticRepository;
import com.shigu.main4.monitor.vo.BrowerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxc on 2017/3/13.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:ac.xml")
public class PageRecoreTrans {

    @Autowired
    private ShiguPageRecodeMapper shiguPageRecodeMapper;

    /**
     * {@link com.shigu.main4.monitor.test.ShiguPageRecodeTest.addEs}
     */
    @Test
    public void trans() {
        int step = 5000;

        ShiguPageRecodeExample recodeExample = new ShiguPageRecodeExample();
        recodeExample.setEndIndex(step);
        int start = 0;
        int count = shiguPageRecodeMapper.countByExample(recodeExample);
        while (start < count) {
            List<ShiguPageRecode> shiguPageRecodes = shiguPageRecodeMapper.selectByConditionList(recodeExample);
            for (ShiguPageRecode shiguPageRecode : shiguPageRecodes) {
                BrowerRecord browerRecord = new BrowerRecord();

            }
            start += step;
        }
        ElasticRepository repository = new ElasticRepository();
        List<SimpleElaBean> sebs = new ArrayList<>();
        repository.insertList(sebs, 100);
    }
}
