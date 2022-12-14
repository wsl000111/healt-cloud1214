package com.healt.cloud.checkup.controller.commonBase;

import com.healt.cloud.checkup.service.commonBase.FunctionService;
import com.healt.cloud.checkup.vo.commonBase.function.SystemParamVo;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuYue
 * @date 2022-03-29 15:21
 * @description: TODO
 */
@AllArgsConstructor
@RestController
@Api(tags = "CommonBase接口API")
@RequestMapping("/baseFunction")
public class FunctionConrtroller {

    private FunctionService functionService;

    @PostMapping("/findConfigPara")
    public String findConfigPara(@RequestBody SystemParamVo systemParamVo){
        return functionService.findConfigPara(systemParamVo);
    }
}
