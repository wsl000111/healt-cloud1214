package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.physicalExa.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-25 11:28
 */
@Mapper
public interface ExamResultBrowseMapper {

    List<HcDeptResultVo> findHcDeptResult(HcDeptResultDictVo hcDeptResultDictVo);

    String findExamMasterCount(@Param("examNo") String examNo);

    String findExamReportCount(@Param("examNo") String examNo);

    List<ExamReportVo> findExamReport(@Param("examNo") String examNo);

    List<ExamMasterReporterVo> findExamMasterReporter(@Param("examNo") String examNo);

    List<ExamMasterVo> findExamMaster(@Param("txzbl") String txzbl);

    List<ExamReport1Vo> findExamReport1(@Param("examNo") String examNo);
}
