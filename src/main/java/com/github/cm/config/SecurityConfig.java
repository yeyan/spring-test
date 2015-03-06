package com.github.cm.config;

import com.github.cm.greetings.GreetingsPermissionEvaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Ye Yan on 5/03/15.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        logger.debug("\n**************************************************\n* Auth Manager");
        auth.inMemoryAuthentication()
                .withUser("user").password("123").roles("USER").and()
                .withUser("admin").password("123").roles("USER", "ADMIN");
    }

    @Configuration
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter{
        protected Logger logger = LoggerFactory.getLogger(this.getClass());

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            logger.debug("\n**************************************************\n* WEB Security");
            http.authorizeRequests()
                    .antMatchers("/fib/**").hasRole("USER")
                    .and().formLogin();
        }
    }

    @Configuration
    @EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
    public static class MethodSecurity extends GlobalMethodSecurityConfiguration {
        protected Logger logger = LoggerFactory.getLogger(this.getClass());

        @Override
        protected MethodSecurityExpressionHandler createExpressionHandler() {

            DefaultMethodSecurityExpressionHandler expressionHandler =
                    new DefaultMethodSecurityExpressionHandler();

            expressionHandler.setPermissionEvaluator(new GreetingsPermissionEvaluator());

            return expressionHandler;
        }
    }

}
