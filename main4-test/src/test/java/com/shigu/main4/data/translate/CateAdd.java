package com.shigu.main4.data.translate;

import com.opentae.data.mall.beans.SearchCategory;
import com.opentae.data.mall.beans.SearchCategorySub;
import com.opentae.data.mall.examples.SearchCategoryExample;
import com.opentae.data.mall.interfaces.SearchCategoryMapper;
import com.opentae.data.mall.interfaces.SearchCategorySubMapper;
import com.shigu.main4.common.util.BeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by wxc on 2017/4/7.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:ac.xml")
public class CateAdd {

    @Autowired
    private SearchCategoryMapper searchCategoryMapper;

    @Autowired
    private SearchCategorySubMapper searchCategorySubMapper;

    /**
     *
     7	2	电商基地	1087	1
     8	2	四季星座	621		2
     9	2	精品男装	613		3
     10	2	之江女装	608		4
     11	2	九天女装	1063	5
     12	2	新杭派	670		6
     13	2	置地国际	655		7
     14	2	钱塘大厦	617		8
     15	2	好四季	1462	9
     16	2	意法服饰	642		10
     17	2	淘款基地	619		11
     18	2	九天国际	661		12
     19	2	中纺服饰	668		13
     20	2	星座女装	601		14
     21	2	中星外贸	652		15
     22	2	四季青	666		16
     */
    public void addToSub() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Scanner scanner = new Scanner(System.in);
        SearchCategoryExample categoryExample = new SearchCategoryExample();
        List<SearchCategory> searchCategories = searchCategoryMapper.selectByExample(categoryExample);
        List<SearchCategory> cats = new ArrayList<>(6);
        for (Iterator<SearchCategory> iterator = searchCategories.iterator(); iterator.hasNext(); ) {
            SearchCategory searchCategory = iterator.next();
            if (searchCategory.getCategoryId() < 7) {
                cats.add(searchCategory);
                iterator.remove();
            }
        }
        for (SearchCategory cat : cats) {
            int i = 1;
            for (SearchCategory searchCategory : searchCategories) {
                System.out.println(cat.getCateName() + "] 类目：有【" + searchCategory.getCateName() + "】市场吗？有请扣1");
                if (1 != scanner.nextInt()) {
                    continue;
                }
                SearchCategorySub sub = new SearchCategorySub();
                sub.setParentCateValue(cat.getCateValue());
                sub.setCateName(searchCategory.getCateName());
                sub.setCateValue(searchCategory.getCateValue());
                sub.setSort(i++);
                sub.setType(2);
                searchCategorySubMapper.insertSelective(sub);
            }
        }
    }

    public void setSearchCategoryMapper(SearchCategoryMapper searchCategoryMapper) {
        this.searchCategoryMapper = searchCategoryMapper;
    }

    public void setSearchCategorySubMapper(SearchCategorySubMapper searchCategorySubMapper) {
        this.searchCategorySubMapper = searchCategorySubMapper;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        CateAdd cateAdd = new CateAdd();
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:ac.xml");
        cateAdd.setSearchCategoryMapper(ac.getBean(SearchCategoryMapper.class));
        cateAdd.setSearchCategorySubMapper(ac.getBean(SearchCategorySubMapper.class));
        cateAdd.addToSub();
    }
}
