package com.shigu.main4.item.services.utils;

import com.opentae.core.mybatis.SgExample;
import com.shigu.main4.common.tools.ShiguPager;
import org.springframework.stereotype.Service;

/**
 * Created by zhaohongbo on 17/3/9.
 */
@Service
public class SelIOItemsUtil {

    public  <E> ShiguPager<E> selIOItems(OnsaleInstockReader<E> reader, int pageNo, int pageSize) {
        if (pageNo < 1)
            pageNo = 1;
        if (pageSize < 1)
            pageSize = 10;

        ShiguPager<E> pager = new ShiguPager<>();
        pager.setNumber(pageNo);

        SgExample example = reader.makeExample(reader.getWebSite(), pageNo, pageSize);
        int count = reader.countByExample(example);
        pager.calPages(count, pageSize);
        if (count > 0) {
            pager.setContent(reader.selectByExample(example));
        }
        return pager;
    }



}
