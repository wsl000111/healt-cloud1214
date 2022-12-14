package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

/**
 * @author GuYue
 * @date 2022-07-01 11:50
 * @description: TODO
 */
@Mapper
public interface MyWebServiceLogMapper {

    @Update("INSERT INTO WEBSERVICE_LOG ( INSERT_DATE, DATA_STR, DATA_TYPE, METHOD, UUID ) VALUES ( #{insertDate}, #{dataStr}, #{dataType}, #{method}, #{uuid} )")
    void saveLog(Date insertDate, String dataStr, String dataType, String method, String uuid);
}
