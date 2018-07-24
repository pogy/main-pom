package com.item.test.wxc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opentae.data.mall.beans.ESGoods;
import com.shigu.main4.item.vo.SearchItem;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wxc on 2017/3/2.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class TestCase {

    private static final Logger logger = LoggerFactory.getLogger(TestCase.class);
    @Test
    public void testSameField() {
        Class target = SearchItem.class;
        Class source = ESGoods.class;
        Map<String, String> map = new HashMap<>();
        List<String> unknow = new ArrayList<>();
        for (Field tf : target.getDeclaredFields()) {
            if (tf.getModifiers() != 2)
                continue;
            String typeEqual = "";
            for (Field sf : source.getDeclaredFields()) {
                if (tf.getName().equals(sf.getName())) {
                    typeEqual = "名称相同， ";
                    if (tf.getType() == sf.getType()) {
                        typeEqual += "类型相同";
                    }
                    break;
                }
            }
            if (typeEqual.equals("")) {
                unknow.add(tf.getName() + "没有找到");
            } else {
                map.put(tf.getName(), typeEqual);
            }
        }
        for (String s : unknow) {
            System.out.println(s);
        }
    }

    @Test
    public void testEs() {
        ESGoods esGoods = new ESGoods();
        esGoods.setGoodsId(53L);
        System.out.println(JSON.toJSONString(esGoods, SerializerFeature.PrettyFormat));
    }

}
