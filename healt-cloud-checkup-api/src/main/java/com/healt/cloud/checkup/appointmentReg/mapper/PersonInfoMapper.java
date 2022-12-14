package com.healt.cloud.checkup.appointmentReg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author GuYue
 * @date 2022-03-22 9:59
 * @description: TODO
 */
@Mapper
public interface PersonInfoMapper {

    public String findPeId(@Param("hospitalCode") String hospitalCode);

    @Select("select max(t.person_visit_id) from hc_person_visit_info t where t.patient_id = #{patientId}")
    public Integer findMaxVisitId(String patientId);

}
