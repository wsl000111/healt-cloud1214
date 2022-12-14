package com.healt.cloud.checkup.triage.controller;

import com.healt.cloud.checkup.entity.HcCounselRequestInfo;
import com.healt.cloud.checkup.triage.service.CounselRequestInfoService;
import com.healt.cloud.checkup.triage.vo.CounselRequestInfoDictVo;
import com.healt.cloud.checkup.triage.vo.HcCounselRequestInfoListVo;
import com.healt.cloud.checkup.triage.vo.SaveCallPatientVo;
import com.healt.cloud.checkup.triage.vo.UpdateCallPatientVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-19 9:41
 */
@RestController
@AllArgsConstructor
@Api(tags = "体检分诊语音呼叫信息接口API")
@RequestMapping("/counselRequestInfo")
public class CounselRequestInfoController {

    private CounselRequestInfoService counselRequestInfoService;

    /**
     * 获取体检分诊语音呼叫信息
     * @param counselRequestInfoDictVo
     * @return list
     */
    @ApiOperation(value = "获取体检分诊语音呼叫信息")
    @PostMapping("/findCounselRequestInfo")
    public List<HcCounselRequestInfo> findCounselRequestInfo(@RequestBody CounselRequestInfoDictVo counselRequestInfoDictVo){
        return counselRequestInfoService.findCounselRequestInfo(counselRequestInfoDictVo);
    }

    /**
     * 删除体检分诊语音呼叫信息
     * @param hcCounselRequestInfoList
     * @return null
     */
    @ApiOperation(value = "删除体检分诊语音呼叫信息")
    @PostMapping("/deleteCounselRequestInfo")
    public void deleteCounselRequestInfo(@RequestBody HcCounselRequestInfoListVo hcCounselRequestInfoList){
        counselRequestInfoService.deleteCounselRequestInfo(hcCounselRequestInfoList);
    }

    /**
     * 呼叫保存
     * @param saveCallPatient
     * @return null
     */
    @ApiOperation(value = "呼叫保存")
    @PostMapping("/saveCallPatient")
    public void saveCallPatient(@RequestBody SaveCallPatientVo saveCallPatient){
        counselRequestInfoService.saveCallPatient(saveCallPatient);
    }

    /**
     * 完成导检/暂脱离导检
     * @param updateCallPatient
     * @return null
     */
    @ApiOperation(value = "完成导检/暂脱离导检")
    @PostMapping("/updateCallPatient")
    public void updateCallPatient(@RequestBody UpdateCallPatientVo updateCallPatient){
        counselRequestInfoService.updateCallPatient(updateCallPatient);
    }
}
