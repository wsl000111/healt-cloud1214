package com.healt.cloud.checkup.config;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author GuYue
 * @date 2022-04-20 14:53
 * @description: 将标准日期、标准日期时间、时间戳转换成Date类型
 */
public class DateConverter implements Converter<String, Date> {

    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private static final String dateFormat2 = "yyyy/MM/dd HH:mm:ss";
    private static final String shortDateFormat = "yyyy-MM-dd";
    private static final String shortDateFormat2 = "yyyy/MM/dd";
    private static final String timeStampFormat = "^\\d+$";

    @Override
    public Date convert(String value) {

        System.out.println("value:"+value);
        if(value == null || value.trim().equals("") || value.equalsIgnoreCase("null")) {
            return null;
        }

        value = value.trim();
        try {
            if (value.contains("-")) {
                SimpleDateFormat formatter;
                if (value.contains(":")) {
                    formatter = new SimpleDateFormat(dateFormat);
                } else {
                    formatter = new SimpleDateFormat(shortDateFormat);
                }
                return formatter.parse(value);
            } else if (value.contains("/")) {
                SimpleDateFormat formatter;
                if (value.contains(":")) {
                    formatter = new SimpleDateFormat(dateFormat2);
                } else {
                    formatter = new SimpleDateFormat(shortDateFormat2);
                }
                return formatter.parse(value);
            } else if (value.matches(timeStampFormat)) {
                Long lDate = new Long(value);
                return new Date(lDate);
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format("parser %s to Date fail", value));
        }
        throw new RuntimeException(String.format("parser %s to Date fail", value));
    }
}
