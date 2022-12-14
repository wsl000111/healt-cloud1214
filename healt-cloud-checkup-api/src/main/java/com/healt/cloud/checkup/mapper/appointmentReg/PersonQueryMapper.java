package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.queryReport.vo.PersonQueryDictVo;
import com.healt.cloud.checkup.queryReport.vo.PersonQueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-26 10:30
 */
@Mapper
public interface PersonQueryMapper {

    List<PersonQueryVo> findPersonQueryTotal(PersonQueryDictVo personQueryDictVo);

    List<PersonQueryVo> findPersonQuery(PersonQueryDictVo personQueryDictVo);
}
