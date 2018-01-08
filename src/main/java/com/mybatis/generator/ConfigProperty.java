package com.mybatis.generator;

/**
 * Created by xlp on 2018/1/8.
 */
public class ConfigProperty {

    private String jdbcConnectionUrl;
    private String jdbcDriverClass;
    private String jdbcUserId;
    private String jdbcPassword;
    private String javaModelProject;
    private String javaModelPackage;
    private String sqlMapProject;
    private String sqlMapPackage;
    private String javaClientProject;
    private String javaClientPackage;
    private String tableNames;

    public String getJdbcConnectionUrl() {
        return jdbcConnectionUrl;
    }

    public void setJdbcConnectionUrl(String jdbcConnectionUrl) {
        this.jdbcConnectionUrl = jdbcConnectionUrl;
    }

    public String getJdbcDriverClass() {
        return jdbcDriverClass;
    }

    public void setJdbcDriverClass(String jdbcDriverClass) {
        this.jdbcDriverClass = jdbcDriverClass;
    }

    public String getJdbcUserId() {
        return jdbcUserId;
    }

    public void setJdbcUserId(String jdbcUserId) {
        this.jdbcUserId = jdbcUserId;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

    public String getJavaModelProject() {
        return javaModelProject;
    }

    public void setJavaModelProject(String javaModelProject) {
        this.javaModelProject = javaModelProject;
    }

    public String getJavaModelPackage() {
        return javaModelPackage;
    }

    public void setJavaModelPackage(String javaModelPackage) {
        this.javaModelPackage = javaModelPackage;
    }

    public String getSqlMapProject() {
        return sqlMapProject;
    }

    public void setSqlMapProject(String sqlMapProject) {
        this.sqlMapProject = sqlMapProject;
    }

    public String getSqlMapPackage() {
        return sqlMapPackage;
    }

    public void setSqlMapPackage(String sqlMapPackage) {
        this.sqlMapPackage = sqlMapPackage;
    }

    public String getJavaClientProject() {
        return javaClientProject;
    }

    public void setJavaClientProject(String javaClientProject) {
        this.javaClientProject = javaClientProject;
    }

    public String getJavaClientPackage() {
        return javaClientPackage;
    }

    public void setJavaClientPackage(String javaClientPackage) {
        this.javaClientPackage = javaClientPackage;
    }

    public String getTableNames() {
        return tableNames;
    }

    public void setTableNames(String tableNames) {
        this.tableNames = tableNames;
    }
}
