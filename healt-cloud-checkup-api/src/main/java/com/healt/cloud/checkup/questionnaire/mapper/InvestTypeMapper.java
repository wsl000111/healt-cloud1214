package com.healt.cloud.checkup.questionnaire.mapper;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

/**
 * @author linklee
 * @create 2022-06-13 9:55
 */
@Mapper
public interface InvestTypeMapper {

    Integer findMaxInvestCode(@Param("hospitalId") String hospitalId);

}
