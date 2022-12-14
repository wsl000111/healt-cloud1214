package com.healt.cloud.common.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author GuYue
 * @date 2022-05-07 11:02
 * @description: Durid连接池工具类
 */
public class DruidUtils {

    public static Map<String, DataSource> dataSourceMap = new HashMap<>();

//    static {
//        try {
//            //1. 加载durid.properties 配置文件
//            InputStream is = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
//            Properties properties = new Properties();
//            properties.load(is);
//            //2。 创建durid连接池
//            dataSource = DruidDataSourceFactory.createDataSource(properties);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    //            driverClassName= oracle.jdbc.OracleDriver
    //            url= jdbc:oracle:thin:@192.168.0.33:1523/tlkq
    //            username= system
    //            password= manager
    public static Connection getConnection(String serviceName, String userName, String password) {
        try{
            String sourceKey = serviceName + userName + password;
            DataSource ds = dataSourceMap.get(sourceKey);
            if(ds == null){
                Properties properties = new Properties();
                properties.setProperty("driverClassName", "oracle.jdbc.OracleDriver");
                String url = "jdbc:oracle:thin:@" + serviceName;
                properties.setProperty("url", url);
                properties.setProperty("username", userName);
                properties.setProperty("password", password);
                properties.setProperty("max-active", "100");
                properties.setProperty("initial-size", "1");
                properties.setProperty("maxWait", "6000");
                properties.setProperty("minIdle", "1");
                properties.setProperty("timeBetweenEvictionRunsMillis", "70000");
                properties.setProperty("minEvictableIdleTimeMillis", "300000");
                properties.setProperty("testWhileIdle", "true");
                properties.setProperty("validationQuery", "select '*' from dual");
                properties.setProperty("testWhileIdle", "true");
                properties.setProperty("testOnBorrow", "false");
                properties.setProperty("testOnReturn", "false");
                properties.setProperty("poolPreparedStatements", "true");
                properties.setProperty("maxOpenPreparedStatements", "50");
                properties.setProperty("maxPoolPreparedStatementPerConnectionSize", "20");
                properties.setProperty("breakAfterAcquireFailure", "true");
                properties.setProperty("connectionErrorRetryAttempts", "1");
                ds = DruidDataSourceFactory.createDataSource(properties);
                dataSourceMap.put(sourceKey, ds);
            }
            return ds.getConnection();
        } catch (Exception e){
            dataSourceMap.clear();
            return null;
        }
    }
}
