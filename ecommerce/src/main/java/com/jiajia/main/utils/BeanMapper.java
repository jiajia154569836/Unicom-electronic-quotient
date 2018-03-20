/**
 * Copyright (c) 2017 www.bonc.com.cn. All Rights Reserved.
 */
package com.jiajia.main.utils;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.builtin.PassThroughConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.metadata.TypeFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * <p>
 * 简单封装orika, 实现深度的BeanOfClasssA  BeanOfClassB复制
 * 不用Apache Common BeanUtils进行类复制，每次就行反射查询对象的属性列表, 非常缓慢.
 * </p>
 *
 * @author yangwang1@bonc.com.cn
 * @version V1.0.0
 */
public class BeanMapper {

    private static MapperFacade mapper;

    static {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(LocalDate.class));
        mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(LocalTime.class));
        mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(LocalDateTime.class));
        mapper = mapperFactory.getMapperFacade();
    }

    /**
     *
     * 简单的复制出新类型对象.
     *
     * @param source 源对象
     * @param destinationClass 目标对象
     * @param <S> 源类型
     * @param <D> 目标类型
     * @return  通过source.getClass() 获得源Class
     */
    public static <S, D> D map(S source, Class<D> destinationClass) {
        return mapper.map(source, destinationClass);
    }

    /**
     * 极致性能的复制出新类型对象.
     * 预先通过BeanMapper.getType() 静态获取并缓存Type类型，在此处传入
     * @param source 源对象
     * @param sourceType 源类型
     * @param destinationType 目标类型
     * @param <S> 源类型
     * @param <D> 目标类型
     * @return 目标对象
     */
    public static <S, D> D map(S source, Type<S> sourceType, Type<D> destinationType) {
        return mapper.map(source, sourceType, destinationType);
    }

    /**
     * 简单的复制出新对象列表到ArrayList
     * @param sourceList 源列表
     * @param sourceClass 源类型
     * @param destinationClass 目标类型
     * @param <S> 源类型
     * @param <D> 目标类型
     * @return 目标列表
     */
    public static <S, D> List<D> mapList(Iterable<S> sourceList, Class<S> sourceClass, Class<D> destinationClass) {
        return mapper.mapAsList(sourceList, TypeFactory.valueOf(sourceClass), TypeFactory.valueOf(destinationClass));
    }

    /**
     *
     * 极致性能的复制出新类型对象到ArrayList.
     * 预先通过BeanMapper.getType() 静态获取并缓存Type类型，在此处传入
     * @param sourceList 源列表
     * @param sourceType 源类型
     * @param destinationType 目标类型
     * @param <S> 源类型
     * @param <D> 目标类型
     * @return 目标列表
     */
    public static <S, D> List<D> mapList(Iterable<S> sourceList, Type<S> sourceType, Type<D> destinationType) {
        return mapper.mapAsList(sourceList, sourceType, destinationType);
    }

    /**
     *
     * 简单复制出新对象列表到数组
     * 通过source.getComponentType() 获得源Class
     * @param destination 目标对象
     * @param source 源对象
     * @param destinationClass 目标类型
     * @param <S> 源类型
     * @param <D> 目标类型
     * @return 目标数组
     */
    public static <S, D> D[] mapArray(final D[] destination, final S[] source, final Class<D> destinationClass) {
        return mapper.mapAsArray(destination, source, destinationClass);
    }

    /**
     *
     * 极致性能的复制出新类型对象到数组
     * 预先通过BeanMapper.getType() 静态获取并缓存Type类型，在此处传入
     * @param destination 目标对象
     * @param source 源对象
     * @param sourceType 源类型
     * @param destinationType 目标类型
     * @param <S> 源类型
     * @param <D> 目标类型
     * @return 目标数组
     */
    public static <S, D> D[] mapArray(D[] destination, S[] source, Type<S> sourceType, Type<D> destinationType) {
        return mapper.mapAsArray(destination, source, sourceType, destinationType);
    }

    /**
     * 预先获取orika转换所需要的Type，避免每次转换.
     * @param rawType 源类型
     * @param <E> 类型
     * @return 类型
     */
    public static <E> Type<E> getType(final Class<E> rawType) {
        return TypeFactory.valueOf(rawType);
    }

}
