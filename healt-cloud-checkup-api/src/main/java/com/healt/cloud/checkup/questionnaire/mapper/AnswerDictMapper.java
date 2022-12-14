package com.healt.cloud.checkup.questionnaire.mapper;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

/**
 * @author linklee
 * @create 2022-06-10 14:35
 */
@Mapper
public interface AnswerDictMapper {

    Integer findMaxAnswerCode(@Param("hospitalId") String hospitalId,@Param("investCode") String investCode,@Param("questionCode") String questionCode);
}
