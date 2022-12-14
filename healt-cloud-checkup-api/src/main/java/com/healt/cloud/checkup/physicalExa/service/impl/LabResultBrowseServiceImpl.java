package com.healt.cloud.checkup.physicalExa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.HcDeptResultDict;
import com.healt.cloud.checkup.entity.InterfaceSource;
import com.healt.cloud.checkup.mapper.appointmentReg.LabResultBrowseMapper;
import com.healt.cloud.checkup.physicalExa.vo.*;
import com.healt.cloud.checkup.service.HcDeptResultDictService;
import com.healt.cloud.checkup.physicalExa.service.LabResultBrowseService;
import com.healt.cloud.checkup.vo.member.PackVsItemsVo;
import com.healt.cloud.checkup.physicalExa.vo.saveVo.SaveHcDeptResultDictListVo;
import com.healt.cloud.checkup.physicalExa.vo.saveVo.SaveHcDeptResultDictVo;
import com.healt.cloud.common.pages.PageResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linklee
 * @create 2022-05-20 10:54
 */
@Service
@AllArgsConstructor
public class LabResultBrowseServiceImpl implements LabResultBrowseService {

    private LabResultBrowseMapper labResultBrowseMapper;

    private HcDeptResultDictService hcDeptResultDictService;

    @Override
    public List<InterfaceSource> findHisConnStr(String hospitalId) {
        List<InterfaceSource> list = labResultBrowseMapper.findHisConnStr(hospitalId);
        if (list.size() == 0) {
            list.add(new InterfaceSource());
        }
        return list;
    }

    @Override
    public PageResult findPersonListPage(PersonListDictVo personListDictVo) {
        List<PersonListVo> listTotal = labResultBrowseMapper.findPersonListTotal(personListDictVo.getHospitalId(),
                personListDictVo.getUnitId(),personListDictVo.getUnitVisitId(),personListDictVo.getPersonId(),
                personListDictVo.getPersonVisitId(),personListDictVo.getName());
        int totalSize = listTotal.size();

        List<PersonListVo> list = labResultBrowseMapper.findPersonList(personListDictVo.getHospitalId(),
                personListDictVo.getUnitId(),personListDictVo.getUnitVisitId(),personListDictVo.getPersonId(),
                personListDictVo.getPersonVisitId(),personListDictVo.getName(),personListDictVo.getPageNum(),
                personListDictVo.getPageSize());
        if (list.size() == 0) {
            list.add(new PersonListVo());
        }
        int totalPages = totalSize%personListDictVo.getPageSize() == 0 ? totalSize / personListDictVo.getPageSize() : totalSize / personListDictVo.getPageSize() + 1;
        PageResult result = new PageResult<PersonListVo>(personListDictVo.getPageNum(), personListDictVo.getPageSize(), totalSize, totalPages, list);
        return result;
    }

    @Override
    public List<LabTestMasterVo> findLabTestMaster(String txzbl) {
        List<LabTestMasterVo> list = labResultBrowseMapper.findLabTestMaster(txzbl);
        if (list.size() == 0) {
            list.add(new LabTestMasterVo());
        }
        return list;
    }

    @Override
    public List findResultHandle(String hospitalId, String itemPackCode) {
        String result = labResultBrowseMapper.findResultHandle(hospitalId,itemPackCode);
        if (result == null) {
            result = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("result_handle",result);
        list.add(map);
        return list;
    }

    @Override
    public List<UnitVisitVo> findUnitVisit(String hospitalId, String personId, Integer personVisitId) {
        List<UnitVisitVo> list = labResultBrowseMapper.findUnitVisit(hospitalId,personId,personVisitId);
        if (list.size() == 0) {
            list.add(new UnitVisitVo());
        }
        return list;
    }

    @Override
    public List<DoctorNoteVo> findDoctorNote(String testNo) {
        List<DoctorNoteVo> list = labResultBrowseMapper.findDoctorNote(testNo);
        if (list.size() == 0) {
            list.add(new DoctorNoteVo());
        }
        return list;
    }

    @Override
    @Transactional
    public void saveDeptResultDict(SaveHcDeptResultDictListVo saveHcDeptResultDictList) {
        for (SaveHcDeptResultDictVo saveHcDeptResultDictVo : saveHcDeptResultDictList.getSaveHcDeptResultDict()) {
            switch (saveHcDeptResultDictVo.getStat()) {
                case "delete" :
                    for (HcDeptResultDict hcDeptResultDict : saveHcDeptResultDictVo.getHcDeptResultDict()) {
                        QueryWrapper<HcDeptResultDict> queryWrapper = new QueryWrapper<>();
                        hcDeptResultDictService.remove(queryWrapper);
                    }
                    break;
                case "add" :
                    for (HcDeptResultDict hcDeptResultDict: saveHcDeptResultDictVo.getHcDeptResultDict()) {
                        QueryWrapper<HcDeptResultDict> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("HOSPITAL_ID", hcDeptResultDict.getHospitalId());
                        queryWrapper.eq("PERSON_ID", hcDeptResultDict.getPersonId());
                        queryWrapper.eq("PERSON_VISIT_ID", hcDeptResultDict.getPersonVisitId());
                        queryWrapper.eq("DEPT_ID", hcDeptResultDict.getDeptId());
                        hcDeptResultDictService.remove(queryWrapper);
                        hcDeptResultDictService.save(hcDeptResultDict);
                        if (saveHcDeptResultDictVo.getResStatus() < 2) {
                            labResultBrowseMapper.updateHcPersonVisitInfo(hcDeptResultDict.getPersonId(),hcDeptResultDict.getPersonVisitId());
                        }
                    }
                    break;
                case "update" :
                    for (HcDeptResultDict hcDeptResultDict : saveHcDeptResultDictVo.getHcDeptResultDict()) {
                        UpdateWrapper<HcDeptResultDict> updateWrapper = new UpdateWrapper<>();
                        hcDeptResultDictService.update(hcDeptResultDict,updateWrapper);
                    }
                    break;
            }
        }
    }

    @Override
    public List<LabResultVo> findLabResult(String testNo) {
        List<LabResultVo> list = labResultBrowseMapper.findLabResult(testNo);
        if (list.size() == 0) {
            list.add(new LabResultVo());
        }
        return list;
    }

    @Override
    public List<PackVsItemsVo> findPackVsItems(String hospitalId, String itemPackCode) {
        List<PackVsItemsVo> list = labResultBrowseMapper.findPackVsItems(hospitalId,itemPackCode);
        if (list.size() == 0) {
            list.add(new PackVsItemsVo());
        }
        return list;
    }

    @Override
    public List<ItemVsExternalVo> findItemVsExternal(String hospitalId, String hcItemCode) {
        List<ItemVsExternalVo> list = labResultBrowseMapper.findItemVsExternal(hospitalId,hcItemCode);
        if (list.size() == 0) {
            list.add(new ItemVsExternalVo());
        }
        return list;
    }

    @Override
    public List<LabResult1Vo> findLabResult1(String testNo) {
        List<LabResult1Vo> list = labResultBrowseMapper.findLabResult1(testNo);
        if (list.size() == 0) {
            list.add(new LabResult1Vo());
        }
        return list;
    }

    @Override
    public List<HcResultVo> findHcResult(HcResultDictVo hcResultDictVo) {
        List<HcResultVo> list = labResultBrowseMapper.findHcResult(hcResultDictVo.getHcDeptCode(),
                hcResultDictVo.getHospitalId(),hcResultDictVo.getPersonId(),hcResultDictVo.getPersonVisitId(),
                hcResultDictVo.getItemAssemCode());
        if (list.size() == 0) {
            list.add(new HcResultVo());
        }
        return list;
    }

    @Override
    public List<HcDeptResultItemsVo> findHcDeptResultItems(String hospitalId,String personId, Integer personVisitId, String deptId, String packCode) {
        List<HcDeptResultItemsVo> list = labResultBrowseMapper.findHcDeptResultItems(hospitalId,personId,personVisitId,deptId,packCode);
        if (list.size() == 0) {
            list.add(new HcDeptResultItemsVo());
        }
        return list;
    }

    @Override
    public List<HcAppregItemsVo> findHcAppregItems(String hospitalId, String personId, Integer personVisitId, String className) {
        List<HcAppregItemsVo> list = labResultBrowseMapper.findHcAppregItems(hospitalId,personId,personVisitId,className);
        if (list.size() == 0) {
            list.add(new HcAppregItemsVo());
        }
        return list;
    }

    @Override
    public List<HcAppregItems1Vo> findHcAppregItems1(String hospitalId, String personId, Integer personVisitId, String itemPackCode) {
        List<HcAppregItems1Vo> list = labResultBrowseMapper.findHcAppregItems1(hospitalId,personId,personVisitId,itemPackCode);
        if (list.size() == 0) {
            list.add(new HcAppregItems1Vo());
        }
        return list;
    }

    @Override
    public List<DeptResultItemsVo> findDeptResultItems(String hospitalId,String personId, Integer personVisitId, String deptId) {
        List<DeptResultItemsVo> list = labResultBrowseMapper.findDeptResultItems(hospitalId,personId,personVisitId,deptId);
        if (list.size() == 0) {
            list.add(new DeptResultItemsVo());
        }
        return list;
    }

    @Override
    public List<VLabResultVo> findVLabResult(String testNo) {
        List<VLabResultVo> list = labResultBrowseMapper.findVLabResult(testNo);
        if (list.size() == 0) {
            list.add(new VLabResultVo());
        }
        return list;
    }

}
