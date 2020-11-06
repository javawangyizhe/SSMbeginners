package com.offcn.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages="com.offcn")
public class SpringContextAppConfig {
    @Bean(name="dataSource")
    public DataSource getDataSource(){
        DruidDataSource DataSource = new DruidDataSource();
        DataSource.setDriverClassName("com.mysql.jdbc.Driver");
        DataSource.setUrl("jdbc:mysql:///mybatis_system");
        DataSource.setUsername("root");
        DataSource.setPassword("root");
        return DataSource;
    }
    @Bean(name = "queryRunner")
    public QueryRunner queryRunner(@Autowired DataSource dataSource){
        QueryRunner queryRunner = new QueryRunner(dataSource);
        return queryRunner;
    }

}
