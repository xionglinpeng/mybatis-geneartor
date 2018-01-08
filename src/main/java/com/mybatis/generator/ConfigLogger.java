package com.mybatis.generator;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by xlp on 2018/1/8.
 */
public class ConfigLogger {

    public static void log(Logger logger,Object object){
        Class<?> classs = object.getClass();
        for(Field field : classs.getDeclaredFields()){
            try {
                Method method = classs.getDeclaredMethod("get"+ StringUtils.capitalize(field.getName()));
                Object value = method.invoke(object);
                if(ObjectUtils.allNotNull(value)) {
                    logger.info("config "+field.getName()+" : "+value);
                } else {
                    logger.warn("config "+field.getName()+" : "+value);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
