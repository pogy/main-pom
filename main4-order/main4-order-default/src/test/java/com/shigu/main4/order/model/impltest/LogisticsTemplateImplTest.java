package com.shigu.main4.order.model.impltest;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.model.LogisticsTemplate;
import com.shigu.main4.order.vo.LogisticsCompanyVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Admin on 2017/7/19.
 */

public class LogisticsTemplateImplTest extends BaseTest{

    @Test
    public void provCompanys(){
        LogisticsTemplate template = SpringBeanFactory.getBean(LogisticsTemplate.class, 2L);
        List<LogisticsCompanyVO> voList = template.provCompanys(5L);
        for (LogisticsCompanyVO v:voList){
            System.out.println(v.getName());
        }
    }
}
