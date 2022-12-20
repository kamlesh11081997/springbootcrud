package com.springbootjdbc.crud;

import com.springbootjdbc.crud.interceptor.EnvironmentInterceptor;
import com.springbootjdbc.crud.service.EnvironmentService;
import com.springbootjdbc.crud.service.EnvironmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringBootJdbcApp {

    @Autowired
    EnvironmentInterceptor environmentInterceptor;

    //starting the spring boot application
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcApp.class,args);
    }

    // creating bean of environment service implementation
    @Bean(initMethod = "init",destroyMethod = "destroy")
    @Scope(value = "request",proxyMode = ScopedProxyMode.INTERFACES)
    public EnvironmentService environmentService(){
        return new EnvironmentServiceImpl();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(environmentInterceptor).addPathPatterns("/**");
            }

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }



}
