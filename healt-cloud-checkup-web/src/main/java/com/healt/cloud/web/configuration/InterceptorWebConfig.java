package com.healt.cloud.web.configuration;

import com.healt.cloud.web.compontent.JWTInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

//将自定义的拦截器放入到springboot容器中
public class InterceptorWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(Arrays.asList("/pdf/login","/pdf/regeist", "/h5/**"));
    }
}
