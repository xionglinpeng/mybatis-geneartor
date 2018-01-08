package com.mybatis.generator;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by xlp on 2018/1/7.
 * 环境变量配置
 */
public class EnvironmentConfig extends AbstractConfig{

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void acquire() {
        logger.info("ENV : acquire env config...");
        super.variables.setJdbcConnectionUrl(System.getenv(ConfigVariablesKeys.MYBATIS_GENERATOR_ENV_JDBC_CONNECTION_URL));
        super.variables.setJdbcDriverClass(System.getenv(ConfigVariablesKeys.MYBATIS_GENERATOR_ENV_JDBC_DRIVER_CLASS));
        super.variables.setJdbcUserId(System.getenv(ConfigVariablesKeys.MYBATIS_GENERATOR_ENV_JDBC_USER_ID));
        super.variables.setJdbcPassword(System.getenv(ConfigVariablesKeys.MYBATIS_GENERATOR_ENV_JDBC_PASSWORD));
        super.variables.setProject(System.getenv(ConfigVariablesKeys.MYBATIS_GENERATOR_ENV_PROJECT));
        super.variables.setJavaModelProject(System.getenv(ConfigVariablesKeys.MYBATIS_GENERATOR_ENV_JAVA_MODEL_PROJECT));
        super.variables.setJavaModelPackage(System.getenv(ConfigVariablesKeys.MYBATIS_GENERATOR_ENV_JAVA_MODEL_PACKAGE));
        super.variables.setSqlMapProject(System.getenv(ConfigVariablesKeys.MYBATIS_GENERATOR_ENV_SQL_MAP_PROJECT));
        super.variables.setSqlMapPackage(System.getenv(ConfigVariablesKeys.MYBATIS_GENERATOR_ENV_SQL_MAP_PACKAGE));
        super.variables.setJavaClientProject(System.getenv(ConfigVariablesKeys.MYBATIS_GENERATOR_ENV_JAVA_CLIENT_PROJECT));
        super.variables.setJavaClientPackage(System.getenv(ConfigVariablesKeys.MYBATIS_GENERATOR_ENV_JAVA_CLIENT_PACKAGE));
        super.variables.setTableNames(System.getenv(ConfigVariablesKeys.MYBATIS_GENERATOR_ENV_TABLE_NAMES));

        ConfigLogger.log(logger,super.variables);
    }

}
