package com.shigu.main4.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 简单数值计算辅助
 * Created by bugzy on 2017/7/20 0020.
 */
public class NumberUtils {

    public static <T extends Number> Integer sum(T... nums) {
        Integer n = 0;
        for (T num : nums) {
            n += num.intValue();
        }
        return n;
    }

    public static <T extends Number> Number sum(Collection<T> numbers) {
        Collection<Integer> integers = new ArrayList<>();
        for (T number : numbers) {
            integers.add(number.intValue());
        }
        return sum(integers.toArray(new Integer[numbers.size()]));
    }
}
