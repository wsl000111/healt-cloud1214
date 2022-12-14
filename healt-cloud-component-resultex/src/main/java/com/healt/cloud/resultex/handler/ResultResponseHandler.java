package com.healt.cloud.resultex.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.healt.cloud.common.http.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.LinkedHashMap;

/**
 * @author GuYue
 * @date 2022-02-25 15:42
 * @description: 统一响应切面
 */
@Slf4j
@RestControllerAdvice
public class ResultResponseHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        //springfox.documentation.swagger2.web.Swagger2Controller接口不进行拦截，不做异常处理
        return !methodParameter.getDeclaringClass().getName().equalsIgnoreCase("springfox.documentation.swagger2.web.Swagger2Controller");
    }

    // 参数o 代表其实就是springmvc的请求的方法的结果
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        log.info("统一处理返回");
        // 对请求的结果在这里统一返回和处理
        if (o instanceof ErrorHandler) {
            // 1、如果返回的结果是一个异常的结果
            ErrorHandler errorHandler = (ErrorHandler) o;
            log.error("异常信息："+errorHandler.getMsg());
            return HttpResult.error(errorHandler.getCode(), errorHandler.getMsg());
        } else if (o instanceof String) {
            try {
                // 2、因为springmvc数据转换器对String是有特殊处理 StringHttpMessageConverter
                ObjectMapper objectMapper = new ObjectMapper();
                HttpResult r = HttpResult.ok(o);
                log.info("SUCCESS");
                //log.info(r.toString());
                return objectMapper.writeValueAsString(r);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (o instanceof LinkedHashMap){
            LinkedHashMap linkedHashMap = (LinkedHashMap) o;
            if(linkedHashMap.get("status").toString().equals("404")){
                log.error("异常信息："+linkedHashMap.get("status").toString()+":"+linkedHashMap.get("path").toString());
                return HttpResult.error(404, linkedHashMap.get("path").toString());
            }
        }
        log.info("SUCCESS");
        return HttpResult.ok(o);
    }
}
