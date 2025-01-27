package com.eidiko.supermarket_integration_service.config;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;

@Configuration
public class PostgreSQLConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.postgresql")
    public DataSourceProperties postgreSqlDataSourceProperties(){
        return new DataSourceProperties();
    }


    @Bean(name = "postgresqlDataSource")
    public DataSource postgreSqlDataSource (){

        return postgreSqlDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean(name = "postgresqlJdbcTemplate")
    public JdbcTemplate postgresqlJdbcTemplate(@Qualifier("postgresqlDataSource") DataSource postgresqlDataSource) {
        return new JdbcTemplate(postgresqlDataSource);
    }

}