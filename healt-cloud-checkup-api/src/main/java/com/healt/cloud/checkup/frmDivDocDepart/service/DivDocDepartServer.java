package com.healt.cloud.checkup.frmDivDocDepart.service;

import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.frmDivDocDepart.vo.*;
import com.healt.cloud.common.pages.PageResult;

import java.util.Date;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-05-22 21:34
 * @description: TODO
 */
public interface DivDocDepartServer {

    List<ValidateRightVo> validateRight(String hospitalId, String userId);

    String saveDivDocDepart(SaveDivDocDepartVo saveDivDocDeprtVo);

    PageResult<FrmGetPersonVoRsp> findPerson(FrmGetPersonVo frmGetPersonVo);

    PageResult<FrmGetUnitPersonVoRsp> findUnitPerson(FrmGetUnitPersonVo frmGetUnitPersonVo);

    List<FrmGetPersonVoRsp> findGetPersonHistory(String hospitalId, String personId, String deptId);

    String findWorkInfo(String deptId, String value1, String value2);

    List<FrmPackVsItems> findPackVsItems(String hospitalId, String itemPackCode);

    List<FrmPackItems> findPackItems(String hospitalId);

    List<FrmItemVsExternal> findItemVsExternal(String hospitalId, String itemCode);

    List<FrmLabResultVo> findLabResult(String testNoList);

    List<FrmLabResultVo> findLabResultOut(String hospitalId, String sourceId, String testNoList);

    List<InterfaceSource> getHisConnStr(String hospitalId);

    List<HcDeptResultItems> findHcDeptResultItems(String hospitalId, String personId, String personVisitId, String deptId, String packCode, String relation);

    List<HcDeptResultDict> findHcDeptResult(String hospitalId, String personId, String personVisitId, String deptId);

    List<HcDeptResultItems> findDeptResultItems(String hospitalId, String personId, String personVisitId, String deptId);

    int countHcPersonAppregItems(String personId, String personVisitId, String finishedSign);

    List<DeptNameListVo> findDeptNameList(String hospitalId, String deptId);

    List<ResultStatusListVo> findResultStatusList(String personId, String personVisitId);

    List<FrmGetHcAppregItem> findHcAppregItem(String hospitalId, String personId, String personVisitId, String packCode);

    List<InitDeptVo> initDept(String userName);

    List<InitDoctorVo> initDoctor(String hospitalId, String deptId);

    List<FrmSetDivSourceVoRes> setDivSource(String hospitalId, String deptId, String personId, String visitId);

    String findResultStatus(String hospitalId, String personId, String visitId);

    Date findBeforeDate(String hospitalId, String personId, String visitId);

    int findItemsCount(String hospitalId, String personId, String visitId, String deptCode);

    List<HcPersonVisitInfo> findHcPersonVisitInfo(String hospitalId, String personId, String visitId);

    List<HcPersonInfo> findHcPersonInfo(String hospitalId, String personId);

    String findClassName(String hospitalId, String deptId);

    int findCountApply(String hospitalId, String deptId, String personId, String visitId);

    int findCountSettle(String hospitalId, String personId, String visitId, String deptCode);

    List<SetPersonInfoVo> findSetPersonInfo(String hospitalId, String personId, String visitId);

    List<HcDeptResultDict> findDeptResult(String personId, String visitId, String deptId);

    List<GetHcResultVo> findHcResult(String hospitalId, String personId, String visitId, String packCode, String deptId);

    List<HcAppregItemsVo> findHcAppregItems(String hospitalId, String personId, String visitId, String deptClass);

    List<VLabTestMaster> findVLabTestMaster(String testNo);

    String findResultHandle(String hospitalId, String itemPackCode);

    String findUpdateConclusion(String hospitalId, String hcDeptCode);

    int importLabResult(String hospitalId, String applyNo, String personId, int personVisitId, String itemPackCode, String doctorName, String ext_sys_code);

    String loadImportLabResult(LoadLabVo loadLabVo);

    String loadImportExamResult(LoadExamVo loadExamVo);

    List<LoadDeptDictVo> loadDeptDict(String hospitalId);

    List<DeptDiseaseGroupVo> getDeptDiseaseGroup(String hospitalId, String deptId);

    List<HcDiseaseDict> getHcDiseaseDict(String hospitalId, String diseaseCode, String deptId);

}
