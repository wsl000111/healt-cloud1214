package com.healt.cloud.checkup.personItemAssemRollBack.controller;

import com.healt.cloud.checkup.personItemAssemRollBack.service.PersonItemAssemRollBackService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuYue
 * @date 2022-07-13 10:56
 * @description: TODO
 */
@Api(tags = "体检项目结果撤销接口API")
@RestController
@AllArgsConstructor
@RequestMapping("/personItem")
public class PersonItemAssemRollBackController {

    private PersonItemAssemRollBackService personItemAssemRollBackService;

    @GetMapping("/itemAssemRollback/{hospitalId}/{personId}/{personVisitId}/{deptId}")
    public void itemAssemRollback(@PathVariable String hospitalId,
                                  @PathVariable String personId,
                                  @PathVariable String personVisitId,
                                  @PathVariable String deptId){
        personItemAssemRollBackService.itemAssemRollback(hospitalId, personId, personVisitId, deptId);
    }

}
