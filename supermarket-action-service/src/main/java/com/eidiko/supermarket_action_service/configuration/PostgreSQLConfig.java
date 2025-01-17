package com.eidiko.supermarket_action_service.configuration;

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
    @ConfigurationProperties(prefix = "spring.datasource.postgresql")
    public DataSourceProperties postgresqlDatasourceProperties()
    {
        return new DataSourceProperties();
    }

    @Bean(name = "postgresqlDataSource")
    public DataSource postgresqlDataSource()
    {
        return postgresqlDatasourceProperties().initializeDataSourceBuilder().build();
    }


    @Bean(name = "postgresqlJdbcTemplate")
    public JdbcTemplate postgresqlJdbcTemplate(@Qualifier("postgresqlDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
