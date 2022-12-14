package com.healt.cloud.checkup.appointmentReg.mapper;

import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.PersonCheckInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-04-16 17:27
 */
@Mapper
public interface PersonModifyResultStatusMapper {
    String selectPersonName(@Param("hospitalId") String hospitalId,@Param("personId") String personId);

    String selectResultStatus(@Param("hospitalId") String hospitalId,@Param("personId") String personId,@Param("personVisitId") Integer personVisitId);

    List<PersonCheckInfoVo> selectPersonCheckInfo(@Param("hospitalId") String hospitalId, @Param("personId") String personId, @Param("personVisitId") Integer personVisitId);

    void updateInChiefReport(@Param("hospitalId") String hospitalId,@Param("personId") String personId,@Param("personVisitId") Integer personVisitId);

    void deleteDiagnosisRecord(@Param("personId") String personId,@Param("personVisitId") Integer personVisitId);

    void updateResultStatus(@Param("hospitalId") String hospitalId,@Param("personId") String personId,@Param("personVisitId") Integer personVisitId);

    void updateResultStatusFinal(@Param("hospitalId") String hospitalId,@Param("personId") String personId,@Param("personVisitId") Integer personVisitId,@Param("finalDocoter") String finalDocoter,@Param("finalName") String finalName);
}
