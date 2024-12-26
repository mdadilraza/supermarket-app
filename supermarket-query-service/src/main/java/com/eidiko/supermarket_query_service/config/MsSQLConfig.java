package com.eidiko.supermarket_query_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class MsSQLConfig {

    @Autowired
    private Environment environment;

    @Bean(name = "mssqlDataSource")
    public DataSource mssqlDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getProperty("spring.datasource.mssql.url"));
        driverManagerDataSource.setUsername(environment.getProperty("spring.datasource.mssql.username"));
        driverManagerDataSource.setPassword(environment.getProperty("spring.datasource.mssql.password"));
        driverManagerDataSource.setDriverClassName(environment.getProperty("spring.datasource.mssql.driver-class-name"));
        return driverManagerDataSource;
    }

    @Bean(name = "mssqlJdbcTemplate")
    public JdbcTemplate mssqlJdbcTemplate(@Qualifier("mssqlDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}

