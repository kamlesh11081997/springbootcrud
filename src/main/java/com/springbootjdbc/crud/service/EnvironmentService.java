package com.springbootjdbc.crud.service;

import com.springbootjdbc.crud.model.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

public interface EnvironmentService {
    void setEnvironment(Environment environment);
    Environment getEnvironment();
    JdbcTemplate getJdbcTemplate();
    String getDatabaseUrl();
    String getDatabasePassword();
    String getDatabaseUserName();
    void init();
    void destroy();

}
