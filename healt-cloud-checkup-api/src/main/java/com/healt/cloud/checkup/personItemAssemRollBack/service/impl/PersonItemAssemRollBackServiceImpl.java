package com.healt.cloud.checkup.personItemAssemRollBack.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.service.*;
import com.healt.cloud.checkup.personItemAssemRollBack.service.PersonItemAssemRollBackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author GuYue
 * @date 2022-07-13 11:06
 * @description: TODO
 */
@Service
@AllArgsConstructor
public class PersonItemAssemRollBackServiceImpl implements PersonItemAssemRollBackService {

    private HcResultDictService hcResultDictService;

    private HcDeptResultDictService hcDeptResultDictService;

    private HcDeptResultItemsService hcDeptResultItemsService;

    private HcDiagnosisRecordService hcDiagnosisRecordService;

    private HcPersonAppregItemsService hcPersonAppregItemsService;

    @Override
    public void itemAssemRollback(String hospitalId, String personId, String personVisitId, String deptId) {
        //    select * from hc_result_dict a
//    where a.hospital_id ='0001' and a.person_id ='2109140010' and a.person_visit_id ='1' and a.dept_id ='10' ; -- 按此条件删除 hc_result_dict
        QueryWrapper<HcResultDict> hcResultDictQueryWrapper = new QueryWrapper<>();
        hcResultDictQueryWrapper.eq("hospital_id", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", personVisitId)
                .eq("dept_id", deptId);
        hcResultDictService.remove(hcResultDictQueryWrapper);

//    select * from hc_dept_result_dict a
//    where a.hospital_id ='0001' and a.person_id ='2109140010' and a.person_visit_id ='1' and a.dept_id ='10' ; -- 按此条件删除 hc_dept_result_dict
        QueryWrapper<HcDeptResultDict> hcDeptResultDictQueryWrapper = new QueryWrapper<>();
        hcDeptResultDictQueryWrapper.eq("hospital_id", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", personVisitId)
                .eq("dept_id", deptId);
        hcDeptResultDictService.remove(hcDeptResultDictQueryWrapper);
//    select * from hc_dept_result_items a
//    where a.hospital_id ='0001' and a.person_id ='2109140010' and a.person_visit_id ='1' and a.dept_id ='10' ; -- 按此条件删除 hc_dept_result_items
        QueryWrapper<HcDeptResultItems> hcDeptResultItemsQueryWrapper = new QueryWrapper<>();
        hcDeptResultItemsQueryWrapper.eq("hospital_id", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", personVisitId)
                .eq("dept_id", deptId);
        hcDeptResultItemsService.remove(hcDeptResultItemsQueryWrapper);
//    select * from hc_diagnosis_record  a
//    where a.hospital_id ='0001' and a.person_id ='2109140010' and a.person_visit_id ='1' and a.dept_id ='10' ; -- 按此条件删除hc_diagnosis_record
        QueryWrapper<HcDiagnosisRecord> hcDiagnosisRecordQueryWrapper = new QueryWrapper<>();
        hcDiagnosisRecordQueryWrapper.eq("hospital_id", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", personVisitId)
                .eq("dept_id", deptId);
        hcDiagnosisRecordService.remove(hcDiagnosisRecordQueryWrapper);
//    update hc_person_appreg_items set  a.finished_sign = '未完成'
//    where a.hospital_id ='0001' and a.person_id ='2109140010' and a.person_visit_id ='1' and a.dept_id ='10' ;-- 按此条件更新hc_person_appreg_items 状态为 未完成
        UpdateWrapper<HcPersonAppregItems> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("hospital_id", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", personVisitId)
                .eq("dept_id", deptId);
        updateWrapper.set("finished_sign", "未完成");
        hcPersonAppregItemsService.update(updateWrapper);
    }
}
