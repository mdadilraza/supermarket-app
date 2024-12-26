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
public class PostgreSQLConfig {

    @Autowired
    private Environment environment;

    @Bean(name = "postgresqlDataSource")
    public DataSource mssqlDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getProperty("spring.datasource.postgresql.url"));
        driverManagerDataSource.setUsername(environment.getProperty("spring.datasource.postgresql.username"));
        driverManagerDataSource.setPassword(environment.getProperty("spring.datasource.postgresql.password"));
        driverManagerDataSource.setDriverClassName(environment.getProperty("spring.datasource.postgresql.driver-class-name"));
        return driverManagerDataSource;
    }

    @Bean(name = "postgresqlJdbcTemplate")
    public JdbcTemplate postgresqlJdbcTemplate(@Qualifier("postgresqlDataSource") DataSource postgresqlDataSource) {
        return new JdbcTemplate(postgresqlDataSource);
    }

}

