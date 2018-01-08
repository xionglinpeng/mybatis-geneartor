package com.mybatis.generator;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * Created by xlp on 2018/1/7.
 */
public class ConfigVariables implements Serializable{

    private String jdbcConnectionUrl;
    private String jdbcDriverClass;
    private String jdbcUserId;
    private String jdbcPassword;
    private String project;
    private String javaModelProject;
    private String javaModelPackage;
    private String sqlMapProject;
    private String sqlMapPackage;
    private String javaClientProject;
    private String javaClientPackage;
    private String tableNames;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        if(StringUtils.isNotBlank(project)){
            if(StringUtils.isBlank(this.javaClientProject)){
                this.javaClientProject = project;
            }
            if(StringUtils.isBlank(this.sqlMapProject)){
                this.sqlMapProject = project;
            }
            if(StringUtils.isBlank(this.javaModelProject)){
                this.javaModelProject = project;
            }
            this.project = project;
        }
    }

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
        if(StringUtils.isNotBlank(javaModelProject)){
            this.javaModelProject = javaModelProject;
        }
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
        if(StringUtils.isNotBlank(sqlMapProject)){
            this.sqlMapProject = sqlMapProject;
        }
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
        if(StringUtils.isNotBlank(javaClientProject)){
            this.javaClientProject = javaClientProject;
        }
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
