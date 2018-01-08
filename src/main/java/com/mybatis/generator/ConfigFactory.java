package com.mybatis.generator;

import com.mybatis.generator.utils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by xlp on 2018/1/8.
 */
public class ConfigFactory {

    private static final Logger logger = LogManager.getLogger();

    public static ConfigProperty validConfigVariables(){
        ConfigProperty configProperty = new ConfigProperty();

        IMybatisGeneratorConfig environmentConfig = new EnvironmentConfig();
        environmentConfig.acquire();
        BeanUtils.copyProperty(environmentConfig.getConfig(),configProperty);

        IMybatisGeneratorConfig vmConfig = new VMConfig();
        vmConfig.acquire();
        BeanUtils.copyProperty(vmConfig.getConfig(),configProperty);

        IMybatisGeneratorConfig fileConfig = new FileConfig();
        fileConfig.acquire();
        BeanUtils.copyProperty(fileConfig.getConfig(),configProperty);

        logger.info("CONFIG : valid config...");
        ConfigLogger.log(logger,configProperty);

        return configProperty;
    }


}
