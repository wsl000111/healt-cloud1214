package com.healt.cloud.checkup.physicalExa.service.impl;

import com.healt.cloud.checkup.mapper.appointmentReg.ExamResultBrowseMapper;
import com.healt.cloud.checkup.physicalExa.service.ExamResultBrowseService;
import com.healt.cloud.checkup.physicalExa.vo.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linklee
 * @create 2022-05-25 11:26
 */
@Service
@AllArgsConstructor
public class ExamResultBrowseServiceImpl implements ExamResultBrowseService {

    private ExamResultBrowseMapper examResultBrowseMapper;

    @Override
    public List<HcDeptResultVo> findHcDeptResult(HcDeptResultDictVo hcDeptResultDictVo) {
        List<HcDeptResultVo> list = examResultBrowseMapper.findHcDeptResult(hcDeptResultDictVo);
        if (list.size() == 0) {
            list.add(new HcDeptResultVo());
        }
        return list;
    }

    @Override
    public List findExamMasterCount(String examNo) {
        String count = examResultBrowseMapper.findExamMasterCount(examNo);
        if (count == null) {
            count = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("count(*)",count);
        list.add(map);
        return list;
    }

    @Override
    public List findExamReportCount(String examNo) {
        String count = examResultBrowseMapper.findExamReportCount(examNo);
        if (count == null) {
            count = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("count(*)",count);
        list.add(map);
        return list;
    }

    @Override
    public List<ExamReportVo> findExamReport(String examNo) {
        List<ExamReportVo> list = examResultBrowseMapper.findExamReport(examNo);
        if (list.size() == 0) {
            list.add(new ExamReportVo());
        }
        return list;
    }

    @Override
    public List<ExamMasterReporterVo> findExamMasterReporter(String examNo) {
        List<ExamMasterReporterVo> list = examResultBrowseMapper.findExamMasterReporter(examNo);
        if (list.size() == 0) {
            list.add(new ExamMasterReporterVo());
        }
        return list;
    }

    @Override
    public List<ExamMasterVo> findExamMaster(String txzbl) {
        List<ExamMasterVo> list = examResultBrowseMapper.findExamMaster(txzbl);
        if (list.size() == 0) {
            list.add(new ExamMasterVo());
        }
        return list;
    }

    @Override
    public List<ExamReport1Vo> findExamReport1(String examNo) {
        List<ExamReport1Vo> list = examResultBrowseMapper.findExamReport1(examNo);
        if (list.size() == 0) {
            list.add(new ExamReport1Vo());
        }
        return list;
    }
}
