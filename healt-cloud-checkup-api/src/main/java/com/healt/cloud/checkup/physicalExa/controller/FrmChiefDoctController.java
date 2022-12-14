package com.healt.cloud.checkup.physicalExa.controller;

import com.healt.cloud.checkup.entity.HcDeptResultDict;
import com.healt.cloud.checkup.entity.HcDeptResultItems;
import com.healt.cloud.checkup.entity.HcDiagnosisRecord;
import com.healt.cloud.checkup.physicalExa.service.FrmChiefDoctService;
import com.healt.cloud.checkup.physicalExa.vo.frmChiefDoct.*;
import com.healt.cloud.common.pages.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author GuYue
 * @date 2022-05-26 0:06
 * @description: TODO
 */
@RestController
@AllArgsConstructor
@Api(tags = "主检审核接口API")
@RequestMapping("/chiefDoct")
public class FrmChiefDoctController {

    private FrmChiefDoctService frmChiefDoctService;

    @ApiOperation(value = "获取初审医生姓名 FIRST_DOCOTER")
    @GetMapping("/firstDocoter/{hospitalCode}/{personId}/{visitId}")
    public String firstDocoter(@PathVariable("hospitalCode") String hospitalCode,
                               @PathVariable("personId") String personId,
                               @PathVariable("visitId") String visitId){
        return frmChiefDoctService.firstDocoter(hospitalCode, personId, visitId);
    }

//    public List<> findUnitCode(){
//
//    }

    @ApiOperation(" 分科医生结果")
    @GetMapping("/deptchiefaudit/{hospitalId}/{personId}/{visitId}")
    public List<HcDeptResultDict> deptchiefaudit(@PathVariable("hospitalId") String hospitalId,
                                                 @PathVariable("personId") String personId,
                                                 @PathVariable("visitId") String visitId){
        return frmChiefDoctService.deptchiefaudit(hospitalId, personId, visitId);
    }

    @ApiOperation(" 体检完成情况")
    @GetMapping("/chiemItemStatus/{hospitalId}/{personId}/{visitId}")
    public List<ChiemItemStatusVo> chiemItemStatus(@PathVariable("hospitalId") String hospitalId,
                                                   @PathVariable("personId") String personId,
                                                   @PathVariable("visitId") String visitId){
        return  frmChiefDoctService.chiemItemStatus(hospitalId, personId, visitId);
    }

    @ApiOperation(" 体检诊断记录  dtDiagnosis")
    @GetMapping("/dtDiagnosis/{hospitalId}/{personId}/{visitId}")
    public List<HcDiagnosisRecord> dtDiagnosis(@PathVariable("hospitalId") String hospitalId,
                                               @PathVariable("personId") String personId,
                                               @PathVariable("visitId") String visitId){
        return frmChiefDoctService.dtDiagnosis(hospitalId, personId, visitId);
    }

    @ApiOperation(" 体检诊断记录  dtDeptResultItem")
    @GetMapping("/dtDeptResultItem/{hospitalId}/{personId}/{visitId}")
    public List<HcDeptResultItems> dtDeptResultItem(@PathVariable("hospitalId") String hospitalId,
                                                    @PathVariable("personId") String personId,
                                                    @PathVariable("visitId") String visitId){
        return frmChiefDoctService.dtDeptResultItem(hospitalId, personId, visitId);
    }

    @ApiOperation(" 主检综合建议指导的分科建议  dtSuggest")
    @GetMapping("/dtSuggest/{hospitalId}/{personId}/{visitId}")
    public List<DtSuggestVo> dtSuggest(@PathVariable("hospitalId") String hospitalId,
                                       @PathVariable("personId") String personId,
                                       @PathVariable("visitId") String visitId){
        return frmChiefDoctService.dtSuggest(hospitalId, personId, visitId);
    }

    @ApiOperation(" 主检综合建议指导的分科建议主检附加结果  dtContent")
    @GetMapping("/dtContent/{hospitalId}/{personId}/{visitId}")
    public String dtContent(@PathVariable("hospitalId") String hospitalId,
                                       @PathVariable("personId") String personId,
                                       @PathVariable("visitId") String visitId){
        return frmChiefDoctService.dtContent(hospitalId, personId, visitId);
    }

//    @ApiOperation(value = "把自动完成的项目设置为完成")
//    @GetMapping("/autoFinishedSign/{HospitalCode}/{personId}/{visitId}")
//    public String autoFinishedSign(@PathVariable("hospitalCode") String hospitalCode,
//                                   @PathVariable("personId") String personId,
//                                   @PathVariable("visitId") String visitId){
//        return frmChiefDoctService.autoFinishedSign(hospitalCode, personId, visitId);
//    }

    @ApiOperation(value = "尚有未完成项目的提示")
    @GetMapping("/getItemPackName/{hospitalCode}/{personId}/{visitId}")
    public List<Map<String, String>> getItemPackName(@PathVariable("hospitalCode") String hospitalCode,
                                                     @PathVariable("personId") String personId,
                                                     @PathVariable("visitId") String visitId){
        return frmChiefDoctService.getItemPackName(hospitalCode, personId, visitId);
    }

    @ApiOperation(value = "初步审核")
    @PostMapping("/saveChiefDoctFirst")
    public String saveChiefDoctFirst(@RequestBody SaveChiefDoctFirstVo saveChiefDoctFirstVo){
        return frmChiefDoctService.saveChiefDoctFirst(saveChiefDoctFirstVo);
    }

    @ApiOperation(value = "最终审核")
    @PostMapping("/saveChiefDoctFinal")
    public String saveChiefDoctFinal(@RequestBody SaveChiefDoctFinalVo saveChiefDoctFinalVo){
        return frmChiefDoctService.saveChiefDoctFinal(saveChiefDoctFinalVo);
    }

    @ApiOperation(value = "页面加载")
    @PostMapping("/searchChiefDoctLoad")
    public PageResult<ChiefPersonVisitInfoVo> searchChiefDoct(@RequestBody SearchChiefDoctVo searchChiefDoctVo){
        return frmChiefDoctService.searchChiefDoct(searchChiefDoctVo);
    }

    @ApiOperation(value = "查询单位某次体检人员，unitVisitId参数不传值时，查询最近一次体检")
    @PostMapping("/getUnitPerson")
    public PageResult<UnitPersonInfoVo> getUnitPersonInfo(@RequestBody SearchUnitPersonInfoVo searchUnitPersonInfoVo){
        return frmChiefDoctService.findUnitPersonInfo(searchUnitPersonInfoVo);
    }

    @ApiOperation(value = "历次个人信息")
    @GetMapping("/getPersonHistory/{hospitalId}/{perosnId}")
    public List<PersonHistoryInfoVo> getPersonHistory(@PathVariable("hospitalId") String hospitalId,
                                                      @PathVariable("perosnId") String perosnId){
        return frmChiefDoctService.getPersonHistory(hospitalId, perosnId);
    }

    @ApiOperation("findGuideClass")
    @GetMapping("/findGuideClass/{knowledgeType}/{hospitalId}")
    public List<Map<String, String>> findGuideClass(@PathVariable("knowledgeType") String knowledgeType,
                                                    @PathVariable("hospitalId") String hospitalId){
        return frmChiefDoctService.findGuideClass(knowledgeType, hospitalId);
    }

    @ApiOperation("findGuideInfo")
    @GetMapping("/findGuideInfo/{knowledgeType}/{hospitalId}")
    public List<GuideInfoVo> findGuideInfo(@PathVariable("knowledgeType") String knowledgeType,
                                           @PathVariable("hospitalId") String hospitalId){
        return frmChiefDoctService.findGuideInfo(knowledgeType, hospitalId);
    }

}
