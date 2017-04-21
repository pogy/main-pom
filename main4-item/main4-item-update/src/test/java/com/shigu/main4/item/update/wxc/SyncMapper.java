package com.shigu.main4.item.update.wxc;

import com.opentae.data.mall.beans.ShiguPropImgs;
import com.shigu.main4.item.exceptions.ItemAddException;
import com.shigu.main4.item.vo.SynItem;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxc on 2017/3/1.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class SyncMapper {

    @Test
    public void testMapp() {
        Class clazz = SynItem.class;
        Class<ShiguPropImgs> tinyClass = ShiguPropImgs.class;
        List<String> fields = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            fields.add(field.getName());
        }
        List<String> tinyField = new ArrayList<>();
        for (Field field : tinyClass.getDeclaredFields()) {
            tinyField.add(field.getName());
        }
        fields.retainAll(tinyField);
        for (String field : fields) {
            System.out.println(tinyClass.getSimpleName() + "." + field + "-->" + clazz.getSimpleName() + "." + field);
        }
    }

    @Test
    public void testExceptio() throws ItemAddException {
        throw new ItemAddException(ItemAddException.ItemAddExceptionEnum.ITEM_ALREADY_EXIST, null);
    }
}
