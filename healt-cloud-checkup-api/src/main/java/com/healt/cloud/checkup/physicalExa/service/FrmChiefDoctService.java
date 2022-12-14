package com.healt.cloud.checkup.physicalExa.service;

import com.healt.cloud.checkup.entity.HcDeptResultDict;
import com.healt.cloud.checkup.entity.HcDeptResultItems;
import com.healt.cloud.checkup.entity.HcDiagnosisRecord;
import com.healt.cloud.checkup.physicalExa.vo.frmChiefDoct.*;
import com.healt.cloud.common.pages.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @author GuYue
 * @date 2022-05-26 0:16
 * @description: TODO
 */
public interface FrmChiefDoctService {

    String firstDocoter(String hospitalCode, String personId, String visitId);

    String autoFinishedSign(String hospitalCode, String personId, String visitId);

    List<Map<String, String>> getItemPackName(String hospitalCode, String personId, String visitId);

    String saveChiefDoctFirst(SaveChiefDoctFirstVo saveChiefDoctFirstVo);

    String saveChiefDoctFinal(SaveChiefDoctFinalVo saveChiefDoctFinalVo);

    PageResult<ChiefPersonVisitInfoVo> searchChiefDoct(SearchChiefDoctVo searchChiefDoctVo);

    List<ChiemItemStatusVo> chiemItemStatus(String hospitalId, String personId, String visitId);

    List<HcDeptResultDict> deptchiefaudit(String hospitalId, String personId, String visitId);

    List<HcDiagnosisRecord> dtDiagnosis(String hospitalId, String personId, String visitId);

    List<HcDeptResultItems> dtDeptResultItem(String hospitalId, String personId, String visitId);

    List<DtSuggestVo> dtSuggest(String hospitalId, String personId, String visitId);

    String dtContent(String hospitalId, String personId, String visitId);

    PageResult<UnitPersonInfoVo> findUnitPersonInfo(SearchUnitPersonInfoVo searchUnitPersonInfoVo);

    List<PersonHistoryInfoVo> getPersonHistory(String hospitalId, String perosnId);

    List<Map<String, String>> findGuideClass(String knowledgeType, String hospitalId);

    List<GuideInfoVo> findGuideInfo(String knowledgeType, String hospitalId);
}
