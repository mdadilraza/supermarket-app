package com.eidiko.supermarket_integration_service.config;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class MsSqlConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.mssql")
    public DataSourceProperties mssqlSqlDataSourceProperties(){
        return new DataSourceProperties();
    }


    @Bean(name = "mssqlsqlDataSource")
    public DataSource mssqlsqlDataSource (){

        return mssqlSqlDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean(name = "mssqlJdbcTemplate")
    public JdbcTemplate mssqlJdbcTemplate(@Qualifier("mssqlsqlDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}

