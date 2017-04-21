package test.com.shigu.search.utils; 

import com.shigu.main4.vo.SearchShopSimple;
import com.shigu.search.utils.ShopWeightComparator;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** 
* ShopWeightComparator Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 12, 2017</pre> 
* @version 1.0 
*/ 
public class ShopWeightComparatorTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: compare(SearchShopSimple o1, SearchShopSimple o2) 
* 
*/ 
@Test
public void testCompare() throws Exception { 
//TODO: Test goes here...
    List<SearchShopSimple> list=new ArrayList<>();
    SearchShopSimple s1=new SearchShopSimple();
    s1.setMarketId(621L);
    SearchShopSimple s2=new SearchShopSimple();
    s2.setMarketId(1087L);
    SearchShopSimple s3=new SearchShopSimple();
    s3.setMarketId(652L);
    SearchShopSimple s4=new SearchShopSimple();
    s4.setMarketId(621L);
    SearchShopSimple s5=new SearchShopSimple();
    s5.setMarketId(617L);
    list.add(s1);
    list.add(s2);
    list.add(s3);
    list.add(s4);
    list.add(s5);
    Collections.sort(list,new ShopWeightComparator());
    System.out.println(list);
} 


} 
