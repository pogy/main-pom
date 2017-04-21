package com.shigu.main4.spread.service;

import com.shigu.main4.spread.exceptions.GoatException;
import com.shigu.main4.spread.vo.GoatALocation;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by Licca on 17/4/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/store_test.xml")
public class GoatGetServiceTest {

    @Autowired
    GoatGetService goatGetService;
    @Test
    public void test() throws GoatException, IOException, TemplateException {
        GoatALocation location=goatGetService.getAlocation("MAN-RM");
        System.out.println(location.getLocalId());
        GoatALocation location1=goatGetService.getLocationData("MAN-DT");
        System.out.println(location1.getItems().get(0).parseToHTML());
    }
}
