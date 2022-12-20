package com.springbootjdbc.crud.service;

import com.springbootjdbc.crud.model.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

public class EnvironmentServiceImpl implements EnvironmentService{

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment=environment;
    }

    @Override
    public Environment getEnvironment() {
        return environment;
    }

    @Override
    public JdbcTemplate getJdbcTemplate() {
        return environment.getJdbcTemplate();
    }

    @Override
    public String getDatabaseUrl() {
        return environment.getJdbcUrl();
    }

    @Override
    public String getDatabasePassword() {
        return environment.getDatabasePassword();
    }

    @Override
    public String getDatabaseUserName() {
        return environment.getDatabaseUsername();
    }

    @Override
    public void init(){

    }

    @Override
    public void destroy(){

    }
}
