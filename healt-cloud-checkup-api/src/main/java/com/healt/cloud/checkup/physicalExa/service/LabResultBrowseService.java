package com.healt.cloud.checkup.physicalExa.service;

import com.healt.cloud.checkup.entity.InterfaceSource;
import com.healt.cloud.checkup.physicalExa.vo.*;
import com.healt.cloud.checkup.vo.member.PackVsItemsVo;
import com.healt.cloud.checkup.physicalExa.vo.saveVo.SaveHcDeptResultDictListVo;
import com.healt.cloud.common.pages.PageResult;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-20 10:54
 */
public interface LabResultBrowseService {

    public List<InterfaceSource> findHisConnStr(String hospitalId);

    public PageResult findPersonListPage(PersonListDictVo personListDictVo);

    public List<LabTestMasterVo> findLabTestMaster(String txzbl);

    public List findResultHandle(String hospitalId, String itemPackCode);

    public List<UnitVisitVo> findUnitVisit(String hospitalId, String personId, Integer personVisitId);

    public List<DoctorNoteVo> findDoctorNote(String testNo);

    public void saveDeptResultDict(SaveHcDeptResultDictListVo saveHcDeptResultDictList);

    public List<LabResultVo> findLabResult(String testNo);

    public List<PackVsItemsVo> findPackVsItems(String hospitalId, String itemPackCode);

    public List<ItemVsExternalVo> findItemVsExternal(String hospitalId, String hcItemCode);

    public List<LabResult1Vo> findLabResult1(String testNo);

    public List<HcResultVo> findHcResult(HcResultDictVo hcResultDictVo);

    public List<HcDeptResultItemsVo> findHcDeptResultItems(String hospitalId,String personId, Integer personVisitId, String deptId, String packCode);

    public List<HcAppregItemsVo> findHcAppregItems(String hospitalId, String personId, Integer personVisitId, String className);

    public List<HcAppregItems1Vo> findHcAppregItems1(String hospitalId, String personId, Integer personVisitId, String itemPackCode);

    public List<DeptResultItemsVo> findDeptResultItems(String hospitalId,String personId, Integer personVisitId, String deptId);

    public List<VLabResultVo> findVLabResult(String testNo);
}
