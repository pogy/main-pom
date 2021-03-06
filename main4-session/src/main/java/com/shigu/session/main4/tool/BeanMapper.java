package com.shigu.session.main4.tool;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.lang.reflect.*;
import java.util.*;


public class BeanMapper {
    private static MapperFacade mapper = null;

    static {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapper = mapperFactory.getMapperFacade();

    }

    /**
     * 基于Dozer转换对象的类型.
     */
    public static <S, D> D map(S source, Class<D> destinationClass) {
        return mapper.map(source, destinationClass);
    }

    /**
     * 基于Dozer转换Collection中对象的类型.
     */
    public static <S, D> List<D> mapList(Iterable<S> sourceList, Class<D> destinationClass) {
        return mapper.mapAsList(sourceList, destinationClass);
    }

    /**
     * 将传入集合中指定字段为Key，对应集合中的对象为Value，构造Map
     * @param list 要转的集合
     * @param field 为Key的字段
     * @param fieldType 字段类型
     * @param <F> 字段类型
     * @param <T> 集合泛型
     * @return 转换后的Map
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static <F, T> Map<F, T> list2Map(List<T> list, String field, Class<F> fieldType) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (list == null || field == null || fieldType == null) return null;
        Map<F, T> map = new LinkedHashMap<F, T>();
        for (T t : list) {
            Class<?> tClass = t.getClass();
            Method method = tClass.getMethod("get" + field.substring(0, 1).toUpperCase() + field.substring(1));
            Object ko = method.invoke(t);
            if (ko == null) continue;
            F key = (F) ko;

            map.put(key, t);
        }
        return map;
    }

    /**
     * 根据指定的字段，从传入集合泛型类型中抽出该字段值，并重新组合以该字段类型为泛型的集合（允许重复的值）
     * @param list 传入的集合
     * @param field 需要抽取的字段
     * @param fieldType 该字段类型
     * @param <E> 字段泛型
     * @param <T> 传入集合泛型
     * @return 结果集合
     * @throws Exception
     */
    public static <E, T> List<E> getFieldList(List<T> list, String field, Class<E> fieldType) throws Exception{
        return (List<E>) getFieldCollection(list, field, fieldType, new ArrayList<E>());
    }

    /**
     * 根据指定的字段，从传入集合泛型类型中抽出该字段值，并重新组合以该字段类型为泛型的集合
     * @param list 传入的集合
     * @param field 需要抽取的字段
     * @param fieldType 该字段类型
     * @param <E> 字段泛型
     * @param <T> 传入集合泛型
     * @return 结果集合
     * @throws Exception
     */
    public static <E, T> Set<E> getFieldSet(List<T> list, String field, Class<E> fieldType) throws Exception{
        return (Set<E>) getFieldCollection(list, field, fieldType, new HashSet<E>());
    }

    public static <E, T> Collection<E> getFieldCollection(List<T> list, String field, Class<E> fieldType, Collection<E> collection) throws Exception {
        if (list == null || field == null || fieldType == null) return null;
        for (T t : list) {
            Class<?> tClass = t.getClass();
            Method method = tClass.getMethod("get" + field.substring(0, 1).toUpperCase() + field.substring(1));
            Object o = method.invoke(t);
            if (o == null) continue;
            E key = (E) o;
            collection.add(key);
        }
        return collection;
    }
}
