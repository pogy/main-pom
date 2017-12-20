package com.shigu.main4.common.util;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;


public class BeanMapper {
    private static MapperFacade mapper = null;

    static {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapper = mapperFactory.getMapperFacade();
    }

    /**
     * 转化抽象类
     * @param source
     * @param destination
     * @param <S>
     * @param <D>
     * @return
     */
    public static <S,D> D mapAbstact(S source,D destination){
        Class<S> sourceClass= (Class<S>) source.getClass();
        Class<D> destinationClass= (Class<D>) destination.getClass();
        Field[] fields=sourceClass.getDeclaredFields();
        Field[] fieldsSupper=sourceClass.getSuperclass().getDeclaredFields();
        List<Field> fieldList=new ArrayList<>();
        fieldList.addAll(Arrays.asList(fields));
        fieldList.addAll(Arrays.asList(fieldsSupper));
        for(Field f:fieldList){
            if(f.getModifiers()!=2){
                continue;
            }
            String fieldName=f.getName();
            fieldName=fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            String setFieldName="set"+fieldName;
            String getFieldName="get"+fieldName;
            try {
                Method getMethod=sourceClass.getMethod(getFieldName);
                Method method=destinationClass.getMethod(setFieldName,f.getType());
                method.invoke(destination,getMethod.invoke(source));
            } catch (Exception e) {
            }
        }
        return destination;
    }
    /**
     * 值拷贝
     * @param source
     * @param destination
     * @param <S>
     * @param <D>
     * @return
     */
    public static <S,D> D map(S source,D destination){
        mapper.map(source,destination);
        return destination;
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
     */
    @SuppressWarnings("unchecked")
    public static <F, T> Map<F, T> list2Map(Iterable<T> list, String field, Class<F> fieldType) {
        if (list == null || field == null || fieldType == null) return null;
        Field classField = null;
        Map<F, T> map = new LinkedHashMap<>();
        try {
            for (T t : list) {
                if (classField == null) {
                    classField = checkField(t.getClass(), field);
                }
                Object ko = classField.get(t);
                if (ko == null)
                    continue;
                map.put((F) ko, t);
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
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
     */
    public static <E, T> List<E> getFieldList(Iterable<T> list, String field, Class<E> fieldType){
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
     */
    public static <E, T> Set<E> getFieldSet(Iterable<T> list, String field, Class<E> fieldType){
        return (Set<E>) getFieldCollection(list, field, fieldType, new HashSet<E>());
    }

    @SuppressWarnings("unchecked")
    public static <E, T> Collection<E> getFieldCollection(Iterable<T> list, String field, Class<E> fieldType, Collection<E> collection) {
        if (list == null || field == null || fieldType == null)
            return null;
        Field classField = null;
        try {
            for (T t : list) {
                if (classField == null) {
                    classField = checkField(t.getClass(), field);
                }
                Object o = classField.get(t);
                if (o == null)
                    continue;
                collection.add((E) o);
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        return collection;
    }

    /**
     *  根据传入集合，提取指定字段值做为返回Map的Key，此方法与 list2Map 不同之处在于 后者的key应当是集合中的主键概念，即集合中所有
     *  对象的该字段值都不同，所以后者的应用受到该约束，如果有两个或以上的该字段相同的key，那么后来者会替换掉之前的value。
     *
     *  本方法使用场景是提取集合中的某字段，同时集合中可能有多个值在此字段一致，调用此方法后，该字段做返回 Map 的Key，Map的value为
     *  原list在此字段聚合的结果集
    *
     * @param list 需要聚合的数据
     * @param field 指定聚合字段
     * @param fieldType 该字段类型
     * @param <E> K泛型
     * @param <T> 元数据范型
     * @return 聚合结果，结构为 Map<E, List<T>>
     */
    @SuppressWarnings("all")
    public static <E, T> Map<E, List<T>> groupBy(Iterable<T> list, String field, Class<E> fieldType) {
        if (list == null || field == null || fieldType == null)
            return null;
        Field classField = null;
        Set<E> fieldSet = getFieldSet(list, field, fieldType);
        Map<E, List<T>> group = new HashMap<>();
        for (E e : fieldSet) {
            group.put(e, new ArrayList<T>());
        }
        try {
            for (T t : list) {
                if (classField == null) {
                    classField = checkField(t.getClass(), field);
                }
                group.get((classField.get(t))).add(t);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return group;
    }

    private static Field checkField(Class<?> tClass, String field) throws NoSuchFieldException {
        Field classField = null;
        while (classField == null) {
            if (tClass == Object.class) {
                throw new NoSuchFieldException(field);
            }
            try {
                classField = tClass.getDeclaredField(field);
                classField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                tClass = tClass.getSuperclass();
            }
        }
        return classField;
    }
}
