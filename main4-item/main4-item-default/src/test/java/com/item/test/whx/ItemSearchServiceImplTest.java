package com.item.test.whx;

import com.item.test.BaseSpringTest;
import com.shigu.main4.item.enums.SearchCheckd;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.item.services.ItemSearchService;
import com.shigu.main4.item.vo.ShiguAggsPager;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by whx on 2017/6/14
 *
 * @author whx
 */
public class ItemSearchServiceImplTest extends BaseSpringTest {

    private static final Logger logger = LoggerFactory.getLogger(com.item.test.wxc.ItemSearchServiceImplTest.class);

    private List<Long> ids;
    {
        ids = new ArrayList<Long>();
        ids.add(20632658L);
        ids.add(3158464L);
    }
    @Autowired
    private ItemSearchService itemSearchService;

    @Test
    public void searchItemByIdsCorrect() {
        show(itemSearchService.searchItemByIds(ids,"hz",1,50));
    }

    @Test
    public void searchItemByIdsWithNullIds() {
        show(itemSearchService.searchItemByIds(null,"hz",2,50));
    }

    @Test
    public void searchItemByIdsWithNullIdsList() {
        show(itemSearchService.searchItemByIds(new ArrayList<Long>(),"hz",2,50));
    }

    @Test
    public void searchItemByIdsWithRepeatIds() {
        ids.add(new Long(20632658L));
        ids.add(new Long(3158464L));
        show(itemSearchService.searchItemByIds(ids, "hz", 1,10));
    }

    @Test
    public void searchItemByIdsWithNullWebSite() {
        show(itemSearchService.searchItemByIds(ids, null, 1,50));
    }

    @Test
    public void searchItemByIdsWithErrorWebSite() {
        show(itemSearchService.searchItemByIds(ids, "gs", 1,50));
    }

    @Test
    public void searchItemByIdsWithErrorPage() {
        show(itemSearchService.searchItemByIds(ids,"hz",-1,50));
    }

    @Test
    public void searchItemByIdsWithErrorPageSize() {
        show(itemSearchService.searchItemByIds(ids,"hz",10,-5));
    }


    @Test
     public void  searchItem_test(){
            List<Long> shouldStoreIds =new ArrayList<> ();
            shouldStoreIds.add (24806L);

            show(itemSearchService.searchItem(null,"hz",null,null,null,shouldStoreIds,null,null,null,null,null,SearchOrderBy.NEW,1,50,true));
        }


    }
