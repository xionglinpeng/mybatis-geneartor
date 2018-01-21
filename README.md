##版本更新日志
1. 1.0.0 初始版本
2. 1.0.1 BUG修复
    代码注释配置`commentGeneratorConfiguration.addProperty("suppressAllComments","true");`导致生成的xml反射文件重复，查看官方文档提示`Warning: if you set this value to true, then all code merging will be disabled.`（如果您将此值设置为true，则所有代码合并都将被禁用。），以修复BUG，修复方式：去掉了注释配置。


如果多个web项目都要用到mybatis框架，并且都要用到mybatis generator反向工程，相互之间进行代码以及配置文件的拷贝也是一件很麻烦的事，本项目就是用于解决此问题。只需要依赖指定的jar包，添加必要的配置，即可实现**默认**的mybatis generator反向工程。

**注意**：

1. 当前版本1.0.0只针对mysql数据进行开发。
2. 直接添加Maven依赖是不能被下载的，因为在Maven中央仓库中根本就不存在，所以需要使用，请自行下载项目打包安装。

## 添加maven依赖
```
<dependency>
    <groupId>com.mybatis.generator</groupId>
    <artifactId>mybatis-generator</artifactId>
    <version>1.0.0</version>
    <scope>provided</scope>
</dependency>
```
在生成mybatis反射文件时需要将`<scope>provided</scope>`去掉。
## 配置必要的属性配置
属性配置有三种方式。分别是
1. 环境变量配置
2. vm虚拟机变量配置
3. 配置文件

##### 一、环境变量配置
```
MYBATIS_GENERATOR_JDBC_CONNECTION_URL=jdbc:mysql://localhost:3306/finance?useUnicode\=true&useSSL\=false&serverTimezone\=UTC
MYBATIS_GENERATOR_JDBC_DRIVER_CLASS=com.mysql.cj.jdbc.Driver
MYBATIS_GENERATOR_JDBC_USER_ID=root
MYBATIS_GENERATOR_JDBC_PASSWORD=xxxxxx
MYBATIS_GENERATOR_PROJECT=src/main/java
MYBATIS_GENERATOR_JAVA_MODEL_PROJECT=src/main/java
MYBATIS_GENERATOR_JAVA_MODEL_PACKAGE=com.mybatis.model
MYBATIS_GENERATOR_SQL_MAP_PROJECT=src/main/java
MYBATIS_GENERATOR_SQL_MAP_PACKAGE=com.mybatis.sql
MYBATIS_GENERATOR_JAVA_CLIENT_PROJECT=src/main/java
MYBATIS_GENERATOR_JAVA_CLIENT_PACKAGE=com.mybatis.mapper
```
##### 二、vm虚拟机变量配置
```
-Dmybatis.generator.jdbc.connectionURL=jdbc:mysql://localhost:3306/finance?useUnicode=true&useSSL=false&serverTimezone=UTC
-Dmybatis.generator.jdbc.driverClass=com.mysql.cj.jdbc.Driver
-Dmybatis.generator.jdbc.userId=root
-Dmybatis.generator.jdbc.password=xxxxxx
-Dmybatis.generator.project=src/main/java
-Dmybatis.generator.java.model.project=src/main/java
-Dmybatis.generator.java.model.package=com.mybatis.model
-Dmybatis.generator.sql.map.project=src/main/java
-Dmybatis.generator.sql.map.package=com.mybatis.sql
-Dmybatis.generator.java.client.project=src/main/java
-Dmybatis.generator.java.client.package=com.mybatis.mapper
-Dmybatis.generator.table.names=expenditure,master_type

```
##### 三、配置文件
```
mybatis.generator.jdbc.connectionURL=jdbc:mysql://localhost:3306/finance?useUnicode=true&useSSL=false&serverTimezone=UTC
mybatis.generator.jdbc.driverClass=com.mysql.cj.jdbc.Driver
mybatis.generator.jdbc.userId=root
mybatis.generator.jdbc.password=xxxxxx
mybatis.generator.project=src/main/java
mybatis.generator.java.model.project=src/main/java
mybatis.generator.java.model.package=com.mybatis.model
mybatis.generator.sql.map.project=src/main/java
mybatis.generator.sql.map.package=com.mybatis.sql
mybatis.generator.java.client.project=src/main/java
mybatis.generator.java.client.package=com.mybatis.mapper
mybatis.generator.table.names=expenditure,master_type
```
配置文件必须命名为`mybatis-generator.properties`，必须放在classpath根目录下，否则找不到配置文件。例如`resources`资源目录。
## 属性详解
```
mybatis.generator.jdbc.connectionURL
```
连接数据库的URL地址
```
mybatis.generator.jdbc.driverClass
```
数据库驱动类全路径
```
mybatis.generator.jdbc.userId
```
数据库账号
```
mybatis.generator.jdbc.password
```
数据库密码
```
mybatis.generator.project
```
`mybatis.generator.java.model.project`、`mybatis.generator.sql.map.project`和`mybatis.generator.java.client.project`的共同路径，大部情况下，上述三个配置都是相同，针对的是同一个项目，设置此配置，就可以不用再设置上述三个配置，会默认将当前配置添加为上述三个配置的值，如果设置了上述三个配置，则以设置上述三个配置值为有效配置。
```
mybatis.generator.java.model.project
```
实体类生成路径，可以是相对当前系统的绝对路径，或是相对路径。建议使用相对路径，相对路径是以当前项目的项目路径为起点，以maven项目为例，如果是多模块项目，相对路口为moduleName/src/main/java，如果不是多模块项目，相对路径是src/main/java。设置会覆盖`mybatis.generator.project`对当前配置的设置。
```
mybatis.generator.java.model.package
```
实体类生成包路径。例如:`com.mybatis.dao`。
```
mybatis.generator.sql.map.project
```
sql映射xml文件生成路径。路径等同于`mybatis.generator.java.model.project`。设置会覆盖`mybatis.generator.project`对当前配置的设置。
```
mybatis.generator.sql.map.package
```
sql映射xml文件生成包路径。路径等同于`mybatis.generator.java.model.package`。

在idea开发工具下，sql映射xml文件放置在包中不会被编译到target目录下，可以设置maven资源配置解决此问题：
```
<build>
    <resources>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>com/githup/sqlMapper/*.xml</include>
            </includes>
        </resource>
    </resources>
</build>
```

```
mybatis.generator.java.client.project
```
mapper接口生成路径。路径等同于`mybatis.generator.java.model.project`。设置会覆盖`mybatis.generator.project`对当前配置的设置。
```
mybatis.generator.java.client.package
```
mapper接口生成包路径。路径等同于`mybatis.generator.java.model.package`。
```
mybatis.generator.table.names
```
表名，以逗号分隔。

## 优先级
环境变量配置 < vm配置 < 配置文件
>配置文件的优先级最高，会覆盖vm配置，vm配置会覆盖环境变量配置。

## 执行
执行main方法
```
com.mybatis.generator.Execute
```
## 实际操作配置
以idea开发工具为例

Run->Edit Configurations->新建Application

建议命名为mybatis-generator。

Main class：设置执行类型`com.mybatis.generator.Execute`。

VM Options：设置vm配置。

Environment Variables：设置环境变量。

或者设置为系统环境变量。