package com.mybatis.generator;

/**
 * Created by xlp on 2018/1/7.
 */
public interface IMybatisGeneratorConfig {

    void acquire();

    ConfigVariables getConfig();
}
