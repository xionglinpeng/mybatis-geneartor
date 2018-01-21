package com.mybatis.generator;

import org.mybatis.generator.config.*;

/**
 * Created by xlp on 2018/1/7.
 */
public class GeneratorConfiguration {

    public static Configuration getInstance(){
        ConfigProperty config = ConfigFactory.validConfigVariables();

        Configuration configuration = new Configuration();
        Context context = new Context(ModelType.FLAT);
        context.setId("Mysql");
        context.setTargetRuntime("MyBatis3");
        context.addProperty("beginningDelimiter","`");
        context.addProperty("endingDelimiter","`");
        context.addProperty("autoDelimitKeywords","true");

        //配置插件
        String plugins[] = {
                "com.mybatis.generator.plugins.PaginationPlugin",
                "org.mybatis.generator.plugins.EqualsHashCodePlugin",
                "org.mybatis.generator.plugins.CaseInsensitiveLikePlugin",
                "org.mybatis.generator.plugins.SerializablePlugin",
                "org.mybatis.generator.plugins.ToStringPlugin",
        };
        for(String plugin : plugins){
            PluginConfiguration pluginConfiguration = new PluginConfiguration();
            pluginConfiguration.setConfigurationType(plugin);
            context.addPluginConfiguration(pluginConfiguration);
        }

        //配置注释生成器
//        CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();
//        //如果您将此值设置为true，则所有代码合并都将被禁用。
//        commentGeneratorConfiguration.addProperty("suppressAllComments","true");
//        commentGeneratorConfiguration.addProperty("suppressDate","true");
//        context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);

        //配置数据库连接
        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setConnectionURL(config.getJdbcConnectionUrl());
        jdbcConnectionConfiguration.setDriverClass(config.getJdbcDriverClass());
        jdbcConnectionConfiguration.setPassword(config.getJdbcPassword());
        jdbcConnectionConfiguration.setUserId(config.getJdbcUserId());
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

        //配置Java类型解析器
        JavaTypeResolverConfiguration javaTypeResolverConfiguration = new JavaTypeResolverConfiguration();
        javaTypeResolverConfiguration.addProperty("forceBigDecimals","false");

        //生成Model类存放位置
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
		javaModelGeneratorConfiguration.setTargetProject(config.getJavaModelProject());
		javaModelGeneratorConfiguration.setTargetPackage(config.getJavaModelPackage());
        javaModelGeneratorConfiguration.addProperty("enableSubPackages","true");
        javaModelGeneratorConfiguration.addProperty("trimStrings","true");
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        //生成映射文件存放位置
        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
		sqlMapGeneratorConfiguration.setTargetProject(config.getSqlMapProject());
		sqlMapGeneratorConfiguration.setTargetPackage(config.getSqlMapPackage());
        sqlMapGeneratorConfiguration.addProperty("enableSubPackages","true");
        sqlMapGeneratorConfiguration.addProperty("trimStrings","true");
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);
        //生成Dao类存放位置
        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
		javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        javaClientGeneratorConfiguration.setTargetProject(config.getJavaClientProject());
		javaClientGeneratorConfiguration.setTargetPackage(config.getJavaClientPackage());
        javaClientGeneratorConfiguration.addProperty("enableSubPackages","true");
        javaClientGeneratorConfiguration.addProperty("trimStrings","true");
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

        for(String tableName : config.getTableNames().split(ConfigVariablesKeys.TABLE_NAME_SEPARATOR)){
            TableConfiguration tableConfiguration = new TableConfiguration(context);
            tableConfiguration.setTableName(tableName);
            context.addTableConfiguration(tableConfiguration);
        }
        configuration.addContext(context);
        return configuration;
    }
}
