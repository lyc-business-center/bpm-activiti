package com.star.springboot.bpm.activiti.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ObjectUtils {

    /**
     * bean转换为map集合
     *
     * @param object 对象bean
     */
    public static Map<String, Object> covertMap(Object object, String... properties) {
        if (object == null) {
            return Collections.emptyMap();
        }
        BeanWrapper wrapper = new BeanWrapperImpl(object);
        Map<String, Object> params;
        if (properties != null && properties.length > 0) {
            params = newMap(properties.length);
            for (String property : properties) {
                if (wrapper.isReadableProperty(property)) {
                    params.put(property, wrapper.getPropertyValue(property));
                }
            }
        } else {
            PropertyDescriptor[] descriptors = wrapper.getPropertyDescriptors();
            params = newMap(descriptors.length);
            for (PropertyDescriptor descriptor : descriptors) {
                params.put(descriptor.getName(), wrapper.getPropertyValue(descriptor.getName()));
            }
        }
        return params;
    }

    /**
     * 创建HashMap实例，创建后需要扩展容量不见意使用此方法（适合于明确大小）
     *
     * @param size 大小
     * @param <K>  key类型
     * @param <V>  value类型
     * @return map实例
     */
    public static <K, V> Map<K, V> newMap(int size) {
        size = (int) (size / 0.75) + 1;
        return new HashMap<>(size);
    }
}
