package com.config.basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 配置RootConfig
 */
@Configuration
@ComponentScan(basePackages = {"com"},
            excludeFilters = {
                    @ComponentScan.Filter(type= FilterType.ANNOTATION,value= EnableWebMvc.class)
            })
public class RootConfig{
}
