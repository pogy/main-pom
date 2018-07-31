package com.item.test.wxc;

import com.item.test.BaseSpringTest;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.item.services.ItemSearchService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Arrays;

/**
 * Created by wxc on 2017/4/4.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
public class ItemSearchServiceImplTest extends BaseSpringTest {

    private static final Logger logger = LoggerFactory.getLogger(ItemSearchServiceImplTest.class);

    @Autowired
    @Qualifier(value = "itemSearchService")
    private ItemSearchService itemSearchService;

    @Test
    public void search() throws Exception {
        Long[] stores = {35749L, 32861L, 16573L, 41603L, 35782L, 41836L, 29858L, 39959L, 40721L, 15908L, 40097L, 42538L, 39055L};
        show(itemSearchService.searchItem("实拍 大货主推】2017年新款蕾丝连衣裙 Q015F65", "hz",null, null, null, Arrays.asList(stores), null,null, null, null, null, SearchOrderBy.GOODS_COMMON, 1, 40, true));
    }

    @Test
    public void searchAggs() throws Exception {
//        show(itemSearchService.aggsCatsAndMarket("款", "hz",601L,null, null, null, null, null));
    }

    @Test
    public void selCategory() throws Exception {
        show(itemSearchService.selCategory(SearchCategory.CATEGORY,"hz"));
    }

    @Test
    public void selSubCategoryBy() throws Exception {
        show(itemSearchService.selSubCategory("man", SearchCategory.CATEGORY,"hz"));
    }


}