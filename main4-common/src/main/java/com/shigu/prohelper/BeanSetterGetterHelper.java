package com.shigu.prohelper;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Modifier;
import java.util.stream.Stream;

/**
 * 编程帮助
 * Created by bugzy on 2017/7/26 0026.
 */
public class BeanSetterGetterHelper {

//    public static void generateGetter(Class clazz) {
//        generateGetterSetter(clazz, true);
//    }
//    public static void generateSetter(Class clazz) {
//        generateGetterSetter(clazz, false);
//    }
//    public static void generateGetterSetter(Class clazz, boolean getOrSet) {
//        Stream.iterate(clazz, aClass -> {
//            if (aClass == null) {
//                return null;
//            }
//            return aClass.getSuperclass();
//        }).limit(10)
//                .filter(c -> c != null && c != Object.class)
//                .map(Class::getDeclaredFields)
//                .flatMap(Stream::of)
//                .filter(field -> field.getModifiers() == Modifier.PRIVATE)
//                .forEach(field -> System.out.println(String.format("%s.%set%s();", StringUtils.uncapitalize(clazz.getSimpleName()), getOrSet?'g':'s', StringUtils.capitalize(field.getName()))));
//    }
}
