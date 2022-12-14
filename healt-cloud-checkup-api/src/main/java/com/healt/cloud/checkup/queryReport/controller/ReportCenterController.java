package com.healt.cloud.checkup.queryReport.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.healt.cloud.checkup.entity.HcExamMaster;
import com.healt.cloud.checkup.entity.HcExamReport;
import com.healt.cloud.checkup.entity.HcPersonInfo;
import com.healt.cloud.checkup.queryReport.vo.PersonPdfReportVo;
import com.healt.cloud.checkup.service.HcExamMasterService;
import com.healt.cloud.checkup.service.HcExamReportService;
import com.healt.cloud.checkup.service.HcPersonInfoService;
import com.healt.cloud.checkup.service.ws.WebServiceClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-08-20 22:28
 * @description: TODO
 */
@RestController
@AllArgsConstructor
@Api(tags = "报告中心接口API")
@RequestMapping("/reportCenter")
public class ReportCenterController {

    private HcPersonInfoService hcPersonInfoService;

    private HcExamMasterService hcExamMasterService;

    private HcExamReportService hcExamReportService;

    private WebServiceClient client;

    @ApiOperation(value = "获取体检人检查pdf报告路径")
    @GetMapping("/pdfReportList/{personId}/{personVisitId}")
    public List<PersonPdfReportVo> pdfReportList(@PathVariable String personId, @PathVariable String personVisitId){
        LambdaQueryWrapper<HcPersonInfo> hcPersonInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        hcPersonInfoLambdaQueryWrapper.eq(HcPersonInfo::getPersonId, personId);
        HcPersonInfo hcPersonInfo = hcPersonInfoService.getOne(hcPersonInfoLambdaQueryWrapper);

        LambdaQueryWrapper<HcExamMaster> hcExamMasterLambdaQueryWrapper = new LambdaQueryWrapper<>();
        hcExamMasterLambdaQueryWrapper.eq(HcExamMaster::getPatientId, personId);
        hcExamMasterLambdaQueryWrapper.eq(HcExamMaster::getVisitId, personVisitId);
        hcExamMasterLambdaQueryWrapper.eq(HcExamMaster::getResultStatus, "4");
        List<HcExamMaster> hcExamMasterList = hcExamMasterService.list(hcExamMasterLambdaQueryWrapper);

        List<PersonPdfReportVo> list = new ArrayList<>();

        for (HcExamMaster hcExamMaster : hcExamMasterList){
            PersonPdfReportVo personPdfReportVo = new PersonPdfReportVo();
            String reportUrl = client.pdfReporQuery(hcPersonInfo.getPatientId(), hcExamMaster.getExamNo());
            if(StringUtils.isEmpty(reportUrl)){
                LambdaQueryWrapper<HcExamReport> lambdaQueryWrapper = new LambdaQueryWrapper();
                lambdaQueryWrapper.eq(HcExamReport::getExamNo, hcExamMaster.getExamNo());
                HcExamReport hcExamReport = hcExamReportService.getOne(lambdaQueryWrapper);
                if(hcExamReport!=null){
                    reportUrl = hcExamReport.getIeId();
                }
            }
            personPdfReportVo.setPersonId(personId);
            personPdfReportVo.setPersonVisitId(personVisitId);
            personPdfReportVo.setReportUrl(reportUrl==null? "":reportUrl);
            personPdfReportVo.setExamNo(hcExamMaster.getExamNo());
            list.add(personPdfReportVo);
        }
        if(list.size()==0){
            list.add(new PersonPdfReportVo());
        }
        return list;
    }

    @ApiOperation(value = "获取体检人心电pdf报告路径")
    @GetMapping("/xdPdfReport/{personId}/{personVisitId}")
    public List<PersonPdfReportVo> xdPdfReport(@PathVariable String personId, @PathVariable String personVisitId){
        LambdaQueryWrapper<HcPersonInfo> hcPersonInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        hcPersonInfoLambdaQueryWrapper.eq(HcPersonInfo::getPersonId, personId);
        HcPersonInfo hcPersonInfo = hcPersonInfoService.getOne(hcPersonInfoLambdaQueryWrapper);

        LambdaQueryWrapper<HcExamMaster> hcExamMasterLambdaQueryWrapper = new LambdaQueryWrapper<>();
        hcExamMasterLambdaQueryWrapper.eq(HcExamMaster::getPatientId, personId);
        hcExamMasterLambdaQueryWrapper.eq(HcExamMaster::getVisitId, personVisitId);
        hcExamMasterLambdaQueryWrapper.eq(HcExamMaster::getResultStatus, "4");
        hcExamMasterLambdaQueryWrapper.eq(HcExamMaster::getExamClass, "心电图");
        List<HcExamMaster> hcExamMasterList = hcExamMasterService.list(hcExamMasterLambdaQueryWrapper);

        List<PersonPdfReportVo> list = new ArrayList<>();

        for (HcExamMaster hcExamMaster : hcExamMasterList){
            PersonPdfReportVo personPdfReportVo = new PersonPdfReportVo();
            String reportUrl = client.pdfReporQuery(hcPersonInfo.getPatientId(), hcExamMaster.getExamNo());
            personPdfReportVo.setPersonId(personId);
            personPdfReportVo.setReportUrl(reportUrl==null? "":reportUrl);
            personPdfReportVo.setExamNo(hcExamMaster.getExamNo());
            list.add(personPdfReportVo);
        }

        if(list.size()==0){
            list.add(new PersonPdfReportVo());
        }
        return list;
    }
}
