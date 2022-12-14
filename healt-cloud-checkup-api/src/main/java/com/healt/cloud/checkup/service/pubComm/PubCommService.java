package com.healt.cloud.checkup.service.pubComm;

import com.healt.cloud.checkup.entity.HcItemReportWriteDict;
import com.healt.cloud.checkup.entity.HcPersonAppregItems;
import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.PersonItemsVo;
import com.healt.cloud.checkup.vo.pubComm.PersonVisitAndInfoVo;
import com.healt.cloud.checkup.vo.pubComm.InterfaceSourceVo;
import com.healt.cloud.checkup.vo.pubComm.PublicDictVo;

import java.sql.Connection;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-03 9:31
 */
public interface PubCommService {

    List<InterfaceSourceVo> findItemExternalInterface(String hospitalId, String itemPackCode);

    List<PublicDictVo> findPublicDict(String dictType);

    String findPersonMaxVisit(String hospitalId, String personId);

    String findUnitMaxVisit(String hospitalId, String unitId);

    String findExamNoForItem(String hospitalId, String itemPackCode);

    String findTestNoForItem(List<PersonItemsVo> personItemsVos, String hospitalId, String itemPackCode);

    String sendExamApply(List<Connection> connList, List<PersonItemsVo> personItemsVos, String userName);

    List<PersonVisitAndInfoVo> findPersonInfo(String hospitalId, String personId, String personVisitId);

    String sendLabApply(List<Connection> connList, List<PersonItemsVo> personItemsVos, String userName);

    void deleteApply(List<Connection> connList, List<PersonItemsVo> dsItemList);

    String deleteExamOrLabApply(List<Connection> connList, HcPersonAppregItems item, String itemClass);

    List<HcItemReportWriteDict> findHcItemReportWriteDict(HcItemReportWriteDict hcItemReportWriteDict);

    List<Connection> getConnects(String hospitalId, String sourceId);
}
