package com.school.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/**
 * Created by Administrator on 2019/1/4.
 */

public class SpringBootStaticResourceConfig  extends WebMvcConfigurationSupport{
    Logger logger = LoggerFactory.getLogger(SpringBootStaticResourceConfig.class);

    @Override
    protected  void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry){
        logger.info("---------"+resourceHandlerRegistry+"进来了");
        System.out.println(resourceHandlerRegistry);

        resourceHandlerRegistry
                .addResourceHandler("/image/**")
                .addResourceLocations("classpath*:static/");
        super.addResourceHandlers(resourceHandlerRegistry);


    }






}
