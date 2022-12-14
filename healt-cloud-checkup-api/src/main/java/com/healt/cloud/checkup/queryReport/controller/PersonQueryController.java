package com.healt.cloud.checkup.queryReport.controller;

import com.healt.cloud.checkup.queryReport.service.PersonQueryService;
import com.healt.cloud.checkup.queryReport.vo.PersonQueryDictVo;
import com.healt.cloud.common.pages.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linklee
 * @create 2022-05-26 10:07
 */
@RestController
@AllArgsConstructor
@Api(tags = "体检人员查询接口API")
@RequestMapping("/personQuery")
public class PersonQueryController {

    private PersonQueryService personQueryService;

    /**
     * 获取体检人员信息并分页
     * @param personQueryDictVo
     * @return list
     */
    @ApiOperation(value = "获取体检人员信息并分页，原bQuery_ItemClick方法")
    @PostMapping("/findPersonQuery")
    public PageResult findPersonQuery(@RequestBody PersonQueryDictVo personQueryDictVo){
        return personQueryService.findPersonQuery(personQueryDictVo);
    }

}
