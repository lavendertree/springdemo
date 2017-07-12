package com.config.basic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 配置DispatcherServlet
 */
public class TestWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected  String[] getServletMappings(){
        return new String[] {"/"};
    }

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class,};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class};
    }

}
