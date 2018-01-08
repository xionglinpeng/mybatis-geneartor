package com.mybatis.generator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by xlp on 2018/1/7.
 */
public class VMConfig extends AbstractConfig{

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void acquire() {
        logger.info("VM : acquire vm config...");

        super.variables.setJdbcConnectionUrl(System.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_JDBC_CONNECTION_URL));
        super.variables.setJdbcDriverClass(System.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_JDBC_DRIVER_CLASS));
        super.variables.setJdbcUserId(System.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_JDBC_USER_ID));
        super.variables.setJdbcPassword(System.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_JDBC_PASSWORD));
        super.variables.setProject(System.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_PROJECT));
        super.variables.setJavaModelProject(System.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_JAVA_MODEL_PROJECT));
        super.variables.setJavaModelPackage(System.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_JAVA_MODEL_PACKAGE));
        super.variables.setSqlMapProject(System.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_SQL_MAP_PROJECT));
        super.variables.setSqlMapPackage(System.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_SQL_MAP_PACKAGE));
        super.variables.setJavaClientProject(System.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_JAVA_CLIENT_PROJECT));
        super.variables.setJavaClientPackage(System.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_JAVA_CLIENT_PACKAGE));
        super.variables.setTableNames(System.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_TABLE_NAMES));

        ConfigLogger.log(logger,super.variables);

    }

}
