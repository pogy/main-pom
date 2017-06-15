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
    @Qualifier(value = "itemSearchService")
    private ItemSearchService itemSearchService;

    @Test
    public void search() throws Exception {
        Long[] stores = {35749L, 32861L, 16573L, 41603L, 35782L, 41836L, 29858L, 39959L, 40721L, 15908L, 40097L, 42538L, 39055L};
        Long[] cids = {123216004L, 162205L};
        Date timeTo = DateUtils.parseDate("2016-07-27 16:09:08", "yyyy-MM-dd HH:mm:ss");
        Date timeFrom = DateUtils.parseDate("2016-07-27 16:09:06", "yyyy-MM-dd HH:mm:ss");
        ShiguAggsPager pager = itemSearchService.searchItem("夏季", "hz", 601L, Arrays.asList(cids), Arrays.asList(stores), 180.00, 200.00, timeFrom, timeTo, SearchOrderBy.GOODS_COMMON, 1, 40, true);
        show(pager);
        assert pager.getContent().get(0).getItemId()==8934921L;
    }


}
