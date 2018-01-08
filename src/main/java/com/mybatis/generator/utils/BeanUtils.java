package com.mybatis.generator.utils;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by xlp on 2018/1/8.
 */
public class BeanUtils {

    public static void copyProperty(Object source,Object target){
        try {
            Class<?> sourceClass = source.getClass();
            Class<?> targetClass = target.getClass();
            for (Field field : sourceClass.getDeclaredFields()) {
                String fieldName = StringUtils.capitalize(field.getName());
                Method method = sourceClass.getDeclaredMethod("get" + fieldName);
                Object object = method.invoke(source);
                if (ObjectUtils.allNotNull(object)) {
                    Method targetMethod = null;
                    try {
                        targetMethod = targetClass.getDeclaredMethod("set" + fieldName, field.getType());
                    }catch (NoSuchMethodException e){
                        continue;
                    }
                    targetMethod.invoke(target, object);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
