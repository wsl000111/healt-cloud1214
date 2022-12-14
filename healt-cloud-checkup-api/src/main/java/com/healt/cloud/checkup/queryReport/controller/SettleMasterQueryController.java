package com.healt.cloud.checkup.queryReport.controller;

import com.healt.cloud.checkup.queryReport.service.SettleMasterQueryService;
import com.healt.cloud.checkup.queryReport.vo.SettleMasterQueryDictVo;
import com.healt.cloud.checkup.queryReport.vo.SettleMasterQueryNewVo;
import com.healt.cloud.checkup.queryReport.vo.SettleMasterQueryVo;
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
 * @create 2022-05-31 9:27
 */
@RestController
@AllArgsConstructor
@Api(tags = "体检结算主记录接口API")
@RequestMapping("/settleMasterQuery")
public class SettleMasterQueryController {

    private SettleMasterQueryService settleMasterQueryService;

    /**
     *
     * @param settleMasterQueryDictVo
     * @return list
     */
    @ApiOperation(value = "原sBperson_Click的方法")
    @PostMapping("/findSettleMasterQuery")
    public List<SettleMasterQueryVo> findSettleMasterQuery(@RequestBody SettleMasterQueryDictVo settleMasterQueryDictVo){
        return settleMasterQueryService.findSettleMasterQuery(settleMasterQueryDictVo);
    }

    /**
     *
     * @param settleMasterQueryDictVo
     * @return list
     */
    @ApiOperation(value = "原sBperson_Click的新方法")
    @PostMapping("/findSettleMasterQueryNew")
    public List<SettleMasterQueryNewVo> findSettleMasterQueryNew(@RequestBody SettleMasterQueryDictVo settleMasterQueryDictVo){
        return settleMasterQueryService.findSettleMasterQueryNew(settleMasterQueryDictVo);
    }

}
