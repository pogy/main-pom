package com.shigu.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 *
 * Created by bugzy on 2017/8/1 0001.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ac.xml")
public class BaseSpringTest {

    protected static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    protected void show(Object o) {
        System.out.println();
        if (o instanceof Collection) {
            for (Object o1 : ((Collection) o)) {
                showOne(o1);
            }
        } else {
            showOne(o);
        }
        System.out.println();
    }

    private void showOne(Object o) {
        if (o == null) {
            return;
        }
        if (o instanceof Number || o instanceof String) {
            System.out.println(o);
        } else if (o instanceof Date) {
            System.out.println(sdf.format(o));
        } else {
            showField(o);
        }
    }

    private void showField(Object o) {
        for (Field field : o.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object o1 = field.get(o);
                if (o1 == null) {
                    continue;
                } else if (o1 instanceof Date) {
                    o1 = sdf.format(o1);
                }
                System.out.print(field.getName() + "=" + o1 + ",");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
