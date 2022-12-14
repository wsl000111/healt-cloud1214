package com.healt.cloud.web.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author GuYue
 * @date 2022-09-14 15:23
 * @description: TODO
 */
public class JSONUtils<T> {
    public static ObjectMapper objectMapper = new ObjectMapper();
    public static String bean2Json(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public static <T> T json2Bean(String jsonStr, Class<T> tClass) throws JsonProcessingException {
        return objectMapper.readValue(jsonStr, tClass);
    }
}
