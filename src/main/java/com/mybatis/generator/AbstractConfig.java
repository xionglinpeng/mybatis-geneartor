package com.mybatis.generator;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by xlp on 2018/1/8.
 */
public abstract class AbstractConfig implements IMybatisGeneratorConfig{

    protected ConfigVariables variables = new ConfigVariables();

    @Override
    public ConfigVariables getConfig() {
        return variables;
    }

}
