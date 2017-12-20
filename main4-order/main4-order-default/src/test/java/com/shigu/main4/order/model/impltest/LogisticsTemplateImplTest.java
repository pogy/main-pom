package com.shigu.main4.order.model.impltest;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.model.LogisticsTemplate;
import com.shigu.main4.order.vo.LogisticsCompanyVO;
import com.shigu.main4.order.vo.PostVO;
import com.shigu.main4.tools.SpringBeanFactory;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Admin on 2017/7/19.
 */

public class LogisticsTemplateImplTest extends BaseTest{


    @Test
    public void getTemplateId() throws Exception {
    }

    @Test
    public void rules() throws Exception {
        LogisticsTemplate template = SpringBeanFactory.getBean(LogisticsTemplate.class, 6L);
//        template.rulesByProv(13L);
//        show(template.rules(5L, 3L));
//        show(template.rules(5L, null));
//        show(template.rules(null, 3L));
//        show(template.rules(null, null));
    }

    @Test
    public void testSenderTemplate() throws Exception {
        LogisticsTemplate template = SpringBeanFactory.getBean(LogisticsTemplate.class, 1L, null);
    }

    @Test
    public void templateInfo() throws Exception {
    }

    @Test
    public void calculate() throws Exception {
        LogisticsTemplate template = SpringBeanFactory.getBean(LogisticsTemplate.class, 6L);
//        show(template.calculate(5L, 3L, 5, 1000L));
        System.err.println((template.calculate(13L, 68L, 12, 1000L)));
    }

    @Test
    public void getPostListByProvId() throws Exception {
        LogisticsTemplate template = SpringBeanFactory.getBean(LogisticsTemplate.class, 4L);
//        show(template.calculate(5L, 3L, 5, 1000L));
//        List<PostVO> postListByProvId = template.getPostListByProvId(13L, -1L);
        List<PostVO> postListByProvId = template.getPostListByProvId(13L, 999999990L);
        postListByProvId.stream().forEach(item->{
            System.err.println(item.getName());
            System.err.println(item.getText());
        });
    }

}
