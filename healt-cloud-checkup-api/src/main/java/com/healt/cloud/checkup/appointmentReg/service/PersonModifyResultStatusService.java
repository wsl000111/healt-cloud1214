package com.healt.cloud.checkup.appointmentReg.service;

import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.PersonCheckInfoVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-04-16 17:25
 */
public interface PersonModifyResultStatusService {
    public String selectPersonName(String hospitalId, String personId);

    public String selectResultStatus(String hospitalId, String personId, Integer personVisitId);

    public List<PersonCheckInfoVo> selectPersonCheckInfo(String hospitalId, String personId, Integer personVisitId);

//    public void updateInChiefReport(String hospitalId, String personId, Integer personVisitId);
//
//    public void deleteDiagnosisRecord(String personId, Integer personVisitId);
//
//    public void updateResultStatus(String hospitalId, String personId, Integer personVisitId);

    public String cancelFinalItemClick(String hospitalId, String personId, Integer personVisitId);

    public void updateResultStatusFinal(String hospitalId, String personId, Integer personVisitId, String finalDocoter, String finalName);

}
