package com.github.cm;

import com.github.cm.config.RootConfig;
import com.github.cm.config.SecurityConfig;
import com.github.cm.config.WebConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Ye Yan on 5/03/15.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class, SecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    public static class WebSecurityInitializer extends AbstractSecurityWebApplicationInitializer {}
}

