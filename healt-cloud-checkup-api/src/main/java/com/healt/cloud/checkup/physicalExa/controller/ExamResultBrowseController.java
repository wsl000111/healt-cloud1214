package com.healt.cloud.checkup.physicalExa.controller;

import com.healt.cloud.checkup.physicalExa.service.ExamResultBrowseService;
import com.healt.cloud.checkup.physicalExa.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-25 11:23
 */
@RestController
@AllArgsConstructor
@Api(tags = "检查结果浏览接口API")
@RequestMapping("/examResultBrowse")
public class ExamResultBrowseController {

    private ExamResultBrowseService examResultBrowseService;

    /**
     *
     * @param hcDeptResultDictVo
     * @return list
     */
    @ApiOperation(value = "原GetHc_Dept_Result方法")
    @PostMapping("/findHcDeptResult")
    public List<HcDeptResultVo> findHcDeptResult(@RequestBody HcDeptResultDictVo hcDeptResultDictVo){
        return examResultBrowseService.findHcDeptResult(hcDeptResultDictVo);
    }

    /**
     * 获取检查单据数量
     * @param examNo
     * @return list
     */
    @ApiOperation(value = "获取检查单据数量，原LoadImport_Exam_Result的第一个select方法")
    @GetMapping("/findExamMasterCount/{examNo}")
    public List findExamMasterCount(@PathVariable("examNo") String examNo){
        return examResultBrowseService.findExamMasterCount(examNo);
    }

    /**
     * 获取检查结果数量
     * @param examNo
     * @return list
     */
    @ApiOperation(value = "获取检查结果数量，原LoadImport_Exam_Result的第二个select方法")
    @GetMapping("/findExamReportCount/{examNo}")
    public List findExamReportCount(@PathVariable("examNo") String examNo){
        return examResultBrowseService.findExamReportCount(examNo);
    }

    /**
     * 获取检查结果
     * @param examNo
     * @return list
     */
    @ApiOperation(value = "获取检查结果，原LoadImport_Exam_Result的第三个select方法")
    @GetMapping("/findExamReport/{examNo}")
    public List<ExamReportVo> findExamReport(@PathVariable("examNo") String examNo){
        return examResultBrowseService.findExamReport(examNo);
    }

    /**
     * 获取检查医生
     * @param examNo
     * @return list
     */
    @ApiOperation(value = "获取检查医生，原LoadImport_Exam_Result的第四个select方法")
    @GetMapping("/findExamMasterReporter/{examNo}")
    public List<ExamMasterReporterVo> findExamMasterReporter(@PathVariable("examNo") String examNo){
        return examResultBrowseService.findExamMasterReporter(examNo);
    }

    /**
     * 导入一个体检检查项目结果
     * @param saveExamResultVo
     * @return null
     */
//    @ApiOperation(value = "导入一个体检检查项目结果，原LoadImport_Exam_Result方法")
//    @GetMapping("/saveExamResult")
//    public void saveExamResult(@RequestBody SaveExamResultListVo saveExamResultVo){
//        return examResultBrowseService.saveExamResult(saveExamResultVo);
//    }

    /**
     * 获得检查主记录
     * @param txzbl
     * @return list
     */
    @ApiOperation(value = "获得检查主记录，原gridView1_SelectionChanged方法")
    @GetMapping("/findExamMaster/{txzbl}")
    public List<ExamMasterVo> findExamMaster(@PathVariable("txzbl") String txzbl){
        return examResultBrowseService.findExamMaster(txzbl);
    }

    /**
     * 获取检查结果
     * @param examNo
     * @return list
     */
    @ApiOperation(value = "获取检查结果，原gridView2_RowClick方法")
    @GetMapping("/findExamReport1/{examNo}")
    public List<ExamReport1Vo> findExamReport1(@PathVariable("examNo") String examNo){
        return examResultBrowseService.findExamReport1(examNo);
    }
}
