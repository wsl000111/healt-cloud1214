package com.healt.cloud.checkup.appointmentReg.service;

import com.healt.cloud.checkup.appointmentReg.vo.finishedSign.FinishedSignPerson;
import com.healt.cloud.checkup.appointmentReg.vo.finishedSign.FinishedSignPersonByWherePageVo;
import com.healt.cloud.checkup.appointmentReg.vo.finishedSign.SaveFinishedSignListVo;
import com.healt.cloud.common.pages.PageResult;

/**
 * @author linklee
 * @create 2022-04-18 9:52
 */
public interface FinishedSignService {

    PageResult<FinishedSignPerson> findPersonByWherePage(FinishedSignPersonByWherePageVo finishedSignPersonByWherePageVo);

    String saveFinishedSignList(SaveFinishedSignListVo saveFinishedSignListVo);

    String findResultStatus(String hospitalId, String personId, String personVisitId);

    void updateFinshedSignRefusal(String hospitaId, String personId, String personVisitId, String itemPackCode, String itemNo, String editerId, String editerName);

    void updateFinshedSignCancelRefusal(String hospitaId, String personId, String personVisitId, String itemPackCode, String itemNo, String editerId, String editerName);
}
