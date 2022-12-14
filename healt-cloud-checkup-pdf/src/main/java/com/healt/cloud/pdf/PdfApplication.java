package com.healt.cloud.pdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * @author GuYue
 * @date 2022-09-16 8:47
 * @description: TODO
 */
@ComponentScan(basePackages = {"com.healt.cloud.checkup","com.healt.cloud.pdf"})
@SpringBootApplication
public class PdfApplication {
    /**
     * 创建 RestTemplate 对象 并注入到Spring容器中
     * @return
     */
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(PdfApplication.class, args);
    }
}
