package com.healt.cloud.checkup.questionnaire.mapper;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

/**
 * @author linklee
 * @create 2022-06-10 14:34
 */
@Mapper
public interface QuestionDictMapper {

    Integer findMaxQuestionCode(@Param("hospitalId") String hospitalId,@Param("investCode") String investCode);
}
