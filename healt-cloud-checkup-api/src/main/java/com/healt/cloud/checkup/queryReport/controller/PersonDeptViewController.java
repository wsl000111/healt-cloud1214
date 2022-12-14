package com.healt.cloud.checkup.queryReport.controller;

import com.healt.cloud.checkup.queryReport.service.PersonDeptViewService;
import com.healt.cloud.checkup.queryReport.vo.DiagnosisRecordVo;
import com.healt.cloud.checkup.queryReport.vo.PersonDeptInfoDictVo;
import com.healt.cloud.common.pages.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-29 9:12
 */
@RestController
@AllArgsConstructor
@Api(tags = "个人体检结果浏览接口API")
@RequestMapping("/personDeptView")
public class PersonDeptViewController {

    private PersonDeptViewService personDeptViewService;

    /**
     * 获取体检人员信息并分页
     * @param personDeptInfoDictVo
     * @return list
     */
    @ApiOperation(value = "获取体检人员信息并分页，原sBperson_Click方法")
    @PostMapping("/findPersonDeptInfo")
    public PageResult findPersonDeptInfo(@RequestBody PersonDeptInfoDictVo personDeptInfoDictVo){
        return personDeptViewService.findPersonDeptInfo(personDeptInfoDictVo);
    }

    /**
     * 获取体检人员主检诊断
     * @param hospitalId,personId,personVisitId
     * @return list
     */
    @ApiOperation(value = "获取体检人员主检诊断，原gridView1_RowClick的第一个select方法")
    @GetMapping("/findDiagnosisRecord/{hospitalId}/{personId}/{personVisitId}")
    public List<DiagnosisRecordVo> findDiagnosisRecord(@PathVariable String hospitalId, @PathVariable String personId,
                                                       @PathVariable String personVisitId){
        return personDeptViewService.findDiagnosisRecord(hospitalId,personId,personVisitId);
    }

}
