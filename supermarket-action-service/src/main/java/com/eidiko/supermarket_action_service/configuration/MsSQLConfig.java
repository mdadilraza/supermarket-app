package com.eidiko.supermarket_action_service.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
public class MsSQLConfig {


    @Autowired
    Environment env;

    @Bean(name = "mssqlDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.mssql")
    public DataSource mssqlDataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.mssql.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.mssql.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.mssql.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.mssql.password"));
        return dataSource;
    }


    @Bean(name = "mssqlJdbcTemplate")
    public JdbcTemplate mssqlJdbcTemplate(@Qualifier("mssqlDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
