package com.healt.cloud.checkup.queryReport.controller;

import com.healt.cloud.checkup.queryReport.service.PersonResultSearchService;
import com.healt.cloud.checkup.queryReport.vo.PersonInfoVo;
import com.healt.cloud.checkup.queryReport.vo.PersonItemsVo;
import com.healt.cloud.checkup.queryReport.vo.PersonItemsCostVo;
import com.healt.cloud.checkup.queryReport.vo.ResultDictVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-27 9:15
 */
@RestController
@AllArgsConstructor
@Api(tags = "个人体检信息查询接口API")
@RequestMapping("/personResultSearch")
public class PersonResultSearchController {

    private PersonResultSearchService personResultSearchService;

    /**
     * 体检号触发体检次数
     * @param hospitalId,personId
     * @return list
     */
    @ApiOperation(value = "体检号触发体检次数，原tEPersonID_EditValueChanged的方法")
    @GetMapping("/findPersonVisitCount/{hospitalId}/{personId}")
    public List findPersonVisitCount(@PathVariable String hospitalId, @PathVariable String personId){
        return personResultSearchService.findPersonVisitCount(hospitalId,personId);
    }

    /**
     * 获取人员信息
     * @param hospitalId,personId,personVisitId
     * @return list
     */
    @ApiOperation(value = "获取人员信息，原GetPersonInfo的第一个select方法")
    @GetMapping("/findPersonInfo/{hospitalId}/{personId}/{personVisitId}")
    public List<PersonInfoVo> findPersonInfo(@PathVariable String hospitalId, @PathVariable String personId,
                                             @PathVariable String personVisitId){
        return personResultSearchService.findPersonInfo(hospitalId,personId,personVisitId);
    }

    /**
     * 获取体检项目结果记录(检验)
     * @param hospitalId,personId,personVisitId
     * @return list
     */
    @ApiOperation(value = "获取体检项目结果记录(检验)，原GetPersonInfo的第二个select方法")
    @GetMapping("/findLabHcResultDict/{hospitalId}/{personId}/{personVisitId}")
    public List<ResultDictVo> findLabHcResultDict(@PathVariable String hospitalId, @PathVariable String personId,
                                               @PathVariable String personVisitId){
        return personResultSearchService.findLabHcResultDict(hospitalId,personId,personVisitId);
    }

    /**
     * 获取体检项目结果记录(报告)
     * @param hospitalId,personId,personVisitId
     * @return list
     */
    @ApiOperation(value = "获取体检项目结果记录(报告)，原GetPersonInfo的第三个select方法")
    @GetMapping("/findReportHcResultDict/{hospitalId}/{personId}/{personVisitId}")
    public List<ResultDictVo> findReportHcResultDict(@PathVariable String hospitalId, @PathVariable String personId,
                                                  @PathVariable String personVisitId){
        return personResultSearchService.findReportHcResultDict(hospitalId,personId,personVisitId);
    }

    /**
     * 取项目
     * @param hospitalId,personId,personVisitId
     * @return list
     */
    @ApiOperation(value = "取项目，原GetPersonItems的第一个select方法")
    @GetMapping("/findPersonItems/{hospitalId}/{personId}/{personVisitId}")
    public List<PersonItemsVo> findPersonItems(@PathVariable String hospitalId, @PathVariable String personId,
                                                @PathVariable String personVisitId){
        return personResultSearchService.findPersonItems(hospitalId,personId,personVisitId);
    }

    /**
     * 取费用
     * @param hospitalId,personId,personVisitId
     * @return list
     */
    @ApiOperation(value = "取费用，原GetPersonItems的第二个select方法")
    @GetMapping("/findPersonItemsCost/{hospitalId}/{personId}/{personVisitId}")
    public List<PersonItemsCostVo> findPersonItemsCost(@PathVariable String hospitalId, @PathVariable String personId,
                                                       @PathVariable String personVisitId){
        return personResultSearchService.findPersonItemsCost(hospitalId,personId,personVisitId);
    }
}
