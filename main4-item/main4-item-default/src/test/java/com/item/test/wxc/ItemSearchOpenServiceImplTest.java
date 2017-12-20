package com.item.test.wxc;

import com.item.test.BaseSpringTest;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.item.services.ItemSearchService;
import com.shigu.main4.item.vo.ShiguAggsPager;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:main4/spring/item_test.xml"})
public class ItemSearchOpenServiceImplTest  extends BaseSpringTest {

    private static final Logger logger = LoggerFactory.getLogger(ItemSearchServiceImplTest.class);

    @Autowired
    private ItemSearchService itemSearchService;

    @Test
    public void search() throws Exception {
        Long[] stores = {35749L, 32861L, 16573L, 41603L, 35782L, 41836L, 29858L, 39959L, 40721L, 15908L, 40097L, 42538L, 39055L};
        Long[] cids = null;
        Date timeTo = null;
        Date timeFrom = null;
        String sid = "1";
        ShiguAggsPager pager = itemSearchService.searchItem("101", "hz",null, null, null, Arrays.asList(stores), sid,null, null, null, null, SearchOrderBy.GOODS_COMMON, 1, 5, true);
        show(pager);

    }


}
