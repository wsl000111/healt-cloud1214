package com.healt.cloud.checkup.appointmentReg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.HcDeptResultItems;
import com.healt.cloud.checkup.entity.HcDiagnosisRecord;
import com.healt.cloud.checkup.appointmentReg.mapper.PersonModifyResultStatusMapper;
import com.healt.cloud.checkup.appointmentReg.service.PersonModifyResultStatusService;
import com.healt.cloud.checkup.entity.HcPersonVisitInfo;
import com.healt.cloud.checkup.service.HcDeptResultItemsService;
import com.healt.cloud.checkup.service.HcDiagnosisRecordService;
import com.healt.cloud.checkup.service.HcPersonVisitInfoService;

import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.PersonCheckInfoVo;
import com.healt.cloud.resultex.exception.CommonException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author linklee
 * @create 2022-04-16 17:25
 */
@Service
@AllArgsConstructor
public class PersonModifyResultStatusServiceImpl implements PersonModifyResultStatusService {

    private PersonModifyResultStatusMapper personModifyResultStatusMapper;

    private HcDeptResultItemsService hcDeptResultItemsService;

    private HcDiagnosisRecordService hcDiagnosisRecordService;

    private HcPersonVisitInfoService hcPersonVisitInfoService;

    @Override
    public String selectPersonName(String hospitalId, String personId) {
        String name = personModifyResultStatusMapper.selectPersonName(hospitalId,personId);
        if (name == null) {
            name = "";
        }
        return name;
    }

    @Override
    public String selectResultStatus(String hospitalId, String personId, Integer personVisitId) {
        String resultStatus = personModifyResultStatusMapper.selectResultStatus(hospitalId,personId,personVisitId);
        if (resultStatus == null) {
            resultStatus = "";
        }
        return resultStatus;
    }

    @Override
    public List<PersonCheckInfoVo> selectPersonCheckInfo(String hospitalId, String personId, Integer personVisitId) {
        List<PersonCheckInfoVo> list = personModifyResultStatusMapper.selectPersonCheckInfo(hospitalId,personId,personVisitId);
        if (list.size() == 0) {
            list.add(new PersonCheckInfoVo());
        }
        return list;
    }

    @Override
    @Transactional
    public String cancelFinalItemClick(String hospitalId, String personId, Integer personVisitId) {
//        UpdateWrapper<HcDeptResultItems> hcDeptResultItemsUpdateWrapper = new UpdateWrapper<>();
//        hcDeptResultItemsUpdateWrapper
//                .set("IN_CHIEF_REPORT", "0")
//                .eq("person_id", personId)
//                .eq("person_visit_id", personVisitId)
//                .eq("hospital_id", hospitalId);
//        if(!hcDeptResultItemsService.update(hcDeptResultItemsUpdateWrapper)){
//            throw new CommonException(500,"更新hc_dept_result_items的阳性诊断初始状态失败");
//        }

//        QueryWrapper<HcDiagnosisRecord> hcDiagnosisRecordQueryWrapper = new QueryWrapper<>();
//        hcDiagnosisRecordQueryWrapper.eq("person_id", personId);
//        hcDiagnosisRecordQueryWrapper.eq("person_visit_id", personVisitId);
//        if(!hcDiagnosisRecordService.remove(hcDiagnosisRecordQueryWrapper)){
//            throw new CommonException(500,"删除hc_diagnosis_record失败！");
//        }

        LambdaQueryWrapper<HcPersonVisitInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(HcPersonVisitInfo::getPersonId, personId)
                .eq(HcPersonVisitInfo::getPersonVisitId, personVisitId)
                .eq(HcPersonVisitInfo::getHospitalId, hospitalId);
        // 修改字段
        HcPersonVisitInfo newHcPersonVisitInfo = new HcPersonVisitInfo();
//        newHcPersonVisitInfo.setResultStatus("2");
        newHcPersonVisitInfo.setResultStatus("5");
        newHcPersonVisitInfo.setFinalDocoter("");
        newHcPersonVisitInfo.setFinalDate(null);
        newHcPersonVisitInfo.setFinalName("");

        if(!hcPersonVisitInfoService.update(newHcPersonVisitInfo,wrapper)){
            throw new CommonException(500, "更新hc_person_visit_info失败！");
        }
        return "取消终审成功";
    }

//    @Override
//    public void updateInChiefReport(String hospitalId, String personId, Integer personVisitId) {
//        personModifyResultStatusMapper.updateInChiefReport(hospitalId,personId,personVisitId);
//    }
//
//    @Override
//    public void deleteDiagnosisRecord(String personId, Integer personVisitId) {
//        personModifyResultStatusMapper.deleteDiagnosisRecord(personId,personVisitId);
//    }
//
//    @Override
//    public void updateResultStatus(String hospitalId, String personId, Integer personVisitId) {
//        personModifyResultStatusMapper.updateResultStatus(hospitalId,personId,personVisitId);
//    }

    @Override
    public void updateResultStatusFinal(String hospitalId, String personId, Integer personVisitId, String finalDocoter, String finalName) {
        personModifyResultStatusMapper.updateResultStatusFinal(hospitalId,personId,personVisitId,finalDocoter,finalName);
    }
}
