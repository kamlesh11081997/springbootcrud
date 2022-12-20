package com.springbootjdbc.crud.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.jdbc.core.JdbcTemplate;

@Builder
@Getter
public class Environment {
    private final String env;
    private final JdbcTemplate jdbcTemplate;
    private final String databaseUsername;
    private final String databasePassword;
    private final String jdbcUrl;
}
