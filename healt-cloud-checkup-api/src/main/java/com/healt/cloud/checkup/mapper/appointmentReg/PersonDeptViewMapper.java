package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.queryReport.vo.DiagnosisRecordVo;
import com.healt.cloud.checkup.queryReport.vo.PersonDeptInfoDictVo;
import com.healt.cloud.checkup.queryReport.vo.PersonDeptInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-29 9:16
 */
@Mapper
public interface PersonDeptViewMapper {

    List<PersonDeptInfoVo> findPersonDeptInfoTotal(PersonDeptInfoDictVo personDeptInfoDictVo);

    List<PersonDeptInfoVo> findPersonDeptInfo(PersonDeptInfoDictVo personDeptInfoDictVo);

    List<DiagnosisRecordVo> findDiagnosisRecord(@Param("hospitalId") String hospitalId, @Param("personId") String personId, @Param("personVisitId") String personVisitId);

}
