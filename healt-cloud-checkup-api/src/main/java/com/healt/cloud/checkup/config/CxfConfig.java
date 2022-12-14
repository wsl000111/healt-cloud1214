package com.healt.cloud.checkup.config;

import com.healt.cloud.checkup.service.ws.server.HealthCheckUpWebServiceSoapImpl;
import com.healt.cloud.checkup.service.ws.server.impl.HealthCheckUpWebServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @author GuYue
 * @date 2022-07-22 20:46
 * @description: TODO
 */
@Configuration
public class CxfConfig {

    @Bean
    public ServletRegistrationBean disServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new CXFServlet(), "/webService/*");
        return servletRegistrationBean;
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus(){
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint(){
        //EndpointImpl endpoint = new EndpointImpl(springBus(), new HealthCheckUpWebServiceImpl());
        EndpointImpl endpoint = new EndpointImpl(springBus(), new HealthCheckUpWebServiceSoapImpl());
        endpoint.publish("/HealthCheckUpWebService");
        return endpoint;
    }
}
