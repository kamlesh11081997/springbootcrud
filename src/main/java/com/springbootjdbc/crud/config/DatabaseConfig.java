package com.springbootjdbc.crud.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Configuration
public class DatabaseConfig {

    @Bean(name = "devDS")
    @ConfigurationProperties(prefix = "spring.datasource.dev")
    public DataSource dataSourceDev(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "prodDS")
    @ConfigurationProperties(prefix = "spring.datasource.prod")
    public DataSource dataSourceProd(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dev")
    public JdbcTemplate jdbcTemplateDev(@Qualifier("devDS")DataSource ds){
        return new JdbcTemplate(ds);
    }

    @Bean(name="prod")
    public JdbcTemplate jdbcTemplateProd(@Qualifier("prodDS")DataSource ds){
        return new JdbcTemplate(ds);
    }

}
