package com.springbootjdbc.crud.interceptor;

import com.springbootjdbc.crud.service.EnvironmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class EnvironmentInterceptor extends HandlerInterceptorAdapter {

    Logger logger= LoggerFactory.getLogger(EnvironmentInterceptor.class);

    @Autowired
    private EnvironmentService environmentService;

    @Autowired
    private Environment springEnvironment;

    @Autowired
    private BeanFactory beanFactory;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       String env=request.getHeader("environment");
       if(!request.getMethod().equalsIgnoreCase("OPTIONS")){
           logger.info("Request for {} environment",env);
           logger.info("Request URI: {}",request.getRequestURL());
           if(env!=null){
               JdbcTemplate jdbcTemplate=(JdbcTemplate) beanFactory.getBean(env);
               com.springbootjdbc.crud.model.Environment environment=
                       com.springbootjdbc.crud.model.Environment.builder()
                               .jdbcTemplate(jdbcTemplate)
                               .env(env)
                               .databaseUsername(springEnvironment.getProperty("spring.datasource.".concat(env).concat(".username")))
                               .databasePassword(springEnvironment.getProperty("spring.datasource.".concat(env).concat(".password")))
                               .jdbcUrl(springEnvironment.getProperty("spring.datasource.".concat(env).concat(".jdbcUrl")))
                               .build();
               logger.info("Environment set : {}",environment.toString());
               environmentService.setEnvironment(environment);
               return true;
           }else{
               return false;
           }
       }
       return false;
    }
}
