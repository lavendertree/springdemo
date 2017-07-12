package com.config.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 配置WebConfig
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.controller")
public class WebConfig  extends WebMvcConfigurerAdapter{

    /*
        function 配置视图
     */
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        resolver.setPrefix("/WEB-INF/views");   //视图路径
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return  resolver;
    }

    /*
    *采用默认的ServletHandler,可以选择不配置默认
    */
    public void ConfigureDefaultServletHanding(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
        super.configureDefaultServletHandling(configurer);
    }

    /*
    * 配置静态资源
    */
    public void addResoureHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/static/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/static/js/");
        registry.addResourceHandler("/image/**").addResourceLocations("/WEB-INF/static/image/");
        super.addResourceHandlers(registry);
    }

}
