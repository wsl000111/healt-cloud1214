package com.healt.cloud.web.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author GuYue
 * @date 2022-09-17 0:35
 * @description: TODO
 */
@Configuration
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //需要的文件路径映射
        registry.addResourceHandler("/download/**").addResourceLocations("file:c:/download/");
        registry.addResourceHandler("/h5/**").addResourceLocations("classpath:/h5/");
        // registry.addResourceHandler("/**").addResourceLocations("classpath:/static/").addResourceLocations("classpath:/META-INF/resources/");
    }

}
