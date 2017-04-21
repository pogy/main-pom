package com.shigu.main4.data.translate;

import com.opentae.data.mall.beans.GoatField;
import com.opentae.data.mall.beans.GoatFieldValue;
import com.opentae.data.mall.beans.GoatItem;
import com.opentae.data.mall.beans.GoatLocation;
import com.opentae.data.mall.interfaces.*;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wxc on 2017/4/10.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
public class GoatAdd {
    private static ApplicationContext ac;

    private static GoatItemMapper goatItemMapper;

    private static GoatFieldMapper goatFieldMapper;

    private static GoatFieldValueMapper goatFieldValueMapper;

    private static GoatLocationMapper goatLocationMapper;

    private static GoatModelMapper goatModelMapper;

    static {
        ac = new ClassPathXmlApplicationContext("classpath:ac.xml");
        goatItemMapper = ac.getBean("tae_mall_goatItemMapper", GoatItemMapper.class);
        goatFieldMapper = ac.getBean("tae_mall_goatFieldMapper", GoatFieldMapper.class);
        goatFieldValueMapper = ac.getBean("tae_mall_goatFieldValueMapper", GoatFieldValueMapper.class);
        goatLocationMapper = ac.getBean("tae_mall_goatLocationMapper", GoatLocationMapper.class);
        goatModelMapper = ac.getBean("tae_mall_goatModelMapper", GoatModelMapper.class);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<GoatLocation> select = goatLocationMapper.select(new GoatLocation());
        for (GoatLocation goatLocation : select) {
            GoatField field = new GoatField();
            field.setLocationId(goatLocation.getLocalId());
            List<GoatField> fields = goatFieldMapper.select(field);
            String description = goatLocation.getDescription();

            GoatItem item = new GoatItem();
            item.setLocalId(goatLocation.getLocalId());
            List<GoatItem> items = goatItemMapper.select(item);
            System.out.println(description + "有" + items.size() + "个广告，还需要添加:");
            int add = scanner.nextInt();
            List<GoatItem> newItems = new ArrayList<>();
            for (int i = 0; i < add; i++) {
                GoatItem goatItem = new GoatItem();
                goatItem.setLocalId(goatLocation.getLocalId());
                goatItem.setDisEnabled(false);
                goatItem.setSort(0);
                goatItem.setStartTime(new Date());
                goatItem.setEndTime(DateUtils.addYears(new Date(), 1));
                goatItemMapper.insertSelective(goatItem);
                newItems.add(goatItem);
            }
            if (newItems.size() == 0)
                continue;

            System.out.println("是否修改这" + newItems.size() + "个广告信息？请扣1");

            if (scanner.nextInt() != 1) {
                continue;
            }

            for (int i = 0; i < newItems.size(); i++) {
                GoatItem goatItem = newItems.get(i);
                for (GoatField goatField : fields) {
                    System.out.println(description + "的第" + (i+1) + "条广告的" + goatField.getFieldName() + "字段值是：");
                    String s = scanner.next();
                    GoatFieldValue fieldValue = new GoatFieldValue();
                    fieldValue.setValue(s);
                    fieldValue.setFid(goatField.getFid());
                    fieldValue.setGoatId(goatItem.getGoatId());
                    goatFieldValueMapper.insertSelective(fieldValue);
                }
            }
        }
        scanner.close();
    }
}
