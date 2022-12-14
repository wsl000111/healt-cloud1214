package com.healt.cloud.checkup;

import com.healt.cloud.checkup.anno.EnableCheckupService;
import com.healt.cloud.resultex.anno.EnableResultEx;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author GuYue
 * @date 2022-03-02 14:25
 * @description: TODO
 */
//@ComponentScan(basePackages = "com.healt.cloud.checkup")
@EnableCheckupService
@EnableResultEx
@MapperScan("com.healt.cloud.checkup.*.mapper")
@SpringBootApplication
public class CheckUpAppliction {
    public static ApplicationContext checkUpApplicationContext;
    public static void main(String[] args) {
        //解决javax.xml.parsers.DocumentBuilderFactory.setFeature(Ljava/lang/String;Z)V异常
        System.setProperty("javax.xml.parsers.DocumentBuilderFactory", "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
        checkUpApplicationContext = SpringApplication.run(CheckUpAppliction.class, args);
    }
}
