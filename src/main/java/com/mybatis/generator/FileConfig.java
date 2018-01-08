package com.mybatis.generator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by xlp on 2018/1/7.
 */
public class FileConfig extends AbstractConfig{

    private static final Logger logger = LogManager.getLogger();

    private static final String CONFIG_FILE_NAME = "mybatis-generator.properties";

    @Override
    public void acquire() {
        logger.info("FILE : acquire file config...");

        InputStream in = ClassLoader.getSystemResourceAsStream(CONFIG_FILE_NAME);
        if(in != null) {
            Properties properties = new Properties();
            try {
                properties.load(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
            super.variables.setJdbcConnectionUrl(properties.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_JDBC_CONNECTION_URL));
            super.variables.setJdbcDriverClass(properties.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_JDBC_DRIVER_CLASS));
            super.variables.setJdbcUserId(properties.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_JDBC_USER_ID));
            super.variables.setJdbcPassword(properties.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_JDBC_PASSWORD));
            super.variables.setProject(properties.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_PROJECT));
            super.variables.setJavaModelProject(properties.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_JAVA_MODEL_PROJECT));
            super.variables.setJavaModelPackage(properties.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_JAVA_MODEL_PACKAGE));
            super.variables.setSqlMapProject(properties.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_SQL_MAP_PROJECT));
            super.variables.setSqlMapPackage(properties.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_SQL_MAP_PACKAGE));
            super.variables.setJavaClientProject(properties.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_JAVA_CLIENT_PROJECT));
            super.variables.setJavaClientPackage(properties.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_JAVA_CLIENT_PACKAGE));
            super.variables.setTableNames(properties.getProperty(ConfigVariablesKeys.MYBATIS_GENERATOR_TABLE_NAMES));

            ConfigLogger.log(logger,super.variables);

        }else{
            logger.info("File : no profile.");
        }
    }

}
