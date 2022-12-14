package com.healt.cloud.checkup.queryReport.service.impl;

import com.healt.cloud.checkup.mapper.appointmentReg.PersonDeptViewMapper;
import com.healt.cloud.checkup.queryReport.service.PersonDeptViewService;
import com.healt.cloud.checkup.queryReport.vo.DiagnosisRecordVo;
import com.healt.cloud.checkup.queryReport.vo.PersonDeptInfoDictVo;
import com.healt.cloud.checkup.queryReport.vo.PersonDeptInfoVo;
import com.healt.cloud.common.pages.PageResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-29 9:15
 */
@Service
@AllArgsConstructor
public class PersonDeptViewServiceImpl implements PersonDeptViewService {

    private PersonDeptViewMapper personDeptViewMapper;


    @Override
    public PageResult findPersonDeptInfo(PersonDeptInfoDictVo personDeptInfoDictVo) {
        List<PersonDeptInfoVo> listTotal = personDeptViewMapper.findPersonDeptInfoTotal(personDeptInfoDictVo);
        int totalSize = listTotal.size();

        List<PersonDeptInfoVo> list = personDeptViewMapper.findPersonDeptInfo(personDeptInfoDictVo);
        if (list.size() == 0) {
            list.add(new PersonDeptInfoVo());
        }
        int totalPages = totalSize%personDeptInfoDictVo.getPageSize() == 0 ? totalSize / personDeptInfoDictVo.getPageSize() : totalSize / personDeptInfoDictVo.getPageSize() + 1;
        PageResult result = new PageResult<PersonDeptInfoVo>(personDeptInfoDictVo.getPageNum(), personDeptInfoDictVo.getPageSize(), totalSize, totalPages, list);
        return result;
    }

    @Override
    public List<DiagnosisRecordVo> findDiagnosisRecord(String hospitalId, String personId, String personVisitId) {
        List<DiagnosisRecordVo> list = personDeptViewMapper.findDiagnosisRecord(hospitalId,personId,personVisitId);
        if (list.size() == 0) {
            list.add(new DiagnosisRecordVo());
        }
        return list;
    }
}
